package com.nttdata.customerservice.mapper;

import java.time.LocalDateTime;
import com.nttdata.customerservice.model.Customer;
import com.nttdata.customerservice.model.CustomerStatus;
import com.nttdata.customerservice.model.CustomerType;
import com.nttdata.customerservice.service.dto.CustomerInDto;

public class CustomerInDTOToCustomer {


  public static Customer map(CustomerInDto in) {
   Customer customer = new Customer();
   customer.setFirstName(in.getFirstName());
   customer.setLastName(in.getLastName());
   customer.setCreateDate(LocalDateTime.now());
   customer.setCustomerType(CustomerType.NATURAL);
   customer.setCustomerStatus(CustomerStatus.ENABLED);
   customer.setAddresses(in.getAddresses());
   customer.setContacts(in.getContacts());
   customer.setDocuments(in.getDocuments());
   return customer;
  }

}
