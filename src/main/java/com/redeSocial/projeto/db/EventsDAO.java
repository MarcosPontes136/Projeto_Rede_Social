package com.redeSocial.projeto.db;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

import com.redeSocial.projeto.entities.Events;

public class EventsDAO implements InterfaceDAO<Events> {

	@Override
	public void persiste(Events t) {
		EntityManager em = UtilDB.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (EntityExistsException e) {
			em.getTransaction().rollback();
			Events original = get(t.getEventName());
			em.getTransaction().begin();
			original.setEventDate(t.getEventDate());
			original.setEventeLocal(t.getEventeLocal());
			original.setEventDescription(t.getEventDescription());
			em.getTransaction().commit();
		}
		
	}

	@Override
	public void remove(Events t) {
		EntityManager em = UtilDB.getEntityManager();
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
		
	}

	@Override
	public Events get(Object pk) {
		EntityManager em = UtilDB.getEntityManager();
		Events t = em.find(Events.class, pk);
		return t;
	}

	@Override
	public List<Events> getAll() {
		return UtilDB.getEntityManager().createQuery("SELECT u FROM Events u", Events.class).getResultList();
	}

}
