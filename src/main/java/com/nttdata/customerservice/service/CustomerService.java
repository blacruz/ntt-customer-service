package com.nttdata.customerservice.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nttdata.customerservice.mapper.CompanyInDTOCustomer;
import com.nttdata.customerservice.mapper.CustomerInDTOToCustomer;
import com.nttdata.customerservice.model.Customer;
import com.nttdata.customerservice.model.CustomerStatus;
import com.nttdata.customerservice.repository.RepositoryCustomer;
import com.nttdata.customerservice.service.dto.CompanyInDto;
import com.nttdata.customerservice.service.dto.CustomerInDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class CustomerService implements ICustomerService{
  
  private static final Logger logger_consola = LoggerFactory.getLogger("consola");
  private static final Logger logger_file = LoggerFactory.getLogger("clients_log");
  
  @Autowired
  private RepositoryCustomer repositoryCustomer;



  public Mono<Customer> createCustomer(CustomerInDto inDto){
     Customer monoCustomer =  CustomerInDTOToCustomer.map(inDto);
    return repositoryCustomer.save(monoCustomer);
    }
  
  public Mono<Customer> createCompany(CompanyInDto companyInDto){
    Customer customer = CompanyInDTOCustomer.map(companyInDto);
    return repositoryCustomer.save(customer);
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

  @Override
  public Mono<Customer> updateCustomer(Customer customer) {
    return repositoryCustomer.findById(customer.getId())
        .map(data -> {
          repositoryCustomer.save(customer).subscribe();
          logger_file.info("Updated the client with id= {}", customer.getId());
          logger_consola.info("Updated the client with id= {}", customer.getId());
          return customer;
        });
  }

  @Override
  public Mono<Customer> deleteCustomer(String id) {
 
    return repositoryCustomer.findById(new String(id))
        .map(customer -> {
          customer.setCustomerStatus(CustomerStatus.DISABLED);
          repositoryCustomer.save(customer).subscribe();
          
          logger_file.info("Deleted the customer with id= {}", id);
          logger_consola.info("Deleted the customer with id= {}", id);

          return customer;
        });
  }

  

  

}
