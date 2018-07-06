/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 23 Feb 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/springdemo/
 **/
package com;

import org.springframework.stereotype.Component;

@Component
public class DesignationService implements Designation {

    public String getDesignation() {
        return "Senior";
    }

}
