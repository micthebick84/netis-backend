-- ============================================================
-- V2__topology_functions.sql
-- Topology DDL: PL/pgSQL functions for topology hierarchy
-- Corrected to match MariaDB cm_topo_leaf schema
-- (includes grp_name, sub_name, isleaf columns)
-- ============================================================

-- SP_MAKE_TOPO_LEAF: Rebuilds the CM_TOPO_LEAF hierarchy table
CREATE OR REPLACE FUNCTION sp_make_topo_leaf(p_user_id VARCHAR)
RETURNS VOID AS $$
BEGIN
    -- Delete existing leaf entries for the user
    DELETE FROM cm_topo_leaf WHERE user_id = p_user_id;

    -- Insert all group-subgroup relationships using recursive CTE
    INSERT INTO cm_topo_leaf (user_id, grp_no, grp_name, sub_no, sub_name, isleaf)
    WITH RECURSIVE grp_tree AS (
        -- Base: each group is its own leaf
        SELECT grp_no, grp_name, grp_no AS sub_no, grp_name AS sub_name
        FROM cm_topo_group
        WHERE user_id = p_user_id
        UNION ALL
        -- Recursive: children belong to parent groups
        SELECT gt.grp_no, gt.grp_name, cg.grp_no AS sub_no, cg.grp_name AS sub_name
        FROM grp_tree gt
        INNER JOIN cm_topo_group cg ON cg.grp_parent = gt.sub_no
        WHERE cg.user_id = p_user_id
          AND cg.grp_no != cg.grp_parent
    )
    SELECT p_user_id, grp_no, grp_name, sub_no, sub_name,
           CASE WHEN sub_no NOT IN (
               SELECT DISTINCT grp_parent FROM cm_topo_group
               WHERE user_id = p_user_id AND grp_no != grp_parent
           ) THEN 1 ELSE 0 END AS isleaf
    FROM grp_tree;
END;
$$ LANGUAGE plpgsql;

-- SP_MAKE_TOPO_LEAF_MOVE: Rebuilds leaf table after a group move operation
CREATE OR REPLACE FUNCTION sp_make_topo_leaf_move(p_user_id VARCHAR)
RETURNS VOID AS $$
BEGIN
    PERFORM sp_make_topo_leaf(p_user_id);
END;
$$ LANGUAGE plpgsql;
