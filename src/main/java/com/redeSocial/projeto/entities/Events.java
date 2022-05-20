package com.redeSocial.projeto.entities;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public abstract class Events {
	
	@Id
	private String eventName;
	
	private String eventDate;
	private String eventeLocal;
	private String eventDescription;
	
	public Events(){
		
	}
	
}
