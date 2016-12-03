package main.java;

import java.io.IOException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class Main {
	 
    public static void main(String args[]) {
//    	JDBCDisciplineDAO d=new JDBCDisciplineDAO();
//    	ArrayList<Discipline> dcpl = d.getAllDiscipline();
//    	Discipline d1=d.getDiscipline(3);
//    	System.out.println(d1.getTeacher());
    	final String CONFIG = "hibernate.cfg.xml";
		AnnotationConfiguration aconf = 
				new AnnotationConfiguration().addAnnotatedClass(User.class);
		Configuration conf = aconf.configure(CONFIG);
		SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();
        User us = new User(0,null, null, 0, 0);
        System.out.println(us.getCredits());
        System.out.println("hello");
        us.setName("Administrator");
        session.beginTransaction();
        session.getTransaction().commit();
        session.save(us);
        System.out.println(us.getName());
        session.close();
        User  dd = new User(0, null, null, 0, 0);
        ArrayList <User> users = new ArrayList <User>();
	       dd.setName("Anna");
	       dd.setSurname("Poliakova");
	       dd.setCredits(0);
	       users.add(dd);
	       for (User d:users) {
	    	   session.beginTransaction();
	    	   session.evict(d);
	       session.saveOrUpdate(d);
	       session.getTransaction().commit();
	       }
	        
	       session.close();


	}
	
}
