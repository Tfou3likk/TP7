package fr.univ.tours.jakartaee.tp7.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	
	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<VinylCollectionEntity> vinylCollection;

	public List<VinylCollectionEntity> getVinylCollection() {
		return vinylCollection;
	}

	public void setVinylCollection(List<VinylCollectionEntity> vinylCollection) {
		this.vinylCollection = vinylCollection;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}
