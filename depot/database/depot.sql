create table muser(
userid number,
username VARCHAR2(10),
password VARCHAR2(10),
roleid number,
deptid number
);

insert into muser values(1,'admin',666,1,1);

CREATE TABLE sector(
deptid number,
deptname VARCHAR2(20)
);

insert into sector values(1,'信息部');
insert into sector values(2,'市场部');
insert into sector values(3,'采购部');

CREATE TABLE role(
roleid number,
rolename VARCHAR2(20)
);

insert into role values(1,'高级经理');
insert into role values(2,'普通职员');

--作为muser表的主键
create  sequence seq_muser
start with 1
increment by 1 --步长，每一次增加1
minvalue 1     --最小值
maxvalue 10000 --最大值
order          --排序 