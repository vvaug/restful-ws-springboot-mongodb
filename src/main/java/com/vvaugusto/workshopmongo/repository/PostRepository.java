package com.vvaugusto.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.vvaugusto.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	//Consultas com QueryMethods
	
	List<Post> findByTitleContainingIgnoreCase(String text);	//Spring Data monta a consulta.
	
	//Consultas personalizadas com @Query
	
	//regex: ?0 pega o primeiro parâmetro do método.
	//options: i -> ignora maiusculo de minusculo.
	
	@Query("{ 'title': { $regex: ?0 $options: 'i' } }")
	List<Post> searchByTitle(String text);
	
	//Consultas com diversos critérios
	
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
