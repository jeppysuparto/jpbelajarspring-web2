package com.jpbelajar.web2.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class SupplierData {

    @NotEmpty(message = "Supplier name can not be empty")
    private String name;

    @NotEmpty(message = "Supplier address can not be empty")
    private String address;

    @NotEmpty(message = "Supplier email can not be empty")
    @Email(message = "Supplier email is not valid")
    private String email;
}
