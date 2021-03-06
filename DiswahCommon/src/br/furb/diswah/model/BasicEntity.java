package br.furb.diswah.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.furb.diswah.model.enums.Status;

/**
 * A base para todas as entidades do sistema.
 * 
 * @author Andr� Felipe de Almeida {almeida.andref@gmail.com}
 */
@MappedSuperclass
public abstract class BasicEntity implements Serializable {

	@Enumerated
    @Column(name="fl_status", nullable=false)
	private Status status = Status.ACTIVE;
	
    @Temporal(TemporalType.DATE)
    @Column(name="dt_creation", nullable=false)
    private Date creation = new Date();
	
    @Temporal(TemporalType.DATE)
    @Column(name="dt_alter")
    private Date alter;

	/**
	 * @return id
	 */
	public abstract Long getId();

	/**
	 * @param id
	 */
	public abstract void setId(Long id);
	
	/**
	 * @return status
	 */ 
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return creation
	 */
	public Date getCreation() {
		return creation;
	}

	/**
	 * @param creation
	 */
	public void setCreation(Date creation) {
		this.creation = creation;
	}

	/**
	 * @return alter
	 */
	public Date getAlter() {
		return alter;
	}

	/**
	 * @param alter
	 */
	public void setAlter(Date alter) {
		this.alter = alter;
	}

}