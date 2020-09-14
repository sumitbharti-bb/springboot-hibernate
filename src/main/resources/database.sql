
create table user_details(
    id int(11) not null AUTO_INCREMENT,
    name varchar(100) not null,
    mobile_number varchar(20) not null,
    email varchar(50) not null,
    primary key(id)
);


create table address(
    id int(11) not null AUTO_INCREMENT,
    user_details_id int(11) not null,
    pin_code varchar(20) not null,
    location varchar(50) not null,
    city varchar(50) not null,
    stats varchar(50) not null,
    primary key(id),
    foreign key(user_details_id) references user_details(id)
);