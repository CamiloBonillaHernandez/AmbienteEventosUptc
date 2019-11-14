package WebRestFull;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dom.ManagerPersona;
import dom.ManagerTipoPersona;
import model.Persona;
import model.TipoPersona;

@Transactional
@Path("Persona")
public class ServicePersona {

	ManagerPersona pMP = new ManagerPersona();
	ManagerTipoPersona mTipoP = new ManagerTipoPersona();
	
	@Path("Listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> Listar() {
		List <Persona> Personas = pMP.listarTiposPersona();
		return Personas;
	}

	@Path("ByID")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Persona getPersonaById(@QueryParam("id") String id) {
		Persona p = pMP.findById(Integer.parseInt(id));
		if(p != null) 
			return p;
		else 
			return null;
	}
	
	@Path("ByName")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Persona getPersonaByName(@QueryParam("name") String name) {
		Persona p = pMP.findByName(name);
		if(p != null) 
			return p;
		else 
			return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Add")
	public String addPersona(@QueryParam("name") String name, @QueryParam("contrasenia") String contrasenia, @QueryParam("idTP") String idTP) {
		TipoPersona tipoPersona = mTipoP.findById(Integer.parseInt(idTP));
		Persona tP = new Persona(name,contrasenia,tipoPersona);
		if(pMP.addPersona(tP)) 
			return "añadido";
		else 
			return "no se inserto nada";
	}
	
	@Path("UpdateNombre")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String updateNombrePersona(@QueryParam("id") int id, @QueryParam("name") String name,  @QueryParam("contrasenia") String contrasenia,
			 @QueryParam("idTP") String idTP) {
		Persona p = new Persona();
		p.setIdPersona(id);
		p.setNombreP(name);
		p.setContrasenia(contrasenia);
		p.setTipoPersona(mTipoP.findById(Integer.parseInt(idTP)));
		if(pMP.updatePersona(p)) 
			return " update";
		else 
			return "sin cambios";
	}
	
	@Path("UpdateTipo")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String updateTipoPersona(@QueryParam("id") int id, @QueryParam("titulo") String titulo,@QueryParam("name") String name, 
			@QueryParam("contrasenia") String contrasenia) {
		TipoPersona tP = mTipoP.findTitle(titulo);
		Persona p = new Persona();
		p.setIdPersona(id);
		p.setNombreP(name);
		p.setContrasenia(contrasenia);
		p.setTipoPersona(tP);
		
		if(pMP.updatePersona(p)) 
			return " update";
		else 
			return "sin cambios";
	}
	
	@Path("delete")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String deletePersona(@QueryParam("id") int id, @QueryParam("name") String name) {
		Persona p = new Persona();
		p.setIdPersona(id);
		p.setNombreP(name);
		if(pMP.borrarPersona(p)) 
			return " eliminado";
		else 
			return "sin cambios";
	}
}
