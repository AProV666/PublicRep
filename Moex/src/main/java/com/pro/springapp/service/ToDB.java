package com.pro.springapp.service;

import com.pro.springapp.model.TickerPojo;
import com.pro.springapp.model.TickerPojoForDB;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ToDB {
    private StandardServiceRegistry registry;
    private Metadata metadata;
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public Session initializer(String cfgXml) {
        registry = new StandardServiceRegistryBuilder().configure(cfgXml).build();
        metadata = new MetadataSources(registry).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        return session;
    }

    public void closeSession() {
        transaction.commit();
        sessionFactory.close();
    }

    public void addToDB(TickerPojoForDB tickerPojoForDB) {
        session.persist(tickerPojoForDB);
    }



    public void getFromDB(){
    TickerPojoForDB tickerPojoForDB = session.get(TickerPojoForDB.class, 1);
    System.out.println(tickerPojoForDB.getDate() + " " + tickerPojoForDB.getClose());

    //Проверить есть ли в базе такой тикер - если есть - берем все строки и закидываем в лист:
    //                                                - сравниваем последнее значение с вчерашней датой:
    //                                                           - если совпадает - возвращаем лист
    //                                                           - если нет - ищем недостающий промежуток - парсим и добавляем в БД - и возвращаем лист
    //                                     - если нет - парсим сайт, добавляем в БД и возвращаем весь список


    }


}
