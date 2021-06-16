package com.cardcoupon.passbook.constant;

/**
 * The Error information when merchants are created
 * created by Di Lu
 */
public enum ErrorCode {
    SUCCESS(0,""),
    DUPLICATE_NAME(1,"The name of merchants are duplicated"),
    EMPTY_LOGO(2,"The logo field is empty"),
    EMPTY_BUSINESS_LICENSE(3,"The license field is empty"),
    ERROR_PHONE(4, "The phone is wrong"),
    EMPTY_ADDRESS(5,"The address field is empty"),
    MERCHANTS_NOT_EXIST(6,"Merchants do not exist");

    private Integer code;
    private String desc;

    ErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
