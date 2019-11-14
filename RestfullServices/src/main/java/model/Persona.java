package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_persona")
	private int idPersona;
	
	@Column(name="contrasenia")
	private String contrasenia;

	@Column(name="nombre_p")
	private String nombreP;


	//bi-directional many-to-one association to TipoPersona
	@ManyToOne
	@JoinColumn(name="id_tipo_persona")
	private TipoPersona tipoPersona;


	public Persona() {
	}
	
	public Persona(String nombre, String contrasenia, TipoPersona tP) {
		this.nombreP = nombre;
		this.contrasenia = contrasenia;
		this.tipoPersona = tP;
	}


	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombreP() {
		return this.nombreP;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}


	public TipoPersona getTipoPersona() {
		return this.tipoPersona;
	}

	public void setTipoPersona(TipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}


}