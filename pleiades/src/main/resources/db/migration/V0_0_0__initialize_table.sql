CREATE TABLE user
(
  `id`         char(32)     NOT NULL COMMENT 'id',
  `login_id`   varchar(32)  NOT NULL COMMENT 'ログインID',
  `name`       varchar(255) NOT NULL COMMENT 'ユーザー名',
  `gender`     char(1)      NOT NULL COMMENT '性別',
  `mail`       varchar(255) NOT NULL COMMENT 'メールアドレス',
  `password`   varchar(255) NOT NULL COMMENT 'パスワード',
  `lockout`    bit(1)       NOT NULL DEFAULT 0 COMMENT 'ロックアウト',
  `office_id`  char(32)     NOT NULL COMMENT '所属オフィス',
  `created_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日',
  `created_by` char(32)     NOT NULL COMMENT '作成者',
  `updated_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE current_timestamp COMMENT '更新日',
  `update_by`  char(32)     NOT NULL COMMENT '更新者',
  `is_deleted` bit(1)       NOT NULL DEFAULT b'0' COMMENT '削除フラグ',
  PRIMARY KEY (`id`),
  UNIQUE uk_employee_no(login_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT 'ユーザー';

CREATE TABLE office
(
  `id`         char(32) NOT NULL COMMENT 'id',
  `name`       char(64) NOT NULL COMMENT '名前',
  `kind`       char(1)  NOT NULL COMMENT '種別',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日',
  `created_by` char(32) NOT NULL COMMENT '作成者',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE current_timestamp COMMENT '更新日',
  `update_by`  char(32) NOT NULL COMMENT '更新者',
  `is_deleted` bit(1)   NOT NULL DEFAULT b'0' COMMENT '削除フラグ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT 'オフィス';

CREATE TABLE permission
(
  `id`         char(32) NOT NULL COMMENT 'id',
  `name`       char(64) NOT NULL COMMENT 'パーミッション名',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日',
  `created_by` char(32) NOT NULL COMMENT '作成者',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE current_timestamp COMMENT '更新日',
  `update_by`  char(32) NOT NULL COMMENT '更新者',
  `is_deleted` bit(1)   NOT NULL DEFAULT b'0' COMMENT '削除フラグ',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT 'パーミッション';

CREATE TABLE role
(
  `id`         char(32) NOT NULL COMMENT 'id',
  `name`       char(64) NOT NULL COMMENT 'ロール名',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日',
  `created_by` char(32) NOT NULL COMMENT '作成者',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE current_timestamp COMMENT '更新日',
  `update_by`  char(32) NOT NULL COMMENT '更新者',
  `is_deleted` bit(1)   NOT NULL DEFAULT b'0' COMMENT '削除フラグ',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT 'ロール';

CREATE TABLE role_permission
(
  `id`            char(32) NOT NULL COMMENT 'id',
  `role_id`       char(32) NOT NULL COMMENT 'id',
  `permission_id` char(32) NOT NULL COMMENT 'id',
  `created_at`    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日',
  `created_by`    char(32) NOT NULL COMMENT '作成者',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT 'ロールに紐づくパーミッション';

CREATE TABLE user_role
(
  `id`         char(32) NOT NULL COMMENT 'id',
  `user_id`    char(32) NOT NULL COMMENT 'id',
  `role_id`    char(32) NOT NULL COMMENT 'id',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日',
  `created_by` char(32) NOT NULL COMMENT '作成者',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT 'ユーザに紐づくロール';


CREATE TABLE sub_office
(
  `id`              char(32) NOT NULL COMMENT 'id',
  `name`            char(64) NOT NULL COMMENT '名前',
  `office_id`       char(32) NOT NULL COMMENT 'オフィス',
  `department_code` char(3)  NOT NULL COMMENT '部門コード',
  `belong_code`     char(3)  NOT NULL COMMENT '所属コード',
  `created_at`      datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日',
  `created_by`      char(32) NOT NULL COMMENT '作成者',
  `updated_at`      datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE current_timestamp COMMENT '更新日',
  `update_by`       char(32) NOT NULL COMMENT '更新者',
  `is_deleted`      bit(1)   NOT NULL DEFAULT b'0' COMMENT '削除フラグ',
  PRIMARY KEY (`id`),
  UNIQUE uk_department_belong(department_code, belong_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '分室';

CREATE TABLE work_time
(
  `id`                             char(32) NOT NULL COMMENT 'id',
  `work_date`                      date     NOT NULL COMMENT '年月日',
  `start_time`                     time     NOT NULL COMMENT '始業時間',
  `end_time`                       time     NOT NULL COMMENT '終業時間',
  `official_working_time`          time NULL COMMENT '所定内通常勤務',
  `official_midnight_working_time` time NULL COMMENT '所定内深夜勤務',
  `official_break_time`            time NULL COMMENT '所定内休憩勤務',
  `created_at`                     datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日',
  `created_by`                     char(32) NOT NULL COMMENT '作成者',
  `updated_at`                     datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE current_timestamp COMMENT '更新日',
  `update_by`                      char(32) NOT NULL COMMENT '更新者',
  `is_deleted`                     bit(1)   NOT NULL DEFAULT b'0' COMMENT '削除フラグ',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '作業時間';


CREATE TABLE oauth_client
(
  `id`            char(32)     NOT NULL COMMENT 'id',
  `name`          varchar(255) NOT NULL COMMENT 'OAuthクライアント名',
  `client_id`     varchar(255) NOT NULL COMMENT 'クライアントID',
  `client_secret` varchar(255) NOT NULL COMMENT 'クライアントシークレット',
  `scope`         varchar(255) NOT NULL COMMENT 'スコープ',
  `created_at`    datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日',
  `created_by`    char(32)     NOT NULL COMMENT '作成者',
  `updated_at`    datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE current_timestamp COMMENT '更新日',
  `update_by`     char(32)     NOT NULL COMMENT '更新者',
  `is_deleted`    bit(1)       NOT NULL DEFAULT b'0' COMMENT '削除フラグ',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT 'OAuthクライアント';

CREATE TABLE oauth_client_redirect_url
(
  `id`              char(32)  NOT NULL COMMENT 'id',
  `oauth_client_id` char(32)  NOT NULL COMMENT 'OAuthクライアントid',
  `redirect_url`    char(255) NOT NULL COMMENT 'リダイレクトURL',
  `created_at`      datetime  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日',
  `created_by`      char(32)  NOT NULL COMMENT '作成者',
  `updated_at`      datetime  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE current_timestamp COMMENT '更新日',
  `update_by`       char(32)  NOT NULL COMMENT '更新者',
  `is_deleted`      bit(1)    NOT NULL DEFAULT b'0' COMMENT '削除フラグ',
  PRIMARY KEY (`id`),
  INDEX             idx_oauth_client_id (`oauth_client_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT 'OAuthクライアントリダイレクトURL';

CREATE TABLE oauth2_registered_client
(
  id                            varchar(100)                            NOT NULL,
  client_id                     varchar(100)                            NOT NULL,
  client_id_issued_at           timestamp     DEFAULT CURRENT_TIMESTAMP NOT NULL,
  client_secret                 varchar(200)  DEFAULT NULL,
  client_secret_expires_at      timestamp     DEFAULT NULL,
  client_name                   varchar(200)                            NOT NULL,
  client_authentication_methods varchar(1000)                           NOT NULL,
  authorization_grant_types     varchar(1000)                           NOT NULL,
  redirect_uris                 varchar(1000) DEFAULT NULL,
  scopes                        varchar(1000)                           NOT NULL,
  client_settings               varchar(2000)                           NOT NULL,
  token_settings                varchar(2000)                           NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE oauth_client_consent
(
  registered_client_id varchar(100)  NOT NULL,
  principal_name       varchar(200)  NOT NULL,
  authorities          varchar(1000) NOT NULL,
  PRIMARY KEY (registered_client_id, principal_name)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT 'OAuthクライアント承認';

-- CREATE TABLE oauth2_registered_client
-- (
--   `id`                            char(32)     NOT NULL COMMENT 'id',
--   `client_id`                     varchar(100) NOT NULL COMMENT 'クライアントID',
--   `client_id_issued_at`           TIMESTAMP    NOT NULL COMMENT 'クライアントID発行時間',
--   `client_secret`                 varchar(255) NOT NULL COMMENT 'クライアントシークレット',
--   `client_secret_expires_at`      TIMESTAMP    NOT NULL COMMENT 'クライアントシークレット発行時間',
--   `client_name`                   varchar(255) NOT NULL COMMENT 'クライアント名',
--   `client_authentication_methods` varchar(32)  NOT NULL COMMENT 'クライアント認可メソッド',
--   `authorization_grant_types`     varchar(32)  NOT NULL COMMENT '認可権限タイプ',
--   `redirect_uris`                 varchar(255) NOT NULL COMMENT 'リダイレクトURI',
--   `scopes`                        varchar(255) NOT NULL COMMENT 'スコープ',
--   `client_settings`               varchar(255) NOT NULL COMMENT 'クライアントセッティング',
--   `token_settings`                varchar(255) NOT NULL COMMENT 'トークンセッティング',
--   PRIMARY KEY (`id`),
--   UNIQUE uk_client_id(`client_id`)
-- )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT 'OAuthクライアント登録済み';

CREATE TABLE oauth2_authorization
(
  id                            varchar(100) NOT NULL,
  registered_client_id          varchar(100) NOT NULL,
  principal_name                varchar(200) NOT NULL,
  authorization_grant_type      varchar(100) NOT NULL,
  attributes                    varchar(4000) DEFAULT NULL,
  state                         varchar(500)  DEFAULT NULL,
  authorization_code_value      blob          DEFAULT NULL,
  authorization_code_issued_at  timestamp     DEFAULT NULL,
  authorization_code_expires_at timestamp     DEFAULT NULL,
  authorization_code_metadata   varchar(2000) DEFAULT NULL,
  access_token_value            blob          DEFAULT NULL,
  access_token_issued_at        timestamp     DEFAULT NULL,
  access_token_expires_at       timestamp     DEFAULT NULL,
  access_token_metadata         varchar(2000) DEFAULT NULL,
  access_token_type             varchar(100)  DEFAULT NULL,
  access_token_scopes           varchar(1000) DEFAULT NULL,
  oidc_id_token_value           blob          DEFAULT NULL,
  oidc_id_token_issued_at       timestamp     DEFAULT NULL,
  oidc_id_token_expires_at      timestamp     DEFAULT NULL,
  oidc_id_token_metadata        varchar(2000) DEFAULT NULL,
  refresh_token_value           blob          DEFAULT NULL,
  refresh_token_issued_at       timestamp     DEFAULT NULL,
  refresh_token_expires_at      timestamp     DEFAULT NULL,
  refresh_token_metadata        varchar(2000) DEFAULT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE oauth2_authorization_consent
(
  registered_client_id varchar(100)  NOT NULL,
  principal_name       varchar(200)  NOT NULL,
  authorities          varchar(1000) NOT NULL,
  PRIMARY KEY (registered_client_id, principal_name)
);