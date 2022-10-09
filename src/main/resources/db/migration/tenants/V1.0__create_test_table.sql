create table item
(
    id bigint auto_increment,
    name varchar(255) not null,
    description varchar(255) null,
    constraint item_pk
        primary key (id)
);

create table storage
(
    id bigint auto_increment,
    address varchar(255) not null,
    constraint storage_pk
        primary key (id)
);

create table storage_item
(
    id bigint auto_increment,
    item_id bigint null,
    storage_id bigint null,
    quantity bigint null,
    constraint storage_item_pk
        primary key (id),
    constraint storage_item_item_id_fk
        foreign key (item_id) references item (id),
    constraint storage_item_storage_id_fk
        foreign key (storage_id) references storage (id)
);
