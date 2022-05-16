package com.redeSocial.projeto.dataBase;

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
public class UserDAO {
	
	@Id
	private String userName;
	
	private String email;
	private String password;
	private String name;
	private String birthdate;
	private String relationship;

	@ManyToMany
	private List<Marketplace> products;
	
	@ManyToMany
	private List<Events> events;
	
	@ManyToMany
	private List<Post> posts;
	
}