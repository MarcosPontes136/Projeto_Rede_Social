package com.redeSocial.projeto.entities.events;

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
public abstract class Events {
	
	private User user;
	private Integer eventId;
	private String eventName;
	private String eventDate;
	private String eventeLocal;
	private String eventDescription;
	
	private List<Comment> comments;
	
	LocalDateTime now = LocalDateTime.now();                                     //fazer classe unica, evita repetição de codigo
	
	DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String date = formatterData.format(now);
	
	DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
	String time = formatterData.format(now);
	
	public abstract void addComment(Integer id, User user, String text);
	public abstract void editComment(Integer id, String text);
	public abstract void removeComment(Integer id);
	public abstract void showComment();
}
