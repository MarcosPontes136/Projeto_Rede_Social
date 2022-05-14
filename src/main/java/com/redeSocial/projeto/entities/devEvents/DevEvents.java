package com.redeSocial.projeto.entities.devEvents;

import com.redeSocial.projeto.entities.comment.Comment;
import com.redeSocial.projeto.entities.events.Events;
import com.redeSocial.projeto.entities.user.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DevEvents extends Events {
	
	@Override
	public void addComment(Integer id, User user, String text) {
		getComments().add(new Comment(id, user, text));
	}

	@Override
	public void editComment(Integer id, String text) {
		for (int i = 0; i < getComments().size(); i++) {
			if (getComments().get(i).getId() == id) {
				getComments().get(i).setText(text);
			}
		}
	}

	@Override
	public void removeComment(Integer id) {
		for (int i = 0; i < getComments().size(); i++) {
			if(getComments().get(i).getId() == id) {
				getComments().remove(i);
			}
		}
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("{COMENTARIO DELETADO}");
		System.out.println();
	}

	@Override
	public void showComment() {
		System.out.println();
		for (int i = 0; i < getComments().size(); i++) {
			System.out.println("Comentario #" + getComments().get(i).getId() + " de " + getComments().get(i).getUser()
					+ " em " + getDate() + " no " + getTime());
			System.out.println(getComments().get(i).getText());
			System.out.println();
		}
	}

	public DevEvents(User user, Integer eventId, String eventName, String eventDate, String eventLocal,
			String eventDescription) {
	}
}
