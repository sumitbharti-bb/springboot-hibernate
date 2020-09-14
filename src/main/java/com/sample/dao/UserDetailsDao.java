package com.sample.dao;

import com.sample.entity.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDetailsDao {
    
    private static final Logger log = LoggerFactory.getLogger(UserDetailsDao.class);
    @PersistenceContext
    private EntityManager entityManager;
    
    /**
     * Save user
     * @param userDetails
     */
    public void persist(UserDetails userDetails){
        try{
            entityManager.persist(userDetails);
        }catch(Exception e){
            log.error("Error occured during save", e);
            throw e;
        }
    }
    
    /**
     * delete user by id
     * @param userDetails
     */
    public void remove(UserDetails userDetails){
        try{
            entityManager.remove(userDetails);
        }catch(Exception e){
            log.error("Error occured during remove", e);
            throw e;
        }
    }
    
    /**
     * find user by id
     * @param id
     * @return
     */
    public UserDetails findById(Integer id){
        try{
            UserDetails userDetails = entityManager.find(UserDetails.class, id);
            return userDetails;
        }catch(Exception e){
            log.error("Error occured While fetching by id", e);
            throw e;
        }
    }
    
    public UserDetails updateUserDetails(UserDetails userDetails){
        try{
            UserDetails updatedUserDetails = entityManager.merge(userDetails);
            return userDetails;
        }catch(Exception e){
            log.error("Error occured While updating userdetails", e);
            throw e;
        }
    }
    
    /**
     * HQL usage
     * @return
     */
    public List<UserDetails> findAll(){
        try{
            Query query = entityManager.createQuery("select ud from UserDetails ud");
           List<UserDetails> userDetailsList = query.getResultList();
           return userDetailsList;
        }catch(Exception e){
            log.error("Error occured While fetching all userdetails", e);
            throw e;
        }
    }
    
    public UserDetails findUser(String mobileNumber){
        try{
            Query query = entityManager.createQuery("select ud from UserDetails ud where ud.mobileNumber = :mobileNumber");
            query.setParameter("mobileNumber", mobileNumber);
            List<UserDetails> userDetailsList = query.getResultList();
           if(!userDetailsList.isEmpty()){
               return userDetailsList.get(0);
           }
           return null;
        }catch(Exception e){
            log.error("Error occured While fetching all userdetails", e);
            throw e;
        }
    }
    
    /**
     * Using hql, Getting userdetails by emailAdress and name
     * @param emailAddress
     * @param name
     * @return
     */
    public UserDetails findUserByEmailAndName(String emailAddress, String name){
        try{
            Query query = entityManager.createQuery("select ud from UserDetails ud where ud.emailAddress = :emailAddress and ud.name = :name");
            query.setParameter("emailAddress", emailAddress);
            query.setParameter("name", name);
            List<UserDetails> userDetailsList = query.getResultList();
            if(!userDetailsList.isEmpty()){
                return userDetailsList.get(0);
            }
            return null;
        }catch(Exception e){
            log.error("Error occured While fetching all userdetails", e);
            throw e;
        }
    }
    
    /**
     * Using sql, Getting userdetails by emailAdress and name
     * @param emailAddress
     * @param name
     * @return
     */
    public UserDetails findUserByEmailAndNameUsingSql(String emailAddress, String name){
        try{
            Query query = entityManager.createNativeQuery("select ud.* from user_details ud where ud.email = :emailAddress and ud.name = :name",UserDetails.class);
            query.setParameter("emailAddress", emailAddress);
            query.setParameter("name", name);
            List<UserDetails> userDetailsList = query.getResultList();
            if(!userDetailsList.isEmpty()){
                return userDetailsList.get(0);
            }
            return null;
        }catch(Exception e){
            log.error("Error occured While fetching all userdetails", e);
            throw e;
        }
    }
    

}
