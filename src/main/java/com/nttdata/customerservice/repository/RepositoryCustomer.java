package com.nttdata.customerservice.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.nttdata.customerservice.model.Customer;
import reactor.core.publisher.Mono;


@Repository
public interface RepositoryCustomer extends ReactiveMongoRepository<Customer, ObjectId>{

  public Mono<Customer> findByFirstName(String firstName);

}
