package com.ethnocopia.dtos.response;

import lombok.*;

/**
 * @author Johnson on 04/11/2023
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {

    private String responseCode;
    private String message;
    private Object data;

}
