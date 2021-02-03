package com.nuvu.corenuvu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="client")
public class ClientDto {

	@Id
	@SequenceGenerator(name="CORE_CLIENT_ID_GENERATOR", sequenceName="CLIENT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CORE_CLIENT_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;
	
	@Column(name="email", length=300)
	private String email;
	
	String name;	
	
	private Boolean active;
	
	@Column(name="document")
	private String nroDocument;
}
