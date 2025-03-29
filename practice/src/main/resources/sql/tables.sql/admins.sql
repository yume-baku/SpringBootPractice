
-- 管理者テーブル
CREATE TABLE `admins` (
  `id`         int NOT NULL AUTO_INCREMENT   COMMENT '管理者ID',
  `last_name`  varchar(255) NOT NULL COMMENT '姓',
  `first_name` varchar(255) NOT NULL COMMENT '名',
  `email`      varchar(255) NOT NULL COMMENT 'メールアドレス',
  `password`   varchar(255) NOT NULL COMMENT 'パスワード', -- 暗号化して保存する
  `current_sign_in_at` TIMESTAMP     COMMENT '最終ログイン日時',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時	',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日時',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4080 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

