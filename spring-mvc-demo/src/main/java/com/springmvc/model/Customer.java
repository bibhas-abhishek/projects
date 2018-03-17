/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 15 Mar 2018
 **/

package com.springmvc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {

    private String firstName;

    @NotNull
    @Size(min = 1, message = "required field")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
