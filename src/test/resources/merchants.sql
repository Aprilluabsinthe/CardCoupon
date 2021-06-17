CREATE TABLE `merchants`(
    `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'Name of Merchant',
    `logo_url` varchar(256) COLLATE utf8_bin NOT NULL COMMENT 'logo of Merchant',
    `business_license_url` varchar(256 ) COLLATE utf8_bin NOT NULL COMMENT 'complement license of Merchant',
    `phone` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'Contact Phone',
    `address` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'Contact Address',
    `is_audit` BOOLEAN COLLATE utf8_bin NOT NULL COMMENT 'Is audited or not',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
