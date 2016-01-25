--------------------------------------------------------
-- Export file for user DL25                          --
-- Created by Administrator on 2013-1-30, 下午 03:09:27 --
--------------------------------------------------------

spool 1-ddl.log

prompt
prompt Creating table ACCESS_SERVER
prompt ============================
prompt
create table ACCESS_SERVER
(
  ID               VARCHAR2(31) not null,
  OPTIMISTIC_LOCK  NUMBER(19) not null,
  F_NAME           VARCHAR2(255),
  NAMING           VARCHAR2(255),
  INSTALL_LOCATION VARCHAR2(255),
  DEVICE_NUMBER    VARCHAR2(255) not null,
  NOTE             VARCHAR2(255),
  IP               VARCHAR2(255),
  O_ORGAN_ID       VARCHAR2(31),
  STD_ID           VARCHAR2(32),
  IP1              VARCHAR2(16),
  LAST_UPDATE_TIME NUMBER(19)
)
;
comment on column ACCESS_SERVER.F_NAME
  is '名称';
comment on column ACCESS_SERVER.NAMING
  is '平台内部设备路由标识';
comment on column ACCESS_SERVER.INSTALL_LOCATION
  is '安装位置';
comment on column ACCESS_SERVER.DEVICE_NUMBER
  is '物理编号，设备注册唯一标识';
comment on column ACCESS_SERVER.NOTE
  is '备注';
comment on column ACCESS_SERVER.IP
  is '局域网IP';
comment on column ACCESS_SERVER.O_ORGAN_ID
  is '运营商ID，不在有用，固定为：0000000000000000000000000000001';
comment on column ACCESS_SERVER.STD_ID
  is '业务ID';
comment on column ACCESS_SERVER.IP1
  is '接入的内网ip';
comment on column ACCESS_SERVER.LAST_UPDATE_TIME
  is '最后一次心跳时间';
alter table ACCESS_SERVER
  add primary key (ID);
alter table ACCESS_SERVER
  add unique (DEVICE_NUMBER);

prompt
prompt Creating table AC_ACCESS_CARDS
prompt ==============================
prompt
create table AC_ACCESS_CARDS
(
  ID          VARCHAR2(31) not null,
  NAME        VARCHAR2(100),
  CARD_NUMBER VARCHAR2(31),
  NOTE        VARCHAR2(300),
  STATUS      VARCHAR2(31),
  PASSWORD    VARCHAR2(255),
  EXPIRE_DATE NUMBER(19),
  ORGAN_ID    VARCHAR2(31)
)
;
comment on table AC_ACCESS_CARDS
  is '门禁卡';
comment on column AC_ACCESS_CARDS.ID
  is '主键 唯一';
comment on column AC_ACCESS_CARDS.NAME
  is '卡名称';
comment on column AC_ACCESS_CARDS.CARD_NUMBER
  is '卡自己的编号';
comment on column AC_ACCESS_CARDS.NOTE
  is '备注';
comment on column AC_ACCESS_CARDS.STATUS
  is '状态：0绑定状态，2初始默认状态';
comment on column AC_ACCESS_CARDS.PASSWORD
  is '密码';
comment on column AC_ACCESS_CARDS.EXPIRE_DATE
  is '到期时间';
comment on column AC_ACCESS_CARDS.ORGAN_ID
  is '所属机构ID';
alter table AC_ACCESS_CARDS
  add constraint PK_AC_ACCESS_CARDS primary key (ID);

prompt
prompt Creating table AC_ACCESS_CONTROLS
prompt =================================
prompt
create table AC_ACCESS_CONTROLS
(
  ID                   VARCHAR2(31) not null,
  NAME                 VARCHAR2(100),
  ORGAN_ID             VARCHAR2(31),
  NAMING               VARCHAR2(100),
  INSTALL_LOCATION     VARCHAR2(300),
  DEVICE_NUMBER        VARCHAR2(100),
  CHANNEL_ID           NUMBER(6),
  NOTE                 VARCHAR2(300),
  DEVICE_TYPE          NUMBER(6),
  ACCESS_SERVER_ID     VARCHAR2(31),
  STATUS               NUMBER(6),
  TECHNICAL_PROTECTION VARCHAR2(255),
  PHYSICAL_PROTECTION  VARCHAR2(255),
  REMOTE_OPEN          VARCHAR2(100)
)
;
comment on table AC_ACCESS_CONTROLS
  is '门禁';
comment on column AC_ACCESS_CONTROLS.NAME
  is '名称';
comment on column AC_ACCESS_CONTROLS.ORGAN_ID
  is '所属机构ID';
comment on column AC_ACCESS_CONTROLS.NAMING
  is '平台内部设备路由标识';
comment on column AC_ACCESS_CONTROLS.INSTALL_LOCATION
  is '安装位置';
comment on column AC_ACCESS_CONTROLS.DEVICE_NUMBER
  is '物理编号，设备注册唯一标识';
comment on column AC_ACCESS_CONTROLS.CHANNEL_ID
  is '通道号';
comment on column AC_ACCESS_CONTROLS.NOTE
  is '备注';
comment on column AC_ACCESS_CONTROLS.DEVICE_TYPE
  is '类型：1门，0防区';
comment on column AC_ACCESS_CONTROLS.ACCESS_SERVER_ID
  is '门禁接入ID';
comment on column AC_ACCESS_CONTROLS.STATUS
  is '默认0，未用到';
comment on column AC_ACCESS_CONTROLS.TECHNICAL_PROTECTION
  is '没用';
comment on column AC_ACCESS_CONTROLS.PHYSICAL_PROTECTION
  is '没用';
alter table AC_ACCESS_CONTROLS
  add constraint AC_ACCESS_CONTROLS_PK primary key (ID);

prompt
prompt Creating table AC_ACCESS_SERVERS
prompt ================================
prompt
create table AC_ACCESS_SERVERS
(
  ID               VARCHAR2(31) not null,
  NAME             VARCHAR2(100),
  NAMING           VARCHAR2(100),
  ACCESS_PASSWORD  VARCHAR2(100),
  INSTALL_LOCATION VARCHAR2(100),
  DEVICE_NUMBER    VARCHAR2(100),
  IP               VARCHAR2(100),
  NOTE             VARCHAR2(300),
  MESSAGE_PORT     NUMBER(6),
  DEVICE_TYPE      VARCHAR2(100),
  STATUS           NUMBER(6),
  ORGAN_ID         VARCHAR2(31),
  GATEWAY_ID       VARCHAR2(31),
  SUBADDR          NUMBER(6),
  MODEL_TYPE       NUMBER(2)
)
;
comment on table AC_ACCESS_SERVERS
  is '门禁主机';
comment on column AC_ACCESS_SERVERS.NAME
  is '名称';
comment on column AC_ACCESS_SERVERS.NAMING
  is '平台内部设备路由标识';
comment on column AC_ACCESS_SERVERS.ACCESS_PASSWORD
  is '门禁控制器管理密码';
comment on column AC_ACCESS_SERVERS.INSTALL_LOCATION
  is '安装位置';
comment on column AC_ACCESS_SERVERS.DEVICE_NUMBER
  is '物理编号，设备注册唯一标识';
comment on column AC_ACCESS_SERVERS.IP
  is 'IP地址';
comment on column AC_ACCESS_SERVERS.NOTE
  is '备注';
comment on column AC_ACCESS_SERVERS.MESSAGE_PORT
  is '通信端口';
comment on column AC_ACCESS_SERVERS.DEVICE_TYPE
  is ' Neatech: 丽泽
      Zknet：  中控
Wiegand：微耕
Peak：    披克
Newabel： 纽贝尔
NetKing： 科松
';
comment on column AC_ACCESS_SERVERS.STATUS
  is '状态，未用到，默认0';
comment on column AC_ACCESS_SERVERS.ORGAN_ID
  is '所属机构ID';
comment on column AC_ACCESS_SERVERS.GATEWAY_ID
  is '注册的门禁网关ID';
comment on column AC_ACCESS_SERVERS.SUBADDR
  is '子地址，在RS485网络中串连多个门禁主机时，IP和Port相同，根据SubAddr字段区分，非RS485网络中的门禁主机，该字段置1（或0）';
comment on column AC_ACCESS_SERVERS.MODEL_TYPE
  is '未用到，默认1';
alter table AC_ACCESS_SERVERS
  add constraint AC_ACCESS_SERVERS_PK primary key (ID);

prompt
prompt Creating table AC_EMPLOYEES
prompt ===========================
prompt
create table AC_EMPLOYEES
(
  ID        VARCHAR2(31) not null,
  NAME      VARCHAR2(50),
  IMAGE     BLOB,
  IS_USER   NUMBER(1),
  USER_ID   VARCHAR2(31),
  NOTE      VARCHAR2(300),
  MOBILE    VARCHAR2(31),
  PHONE     VARCHAR2(31),
  EMAIL     VARCHAR2(31),
  AGE       NUMBER(2),
  GENDER    NUMBER(2),
  ADDRESS   VARCHAR2(31),
  EMP_NO    VARCHAR2(31),
  NATION    VARCHAR2(255),
  FOLK      VARCHAR2(255),
  ID_CARD   VARCHAR2(255),
  BIRTHDAY  NUMBER(19),
  PLACE     VARCHAR2(255),
  GROUP_ID  VARCHAR2(31),
  POSITION  VARCHAR2(31),
  ORGAN_ID  VARCHAR2(31),
  BRANCH_ID VARCHAR2(31)
)
;
alter table AC_EMPLOYEES
  add constraint AC_EMPLOYEES_PK primary key (ID);

prompt
prompt Creating table AC_EMPLOYEE_ABSENT_RECORD
prompt ========================================
prompt
create table AC_EMPLOYEE_ABSENT_RECORD
(
  ID          VARCHAR2(31) not null,
  ABSENT_TYPE VARCHAR2(10),
  EMPLOYEE_ID VARCHAR2(31),
  BRANCH_ID   VARCHAR2(31),
  ORGAN_ID    VARCHAR2(31),
  START_TIME  DATE,
  END_TIME    DATE,
  APPROVER    VARCHAR2(100),
  NOTE        VARCHAR2(300)
)
;
comment on column AC_EMPLOYEE_ABSENT_RECORD.ABSENT_TYPE
  is '请假类型：事假、病假、年假等';
comment on column AC_EMPLOYEE_ABSENT_RECORD.BRANCH_ID
  is '员工所属部门ID';
comment on column AC_EMPLOYEE_ABSENT_RECORD.ORGAN_ID
  is '员工所属机构ID';
comment on column AC_EMPLOYEE_ABSENT_RECORD.START_TIME
  is '请假起始日期，格式：yyyy-MM-dd HH:mm:ss';
comment on column AC_EMPLOYEE_ABSENT_RECORD.END_TIME
  is '请假结束日期，格式：yyyy-MM-dd HH:mm:ss';
comment on column AC_EMPLOYEE_ABSENT_RECORD.APPROVER
  is '审核人';
alter table AC_EMPLOYEE_ABSENT_RECORD
  add primary key (ID);

prompt
prompt Creating table AC_EMPLOYEE_GROUP
prompt ================================
prompt
create table AC_EMPLOYEE_GROUP
(
  ID          VARCHAR2(31) not null,
  NAME        VARCHAR2(50),
  ORGAN_ID    VARCHAR2(31),
  CREATOR_ID  VARCHAR2(31),
  CREATE_TIME DATE,
  NOTE        VARCHAR2(300)
)
;
comment on column AC_EMPLOYEE_GROUP.NAME
  is '员工组名称';
comment on column AC_EMPLOYEE_GROUP.ORGAN_ID
  is '员工组所属机构ID';
comment on column AC_EMPLOYEE_GROUP.CREATOR_ID
  is '员工组创建者';
alter table AC_EMPLOYEE_GROUP
  add primary key (ID);

prompt
prompt Creating table AC_EMPLOYEE_SCHEDULE
prompt ===================================
prompt
create table AC_EMPLOYEE_SCHEDULE
(
  ID           VARCHAR2(31) not null,
  NAME         VARCHAR2(50),
  ORGAN_ID     VARCHAR2(31),
  CREATOR_ID   VARCHAR2(31),
  CREATE_TIME  DATE,
  INITIAL_DATE VARCHAR2(50),
  CLOSURE_DATE VARCHAR2(50),
  START_TIME   VARCHAR2(50),
  CLOSING_TIME VARCHAR2(50),
  NOTE         VARCHAR2(300)
)
;
comment on column AC_EMPLOYEE_SCHEDULE.NAME
  is '排班名称';
comment on column AC_EMPLOYEE_SCHEDULE.ORGAN_ID
  is '排班所属机构ID';
comment on column AC_EMPLOYEE_SCHEDULE.CREATOR_ID
  is '排班创建者';
comment on column AC_EMPLOYEE_SCHEDULE.INITIAL_DATE
  is '排班起始日期,格式:yyyy-MM-dd';
comment on column AC_EMPLOYEE_SCHEDULE.CLOSURE_DATE
  is '排班结束日期,格式:yyyy-MM-dd';
comment on column AC_EMPLOYEE_SCHEDULE.START_TIME
  is '上班时间,格式:HH:mm:ss';
comment on column AC_EMPLOYEE_SCHEDULE.CLOSING_TIME
  is '下班时间,格式:HH:mm:ss';
alter table AC_EMPLOYEE_SCHEDULE
  add primary key (ID);

prompt
prompt Creating table AC_GATEWAY
prompt =========================
prompt
create table AC_GATEWAY
(
  ID               VARCHAR2(31) not null,
  NAME             VARCHAR2(100),
  LAN_IP           VARCHAR2(100),
  WAN_IP           VARCHAR2(100),
  INSTALL_LOCATION VARCHAR2(100),
  NOTE             VARCHAR2(300),
  NAMING           VARCHAR2(100),
  PORT             NUMBER(6),
  DEVICE_NUMBER    VARCHAR2(30),
  ORGAN_ID         VARCHAR2(31),
  LAST_UPDATE_TIME NUMBER(19)
)
;
comment on column AC_GATEWAY.LAST_UPDATE_TIME
  is '最后一次心跳时间';
alter table AC_GATEWAY
  add constraint AC_GATEWAY_PK primary key (ID);

prompt
prompt Creating table AC_LOG
prompt =====================
prompt
create table AC_LOG
(
  ID           VARCHAR2(31) not null,
  TRIGGER_ID   VARCHAR2(31),
  DEVICE_TYPE  VARCHAR2(32),
  LOG_TYPE     VARCHAR2(100),
  TRIGGER_TYPE VARCHAR2(100),
  DEVICE_ID    VARCHAR2(31),
  TIME         NUMBER(16),
  NAMING       VARCHAR2(255),
  NOTE         VARCHAR2(255)
)
;
comment on column AC_LOG.TRIGGER_ID
  is '可能为用户ID，也可能是卡ID，现在只有这二种';
comment on column AC_LOG.DEVICE_TYPE
  is 'Door：报警的门
	Area：报警防区， 方便以后将对应报警主机的日志信息也保存到中心
';
comment on column AC_LOG.LOG_TYPE
  is 'Trigger：正常触发的log,Alarm：报警log';
comment on column AC_LOG.TRIGGER_TYPE
  is 'TriggerFingerPrint：指纹，这种方式下Trigger Id为用户ID
	TriggerPassword：密码，这种方式下Trigger Id为用户ID
	TriggerCard：门卡，这种方式下Trigger Id为卡ID
	TriggerOpenDoor：门开记录，Trigger Id值为空
	TriggerCloseDoor：门关记录，Trigger Id值为空
	TriggerHandleOpen：手动开门记录，Trigger Id值为空
	AlarmIllegalOpenDoor：非正常门开报警，TriggerId值为空
	AlarmIllegalCloseDoor：非正常门关报警（非正常开门后），Trigger Id值为空
	AlarmTimeoutOpenDoor：合法刷卡在规定延时内未开门进入报警，Trigger Id值为空
	AlarmTimeoutCloseDoor：合法进入后但在规定延时内未关好门报警，Trigger Id值为空
	AlarmInvalidCard：无效的用户卡刷卡记录报警，Trigger Id为卡ID
	AlarmInvalidFingerPrint：无效的指纹刷卡记录报警，Trigger Id为用户ID
	AlarmOverdueCard：已过有效期卡刷卡记录报警，Trigger Id为卡ID
	AlarmOverdueFingerPrint：已过有效期指纹刷卡记录报警，Trigger Id为用户ID
	AlarmPeriodLimit：当前时间无进入权限的用户卡刷卡记录报警，Trigger Id为卡ID
	AlarmPeriodLimitFingerPrint：当前无进入权限的用户指纹刷卡记录报警，Trigger Id为用户ID
	AlarmUserMenace: 胁迫报警,Trigger Id为用户ID
';
comment on column AC_LOG.TIME
  is '事件发生事件';
comment on column AC_LOG.NAMING
  is '事件Naming，逻辑主键';
alter table AC_LOG
  add constraint AC_LOG_PK primary key (ID);

prompt
prompt Creating table AC_R_DOOR_CARD
prompt =============================
prompt
create table AC_R_DOOR_CARD
(
  ID             VARCHAR2(31) not null,
  DOOR_ID        VARCHAR2(31) not null,
  CARD_ID        VARCHAR2(31) not null,
  AUTHORIZE_TYPE NUMBER,
  AUTHORIZE_TIME NUMBER,
  EXPIRED_TIME   NUMBER,
  PASSWORD       NUMBER
)
;
comment on column AC_R_DOOR_CARD.DOOR_ID
  is '门ID';
comment on column AC_R_DOOR_CARD.CARD_ID
  is '卡ID';
comment on column AC_R_DOOR_CARD.AUTHORIZE_TYPE
  is '授权类型：0初始默认，1下发授权';
comment on column AC_R_DOOR_CARD.AUTHORIZE_TIME
  is '授权时间';
comment on column AC_R_DOOR_CARD.EXPIRED_TIME
  is '过期时间';
comment on column AC_R_DOOR_CARD.PASSWORD
  is '密码';
alter table AC_R_DOOR_CARD
  add constraint AC_R_DOOR_CARD_PK primary key (ID);

prompt
prompt Creating table AC_R_EMPLOYEE_CARD
prompt =================================
prompt
create table AC_R_EMPLOYEE_CARD
(
  ID          VARCHAR2(31) not null,
  EMPLOYEE_ID VARCHAR2(31) not null,
  CARD_ID     VARCHAR2(31) not null
)
;
alter table AC_R_EMPLOYEE_CARD
  add constraint AC_R_EMPLOYEE_CARD_PK primary key (ID);

prompt
prompt Creating table AC_R_EMPLOYEE_GROUP
prompt ==================================
prompt
create table AC_R_EMPLOYEE_GROUP
(
  ID          VARCHAR2(31) not null,
  GROUP_ID    VARCHAR2(31) not null,
  EMPLOYEE_ID VARCHAR2(31) not null
)
;
alter table AC_R_EMPLOYEE_GROUP
  add primary key (ID);

prompt
prompt Creating table AC_R_SCHEDULE_GROUP
prompt ==================================
prompt
create table AC_R_SCHEDULE_GROUP
(
  ID          VARCHAR2(31) not null,
  GROUP_ID    VARCHAR2(31) not null,
  SCHEDULE_ID VARCHAR2(31) not null
)
;
alter table AC_R_SCHEDULE_GROUP
  add primary key (ID);

prompt
prompt Creating table VIDEO_INPUT_SERVER_MODEL
prompt =======================================
prompt
create table VIDEO_INPUT_SERVER_MODEL
(
  ID              VARCHAR2(31) not null,
  OPTIMISTIC_LOCK NUMBER(19) not null,
  F_NAME          VARCHAR2(255) not null,
  F_TYPE          VARCHAR2(255),
  ENCODE          VARCHAR2(255),
  NOTE            VARCHAR2(255),
  MANUFACTURER_ID VARCHAR2(32),
  DECODE          VARCHAR2(255),
  RTP_PAYLOAD     VARCHAR2(6)
)
;
alter table VIDEO_INPUT_SERVER_MODEL
  add primary key (ID);

prompt
prompt Creating table ORGAN
prompt ====================
prompt
create table ORGAN
(
  ID              VARCHAR2(31) not null,
  OPTIMISTIC_LOCK NUMBER(19) not null,
  F_NAME          VARCHAR2(255) not null,
  PARENT_ORGAN_ID VARCHAR2(31),
  PATH            VARCHAR2(1000)
)
;
alter table ORGAN
  add primary key (ID);
alter table ORGAN
  add constraint FK47F99F1EF04961E foreign key (PARENT_ORGAN_ID)
  references ORGAN (ID);

prompt
prompt Creating table COMPANY
prompt ======================
prompt
create table COMPANY
(
  ORGAN_ID     VARCHAR2(31) not null,
  NOTE         VARCHAR2(255),
  LINKMAN      VARCHAR2(255),
  EMAIL        VARCHAR2(255),
  PHONE        VARCHAR2(255),
  FAX          VARCHAR2(255),
  ADDRESS      VARCHAR2(255),
  POSTALCODE   VARCHAR2(255),
  IS_SUSPENDED NUMBER(1) not null,
  F_NUMBER     VARCHAR2(255) not null,
  O_ORGAN_ID   VARCHAR2(31),
  CREATETIME   NUMBER(19) default 0,
  IS_MSP       NUMBER(2) default 0
)
;
alter table COMPANY
  add primary key (ORGAN_ID);
alter table COMPANY
  add unique (F_NUMBER);
alter table COMPANY
  add constraint FK_SUPER_CP foreign key (ORGAN_ID)
  references ORGAN (ID);

prompt
prompt Creating table VIDEO_INPUT_SERVER
prompt =================================
prompt
create table VIDEO_INPUT_SERVER
(
  ID                          VARCHAR2(31) not null,
  OPTIMISTIC_LOCK             NUMBER(19) not null,
  F_NAME                      VARCHAR2(255),
  NAMING                      VARCHAR2(255),
  INSTALL_LOCATION            VARCHAR2(255),
  NOTE                        VARCHAR2(255),
  DEVICE_NUMBER               VARCHAR2(255) not null,
  IP                          VARCHAR2(255),
  LINK_TYPE                   VARCHAR2(255),
  HEART_CYCLE                 NUMBER(10),
  REBOOT_TIME                 VARCHAR2(255),
  REBOOT_CYCLE                NUMBER(10),
  MAX_CONNECT_AMOUNT          NUMBER(10),
  VIDEO_INTPUT_AMOUNT         NUMBER(10),
  VIDEO_INPUT_SERVER_MODEL_ID VARCHAR2(31) not null,
  COMPANY_ID                  VARCHAR2(31),
  STD_ID                      VARCHAR2(32),
  IS_SUPPORT_SCHEME           NUMBER(1) default 0,
  O_ORGAN_ID                  VARCHAR2(31),
  MAX_VIDEOINPUT_CHANNEL      NUMBER default 0,
  MAX_ALARMOUTPUT_CHANNEL     NUMBER default 0,
  MAX_ALARMINPUT_CHANNEL      NUMBER default 0,
  IS_SUSPENDED                NUMBER(1) default 0,
  IS_SUPPORT_NAT              NUMBER(1) default 0,
  IS_SUPPORT_VOD2             NUMBER(1) default 0,
  IS_SUPPORT_PTZ_LOCK         NUMBER(1) default 0,
  CREATETIME                  NUMBER(19) default 0,
  START_ONLINE_TIME           NUMBER(19) default 0,
  IS_REGISTERD                NUMBER default 0,
  WEB_PORT                    NUMBER default 80,
  NAT_IP                      VARCHAR2(30),
  IS_NAT                      NUMBER(1) default 0,
  SUPPORT_CAPACITY            VARCHAR2(50) default '11111111111111111111111111111111111111111111111111',
  VIS_TYPE                    VARCHAR2(10),
  PASSWORD                    VARCHAR2(64),
  SIP_PORT                    NUMBER(6)
)
;
comment on column VIDEO_INPUT_SERVER.MAX_VIDEOINPUT_CHANNEL
  is '最大视频输入通道';
comment on column VIDEO_INPUT_SERVER.MAX_ALARMOUTPUT_CHANNEL
  is '最大报警输出通道';
comment on column VIDEO_INPUT_SERVER.MAX_ALARMINPUT_CHANNEL
  is '最大报警输入通道';
comment on column VIDEO_INPUT_SERVER.IS_SUSPENDED
  is '设备是不是暂停';
comment on column VIDEO_INPUT_SERVER.IS_SUPPORT_NAT
  is '是不是支持NAT';
comment on column VIDEO_INPUT_SERVER.IS_SUPPORT_VOD2
  is '是不是支持VOD 2.0版本';
comment on column VIDEO_INPUT_SERVER.IS_SUPPORT_PTZ_LOCK
  is '是不是支持云台锁定';
comment on column VIDEO_INPUT_SERVER.IS_NAT
  is '是否在Nat之后 0:不在 1:在';
comment on column VIDEO_INPUT_SERVER.SUPPORT_CAPACITY
  is '视频服务器能力项';
comment on column VIDEO_INPUT_SERVER.VIS_TYPE
  is '专用视频服务器类型 1:人保 2未定义（之后扩展时补充）';
comment on column VIDEO_INPUT_SERVER.SIP_PORT
  is '信令通信端口';
alter table VIDEO_INPUT_SERVER
  add primary key (ID);
alter table VIDEO_INPUT_SERVER
  add unique (DEVICE_NUMBER);
alter table VIDEO_INPUT_SERVER
  add constraint FKCC5026DCEA63EC3D foreign key (COMPANY_ID)
  references COMPANY (ORGAN_ID)
  disable;
alter table VIDEO_INPUT_SERVER
  add constraint FKCC5026DCF2BDA414 foreign key (VIDEO_INPUT_SERVER_MODEL_ID)
  references VIDEO_INPUT_SERVER_MODEL (ID);

prompt
prompt Creating table ALARM_BOX
prompt ========================
prompt
create table ALARM_BOX
(
  ID                    VARCHAR2(31) not null,
  OPTIMISTIC_LOCK       NUMBER(19) not null,
  F_NAME                VARCHAR2(255),
  NAMING                VARCHAR2(255),
  INSTALL_LOCATION      VARCHAR2(255),
  NOTE                  VARCHAR2(255),
  VIDEO_INPUT_SERVER_ID VARCHAR2(31) not null,
  ADDRESS_NUMBER        VARCHAR2(255) not null
)
;
alter table ALARM_BOX
  add primary key (ID);
alter table ALARM_BOX
  add unique (VIDEO_INPUT_SERVER_ID);
alter table ALARM_BOX
  add constraint FK_AB_VIS foreign key (VIDEO_INPUT_SERVER_ID)
  references VIDEO_INPUT_SERVER (ID);

prompt
prompt Creating table ALARM_INPUT_CHANNEL_TYPE
prompt =======================================
prompt
create table ALARM_INPUT_CHANNEL_TYPE
(
  ID                      VARCHAR2(31) not null,
  OPTIMISTIC_LOCK         NUMBER(19) not null,
  F_NAME                  VARCHAR2(255) not null,
  IS_CONTROLLABLE_BY_USER NUMBER(1) not null,
  DESCRIBE                VARCHAR2(255)
)
;
alter table ALARM_INPUT_CHANNEL_TYPE
  add primary key (ID);

prompt
prompt Creating table ALARM_INPUT_CHANNEL
prompt ==================================
prompt
create table ALARM_INPUT_CHANNEL
(
  ID                          VARCHAR2(31) not null,
  OPTIMISTIC_LOCK             NUMBER(19) not null,
  F_NAME                      VARCHAR2(255),
  NAMING                      VARCHAR2(255),
  INSTALL_LOCATION            VARCHAR2(255),
  NOTE                        VARCHAR2(255),
  ALARM_BOX_ID                VARCHAR2(31) not null,
  ADDRESS_NUMBER_ON_ALARM_BOX VARCHAR2(255) not null,
  ALARM_INPUT_CHANNEL_TYPE_ID VARCHAR2(31) not null,
  ORGAN_ID                    VARCHAR2(31),
  DEVICE_PHYSICAL_RELATION_ID VARCHAR2(31),
  IS_SUPPORT_SCHEME           NUMBER(1) default 0,
  IS_SHARE                    NUMBER(5) default 0,
  CHANNEL_ID                  NUMBER(2),
  ALARM_STORAGE_SERVER_ID     VARCHAR2(31)
)
;
comment on column ALARM_INPUT_CHANNEL.IS_SHARE
  is '报警输入是否公享: 0 不公享,1 公享';
alter table ALARM_INPUT_CHANNEL
  add primary key (ID);
alter table ALARM_INPUT_CHANNEL
  add constraint FKB0EBEFC01DE59FD foreign key (ALARM_BOX_ID)
  references ALARM_BOX (ID);
alter table ALARM_INPUT_CHANNEL
  add constraint FKB0EBEFC03162BAC1 foreign key (ALARM_INPUT_CHANNEL_TYPE_ID)
  references ALARM_INPUT_CHANNEL_TYPE (ID);
alter table ALARM_INPUT_CHANNEL
  add constraint FKB0EBEFC07D1CC229 foreign key (ORGAN_ID)
  references ORGAN (ID)
  disable;

prompt
prompt Creating table ALARM_OUTPUT_CHANNEL_TYPE
prompt ========================================
prompt
create table ALARM_OUTPUT_CHANNEL_TYPE
(
  ID                      VARCHAR2(31) not null,
  OPTIMISTIC_LOCK         NUMBER(19) not null,
  F_NAME                  VARCHAR2(255) not null,
  IS_CONTROLLABLE_BY_USER NUMBER(1) not null,
  DESCRIBE                VARCHAR2(255)
)
;
alter table ALARM_OUTPUT_CHANNEL_TYPE
  add primary key (ID);

prompt
prompt Creating table ALARM_OUTPUT_CHANNEL
prompt ===================================
prompt
create table ALARM_OUTPUT_CHANNEL
(
  ID                           VARCHAR2(31) not null,
  OPTIMISTIC_LOCK              NUMBER(19) not null,
  F_NAME                       VARCHAR2(255),
  NAMING                       VARCHAR2(255),
  INSTALL_LOCATION             VARCHAR2(255),
  NOTE                         VARCHAR2(255),
  ALARM_BOX_ID                 VARCHAR2(31) not null,
  ADDRESS_NUMBER_ON_ALARM_BOX  VARCHAR2(255) not null,
  ALARM_OUTPUT_CHANNEL_TYPE_ID VARCHAR2(31) not null,
  ORGAN_ID                     VARCHAR2(31),
  DEVICE_PHYSICAL_RELATION_ID  VARCHAR2(31),
  IS_SUPPORT_SCHEME            NUMBER(1) default 0,
  IS_SHARE                     NUMBER(5) default 0,
  CHANNEL_ID                   NUMBER(2)
)
;
comment on column ALARM_OUTPUT_CHANNEL.IS_SHARE
  is '报警输入是否公享: 0 不公享,1 公享';
alter table ALARM_OUTPUT_CHANNEL
  add primary key (ID);
alter table ALARM_OUTPUT_CHANNEL
  add constraint FK685E4F731DE59FD foreign key (ALARM_BOX_ID)
  references ALARM_BOX (ID);
alter table ALARM_OUTPUT_CHANNEL
  add constraint FK685E4F7367DFB774 foreign key (ALARM_OUTPUT_CHANNEL_TYPE_ID)
  references ALARM_OUTPUT_CHANNEL_TYPE (ID);
alter table ALARM_OUTPUT_CHANNEL
  add constraint FK685E4F737D1CC229 foreign key (ORGAN_ID)
  references ORGAN (ID)
  disable;
create index AOC_BOXID on ALARM_OUTPUT_CHANNEL (ALARM_BOX_ID);

prompt
prompt Creating table BRANCH
prompt =====================
prompt
create table BRANCH
(
  ID        VARCHAR2(31) not null,
  NAME      VARCHAR2(200) not null,
  PARENT_ID VARCHAR2(31),
  ORGAN_ID  VARCHAR2(31),
  PATH      VARCHAR2(1000) not null,
  PERSON    VARCHAR2(100),
  CONTACT   VARCHAR2(200)
)
;
comment on column BRANCH.NAME
  is '部门名称';
comment on column BRANCH.PARENT_ID
  is '上机部门ID';
comment on column BRANCH.ORGAN_ID
  is '部门所属机构ID';
comment on column BRANCH.PERSON
  is '联系人';
comment on column BRANCH.CONTACT
  is '联系方式';
alter table BRANCH
  add primary key (ID);

prompt
prompt Creating table DISPATCH_SERVER
prompt ==============================
prompt
create table DISPATCH_SERVER
(
  ID                     VARCHAR2(31) not null,
  OPTIMISTIC_LOCK        NUMBER(19) not null,
  F_NAME                 VARCHAR2(255),
  NAMING                 VARCHAR2(255),
  INSTALL_LOCATION       VARCHAR2(255),
  NOTE                   VARCHAR2(255),
  DEVICE_NUMBER          VARCHAR2(255) not null,
  IP                     VARCHAR2(255),
  IP2                    VARCHAR2(255),
  VIDEOPORT              NUMBER(10),
  MSGPORT                NUMBER(10),
  LINK_TYPE              VARCHAR2(255),
  HEART_CYCLE            NUMBER(10),
  MAX_OUTPUT_AMOUNT      NUMBER(10),
  MAX_INPUT_AMOUNT       NUMBER(10),
  RESERVED_OUTPUT_AMOUNT NUMBER(10),
  O_ORGAN_ID             VARCHAR2(31),
  WEIGHT                 VARCHAR2(5),
  STD_ID                 VARCHAR2(32),
  OWNER_SHIP             VARCHAR2(60) default 'private'
)
;
alter table DISPATCH_SERVER
  add primary key (ID);
alter table DISPATCH_SERVER
  add unique (DEVICE_NUMBER);

prompt
prompt Creating table EP_ALARM_EVENT
prompt =============================
prompt
create table EP_ALARM_EVENT
(
  ID              VARCHAR2(31) not null,
  SESSION_ID      VARCHAR2(31),
  SOURCE_ID       VARCHAR2(31),
  SOURCE_TYPE     VARCHAR2(64),
  THRESHOLD       VARCHAR2(255),
  VALUE           VARCHAR2(255),
  BEGIN_TIME      NUMBER(19),
  END_TIME        NUMBER(19),
  CONFIRM_TIME    NUMBER(19),
  NOTE            VARCHAR2(255),
  NAMING          VARCHAR2(255),
  SOURCE_NAME     VARCHAR2(255),
  EVENT_TYPE_NAME VARCHAR2(255),
  EVENT_LEVEL     VARCHAR2(8) default '1',
  ORGAN_ID        VARCHAR2(32),
  RECORD_FLAG     VARCHAR2(2)
)
;
comment on table EP_ALARM_EVENT
  is '电力环控设备报警信息';
comment on column EP_ALARM_EVENT.SESSION_ID
  is '上报服务器的session_id';
comment on column EP_ALARM_EVENT.SOURCE_ID
  is '报警源ID';
comment on column EP_ALARM_EVENT.SOURCE_TYPE
  is '报警源类型';
comment on column EP_ALARM_EVENT.THRESHOLD
  is '如果是开关量，则0表示开，1表示关，如果是模拟量，则表示产生本次报警的阀值';
comment on column EP_ALARM_EVENT.VALUE
  is '产生报警的真实数据值';
comment on column EP_ALARM_EVENT.BEGIN_TIME
  is '报警开始时间';
comment on column EP_ALARM_EVENT.END_TIME
  is '报警结束时间';
comment on column EP_ALARM_EVENT.CONFIRM_TIME
  is '报警确认时间';
comment on column EP_ALARM_EVENT.NOTE
  is '备注';
comment on column EP_ALARM_EVENT.RECORD_FLAG
  is '带有报警录像标志：1-有，0-没有';
alter table EP_ALARM_EVENT
  add constraint EP_ALARM_EVENT_P primary key (ID);

prompt
prompt Creating table EP_ASSETS
prompt ========================
prompt
create table EP_ASSETS
(
  ID                VARCHAR2(31) not null,
  TYPE              NUMBER not null,
  USE_TIME          NUMBER,
  EXPIRATION_TIME   NUMBER,
  SIGNIFICANT_LEVEL NUMBER,
  DEVICE_NUMBER     VARCHAR2(50),
  INSTALL_LOCATION  VARCHAR2(255)
)
;
comment on column EP_ASSETS.TYPE
  is 'GIS设备 = 0
电容器 = 1
变压器 = 2
 开关柜 = 3';
comment on column EP_ASSETS.USE_TIME
  is '投运时间';
comment on column EP_ASSETS.EXPIRATION_TIME
  is '到期时间';
comment on column EP_ASSETS.SIGNIFICANT_LEVEL
  is '重要级别';
comment on column EP_ASSETS.DEVICE_NUMBER
  is '设备编号';
alter table EP_ASSETS
  add constraint EP_ASSETS_PK primary key (ID);

prompt
prompt Creating table EP_CLIENT_GATEWAY
prompt ================================
prompt
create table EP_CLIENT_GATEWAY
(
  ID              VARCHAR2(31) not null,
  NAME            VARCHAR2(50) not null,
  DEVICE_NUMBER   VARCHAR2(20) not null,
  IP1             VARCHAR2(30),
  IP2             VARCHAR2(30),
  NAMING          VARCHAR2(50),
  PORT            NUMBER(10),
  NOTE            VARCHAR2(200),
  HEARTBEAT_CYCLE NUMBER(8),
  HEARTBEAT_TIME  NUMBER(19),
  ADDRESS         VARCHAR2(255)
)
;
comment on column EP_CLIENT_GATEWAY.ID
  is 'ID';
comment on column EP_CLIENT_GATEWAY.NAME
  is '名称';
comment on column EP_CLIENT_GATEWAY.DEVICE_NUMBER
  is '设备编号，设备注册用';
comment on column EP_CLIENT_GATEWAY.IP1
  is '主要使用的ip';
comment on column EP_CLIENT_GATEWAY.IP2
  is '备用IP、双网卡使用';
comment on column EP_CLIENT_GATEWAY.PORT
  is '端口';
comment on column EP_CLIENT_GATEWAY.NOTE
  is '备注';
comment on column EP_CLIENT_GATEWAY.HEARTBEAT_CYCLE
  is '心跳周期 单位为秒';
comment on column EP_CLIENT_GATEWAY.HEARTBEAT_TIME
  is '最后一次心跳时间';
comment on column EP_CLIENT_GATEWAY.ADDRESS
  is '安装位置';
alter table EP_CLIENT_GATEWAY
  add constraint CLIENT_GATEWAY_KEY primary key (ID);

prompt
prompt Creating table EP_CONTROL_SERVER
prompt ================================
prompt
create table EP_CONTROL_SERVER
(
  ID               VARCHAR2(31) not null,
  GATHER_SERVER_ID VARCHAR2(31),
  NAME             VARCHAR2(255) not null,
  POSITION         VARCHAR2(255),
  ORGAN_ID         VARCHAR2(31),
  TYPE             NUMBER(1),
  URL              VARCHAR2(255)
)
;
comment on table EP_CONTROL_SERVER
  is '控制器';
comment on column EP_CONTROL_SERVER.GATHER_SERVER_ID
  is '采集服务器ID';
comment on column EP_CONTROL_SERVER.NAME
  is '控制器名称';
comment on column EP_CONTROL_SERVER.POSITION
  is '物理位置';
comment on column EP_CONTROL_SERVER.ORGAN_ID
  is '所属机构';
comment on column EP_CONTROL_SERVER.TYPE
  is '1:plc 2:太阳能控制器';
comment on column EP_CONTROL_SERVER.URL
  is '网络访问地址';
alter table EP_CONTROL_SERVER
  add primary key (ID);

prompt
prompt Creating table EP_DEVICE
prompt ========================
prompt
create table EP_DEVICE
(
  ID        VARCHAR2(31) not null,
  NAME      VARCHAR2(200) not null,
  ORGAN_ID  VARCHAR2(31),
  PARENT_ID VARCHAR2(31),
  TYPE      NUMBER(20),
  NOTE      VARCHAR2(1000),
  OPERATION VARCHAR2(31)
)
;
comment on column EP_DEVICE.ORGAN_ID
  is '电力设备所属的机构，对应于全球眼的ORGAN表';
comment on column EP_DEVICE.PARENT_ID
  is '父设备ID';
comment on column EP_DEVICE.TYPE
  is '设备类型1：资产 2：输电线 3：智能检测设备 4：可关联设备功能区 5：不可关联功能区';
alter table EP_DEVICE
  add primary key (ID);

prompt
prompt Creating table EP_EVENT_SERVER
prompt ==============================
prompt
create table EP_EVENT_SERVER
(
  ID               VARCHAR2(31) not null,
  DEVICE_NUMBER    VARCHAR2(14) not null,
  NAME             VARCHAR2(100) not null,
  INSTALL_LOCATION VARCHAR2(100),
  IP1              VARCHAR2(50),
  IP2              VARCHAR2(50),
  NAMING           VARCHAR2(100),
  NOTE             VARCHAR2(300),
  PORT             NUMBER(10),
  HEARTBEAT_CYCLE  NUMBER(8),
  HEARTBEAT_TIME   NUMBER(19),
  ALARM_FREQUENCY  NUMBER(8)
)
;
comment on column EP_EVENT_SERVER.ID
  is '主键';
comment on column EP_EVENT_SERVER.DEVICE_NUMBER
  is '设备号';
comment on column EP_EVENT_SERVER.NAME
  is '名称';
comment on column EP_EVENT_SERVER.INSTALL_LOCATION
  is '安装地址';
comment on column EP_EVENT_SERVER.NAMING
  is 'naming';
comment on column EP_EVENT_SERVER.NOTE
  is '备注';
comment on column EP_EVENT_SERVER.PORT
  is '端口';
comment on column EP_EVENT_SERVER.HEARTBEAT_CYCLE
  is '心跳周期，单位为秒';
comment on column EP_EVENT_SERVER.ALARM_FREQUENCY
  is '相同报警拦截时间，单位为秒';
alter table EP_EVENT_SERVER
  add constraint EP_EVENT_SERVER_PK primary key (ID);

prompt
prompt Creating table EP_EVENT_TYPE
prompt ============================
prompt
create table EP_EVENT_TYPE
(
  ID            VARCHAR2(31) not null,
  CODE          NUMBER(20) not null,
  NAME          VARCHAR2(255) not null,
  STANDARD_TYPE VARCHAR2(8) default '1'
)
;
comment on table EP_EVENT_TYPE
  is '互联事件类型';
comment on column EP_EVENT_TYPE.CODE
  is '事件统一编码，INT32转为10进制数字';
comment on column EP_EVENT_TYPE.NAME
  is '事件名称';
comment on column EP_EVENT_TYPE.STANDARD_TYPE
  is '1表示国网标准,2表示南方电网标准';
alter table EP_EVENT_TYPE
  add constraint EP_EVENT_TYPE_ID primary key (ID);

prompt
prompt Creating table EP_GATHER_SERVER
prompt ===============================
prompt
create table EP_GATHER_SERVER
(
  ID                    VARCHAR2(31) not null,
  ORGAN_ID              VARCHAR2(31),
  IP                    VARCHAR2(22),
  NAME                  VARCHAR2(255) not null,
  NOTE                  VARCHAR2(1000),
  HEART_CYCLE           NUMBER(10) default 600 not null,
  EVENT_SERVER_ID       VARCHAR2(255),
  EVENT_PORT            VARCHAR2(6),
  CLIENT_PORT           VARCHAR2(6),
  CONSOLE_LISTENER_IP   VARCHAR2(22),
  CONSOLE_LISTENER_PORT VARCHAR2(6),
  CONSOLE_PASSWORD      VARCHAR2(20),
  CLIENT_IP             VARCHAR2(22),
  EVENT_IP              VARCHAR2(22),
  DEVICE_NUMBER         VARCHAR2(31)
)
;
comment on table EP_GATHER_SERVER
  is '采集服务器';
comment on column EP_GATHER_SERVER.ORGAN_ID
  is '采集服务器所属的机构，对应于全球眼的ORGAN表';
comment on column EP_GATHER_SERVER.IP
  is '采集服务器IP';
comment on column EP_GATHER_SERVER.NAME
  is '采集服务器名称';
comment on column EP_GATHER_SERVER.HEART_CYCLE
  is '心跳周期(单位 秒)';
comment on column EP_GATHER_SERVER.EVENT_SERVER_ID
  is '关联事件服务器ID';
comment on column EP_GATHER_SERVER.EVENT_PORT
  is '监听事件服务器请求端口';
comment on column EP_GATHER_SERVER.CLIENT_PORT
  is '监听客户端请求端口';
comment on column EP_GATHER_SERVER.CONSOLE_LISTENER_IP
  is 'web服务ip';
comment on column EP_GATHER_SERVER.CONSOLE_LISTENER_PORT
  is 'web服务端口';
comment on column EP_GATHER_SERVER.CONSOLE_PASSWORD
  is 'web服务密码';
comment on column EP_GATHER_SERVER.CLIENT_IP
  is '监听客户端请求IP';
comment on column EP_GATHER_SERVER.EVENT_IP
  is '监听事件服务器IP';
alter table EP_GATHER_SERVER
  add primary key (ID);

prompt
prompt Creating table EP_INSTALL_ADDRESS
prompt =================================
prompt
create table EP_INSTALL_ADDRESS
(
  ID                    VARCHAR2(31) not null,
  NAME                  VARCHAR2(32),
  LINE_BACK_FEW         VARCHAR2(32),
  TOWER_NUMBER          VARCHAR2(32),
  SWITCHES_IP           VARCHAR2(32),
  SERIAL_SERVER_IP      VARCHAR2(32),
  VOLTAGE_LEVEL         VARCHAR2(32),
  AREA_BELONGS          VARCHAR2(32),
  INSTALLATION_POSITION VARCHAR2(32),
  TYPE                  VARCHAR2(32)
)
;
alter table EP_INSTALL_ADDRESS
  add primary key (ID);

prompt
prompt Creating table EP_INTELLIGENT_CHANNEL
prompt =====================================
prompt
create table EP_INTELLIGENT_CHANNEL
(
  ID               VARCHAR2(31) not null,
  OPTIMISTIC_LOCK  NUMBER(19) not null,
  F_NAME           VARCHAR2(255),
  NAMING           VARCHAR2(255),
  INSTALL_LOCATION VARCHAR2(255),
  PARENT_ID        VARCHAR2(31),
  PARENT_TYPE      NUMBER(1),
  DESCRIPTION      VARCHAR2(255),
  NOTE             VARCHAR2(255),
  COMPANY          VARCHAR2(255),
  CHANNEL_ID       NUMBER(2),
  ORGAN_ID         VARCHAR2(31)
)
;
alter table EP_INTELLIGENT_CHANNEL
  add primary key (ID);

prompt
prompt Creating table EP_INTELLIGENT_DETECTION
prompt =======================================
prompt
create table EP_INTELLIGENT_DETECTION
(
  DEVICE_ID VARCHAR2(31) not null,
  TYPE      NUMBER not null
)
;
comment on column EP_INTELLIGENT_DETECTION.TYPE
  is '1:变压器区 2:电容器室 3:主控室 4:房间温湿度 5:有害气体6:站用电7:避雷针8:微气象9:环境控制';
alter table EP_INTELLIGENT_DETECTION
  add constraint EP_INTELLIGENT_DETECTION_PK primary key (DEVICE_ID);

prompt
prompt Creating table EP_MAP
prompt =====================
prompt
create table EP_MAP
(
  ID             VARCHAR2(31) not null,
  ORGAN_ID       VARCHAR2(31),
  NAME           VARCHAR2(255) not null,
  EP_MAP_TYPE_ID VARCHAR2(31) not null,
  PATH           VARCHAR2(1000),
  NOTE           VARCHAR2(1000),
  IMAGE          BLOB
)
;
comment on table EP_MAP
  is '电力地图';
comment on column EP_MAP.ORGAN_ID
  is '地图所属的机构，对应于全球眼的ORGAN表';
comment on column EP_MAP.NAME
  is '地图名称';
comment on column EP_MAP.EP_MAP_TYPE_ID
  is '地图类型';
comment on column EP_MAP.PATH
  is '存在服务器上的地址';
alter table EP_MAP
  add primary key (ID);

prompt
prompt Creating table EP_MONITOR_DEVICE
prompt ================================
prompt
create table EP_MONITOR_DEVICE
(
  ID       VARCHAR2(31) not null,
  NAME     VARCHAR2(50) not null,
  TYPE     NUMBER not null,
  NAMING   VARCHAR2(100),
  ORGAN_ID VARCHAR2(31) not null
)
;
comment on column EP_MONITOR_DEVICE.TYPE
  is '1:vic2:prober';
comment on column EP_MONITOR_DEVICE.ORGAN_ID
  is '机构ID';
alter table EP_MONITOR_DEVICE
  add constraint EP_MONITOR_DEVICE_PK primary key (ID);

prompt
prompt Creating table EP_OPERATION
prompt ===========================
prompt
create table EP_OPERATION
(
  ID               VARCHAR2(31) not null,
  NAME             VARCHAR2(50) not null,
  NOTE             VARCHAR2(100),
  PARENT_ID        VARCHAR2(31),
  OPERATION_NUMBER VARCHAR2(10)
)
;
alter table EP_OPERATION
  add constraint EP_OPERATION_KEY primary key (ID);

prompt
prompt Creating table EP_OPERATION_LOG
prompt ===============================
prompt
create table EP_OPERATION_LOG
(
  ID                  VARCHAR2(31) not null,
  USER_ID             VARCHAR2(31),
  USER_LOGIN_NAME     VARCHAR2(100),
  USER_SESSION_ID     VARCHAR2(31),
  OPERATE_TIME        NUMBER(19),
  OPERATE_DESCRIPTION VARCHAR2(100),
  OPERATEOR_IP        VARCHAR2(30),
  INTERFACE_NAME      VARCHAR2(30)
)
;
comment on column EP_OPERATION_LOG.ID
  is '主键';
comment on column EP_OPERATION_LOG.USER_ID
  is '用户ID';
comment on column EP_OPERATION_LOG.USER_LOGIN_NAME
  is '用户登录名';
comment on column EP_OPERATION_LOG.USER_SESSION_ID
  is '用户Session';
comment on column EP_OPERATION_LOG.OPERATE_TIME
  is '操作时间';
comment on column EP_OPERATION_LOG.OPERATE_DESCRIPTION
  is '操作描述';
comment on column EP_OPERATION_LOG.OPERATEOR_IP
  is '操作员IP';
comment on column EP_OPERATION_LOG.INTERFACE_NAME
  is '所调用的接口';
alter table EP_OPERATION_LOG
  add constraint EP_OPERATION_LOG_PK primary key (ID);

prompt
prompt Creating table EP_PRESET
prompt ========================
prompt
create table EP_PRESET
(
  ID            VARCHAR2(31) not null,
  NAME          VARCHAR2(255) not null,
  PRESET_NUMBER NUMBER(4) not null,
  VIC_ID        VARCHAR2(31) not null,
  NOTE          VARCHAR2(1000),
  TYPE          NUMBER(16),
  SET_FLAG      INTEGER not null
)
;
comment on table EP_PRESET
  is '预置点';
comment on column EP_PRESET.NAME
  is '预置点的名称';
comment on column EP_PRESET.PRESET_NUMBER
  is '摄像头预置点位编号（0为默认预置点）';
comment on column EP_PRESET.VIC_ID
  is '摄像头ID,对应全球眼VIDEO_INPUT_CHANNEL表';
comment on column EP_PRESET.NOTE
  is '备注';
comment on column EP_PRESET.SET_FLAG
  is '是否在摄像头设置过(1：设置过 0：没有)';
alter table EP_PRESET
  add primary key (ID);

prompt
prompt Creating table EP_PROBER
prompt ========================
prompt
create table EP_PROBER
(
  ID                VARCHAR2(31) not null,
  CONTROL_SERVER_ID VARCHAR2(31),
  EP_PROBER_TYPE_ID VARCHAR2(31) not null,
  CHANNEL_NUMBER    NUMBER(4),
  SCHEME            VARCHAR2(2000),
  NAME              VARCHAR2(255),
  NOTE              VARCHAR2(1000),
  MAX_LIMIT         NUMBER(8),
  MIN_LIMIT         NUMBER(8),
  CYCLE             NUMBER(20),
  ADDRESS           VARCHAR2(200),
  LENGTH            VARCHAR2(100),
  IS_WARN           NUMBER(8),
  BOOL_WARN         NUMBER(8),
  DATA_TYPE         VARCHAR2(255),
  POSITION          VARCHAR2(200),
  REGISTER_REVERSE  NUMBER(8),
  PLC_IO_SAVE_CYCLE NUMBER(8),
  PLC_IO_SAVE_TYPE  VARCHAR2(255),
  PLC_IO_TYPE       VARCHAR2(255),
  ORGAN_ID          VARCHAR2(32)
)
;
comment on table EP_PROBER
  is '探测器';
comment on column EP_PROBER.CONTROL_SERVER_ID
  is '控制器ID';
comment on column EP_PROBER.EP_PROBER_TYPE_ID
  is '探测器类型ID';
comment on column EP_PROBER.CHANNEL_NUMBER
  is '所在控制器的通道号';
comment on column EP_PROBER.SCHEME
  is '所关联的预案';
comment on column EP_PROBER.NAME
  is '探测器名称';
comment on column EP_PROBER.MAX_LIMIT
  is '阀值大';
comment on column EP_PROBER.MIN_LIMIT
  is '阀值小';
comment on column EP_PROBER.CYCLE
  is '采样频率';
comment on column EP_PROBER.ADDRESS
  is '寄存器起始地址';
comment on column EP_PROBER.IS_WARN
  is '是否报警';
comment on column EP_PROBER.BOOL_WARN
  is '开关量报警值';
comment on column EP_PROBER.DATA_TYPE
  is '数据类型';
comment on column EP_PROBER.POSITION
  is '安装地址';
comment on column EP_PROBER.REGISTER_REVERSE
  is '是否需要反转寄存器顺序';
comment on column EP_PROBER.PLC_IO_SAVE_CYCLE
  is '数据保存间隔，毫秒，<=0表示不保存';
comment on column EP_PROBER.PLC_IO_SAVE_TYPE
  is '数据保存方式:
"SaveAll",
"SaveChange",
"SaveWarn",
"SaveChangeAndWarn"';
comment on column EP_PROBER.PLC_IO_TYPE
  is '数据读取方式"Coils"
"InputDiscretes"
"HoldingRegisters"
"InputRegisters"，';
alter table EP_PROBER
  add primary key (ID);

prompt
prompt Creating table EP_PROBER_TYPE
prompt =============================
prompt
create table EP_PROBER_TYPE
(
  ID           VARCHAR2(31) not null,
  NAME         VARCHAR2(255) not null,
  TYPE         VARCHAR2(2) not null,
  DIGITAL_TYPE VARCHAR2(2)
)
;
comment on table EP_PROBER_TYPE
  is '探测器类型';
comment on column EP_PROBER_TYPE.NAME
  is '探测器类型名称';
comment on column EP_PROBER_TYPE.TYPE
  is '类型（1：开关量 2：模拟量）';
comment on column EP_PROBER_TYPE.DIGITAL_TYPE
  is '开关量类型(1：输入 2：输出)';
alter table EP_PROBER_TYPE
  add primary key (ID);

prompt
prompt Creating table EP_ROLE
prompt ======================
prompt
create table EP_ROLE
(
  ID               VARCHAR2(31) not null,
  NAME             VARCHAR2(50) not null,
  NOTE             VARCHAR2(100),
  ORGAN_ID         VARCHAR2(31) not null,
  IS_SUSPENDED     NUMBER default 0,
  CREATE_USER_NAME VARCHAR2(500) not null,
  TYPE             NUMBER default 2 not null
)
;
comment on table EP_ROLE
  is '用户角色';
comment on column EP_ROLE.NAME
  is '角色名称';
comment on column EP_ROLE.NOTE
  is '备注';
comment on column EP_ROLE.IS_SUSPENDED
  is '是否停用: 0:停用 1:不停用';
comment on column EP_ROLE.TYPE
  is '1:系统生成 2:用户创建';
alter table EP_ROLE
  add constraint EP_ROLE_ID primary key (ID);

prompt
prompt Creating table EP_R_ASSETS_VIC
prompt ==============================
prompt
create table EP_R_ASSETS_VIC
(
  ID        VARCHAR2(31) not null,
  ASSETS_ID VARCHAR2(31) not null,
  VIC_ID    VARCHAR2(31) not null
)
;
alter table EP_R_ASSETS_VIC
  add constraint EP_ASSETS_VIC_PK primary key (ID);

prompt
prompt Creating table EP_R_DEVICE_VIC
prompt ==============================
prompt
create table EP_R_DEVICE_VIC
(
  DEVICE_ID  VARCHAR2(31) not null,
  VIC_ID     VARCHAR2(31) not null,
  PRESET_ID  VARCHAR2(31) not null,
  TASK_TYPE  NUMBER not null,
  STEP_ID    VARCHAR2(31),
  IS_DEFAULT NUMBER(1)
)
;
comment on table EP_R_DEVICE_VIC
  is '电力设备和摄像头关系表';
comment on column EP_R_DEVICE_VIC.DEVICE_ID
  is '电力设备ID';
comment on column EP_R_DEVICE_VIC.VIC_ID
  is '摄像头ID，对应全球眼VIDEO_INPUT_CHANNEL表';
comment on column EP_R_DEVICE_VIC.PRESET_ID
  is '预置点ID';
comment on column EP_R_DEVICE_VIC.TASK_TYPE
  is '0、未使用、1、浏览 2、巡视 3、倒闸';
comment on column EP_R_DEVICE_VIC.STEP_ID
  is '任务步骤ID';
comment on column EP_R_DEVICE_VIC.IS_DEFAULT
  is '是否默认预置点(只有设备浏览时用，1代表是)';

prompt
prompt Creating table EP_R_DOOR_VIC
prompt ============================
prompt
create table EP_R_DOOR_VIC
(
  ID        CHAR(31) not null,
  DOOR_ID   CHAR(31),
  VIC_ID    CHAR(31),
  PRESET_ID CHAR(31)
)
;
alter table EP_R_DOOR_VIC
  add constraint EP_R_DOOR_VIC_PK primary key (ID);

prompt
prompt Creating table EP_R_MAP_DEVICE
prompt ==============================
prompt
create table EP_R_MAP_DEVICE
(
  EP_MAP_ID    VARCHAR2(31) not null,
  DEVICE_ID    VARCHAR2(31) not null,
  DEVICE_TYPE  NUMBER(2) not null,
  COORDINATE_X VARCHAR2(32),
  COORDINATE_Y VARCHAR2(32),
  LEFT         VARCHAR2(32),
  RIGHT        VARCHAR2(32),
  TOP          VARCHAR2(32),
  BOTTOM       VARCHAR2(32),
  ID           VARCHAR2(31) not null
)
;
comment on table EP_R_MAP_DEVICE
  is '地图和设备关系';
comment on column EP_R_MAP_DEVICE.EP_MAP_ID
  is '地图ID';
comment on column EP_R_MAP_DEVICE.DEVICE_ID
  is '设备ID';
comment on column EP_R_MAP_DEVICE.DEVICE_TYPE
  is '设备类型(1:摄像头2:电力设备)';
comment on column EP_R_MAP_DEVICE.COORDINATE_X
  is '设备在图片上的横坐标';
comment on column EP_R_MAP_DEVICE.COORDINATE_Y
  is '设备在图片上的纵坐标';
comment on column EP_R_MAP_DEVICE.LEFT
  is '设备在图片上的左边位置';
comment on column EP_R_MAP_DEVICE.RIGHT
  is '设备在图片上的右边位置';
comment on column EP_R_MAP_DEVICE.TOP
  is '设备在图片上的高位置';
comment on column EP_R_MAP_DEVICE.BOTTOM
  is '设备在图片上的低位置';
alter table EP_R_MAP_DEVICE
  add constraint EP_R_MAP_DEVICE_PK primary key (ID);

prompt
prompt Creating table EP_R_MONITOR_DEVICE
prompt ==================================
prompt
create table EP_R_MONITOR_DEVICE
(
  ID           VARCHAR2(31) not null,
  MONITOR_ID   VARCHAR2(31) not null,
  DEVICE_ID    VARCHAR2(31) not null,
  MONITOR_TYPE NUMBER not null,
  DEVICE_TYPE  NUMBER not null
)
;
comment on column EP_R_MONITOR_DEVICE.MONITOR_TYPE
  is '1:摄像头 2:探测器';
comment on column EP_R_MONITOR_DEVICE.DEVICE_TYPE
  is '1:资产 2 输电线 3智能检测设备4功能区5其他';
alter table EP_R_MONITOR_DEVICE
  add constraint EP_R_MONITOR_DEVICE_PK primary key (ID);

prompt
prompt Creating table EP_R_PROBER_VIC
prompt ==============================
prompt
create table EP_R_PROBER_VIC
(
  ID        VARCHAR2(31) not null,
  VIC_ID    VARCHAR2(31) not null,
  PROBER_ID VARCHAR2(31) not null,
  PRESET_ID VARCHAR2(31)
)
;
alter table EP_R_PROBER_VIC
  add constraint EP_R_PROBER_VIC_PK primary key (ID);

prompt
prompt Creating table EP_R_ROLE_OPERATION
prompt ==================================
prompt
create table EP_R_ROLE_OPERATION
(
  ID           VARCHAR2(31) not null,
  ROLE_ID      VARCHAR2(31) not null,
  OPERATION_ID VARCHAR2(31) not null
)
;
alter table EP_R_ROLE_OPERATION
  add constraint EP_R_ROLE_OPERATION_PK primary key (ID);

prompt
prompt Creating table EP_R_ROLE_RESOURCE
prompt =================================
prompt
create table EP_R_ROLE_RESOURCE
(
  ID                VARCHAR2(31) not null,
  ROLE_ID           VARCHAR2(31) not null,
  RESOURCE_ID       VARCHAR2(31) not null,
  RESOURCE_TYPE     VARCHAR2(31) not null,
  RESOURCE_ORGAN_ID VARCHAR2(31) not null
)
;
alter table EP_R_ROLE_RESOURCE
  add constraint EP_R_ROLE_RESOURCE_PK primary key (ID);

prompt
prompt Creating table EP_R_SCHEME_ALARM_SOURCE
prompt =======================================
prompt
create table EP_R_SCHEME_ALARM_SOURCE
(
  EP_SCHEME_ID VARCHAR2(31) not null,
  SOURCE_ID    VARCHAR2(31) not null,
  SOURCE_TYPE  VARCHAR2(255) not null,
  ALARM_TYPE   VARCHAR2(64) default '2' not null,
  ID           VARCHAR2(31) not null
)
;
comment on table EP_R_SCHEME_ALARM_SOURCE
  is '预案与触发预案的报警源关联表';
comment on column EP_R_SCHEME_ALARM_SOURCE.EP_SCHEME_ID
  is '预案ID';
comment on column EP_R_SCHEME_ALARM_SOURCE.SOURCE_ID
  is '报警源ID';
comment on column EP_R_SCHEME_ALARM_SOURCE.SOURCE_TYPE
  is '报警源类型';
comment on column EP_R_SCHEME_ALARM_SOURCE.ALARM_TYPE
  is '事件类型。根据事件类型绑定设备的不同预案';
alter table EP_R_SCHEME_ALARM_SOURCE
  add constraint EP_R_SCHEME_ALARM_SOURCE_PK primary key (ID);

prompt
prompt Creating table EP_R_TASKSTEP_MONITOR
prompt ====================================
prompt
create table EP_R_TASKSTEP_MONITOR
(
  ID           VARCHAR2(31) not null,
  STEP_ID      VARCHAR2(31) not null,
  MONITOR_ID   VARCHAR2(31) not null,
  MONITOR_TYPE NUMBER not null,
  TASK_ID      VARCHAR2(31) not null,
  PRESET_ID    VARCHAR2(31)
)
;
alter table EP_R_TASKSTEP_MONITOR
  add constraint EP_R_TASKSTEP_MONITOR_PK primary key (ID);

prompt
prompt Creating table EP_R_TASK_EMPLOYEE
prompt =================================
prompt
create table EP_R_TASK_EMPLOYEE
(
  ID                VARCHAR2(31) not null,
  TASK_ID           VARCHAR2(31) not null,
  EMPLOYEE_ID       VARCHAR2(31) not null,
  USER_ID           VARCHAR2(31),
  ALLOT_USER_ID     VARCHAR2(31) not null,
  EXECUTE_TIME      VARCHAR2(50) not null,
  EXECUTE_TIME_TYPE NUMBER,
  TASK_TYPE         NUMBER not null,
  SUPPORT_EMPLOYEE  VARCHAR2(2000)
)
;
alter table EP_R_TASK_EMPLOYEE
  add constraint EP_R_TASK_EMPLOYEE_PK primary key (ID);

prompt
prompt Creating table EP_R_TRACK_PRESET
prompt ================================
prompt
create table EP_R_TRACK_PRESET
(
  TRACK_ID  VARCHAR2(31) not null,
  PRESET_ID VARCHAR2(31) not null,
  SEQ       NUMBER(8),
  DURATION  VARCHAR2(16)
)
;
comment on table EP_R_TRACK_PRESET
  is '巡航与预置点关联表';
comment on column EP_R_TRACK_PRESET.TRACK_ID
  is '巡航ID';
comment on column EP_R_TRACK_PRESET.PRESET_ID
  is '预置点ID';
comment on column EP_R_TRACK_PRESET.SEQ
  is '巡航中当前预置点所在的运动序列编号，从1开始，越小的越先执行';
comment on column EP_R_TRACK_PRESET.DURATION
  is '当前预置点位持续时间';

prompt
prompt Creating table EP_R_USER_ROLE
prompt =============================
prompt
create table EP_R_USER_ROLE
(
  ID      VARCHAR2(31) not null,
  USER_ID VARCHAR2(31) not null,
  ROLE_ID VARCHAR2(31) not null
)
;
comment on table EP_R_USER_ROLE
  is '用户与用户角色的关联表';
comment on column EP_R_USER_ROLE.USER_ID
  is '用户ID';
comment on column EP_R_USER_ROLE.ROLE_ID
  is '角色ID';
alter table EP_R_USER_ROLE
  add constraint EP_R_USER_ROLE_ID primary key (ID);

prompt
prompt Creating table EP_SCHEME
prompt ========================
prompt
create table EP_SCHEME
(
  ID               VARCHAR2(31) not null,
  NAME             VARCHAR2(255),
  ORGAN_ID         VARCHAR2(31),
  NOTE             VARCHAR2(255),
  TYPE             VARCHAR2(32) default 'alarm',
  LAST_UPDATE_TIME NUMBER(16)
)
;
comment on table EP_SCHEME
  is '预案基础定义表';
comment on column EP_SCHEME.NAME
  is '预案名称';
comment on column EP_SCHEME.ORGAN_ID
  is '预案创建人所属机构';
alter table EP_SCHEME
  add primary key (ID);

prompt
prompt Creating table EP_SCHEME_COMMAND
prompt ================================
prompt
create table EP_SCHEME_COMMAND
(
  ID           VARCHAR2(31) not null,
  EP_SCHEME_ID VARCHAR2(31) not null,
  TARGET_ID    VARCHAR2(31) not null,
  TARGET_TYPE  VARCHAR2(255) not null,
  VALUE        VARCHAR2(4000),
  DURATION     VARCHAR2(16),
  SEQ          NUMBER(8)
)
;
comment on table EP_SCHEME_COMMAND
  is '预案指令表';
comment on column EP_SCHEME_COMMAND.EP_SCHEME_ID
  is '指令所属预案ID';
comment on column EP_SCHEME_COMMAND.TARGET_ID
  is '目标ID（摄像头ID，预置点ID等）';
comment on column EP_SCHEME_COMMAND.TARGET_TYPE
  is '目标类型';
comment on column EP_SCHEME_COMMAND.VALUE
  is '对应改变目标的数值，不需要改变值的时候为空';
comment on column EP_SCHEME_COMMAND.DURATION
  is '持续时间，单位秒';
comment on column EP_SCHEME_COMMAND.SEQ
  is '指令顺序编号，从1开始，越小越先执行';
alter table EP_SCHEME_COMMAND
  add primary key (ID);

prompt
prompt Creating table EP_TASK
prompt ======================
prompt
create table EP_TASK
(
  ID          VARCHAR2(31) not null,
  NAME        VARCHAR2(255) not null,
  ORGAN_ID    VARCHAR2(31) not null,
  TYPE        INTEGER not null,
  NOTE        VARCHAR2(1000),
  CREATE_TIME NUMBER not null,
  BRANCH_ID   VARCHAR2(31)
)
;
alter table EP_TASK
  add primary key (ID);
alter table EP_TASK
  add unique (NAME);

prompt
prompt Creating table EP_TASK_HISTORY
prompt ==============================
prompt
create table EP_TASK_HISTORY
(
  ID                VARCHAR2(31) not null,
  TASK_ID           VARCHAR2(31) not null,
  TASK_NAME         VARCHAR2(100) not null,
  ORGAN_NAME        VARCHAR2(31),
  TYPE              NUMBER not null,
  NOTE              VARCHAR2(500),
  BRANCH_NAME       VARCHAR2(31),
  EMPLOYEE_NAME     VARCHAR2(31) not null,
  USER_ID           VARCHAR2(31),
  ALLOT_USER_ID     VARCHAR2(500),
  EXECUTE_TIME      VARCHAR2(50) not null,
  EXECUTE_TIME_TYPE NUMBER not null,
  TASK_TYPE         NUMBER not null,
  RESULT            VARCHAR2(2000),
  END_TIME          VARCHAR2(50),
  EMPLOYEE_ID       VARCHAR2(31),
  SUPPORT_EMPLOYEE  VARCHAR2(2000)
)
;
comment on column EP_TASK_HISTORY.RESULT
  is '处理意见';
comment on column EP_TASK_HISTORY.END_TIME
  is '系统生成当前时间';
alter table EP_TASK_HISTORY
  add constraint EP_TASK_HISTORY_PK primary key (ID);

prompt
prompt Creating table EP_TASK_INSPECTION
prompt =================================
prompt
create table EP_TASK_INSPECTION
(
  ITEM     VARCHAR2(200) not null,
  STANDARD VARCHAR2(500) not null,
  TYPE     VARCHAR2(200) not null,
  SEQ      NUMBER,
  ID       VARCHAR2(31)
)
;

prompt
prompt Creating table EP_TASK_STEP
prompt ===========================
prompt
create table EP_TASK_STEP
(
  ID          VARCHAR2(31) not null,
  NAME        VARCHAR2(2000) not null,
  SEQ         NUMBER(8) not null,
  TASK_ID     VARCHAR2(31) not null,
  NOTE        VARCHAR2(1000),
  DEVICE_TYPE VARCHAR2(255)
)
;
comment on table EP_TASK_STEP
  is '电力任务步骤定义';
comment on column EP_TASK_STEP.NAME
  is '电力任务步骤的名称';
comment on column EP_TASK_STEP.SEQ
  is '该步骤在整个任务中的序号';
comment on column EP_TASK_STEP.TASK_ID
  is '所属任务ID';
alter table EP_TASK_STEP
  add primary key (ID);

prompt
prompt Creating table EP_TASK_STEP_HISTORY
prompt ===================================
prompt
create table EP_TASK_STEP_HISTORY
(
  ID              VARCHAR2(31) not null,
  HISTORY_TASK_ID VARCHAR2(31) not null,
  SEQ             NUMBER,
  STEP_NAME       VARCHAR2(500),
  STEP_NOTE       VARCHAR2(500),
  DEVICE_TYPE     VARCHAR2(500),
  RESULT          VARCHAR2(500),
  STEP_ID         VARCHAR2(31) not null,
  STEP_CAPTURE_ID VARCHAR2(1000)
)
;
alter table EP_TASK_STEP_HISTORY
  add constraint EP_TASK_STEP_HISTORY_PK primary key (ID);

prompt
prompt Creating table EP_TRACK
prompt =======================
prompt
create table EP_TRACK
(
  ID   VARCHAR2(31) not null,
  NAME VARCHAR2(255),
  NOTE VARCHAR2(255)
)
;
comment on table EP_TRACK
  is '巡航（预置点轨迹）表';
alter table EP_TRACK
  add primary key (ID);

prompt
prompt Creating table MANUFACTURER
prompt ===========================
prompt
create table MANUFACTURER
(
  ID                  VARCHAR2(31) not null,
  OPTIMISTIC_LOCK     NUMBER(19) not null,
  F_NAME              VARCHAR2(255) not null,
  NOTE                VARCHAR2(255),
  CONTACT_INFORMATION VARCHAR2(30),
  LINKMAN             VARCHAR2(255)
)
;
alter table MANUFACTURER
  add primary key (ID);

prompt
prompt Creating table VIDEO_INPUT_CHANNEL_MODEL
prompt ========================================
prompt
create table VIDEO_INPUT_CHANNEL_MODEL
(
  ID               VARCHAR2(31) not null,
  OPTIMISTIC_LOCK  NUMBER(19) not null,
  MANUFACTURER_ID  VARCHAR2(31) not null,
  F_NAME           VARCHAR2(255) not null,
  HAS_PTZ          NUMBER(1) not null,
  HAS_PTZ_APERTURE NUMBER(1) not null,
  HAS_PTZ_FOCI     NUMBER(1) not null,
  HAS_PTZ_ZOOM     NUMBER(1) not null,
  HAS_PTZ_ASW_1    NUMBER(1) not null,
  HAS_PTZ_ASW_2    NUMBER(1) not null,
  HAS_PTZ_ASW_3    NUMBER(1) not null,
  HAS_PTZ_ASW_4    NUMBER(1) not null,
  HAS_PTZ_AUTO     NUMBER(1) not null,
  HAS_SENSE        NUMBER(1) not null,
  HAS_SHELTER      NUMBER(1) not null,
  HAS_TIME_LABEL   NUMBER(1) not null,
  HAS_TEXT_LABEL   NUMBER(1) not null,
  NOTE             VARCHAR2(255)
)
;
alter table VIDEO_INPUT_CHANNEL_MODEL
  add primary key (ID);
alter table VIDEO_INPUT_CHANNEL_MODEL
  add constraint FK601566F45B838449 foreign key (MANUFACTURER_ID)
  references MANUFACTURER (ID);

prompt
prompt Creating table STORAGE_SERVER
prompt =============================
prompt
create table STORAGE_SERVER
(
  ID                VARCHAR2(31) not null,
  OPTIMISTIC_LOCK   NUMBER(19) not null,
  F_NAME            VARCHAR2(255),
  NAMING            VARCHAR2(255),
  INSTALL_LOCATION  VARCHAR2(255),
  NOTE              VARCHAR2(255),
  DEVICE_NUMBER     VARCHAR2(255) not null,
  IP                VARCHAR2(255),
  LINK_TYPE         VARCHAR2(255),
  HEART_CYCLE       NUMBER(10),
  MAX_OUTPUT_AMOUNT NUMBER(10),
  MAX_INPUT_AMOUNT  NUMBER(10),
  FTP_PORT          NUMBER(10),
  FTP_USER_NAME     VARCHAR2(255),
  FTP_PASSWORD      VARCHAR2(255),
  IP2               VARCHAR2(255),
  MESSAGE_PORT      NUMBER(10) default 4196,
  STD_ID            VARCHAR2(32),
  IS_VIRTUAL_IP     NUMBER default 0
)
;
alter table STORAGE_SERVER
  add primary key (ID);
alter table STORAGE_SERVER
  add unique (DEVICE_NUMBER);

prompt
prompt Creating table REMOTE_STORAGE_SERVER
prompt ====================================
prompt
create table REMOTE_STORAGE_SERVER
(
  STORAGE_SERVER_ID VARCHAR2(31) not null,
  O_ORGAN_ID        VARCHAR2(31),
  HAS_VOD           NUMBER(1) default 0
)
;
comment on column REMOTE_STORAGE_SERVER.HAS_VOD
  is '是否支持视频点播: 0 不支持,1 支持';
alter table REMOTE_STORAGE_SERVER
  add primary key (STORAGE_SERVER_ID);
alter table REMOTE_STORAGE_SERVER
  add constraint FK_SUPER_R_SS foreign key (STORAGE_SERVER_ID)
  references STORAGE_SERVER (ID);

prompt
prompt Creating table VIDEO_INPUT_CHANNEL
prompt ==================================
prompt
create table VIDEO_INPUT_CHANNEL
(
  ID                           VARCHAR2(31) not null,
  OPTIMISTIC_LOCK              NUMBER(19) not null,
  F_NAME                       VARCHAR2(255),
  NAMING                       VARCHAR2(255),
  INSTALL_LOCATION             VARCHAR2(255),
  NOTE                         VARCHAR2(255),
  HAS_PAN                      NUMBER(1),
  PTZ_DECODE_TYPE              VARCHAR2(255),
  VIDEO_FORMAT                 VARCHAR2(255),
  STORE_CYCLE                  NUMBER(10),
  STORE_PLAN_HOUR_FLAG         VARCHAR2(1000),
  FRAME_RATE                   NUMBER(10),
  MAX_BPS                      NUMBER(10),
  BRIGHTNESS                   NUMBER(10),
  HUE                          NUMBER(10),
  CONTRAST                     NUMBER(10),
  SATURATION                   NUMBER(10),
  VIDEO_INPUT_CHANNEL_MODEL_ID VARCHAR2(31) not null,
  VIDEO_INPUT_SERVER_ID        VARCHAR2(31) not null,
  IMAGE_QUALITY_LEVEL_ID       VARCHAR2(31),
  DISPATCH_SERVER_ID           VARCHAR2(31),
  REMOTE_STORAGE_SERVER_ID     VARCHAR2(31),
  ORGAN_ID                     VARCHAR2(31),
  DEVICE_PHYSICAL_RELATION_ID  VARCHAR2(31),
  IS_SUSPENDED                 NUMBER(1) default 0,
  STD_ID                       VARCHAR2(31),
  IS_SUPPORT_SCHEME            NUMBER(1) default 0,
  PRE_RECORD_TIME              NUMBER(4) default 120,
  REMOTE_STORE_PLAN_HOUR_FLAG  VARCHAR2(1000),
  STORE_TYPE                   NUMBER(2) default 0,
  PATH                         VARCHAR2(500),
  LONGITUDE                    VARCHAR2(16) default 0,
  LATITUDE                     VARCHAR2(16) default 0,
  PULL_MODE                    NUMBER default 0,
  IS_SHARE                     NUMBER(5) default 0,
  CHANNEL_ID                   NUMBER(2) default 1,
  OVER_WRITE_FLAG              NUMBER default 1,
  LOCAL_STORE_CYCLE            NUMBER(9) default 0,
  SCHEME_TYPE                  NUMBER(1) default 1,
  LOCAL_SCHEME_TYPE            NUMBER(1) default 1,
  STREAM_TYPE                  NUMBER(1) default 0,
  ALARM_STORAGE_SERVER_ID      VARCHAR2(31)
)
;
comment on column VIDEO_INPUT_CHANNEL.PULL_MODE
  is '中心存储的历史视频的获取方式,1:中心存储主动 0:中心存储被动';
comment on column VIDEO_INPUT_CHANNEL.IS_SHARE
  is '摄像头是否公享: 0 不公享,1 公享';
comment on column VIDEO_INPUT_CHANNEL.SCHEME_TYPE
  is '远程存储方式0:天 1:周 2:月';
comment on column VIDEO_INPUT_CHANNEL.LOCAL_SCHEME_TYPE
  is '本地存储方式0:天 1:周 2:月';
comment on column VIDEO_INPUT_CHANNEL.STREAM_TYPE
  is '码流类型:0:Normal 1:CDMA1x 2:EVDO 3:WIFI';
alter table VIDEO_INPUT_CHANNEL
  add primary key (ID);
alter table VIDEO_INPUT_CHANNEL
  add constraint FK737C786A235B895E foreign key (VIDEO_INPUT_SERVER_ID)
  references VIDEO_INPUT_SERVER (ID);
alter table VIDEO_INPUT_CHANNEL
  add constraint FK737C786A2FC03E12 foreign key (DISPATCH_SERVER_ID)
  references DISPATCH_SERVER (ID);
alter table VIDEO_INPUT_CHANNEL
  add constraint FK737C786A5A993246 foreign key (VIDEO_INPUT_CHANNEL_MODEL_ID)
  references VIDEO_INPUT_CHANNEL_MODEL (ID);
alter table VIDEO_INPUT_CHANNEL
  add constraint FK737C786A7D1CC229 foreign key (ORGAN_ID)
  references ORGAN (ID)
  disable;
alter table VIDEO_INPUT_CHANNEL
  add constraint FK737C786AC6E742FA foreign key (REMOTE_STORAGE_SERVER_ID)
  references REMOTE_STORAGE_SERVER (STORAGE_SERVER_ID);

prompt
prompt Creating table GENERAL_CAMERA_VIC
prompt =================================
prompt
create table GENERAL_CAMERA_VIC
(
  VIDEO_INPUT_CHANNEL_ID VARCHAR2(31) not null,
  ADDRESS_NUMBER         VARCHAR2(255) not null
)
;
alter table GENERAL_CAMERA_VIC
  add primary key (VIDEO_INPUT_CHANNEL_ID);
alter table GENERAL_CAMERA_VIC
  add constraint FK_SUPER_GC_VIC foreign key (VIDEO_INPUT_CHANNEL_ID)
  references VIDEO_INPUT_CHANNEL (ID);

prompt
prompt Creating table GENERAL_CAMERA_VIS
prompt =================================
prompt
create table GENERAL_CAMERA_VIS
(
  VIDEO_INPUT_SERVER_ID VARCHAR2(31) not null
)
;
alter table GENERAL_CAMERA_VIS
  add primary key (VIDEO_INPUT_SERVER_ID);
alter table GENERAL_CAMERA_VIS
  add constraint FK_SUPER_GC_VIS foreign key (VIDEO_INPUT_SERVER_ID)
  references VIDEO_INPUT_SERVER (ID);

prompt
prompt Creating table INTELLIGENT_CHANNEL
prompt ==================================
prompt
create table INTELLIGENT_CHANNEL
(
  ID               VARCHAR2(31) not null,
  OPTIMISTIC_LOCK  NUMBER(19) not null,
  F_NAME           VARCHAR2(255),
  NAMING           VARCHAR2(255),
  INSTALL_LOCATION VARCHAR2(255),
  PARENT_ID        VARCHAR2(31),
  PARENT_TYPE      NUMBER(1),
  DESCRIPTION      VARCHAR2(255),
  NOTE             VARCHAR2(255),
  COMPANY          VARCHAR2(255),
  CHANNEL_ID       NUMBER(2)
)
;
comment on column INTELLIGENT_CHANNEL.PARENT_ID
  is '智能服务器ID或者视频服务器ID';
comment on column INTELLIGENT_CHANNEL.PARENT_TYPE
  is '父类型 0：附属于智能服务器  1：附属于视频服务器';
comment on column INTELLIGENT_CHANNEL.DESCRIPTION
  is '智能分析单元分析能力描述';
alter table INTELLIGENT_CHANNEL
  add primary key (ID);

prompt
prompt Creating table IP_CAMERA_VIC
prompt ============================
prompt
create table IP_CAMERA_VIC
(
  VIDEO_INPUT_CHANNEL_ID VARCHAR2(31) not null,
  HOST                   VARCHAR2(255) not null,
  PORT                   NUMBER(10) not null,
  PASSWORD               VARCHAR2(255) default 'e10adc3949ba59abbe56e057f20f883e',
  MOBILEPHONE1           VARCHAR2(20),
  MOBILEPHONE2           VARCHAR2(20),
  EMAIL                  VARCHAR2(50),
  DEVICE_TYPE            VARCHAR2(20),
  SD_SUPPORT             NUMBER(1) default 1
)
;
alter table IP_CAMERA_VIC
  add primary key (VIDEO_INPUT_CHANNEL_ID);
alter table IP_CAMERA_VIC
  add constraint FK_SUPER_IPC_VIC foreign key (VIDEO_INPUT_CHANNEL_ID)
  references VIDEO_INPUT_CHANNEL (ID);

prompt
prompt Creating table IP_CAMERA_VIS
prompt ============================
prompt
create table IP_CAMERA_VIS
(
  VIDEO_INPUT_SERVER_ID  VARCHAR2(31) not null,
  LOCAL_ALARM1_FLAG      NUMBER(1) default 1,
  LOCAL_ALARM2_FLAG      NUMBER(1) default 1,
  LOCAL_ALARM3_FLAG      NUMBER(1) default 1,
  LOCAL_TIMING_FLAG      NUMBER(1) default 1,
  LOCAL_TIMING_INTERVAL  NUMBER(11) default 0,
  LOCAL_SHOOTING_FLAG    NUMBER(1) default 1,
  SD_CACHE_FLAG          NUMBER(1) default 0,
  SD_RED_SAVE_FLAG       NUMBER(1) default 0,
  IS_DELETED             NUMBER(1) default 0,
  REMOTE_ALARM1_FLAG     NUMBER(1) default 0,
  REMOTE_ALARM2_FLAG     NUMBER(1) default 0,
  REMOTE_ALARM3_FLAG     NUMBER(1) default 0,
  REMOTE_TIMING_FLAG     NUMBER(1) default 0,
  REMOTE_TIMING_INTERVAL NUMBER(11) default 0,
  REMOTE_SHOOTING_FLAG   NUMBER(1) default 0,
  TOTAL_CAPACITY         NUMBER(11) default 0,
  USED_CAPACITY          NUMBER(11) default 0,
  REMAIN_CAPACITY        NUMBER(11) default 0,
  SD_CARD_EXIST_FLAG     NUMBER(1) default 0,
  LOW_CAPACITY_FLAG      NUMBER(1) default 0,
  STORE_CYCLE            NUMBER(11) default 0,
  OVERWRITE_FLAG         NUMBER(1) default 1,
  BACKUP_FLAG            NUMBER(1) default 0,
  CLEAN_FLAG             NUMBER(1) default 0,
  STORE_SIZE             VARCHAR2(20),
  BACKUP_PATH            VARCHAR2(50),
  BACKUP_TIME            VARCHAR2(10),
  BRIGHTNESS             NUMBER(11) default 50,
  CONTRAST               NUMBER(11) default 50,
  SATURATION             NUMBER(11) default 50,
  HUE                    NUMBER(11) default 50,
  FRAME_NUM              NUMBER(11) default 50,
  FRAME_INTERVAL         NUMBER(11) default 10,
  TRANSMISSION_SPEED     NUMBER(11) default 50,
  CAPTION                VARCHAR2(20),
  CAPTION_LOCATION       NUMBER(1) default 1,
  TIME_LOCATION          NUMBER(1) default 3,
  DEVICE_TYPE            VARCHAR2(20)
)
;
alter table IP_CAMERA_VIS
  add primary key (VIDEO_INPUT_SERVER_ID);
alter table IP_CAMERA_VIS
  add constraint FK_SUPER_IPC_VIS foreign key (VIDEO_INPUT_SERVER_ID)
  references VIDEO_INPUT_SERVER (ID);

prompt
prompt Creating table LOCAL_STORAGE_SERVER
prompt ===================================
prompt
create table LOCAL_STORAGE_SERVER
(
  STORAGE_SERVER_ID     VARCHAR2(31) not null,
  COMPANY_ID            VARCHAR2(31),
  VIDEO_INPUT_SERVER_ID VARCHAR2(31) not null,
  O_ORGAN_ID            VARCHAR2(31)
)
;
alter table LOCAL_STORAGE_SERVER
  add primary key (STORAGE_SERVER_ID);
alter table LOCAL_STORAGE_SERVER
  add unique (VIDEO_INPUT_SERVER_ID);
alter table LOCAL_STORAGE_SERVER
  add constraint FK_L_SS_VIS foreign key (VIDEO_INPUT_SERVER_ID)
  references VIDEO_INPUT_SERVER (ID);
alter table LOCAL_STORAGE_SERVER
  add constraint FK_SUPER_L_SS foreign key (STORAGE_SERVER_ID)
  references STORAGE_SERVER (ID);

prompt
prompt Creating table MEDIA_GATEWAY_SERVER
prompt ===================================
prompt
create table MEDIA_GATEWAY_SERVER
(
  ID               VARCHAR2(32) not null,
  DEVICE_NUMBER    VARCHAR2(20),
  LAN_IP           VARCHAR2(32),
  WAN_IP           VARCHAR2(32),
  MSG_PORT         NUMBER(6),
  HEARTBEAT_TIME   NUMBER(19),
  STATUS           NUMBER(2),
  INSTALL_LOCATION VARCHAR2(255),
  HEARTBEAT_CYCLE  NUMBER(8),
  NAME             VARCHAR2(200)
)
;
comment on table MEDIA_GATEWAY_SERVER
  is '互联媒体网关服务器';
comment on column MEDIA_GATEWAY_SERVER.DEVICE_NUMBER
  is '设备物理编号，唯一标识';
comment on column MEDIA_GATEWAY_SERVER.LAN_IP
  is '局域网IP';
comment on column MEDIA_GATEWAY_SERVER.WAN_IP
  is '广域网IP';
comment on column MEDIA_GATEWAY_SERVER.MSG_PORT
  is '内部协议监听端口';
comment on column MEDIA_GATEWAY_SERVER.HEARTBEAT_TIME
  is '心跳时间';
comment on column MEDIA_GATEWAY_SERVER.STATUS
  is '状态-1未注册，0下线，1上线';
comment on column MEDIA_GATEWAY_SERVER.INSTALL_LOCATION
  is '安装位置';
comment on column MEDIA_GATEWAY_SERVER.HEARTBEAT_CYCLE
  is '心跳间隔时间，单位秒';
alter table MEDIA_GATEWAY_SERVER
  add constraint MEDIA_GATEWAY_SERVER_ID primary key (ID);

prompt
prompt Creating table PLATFORM
prompt =======================
prompt
create table PLATFORM
(
  ID                           VARCHAR2(31) not null,
  OPTIMISTIC_LOCK              NUMBER(19) not null,
  F_NAME                       VARCHAR2(255),
  CMS_ID                       VARCHAR2(255) not null,
  LOCATION                     VARCHAR2(255),
  VERIFY                       VARCHAR2(255),
  NOTE                         VARCHAR2(255),
  PASSWORD                     VARCHAR2(60),
  USER_NOTIFY_SERVER_IP        VARCHAR2(15),
  USER_NOTIFY_SERVER_PORT      NUMBER default 8080,
  USER_NOTIFY_SERVER_URL       VARCHAR2(60),
  USER_NOTIFY_SERVER_LOGINNAME VARCHAR2(30),
  USER_NOTIFY_SERVER_PASSWORD  VARCHAR2(255),
  SMS_NOTIFY_TYPE              NUMBER(1) default 0,
  SP_CODE                      VARCHAR2(50),
  CDR_SERVER_IP                VARCHAR2(15),
  CDR_SERVER_PORT              NUMBER default 8080,
  HTTPS_FLAG                   NUMBER default 0,
  IS_CONN_AUTH_CENTER          NUMBER(2)
)
;
comment on column PLATFORM.PASSWORD
  is '平台操作密码';
alter table PLATFORM
  add primary key (ID);

prompt
prompt Creating table PLATFORM_RESOURCES
prompt =================================
prompt
create table PLATFORM_RESOURCES
(
  ID            VARCHAR2(31) not null,
  RESOURCE_ID   VARCHAR2(31) not null,
  NAME          VARCHAR2(255) not null,
  NAMING        VARCHAR2(255),
  SIP_CODE      VARCHAR2(32),
  ORGAN_ID      VARCHAR2(31),
  IS_SHARE      NUMBER(2),
  STATUS        NUMBER(2),
  LONGITUDE     VARCHAR2(16),
  LATITUDE      VARCHAR2(16),
  TYPE          VARCHAR2(32) not null,
  STANDARD_TYPE VARCHAR2(8) default '0'
)
;
comment on table PLATFORM_RESOURCES
  is '平台机构设备用户资源集合';
comment on column PLATFORM_RESOURCES.RESOURCE_ID
  is '机构，设备，用户在平台内部的ID';
comment on column PLATFORM_RESOURCES.NAME
  is '资源名称';
comment on column PLATFORM_RESOURCES.NAMING
  is '设备，用户Naming';
comment on column PLATFORM_RESOURCES.SIP_CODE
  is '18位SIP地址编码';
comment on column PLATFORM_RESOURCES.ORGAN_ID
  is '上级机构ID';
comment on column PLATFORM_RESOURCES.IS_SHARE
  is '是否共享给外平台';
comment on column PLATFORM_RESOURCES.STATUS
  is '状态0-不可用，1-可用';
comment on column PLATFORM_RESOURCES.LONGITUDE
  is '经度值';
comment on column PLATFORM_RESOURCES.LATITUDE
  is '纬度值';
comment on column PLATFORM_RESOURCES.TYPE
  is 'organ, user, vis, vic, aic, aoc, prober';
comment on column PLATFORM_RESOURCES.STANDARD_TYPE
  is '0表示全球眼设备,1表示国网标准接口B设备,2表示南方电网标准设备';
alter table PLATFORM_RESOURCES
  add constraint PLATFORM_RESOURCES_ID primary key (ID);

prompt
prompt Creating table PLATFORM_SUBSCRIBE
prompt =================================
prompt
create table PLATFORM_SUBSCRIBE
(
  ID            VARCHAR2(32) not null,
  PLATFORM_CODE VARCHAR2(32),
  CODE          VARCHAR2(32),
  UPDATE_TIME   NUMBER(16),
  EVENT         VARCHAR2(32),
  TYPE          VARCHAR2(32)
)
;
comment on table PLATFORM_SUBSCRIBE
  is '做为下级平台，异平台订阅关系';
comment on column PLATFORM_SUBSCRIBE.PLATFORM_CODE
  is '异平台18位平台地址编码';
comment on column PLATFORM_SUBSCRIBE.CODE
  is '本平台资源18位地址编码';
comment on column PLATFORM_SUBSCRIBE.UPDATE_TIME
  is '上次更新时间';
alter table PLATFORM_SUBSCRIBE
  add constraint PLATFORM_SUBSCRIBE_ID primary key (ID);

prompt
prompt Creating table RTP_PAYLOAD
prompt ==========================
prompt
create table RTP_PAYLOAD
(
  ID           VARCHAR2(32) not null,
  PAYLOAD      VARCHAR2(6) not null,
  ENCODE_NAME  VARCHAR2(128),
  FREQUENCY    NUMBER(8),
  BASE64       VARCHAR2(255),
  NOTE         VARCHAR2(255),
  FMTP_PUBLIC  VARCHAR2(255),
  FMTP_PRIVATE VARCHAR2(255)
)
;
comment on table RTP_PAYLOAD
  is 'rtp Payload信息，以及对应的视频解码头';
comment on column RTP_PAYLOAD.PAYLOAD
  is 'payload具体值：0-95按照IETF已定义的方式描述；110后需向标准归口单位申请';
comment on column RTP_PAYLOAD.ENCODE_NAME
  is '编码名称';
comment on column RTP_PAYLOAD.FREQUENCY
  is '时钟频率';
comment on column RTP_PAYLOAD.BASE64
  is 'base64编码的视频流第一个包，用于解码';
comment on column RTP_PAYLOAD.NOTE
  is '备注';
comment on column RTP_PAYLOAD.FMTP_PUBLIC
  is 'fmtp标准值';
comment on column RTP_PAYLOAD.FMTP_PRIVATE
  is 'fmtp私有值';
alter table RTP_PAYLOAD
  add constraint RTP_PAYLOAD_ID primary key (ID);
alter table RTP_PAYLOAD
  add constraint RTP_PAYLOAD_VALUE unique (PAYLOAD);

prompt
prompt Creating table R_AC_VIC
prompt =======================
prompt
create table R_AC_VIC
(
  VIC_ID            VARCHAR2(31),
  ACCESS_CONTROL_ID VARCHAR2(31)
)
;

prompt
prompt Creating table R_USER_ACCONTROL
prompt ===============================
prompt
create table R_USER_ACCONTROL
(
  USER_ID    VARCHAR2(31) not null,
  CONTROL_ID VARCHAR2(31) not null
)
;

prompt
prompt Creating table R_USER_VIS
prompt =========================
prompt
create table R_USER_VIS
(
  ID         VARCHAR2(32) not null,
  USERID     VARCHAR2(32) not null,
  VISID      VARCHAR2(32) not null,
  TYPE       INTEGER not null,
  PERMISSION VARCHAR2(32) not null
)
;
comment on column R_USER_VIS.ID
  is '主键';
comment on column R_USER_VIS.USERID
  is '用户ID';
comment on column R_USER_VIS.VISID
  is 'VISID';
comment on column R_USER_VIS.TYPE
  is '类型(0：不具有使用该vis，1：特殊权限 参见PERSSION字段)';
comment on column R_USER_VIS.PERMISSION
  is '权限字符串（0000000000000000：第一位代表实时视频，第二位代表历史视频，第三位代表云台和其设备参数设置 其他预留）（0:没有1：有）';
alter table R_USER_VIS
  add constraint R_USER_VIS_PK primary key (ID);

prompt
prompt Creating table SIP_SERVER
prompt =========================
prompt
create table SIP_SERVER
(
  ID                      VARCHAR2(32) not null,
  NAME                    VARCHAR2(255),
  LAN_IP                  VARCHAR2(32),
  HTTP_PORT               NUMBER(5),
  HEARTBEAT_TIME          NUMBER(19),
  DEVICE_NUMBER           VARCHAR2(20),
  REGISTER_TYPE           VARCHAR2(2),
  WAN_IP                  VARCHAR2(32),
  SIP_PORT                NUMBER(5),
  MEGA_PORT               NUMBER(5),
  EVENT_SERVER_ID         VARCHAR2(32),
  MEDIA_GATEWAY_SERVER_ID VARCHAR2(32)
)
;
comment on table SIP_SERVER
  is '信令网关';
comment on column SIP_SERVER.LAN_IP
  is '内网服务IP';
comment on column SIP_SERVER.HTTP_PORT
  is 'HTTP服务端口';
comment on column SIP_SERVER.REGISTER_TYPE
  is '注册类型，0-注册为内部接入模块，1-注册为对外信令模块';
comment on column SIP_SERVER.WAN_IP
  is '外网服务IP';
comment on column SIP_SERVER.SIP_PORT
  is '信令服务端口';
comment on column SIP_SERVER.MEGA_PORT
  is '内部megaeyes协议通信端口';
alter table SIP_SERVER
  add constraint SIP_SERVER_ID primary key (ID);

prompt
prompt Creating table STANDARD_ID
prompt ==========================
prompt
create table STANDARD_ID
(
  ID              VARCHAR2(31) not null,
  OPTIMISTIC_LOCK NUMBER(19) not null,
  VIS_NO          NUMBER(8) not null,
  IPVIS_NO        NUMBER(8) not null,
  VIC_NO          NUMBER(8) not null,
  CREATE_DATE     NUMBER(19),
  NOTE            VARCHAR2(255),
  USER_NO         NUMBER(9) default 1
)
;

prompt
prompt Creating table TEMP_RESOURCES
prompt =============================
prompt
create table TEMP_RESOURCES
(
  ID          VARCHAR2(31) not null,
  SIP_CODE    VARCHAR2(32),
  NAME        VARCHAR2(255),
  STATUS      NUMBER(2),
  DECODER_TAG VARCHAR2(255),
  LONGITUDE   VARCHAR2(16),
  LATITUDE    VARCHAR2(16),
  SUB_NUM     NUMBER(8),
  PARENT_CODE VARCHAR2(32),
  NAMING      VARCHAR2(255),
  DEVICE_TYPE VARCHAR2(8)
)
;
comment on table TEMP_RESOURCES
  is '外平台临时设备表';
comment on column TEMP_RESOURCES.SIP_CODE
  is '18位SIP地址编码';
comment on column TEMP_RESOURCES.NAME
  is '资源名称';
comment on column TEMP_RESOURCES.STATUS
  is '状态0-不可用，1-可用';
comment on column TEMP_RESOURCES.DECODER_TAG
  is '解码插件标签';
comment on column TEMP_RESOURCES.LONGITUDE
  is '经度值';
comment on column TEMP_RESOURCES.LATITUDE
  is '纬度值';
comment on column TEMP_RESOURCES.SUB_NUM
  is '包涵子节点数目';
comment on column TEMP_RESOURCES.PARENT_CODE
  is '父节点18位SIP地址编码';
comment on column TEMP_RESOURCES.NAMING
  is '平台为外平台资源生成的Naming';
comment on column TEMP_RESOURCES.DEVICE_TYPE
  is '资源类型。0-机构，1-摄像头，6-报警输入，7-报警输出';
alter table TEMP_RESOURCES
  add constraint TEMP_RESOURCE_ID primary key (ID);

prompt
prompt Creating table THIRD_PARTY_PLATFORM
prompt ===================================
prompt
create table THIRD_PARTY_PLATFORM
(
  ID             VARCHAR2(31) not null,
  SIP_CODE       VARCHAR2(32),
  STATUS         NUMBER(2),
  HTTP_URL       VARCHAR2(255),
  SIP_URL        VARCHAR2(255),
  NAME           VARCHAR2(255),
  HEARTBEAT_TIME NUMBER(16)
)
;
comment on table THIRD_PARTY_PLATFORM
  is '第三方平台表，通过第三方平台的上下线来更新';
comment on column THIRD_PARTY_PLATFORM.SIP_CODE
  is '平台18位SIP地址编码';
comment on column THIRD_PARTY_PLATFORM.STATUS
  is '状态0-下线，1-上线';
comment on column THIRD_PARTY_PLATFORM.HTTP_URL
  is 'HTTP服务地址';
comment on column THIRD_PARTY_PLATFORM.SIP_URL
  is 'SIP服务地址';
alter table THIRD_PARTY_PLATFORM
  add constraint THIRD_PARTY_PLATFORM_ID primary key (ID);

prompt
prompt Creating table T_USER
prompt =====================
prompt
create table T_USER
(
  ID                 VARCHAR2(31) not null,
  OPTIMISTIC_LOCK    NUMBER(19) not null,
  NOTE               VARCHAR2(255),
  ORGAN_ID           VARCHAR2(31) not null,
  LOGON_NAME         VARCHAR2(255) not null,
  F_PASSWORD         VARCHAR2(255) not null,
  F_NAME             VARCHAR2(255),
  NAMING             VARCHAR2(255),
  AGE                NUMBER(10),
  SEX                VARCHAR2(255),
  MOBILE             VARCHAR2(255),
  EMAIL              VARCHAR2(255),
  PHONE              VARCHAR2(255),
  IS_SUSPENDED       NUMBER(1) not null,
  SESSION_MAX_AMOUNT NUMBER(10) not null,
  BIND_SOFTDOG       NUMBER(1) default 0,
  CREATETIME         NUMBER(19) default 0,
  STD_ID             VARCHAR2(32),
  PRIORITY           NUMBER(2) default 1,
  MONITOR_ROLE       NUMBER default 0,
  PERMISSION_MODE    VARCHAR2(1),
  PERMISSION_CHANGE  NUMBER,
  EXPIRED_DAY        DATE default to_date('20200101','yyyymmdd'),
  BILL_MODE          NUMBER(2) default 0,
  DISPATCH_SERVER_ID VARCHAR2(60),
  USER_ACCOUNT       VARCHAR2(50),
  IS_PHONE_NOTIFY    NUMBER(1) default 0,
  IS_EMAIL_NOTIFY    NUMBER(1) default 0,
  SMS_SEND_RULE      VARCHAR2(1000),
  AUDIO_ID           VARCHAR2(30),
  AUDIO_SEND_RULE    VARCHAR2(1000),
  IS_AUDIO_NOTIFY    NUMBER(1) default 0,
  VIP                NUMBER(2) default 0,
  IS_MSP             NUMBER(2) default 0,
  BRANCH_ID          VARCHAR2(31),
  GRADE              NUMBER(10),
  POSITION           VARCHAR2(200),
  IS_BRANCH_MANAGE   NUMBER,
  ACCESS_SERVER_ID   VARCHAR2(31)
)
;
comment on column T_USER.EXPIRED_DAY
  is '帐号过期时间';
comment on column T_USER.BILL_MODE
  is '0 不需要付费 1  非套餐模式的后付费 2 	套餐模式的后付费 3  	套餐模式的预付费  4 包月后付费用';
alter table T_USER
  add primary key (ID);
alter table T_USER
  add constraint FK94B9B0D67D1CC229 foreign key (ORGAN_ID)
  references ORGAN (ID);

prompt
prompt Creating table USER_SESSION
prompt ===========================
prompt
create table USER_SESSION
(
  ID              VARCHAR2(31) not null,
  OPTIMISTIC_LOCK NUMBER(19) not null,
  LOGON_TIME      NUMBER(19) not null,
  HEARTBEAT_TIME  NUMBER(19),
  USER_ID         VARCHAR2(31) not null,
  IP              VARCHAR2(16),
  CLIENT_TYPE     VARCHAR2(8)
)
;
comment on column USER_SESSION.CLIENT_TYPE
  is '客户端类型。0-客户端，1-采集服务器';
alter table USER_SESSION
  add primary key (ID);
alter table USER_SESSION
  add constraint FK57849E022206F20F foreign key (USER_ID)
  references T_USER (ID);

prompt
prompt Creating table USER_SESSION_HISTORY
prompt ===================================
prompt
create table USER_SESSION_HISTORY
(
  ID              VARCHAR2(31) not null,
  OPTIMISTIC_LOCK NUMBER(19) not null,
  USER_SESSION_ID VARCHAR2(255) not null,
  LOGON_TIME      NUMBER(19) not null,
  LOGOFF_TIME     NUMBER(19) not null,
  USER_ID         VARCHAR2(255) not null
)
;
alter table USER_SESSION_HISTORY
  add primary key (ID);
alter table USER_SESSION_HISTORY
  add unique (USER_SESSION_ID)
  disable;

prompt
prompt Creating table USER_SUBSCRIBE
prompt =============================
prompt
create table USER_SUBSCRIBE
(
  ID            VARCHAR2(32) not null,
  USER_ID       VARCHAR2(32),
  CODE          VARCHAR2(32),
  UPDATE_TIME   NUMBER(16),
  EVENT         VARCHAR2(32),
  TYPE          VARCHAR2(32),
  PLATFORM_CODE VARCHAR2(32)
)
;
comment on table USER_SUBSCRIBE
  is '做为上级平台的用户订阅关系';
comment on column USER_SUBSCRIBE.USER_ID
  is '用户31位ID';
comment on column USER_SUBSCRIBE.CODE
  is '外平台资源18位地址编码';
comment on column USER_SUBSCRIBE.UPDATE_TIME
  is '上次更新时间';
comment on column USER_SUBSCRIBE.EVENT
  is '事件类型，alarm或event';
comment on column USER_SUBSCRIBE.TYPE
  is '订阅的具体事件类型，32位int';
comment on column USER_SUBSCRIBE.PLATFORM_CODE
  is '订阅的平台18位地址编码';
alter table USER_SUBSCRIBE
  add constraint USER_SUBSCRIBE_ID primary key (ID);

prompt
prompt Creating table VIDEO_DISPLAY_DEVICE
prompt ===================================
prompt
create table VIDEO_DISPLAY_DEVICE
(
  ID                  VARCHAR2(31) not null,
  OPTIMISTIC_LOCK     NUMBER(19) not null,
  F_NAME              VARCHAR2(255),
  NAMING              VARCHAR2(255),
  INSTALL_LOCATION    VARCHAR2(255),
  NOTE                VARCHAR2(255),
  DEVICE_NUMBER       VARCHAR2(255) not null,
  IP                  VARCHAR2(255),
  LINK_TYPE           VARCHAR2(255),
  HEART_CYCLE         NUMBER(10),
  REBOOT_TIME         VARCHAR2(255),
  REBOOT_CYCLE        NUMBER(10),
  VIDEO_INTPUT_AMOUNT NUMBER(10),
  VIDEO_OUTPUT_AMOUNT NUMBER(10),
  COMPANY_ID          VARCHAR2(31),
  O_ORGAN_ID          VARCHAR2(31)
)
;
alter table VIDEO_DISPLAY_DEVICE
  add primary key (ID);
alter table VIDEO_DISPLAY_DEVICE
  add unique (DEVICE_NUMBER);
alter table VIDEO_DISPLAY_DEVICE
  add constraint FKC92800F7EA63EC3D foreign key (COMPANY_ID)
  references COMPANY (ORGAN_ID)
  disable;

prompt
prompt Creating table VIDEO_OUTPUT_CHANNEL_MODEL
prompt =========================================
prompt
create table VIDEO_OUTPUT_CHANNEL_MODEL
(
  ID              VARCHAR2(31) not null,
  OPTIMISTIC_LOCK NUMBER(19) not null,
  MANUFACTURER_ID VARCHAR2(31) not null,
  F_NAME          VARCHAR2(255) not null,
  NOTE            VARCHAR2(255)
)
;
alter table VIDEO_OUTPUT_CHANNEL_MODEL
  add primary key (ID);
alter table VIDEO_OUTPUT_CHANNEL_MODEL
  add constraint FK76E057535B838449 foreign key (MANUFACTURER_ID)
  references MANUFACTURER (ID);

prompt
prompt Creating table VIDEO_OUTPUT_CHANNEL
prompt ===================================
prompt
create table VIDEO_OUTPUT_CHANNEL
(
  ID                            VARCHAR2(31) not null,
  OPTIMISTIC_LOCK               NUMBER(19) not null,
  F_NAME                        VARCHAR2(255),
  NAMING                        VARCHAR2(255),
  INSTALL_LOCATION              VARCHAR2(255),
  NOTE                          VARCHAR2(255),
  VIDEO_DISPLAY_DEVICE_ID       VARCHAR2(31) not null,
  ADDRESS_NUMBER                VARCHAR2(255) not null,
  VIDEO_OUTPUT_CHANNEL_MODEL_ID VARCHAR2(31) not null,
  ORGAN_ID                      VARCHAR2(31),
  DEVICE_PHYSICAL_RELATION_ID   VARCHAR2(31),
  STD_ID                        VARCHAR2(32),
  IS_SHARE                      NUMBER(5) default 0,
  DISPATCH_SERVER_ID            VARCHAR2(255)
)
;
comment on column VIDEO_OUTPUT_CHANNEL.IS_SHARE
  is '监视器是否公享: 0 不公享,1 公享';
alter table VIDEO_OUTPUT_CHANNEL
  add primary key (ID);
alter table VIDEO_OUTPUT_CHANNEL
  add constraint FKF7DEDC097D1CC229 foreign key (ORGAN_ID)
  references ORGAN (ID)
  disable;
alter table VIDEO_OUTPUT_CHANNEL
  add constraint FKF7DEDC09C4D37187 foreign key (VIDEO_OUTPUT_CHANNEL_MODEL_ID)
  references VIDEO_OUTPUT_CHANNEL_MODEL (ID);
alter table VIDEO_OUTPUT_CHANNEL
  add constraint FKF7DEDC09C649B563 foreign key (VIDEO_DISPLAY_DEVICE_ID)
  references VIDEO_DISPLAY_DEVICE (ID);

prompt
prompt Creating sequence ACCESSSERVER_SEQ
prompt ==================================
prompt
create sequence ACCESSSERVER_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000000000009
increment by 1
nocache
cycle;

prompt
prompt Creating sequence AC_ACCESS_CARDS_SEQ
prompt =====================================
prompt
create sequence AC_ACCESS_CARDS_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000000100005
increment by 1
nocache
cycle;

prompt
prompt Creating sequence AC_ACCESS_CONTROLS_SEQ
prompt ========================================
prompt
create sequence AC_ACCESS_CONTROLS_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000000200007
increment by 1
nocache
cycle;

prompt
prompt Creating sequence AC_ACCESS_PRIVILEGES_SEQ
prompt ==========================================
prompt
create sequence AC_ACCESS_PRIVILEGES_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000000300000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence AC_ACCESS_SERVERS_SEQ
prompt =======================================
prompt
create sequence AC_ACCESS_SERVERS_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000000400004
increment by 1
nocache
cycle;

prompt
prompt Creating sequence AC_DOOR_GROUP_SEQ
prompt ===================================
prompt
create sequence AC_DOOR_GROUP_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000000500000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence AC_EMPLOYEES_SEQ
prompt ==================================
prompt
create sequence AC_EMPLOYEES_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000000600009
increment by 1
nocache
cycle;

prompt
prompt Creating sequence AC_EMPLOYEE_ABSENT_SEQ
prompt ========================================
prompt
create sequence AC_EMPLOYEE_ABSENT_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200050000000000000013
increment by 1
nocache
cycle;

prompt
prompt Creating sequence AC_EMPLOYEE_GROUP_SEQ
prompt =======================================
prompt
create sequence AC_EMPLOYEE_GROUP_SEQ
minvalue 1
maxvalue 99999999999999999999999999
start with 200000000000000700016
increment by 1
nocache
cycle;

prompt
prompt Creating sequence AC_EMPLOYEE_SCHEDULE_SEQ
prompt ==========================================
prompt
create sequence AC_EMPLOYEE_SCHEDULE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200050000000000000004
increment by 1
nocache
cycle;

prompt
prompt Creating sequence AC_GATEWAY_SEQ
prompt ================================
prompt
create sequence AC_GATEWAY_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000000800007
increment by 1
nocache
cycle;

prompt
prompt Creating sequence AC_LOG_SEQ
prompt ============================
prompt
create sequence AC_LOG_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090000000000000620
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence AC_PLANNINGGROUPS_SEQ
prompt =======================================
prompt
create sequence AC_PLANNINGGROUPS_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000000900000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence AC_POLICIES_SEQ
prompt =================================
prompt
create sequence AC_POLICIES_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000001000000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence AC_R_DOOR_CARD_SEQ
prompt ====================================
prompt
create sequence AC_R_DOOR_CARD_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200050000000000000013
increment by 1
nocache
cycle;

prompt
prompt Creating sequence AC_R_EMPLOYEE_CARD_SEQ
prompt ========================================
prompt
create sequence AC_R_EMPLOYEE_CARD_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200050000000000000005
increment by 1
nocache
cycle;

prompt
prompt Creating sequence AC_R_EMPLOYEE_GROUP_SEQ
prompt =========================================
prompt
create sequence AC_R_EMPLOYEE_GROUP_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200050000000000000064
increment by 1
nocache
cycle;

prompt
prompt Creating sequence AC_R_SCHEDULE_GROUP_SEQ
prompt =========================================
prompt
create sequence AC_R_SCHEDULE_GROUP_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200050000000000000010
increment by 1
nocache
cycle;

prompt
prompt Creating sequence ALARMBOX_SEQ
prompt ==============================
prompt
create sequence ALARMBOX_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000001100002
increment by 1
nocache
cycle;

prompt
prompt Creating sequence ALARMEVENTRESPOND_SEQ
prompt =======================================
prompt
create sequence ALARMEVENTRESPOND_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090010000000000000
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence ALARMEVENTS_SEQ
prompt =================================
prompt
create sequence ALARMEVENTS_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090020000000000000
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence ALARMEVENTTYPE_SEQ
prompt ====================================
prompt
create sequence ALARMEVENTTYPE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000001200000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence ALARMEVENTUSER_SEQ
prompt ====================================
prompt
create sequence ALARMEVENTUSER_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090030000000000000
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence ALARMEVENT_SEQ
prompt ================================
prompt
create sequence ALARMEVENT_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090040000000000000
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence ALARMINPUTCHANNELTYPE_SEQ
prompt ===========================================
prompt
create sequence ALARMINPUTCHANNELTYPE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000001300017
increment by 1
nocache
cycle;

prompt
prompt Creating sequence ALARMINPUTCHANNEL_SEQ
prompt =======================================
prompt
create sequence ALARMINPUTCHANNEL_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000001400002
increment by 1
nocache
cycle;

prompt
prompt Creating sequence ALARMOUTPUTCHANNELTYPE_SEQ
prompt ============================================
prompt
create sequence ALARMOUTPUTCHANNELTYPE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000001500011
increment by 1
nocache
cycle;

prompt
prompt Creating sequence ALARMOUTPUTCHANNEL_SEQ
prompt ========================================
prompt
create sequence ALARMOUTPUTCHANNEL_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000001600002
increment by 1
nocache
cycle;

prompt
prompt Creating sequence ALARMSCHEME_SEQ
prompt =================================
prompt
create sequence ALARMSCHEME_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000001700000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence BRANCH_SEQ
prompt ============================
prompt
create sequence BRANCH_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000001800048
increment by 1
nocache
cycle;

prompt
prompt Creating sequence DEVICEALARM_SEQ
prompt =================================
prompt
create sequence DEVICEALARM_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000001900000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence DEVICENOTICEEVENTRESPOND_SEQ
prompt ==============================================
prompt
create sequence DEVICENOTICEEVENTRESPOND_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090050000000000000
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence DEVICENOTICEEVENTTYPE_SEQ
prompt ===========================================
prompt
create sequence DEVICENOTICEEVENTTYPE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000002000000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence DEVICENOTICEEVENT_SEQ
prompt =======================================
prompt
create sequence DEVICENOTICEEVENT_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090060000000000000
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence DISPATCHSERVER_SEQ
prompt ====================================
prompt
create sequence DISPATCHSERVER_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000002100005
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EPGISVIDEOCOORDINATE_SEQ
prompt ==========================================
prompt
create sequence EPGISVIDEOCOORDINATE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000002200000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_ALARM_EVENT_SEQ
prompt ====================================
prompt
create sequence EP_ALARM_EVENT_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090070000000000310
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence EP_ALARM_GUARD_SEQ
prompt ====================================
prompt
create sequence EP_ALARM_GUARD_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000002300000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_ASSETS_SEQ
prompt ===============================
prompt
create sequence EP_ASSETS_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 200000000000002400000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_ASSETS_VIC_SEQ
prompt ===================================
prompt
create sequence EP_ASSETS_VIC_SEQ
minvalue 1
maxvalue 99999999999999999999999999
start with 200000000000002500000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_CLIENT_GATEWAY_SEQ
prompt =======================================
prompt
create sequence EP_CLIENT_GATEWAY_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000000100011
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_CODE_SEQ
prompt =============================
prompt
create sequence EP_CODE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000002600000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_CONTROL_SERVER_SEQ
prompt =======================================
prompt
create sequence EP_CONTROL_SERVER_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000002700001
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_DEVICE_SEQ
prompt ===============================
prompt
create sequence EP_DEVICE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000002800003
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_EVENT_SERVER_SEQ
prompt =====================================
prompt
create sequence EP_EVENT_SERVER_SEQ
minvalue 1
maxvalue 99999999999999999999999999
start with 200000000000002900001
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_EVENT_TYPE_SEQ
prompt ===================================
prompt
create sequence EP_EVENT_TYPE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000003000037
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_GATHER_SERVER_SEQ
prompt ======================================
prompt
create sequence EP_GATHER_SERVER_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000003100001
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_INSTALL_ADDRESS_SEQ
prompt ========================================
prompt
create sequence EP_INSTALL_ADDRESS_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000003200003
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_INTELLIGENT_CHANNEL_SEQ
prompt ============================================
prompt
create sequence EP_INTELLIGENT_CHANNEL_SEQ
minvalue 1
maxvalue 999999999999999999999
start with 200000000000003300000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_MAP_SEQ
prompt ============================
prompt
create sequence EP_MAP_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000003400001
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_MAP_TYPE_SEQ
prompt =================================
prompt
create sequence EP_MAP_TYPE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000003500000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_MONITOR_DEVICE_SEQ
prompt =======================================
prompt
create sequence EP_MONITOR_DEVICE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000003600000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_OPERATION_LOG_SEQ
prompt ======================================
prompt
create sequence EP_OPERATION_LOG_SEQ
minvalue 1
maxvalue 9999999999999999999999
start with 200090080000000002608
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence EP_PLAN_LOG_SEQ
prompt =================================
prompt
create sequence EP_PLAN_LOG_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090090000000000000
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence EP_PLAN_SEQ
prompt =============================
prompt
create sequence EP_PLAN_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000003700000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_PLAN_STEP_SEQ
prompt ==================================
prompt
create sequence EP_PLAN_STEP_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000003800000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_PRESET_SEQ
prompt ===============================
prompt
create sequence EP_PRESET_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000003900030
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_PROBER_DATA_SEQ
prompt ====================================
prompt
create sequence EP_PROBER_DATA_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090100000000000000
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence EP_PROBER_HB_DATA_SEQ
prompt =======================================
prompt
create sequence EP_PROBER_HB_DATA_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090110000000000000
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence EP_PROBER_HB_SEQ
prompt ==================================
prompt
create sequence EP_PROBER_HB_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000004000000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_PROBER_SEQ
prompt ===============================
prompt
create sequence EP_PROBER_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000004100025
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_PROBER_TYPE_SEQ
prompt ====================================
prompt
create sequence EP_PROBER_TYPE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000004200000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_ROLE_PERMISSION_SEQ
prompt ========================================
prompt
create sequence EP_ROLE_PERMISSION_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200050000000000000000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_ROLE_SEQ
prompt =============================
prompt
create sequence EP_ROLE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000004300089
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_R_ASSETS_SEQ
prompt =================================
prompt
create sequence EP_R_ASSETS_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 200050000000000000000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_R_DOOR_VIC_SEQ
prompt ===================================
prompt
create sequence EP_R_DOOR_VIC_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200050000000000000003
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_R_FAVORITE_DEVICE_SEQ
prompt ==========================================
prompt
create sequence EP_R_FAVORITE_DEVICE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200050000000000000000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_R_MAP_DEVICE_SEQ
prompt =====================================
prompt
create sequence EP_R_MAP_DEVICE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200050000000000000002
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_R_MONITOR_DEVICE_SEQ
prompt =========================================
prompt
create sequence EP_R_MONITOR_DEVICE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200050000000000000070
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_R_PROBER_VIC_SEQ
prompt =====================================
prompt
create sequence EP_R_PROBER_VIC_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200050000000000000000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_R_ROLE_OPERATION_SEQ
prompt =========================================
prompt
create sequence EP_R_ROLE_OPERATION_SEQ
minvalue 1
maxvalue 99999999999999999999999999
start with 200050000000000001358
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_R_ROLE_RESOURCE_SEQ
prompt ========================================
prompt
create sequence EP_R_ROLE_RESOURCE_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 200050000000000000012
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_R_SCHEME_ALARM_SOURCE_SEQ
prompt ==============================================
prompt
create sequence EP_R_SCHEME_ALARM_SOURCE_SEQ
minvalue 1
maxvalue 99999999999999999999999999
start with 200050000000000001984
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_R_TASKSTEP_MONITOR_SEQ
prompt ===========================================
prompt
create sequence EP_R_TASKSTEP_MONITOR_SEQ
minvalue 1
maxvalue 99999999999999999999999999
start with 200050000000000000008
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_R_TASK_EMPLOYEE_SEQ
prompt ========================================
prompt
create sequence EP_R_TASK_EMPLOYEE_SEQ
minvalue 1
maxvalue 99999999999999999999999999
start with 200050000000000000001
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_R_USER_PLAN_SEQ
prompt ====================================
prompt
create sequence EP_R_USER_PLAN_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200050000000000000000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_R_USER_ROLE_SEQ
prompt ====================================
prompt
create sequence EP_R_USER_ROLE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200050000000000000001
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_SCHEME_COMMAND_SEQ
prompt =======================================
prompt
create sequence EP_SCHEME_COMMAND_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000004400061
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_SCHEME_SEQ
prompt ===============================
prompt
create sequence EP_SCHEME_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000004500016
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_SOLAR_BATTERY_DATA_SEQ
prompt ===========================================
prompt
create sequence EP_SOLAR_BATTERY_DATA_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090120000000000000
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence EP_SOLAR_BATTERY_ECOM_DATA_SEQ
prompt ================================================
prompt
create sequence EP_SOLAR_BATTERY_ECOM_DATA_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090130000000000000
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence EP_SOLAR_BATTERY_SCHEME_SEQ
prompt =============================================
prompt
create sequence EP_SOLAR_BATTERY_SCHEME_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000004600000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_SOLAR_BATTERY_SEQ
prompt ======================================
prompt
create sequence EP_SOLAR_BATTERY_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000004700000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_TASK_HISTORY_SEQ
prompt =====================================
prompt
create sequence EP_TASK_HISTORY_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090140000000000100
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence EP_TASK_INSTANCE_SEQ
prompt ======================================
prompt
create sequence EP_TASK_INSTANCE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000004800009
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_TASK_LOG_SEQ
prompt =================================
prompt
create sequence EP_TASK_LOG_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090150000000000000
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence EP_TASK_SEQ
prompt =============================
prompt
create sequence EP_TASK_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000004900002
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_TASK_STEP_HISTORY_SEQ
prompt ==========================================
prompt
create sequence EP_TASK_STEP_HISTORY_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090160000000000100
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence EP_TASK_STEP_INSTANCE_SEQ
prompt ===========================================
prompt
create sequence EP_TASK_STEP_INSTANCE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000005000000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_TASK_STEP_SEQ
prompt ==================================
prompt
create sequence EP_TASK_STEP_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000005100007
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_TRACK_SEQ
prompt ==============================
prompt
create sequence EP_TRACK_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000005200000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_USER_FAVORITE_SEQ
prompt ======================================
prompt
create sequence EP_USER_FAVORITE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000005300000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence EP_USER_VIEW_SEQ
prompt ==================================
prompt
create sequence EP_USER_VIEW_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000005400000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence HISTORY_VIDEO_SEQ
prompt ===================================
prompt
create sequence HISTORY_VIDEO_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090170000000000000
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence IMAGEQUALITYLEVELPARAMETER_SEQ
prompt ================================================
prompt
create sequence IMAGEQUALITYLEVELPARAMETER_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000005500000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence IMAGEQUALITYLEVEL_SEQ
prompt =======================================
prompt
create sequence IMAGEQUALITYLEVEL_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000005600000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence INTELLIGENTCHANNEL_SEQ
prompt ========================================
prompt
create sequence INTELLIGENTCHANNEL_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000005700000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence IVU_TASK_SEQ
prompt ==============================
prompt
create sequence IVU_TASK_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090260000000000000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence MANUFACTURER_SEQ
prompt ==================================
prompt
create sequence MANUFACTURER_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000005800010
increment by 1
nocache
cycle;

prompt
prompt Creating sequence MATRIXCAMERA_SEQ
prompt ==================================
prompt
create sequence MATRIXCAMERA_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000005900000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence MATRIXVIC_SEQ
prompt ===============================
prompt
create sequence MATRIXVIC_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000006000000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence MATRIX_SEQ
prompt ============================
prompt
create sequence MATRIX_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000006100000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence MEDIA_GATEWAY_SERVER_SEQ
prompt ==========================================
prompt
create sequence MEDIA_GATEWAY_SERVER_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000006200000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence NMSSYNCLOG_SEQ
prompt ================================
prompt
create sequence NMSSYNCLOG_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090180000000000000
increment by 1
cache 20
cycle;

prompt
prompt Creating sequence OORGAN_SEQ
prompt ============================
prompt
create sequence OORGAN_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000006300000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence OPERMISSION_SEQ
prompt =================================
prompt
create sequence OPERMISSION_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000006400000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence ORGANDEVICES_SEQ
prompt ==================================
prompt
create sequence ORGANDEVICES_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000006500000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence ORGAN_SEQ
prompt ===========================
prompt
create sequence ORGAN_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000006600036
increment by 1
nocache
cycle;

prompt
prompt Creating sequence OUSEROPERATIONEFFECT_SEQ
prompt ==========================================
prompt
create sequence OUSEROPERATIONEFFECT_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000006700000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence OUSEROPERATIONLOG_SEQ
prompt =======================================
prompt
create sequence OUSEROPERATIONLOG_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000006800000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence OUSEROPERATION_SEQ
prompt ====================================
prompt
create sequence OUSEROPERATION_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000006900000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence OUSERSESSION_SEQ
prompt ==================================
prompt
create sequence OUSERSESSION_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000007000000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence OUSER_SEQ
prompt ===========================
prompt
create sequence OUSER_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000007100000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence PERMISSION_SEQ
prompt ================================
prompt
create sequence PERMISSION_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000007200000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence PLATFORMROUTEINFO_SEQ
prompt =======================================
prompt
create sequence PLATFORMROUTEINFO_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000007300000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence PLATFORM_RESOURCES_SEQ
prompt ========================================
prompt
create sequence PLATFORM_RESOURCES_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000007400004
increment by 1
nocache
cycle;

prompt
prompt Creating sequence PLATFORM_SEQ
prompt ==============================
prompt
create sequence PLATFORM_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000007500000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence PLATFORM_SUBSCRIBE_SEQ
prompt ========================================
prompt
create sequence PLATFORM_SUBSCRIBE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090190000000000000
increment by 1
cache 20
cycle;

prompt
prompt Creating sequence PROGRAMUPDATEINFO_SEQ
prompt =======================================
prompt
create sequence PROGRAMUPDATEINFO_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000007600000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence RTP_PAYLOAD_SEQ
prompt =================================
prompt
create sequence RTP_PAYLOAD_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000007700009
increment by 1
nocache
cycle;

prompt
prompt Creating sequence R_USER_VIS_SEQ
prompt ================================
prompt
create sequence R_USER_VIS_SEQ
minvalue 0
maxvalue 9999999999999999999999
start with 200050000000000000000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence SHAREDEVICEINFO_SEQ
prompt =====================================
prompt
create sequence SHAREDEVICEINFO_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000007800000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence SIP_SERVER_SEQ
prompt ================================
prompt
create sequence SIP_SERVER_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000007900000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence STANDARD_ID_SEQ
prompt =================================
prompt
create sequence STANDARD_ID_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000008000000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence STORAGESERVER_SEQ
prompt ===================================
prompt
create sequence STORAGESERVER_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000008100047
increment by 1
nocache
cycle;

prompt
prompt Creating sequence SYSTEMROLE_SEQ
prompt ================================
prompt
create sequence SYSTEMROLE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000008200000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence TEMP_COMMAND_ID
prompt =================================
prompt
create sequence TEMP_COMMAND_ID
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000008300000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence TEMP_RESOURCES_SEQ
prompt ====================================
prompt
create sequence TEMP_RESOURCES_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090200000000000000
increment by 1
cache 100
cycle;

prompt
prompt Creating sequence THIRD_PARTY_PLATFORM_SEQ
prompt ==========================================
prompt
create sequence THIRD_PARTY_PLATFORM_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000008400000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence TROLE_SEQ
prompt ===========================
prompt
create sequence TROLE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000008500000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence TUSER_SEQ
prompt ===========================
prompt
create sequence TUSER_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000008600359
increment by 1
nocache
cycle;

prompt
prompt Creating sequence USEROPERATIONEFFECT_SEQ
prompt =========================================
prompt
create sequence USEROPERATIONEFFECT_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000008700000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence USEROPERATIONLOG_SEQ
prompt ======================================
prompt
create sequence USEROPERATIONLOG_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090210000000000000
increment by 1
cache 20
cycle;

prompt
prompt Creating sequence USEROPERATION_SEQ
prompt ===================================
prompt
create sequence USEROPERATION_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090220000000000000
increment by 1
cache 20
cycle;

prompt
prompt Creating sequence USERORGANACL_SEQ
prompt ==================================
prompt
create sequence USERORGANACL_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000008800000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence USERSESSIONHISTORY_SEQ
prompt ========================================
prompt
create sequence USERSESSIONHISTORY_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090230000000001427
increment by 1
cache 20
cycle;

prompt
prompt Creating sequence USERSESSION_SEQ
prompt =================================
prompt
create sequence USERSESSION_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090240000000001386
increment by 1
cache 20
cycle;

prompt
prompt Creating sequence USERVIDEOFLOWRECORD_SEQ
prompt =========================================
prompt
create sequence USERVIDEOFLOWRECORD_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000008900000
increment by 1
nocache
cycle;

prompt
prompt Creating sequence USER_SUBSCRIBE_SEQ
prompt ====================================
prompt
create sequence USER_SUBSCRIBE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200090250000000000000
increment by 1
cache 20
cycle;

prompt
prompt Creating sequence VIDEODISPLAYDEVICE_SEQ
prompt ========================================
prompt
create sequence VIDEODISPLAYDEVICE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000009000001
increment by 1
nocache
cycle;

prompt
prompt Creating sequence VIDEOINPUTCHANNELMODEL_SEQ
prompt ============================================
prompt
create sequence VIDEOINPUTCHANNELMODEL_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000009100007
increment by 1
nocache
cycle;

prompt
prompt Creating sequence VIDEOINPUTCHANNEL_SEQ
prompt =======================================
prompt
create sequence VIDEOINPUTCHANNEL_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000009200009
increment by 1
nocache
cycle;

prompt
prompt Creating sequence VIDEOINPUTSERVERMODEL_SEQ
prompt ===========================================
prompt
create sequence VIDEOINPUTSERVERMODEL_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000009300010
increment by 1
nocache
cycle;

prompt
prompt Creating sequence VIDEOINPUTSERVER_SEQ
prompt ======================================
prompt
create sequence VIDEOINPUTSERVER_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000009400040
increment by 1
nocache
cycle;

prompt
prompt Creating sequence VIDEOOUTPUTCHANNELMODEL_SEQ
prompt =============================================
prompt
create sequence VIDEOOUTPUTCHANNELMODEL_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000009500003
increment by 1
nocache
cycle;

prompt
prompt Creating sequence VIDEOOUTPUTCHANNEL_SEQ
prompt ========================================
prompt
create sequence VIDEOOUTPUTCHANNEL_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 200000000000009600001
increment by 1
nocache
cycle;

prompt
prompt Creating procedure REGISTER_TERMINAL
prompt ====================================
prompt
CREATE OR REPLACE PROCEDURE register_terminal(v_terminal_id  varchar2,
                                              v_accesid      varchar2,
                                              v_cmsid        varchar2,
                                              support_scheme number,
                                              companyStr     varchar2)

 IS

BEGIN
  if (length(v_terminal_id) >= 18) then
    update VIDEO_INPUT_SERVER r
       set r.NAMING          = v_terminal_id || ':' || v_accesid || ':' ||
                               v_cmsid,
           IS_SUPPORT_SCHEME = support_scheme
     where r.ID = v_terminal_id;

    update VIDEO_INPUT_CHANNEL t
       set t.NAMING          = ID || ':' || v_terminal_id || ':' ||
                               v_accesid || ':' || v_cmsid,
           IS_SUPPORT_SCHEME = support_scheme
     where t.VIDEO_INPUT_SERVER_ID = v_terminal_id;

    update ALARM_INPUT_CHANNEL m
       set m.NAMING          = ID || ':' || v_terminal_id || ':' ||
                               v_accesid || ':' || v_cmsid,
           IS_SUPPORT_SCHEME = support_scheme
     where m.ALARM_BOX_ID in
           (select ID
              from ALARM_BOX
             where VIDEO_INPUT_SERVER_ID = v_terminal_id);

    update ALARM_OUTPUT_CHANNEL n
       set n.NAMING          = ID || ':' || v_terminal_id || ':' ||
                               v_accesid || ':' || v_cmsid,
           IS_SUPPORT_SCHEME = support_scheme
     where n.ALARM_BOX_ID in
           (select ID
              from ALARM_BOX
             where VIDEO_INPUT_SERVER_ID = v_terminal_id);

    update INTELLIGENT_CHANNEL i
       set i.NAMING  = ID || ':' || v_terminal_id || ':' || v_accesid || ':' ||
                       v_cmsid,
           i.COMPANY = companyStr
     where i.PARENT_TYPE = 1
       and i.PARENT_ID = v_terminal_id;
    commit;
  end if;
END;
/

prompt
prompt Creating trigger ORGAN_TRIGGER
prompt ==============================
prompt
create or replace trigger "ORGAN_TRIGGER"
before DELETE OR INSERT
ON ORGAN
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
DECLARE

BEGIN

  execute immediate 'update t_user tt set tt.permission_change=1';
EXCEPTION
  WHEN OTHERS THEN
    raise;
END;
/

prompt
prompt Creating trigger UPDATE_NAMING_AIC_TRIGGER
prompt ==========================================
prompt
create or replace trigger "UPDATE_NAMING_AIC_TRIGGER"
             after update
	     of naming
             on alarm_input_channel
             FOR EACH ROW
DECLARE
  aicNaming       alarm_input_channel.naming%TYPE;
  isSupportScheme alarm_input_channel.is_support_scheme%TYPE;
  aicId           alarm_input_channel.id%TYPE;

BEGIN
  aicNaming       := :new.naming;
  isSupportScheme := :new.is_support_scheme;
  aicId           := :new.id;

  --update organ_devices set naming=aicNaming,is_support_scheme=isSupportScheme where type='AIC' and deviceid=aicId;

  update platform_resources
     set naming = aicNaming
   where type = 'aic'
     and resource_id = aicId;
END update_naming_aic_trigger;
/

prompt
prompt Creating trigger UPDATE_NAMING_VIC_TRIGGER
prompt ==========================================
prompt
create or replace trigger "UPDATE_NAMING_VIC_TRIGGER"
             after update
	     of naming
             on video_input_channel
             FOR EACH ROW
DECLARE
  vicNaming       video_input_channel.naming%TYPE;
  isSupportScheme video_input_channel.is_support_scheme%TYPE;
  vicId           video_input_channel.id%TYPE;

BEGIN
  vicNaming       := :new.naming;
  isSupportScheme := :new.is_support_scheme;
  vicId           := :new.id;

  --update organ_devices set naming=vicNaming,is_support_scheme=isSupportScheme where (type='VIC' or type='IPVIC') and deviceid=vicId;

  update platform_resources
     set naming = vicNaming
   where type = 'vic'
     and resource_id = vicId;

END update_naming_vic_trigger;
/

prompt
prompt Creating trigger UPDATE_NAMING_VIS_TRIGGER
prompt ==========================================
prompt
create or replace trigger "UPDATE_NAMING_VIS_TRIGGER"
  after update of naming on video_input_server
  for each row
declare
  visnaming video_input_server.naming%TYPE;
  id        video_input_server.id%TYPE;
begin
  visnaming := :new.naming;
  id        := :new.id;

  update platform_resources
     set naming = visnaming
   where type = 'vis'
     and resource_id = id;

end UPDATE_NAMING_VIS_TRIGGER;
/


spool off
