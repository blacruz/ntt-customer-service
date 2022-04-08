package com.nttdata.customerservice.service.dto;


import java.util.List;
import com.nttdata.customerservice.model.Address;
import com.nttdata.customerservice.model.Contact;
import com.nttdata.customerservice.model.Documents;
import lombok.Data;


@Data
public class CustomerInDto {
  
  private String firstName;
  private String lastName;
  private List<Contact> contacts;
  private List<Address> addresses;
  private List<Documents> documents;
  

}
