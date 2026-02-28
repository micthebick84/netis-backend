-- Phase 2 topology tables

CREATE TABLE IF NOT EXISTS cm_topo_draw_tool (
    user_id VARCHAR(50) NOT NULL,
    draw_no BIGINT NOT NULL,
    grp_no BIGINT DEFAULT 0,
    draw_type VARCHAR(20),
    draw_shape VARCHAR(20),
    xpoint INTEGER DEFAULT 0,
    ypoint INTEGER DEFAULT 0,
    width INTEGER DEFAULT 0,
    height INTEGER DEFAULT 0,
    rotate INTEGER DEFAULT 0,
    fill_color VARCHAR(20),
    line_color VARCHAR(20),
    line_width INTEGER DEFAULT 1,
    opacity NUMERIC(5,2) DEFAULT 1.0,
    font_size INTEGER DEFAULT 12,
    font_color VARCHAR(20),
    text_content TEXT,
    z_index INTEGER DEFAULT 0,
    PRIMARY KEY (user_id, draw_no)
);

CREATE TABLE IF NOT EXISTS cm_topo_spline (
    user_id VARCHAR(50) NOT NULL,
    spline_no BIGINT NOT NULL,
    grp_no BIGINT DEFAULT 0,
    points TEXT,
    line_color VARCHAR(20),
    line_width INTEGER DEFAULT 1,
    fill_color VARCHAR(20),
    opacity NUMERIC(5,2) DEFAULT 1.0,
    closed VARCHAR(1) DEFAULT 'N',
    z_index INTEGER DEFAULT 0,
    PRIMARY KEY (user_id, spline_no)
);

CREATE TABLE IF NOT EXISTS cm_topo_dump (
    dump_no BIGSERIAL PRIMARY KEY,
    user_id VARCHAR(50),
    grp_no BIGINT DEFAULT 0,
    dump_name VARCHAR(200),
    dump_data BYTEA,
    dump_memo TEXT,
    reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    reg_user VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS cm_topo_restore_hist (
    restore_no BIGSERIAL PRIMARY KEY,
    dump_no BIGINT,
    user_id VARCHAR(50),
    restore_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    restore_user VARCHAR(50),
    restore_memo TEXT
);

CREATE TABLE IF NOT EXISTS cm_topo_link_multi (
    user_id VARCHAR(50) NOT NULL,
    link_no BIGINT NOT NULL,
    seq_no INTEGER NOT NULL DEFAULT 0,
    dev_ip VARCHAR(50),
    if_index VARCHAR(50),
    if_name VARCHAR(100),
    link_dir VARCHAR(10) DEFAULT 'IN',
    PRIMARY KEY (user_id, link_no, seq_no)
);
