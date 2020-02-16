drop table if exists map_history;
create table map_history (
id int primary key auto_increment,
userId varchar,
title varchar,
point varchar,
url varchar,
detailUrl varchar,
address varchar,
city varchar,
province varchar,
phoneNumber varchar,
postcode varchar,
distance varchar,
tag varchar,
createTime DATE
)