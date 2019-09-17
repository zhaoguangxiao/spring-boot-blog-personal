ALTER TABLE `blog`.`tb_user`
ADD COLUMN `img` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户头像' AFTER `user_name`;