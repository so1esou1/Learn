drop table if exists t_user;
create table  t_user(
    id int(10) primary key auto_increment,
    username varchar(32) not null unique,
    password varchar(32) not null,
    realname varchar(128)
)

insert into t_user(username,password,realname) values ('admin','123','管理员');
insert into t_user(username,password,realname) values ('张三','123','张三');
commit;
select * from t_user;