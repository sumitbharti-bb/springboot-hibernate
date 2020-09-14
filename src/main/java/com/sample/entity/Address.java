package com.sample.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "address")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "pin_code")
    private String pinCode;
    
    @Column(name = "location")
    private String location;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "user_details_id")
    private UserDetails userDetails;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getPinCode() {
        return pinCode;
    }
    
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public UserDetails getUserDetails() {
        return userDetails;
    }
    
    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
