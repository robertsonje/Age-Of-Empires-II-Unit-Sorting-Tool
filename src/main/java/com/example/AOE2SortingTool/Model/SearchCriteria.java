package com.example.AOE2SortingTool.Model;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author robertsonje
 */
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
