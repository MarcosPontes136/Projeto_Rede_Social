package com.redeSocial.projeto.db;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

import com.redeSocial.projeto.entities.Marketplace;


public class MarketplaceDAO implements InterfaceDAO<Marketplace> {

	@Override
	public void persiste(Marketplace t) {
		EntityManager em = UtilDB.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (EntityExistsException e) {
			em.getTransaction().rollback();
			Marketplace original = get(t.getProductName());
			em.getTransaction().begin();
			original.setProductPrice(t.getProductPrice());
			original.setProductDescription(t.getProductDescription());
			em.getTransaction().commit();
		}
		
	}

	@Override
	public void remove(Marketplace t) {
		EntityManager em = UtilDB.getEntityManager();
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();		
	}

	@Override
	public Marketplace get(Object pk) {
		EntityManager em = UtilDB.getEntityManager();
		Marketplace t = em.find(Marketplace.class, pk);
		return t;
	}

	@Override
	public List<Marketplace> getAll() {
		return UtilDB.getEntityManager().createQuery("SELECT u FROM Marketplace u", Marketplace.class).getResultList();
	}

}
