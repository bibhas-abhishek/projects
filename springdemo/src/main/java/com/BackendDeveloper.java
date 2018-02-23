/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 23 Feb 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/springdemo/
 **/
package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BackendDeveloper implements Developer {

    @Autowired
    private DesignationService designationService;

    @Value("${foo.name}")
    private String name;

    @Value("${foo.age}")
    private String age;

    public String getDeveloperType() {
        return "Backend Developer";
    }

    public String getDesignation() {
        return designationService.getDesignation();
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

}
