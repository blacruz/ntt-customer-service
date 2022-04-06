package com.nttdata.customerservice.service;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nttdata.customerservice.model.Customer;
import com.nttdata.customerservice.repository.RepositoryCustomer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class CustomerService implements ICustomerService{
  
  private RepositoryCustomer repositoryCustomer;

  @Override
  @Transactional(readOnly = true)
  public Mono<Customer> finById(ObjectId id) {
    return repositoryCustomer.findById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public Flux<Customer> findAllCustomer() {
    return repositoryCustomer.findAll();
  }

}
