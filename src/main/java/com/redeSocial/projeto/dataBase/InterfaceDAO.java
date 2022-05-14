package com.redeSocial.projeto.dataBase;

import java.util.List;

public interface InterfaceDAO<T> {
	
	public void add(T reference);

	public void remove(T reference);
	
	public void update(T reference);

	public List<T> all();
	
	public int getLastId();
	
}


/*
 * Uma DAO (Data Access Object) é um padrão de projeto. 
 * Este padrão de projeto centraliza em um único objeto a comunicação
 * com o banco de dados em relação a uma única entidade ou a um conjunto de
 * entidades.
 */