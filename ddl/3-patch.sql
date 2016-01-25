--2013.01.04 add by HBJ--
--用户表添加是否内网用户标识，用于区分用户登录时选择的客户端网关IP
alter table t_user add is_inner_user number(1);
comment on column t_user.is_inner_user is '是否内网用户，0-外网用户，1-内网用户';
update t_user set is_inner_user = '1';
--2013.01.04 end--

--2013.01.05 add by HBJ--
--员工地址字段从31位长度修改为255
alter table ac_employees modify address varchar2(255);
--2013.01.05 end--