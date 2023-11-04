package com.ethnocopia.service;

import com.ethnocopia.dtos.request.CustomerRequest;
import com.ethnocopia.dtos.response.ApiResponse;

/**
 * @author Johnson on 04/11/2023
 */
public interface CustomerService {

    ApiResponse getAllCustomers();

    ApiResponse createCustomer(CustomerRequest request);

    ApiResponse deleteCustomer(Integer customerId);

    ApiResponse updateCustomer(Integer customerId, CustomerRequest request);
}
