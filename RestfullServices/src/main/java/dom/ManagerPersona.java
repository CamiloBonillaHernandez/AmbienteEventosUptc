package dom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Persona;

public class ManagerPersona {

	EntityManagerFactory factory;

	public ManagerPersona() {
		this.factory = Persistence.createEntityManagerFactory("database");
	}

	/*
	 * Bloque de CRUD Persona
	 */

	public List<Persona> listarTiposPersona() {
		EntityManager em = this.factory.createEntityManager();
		List<Persona> lista  = em.createQuery("SELECT p FROM Persona p").getResultList();
		em.close();
		return lista;
	}

	public Persona findById(int id) {
		EntityManager em = this.factory.createEntityManager();
		Persona p= em.find(Persona.class, id);
		em.close();
		return p;
	}

	public Persona findByName(String name) {
		EntityManager em = this.factory.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Persona p WHERE p.nombreP =:name");
		query.setParameter("name",name);
		Persona p= (Persona) query.getSingleResult();
		em.close();
		return p;
	}

	public boolean addPersona(Persona p) {
		EntityManager em = this.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
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

	public boolean updatePersona(Persona p) {
		EntityManager em = this.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			Persona pUpdate = findById(p.getIdPersona());
			pUpdate = em.merge(p);
			em.persist(pUpdate);
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

	public boolean  borrarPersona(Persona p) {
		EntityManager em = this.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			Persona delp= findById(p.getIdPersona());
			delp = em.merge(p);
			em.remove(delp);
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
