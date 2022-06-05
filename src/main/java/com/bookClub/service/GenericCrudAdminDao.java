package com.bookClub.service;

import java.util.List;

public interface GenericCrudAdminDao<E, K> {


	void add(E entity);

	void update(E entity);

	boolean remove(K key);

	List<E> list(K key);
	E find(K key);

	


}
