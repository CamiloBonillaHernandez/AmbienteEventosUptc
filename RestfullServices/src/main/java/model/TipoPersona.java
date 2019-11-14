package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_persona database table.
 * 
 */
@Entity
@Table(name="tipo_persona")
@NamedQuery(name="TipoPersona.findAll", query="SELECT t FROM TipoPersona t")
public class TipoPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_persona")
	private int idTipoPersona;

	@Column(name="titulo_tp")
	private String tituloTp;


	public TipoPersona() {
	}
	
	public TipoPersona(String title) {
		this.tituloTp = title;
	}

	public int getIdTipoPersona() {
		return this.idTipoPersona;
	}

	public void setIdTipoPersona(int idTipoPersona) {
		this.idTipoPersona = idTipoPersona;
	}

	public String getTituloTp() {
		return this.tituloTp;
	}

	public void setTituloTp(String tituloTp) {
		this.tituloTp = tituloTp;
	}


}