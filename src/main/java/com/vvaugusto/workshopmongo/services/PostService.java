package com.vvaugusto.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vvaugusto.workshopmongo.domain.Post;
import com.vvaugusto.workshopmongo.repository.PostRepository;
import com.vvaugusto.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	PostRepository repo;
		
	public List<Post> findAll(){
		
		return repo.findAll();	
	}
	
	public Post findById(String id) {
		
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
		
	}
	
	public Post insert(Post obj) {
		
		return repo.insert(obj);
		
	}
	
	public List<Post> findByTitle(String text){
		
		return repo.searchByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
