-- mega next seq = 200000000000005200000
-- ep next seq = 200020000000002800000
-- hulian next seq = 200030000000001000000
-- large data next seq = 200090000200000000000

create sequence EP_TASK_HISTORY_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090000180000000000
increment by 1
cache 10
cycle;

create sequence EP_TASK_STEP_HISTORY_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090000190000000000
increment by 1
cache 10
cycle;
