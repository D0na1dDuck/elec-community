# 电子社区

## 简介
[项目地址](https://github.com/D0na1dDuck/elec-community)

## 资料
[Spring 文档](https://spring.io/)  
[Bootstrap](https://v3.bootcss.com/)  
[OkHttp](https://square.github.io/okhttp/)  
[菜鸟教程](https://www.runoob.com/)  
[es](https://elasticsearch.cn/)

## 工具
[Git](https://git-scm.com/)  
[Github](https://github.com/)  
[flyway](https://flywaydb.org/)

## 脚本
```sql
create table USER
(
    ID           INT auto_increment,
    ACCOUNT_ID   VARCHAR(100),
    NAME         VARCHAR(50),
    TOKEN        CHAR(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    BIO          VARCHAR(256),
    constraint USER_PK
        primary key (ID)
);
```   

## mvn命令
```
mvn flyway:migrate
```


