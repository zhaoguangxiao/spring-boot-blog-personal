CREATE TABLE `tb_user`  (
  `id` int(11)  COMMENT '主键' NOT NULL,
  `email` varchar(255) NOT NULL COMMENT '邮箱',
  `pwd` varchar(255) NOT NULL COMMENT '密码',
  `create_time` bigint(20) NULL COMMENT '创建时间',
  `update_time` bigint(20) NULL COMMENT '更新日期',
  PRIMARY KEY (`id`)
);