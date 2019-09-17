ALTER TABLE `tb_user`
ADD COLUMN `user_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称' AFTER `update_time`;