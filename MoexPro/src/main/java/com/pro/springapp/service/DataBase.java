package com.pro.springapp.service;

import com.pro.springapp.model.TickerPojo;
import com.pro.springapp.model.TickerPojoForDB;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class DataBase {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public void initializer(String cfgXml) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure(cfgXml).build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    public void closeSession() {
        transaction.commit();
        sessionFactory.close();
    }

    public void addToDB(TickerPojoForDB tickerPojoForDB) {
        session.persist(tickerPojoForDB);
    }

    public List<TickerPojoForDB> getList() {
        CriteriaQuery<TickerPojoForDB> criteriaQuery = session.getCriteriaBuilder().createQuery(TickerPojoForDB.class);
        criteriaQuery.from(TickerPojoForDB.class);
        return session.createQuery(criteriaQuery).getResultList();
    }

//    public TickerPojoForDB getTicker(int id) {
//        return session.get(TickerPojoForDB.class, id);
//    }

    public void uniqTickerToDB(String ticker, DataBase dataBase, Set<Date> uniqDateList, List<TickerPojo> tickerPojoList) {

        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        if (!tickerPojoList.isEmpty()) {

            for (TickerPojo t : tickerPojoList) {
                Date date = null;
                try {
                    date = format.parse(String.valueOf(t.getDate()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Timestamp timestamp = new Timestamp(Objects.requireNonNull(date).getTime());

                if (uniqDateList.isEmpty() || !uniqDateList.contains(timestamp)) {
                    TickerPojoForDB tickerPojoForDB = new TickerPojoForDB();
                    tickerPojoForDB.setTicker(ticker);
                    tickerPojoForDB.setDate(date);
                    tickerPojoForDB.setLow(t.getLow());
                    tickerPojoForDB.setHigh(t.getHigh());
                    tickerPojoForDB.setClose(t.getClose());
                    tickerPojoForDB.setVolume(t.getVolume());
                    dataBase.addToDB(tickerPojoForDB);
                }
            }
        }
    }
}