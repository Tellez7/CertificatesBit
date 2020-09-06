package com.bit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bit.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public User findById(long id);

	public List<User> findAll();
}
