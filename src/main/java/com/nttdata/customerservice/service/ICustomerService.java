package com.nttdata.customerservice.service;

import org.bson.types.ObjectId;
import com.nttdata.customerservice.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService {

  public Mono<Customer> finById(ObjectId id);
  
  public Flux<Customer> findAllCustomer();
}
