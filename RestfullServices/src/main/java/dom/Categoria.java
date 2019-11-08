package dom;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase que permite maquetear la entidad Categoria y enlazarla a la Tabla Categoria de Mysql,
 * Si esta esta creada enlaza los atributos, si no esta creada no puede enlazar los atributos
 * @author camil
 *
 */

@Entity
@Table(name = "categoria")
@SequenceGenerator(name = "SEQCat", sequenceName = "SEQ_COMUN", initialValue = 0, allocationSize = 1)
public class Categoria  implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_categoria",unique=true, nullable = false)
	private Integer idCategoria;
	@Column (name = "nombre_categoria")
	private String nombreCategoria;


	public Categoria() {
	}


	public Categoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}


	public Integer getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombreCategoria() {
		return this.nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}


}


