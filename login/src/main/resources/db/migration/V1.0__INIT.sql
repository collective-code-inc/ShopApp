---------------------------------------------
----Create Tables----------------------------
---------------------------------------------
create table USERS
(
    id         int8         not null,
    EMAIL_ID   varchar(255) not null,
    FIRST_NAME varchar(255) not null,
    LAST_NAME  varchar(255) not null,
    USER_NAME  varchar(255) not null unique,
    PASSWORD   varchar(255) not null,
    primary key (id)
);

--Create Sequence Generator-------------------------------------------
----------------------------------------------------------------------
create sequence USER_ID_SEQ_GEN start 151 increment 50;