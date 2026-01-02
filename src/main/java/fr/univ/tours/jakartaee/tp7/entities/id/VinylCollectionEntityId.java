package fr.univ.tours.jakartaee.tp7.entities.id;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.*;

@Embeddable
public class VinylCollectionEntityId implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 7802395502542406769L;
	
	@Column(name = "user")
	private String user;
	
	@Column(name = "identification_code")
	private String identificationCode;
	
	
	
	public VinylCollectionEntityId() {
		super();
	}

	public VinylCollectionEntityId(String user, String identificationCode) {
		super();
		this.user = user;
		this.identificationCode = identificationCode;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getIdentificationCode() {
		return identificationCode;
	}

	public void setIdentificationCode(String identificationCode) {
		this.identificationCode = identificationCode;
	}
	
	
	
	
	

}
