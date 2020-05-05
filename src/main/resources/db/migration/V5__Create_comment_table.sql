create table COMMENT
(
    id BIGINT auto_increment,
    parent_id BIGINT not null,
    type INT not null,
    commentator INT not null,
    content VARCHAR(1024) null,
    gmt_create BIGINT not null,
    gmt_modified BIGINT not null,
    like_count BIGINT default 0,
    constraint COMMENT_pk
        primary key (id)
);
