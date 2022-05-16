package com.redeSocial.projeto.entities.User;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.redeSocial.projeto.entities.Events.Events;
import com.redeSocial.projeto.entities.Marketplace.Marketplace;
import com.redeSocial.projeto.entities.Post.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class User{
	
	@Id
	private String userName;
	
	private String email;
	private String name;
	private String password;
	private String birthdate;
	private String relationship;
	
	@ManyToMany
	private List<Marketplace> products;
	
	@ManyToMany
	private List<Post> posts;
	
	@ManyToMany
	private List<Events> events;
	
	public User(){
		
	}
	
}
