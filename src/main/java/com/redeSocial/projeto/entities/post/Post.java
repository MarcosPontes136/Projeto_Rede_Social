package com.redeSocial.projeto.entities.post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.redeSocial.projeto.entities.comment.Comment;
import com.redeSocial.projeto.entities.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	
	private User user;
	private Integer idPost;
	private String content;
	
	private List<Comment> comments;
	
	LocalDateTime now = LocalDateTime.now();                                     //fazer classe unica, evita repetição de codigo
	
	DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String date = formatterData.format(now);
	
	DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
	String time = formatterData.format(now);
	
	
	
	
}
