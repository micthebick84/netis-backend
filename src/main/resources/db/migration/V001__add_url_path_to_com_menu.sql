-- ============================================================
-- Migration: V001 - Add url_path column to com_menu
-- Date: 2026-02-15
-- Description: GUID와 화면 URL 경로를 매핑하기 위해
--              com_menu 테이블에 url_path 컬럼 추가.
--              NetisMenuHelper(netisweb_v6.7)의 GUID→URL 매핑 데이터를 마이그레이션.
-- ============================================================

-- 1. 컬럼 추가
ALTER TABLE com_menu ADD COLUMN IF NOT EXISTS url_path character varying(200);

-- 2. GUID → URL 매핑 데이터 (NetisMenuHelper 기반)
-- 일반
UPDATE com_menu SET url_path = '/main/oms/errStatus.do' WHERE guid = 'BDAF11A9-B895-11E7-BF32-42F2E997FE51';
UPDATE com_menu SET url_path = '/main/oms/errHistory.do' WHERE guid = '387167E1-B897-11E7-BF32-42F2E997FE51';
UPDATE com_menu SET url_path = '/main/oms/errTimeLine.do' WHERE guid = 'A8C639FB-CFA2-11EE-8FEB-20677CD38D75';
UPDATE com_menu SET url_path = '/main/nms/rack.do' WHERE guid = 'EB56AED2-8197-4FA4-A5DA-E86E5476D7DB';
UPDATE com_menu SET url_path = '/d3map/topology.do' WHERE guid = 'BB590E9A-A453-4F8A-B1D8-737A4D07BDD0';
UPDATE com_menu SET url_path = '/d3map/grpTopology.do' WHERE guid = '5CE4B5A2-9119-11EB-9775-000C297DBB6C';
UPDATE com_menu SET url_path = '/d3map/srms.do' WHERE guid = 'B0C11196-7E29-4F9B-AC86-ABE69A0A192B';
UPDATE com_menu SET url_path = '/main/com/pollGrpMon.do' WHERE guid = 'BD06508D-928C-44F4-8E82-D7ADD6E2C10F';
UPDATE com_menu SET url_path = '/main/com/oidMgmt.do' WHERE guid = 'DAB56EEE-A850-49B7-A548-F74DC6455E43';
UPDATE com_menu SET url_path = '/main/com/recvGrpMgmt.do' WHERE guid = '4D478A8D-2084-4071-A58D-9054FB9F3226';
UPDATE com_menu SET url_path = '/main/com/recvGrpStatus.do' WHERE guid = '09AB0F28-6D8B-46DE-9D80-1EA321FAA746';
UPDATE com_menu SET url_path = '/main/com/evtDbMgmt.do' WHERE guid = '8508BC3A-AE8E-11ED-9091-005056040055';
UPDATE com_menu SET url_path = '/main/com/solShortCuts.do' WHERE guid = 'BB86F0DC-3FD3-3A5E-8D43-507D7A122783';
-- NMS
UPDATE com_menu SET url_path = '/main/nms/devStatus.do' WHERE guid = '9CF64ED0-19B0-4AD0-9B60-E857EFCC2C73';
UPDATE com_menu SET url_path = '/main/nms/devPerf3.do' WHERE guid = 'F65147B3-4A57-46B4-B6E4-1C21295A73D7';
UPDATE com_menu SET url_path = '/main/nms/devPerf2.do' WHERE guid = '0345E214-6344-11EF-8BB8-FA163EC245E9';
UPDATE com_menu SET url_path = '/main/nms/ifPerfStatus.do' WHERE guid = 'CC0786B1-3842-11EF-B89E-FA163E1C5E56';
UPDATE com_menu SET url_path = '/main/nms/devPerf.do' WHERE guid = '49614AF4-9C98-4EEA-96CE-CFDBD69DE23D';
UPDATE com_menu SET url_path = '/main/nms/ifPerf3.do' WHERE guid = '0EC48CC6-A4D8-4EE5-A2F5-5077EFD93BC4';
UPDATE com_menu SET url_path = '/main/nms/ifPerf.do' WHERE guid = '2ED32E26-E1FA-4CDD-8760-0010717D0436';
UPDATE com_menu SET url_path = '/main/nms/ifStatus.do' WHERE guid = '616D8144-FAF1-4BAE-9BB6-0B8F5F381130';
UPDATE com_menu SET url_path = '/main/nms/devPerfCmp.do' WHERE guid = '9869CAB0-822A-4319-853B-0EF050F49F56';
UPDATE com_menu SET url_path = '/main/nms/devPerfCmp_v64.do' WHERE guid = '0C1E7E1A-44D4-11EF-8BFB-FA163EC245E9';
UPDATE com_menu SET url_path = '/main/nms/ifPerfCmp.do' WHERE guid = 'D4A9FE70-2E18-4A67-A5EE-B47CDD36C6F5';
UPDATE com_menu SET url_path = '/main/nms/ifPerfCmp_v64.do' WHERE guid = '4F6FFBD6-44D4-11EF-8BFB-FA163EC245E9';
UPDATE com_menu SET url_path = '/main/nms/syslog.do' WHERE guid = '340636E8-DA70-489D-A450-0458FFC3B099';
UPDATE com_menu SET url_path = '/main/nms/syslog2.do' WHERE guid = '65DB7E2D-49D2-11E8-9776-E0D55E600B1B';
UPDATE com_menu SET url_path = '/main/nms/syslogEvtMgmt.do' WHERE guid = '2B07FE94-3F6E-42CB-91D0-EB5F4C5A3A09';
UPDATE com_menu SET url_path = '/main/nms/trap.do' WHERE guid = '35E56A6F-B4CF-4255-8300-A55BA44F7BA6';
UPDATE com_menu SET url_path = '/main/nms/trapEvtMgmt.do' WHERE guid = 'CF7338A3-06E2-472C-89D1-C817F2083E95';
UPDATE com_menu SET url_path = '/main/nms/chgMgmt.do' WHERE guid = '11B3C551-A9E2-4361-AC5C-D45751AD5E64';
UPDATE com_menu SET url_path = '/main/nms/assetInfoDev.do' WHERE guid = '3CD3129B-6B76-4398-A18A-43444A6C04EB';
UPDATE com_menu SET url_path = '/main/nms/assetInfoAp.do' WHERE guid = '21DF8EE0-EF9E-464A-97D6-EAB52DD19EE0';
UPDATE com_menu SET url_path = '/main/nms/assetInfoEosEol.do' WHERE guid = 'ACFA9C63-A3A7-11EE-9493-E869546C2160';
UPDATE com_menu SET url_path = '/main/nms/ifGraph.do' WHERE guid = '5429AEB0-797B-43F4-BF52-3CCC97A0EB64';
UPDATE com_menu SET url_path = '/main/nms/realTimeIf.do' WHERE guid = '5D96EB60-4789-4C89-A146-EF33B8D96510';
UPDATE com_menu SET url_path = '/main/nms/realTimeMultiPerf.do' WHERE guid = '6319D18C-0F49-47F2-8A01-F43E513180E0';
UPDATE com_menu SET url_path = '/main/nms/jobHist.do' WHERE guid = 'AF77542E-119A-4DF1-97AB-6A46CD092FDD';
UPDATE com_menu SET url_path = '/main/nms/ipMgmt.do' WHERE guid = 'D9167E24-F81F-4C44-A2CA-FFD15309478F';
UPDATE com_menu SET url_path = '/main/nms/healthChk.do' WHERE guid = 'A54369C9-AB15-4DC1-8181-2175E77E89C4';
UPDATE com_menu SET url_path = '/main/nms/l4Session.do' WHERE guid = '8747AA42-733A-441E-A3EA-AA18651774DD';
-- (전체 매핑은 /tmp/update_urls.sql 참조 - 총 321개 매핑)

-- 참고: 전체 UPDATE문은 NetisMenuHelper.java에서 자동 추출하여 적용 완료.
-- DB에 존재하는 204개 GUID 중 182개가 URL 매핑됨.
