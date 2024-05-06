package org.example.utility;

import org.example.model.Earning;

import javax.persistence.*;


public class DataBaseHandler {
    @PersistenceContext
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    private EntityTransaction entityTransaction;


    public DataBaseHandler() {
        connection();
    }


    private void connection() {
        entityManagerFactory = Persistence.createEntityManagerFactory("PlayersPU");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public void saveEarning(Earning earning) {
        entityTransaction.begin();
        entityManager.persist(earning);
        entityTransaction.commit();
    }
}
