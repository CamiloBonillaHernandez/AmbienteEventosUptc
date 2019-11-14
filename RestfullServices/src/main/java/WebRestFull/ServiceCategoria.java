package WebRestFull;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import model.Categoria;
import dom.ManagerCategoria;

/**
 * Clase que permite implementar metodo Rest para que el servidor pueda comunicarse por medio de servicios con la app movil
 * una ves este desplegado, En especifico implementa los servicios de la Tabla Categoria
 * @author camil
 *
 */
@Transactional
@Path("categoria")
public class ServiceCategoria {

	ManagerCategoria pMC = new ManagerCategoria();
	
	@Path("Listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categoria> Listar() {
		List <Categoria> categorias = pMC.listarCategorias();
		return categorias;
	}

	@Path("ByID")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Categoria getCategoriaById(@QueryParam("id") String id) {
		Categoria c = pMC.findById(Integer.parseInt(id));
		if(c != null) 
			return c;
		else 
			return null;
	}
	
	@Path("ByName")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Categoria getCategoriaByName(@QueryParam("name") String name) {
		Categoria c = pMC.findByName(name);
		if(c != null) 
			return c;
		else 
			return null;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Add")
	public String addCategoria(@QueryParam("name") String name) {
		Categoria c = new Categoria(name);
		if(pMC.addCategoria(c)) 
			return "añadido";
		else 
			return "no se inserto nada";
	}
	
	@Path("Update")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String upDateCategoria(@QueryParam("id") int id, @QueryParam("name") String nombre) {
		Categoria c = new Categoria();
		c.setIdCategoria(id);
		c.setNombreC(nombre);
		if(pMC.updateCategoria(c)) 
			return " update";
		else 
			return "sin cambios";
	}
	
	@Path("delete")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteCategoria(@QueryParam("id") int id, @QueryParam("name") String nombre) {
		Categoria c = new Categoria();
		c.setIdCategoria(id);
		c.setNombreC(nombre);
		if(pMC.borrarCategoria(c)) 
			return " eliminado";
		else 
			return "sin cambios";
	}
}
