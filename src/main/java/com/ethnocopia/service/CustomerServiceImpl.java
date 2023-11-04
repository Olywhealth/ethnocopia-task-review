package com.ethnocopia.service;

import com.ethnocopia.dtos.request.CustomerRequest;
import com.ethnocopia.dtos.response.ApiResponse;
import com.ethnocopia.enums.Status;
import com.ethnocopia.exception.CustomException;
import com.ethnocopia.model.Customer;
import com.ethnocopia.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Johnson on 04/11/2023
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public ApiResponse getAllCustomers() {
        log.info("Retrieving all customers");
        List<Customer> allCustomers = customerRepository.findAll();
        return ApiResponse.builder()
                .responseCode(Status.SUCCESSFUL.getCode())
                .message(Status.SUCCESSFUL.getMessage())
                .data(allCustomers)
                .build();
    }

    @Override
    public ApiResponse createCustomer(CustomerRequest request) {
        log.info("Attempt to crete new customer");
        Optional<Customer> customerByEmail = customerRepository.findByEmail(request.email());

        if (customerByEmail.isPresent()) {
            log.error("Customer with the same email already exist");
            throw new CustomException("Customer already exist try login");
        }
        Customer newCustomer = new Customer();
        newCustomer.setName(request.name());
        newCustomer.setEmail(request.email());
        newCustomer.setAge(request.age());
        log.info("New customer successfully created");
        return ApiResponse.builder()
                .responseCode(Status.SUCCESSFUL.getCode())
                .message(Status.SUCCESSFUL.getMessage())
                .data(newCustomer)
                .build();
    }

    @Override
    public ApiResponse deleteCustomer(Integer customerId) {
        log.info("Attempt to delete customer {}", customerId);
        customerRepository.findById(customerId)
                .ifPresentOrElse(
                        customer -> customerRepository.deleteById(customerId),
                        () -> {
                            log.error("No customer with such ID {}", customerId);
                            throw new CustomException("No customer with ID: " + customerId);
                        }
                );
        log.info("Successfully deleted customer {}", customerId);
        return ApiResponse.builder()
                .responseCode(Status.SUCCESSFUL.getCode())
                .message(Status.SUCCESSFUL.getMessage())
                .data(null)
                .build();
    }

    @Override
    public ApiResponse updateCustomer(Integer customerId, CustomerRequest request) {
        log.info("Attempt to update an existing customer");
        return customerRepository.findById(customerId)
                .map(customer -> {
                    customer.setName(request.name());
                    customer.setEmail(request.email());
                    customer.setAge(request.age());
                    customerRepository.save(customer);
                    log.info("Successfully updated customer with ID: {}", customerId);
                    return ApiResponse.builder()
                            .responseCode(Status.SUCCESSFUL.getCode())
                            .message(Status.SUCCESSFUL.getMessage())
                            .data(customer)
                            .build();
                })
                .orElseThrow(() -> new CustomException("No customer with ID: " + customerId));
    }

}
