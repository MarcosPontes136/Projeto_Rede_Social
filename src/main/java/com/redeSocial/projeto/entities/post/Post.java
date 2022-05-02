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
	
	
	public void addComment (Integer id, User user, String text) {   //criar
		comments.add(new Comment(id, user, text));
	}
	
	public void editComment (Integer id, String text) {          //editar
		for(int i=0; i < comments.size(); i++){
			if (comments.get(i).getId() == id) {
				comments.get(i).setText(text);
			}
		}
	}
	
	public void removeComment(Integer id) {                   //remover
		for(int i=0; i < comments.size(); i++) {
			if (comments.get(i).getId() == id) {
				comments.remove(i);
			}
		}
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("{COMENTARIO DELETADO}");
		System.out.println();
	}
	
	public void showComment() {
		for (int i = 0; i < comments.size(); i++) {
			System.out.println("Comentario #" + comments.get(i).getId() + " de " + comments.get(i).getUser()
					+ " em " + date + " no " + time);
			System.out.println("        " + comments.get(i).getText());
			System.out.println();
		}
	}
}
