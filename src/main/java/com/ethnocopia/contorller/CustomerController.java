package com.ethnocopia.contorller;

import com.ethnocopia.dtos.request.CustomerRequest;
import com.ethnocopia.dtos.response.ApiResponse;
import com.ethnocopia.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Johnson on 04/11/2023
 */
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;


    @GetMapping("/all")
    public ApiResponse getCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/signup")
    public ApiResponse addCustomer(@Valid @RequestBody CustomerRequest request) {
        return customerService.createCustomer(request);
    }

    @DeleteMapping("/{customerId}")
    public ApiResponse deleteCustomer(@PathVariable Integer customerId) {
        return customerService.deleteCustomer(customerId);
    }

    @PutMapping("/{customerId}/update")
    public ApiResponse updateCustomer(@Valid @RequestBody CustomerRequest request, @PathVariable Integer customerId) {
        return customerService.updateCustomer(customerId, request);
    }
}
