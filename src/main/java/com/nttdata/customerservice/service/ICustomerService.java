package com.nttdata.customerservice.service;


import com.nttdata.customerservice.model.Customer;
import com.nttdata.customerservice.model.CustomerType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService {

  public Mono<Customer> finById(String id);
  
  public Flux<Customer> findAllCustomer();
  
  public Mono<Customer> findByIdType(String id);
}
