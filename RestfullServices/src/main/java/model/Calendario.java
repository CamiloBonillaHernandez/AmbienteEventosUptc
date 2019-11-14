package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the calendario database table.
 * 
 */
@Entity
@NamedQuery(name="Calendario.findAll", query="SELECT c FROM Calendario c")
public class Calendario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_calendario")
	private int idCalendario;

	@Column(name="descripcion_cl")
	private String descripcionCl;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_cl")
	private Date fechaCl;

	@Column(name="titulo_cl")
	private String tituloCl;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	public Calendario() {
	}

	public int getIdCalendario() {
		return this.idCalendario;
	}

	public void setIdCalendario(int idCalendario) {
		this.idCalendario = idCalendario;
	}

	public String getDescripcionCl() {
		return this.descripcionCl;
	}

	public void setDescripcionCl(String descripcionCl) {
		this.descripcionCl = descripcionCl;
	}

	public Date getFechaCl() {
		return this.fechaCl;
	}

	public void setFechaCl(Date fechaCl) {
		this.fechaCl = fechaCl;
	}

	public String getTituloCl() {
		return this.tituloCl;
	}

	public void setTituloCl(String tituloCl) {
		this.tituloCl = tituloCl;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}