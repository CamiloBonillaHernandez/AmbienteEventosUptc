package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reporte_bug database table.
 * 
 */
@Entity
@Table(name="reporte_bug")
@NamedQuery(name="ReporteBug.findAll", query="SELECT r FROM ReporteBug r")
public class ReporteBug implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_reporte_bug")
	private int idReporteBug;

	@Column(name="descripcion_rb")
	private String descripcionRb;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_rb")
	private Date fechaRb;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	public ReporteBug() {
	}

	public int getIdReporteBug() {
		return this.idReporteBug;
	}

	public void setIdReporteBug(int idReporteBug) {
		this.idReporteBug = idReporteBug;
	}

	public String getDescripcionRb() {
		return this.descripcionRb;
	}

	public void setDescripcionRb(String descripcionRb) {
		this.descripcionRb = descripcionRb;
	}

	public Date getFechaRb() {
		return this.fechaRb;
	}

	public void setFechaRb(Date fechaRb) {
		this.fechaRb = fechaRb;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}