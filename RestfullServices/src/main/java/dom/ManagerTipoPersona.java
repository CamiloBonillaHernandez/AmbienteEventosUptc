package dom;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.TipoPersona;

/**
 * Clase que se encarga de gestionar la conexion y los metodos CRUD de la tabla TipoPersona hacia la base de Datos Mysql
 * @author camil
 *
 */
public class ManagerTipoPersona {

	EntityManagerFactory factory;

	public ManagerTipoPersona() {
		this.factory = Persistence.createEntityManagerFactory("database");
	}

	/*
	 * Bloque de CRUD TipoPersona
	 */

	public List<TipoPersona> listarTiposPersona() {
		EntityManager em = this.factory.createEntityManager();
		List<TipoPersona> lista  = em.createQuery("select t from TipoPersona t").getResultList();
		em.close();
		return lista;
	}

	public TipoPersona findById(int id) {
		EntityManager em = this.factory.createEntityManager();
		TipoPersona tP= em.find(TipoPersona.class, id);
		em.close();
		return tP;
	}

	public TipoPersona findTitle(String titulo) {
		EntityManager em = this.factory.createEntityManager();
		Query query = em.createQuery("SELECT t FROM TipoPersona t WHERE t.tituloTp =:titulo");
		query.setParameter("titulo", titulo);
		TipoPersona tP= (TipoPersona) query.getSingleResult();
		em.close();
		return tP;
	}

	public boolean addTipoPersona(TipoPersona tP) {
		EntityManager em = this.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(tP);
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

	public boolean updateTipoPersona(TipoPersona tP) {
		EntityManager em = this.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			TipoPersona tPUpdate = findById(tP.getIdTipoPersona());
			tPUpdate = em.merge(tP);
			em.persist(tPUpdate);
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

	public boolean  borrarTipoPersona(TipoPersona tP) {
		EntityManager em = this.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			TipoPersona delTP= findById(tP.getIdTipoPersona());
			delTP = em.merge(tP);
			em.remove(delTP);
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
