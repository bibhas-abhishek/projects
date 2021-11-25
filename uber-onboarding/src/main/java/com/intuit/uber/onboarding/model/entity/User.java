/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- uber-onboarding: User
*- 25 Nov 2021 11:37 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

package com.intuit.uber.onboarding.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import com.intuit.uber.onboarding.model.enums.IdentityType;
import com.intuit.uber.onboarding.model.enums.UserType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long         id;

    @Column(name = "user_type", nullable = false)
    private UserType     userType;

    @Column(nullable = false)
    private String       name;

    @Column(nullable = false)
    private Integer      age;

    @Column(nullable = false)
    private String       address;

    @Column(name = "identity_type", nullable = false)
    private IdentityType identityType;

    @Column(name = "identity_number", nullable = false)
    private String       identityNumber;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date         updatedAt;
}
