package com.jpbelajar.web2.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CategoryData {

    @NotEmpty(message="Category name can not be empty")
    private String name;

}
