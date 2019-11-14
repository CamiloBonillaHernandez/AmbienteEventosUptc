package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sugerencias database table.
 * 
 */
@Entity
@Table(name="sugerencias")
@NamedQuery(name="Sugerencia.findAll", query="SELECT s FROM Sugerencia s")
public class Sugerencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sugerencias")
	private int idSugerencias;

	@Column(name="descripcion_s")
	private String descripcionS;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	public Sugerencia() {
	}

	public int getIdSugerencias() {
		return this.idSugerencias;
	}

	public void setIdSugerencias(int idSugerencias) {
		this.idSugerencias = idSugerencias;
	}

	public String getDescripcionS() {
		return this.descripcionS;
	}

	public void setDescripcionS(String descripcionS) {
		this.descripcionS = descripcionS;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}