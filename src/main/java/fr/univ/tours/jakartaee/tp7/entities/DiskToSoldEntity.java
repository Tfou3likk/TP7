package fr.univ.tours.jakartaee.tp7.entities;

import java.math.BigDecimal;


import jakarta.persistence.*;

@Entity
@Table(name = "disk_to_sold")
public class DiskToSoldEntity {
	
	@Id
	@Column(name = "identification_code")
	private String identificationCode;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@OneToOne(fetch = FetchType.EAGER)
	@MapsId
	@JoinColumn(name = "identification_code")
	private DiskEntity disk;
	
	
	public DiskToSoldEntity() {
		super();
	}

	public DiskEntity getDisk() {
		return disk;
	}

	public void setDisk(DiskEntity disk) {
		this.disk = disk;
	}

	public String getIdentificationCode() {
		return identificationCode;
	}

	public void setIdentificationCode(String identificationCode) {
		this.identificationCode = identificationCode;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
