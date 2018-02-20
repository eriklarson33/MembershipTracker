/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmembership;

import appmembership.controller.AppMembershipController;
import appmembership.dao.AppMembershipDao;
import appmembership.dao.AppMembershipDaoImpl;
import appmembership.ui.AppMembershipView;
import appmembership.ui.UserIO;
import appmembership.ui.UserIOConsoleImpl;

/**
 *
 * @author eriklarson-laptop
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* 
        Use the App class to wire the application through Dependency Injection.
        Each instance of the class is using the constructors we built within the 
        class to pass in the needed dependencies.
        For Example, the view uses the UserIOConsoleImpl class through its interface.
        Similarly, the controller depends on the use of the view and dao.
        NOTE:  This is loosely coupled.  
        ... For Example, the view doesn't know which implementation of the UserIO
        it is using.
        */
        UserIO myIo = new UserIOConsoleImpl();
        AppMembershipView myView = new AppMembershipView(myIo);
        AppMembershipDao myDao = new AppMembershipDaoImpl();
        AppMembershipController controller = new AppMembershipController(myView, myDao);
        
        controller.run();
    }
    
}
