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

CREATE TABLE oauth_client_consent
(
  `id`              char(32)     NOT NULL COMMENT 'id',
  `oauth_client_id` char(32)     NOT NULL COMMENT 'OAuthクライアントID',
  `user_id`         char(32)     NOT NULL COMMENT 'ユーザーID',
  `scope`           varchar(255) NOT NULL COMMENT 'スコープ',
  `created_at`      datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日',
  `created_by`      char(32)     NOT NULL COMMENT '作成者',
  `is_deleted`      bit(1)       NOT NULL DEFAULT b'0' COMMENT '削除フラグ',
  PRIMARY KEY (`id`),
  INDEX             idx_oauth_client_id_user_id (`oauth_client_id`, `user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT 'OAuthクライアント承認';
