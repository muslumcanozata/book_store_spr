package com.store.book.domains.dto;

import com.store.book.domains.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
public class CustomersDTO {
    private Long id;
    private String name;
    private String surname;
    private String username;
    @Email(message = "E-Mail should be valid")
    private String email;
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phone_number;
    private List<CustomerCardsDTO> customerCards;
    private List<CustomerAddressesDTO> customerAddresses;
    private Status status;
}
