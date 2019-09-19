CREATE TABLE `blog`.`tb_openUser`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `open_type` int(2) NOT NULL COMMENT '1 为 qq登录\r\n2 为 github登录',
  `access_token` varchar(255) NOT NULL COMMENT '调用接口需要用到的token，比如利用accessToken发表微博等，如果只是对接登录的话，这个其实没啥用',
  `nick_name` varchar(50) NULL COMMENT '昵称',
  `avatar` varchar(255) NULL COMMENT '头像',
  PRIMARY KEY (`id`)
);