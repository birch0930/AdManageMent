CREATE TABLE IF NOT EXISTS ADVERT(
advertId int PRIMARY KEY
,username varchar(20) 
,startDate date not null	
,expiryDate date  not null
,servicePeriod int  not null
,remainedPeriod int default 0
,status int default 0 not null
,suspendDate timestamp null
)character set=utf8;


drop table ADVERT;
select * from ADVERT;
update ADVERT set STATUS = 0 WHERE ADVERTID = 9;

UPDATE ADVERT SET   REMAINEDPERIOD=5   WHERE ADVERTID = 0
delete from ADVERT;

CREATE TABLE IF NOT EXISTS ADVERTTYPE(
advertTypeId int primary key
,typeName varchar(10) 
)character set=utf8;

INSERT INTO  ADVERTTYPE VALUES (1,'Main');
INSERT INTO  ADVERTTYPE VALUES (2,'Banner');
INSERT INTO  ADVERTTYPE VALUES (3,'Item');



,advertTypeId int	 not null
,FOREIGN KEY(advertTypeId) REFERENCES  ADVERTTYPE(advertTypeId)
