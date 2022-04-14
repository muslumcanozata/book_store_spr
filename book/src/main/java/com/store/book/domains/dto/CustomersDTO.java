package com.store.book.domains.dto;

import com.store.book.domains.entity.Customers;
import com.store.book.domains.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class CustomersDTO {
    private Long id;
    private String name;
    private String surname;
    private String username;
    @Email(message = "E-Mail should be valid")
    private String email;
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;
    private Status status;

    public static CustomersDTO fromEntityToDTO(Customers customers) {
        CustomersDTO customersDTO = new CustomersDTO();
        if(customers == null) {
            return customersDTO;
        }
        customersDTO.setId(customers.getId());
        customersDTO.setName(customers.getName());
        customersDTO.setSurname(customers.getSurname());
        customersDTO.setUsername(customers.getSurname());
        customersDTO.setEmail(customers.getEmail());
        customersDTO.setPhoneNumber(customers.getPhoneNumber());
        customersDTO.setStatus(customers.getStatus());
        return customersDTO;
    }
}
