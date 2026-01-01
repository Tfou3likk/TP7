package fr.univ.tours.jakartaee.tp7.entities;

import java.time.LocalDateTime;

import fr.univ.tours.jakartaee.tp7.entities.id.VinylCollectionEntityId;
import jakarta.persistence.*;

@Entity
@Table(name = "vinyl_collection" )
public class VinylCollectionEntity {
	
	@EmbeddedId
	private VinylCollectionEntityId id;
	
	@Column(name = "acquisition_date")
	private LocalDateTime acquisitionDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user", referencedColumnName="email")
	@MapsId("user")
	private UserEntity user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "identification_code")
	@MapsId("identificationCode")
	private DiskEntity disk;

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public DiskEntity getDisk() {
		return disk;
	}

	public void setDisk(DiskEntity disk) {
		this.disk = disk;
	}

	public VinylCollectionEntityId getId() {
		return id;
	}

	public void setId(VinylCollectionEntityId id) {
		this.id = id;
	}

	public LocalDateTime getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(LocalDateTime acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}
	
	
}
