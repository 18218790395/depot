CREATE TABLE auser(
aid NUMBER primary key,
aname VARCHAR2(20),
pwd VARCHAR2(20)
)

--作为auser表的主键
create  sequence seq_auser
start with 0
increment by 1 --步长，每一次增加1
minvalue 0     --最小值
maxvalue 10000 --最大值
order          --排序 

INSERT INTO auser VALUES(seq_auser.nextval,'admin',123)


CREATE TABLE book(
bid NUMBER primary key,
bname VARCHAR2(20),
author VARCHAR(20),
publish VARCHAR2(20),
price NUMBER,
num NUMBER)

--作为book表的主键
create  sequence seq_book
start with 0
increment by 1 --步长，每一次增加1
minvalue 0     --最小值
maxvalue 10000 --最大值
order          --排序 

INSERT INTO book VALUES(seq_book.nextval,'大雪中的山庄','东野圭吾','北京十月文艺出版社',35,1)
INSERT INTO book VALUES(seq_book.nextval,'三生三世 十里桃花','唐七公子','沈阳出版社',38,1)
INSERT INTO book VALUES(seq_book.nextval,'何以笙箫默','顾漫','朝华出版社',38,1)
INSERT INTO book VALUES(seq_book.nextval,'11处特工皇妃','潇湘冬儿','江苏文艺出版社',38,1)
INSERT INTO book VALUES(seq_book.nextval,'人类简史','尤瓦尔·赫拉利','中信出版社',38,1)
INSERT INTO book VALUES(seq_book.nextval,'明朝那些事儿（1-9）','当年明月','中国海关出版社',38,1)
INSERT INTO book VALUES(seq_book.nextval,'方向','马克·安托万·马修','北京联合出版公司',38,1)
INSERT INTO book VALUES(seq_book.nextval,'画的秘密','马克-安托万·马修','北京联合出版公司',38,1)
INSERT INTO book VALUES(seq_book.nextval,'造彩虹的人','东野圭吾','北京十月文艺出版社',38,1)
INSERT INTO book VALUES(seq_book.nextval,'少有人走的路','M·斯科特·派克','吉林文史出版社',38,1)
INSERT INTO book VALUES(seq_book.nextval,'追寻生命的意义','[奥] 维克多·弗兰克','新华出版社',38,1)


CREATE TABLE reader(
rid NUMBER primary key,
rname VARCHAR2(20),
gender VARCHAR2(20),
address VARCHAR2(20),
phone VARCHAR2(20)
)

--作为reader表的主键
create  sequence seq_reader
start with 0
increment by 1 --步长，每一次增加1
minvalue 0     --最小值
maxvalue 10000 --最大值
order          --排序 

INSERT INTO reader VALUES(seq_reader.nextval,'yang','女','广东湛江',15378654783)
INSERT INTO reader VALUES(seq_reader.nextval,'li','女','广东湛江',15378654783)