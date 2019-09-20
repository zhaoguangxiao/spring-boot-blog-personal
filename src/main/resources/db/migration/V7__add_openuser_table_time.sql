ALTER TABLE `blog`.`tb_openuser`
ADD COLUMN `create_time` bigint(20) NULL COMMENT '创建时间' AFTER `openId`,
ADD COLUMN `update_time` bigint(20) NULL COMMENT '更新时间' AFTER `create_time`;