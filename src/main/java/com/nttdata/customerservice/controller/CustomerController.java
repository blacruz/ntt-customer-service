package com.nttdata.customerservice.controller;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nttdata.customerservice.model.Customer;
import com.nttdata.customerservice.service.CustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  private CustomerService customerService;
  
  
  private static final Logger log =LoggerFactory.getLogger(CustomerController.class);
  
  @GetMapping("/{id}")
  public Mono<Customer> show(@PathVariable String id){
    //Mono<Customer> customer = customerService.finById(id);
    Flux<Customer> customers = customerService.findAllCustomer();
    Mono<Customer> customer = customers.filter(c -> c.getId().equals(id))
          .next();
//        .doOnNext(c -> log.info(c.getCustomerType().name()));
    return customer; 
  }
  
  
  @GetMapping("/all")
  public Flux<Customer> index(){
    Flux<Customer> customers = customerService.findAllCustomer();
    return customers;
  }
  
  @GetMapping("/type/{id}")
  public Flux<Object> showType(@PathVariable String id){
    //Mono<Customer> customer = customerService.finById(id);
    Flux<Customer> customers = customerService.findAllCustomer();
    Flux<Object> customer = customers.filter(c -> c.getId().equals(id))
        .map(m -> m.getCustomerType().toString());
    return customer; 
  }
  
  
}
