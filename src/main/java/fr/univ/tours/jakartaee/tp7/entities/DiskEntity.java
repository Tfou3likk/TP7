package fr.univ.tours.jakartaee.tp7.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="disk")
public class DiskEntity {
	
	@Id
	@Column(name = "identification_code")
	private String identificationCode;
	
	@Column(name = "album")
	private String album;
	
	@Column(name = "artist")
	private String artist;
	
	@OneToMany(mappedBy = "disk", fetch = FetchType.EAGER)
	private List<VinylCollectionEntity> vinylCollection;
	
	@OneToOne(mappedBy = "disk", fetch = FetchType.EAGER)
	private DiskToSoldEntity diskToSold;

	
	public List<VinylCollectionEntity> getVinylCollection() {
		return vinylCollection;
	}

	public void setVinylCollection(List<VinylCollectionEntity> vinylCollection) {
		this.vinylCollection = vinylCollection;
	}

	public DiskToSoldEntity getDiskToSold() {
		return diskToSold;
	}

	public void setDiskToSold(DiskToSoldEntity diskToSold) {
		this.diskToSold = diskToSold;
	}

	public String getIdentificationCode() {
		return identificationCode;
	}

	public void setIdentificationCode(String identifcationCode) {
		this.identificationCode = identifcationCode;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	
	

}
