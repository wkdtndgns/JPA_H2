CREATE TABLE t_user
(
    user_no  int AUTO_INCREMENT COMMENT '사용자 번호 (P.K)'
        PRIMARY KEY,
    password varchar(255),
    name     varchar(30),
    tel      varchar(255),
    nickname varchar(30),
    email    varchar(255)
);