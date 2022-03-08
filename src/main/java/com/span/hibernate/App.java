package com.span.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien telusko= new Alien();
        
   /*     AlienName  aName=new AlienName();
        aName.setfName("Hardik");
        aName.setlName("Patel");
        aName.setmName("Mangubhai");
       telusko.setAlienName(aName);
        telusko.setAlienColor("green");
        telusko.setAlienId(108);
        
        Laptop laptop = new Laptop();
        laptop.setId(2);
        laptop.setName("Dell");
        
      */
        
        Configuration con= new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);
              
        SessionFactory sf = con.buildSessionFactory();
        
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        //session.save(telusko);
        
        telusko=session.get(Alien.class, 106);
        
      Query q=session.createQuery("from Alien");
      List<Alien> Alie=q.list();
      
       for(Alien a:Alie) {
    	   System.out.println(a.getAlienColor());
       }
        
        tx.commit();
    }
}
