package org.example;

import org.example.entities.Auto;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
for (int i=0;i<10;i++){
   // addAuto(new Auto(i,getAuto()));
    System.out.println();

}
    }

    public static void addAuto(Auto auto) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(auto);
        session.getTransaction().commit();
        session.close();
       // System.out.println("add");
    }

    public static List<Auto>getAuto(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Auto>autos=session.createQuery("List Autos:").list();
        session.close();
        return autos;
    }

    public static void update (Auto auto){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Auto auto1=(Auto)session.load(Auto.class,auto.getId());
        auto.setModel(auto1.getModel());
        auto.setPrice(auto1.getPrice());
        session.getTransaction().commit();
        session.close();
        System.out.println("OK " + auto1.getModel());
    }
}
