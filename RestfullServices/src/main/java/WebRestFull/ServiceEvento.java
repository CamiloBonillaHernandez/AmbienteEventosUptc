package WebRestFull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dom.ManagerCategoria;
import dom.ManagerEvento;
import dom.ManagerPersona;
import dom.ManagerTipoPersona;
import model.Categoria;
import model.Evento;
import model.Persona;
import model.TipoPersona;

@Transactional
@Path("Evento")
public class ServiceEvento {

	ManagerPersona pMP = new ManagerPersona();
	ManagerCategoria mC = new ManagerCategoria();
	ManagerEvento pME = new ManagerEvento();
	
	
	@Path("Listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Evento> Listar() {
		List <Evento> ev= pME.listarEventos();
		return ev;
	}

	@Path("ByID")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Evento getEventoById(@QueryParam("id") String id) {
		Evento e = pME.findById(Integer.parseInt(id));
		if(e != null) 
			return e;
		else 
			return null;
	}
	
	@Path("ByTitle")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Evento getEventoByTitle(@QueryParam("title") String title) {
		Evento e = pME.findByTitle(title);
		if(e != null) 
			return e;
		else 
			return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Add")
	public String addEvento(@QueryParam("title") String title, @QueryParam("descripcion") String descripcion, @QueryParam("fI") String fI,
			@QueryParam("fF") String fF, @QueryParam("lugar") String lugar , @QueryParam("imagen") String imagen, @QueryParam("iDP") String iDP,
			@QueryParam("iDC") String iDC) throws ParseException {
		Persona p = pMP.findById(Integer.parseInt(iDP));
		Categoria c = mC.findById(Integer.parseInt(iDC));
		Date date1= new SimpleDateFormat("dd/MM/yyyy").parse(fI);  
		Date date2= new SimpleDateFormat("dd/MM/yyyy").parse(fF);  
		System.err.println(date1 + "   -   "+ date2 );
		byte[] iB = imagen.getBytes();
		Evento evento = new Evento(descripcion, date1, date2, iB, lugar, title, c, p);
		
		if(pME.addEvento(evento)) 
			return "añadido";
		else 
			return "no se inserto nada";
	}
	
	
	
  /***
   * Pendientes por realizar UpdateEvento y DeleteEvento
   */
	
	@Path("UpdateId")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String updateNombrePersona(@QueryParam("id") int id, @QueryParam("name") String name,  @QueryParam("contrasenia") String contrasenia,
			 @QueryParam("idTP") String idTP) {
		Persona p = new Persona();
		p.setIdPersona(id);
		p.setNombreP(name);
		p.setContrasenia(contrasenia);
	//	p.setTipoPersona(mTipoP.findById(Integer.parseInt(idTP)));
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
