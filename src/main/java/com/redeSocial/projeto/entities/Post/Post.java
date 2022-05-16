package com.redeSocial.projeto.entities.Post;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Post {
	
	@Id
	private String postTitle;
	
	private String newPost;
	
	public Post() {
		
	}
}
