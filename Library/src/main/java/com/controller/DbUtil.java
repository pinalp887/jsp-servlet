package com.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbUtil {

	public static EntityManagerFactory factory;
	public static EntityManager manager;

	public static void beginTransaction() {
		factory = Persistence.createEntityManagerFactory("onetoOne");
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
	}

	public static void commitTransaction() {
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
