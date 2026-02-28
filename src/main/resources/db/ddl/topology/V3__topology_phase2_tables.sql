-- Phase 2 topology tables

CREATE TABLE IF NOT EXISTS cm_topo_draw_tool (
    draw_no BIGSERIAL PRIMARY KEY,
    user_id VARCHAR(50) NOT NULL,
    grp_no BIGINT DEFAULT 0,
    dev_kind1 VARCHAR(50),
    dev_kind2 VARCHAR(50),
    pos_x NUMERIC DEFAULT 0,
    pos_y NUMERIC DEFAULT 0,
    width NUMERIC DEFAULT 0,
    height NUMERIC DEFAULT 0,
    fill_color VARCHAR(50),
    fill_opacity VARCHAR(20),
    stroke_color VARCHAR(50),
    stroke_opacity VARCHAR(20),
    stroke_width INTEGER DEFAULT 1,
    corner_radius INTEGER DEFAULT 0,
    font_size INTEGER DEFAULT 12,
    font_weight VARCHAR(20),
    text_anchor VARCHAR(20),
    text_content TEXT,
    text_area_content TEXT,
    rx NUMERIC DEFAULT 0,
    ry NUMERIC DEFAULT 0,
    sort_idx INTEGER DEFAULT 0,
    font_distance NUMERIC DEFAULT 20,
    rotation NUMERIC DEFAULT 0,
    line_style VARCHAR(50) DEFAULT '',
    draw_conf TEXT
);

CREATE TABLE IF NOT EXISTS cm_topo_spline (
    spline_no BIGSERIAL PRIMARY KEY,
    user_id VARCHAR(50) NOT NULL,
    grp_no BIGINT DEFAULT 0,
    spline_type VARCHAR(50),
    spline_string TEXT,
    spline_conf TEXT,
    spline_size VARCHAR(20),
    spline_style VARCHAR(50),
    spline_color VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS cm_topo_dump (
    dump_seq BIGINT NOT NULL PRIMARY KEY,
    ins_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id VARCHAR(50),
    xml_text BYTEA,
    memo TEXT
);

CREATE TABLE IF NOT EXISTS cm_topo_restore_hist (
    ins_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    dump_seq BIGINT,
    rest_user_id VARCHAR(50),
    rest_user_ip VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS cm_topo_link_multi (
    user_id VARCHAR(50) NOT NULL,
    item_no BIGINT NOT NULL,
    mng_no BIGINT,
    if_idx BIGINT,
    evt_level NUMERIC,
    line_width NUMERIC(20,0),
    link_no BIGINT,
    link_name VARCHAR(200),
    traffic NUMERIC(20,0),
    traffic_type VARCHAR(50),
    dash_key VARCHAR(50)
);
