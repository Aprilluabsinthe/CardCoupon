package com.cardcoupon.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * the general object for response
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    /**
     * the error code, 0 to be default
     */
    private Integer errorCode = 0;

    /**
     * the error Message, empty to be default
     */
    private String errorMessage = "";

    /**
     * the data object to return to
     */
    private Object data;

    /**
     * <h2> the constrcutor for response data</h2>
     * @param data the data object to be return to.
     */
    public Response(Object data) {
        this.data = data;
    }

}
