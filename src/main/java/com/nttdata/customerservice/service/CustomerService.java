package com.nttdata.customerservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nttdata.customerservice.mapper.CustomerInDTOToCustomer;
import com.nttdata.customerservice.model.Customer;
import com.nttdata.customerservice.repository.RepositoryCustomer;
import com.nttdata.customerservice.service.dto.CustomerInDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class CustomerService implements ICustomerService{
  
  @Autowired
  private RepositoryCustomer repositoryCustomer;



  public Mono<Customer> createCustomer(CustomerInDto inDto){
     Customer monoCustomer =  CustomerInDTOToCustomer.map(inDto);
    return repositoryCustomer.save(monoCustomer);
    }
 
  @Override
  @Transactional(readOnly = true)
  public Flux<Customer> findAllCustomer() {
    return repositoryCustomer.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Mono<Customer> finById(String id) {
    return repositoryCustomer.findById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public Mono<Customer> findByIdType(String id) {
    return repositoryCustomer.findByFirstName(id);
  }

  

}
