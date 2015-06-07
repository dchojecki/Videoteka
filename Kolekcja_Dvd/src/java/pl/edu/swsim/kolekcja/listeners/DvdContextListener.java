/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.swsim.kolekcja.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import pl.edu.swsim.kolekcja.config.DBManager;

/**
 *
 * @author Damian
 */
public class DvdContextListener implements ServletContextListener {

    
    public void contextInitialized(ServletContextEvent sce) {
        DBManager.getManager().createEntityManagerFactory();

    }

  
    public void contextDestroyed(ServletContextEvent sce) {
        DBManager.getManager().closeEntityManagerFactory();
    }
}
