package com.nuvu.corenuvu.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@NamedQuery(name="Paymentcard.findAll", query="SELECT c FROM Paymentcard c")
public class Paymentcard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PAYMENTCARD_ID_GENERATOR", sequenceName="PAYMENTCARD_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAYMENTCARD_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=4)
	private String crypto;

	@Column(nullable=false, length=5)
	private String expiry;

	@Column(name="is_active", nullable=false)
	@JsonProperty("is_active")
	private Boolean isActive;


	@Column(nullable=false, length=50)
	private String name;

	@Column(nullable=false, length=16)
	private String number;

	@Column(nullable=false, length=5)
	private String start;

	private Integer idclient;

	@Column(name="brand_code", nullable=false)
	@JsonProperty("brand_code")
	private String brandCode;

	
	public Paymentcard() {
	}
	
	public Paymentcard(final String name) {
		this.name = name;
	}

	public String getCardName() {
		if(this.number != null) {
			return String.format("%s (...%s)", String.valueOf(this.name), this.number.substring(this.number.length() - 8<0?0:this.number.length() - 8));
		}
		return "";
	}


}