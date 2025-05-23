create database ss11;

use ss11;

# drop database ss11;

create table Categories
(
    id           int primary key auto_increment,
    categoryName varchar(50) not null unique,
    status       bit default 1
);

delimiter //
create procedure find_all_catalog()
begin
    select * from Categories;
end;

create procedure find_catalog_by_id(
    id_in int
)
begin
    select * from Categories where id = id_in;
end;

create procedure check_catalog_name(
    categoryName_in varchar(50)
)
begin
    select * from Categories where categoryName = categoryName_in;
end;

create procedure create_catalog(
    categoryName_in varchar(50)
)
begin
    insert into Categories (categoryName)
    values (categoryName_in);
end;

create procedure edit_catalog(
    id_in int,
    categoryName_in varchar(50),
    status_in bit
)
begin
    update Categories
    set id           = id_in,
        categoryName = categoryName_in,
        status       = status_in
    where id = id_in;
end;

create procedure delete_catalog(
    id_in int
)
begin
    delete from Categories where id = id_in;
end;
delimiter //