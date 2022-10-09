# USE master;

create table tenant
(
    id bigint auto_increment,
    name varchar(255) null,
    constraint tenant_pk
        primary key (id)
);

create table user
(
    id bigint auto_increment,
    username varchar(255) null,
    password varchar(255) null,
    tenant_id bigint null,
    constraint user_pk
        primary key (id),
    constraint user_tenant_id_fk
        foreign key (tenant_id) references tenant (id)
);






