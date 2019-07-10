package com.vvaugusto.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vvaugusto.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {	//<Classe, tipo_id>
	
}
