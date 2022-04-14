package com.store.book.domains.dto;

import com.store.book.domains.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CustomerInsertRequestDTO {
    private String name;
    private String surname;
    private String username;
    @Email(message = "E-Mail should be valid")
    private String email;
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;
    private Status status;
}
