/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package startup;

import boundary.CustomerFacade;
import boundary.ManagerFacade;
import boundary.UserFacade;
import entity.Customer;
import entity.Manager;
import entity.Pilot;
import entity.Users;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import utility.HashedPasswordGenerator;

/**
 *
 * @author Xpan
 */
@Singleton
@Startup
public class StartSingleton {
    private Users user;
    private Manager m;
    private Pilot p;
    private Customer c;
    private String password;

    @EJB
    private UserFacade userFacade;
    @EJB
    private CustomerFacade customerFacade;
    @EJB
    private ManagerFacade managerFacade;
    @PostConstruct
    private void initApp(){
        user=new Users();
        System.out.println("StartSingleton in initApp()"); 

        user.setName("Grace");
        user.setEmail("grace@gmail.com");
        password="123456";
        HashedPasswordGenerator hash=new HashedPasswordGenerator();
        String hashedPass1=hash.hashPassword(hash.hashPassword(password));
        user.setPassword(hashedPass1);
        this.userFacade.create(user);   
        
        m=new Manager();
        m.setName("Manager");
        m.setPosition("Project Manager");
        m.setUser(user);
        this.managerFacade.create(m);
        
        user=new Users();
        user.setName("Yang");
        user.setEmail("yang@gmail.com");
        hash=new HashedPasswordGenerator();
        String hashedPass2=hash.hashPassword(hash.hashPassword(password));
        user.setPassword(hashedPass2);
        this.userFacade.create(user); 
        
        c=new Customer();
        c.setName("Customer");
        c.setUser(user);
        this.customerFacade.create(c);
    }
}
