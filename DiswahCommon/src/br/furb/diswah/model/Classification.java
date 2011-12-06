package br.furb.diswah.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

/**
 * 
 * @author Andr� Felipe de Almeida {almeida.andref@gmail.com}
 */
@Entity
@AccessType("field")
@Table(name = "classification")
public class Classification extends BasicEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_classification", nullable = false)
    private Long id;
	
	@Column(name="cd_classification", nullable=false)
    private Long code;
	
	@Column(name = "ds_name", nullable = false, length = 40)
    private String name;
	
	@Column(name = "ds_description", nullable = false, length = 200)
    private String description;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Id: "+id+" | Nome: "+name+ " | Descri��o: "+description;
	}
	
}