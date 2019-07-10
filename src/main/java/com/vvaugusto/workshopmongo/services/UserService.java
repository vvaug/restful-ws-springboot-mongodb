package com.vvaugusto.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vvaugusto.workshopmongo.domain.User;
import com.vvaugusto.workshopmongo.dto.UserDTO;
import com.vvaugusto.workshopmongo.repository.UserRepository;
import com.vvaugusto.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	//Resource -> Service -> Repository -> Domain
	
	@Autowired	//instancia automaticamente o repository. (Injeção de dependência automática)
	UserRepository repo;
	
	public List<User> findAll(){
		
		return repo.findAll();
	}
	
	public User findById(String id) {
		
		Optional<User> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert (User obj) {
		
		return repo.insert(obj);
	}
	
	public User fromDTO (UserDTO objDTO) {	//retornar objeto do banco de dados.
		
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
		
	}
	
	public void delete (String id) {
		
		repo.delete(findById(id));
		
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData (User newObj, User obj) {
		
		newObj.setId(obj.getId());
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}
}
