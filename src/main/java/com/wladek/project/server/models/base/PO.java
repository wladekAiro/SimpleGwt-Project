package com.wladek.project.server.models.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@MappedSuperclass
public class PO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Date createdAt;
	
	@Column
	private Date updatedAt;
	
	@Column(columnDefinition="int default 1")
	private int isActive=1;
	
	public void init(){
		if(this.getId()==null){
			createdAt = new Date(System.currentTimeMillis());
		}else{
			updatedAt= new Date(System.currentTimeMillis());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	
	@PrePersist
	public void onPrePersist(){
		this.createdAt=new Date();
	}
	
	@PreUpdate
	public void onPreUpdate(){
		this.updatedAt=new Date();
	}
}
