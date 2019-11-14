package dom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Categoria;
import model.Evento;

public class ManagerEvento {
	EntityManagerFactory factory;

	public ManagerEvento() {
		this.factory = Persistence.createEntityManagerFactory("database");
	}

	/*
	 * Bloque de CRUD Categoria
	 */

	public List<Evento> listarEventos() {
		EntityManager em = this.factory.createEntityManager();
		List<Evento> lista  = em.createQuery("SELECT e FROM Evento e").getResultList();
		em.close();
		return lista;
	}

	public Evento findById(int id) {
		EntityManager em = this.factory.createEntityManager();
		Evento e = em.find(Evento.class, id);
		em.close();
		return e;
	}

	public Evento findByTitle(String title) {
		EntityManager em = this.factory.createEntityManager();
		Query query = em.createQuery("SELECT e FROM Evento e WHERE e.tituloE =:title");
		query.setParameter("title", title);
		Evento e= (Evento) query.getSingleResult();
		em.close();
		return e;
	}

	public boolean addEvento(Evento ev) {
		EntityManager em = this.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(ev);
		try {
			tx.commit();
			System.out.println("insertado");
		} catch (Exception e) {
			System.out.println("Fall� la inserci�n");
			return false;
		}finally {
			em.close();
		}
		return true;
	}

	public boolean updateEvento(Evento ev) {
		EntityManager em = this.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			Evento evento = findById(ev.getIdEvento());
			evento = em.merge(ev);
			em.persist(evento);
			tx.commit();
			System.out.println("Actualizado");
		} catch (Exception e) {
			System.out.println("fallo la actualizacion");
			return false;
		}finally {
			em.close();
		}
		return true;
	}

	public boolean  borrarEvento(Evento ev) {
		EntityManager em = this.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			Evento evento= findById(ev.getIdEvento());
			evento = em.merge(ev);
			em.remove(evento);
			tx.commit();
			System.out.println("Eliminado");
		} catch (Exception e) {
			System.out.println("fall� en la eliminacion");
			return false;
		}finally {
			em.close();
		}
		return true;
	}
}
