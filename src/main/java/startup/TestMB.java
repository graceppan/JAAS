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
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import utility.HashedPasswordGenerator;

/**
 *
 * @author Xpan
 */
@Named(value = "testMB")
@RequestScoped
public class TestMB implements Serializable{

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

    public void run(){
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Manager getM() {
        return m;
    }

    public void setM(Manager m) {
        this.m = m;
    }

    public Pilot getP() {
        return p;
    }

    public void setP(Pilot p) {
        this.p = p;
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    public CustomerFacade getCustomerFacade() {
        return customerFacade;
    }

    public void setCustomerFacade(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }

    public ManagerFacade getManagerFacade() {
        return managerFacade;
    }

    public void setManagerFacade(ManagerFacade managerFacade) {
        this.managerFacade = managerFacade;
    }
    
}
