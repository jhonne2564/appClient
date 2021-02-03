package com.nuvu.corenuvu.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="security_app")
@Getter
@Setter
public class SecurityApp {
	
	@Id
	private Integer id;
	
	@Column(nullable=false)
	private Boolean active;
	
	@Column(nullable=false, length=300)
	private String key;

	@Column(nullable=false, length=200)
	private String name;
	
	@Column(length=300)
	private String url;
	
	@Enumerated(EnumType.STRING)
	private EnumOperationMode mode;
	
}
