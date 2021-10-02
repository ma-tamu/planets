CREATE TABLE user
(
  `id`          char(32)     NOT NULL COMMENT 'id',
  `employee_no` varchar(7)   NOT NULL COMMENT '社員番号',
  `first_name`  varchar(32)  NOT NULL COMMENT '名',
  `last_name`   varchar(32)  NOT NULL COMMENT '姓',
  `gender`      char(1)      NOT NULL COMMENT '性別',
  `mail`        varchar(255) NOT NULL COMMENT 'メールアドレス',
  `password`    varchar(255) NOT NULL COMMENT 'パスワード',
  `office_id`   char(32)     NOT NULL COMMENT '所属オフィス',
  `created_at`  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日',
  `created_by`  char(32)     NOT NULL COMMENT '作成者',
  `updated_at`  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE current_timestamp COMMENT '更新日',
  `update_by`   char(32)     NOT NULL COMMENT '更新者',
  `is_deleted`  bit(1)       NOT NULL DEFAULT b'0' COMMENT '削除フラグ',
  PRIMARY KEY (`id`),
  UNIQUE uk_employee_no(employee_no)
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
  `id`         char(32) NOT NULL COMMENT 'id',
  `work_date`  date     NOT NULL COMMENT '年月日',
  `start_at`   time     NOT NULL COMMENT '始業時間',
  `end_at`     time     NOT NULL COMMENT '終業時間',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日',
  `created_by` char(32) NOT NULL COMMENT '作成者',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE current_timestamp COMMENT '更新日',
  `update_by`  char(32) NOT NULL COMMENT '更新者',
  `is_deleted` bit(1)   NOT NULL DEFAULT b'0' COMMENT '削除フラグ',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '作業時間';