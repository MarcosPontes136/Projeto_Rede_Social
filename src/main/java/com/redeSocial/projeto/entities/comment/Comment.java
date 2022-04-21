package com.redeSocial.projeto.entities.comment;

import com.redeSocial.projeto.entities.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	
	private Integer id;
	private User user;
	private String text;
	
}
