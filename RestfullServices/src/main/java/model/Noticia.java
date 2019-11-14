package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the noticia database table.
 * 
 */
@Entity
@NamedQuery(name="Noticia.findAll", query="SELECT n FROM Noticia n")
public class Noticia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_noticia")
	private int idNoticia;

	@Column(name="descripcion_n")
	private String descripcionN;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_n")
	private Date fechaN;

	@Lob
	@Column(name="imagen_n", length=100000)
	private byte[] imagenN;

	@Column(name="titulo_n")
	private String tituloN;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	public Noticia() {
	}

	public int getIdNoticia() {
		return this.idNoticia;
	}

	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}

	public String getDescripcionN() {
		return this.descripcionN;
	}

	public void setDescripcionN(String descripcionN) {
		this.descripcionN = descripcionN;
	}

	public Date getFechaN() {
		return this.fechaN;
	}

	public void setFechaN(Date fechaN) {
		this.fechaN = fechaN;
	}

	public byte[] getImagenN() {
		return this.imagenN;
	}

	public void setImagenN(byte[] imagenN) {
		this.imagenN = imagenN;
	}

	public String getTituloN() {
		return this.tituloN;
	}

	public void setTituloN(String tituloN) {
		this.tituloN = tituloN;
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