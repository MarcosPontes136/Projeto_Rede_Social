package com.redeSocial.projeto.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Marketplace {
	
	@Id
	private String productName;
	
	private Double productPrice;
	private String productDescription;
	
	public Marketplace() {
		
	}
	
}
