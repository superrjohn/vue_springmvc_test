CREATE TABLE `dept` (
                        `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                        `name` varchar(10) NOT NULL COMMENT '部门名称',
                        `create_time` datetime NOT NULL COMMENT '创建时间',
                        `update_time` datetime NOT NULL COMMENT '修改时间',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门表'