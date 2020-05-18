/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/5/18 22:04:28                           */
/*==============================================================*/


drop table if exists t_client;

drop table if exists t_product;

drop table if exists t_product_in;

drop table if exists t_product_out;

drop table if exists t_provider;

drop table if exists t_repertory;

drop table if exists t_sale;

drop table if exists t_sale_return;

drop table if exists t_user;

/*==============================================================*/
/* Table: t_client                                              */
/*==============================================================*/
create table t_client
(
   id                   varchar(20) not null,
   name                 varchar(50),
   address              varchar(100),
   zip                  varchar(6),
   email                varchar(20),
   phone_number         varchar(20),
   contact              varchar(20),
   contact_phone_number varchar(11),
   bank                 varchar(50),
   bank_account         varchar(30),
   remark               int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_product                                             */
/*==============================================================*/
create table t_product
(
   id                   varchar(20) not null,
   name                 varchar(20),
   place_of_production  varchar(50),
   providerID           varchar(20),
   specification        varchar(20),
   batch                varchar(20),
   price                double,
   remark               int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_product_in                                          */
/*==============================================================*/
create table t_product_in
(
   id                   varchar(20) not null,
   productID            varchar(20),
   quantity             double,
   money                double,
   providerID           varchar(20),
   operator             varchar(20),
   cleaning             varchar(20),
   reamark              int,
   time                 datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: t_product_out                                         */
/*==============================================================*/
create table t_product_out
(
   id                   varchar(20) not null,
   productID            varchar(20),
   quantity             double,
   money                double,
   providerID           varchar(20),
   operator             varchar(20),
   cleaning             varchar(20),
   reamark              int,
   time                 datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: t_provider                                            */
/*==============================================================*/
create table t_provider
(
   id                   varchar(20) not null,
   name                 varchar(50),
   address              varchar(100),
   zip                  varchar(6),
   phone_number         varchar(20),
   contact              varchar(20),
   contact_phone_number varchar(11),
   bank                 varchar(50),
   bank_account         varchar(30),
   email                varchar(20),
   remark               int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_repertory                                           */
/*==============================================================*/
create table t_repertory
(
   id                   varchar(20) not null,
   quantity             double not null,
   productID            varchar(20) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_sale                                                */
/*==============================================================*/
create table t_sale
(
   time                 datetime,
   id                   varchar(20) not null,
   quanity              double,
   money                double,
   accountID            varchar(20),
   productID            varchar(20),
   operator             varchar(20),
   cleaning             varchar(20),
   remark               int,
   primary key (id)
);

/*==============================================================*/
/* Table: t_sale_return                                         */
/*==============================================================*/
create table t_sale_return
(
   time                 datetime,
   id                   varchar(20) not null,
   quanity              double,
   money                double,
   accountID            varchar(20),
   productID            varchar(20),
   operator             varchar(20),
   cleaning             varchar(20),
   remark               int,
   primary key (id)
);

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   account              varchar(20) not null,
   password             varchar(20) not null,
   name                 varchar(20),
   access_level         int not null,
   primary key (account)
);

alter table t_product_in add constraint FK_Reference_4 foreign key (providerID)
      references t_provider (id) on delete restrict on update restrict;

alter table t_product_in add constraint FK_Reference_5 foreign key (productID)
      references t_product (id) on delete restrict on update restrict;

alter table t_product_out add constraint FK_Reference_1 foreign key (providerID)
      references t_provider (id) on delete restrict on update restrict;

alter table t_product_out add constraint FK_Reference_2 foreign key (productID)
      references t_product (id) on delete restrict on update restrict;

alter table t_repertory add constraint FK_Reference_3 foreign key (productID)
      references t_product (id) on delete restrict on update restrict;

alter table t_sale add constraint FK_Reference_8 foreign key (accountID)
      references t_client (id) on delete restrict on update restrict;

alter table t_sale add constraint FK_Reference_9 foreign key (productID)
      references t_product (id) on delete restrict on update restrict;

alter table t_sale_return add constraint FK_Reference_6 foreign key (productID)
      references t_product (id) on delete restrict on update restrict;

alter table t_sale_return add constraint FK_Reference_7 foreign key (accountID)
      references t_client (id) on delete restrict on update restrict;

