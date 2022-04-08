package com.nttdata.customerservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.nttdata.customerservice.model.Customer;
import com.nttdata.customerservice.model.CustomerType;
import com.nttdata.customerservice.repository.RepositoryCustomer;
import reactor.test.StepVerifier;


@SpringBootTest
@ActiveProfiles("test")
class CustomerServiceApplicationTests {

  @Autowired
  private RepositoryCustomer customersRepo;

  @BeforeAll
  public static void setup() {
    System.setProperty("jdk.tls.client.protocols", "TLSv1.2");
  }

  @Test
  void CreateCustomer() {
    var customer = new Customer();
    customer.setFirstName("Dennilson");
    customer.setLastName("Muñoz");
    customer.setCustomerType(CustomerType.NATURAL);

    var saveCustomer = customersRepo.save(customer).block();

    var customertDb = customersRepo.findByFirstName("Dennilson");
    StepVerifier.create(customertDb).assertNext(cust -> {
      assertEquals(CustomerType.NATURAL, cust.getCustomerType());
    }).expectComplete().verify();
    
    
    //customersRepo.deleteById(saveCustomer.getId()).block();
  }

}
