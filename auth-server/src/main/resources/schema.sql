------------ 客户端 -------------
-- 字段参考：JdbcClientDetailsService.CLIENT_FIELDS
DROP TABLE IF EXISTS oauth_client_details;
CREATE TABLE oauth_client_details
(
    client_id               VARCHAR(255) PRIMARY KEY,
    resource_ids            VARCHAR(255),
    client_secret           VARCHAR(255),
    scope                   VARCHAR(255),
    authorized_grant_types  VARCHAR(255),
    web_server_redirect_uri VARCHAR(255),
    authorities             VARCHAR(255),
    additional_information  VARCHAR(255),
    autoapprove             VARCHAR(255),
    access_token_validity   INTEGER,
    refresh_token_validity  INTEGER
);
INSERT INTO oauth_client_details
VALUES ('user', NULL, '$2a$10$HFwz2cSmd2wEwPF6OEbRGOwkbYK1KRQUpkxS/hYaedVuCq56Wux4S', 'all',
        'authorization_code,refresh_token', 'http://auth-server', NULL, NULL, 'true', 7200, NULL);
INSERT INTO oauth_client_details
VALUES ('sso-client-a', NULL, '$2a$10$HFwz2cSmd2wEwPF6OEbRGOwkbYK1KRQUpkxS/hYaedVuCq56Wux4S', 'all',
        'authorization_code,refresh_token', 'http://sso-client-a:8081/login',
        NULL, NULL, 'true', 7200, NULL);
INSERT INTO oauth_client_details
VALUES ('sso-client-b', NULL, '$2a$10$HFwz2cSmd2wEwPF6OEbRGOwkbYK1KRQUpkxS/hYaedVuCq56Wux4S', 'all',
        'authorization_code,refresh_token', 'http://sso-client-b:8082/login', NULL, NULL, 'true', 7200, NULL);

---------------- 用户 -----------
-- 参考： org.springframework.security.core.userdetails.User

DROP TABLE IF EXISTS oauth_user_details;
CREATE TABLE oauth_user_details
(
    id          INTEGER PRIMARY KEY,
    username    VARCHAR(200) NOT NULL UNIQUE, -- 用户名
    password    VARCHAR(60)  NOT NULL,        -- 密码
    name        VARCHAR(200),                 -- 姓名(昵称)
    authorities VARCHAR(200),                 -- authority （role） split for ,
    enabled     BOOLEAN DEFAULT TRUE,         -- 是否可用
    locked      BOOLEAN DEFAULT FALSE,        -- 账号被锁定
    expiry      TIMESTAMP(0),                 -- 账号过期时间
    credentials TIMESTAMP(0)                  -- 凭证过期时间
);

-- 密码：123123
INSERT INTO oauth_user_details
VALUES (1, 'admin', '$2a$10$qmYhnuFIsLSPWs58k4bEW.hlLQ6BVQiSN0Xx/CUu6.fFv/58.CzAW', '管理', 'A', true, false, null, null);
INSERT INTO oauth_user_details
VALUES (2, 'adam', '$2a$10$qmYhnuFIsLSPWs58k4bEW.hlLQ6BVQiSN0Xx/CUu6.fFv/58.CzAW', '亚当', 'B', null, false, null, null);
