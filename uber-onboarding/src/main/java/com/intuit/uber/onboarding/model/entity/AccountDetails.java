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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "account_details")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User    user;

    @Column(name = "is_online", nullable = false)
    private Boolean isOnline;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date    updatedAt;
}
