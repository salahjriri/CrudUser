package com.springboothibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.springboothibernate.model.User;

@Transactional
public interface UserService extends CrudRepository<User, Integer> {
	List<User> findAll();
	void delete(Integer id);
	@SuppressWarnings("unchecked")
	User save(User s);
	boolean exists(Integer id );
	User findOne(Integer id);
}
