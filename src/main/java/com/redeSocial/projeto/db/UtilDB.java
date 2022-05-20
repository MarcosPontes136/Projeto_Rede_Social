package com.redeSocial.projeto.db;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.redeSocial.projeto.entities.User;

public class UtilDB {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("RedeSocial");
			return entityManagerFactory;
		}
		return entityManagerFactory;
	}
	
	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = getEntityManagerFactory().createEntityManager();
		}
		return entityManager;
	}
	public static void closeConn() {
		if (entityManager != null)
				entityManager.close();
		if (entityManagerFactory != null)
				entityManagerFactory.close();
	}
	public static void initDB() {
		for(User u : consumeAPI(consultAPI()))
			new UserDAO().persiste(u);
			
	}
	
	public static List<User> consumeAPI(List<String> users){
		return null;
	}
	
	private static List<String> consultAPI(){
		return null;
	}
}
