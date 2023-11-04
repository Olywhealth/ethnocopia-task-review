package com.ethnocopia.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Johnson on 04/11/2023
 */
@Getter
@RequiredArgsConstructor
public enum Status {

    SUCCESSFUL("00","SUCCESS","Registration successfully"),
    FAILED("01","FAILED","Registration failed");

    private final String code;
    private final String Status;
    private final String message;
}
