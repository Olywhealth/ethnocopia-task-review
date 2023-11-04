package com.ethnocopia.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * @author Johnson on 04/11/2023
 */
public record CustomerRequest(

        @NotBlank(message = "Name should not be empty")
        String name,
        @NotBlank(message = "Email must not be empty")
        String email,
        @Pattern(regexp = "[0-9]{3}", message = "Age should be of numeric value only")
        Integer age
) {
}
