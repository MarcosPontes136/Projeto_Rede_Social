package com.redeSocial.projeto.dataBase;

import java.util.List;

public interface InterfaceDAO<T> {
	
	public void persiste(T t);

	public void remove(T t);

	public T get(Object pk);
	
	public List<T> getAll();
	
}


/*
 * Uma DAO (Data Access Object) é um padrão de projeto. 
 * Este padrão de projeto centraliza em um único objeto a comunicação
 * com o banco de dados em relação a uma única entidade ou a um conjunto de
 * entidades.
 */