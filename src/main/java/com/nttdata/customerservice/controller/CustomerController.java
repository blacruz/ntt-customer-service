package com.nttdata.customerservice.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nttdata.customerservice.dtoaccounts.AccountType;
import com.nttdata.customerservice.dtoaccounts.BalanceDTO;
import com.nttdata.customerservice.model.Customer;
import com.nttdata.customerservice.model.CustomerType;
import com.nttdata.customerservice.service.CustomerService;
import com.nttdata.customerservice.service.dto.CompanyInDto;
import com.nttdata.customerservice.service.dto.CustomerInDto;
import com.nttdata.customerservice.webclientimpl.WebClientAccountService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  private CustomerService customerService;
  
  @Autowired
  private WebClientAccountService accountService;


  private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

  @GetMapping("/{id}")
  public Mono<Customer> show(@PathVariable String id) {
    // Mono<Customer> customer = customerService.finById(id);
    Flux<Customer> customers = customerService.findAllCustomer();
    Mono<Customer> customer = customers.filter(c -> c.getId().equals(id)).next();
    // .doOnNext(c -> log.info(c.getCustomerType().name()));
    return customer;
  }


  @GetMapping("/all")
  public Flux<Customer> index() {
    Flux<Customer> customers = customerService.findAllCustomer();
    return customers;
  }

  @GetMapping("/type/{id}")
  public Mono<CustomerType> showType(@PathVariable String id) {
    Mono<Customer> customers = customerService.finById(id);
    var customer = customers.switchIfEmpty(Mono.error(new RuntimeException("Customer not found")))
        .map(c -> c.getCustomerType());
    return customer;
  }

  @PostMapping("/customer")
  public Mono<Customer> createCustomer(@RequestBody CustomerInDto dto) {
    Mono<Customer> monoCustomer = customerService.createCustomer(dto);
    return monoCustomer;
  }


  @PostMapping("/commpany")
  public Mono<Customer> createCompany(@RequestBody CompanyInDto companyInDto) {
    Mono<Customer> monoCustomer = customerService.createCompany(companyInDto);
    return monoCustomer;
  }


  @PutMapping("/id/{id}")
  public Mono<Customer> updateCsutomer(@PathVariable String id, @RequestBody Customer customer) {
    // Customer customer2 = new Customer();
    // customer2.setId(id);
    return customerService.updateCustomer(customer);
  }


  @DeleteMapping("/id/{id}")
  public Mono<Customer> deleteCustomer(@PathVariable String id) {

    return customerService.deleteCustomer(id);
  }
  
  @GetMapping("/{id}/products")
    public Flux<BalanceDTO> getAllProducts(@PathVariable String id){
      return accountService.getAccountByIdCustomer(id);
    }

}
