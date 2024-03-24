create table PRODUCT
(
    id         int8         not null,
    PRODUCT_ID   varchar(255) not null unique,
    CATEGORY varchar(255) not null,
    IMAGES  varchar(255) not null,
    PRODUCT_DESCRIPTION  varchar(255) not null ,
    PRICE   varchar(255) not null,
    primary key (id)
);

create sequence ITEM_ID_SEQ_GEN start 151 increment 50;