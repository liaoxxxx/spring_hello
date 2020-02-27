/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : spring

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2020-02-27 02:43:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `avatars` varchar(255) DEFAULT NULL,
  `is_administrator` tinyint(4) DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `sys_role_id` int(11) DEFAULT NULL,
  `admin_detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn7kdvesgar2l35ta9r2voj3i7` (`sys_role_id`),
  KEY `FKg7a10a79dxl37k1qlenec6ieo` (`admin_detail_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'https://pic4.zhimg.com/v2-8e5c071fec812465fbd806f537933a48_xll.jpg 2x', '1', '0', 'liaoxx', '123456', 'liaoxxx lege xx', 'dwdwd', '1', 'admin', '1', null, '1');
INSERT INTO `admin` VALUES ('2', '\'\'', '2', '0', 'liaoxx', '123456', 'liaoxxx lege xx', 'dwdwd', '1', 'editor', '1', null, '2');

-- ----------------------------
-- Table structure for admin_detail
-- ----------------------------
DROP TABLE IF EXISTS `admin_detail`;
CREATE TABLE `admin_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `sexy` tinyint(4) DEFAULT NULL,
  `updated_at` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin_detail
-- ----------------------------
INSERT INTO `admin_detail` VALUES ('1', '1565454574', '993501756@qq.com', '18676684597', 'liaoxx detail', '1', '465465654');

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES ('1', '1', '1');
INSERT INTO `admin_role` VALUES ('2', '1', '2');
INSERT INTO `admin_role` VALUES ('3', '1', '3');

-- ----------------------------
-- Table structure for bili_recommend_entity
-- ----------------------------
DROP TABLE IF EXISTS `bili_recommend_entity`;
CREATE TABLE `bili_recommend_entity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `typename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of bili_recommend_entity
-- ----------------------------
INSERT INTO `bili_recommend_entity` VALUES ('1', '69023878', 'Sawako碎花子', '▼Original：银色飞行船 - supercell\n▼Mix：神宝\n▼Encode&Vocal：我\n\n祝我生日快乐，\n这已经是我在B站第三个生日投稿了，\n谢谢神宝每年都帮助我完成满意的投稿。\n通过翻唱有幸认识了很多人，\n谢谢听众和身边朋友一直以来的陪伴和支持，以后也会作为爱好继续唱下去的。', '477007', 'http://i2.hdslb.com/bfs/archive/e50c615734b0567903a5249c1abf8d296e05e32e.jpg', '', '【碎花】银色飞行船 HB to me', '翻唱');
INSERT INTO `bili_recommend_entity` VALUES ('2', '67864967', '流浪者工作室', '前情提要：为了阻止世界毁灭之日的到来，受到邀请的五位“专家”组成了特别行动小队，即将开始护送目标内容物。而为了让过程更为顺利，组织者提议小队成员们在行动正式开始之前先来进行一次简单的“自我介绍”……\n——————————\n出品方：流浪者工作室\n跑团组：Louz、发狂、大风、子珏、夜夜夜、泰普兰、艾恩\n文案组：Louz、发狂、泰普兰、法系之友刺客\n美术组：Louz、孟韩君、现世的魔法少女、马、洛迪、大风、青山不正、半只橘\n视频组：Louz、半拥妖榭、洛迪、林间山色、半只橘\n配音组：Louz、驭宴、冷皇、蓝风', '397082443', 'http://i1.hdslb.com/bfs/archive/bcc6a772d6c8c2ae3b28b410644549c043256bea.jpg', '', '【流浪者工作室】镜中神话丨卡涅阿德斯的方舟 - 第0集', '短片·手书·配音');
INSERT INTO `bili_recommend_entity` VALUES ('3', '67853417', '祀舞。', 'KURIN：录得很快捷，发得很艰难的舞。又是个年更合舞^^继续期待明年\n45：我又投稿啦！没想到吧~~~\n音源：sm32921516 编舞：sm34093730\n摄影后期：hana ←辛苦啦谢谢！\n【禁止搬运及二次创作】', '317922', 'http://i1.hdslb.com/bfs/archive/3f482a9f0bf9b8c8c0fcd153d7331fb11142afff.jpg', '', '【KURIN×祀舞】SNOBBISM', '宅舞');
INSERT INTO `bili_recommend_entity` VALUES ('4', '64880110', 'Sawadika_萨瓦迪卡', '上次看评论说想看新宝岛\n趁着今天生日即兴freestyle一波\n1分40秒高能预警\n请忽略我宅了几天没洗的脸和头\n还有一个月内剪的秀发', '305411908', 'http://i0.hdslb.com/bfs/archive/679b72224fd6f6f36b4b23bda8a16d4d8c0b434f.jpg', '', '【新宝岛】猛男版太难了，改编了一个肥宅版', null);
INSERT INTO `bili_recommend_entity` VALUES ('5', '51302756', '平沢唯KON', '剪了一天两夜吧，本来想用Rise - Epic Music这首BGM的，发现太多人用了，就选了比较喜欢的梦龙的一首歌，致我最喜欢的超级英雄托尼斯塔克——钢铁侠\n没硬币的话点个推荐就好了，支持一下！\nBGM：Demons---Imagine Dragons\n素材：钢铁侠1,2,3；复仇者联盟1,2,3；美国队长3；蜘蛛侠 英雄归来', '100669319', 'http://i1.hdslb.com/bfs/archive/4b8c683bd93502338b3fe1b2a5362695ff808e2b.jpg', '', '【钢铁侠个人向】I love you more than three thousand.', '影视剪辑');
INSERT INTO `bili_recommend_entity` VALUES ('6', '53447524', '赫_一号机', 'Niconico ：https://www.nicovideo.jp/watch/sm35145654\nYouTube ：https://youtu.be/Fb1_fpuYX1I\n\nDIVELAです。 ミクさんの歌です。\n\n■曲＆歌詞＆調声：DIVELA：https://twitter.com/MIX_Destroy\n■絵：白雪とわ 様：https://twitter.com/ShirayukiTowa\n■お歌：初音ミク \n\n♨前作 『REVENGE DOLL 39』 ：sm34867297\n\nマイリスト', '797614', 'http://i0.hdslb.com/bfs/archive/63d1158f0b6f4ecadf4cfcaa0393b163d8f0899c.jpg', '', '【初音ミク】在那里存在着生命吗？【DIVELA】', 'VOCALOID·UTAU');

-- ----------------------------
-- Table structure for dto
-- ----------------------------
DROP TABLE IF EXISTS `dto`;
CREATE TABLE `dto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creat_time` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dto
-- ----------------------------

-- ----------------------------
-- Table structure for express_provider
-- ----------------------------
DROP TABLE IF EXISTS `express_provider`;
CREATE TABLE `express_provider` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` bigint(20) DEFAULT NULL,
  `express_provider_char` varchar(255) DEFAULT NULL,
  `express_provider_code` varchar(255) DEFAULT NULL,
  `express_provider_customer_name` varchar(255) DEFAULT NULL,
  `express_provider_name` varchar(255) DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `updated_at` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of express_provider
-- ----------------------------
INSERT INTO `express_provider` VALUES ('1', '1571601432197', 'jingdongkuaidi', 'JD', '020K373812', '京东快递', '0', '这是京东快递的备注', '1', '1571601432197');

-- ----------------------------
-- Table structure for express_query_cache
-- ----------------------------
DROP TABLE IF EXISTS `express_query_cache`;
CREATE TABLE `express_query_cache` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` bigint(20) DEFAULT NULL,
  `datas` varchar(255) DEFAULT NULL,
  `expire_at` bigint(20) DEFAULT NULL,
  `express_no` varchar(255) DEFAULT NULL,
  `express_provider_code` varchar(255) DEFAULT NULL,
  `express_provider_name` varchar(255) DEFAULT NULL,
  `updated_at` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of express_query_cache
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `base_price` float NOT NULL,
  `cate_id` varchar(255) DEFAULT NULL,
  `created_at` bigint(20) NOT NULL,
  `created_at_str` varchar(255) DEFAULT NULL,
  `images` varchar(255) DEFAULT NULL,
  `input_price` float NOT NULL,
  `is_delete` tinyint(4) NOT NULL,
  `name` varchar(255) NOT NULL,
  `show_price` tinyint(4) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `update_at_str` varchar(255) DEFAULT NULL,
  `updated_at` bigint(20) NOT NULL,
  `sub_title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('30', '50', '22', '1577692131485', null, '[\"\\\\image\\\\202012\\\\30\\\\1577692002464.jpg\",\"\\\\image\\\\202012\\\\30\\\\1577692002441.jpg\"]', '45', '0', '个合同两份合同和', '0', '1', '唱歌和', '换了个路过路过路过', null, '1577692131485', '达瓦达瓦达瓦单位单位搞了个');
INSERT INTO `goods` VALUES ('31', '50', '22', '1577692160653', null, '[\"\\\\image\\\\202012\\\\30\\\\1577692002464.jpg\",\"\\\\image\\\\202012\\\\30\\\\1577692002441.jpg\"]', '45', '0', '电脑', '0', '1', '唱歌和', '换了个咯咯咯', null, '1577692160653', '达瓦达瓦达瓦好得很');
INSERT INTO `goods` VALUES ('32', '50', '22', '1577692162675', null, '[\"\\\\image\\\\202012\\\\30\\\\1577692002464.jpg\",\"\\\\image\\\\202012\\\\30\\\\1577692002441.jpg\"]', '45', '0', '电脑', '0', '1', '唱歌和', '换了个咯咯咯', null, '1577692162675', '达瓦达瓦达瓦好得很');
INSERT INTO `goods` VALUES ('33', '50', '22', '1577692162859', null, '[\"\\\\image\\\\202012\\\\30\\\\1577692002464.jpg\",\"\\\\image\\\\202012\\\\30\\\\1577692002441.jpg\"]', '45', '0', '电脑', '0', '1', '唱歌和', '换了个咯咯咯', null, '1577692162859', '达瓦达瓦达瓦好得很');
INSERT INTO `goods` VALUES ('34', '50', '22', '1577692163020', null, '[\"\\\\image\\\\202012\\\\30\\\\1577692002464.jpg\",\"\\\\image\\\\202012\\\\30\\\\1577692002441.jpg\"]', '45', '0', '电脑', '0', '1', '唱歌和', '换了个咯咯咯', null, '1577692163020', '达瓦达瓦达瓦好得很');
INSERT INTO `goods` VALUES ('35', '50', '22', '1577692163180', null, '[\"\\\\image\\\\202012\\\\30\\\\1577692002464.jpg\",\"\\\\image\\\\202012\\\\30\\\\1577692002441.jpg\"]', '45', '0', '电脑', '0', '1', '唱歌和', '换了个咯咯咯', null, '1577692163180', '达瓦达瓦达瓦好得很');

-- ----------------------------
-- Table structure for goods_category
-- ----------------------------
DROP TABLE IF EXISTS `goods_category`;
CREATE TABLE `goods_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(255) DEFAULT NULL,
  `parent_id` int(6) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `thumb` varchar(255) DEFAULT NULL,
  `created_at` bigint(13) DEFAULT NULL,
  `updated_at` bigint(13) DEFAULT NULL,
  `created_at_str` varchar(255) DEFAULT NULL,
  `update_at_str` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods_category
-- ----------------------------
INSERT INTO `goods_category` VALUES ('21', '消毒柜', '1', '1', '就是消毒柜啊', null, '1573493605341', '1573493605341', null, null);
INSERT INTO `goods_category` VALUES ('2', '家用电器', '1', '1', '就是家用电器啊', null, '1573456628048', '1573456628048', null, null);
INSERT INTO `goods_category` VALUES ('3', '洗衣机', '1', '1', '洗衣服的机器', null, '1573485864330', '1573485864330', null, null);
INSERT INTO `goods_category` VALUES ('4', '电视机', '1', '1', '就是电视机啊', null, '1573486562682', '1573486562682', null, null);
INSERT INTO `goods_category` VALUES ('5', '空调', '1', '1', '就是空调啊', null, '1573486799319', '1573486799319', null, null);
INSERT INTO `goods_category` VALUES ('6', '饮水机', '1', '1', '就是饮水机啊', null, '1573486947888', '1573486947888', null, null);
INSERT INTO `goods_category` VALUES ('7', '抽油烟机', '1', '1', '就是抽油烟机啊', null, '1573487015671', '1573487015671', null, null);
INSERT INTO `goods_category` VALUES ('1', '主分类', '0', '1', '就是', null, '1573456628048', '1573456628048', null, null);
INSERT INTO `goods_category` VALUES ('22', '吸尘器', '1', '1', '就是吸尘器啊', null, '1573493736141', '1573493736141', null, null);
INSERT INTO `goods_category` VALUES ('23', '电脑办公l', '10', '1', '就是电脑办公类a', null, '1573668860715', '1575985335738', null, null);

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '', '管理员', 'admin');
INSERT INTO `role` VALUES ('2', '', '财务', 'finance');
INSERT INTO `role` VALUES ('3', '', '小编', 'editor');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `resource_type` enum('menu','button') DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '\0', '用户管理', '0', '0/', 'userInfo:view', 'menu', 'userInfo/userList');
INSERT INTO `sys_permission` VALUES ('2', '\0', '用户添加', '1', '0/1', 'userInfo:add', 'button', 'userInfo/userAdd');
INSERT INTO `sys_permission` VALUES ('3', '\0', '用户删除', '1', '0/1', 'userInfo:del', 'button', 'userInfo/userDel');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '\0', '管理员', 'admin');
INSERT INTO `sys_role` VALUES ('2', '\0', 'VIP会员', 'vip');
INSERT INTO `sys_role` VALUES ('3', '', 'test', 'test');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  KEY `FKomxrs8a388bknvhjokh440waq` (`permission_id`),
  KEY `FK9q28ewrhntqeipl1t04kh1be7` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '2');
INSERT INTO `sys_role_permission` VALUES ('2', '3');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `role_id` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  KEY `FKgkmyslkrfeyn9ukmolvek8b8f` (`uid`),
  KEY `FKhh52n8vd4ny9ff4x9fb8v65qx` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');

-- ----------------------------
-- Table structure for upload_file
-- ----------------------------
DROP TABLE IF EXISTS `upload_file`;
CREATE TABLE `upload_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` bigint(20) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `updated_at` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of upload_file
-- ----------------------------
INSERT INTO `upload_file` VALUES ('1', '1576676892587', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\18\\1576676892584.jpg', '1576676892587');
INSERT INTO `upload_file` VALUES ('2', '1576676915746', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\18\\1576676915744.jpg', '1576676915746');
INSERT INTO `upload_file` VALUES ('3', '1576677400811', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\18\\1576677400809.jpg', '1576677400811');
INSERT INTO `upload_file` VALUES ('4', '1576677412199', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\18\\1576677412197.jpg', '1576677412199');
INSERT INTO `upload_file` VALUES ('5', '1577204619303', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577204619298.jpg', '1577204619303');
INSERT INTO `upload_file` VALUES ('6', '1577204634810', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577204634807.jpg', '1577204634810');
INSERT INTO `upload_file` VALUES ('7', '1577204640609', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577204640604.jpg', '1577204640609');
INSERT INTO `upload_file` VALUES ('8', '1577204684022', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577204684016.jpg', '1577204684022');
INSERT INTO `upload_file` VALUES ('9', '1577204684044', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577204684041.jpg', '1577204684044');
INSERT INTO `upload_file` VALUES ('10', '1577204764822', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577204764817.jpg', '1577204764822');
INSERT INTO `upload_file` VALUES ('11', '1577204807965', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577204807961.jpg', '1577204807965');
INSERT INTO `upload_file` VALUES ('12', '1577204807965', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577204807960.jpg', '1577204807965');
INSERT INTO `upload_file` VALUES ('13', '1577204844517', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577204844511.jpg', '1577204844517');
INSERT INTO `upload_file` VALUES ('14', '1577204844519', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577204844515.jpg', '1577204844519');
INSERT INTO `upload_file` VALUES ('15', '1577204965169', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577204965165.jpg', '1577204965169');
INSERT INTO `upload_file` VALUES ('16', '1577204965177', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577204965171.jpg', '1577204965177');
INSERT INTO `upload_file` VALUES ('17', '1577205011052', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577205011046.jpg', '1577205011052');
INSERT INTO `upload_file` VALUES ('18', '1577205011059', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577205011045.jpg', '1577205011059');
INSERT INTO `upload_file` VALUES ('19', '1577205011060', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577205011051.jpg', '1577205011060');
INSERT INTO `upload_file` VALUES ('20', '1577205124445', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577205124434.jpg', '1577205124445');
INSERT INTO `upload_file` VALUES ('21', '1577205124457', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577205124449.jpg', '1577205124457');
INSERT INTO `upload_file` VALUES ('22', '1577205124450', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577205124443.jpg', '1577205124450');
INSERT INTO `upload_file` VALUES ('23', '1577205163409', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577205163402.jpg', '1577205163409');
INSERT INTO `upload_file` VALUES ('24', '1577280993780', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577280993774.jpg', '1577280993780');
INSERT INTO `upload_file` VALUES ('25', '1577281032543', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577281032541.jpg', '1577281032543');
INSERT INTO `upload_file` VALUES ('26', '1577281038965', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577281038961.jpg', '1577281038965');
INSERT INTO `upload_file` VALUES ('27', '1577281156408', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577281156404.jpg', '1577281156408');
INSERT INTO `upload_file` VALUES ('28', '1577281159996', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577281159991.jpg', '1577281159996');
INSERT INTO `upload_file` VALUES ('29', '1577281163630', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577281163625.jpg', '1577281163630');
INSERT INTO `upload_file` VALUES ('30', '1577281267297', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577281267281.jpg', '1577281267297');
INSERT INTO `upload_file` VALUES ('31', '1577281270545', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577281270540.jpg', '1577281270545');
INSERT INTO `upload_file` VALUES ('32', '1577281344792', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577281344784.jpg', '1577281344792');
INSERT INTO `upload_file` VALUES ('33', '1577281344794', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577281344788.jpg', '1577281344794');
INSERT INTO `upload_file` VALUES ('34', '1577281519460', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577281519457.jpg', '1577281519460');
INSERT INTO `upload_file` VALUES ('35', '1577281519460', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577281519451.jpg', '1577281519460');
INSERT INTO `upload_file` VALUES ('36', '1577281567992', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577281567974.jpg', '1577281567992');
INSERT INTO `upload_file` VALUES ('37', '1577281568003', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577281567999.jpg', '1577281568003');
INSERT INTO `upload_file` VALUES ('38', '1577281567992', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577281567973.jpg', '1577281567992');
INSERT INTO `upload_file` VALUES ('39', '1577282804691', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\25\\1577282804686.jpg', '1577282804691');
INSERT INTO `upload_file` VALUES ('40', '1577290425584', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\201912\\26\\1577290425579.jpg', '1577290425584');
INSERT INTO `upload_file` VALUES ('41', '1577681251622', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\1577681251615202012\\30\\.jpg', '1577681251622');
INSERT INTO `upload_file` VALUES ('42', '1577681255004', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\1577681254999202012\\30\\.jpg', '1577681255004');
INSERT INTO `upload_file` VALUES ('43', '1577683037276', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\1577683037267202012\\30\\.jpg', '1577683037276');
INSERT INTO `upload_file` VALUES ('44', '1577688265485', 'D:\\coding\\spring_hello\\src\\main\\resources\\public\\upload\\image\\1577688265480202012\\30\\.jpg', '1577688265485');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(16) DEFAULT NULL,
  `password` varchar(128) NOT NULL DEFAULT '',
  `nickname` varchar(16) NOT NULL DEFAULT '',
  `salt` varchar(64) NOT NULL DEFAULT '',
  `avatars` varchar(255) NOT NULL DEFAULT '',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0',
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'liaoxx', 'dwdwdwdwd', '廖xx', 'dwdw', 'https://pic4.zhimg.com/v2-8e5c071fec812465fbd806f537933a48_xl.jpg', '0', '1');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `uid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `state` tinyint(4) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '管理员', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '0', 'admin');
