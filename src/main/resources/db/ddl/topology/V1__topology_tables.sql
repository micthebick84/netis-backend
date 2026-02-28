-- ============================================================
-- V1__topology_tables.sql
-- Topology DDL: All tables for the topology module
-- Corrected to match MariaDB schema exactly
-- ============================================================

-- CM_TOPO_GROUP (토폴로지 그룹 정보)
-- MariaDB: No PRIMARY KEY, only index on (GRP_NO, USER_ID)
CREATE TABLE IF NOT EXISTS cm_topo_group (
    user_id VARCHAR(50) NOT NULL,
    grp_no BIGINT,
    grp_name VARCHAR(255) NOT NULL,
    grp_parent REAL NOT NULL,
    bg_file_nm VARCHAR(100),
    gis_zoom REAL,
    gis_lat NUMERIC(14,9),
    gis_lnt NUMERIC(12,7),
    view_type VARCHAR(10) DEFAULT 'TOPO',
    station_code VARCHAR(6)
);

CREATE INDEX IF NOT EXISTS cm_topo_group_idx1 ON cm_topo_group (grp_no, user_id);

-- CM_TOPO_ITEM (토폴로지 아이템 정보)
CREATE TABLE IF NOT EXISTS cm_topo_item (
    user_id VARCHAR(50) NOT NULL,
    grp_no BIGINT NOT NULL,
    item_no INTEGER NOT NULL,
    item_type VARCHAR(10),
    item_sub_type VARCHAR(10),
    mng_no INTEGER NOT NULL,
    xpoint INTEGER,
    ypoint INTEGER,
    item_size NUMERIC(5,2),
    sh_evt SMALLINT,
    item_sub_kind VARCHAR(30),
    item_file_name VARCHAR(100),
    item_alias VARCHAR(100),
    user_content TEXT,
    font_size SMALLINT,
    evt_level SMALLINT,
    dev_kind1 VARCHAR(20),
    dev_kind2 VARCHAR(50),
    usr_kind VARCHAR(100),
    gc_no INTEGER,
    uniq_id INTEGER,
    evt_type SMALLINT,
    temp1 VARCHAR(50),
    temp2 VARCHAR(50),
    temp3 VARCHAR(50),
    back_mng_no INTEGER DEFAULT -1,
    show_label SMALLINT DEFAULT 1,
    dev_perf TEXT,
    item_conf TEXT,
    PRIMARY KEY (user_id, item_no)
);

CREATE INDEX IF NOT EXISTS cm_topo_item_idx1 ON cm_topo_item (grp_no, user_id);
CREATE INDEX IF NOT EXISTS cm_topo_item_idx2 ON cm_topo_item (mng_no, user_id);
CREATE INDEX IF NOT EXISTS cm_topo_item_idx3 ON cm_topo_item (dev_kind1, mng_no, user_id);

-- CM_TOPO_LINK (토폴로지 링크 정보)
CREATE TABLE IF NOT EXISTS cm_topo_link (
    user_id VARCHAR(50) NOT NULL,
    grp_no BIGINT,
    mng_no1 BIGINT,
    if_idx1 BIGINT,
    url VARCHAR(200),
    line_size NUMERIC(3,2),
    line_type SMALLINT,
    sh_evt SMALLINT,
    item_no1 BIGINT,
    item_no2 BIGINT,
    evt_level1 SMALLINT,
    point1 REAL,
    point2 REAL,
    line_width1 BIGINT,
    link_idx1 BIGINT NOT NULL,
    link_no BIGINT NOT NULL,
    mng_no2 BIGINT,
    if_idx2 BIGINT,
    evt_level2 SMALLINT,
    line_width2 BIGINT,
    link_name1 VARCHAR(200),
    link_name2 VARCHAR(200),
    is_main SMALLINT NOT NULL,
    gc_no REAL,
    traffic1 BIGINT,
    traffic2 BIGINT,
    is_multi SMALLINT,
    link_idx2 BIGINT NOT NULL,
    traffic_type1 VARCHAR(1) NOT NULL,
    traffic_type2 VARCHAR(1) NOT NULL,
    line_point_ud1 SMALLINT,
    line_point_lr1 SMALLINT,
    line_point_ud2 SMALLINT,
    line_point_lr2 SMALLINT,
    point3 REAL,
    user_poll_line_color1 VARCHAR(10),
    user_poll_line_color2 VARCHAR(10),
    curve_x1 NUMERIC(6,2),
    curve_y1 NUMERIC(6,2),
    curve_x2 NUMERIC(6,2),
    curve_y2 NUMERIC(6,2),
    line_style VARCHAR(10),
    line_color VARCHAR(10),
    polling_color VARCHAR(10),
    traffic1_in BIGINT,
    traffic1_out BIGINT,
    traffic2_in BIGINT,
    traffic2_out BIGINT,
    line_traffic_effect VARCHAR(15),
    line_traffic_effect_speed SMALLINT DEFAULT 0,
    line_flow_effect VARCHAR(15),
    line_flow_effect_speed SMALLINT DEFAULT 0,
    line_flow_effect_count SMALLINT DEFAULT 0,
    line_flow_effect_color VARCHAR(15),
    line_label_conf TEXT,
    PRIMARY KEY (user_id, link_no)
);

CREATE INDEX IF NOT EXISTS cm_topo_link_idx1 ON cm_topo_link (grp_no);

-- CM_TOPO_ETC (토폴로지 기타 정보)
CREATE TABLE IF NOT EXISTS cm_topo_etc (
    user_id VARCHAR(50) NOT NULL,
    item_no BIGINT NOT NULL,
    dev_name VARCHAR(50),
    dev_ip VARCHAR(15),
    icmp_polling VARCHAR(1),
    url VARCHAR(100),
    PRIMARY KEY (user_id, item_no)
);

-- CM_TOPO_LEAF (그룹 계층 구조 - 스토어드 프로시저로 생성)
-- MariaDB: No PRIMARY KEY, only indexes
CREATE TABLE IF NOT EXISTS cm_topo_leaf (
    user_id VARCHAR(50) NOT NULL,
    grp_no BIGINT,
    grp_name VARCHAR(255),
    sub_no REAL NOT NULL,
    sub_name VARCHAR(255),
    isleaf SMALLINT
);

CREATE INDEX IF NOT EXISTS cm_topo_leaf_idx1 ON cm_topo_leaf (user_id, grp_no);
CREATE INDEX IF NOT EXISTS cm_topo_leaf_idx2 ON cm_topo_leaf (user_id, sub_no);

-- CM_TOPO_AUTH_GROUP (토폴로지 권한 그룹)
CREATE TABLE IF NOT EXISTS cm_topo_auth_group (
    auth_grp_no SERIAL PRIMARY KEY,
    grp_name VARCHAR(255) NOT NULL,
    user_id VARCHAR(20) NOT NULL,
    edit_yn VARCHAR(1) DEFAULT 'N'
);

-- CM_TOPO_AUTH_GROUP_SUBGRP (토폴로지 권한 그룹 상세)
CREATE TABLE IF NOT EXISTS cm_topo_auth_group_subgrp (
    seq_no INTEGER NOT NULL PRIMARY KEY,
    auth_grp_no INTEGER NOT NULL,
    topo_grp_no INTEGER NOT NULL
);

-- CM_TOPO_USER (토폴로지 사용자 설정)
CREATE TABLE IF NOT EXISTS cm_topo_user (
    user_id VARCHAR(50) NOT NULL PRIMARY KEY,
    legend_traffic SMALLINT,
    legend_err SMALLINT,
    legend_detail SMALLINT,
    traffic_x INTEGER,
    traffic_y INTEGER,
    err_x INTEGER,
    err_y INTEGER,
    detail_x INTEGER,
    detail_y INTEGER,
    show_ip SMALLINT,
    show_balloon SMALLINT,
    tr_lmt1 BIGINT,
    tr_lmt2 BIGINT,
    tr_lmt3 BIGINT,
    tr_lmt4 BIGINT,
    tr_rgb1 BIGINT,
    tr_rgb2 BIGINT,
    tr_rgb3 BIGINT,
    tr_rgb4 BIGINT,
    tr_rgb5 BIGINT,
    er_rgb1 BIGINT,
    er_rgb2 BIGINT,
    er_rgb3 BIGINT,
    er_rgb4 BIGINT,
    er_rgb5 BIGINT,
    vw_router SMALLINT,
    vw_switch SMALLINT,
    vw_server SMALLINT,
    vw_sub SMALLINT,
    vw_link SMALLINT,
    vw_etc SMALLINT,
    lk_lmt1 BIGINT,
    lk_lmt2 BIGINT,
    lk_lmt3 BIGINT,
    lk_rgb1 BIGINT,
    lk_rgb2 BIGINT,
    lk_rgb3 BIGINT,
    lk_rgb4 BIGINT,
    show_evt_level SMALLINT,
    refresh_time BIGINT,
    is_blank_evt SMALLINT,
    show_label SMALLINT,
    show_label_rack SMALLINT,
    line_color VARCHAR(10),
    polling_color VARCHAR(10),
    alarm_chk SMALLINT DEFAULT 0,
    alarm_lv1_chk SMALLINT DEFAULT 0,
    alarm_lv2_chk SMALLINT DEFAULT 0,
    alarm_lv3_chk SMALLINT DEFAULT 0,
    alarm_lv4_chk SMALLINT DEFAULT 0,
    alarm_lv5_chk SMALLINT DEFAULT 0,
    alarm_lv1_path VARCHAR(50) DEFAULT 'default.mp3',
    alarm_lv2_path VARCHAR(50) DEFAULT 'default.mp3',
    alarm_lv3_path VARCHAR(50) DEFAULT 'default.mp3',
    alarm_lv4_path VARCHAR(50) DEFAULT 'default.mp3',
    alarm_lv5_path VARCHAR(50) DEFAULT 'default.mp3',
    font_color VARCHAR(10),
    font_bg_color VARCHAR(10),
    json_conf TEXT,
    show_icmp_poll SMALLINT DEFAULT 0,
    show_ap_event SMALLINT DEFAULT 0,
    show_vm_event SMALLINT NOT NULL DEFAULT 0,
    digitclock_conf TEXT,
    slide_grp_conf TEXT,
    helpline_conf TEXT
);

-- COM_IMG (이미지 정보)
CREATE TABLE IF NOT EXISTS com_img (
    img_no BIGINT NOT NULL PRIMARY KEY,
    img_name VARCHAR(50) NOT NULL,
    img_uid VARCHAR(100) NOT NULL,
    img BYTEA NOT NULL,
    img_kind1 VARCHAR(20) NOT NULL,
    img_kind2 VARCHAR(20),
    img_kind3 VARCHAR(20),
    s_conf SMALLINT NOT NULL,
    sort_idx SMALLINT,
    is_display SMALLINT DEFAULT 1
);

-- S_CM_RACK (랙 정보)
-- MariaDB: UNIQUE KEY on RACK_NO (no PK)
CREATE TABLE IF NOT EXISTS s_cm_rack (
    rack_no REAL NOT NULL UNIQUE,
    grp_no REAL NOT NULL,
    rack_name VARCHAR(100),
    rack_u REAL NOT NULL,
    rack_ip VARCHAR(50) NOT NULL,
    rack_port INTEGER NOT NULL,
    rack_temp1 SMALLINT,
    rack_humi1 SMALLINT,
    rack_volt1 SMALLINT,
    rack_amp1 SMALLINT,
    rack_state SMALLINT,
    rack_temp2 SMALLINT,
    rack_humi2 SMALLINT,
    rack_volt2 SMALLINT,
    rack_amp2 SMALLINT,
    rack_di0 SMALLINT,
    rack_di1 SMALLINT,
    rack_port2 INTEGER NOT NULL DEFAULT 0,
    x_point REAL,
    y_point REAL,
    rack_type VARCHAR(20),
    width VARCHAR(10),
    height VARCHAR(10),
    rack_desc VARCHAR(200),
    model VARCHAR(20),
    vendor VARCHAR(20),
    yyyymmdd VARCHAR(8),
    evt_level SMALLINT,
    rack_info_upd VARCHAR(14),
    profile_no SMALLINT
);

-- S_CM_RACK_CONF (랙 마운트 설정)
-- MariaDB: UNIQUE KEY on SEQ_NO, FK to s_cm_rack(RACK_NO)
CREATE TABLE IF NOT EXISTS s_cm_rack_conf (
    seq_no REAL NOT NULL UNIQUE,
    rack_no REAL,
    slot_no REAL NOT NULL,
    slot_u REAL NOT NULL,
    mng_no REAL,
    etc_no REAL,
    dev_kind1 VARCHAR(20),
    img_name VARCHAR(100),
    slot_kind VARCHAR(10) DEFAULT 'SVR',
    rack_section VARCHAR(1)
);

CREATE INDEX IF NOT EXISTS s_cm_rack_conf_rack_no_idx ON s_cm_rack_conf (rack_no);
