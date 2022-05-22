package com.redeSocial.projeto.db;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.scene.control.Alert;

import com.redeSocial.projeto.AlertUtil;
import com.redeSocial.projeto.entities.User;

public class UtilDB {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("RedeSocial");
			return entityManagerFactory;
		}
		return entityManagerFactory;
	}
	
	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = getEntityManagerFactory().createEntityManager();
		}
		return entityManager;
	}
	public static void closeConn() {
		if (entityManager != null)
				entityManager.close();
		if (entityManagerFactory != null)
				entityManagerFactory.close();
	}
	public static void initDB() {
		for(User u : consumeAPI(consultAPI()))
			new UserDAO().persiste(u);
			
	}
	
	public static List<User> consumeAPI(List<String> users){
		List<User> result = new ArrayList<User>();
		for (int lineIndex = 0; lineIndex < users.size(); lineIndex++) {
			String line = users.get(lineIndex);
			if (line.contains("username")) {
				
			}
		}
		return result;
	}
	private static String processJSONLine(String line) {
		String[] dividedLine = line.split(":");
		String username = dividedLine[1];
		username = username.replace(",", " ");
		username = username.replace("\"", " ");
		username = username.trim();
		return username;
	}
	
	private static List<String> consultAPI(){
		List<String> result = new ArrayList<>();
		try {
			URL url = new URL("");
			URLConnection uc = url.openConnection();
			InputStreamReader input = new InputStreamReader(uc.getInputStream());
			BufferedReader in = new BufferedReader(input);
			String inputLine;
			
			while ((inputLine = in.readLine())!= null)
				result.add(inputLine);
			
			in.close();
		} catch (Exception e) {
			Alert alert = AlertUtil.error("ERROR", "API ERROR", "API ERROR!", e);
			alert.showAndWait();
		}
		return result;
	}
}
