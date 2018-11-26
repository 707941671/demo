package com.xinghan;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration    ().configure();
        //创建会话工厂对象
        SessionFactory sessionFactory = config.buildSessionFactory();
        //会话对象
        Session session= sessionFactory.openSession();

        //开启事务
        Transaction tx = session.beginTransaction();

        Person person =new Person();
        person.setName("宋洪廷");
        person.setAge(12);
        person.setSex("man");
        session.save(person);

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
