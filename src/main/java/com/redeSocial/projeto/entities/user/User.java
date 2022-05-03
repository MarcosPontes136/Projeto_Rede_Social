package com.redeSocial.projeto.entities.user;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import org.yaml.snakeyaml.error.Mark;

import com.redeSocial.projeto.entities.Follow.Follow;
import com.redeSocial.projeto.entities.comment.Comment;
import com.redeSocial.projeto.entities.devEvents.DevEvents;
import com.redeSocial.projeto.entities.gameEvents.GameEvents;
import com.redeSocial.projeto.entities.marketplace.Marketplace;
import com.redeSocial.projeto.entities.post.Post;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User extends Comment {
	
	private String email;
	private String password;
	private String name;
	private String birthdate;
	private String relationship;

	private List<Marketplace> marketplace;
	private List<Post> posts;
	private List<Follow> followers;
	private List<DevEvents> dev;
	private List<GameEvents> gameEvents;
	
	LocalDateTime now = LocalDateTime.now();
	
	DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String date = formatterData.format(now);
	
	DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
	String time = formatterData.format(now);
	
	
	//MARKETPLACE
	
	public void showMarket() {
		for (int i = 0; i < marketplace.size(); i++) {
			System.out.println("-------------------------------------------------------------------------");
			System.out.println();
			System.out.println("#" + marketplace.get(i).getId() + " - " + marketplace.get(i).getProduct() + "postado por " + name);
			System.out.println("Preço: " + marketplace.get(i).getPrice());
			System.out.println("Descrição: " + marketplace.get(i).getDescription());
			System.out.println();
			System.out.println();
			marketplace.get(i).showComment();
			System.out.println();
		}
	}
	
	public void showYouMarket() {
		for (int i = 0; i < marketplace.size(); i++) {
			System.out.println("-------------------------------------------------------------------------");
			System.out.println();
			System.out.println("#" + marketplace.get(i).getId() + " - " + marketplace.get(i).getProduct() + "postado por " + name);
			System.out.println("Preço: " + marketplace.get(i).getPrice());
			System.out.println("Descrição: " + marketplace.get(i).getDescription());
			System.out.println();
		}
	}
	
	public void addProduct(User user, Integer id, String product, Double price, String description) {
		getMarketplace().add(new Marketplace(user, id, product, price, description, null, now, formatterData, product, formatterTime, description));
	}
	
	public void editProductName(Integer id, String product) {
		for (int i = 0; i < marketplace.size(); i++) {
			if (marketplace.get(i).getId() == id) {
				marketplace.get(i).setProduct(product);
			}
		}
	}

	public void editProductPrice(Integer id, Double price) {
		for (int i = 0; i < marketplace.size(); i++) {
			if (marketplace.get(i).getId() == id) {
				marketplace.get(i).setPrice(price);
			}
		}
	} 
	
	public void editProductDescription(Integer id, String description) {
		for (int i = 0; i < marketplace.size(); i++) {
			if (marketplace.get(i).getId() == id) {
				marketplace.get(i).setDescription(description);
			}
		}
	} 
	
	public void removeProduct(Integer id) {
		for (int i = 0; i < marketplace.size(); i++) {
			if (marketplace.get(i).getId() == id) {
				marketplace.remove(i);
			}
		}
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("{PRODUTO DELETADO}");
		System.out.println();
	} 
	
	//POST
	
	public void showPost() {
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("                                                               {TIMELINE}");
		for (int i = 0; i < posts.size(); i++) {
			System.out.println();
			System.out.println("Postado # " + getPosts().get(i).getIdPost() + "por" + name + " em " + date + "ás" + time);
			System.out.println("            " + posts.get(i).getContent());
			System.out.println();
			posts.get(i).showComment();
			System.out.println();
		}
	}
	
	public void showYouPosts() {
		for (int i = 0; i < posts.size(); i++) {
			System.out.println();
			System.out.println("Postado # " + getPosts().get(i).getIdPost() + "por" + name + " em " + date + "ás" + time);
			System.out.println("Preço: " + marketplace.get(i).getPrice());
			System.out.println("            " + posts.get(i).getContent());
			System.out.println();
		}
	}
	
	public void  addPost(User user, Integer idPost, String content) {
		posts.add(new Post(user, idPost, content, null, now, formatterData, content, formatterData, content));
	}
	
	public void editPost(Integer idPost, String content) {
		for (int i = 0; i < posts.size(); i++) {
			if (posts.get(i).getIdPost() == idPost) {
				posts.get(i).setContent(content);
			}
		}
	}
	
	public void removePost(Integer idPost) {
		for (int i = 0; i < posts.size(); i++) {
			if (posts.get(i).getIdPost() == idPost) {
				posts.remove(i);
			}
		}
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("{POST DELETADO}");
		System.out.println();
		
	}
	
	// FRIENDS 
	
	public void showFollowers() {
		for (int i = 0; i < followers.size(); i++) {
			System.out.println();
			System.out.println("#" + followers.get(i).getName() + ", Data de nascimento: " + followers.get(i).getBirthdate() + ", Status de relacionamento: " 
			+ followers.get(i).getRelationship());
		}
	}
	
	public void showFriends() {
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("                                                                {FRIENDS}");
		for (int i = 0; i < followers.size(); i++) {
			System.out.println(followers.get(i).getName() + " / ");
		}
		System.out.println();
	}
	
	public void follow(String name, String birthdate, String Relationship) {
		followers.add(new Follow(name, birthdate, Relationship));
		System.out.println();
	}
	
	public void unFollow(String nameFallower) {
		for (int i = 0; i < followers.size(); i++) {
			if (followers.get(i).getName().contentEquals(nameFallower)) {
				followers.remove(i);
				System.out.println("{FRIEND REMOVIDO!}");
			}else {
				System.out.println("{VOCÊ NÃO TEM UM AMMIGO COM ESSE NOME!}");
			}
		}
	}
	
	
	// DEV EVENTS
	
	
	
	
}
