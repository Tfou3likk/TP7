package fr.univ.tours.jakartaee.tp7.business.pojo;

import jakarta.validation.constraints.NotBlank;

public class DiskForm {
	
	@NotBlank(message = "Champ id obligatoire")
	private String identificationCode;
	
	@NotBlank(message = "Champ album obligatoire")
	private String album;
	
	@NotBlank(message = "Champ artist obligatoire")
	private String artist;
	
	public String getIdentificationCode() {
		return identificationCode;
	}
	public void setIdentificationCode(String identificationCode) {
		this.identificationCode = identificationCode;
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
