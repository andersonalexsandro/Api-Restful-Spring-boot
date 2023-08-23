create table usuarios(
    id bigint not null auto_increment,
    login varchar(20) not null unique,
    senha varchar(20) not null,

    primary key(id)
);