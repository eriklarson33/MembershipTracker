/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmembership.dao;

/**
 *
 * @author eriklarson-laptop
 */
public class AppMembershipDaoException extends Exception {
    
    public AppMembershipDaoException(String message) {
        super(message);
    }
    
    public AppMembershipDaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
