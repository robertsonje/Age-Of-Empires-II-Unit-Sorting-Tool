package com.example.CrudRepository.Model;

import org.hibernate.validator.constraints.NotBlank;

public class SearchCriteria {
    @NotBlank(message = "Name of the unit can't be empty.")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
