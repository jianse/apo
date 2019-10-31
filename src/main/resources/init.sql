CREATE TABLE `users` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户  ID  自增',
`name` varchar(50) NOT NULL DEFAULT 'NULL' COMMENT '用户账户',
`pwd` varchar(50) NOT NULL DEFAULT 'NULL' COMMENT '用户密码',
`realname` varchar(50) NOT NULL DEFAULT 'NULL' COMMENT '用户真实姓名',
`sex` varchar(50) NOT NULL DEFAULT 'NULL' COMMENT '用户性别',
`age` varchar(50) NOT NULL DEFAULT 'NULL' COMMENT '用户年龄',
`card` varchar(50) NOT NULL DEFAULT 'NULL' COMMENT '身份证号',
`address` varchar(100) NULL DEFAULT NULL COMMENT '地址',
`phone` varchar(50) NULL DEFAULT NULL COMMENT '电话',
`email` varchar(50) NULL DEFAULT NULL COMMENT '用户邮箱',
`code` varchar(50) NULL DEFAULT NULL COMMENT '邮政编码',
`type` varchar(50) NULL DEFAULT NULL COMMENT '类型',
PRIMARY KEY (`id`) 
)
COMMENT = '用户表主要用于保存系统用户的资料。';
CREATE TABLE `types` (
`id` integer NOT NULL AUTO_INCREMENT COMMENT '类别id自增',
`name` varchar(50) NOT NULL DEFAULT 'NULL' COMMENT '类别名称',
PRIMARY KEY (`id`) 
)
COMMENT = '类别表主要用于保存菜品所涉及的类别。';
CREATE TABLE `menus` (
`id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id 自增',
`name` varchar(50) NOT NULL COMMENT '菜品名称',
`typeid` varchar(50) NOT NULL COMMENT '菜品类别',
`burden` varchar(100) NULL COMMENT '原材料',
`brief` varchar(500) NULL COMMENT '简介',
`price` varchar(50) NULL COMMENT '单价',
`sums` varchar(50) NULL COMMENT '数量',
`price1` varchar(50) NULL COMMENT '折后单价',
`sums1` varchar(50) NULL COMMENT '优惠数量',
`imgpath` varchar(100) NULL COMMENT '图片',
PRIMARY KEY (`id`) 
)
COMMENT = '菜单表主要保存菜品的款式信息。';
CREATE TABLE `orders` (
`id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID  自增',
`menuid` varchar(50) NOT NULL DEFAULT 'NULL' COMMENT '菜品id',
`userid` varchar(50) NOT NULL DEFAULT 'NULL' COMMENT '用户id',
`menunum` varchar(50) NULL DEFAULT 'NULL' COMMENT '订单数量',
`times` varchar(50) NOT NULL DEFAULT 'NULL' COMMENT '时间',
`delivery` varchar(50) NOT NULL DEFAULT 'NULL' COMMENT '状态（0/1）',
PRIMARY KEY (`id`) 
)
COMMENT = '购买交易表';
CREATE TABLE `notice` (
`id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id 自增',
`name` varchar(50) NOT NULL DEFAULT 'NULL' COMMENT '公告名称',
`content` varchar(100) NOT NULL DEFAULT 'NULL' COMMENT '公告内容',
`times` varchar(50) NOT NULL DEFAULT 'NULL' COMMENT '公告时间',
PRIMARY KEY (`id`) 
)
COMMENT = '公告表主要保存发布的公告。';
CREATE TABLE `admin` (
`id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id 自增',
`name` varchar(50) NOT NULL COMMENT '用户名',
`pwd` varchar(50) NOT NULL COMMENT '密码',
`authority` varchar(10) NOT NULL DEFAULT 'NULL' COMMENT '权限',
PRIMARY KEY (`id`) 
)
COMMENT = '管理员表主要用于保存系统管理员信息。';
