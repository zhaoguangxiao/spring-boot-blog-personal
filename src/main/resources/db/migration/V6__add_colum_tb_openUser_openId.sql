ALTER TABLE `blog`.`tb_openuser`
ADD COLUMN `openId` varchar(150) NOT NULL COMMENT '代表用户唯一身份的ID' AFTER `avatar`;