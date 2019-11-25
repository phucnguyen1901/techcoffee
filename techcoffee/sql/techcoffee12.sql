create database techcoffee;
use techcoffee;

create table if not exists users(
	iduser int not null  AUTO_INCREMENT,
	username char(16) not null unique,
    passwd char(16) not null,
    check_admin char(1) default "0",
    feelback varchar(1000),
    primary key (iduser)
);

create table if not exists datBan (
	idDatban int not null primary key AUTO_INCREMENT,
    soBan char(4) not null,
    userName char(16) not null,
    soNguoi nvarchar(15) not null,
    timeDatban nvarchar(30) not null,
    yeuCau nvarchar(1000)
);

insert into users(username,passwd,check_admin,feelback) values("username1","123","0","Chuc mung nam moi");
insert into users(username,passwd,check_admin,feelback) values("admin1","123","1","Chuc mung nam moi haha");
insert into users(username,passwd,check_admin,feelback) values("username2","456","0","Chuc mung nam moi");
insert into users(username,passwd,check_admin,feelback) values("admin2","456","1","Chuc mung nam moi haha");

select * from users;

create table if not exists employee (
	idemployee char(4) not null,
    emplyeename char(35) not null,
    phonenumber char(10) not null,
    wage char(10) not null,
    workingday date not null,
	birthday date not null,
    primary key(idemployee)
);


create table if not exists save_add(
	idemployee char(4) not null ,
    emplyeename char(35) not null,
    statuses char(10) not null, 
    date varchar(255) ,
    primary key (idemployee)
);

create table if not exists save_delete(
	idemployee char(4) not null ,
	emplyeename char(35) not null,
    statuses char(20) not null, 
    date varchar(255) ,
    primary key (idemployee)
);

-- drop trigger add_history;
-- trigger luu lich su them
delimiter $$
create trigger add_history before insert
on employee 
for each row
begin
	insert into save_add(idemployee,emplyeename,statuses,date) values(new.idemployee,new.emplyeename,"Added", now());
end$$
delimiter ;

-- drop trigger delete_history;
-- trigger luu lich su xoa
delimiter $$
create trigger delete_history before delete
on employee 
for each row
begin
	insert into save_delete(idemployee,emplyeename,statuses,date) values(old.idemployee,old.emplyeename,"Deleted", now());
end$$
delimiter ;

-- thu tuc them
delimiter $$
create procedure add_employee(idemployee1 char(4),emplyeename1 char(35), phonenumber1 char(10),  wage1 char(11),  workingday1 date, birthday1 date)
begin
	if exists (select idemployee from employee)
    then
		insert into employee(idemployee,emplyeename,phonenumber,wage,workingday,birthday) values(idemployee1,emplyeename1,phonenumber1,wage1,workingday1,birthday1) ;
    end if;
end$$
delimiter ;

insert into employee(idemployee,emplyeename,phonenumber,wage,workingday,birthday) values("nv1","nguyen van a","0947123456","2000000","1992-06-15","2019-06-06");
insert into employee(idemployee,emplyeename,phonenumber,wage,workingday,birthday) values("bv1","nguyen van b","0909654123","3000000","1993-03-22","2019-06-06");

-- thu tuc update du lieu
delimiter $$
create procedure update_employee(idemployee1 char(4),emplyeename1 char(35), phonenumber1 char(10),  wage1 char(11),  workingday1 date, birthday1 date, idemployeenew char(4))
begin
	if exists (select idemployee from employee)
    then
		update employee set idemployee = idemployee1 , emplyeename=emplyeename1, phonenumber=phonenumber1, wage=wage1, workingday=workingday1, birthday=birthday1 where idemployee=idemployeenew ;
    end if;
end$$
delimiter ;

-- thu tuc xoa nhan vien
delimiter $$
create procedure delete_employee(idemployee1 char(4))
begin
	if exists (select idemployee from employee)
    then
		delete from employee where idemployee=idemployee1;
    end if;
end$$
delimiter ;



create table if not exists ban (
    tenBan char(8) primary key,
    trangThai int not null 
);

insert into ban values('so1',1);
insert into ban values('so2',1);
insert into ban values('so3',1);
insert into ban values('so4',1);
insert into ban values('so5',1);
insert into ban values('so6',1);
insert into ban values('so7',1);
insert into ban values('so8',1);
insert into ban values('so9',1);
insert into ban values('so10',1);
delimiter $$

create procedure dangdat(ban char(8))
begin
	update ban set trangThai = 2 where  tenBan=ban;
end$$

create procedure datXong(ban char(8))
begin
	update ban set trangThai = 3 where  tenBan=ban;
end$$

create procedure dungXong(ban char(8))
begin
	update ban set trangThai = 1 where  tenBan=ban;
end$$


-- call dangdat('so1')$$
-- call dungXong('so2')$$
-- call datXong('so1')$$

create function xuatTT(ban char(8))
returns int
reads sql data deterministic
begin
 declare tt int;
	set tt=(select trangThai from techcoffee.ban where tenBan =ban);
return tt;
end$$
SET GLOBAL log_bin_trust_function_creators = 1;
