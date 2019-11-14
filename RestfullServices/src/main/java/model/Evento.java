package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the evento database table.
 * 
 */
@Entity
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_evento")
	private int idEvento;

	@Column(name="descripcion_e")
	private String descripcionE;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="f_final_e")
	private Date fFinalE;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="f_inicio_e")
	private Date fInicioE;

	
	@Lob()
	@Column(name="imagen_e",length=100000)
	private byte[] imagenE;

	@Column(name="lugar_e")
	private String lugarE;

	@Column(name="titulo_e")
	private String tituloE;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	public Evento() {
	}
	
	

	public Evento(String descripcionE, Date fFinalE, Date fInicioE, byte[] imagenE, String lugarE, String tituloE,
			Categoria categoria, Persona persona) {
		this.descripcionE = descripcionE;
		this.fFinalE = fFinalE;
		this.fInicioE = fInicioE;
		this.imagenE = imagenE;
		this.lugarE = lugarE;
		this.tituloE = tituloE;
		this.categoria = categoria;
		this.persona = persona;
	}



	public int getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getDescripcionE() {
		return this.descripcionE;
	}

	public void setDescripcionE(String descripcionE) {
		this.descripcionE = descripcionE;
	}

	public Date getFFinalE() {
		return this.fFinalE;
	}

	public void setFFinalE(Date fFinalE) {
		this.fFinalE = fFinalE;
	}

	public Date getFInicioE() {
		return this.fInicioE;
	}

	public void setFInicioE(Date fInicioE) {
		this.fInicioE = fInicioE;
	}

	public byte[] getImagenE() {
		return this.imagenE;
	}

	public void setImagenE(byte[] imagenE) {
		this.imagenE = imagenE;
	}

	public String getLugarE() {
		return this.lugarE;
	}

	public void setLugarE(String lugarE) {
		this.lugarE = lugarE;
	}

	public String getTituloE() {
		return this.tituloE;
	}

	public void setTituloE(String tituloE) {
		this.tituloE = tituloE;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}