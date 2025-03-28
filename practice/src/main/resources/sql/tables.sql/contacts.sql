CREATE TABLE `contacts` (
  `id`            int NOT NULL AUTO_INCREMENT  COMMENT 'お問い合わせID',
  `last_name`     varchar(255) NOT NULL COMMENT '姓',
  `first_name`    varchar(255) NOT NULL COMMENT '名',
  `email`         varchar(255) NOT NULL COMMENT 'メールアドレス',
  `phone`         varchar(11)  NOT NULL COMMENT '電話番号',
  `zip_code`      varchar(8)   NOT NULL COMMENT '郵便番号',
  `address`       varchar(255) NOT NULL COMMENT '住所',
  `building_name` varchar(255) NOT NULL COMMENT '建物名',
  `contact_type`  varchar(50)  NOT NULL COMMENT 'お問い合わせ種別',
  `body`          text         NOT NULL COMMENT '	内容',
  `updated_at`    timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `created_at`    timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日時',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci