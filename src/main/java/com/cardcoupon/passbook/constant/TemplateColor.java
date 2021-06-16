package com.cardcoupon.passbook.constant;

/**
 * <h1>The background color of a token</h1>
 * Created by Di Lu
 */
public enum TemplateColor {
    RED(1,"red"),
    GREEN(1,"green"),
    BLUE(1,"blue");

    private Integer code;
    private String color;

    TemplateColor(Integer code, String color) {
        this.code = code;
        this.color = color;
    }

    public Integer getCode(){
        return this.code;
    }

    public String getColor() {
        return this.color;
    }
}
