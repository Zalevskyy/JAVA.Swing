/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationswing.Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author lv270669zia
 */
public class HibernateSFactory {
    private static final SessionFactory sessionFactory;
    static {
        try {
            //sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Configuration configObj = new Configuration();
            configObj.configure("hibernate.cfg.xml");

             StandardServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
            sessionFactory = configObj.buildSessionFactory(serviceRegistryObj);
        }
        catch (Throwable ex){
            System.err.println("SessionFactory creation fail "+ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
