package dom;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Clase que se encarga de gestionar la conexion y los metodos CRUD de la tabla Categoria hacia la base de Datos Mysql
 * @author camil
 *
 */
public class ManagerCategoria {

	EntityManagerFactory factory;

	public ManagerCategoria() {
		this.factory = Persistence.createEntityManagerFactory("database");
	}

	/*
	 * Bloque de CRUD Categoria
	 */

	public List<Categoria> listarCategorias() {
		EntityManager em = this.factory.createEntityManager();
		List<Categoria> lista  = em.createQuery("select ca from Categoria ca").getResultList();
		em.close();
		return lista;
	}

	public Categoria findById(int id) {
		EntityManager em = this.factory.createEntityManager();
		Categoria categoria = em.find(Categoria.class, id);
		System.out.println("Categoria: "+categoria.getNombreCategoria()+ " con id: "+categoria.getIdCategoria());
		em.close();
		return categoria;
	}

	public Categoria findByName(String nombre) {
		EntityManager em = this.factory.createEntityManager();
		Query query = em.createQuery("SELECT c FROM Categoria c WHERE c.nombreCategoria =:nombre");
		query.setParameter("nombre", nombre);
		Categoria categoria= (Categoria) query.getSingleResult();
		em.close();
		return categoria;
	}

	public boolean addCategoria(Categoria c) {
		EntityManager em = this.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
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

	public boolean updateCategoria(Categoria c) {
		EntityManager em = this.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			Categoria cUpdate = em.merge(c);
			em.persist(cUpdate);
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

	public boolean borrarCategoria(Categoria c) {
		EntityManager em = this.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			Categoria cdelete = em.merge(c);
			em.remove(cdelete);
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
