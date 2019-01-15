package com.cmc.gdp05.group4.service.impl;

public interface BaseService<T> {
	boolean insert(T object);
	boolean update(T object);
	boolean delete(String email);
}
