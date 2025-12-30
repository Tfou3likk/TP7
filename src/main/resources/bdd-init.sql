create table user (
    email varchar(255) primary key,
    firstname text,
    lastname text
);

create table disk (
    identification_code varchar(255) primary key,
    album text,
    artist text
);

create table disk_to_sold (
    identification_code varchar(255) primary key,
    price decimal(10,2),
    constraint foreign key (identification_code) references disk(identification_code)
);

create table vinyl_collection(
    identification_code varchar(255) primary key,
    user varchar(255),
    constraint foreign key (identification_code) references disk(identification_code),
    constraint foreign key (user) references user(email)
);