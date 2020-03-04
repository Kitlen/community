CREATE TABLE COMMENT
(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    PARENT_ID BIGINT NOT NULL,
    TYPE INT NOT NULL,
    COMMENTATOR INT NOT NULL,
    content varchar(1024),
    LIKE_COUNT BIGINT DEFAULT 0,
    GMT_CREATE BIGINT,
    GMT_MODIFIED BIGINT
);