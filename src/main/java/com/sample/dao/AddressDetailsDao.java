package com.sample.dao;

import com.sample.entity.Address;
import com.sample.entity.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AddressDetailsDao {
    
    private static final Logger log = LoggerFactory.getLogger(AddressDetailsDao.class);
    @PersistenceContext
    private EntityManager entityManager;
    
    /**
     * Save address
     * @param address
     */
    public void persist(Address address){
        try{
            entityManager.persist(address);
        }catch(Exception e){
            log.error("Error occured during save", e);
            throw e;
        }
    }
    
    /**
     * delete user by id
     * @param address
     */
    public void remove(Address address){
        try{
            entityManager.remove(address);
        }catch(Exception e){
            log.error("Error occured during remove", e);
            throw e;
        }
    }
    
    /**
     * find address by id
     * @param id
     * @return
     */
    public Address findById(Integer id){
        try{
            Address address = entityManager.find(Address.class, id);
            return address;
        }catch(Exception e){
            log.error("Error occured While fetching by id", e);
            throw e;
        }
    }
    
    /**
     * HQL usage
     * @return
     */
    public List<Address> findAll(){
        try{
            Query query = entityManager.createQuery("select ad from Address ad");
            List<Address> addressList = query.getResultList();
            return addressList;
        }catch(Exception e){
            log.error("Error occured While fetching all address", e);
            throw e;
        }
    }
    
    /**
     * Get address by pincode and location using hql
     * @param pinCode
     * @param location
     * @return
     */
    public Address findAddress(String pinCode, String location){
        try{
            Query query = entityManager.createQuery("select ad from Address ad where ad.pinCode = :pinCode and ad.location = :location");
            query.setParameter("pinCode", pinCode);
            query.setParameter("location", location);
            List<Address> addressList = query.getResultList();
            if(!addressList.isEmpty()){
                return addressList.get(0);
            }
            return null;
        }catch(Exception e){
            log.error("Error occured While fetching all address", e);
            throw e;
        }
    }
}
