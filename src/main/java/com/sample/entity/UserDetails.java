package com.sample.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_details")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetails {
    
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "mobile_number")
    private String mobileNumber;
    
    @Column(name = "email")
    private String emailAddress;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userDetails")
    @JsonIgnore
    private Set<Address> addresses;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getMobileNumber() {
        return mobileNumber;
    }
    
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public Set<Address> getAddresses() {
        return addresses;
    }
    
    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
