package WebRestFull;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dom.ManagerTipoPersona;
import dom.ManagerTipoPersona;
import model.TipoPersona;


@Transactional
@Path("TipoPersona")
public class ServiceTipoPersona {


	ManagerTipoPersona pMTP = new ManagerTipoPersona();
	
	@Path("Listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoPersona> Listar() {
		List <TipoPersona> TipoPersonas = pMTP.listarTiposPersona();
		return TipoPersonas;
	}

	@Path("ByID")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TipoPersona getTipoPersonaById(@QueryParam("id") String id) {
		TipoPersona tP = pMTP.findById(Integer.parseInt(id));
		if(tP != null) 
			return tP;
		else 
			return null;
	}
	
	@Path("ByTitle")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TipoPersona getTipoPersonaByName(@QueryParam("title") String title) {
		TipoPersona tP = pMTP.findTitle(title);
		if(tP != null) 
			return tP;
		else 
			return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Add")
	public String addTipoPersona(@QueryParam("title") String title) {
		TipoPersona tP = new TipoPersona(title);
		if(pMTP.addTipoPersona(tP)) 
			return "añadido";
		else 
			return "no se inserto nada";
	}
	
	@Path("Update")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String upDateTipoPersona(@QueryParam("id") int id, @QueryParam("title") String title) {
		TipoPersona tP = new TipoPersona();
		tP.setIdTipoPersona(id);
		tP.setTituloTp(title);
		if(pMTP.updateTipoPersona(tP)) 
			return " update";
		else 
			return "sin cambios";
	}
	
	@Path("delete")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteTipoPersona(@QueryParam("id") int id, @QueryParam("title") String title) {
		TipoPersona tP = new TipoPersona();
		tP.setIdTipoPersona(id);
		tP.setTituloTp(title);
		if(pMTP.borrarTipoPersona(tP)) 
			return " eliminado";
		else 
			return "sin cambios";
	}
}
