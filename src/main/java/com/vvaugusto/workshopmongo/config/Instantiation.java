package com.vvaugusto.workshopmongo.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.vvaugusto.workshopmongo.domain.Post;
import com.vvaugusto.workshopmongo.domain.User;
import com.vvaugusto.workshopmongo.dto.AuthorDTO;
import com.vvaugusto.workshopmongo.dto.CommentDTO;
import com.vvaugusto.workshopmongo.repository.PostRepository;
import com.vvaugusto.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	//Classe de instanciação da base de dados (carga inicial da base de dados)
	
	@Autowired
	UserRepository repo;
	@Autowired
	PostRepository prepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		repo.deleteAll();
		prepo.deleteAll();
		
		User victor = new User(null, "Victor", "victorhyuuk1@gmail.com");
		User vinicius = new User(null, "Vinicius", "viinibarb@gmail.com");
		User ana = new User(null, "Ana", "anajuliatorres@gmail.com");
		User karol = new User(null, "Karolina", "anakarolina@gmail.com");
		
		//Persistir os usuários antes de relacioná-los com post.
		repo.saveAll(Arrays.asList(victor, vinicius, ana, karol));
		
		Post p1 = new Post(null, new AuthorDTO(victor), new Date(), "Noticia", "Fui promovido!!");
		Post p2 = new Post(null, new AuthorDTO(victor), new Date(), "Cinema", "Vou ao cinema sábado!!");
		Post p3 = new Post(null, new AuthorDTO(ana), new Date(), "Sonho", "Vou a Disney !!!");
		Post p4 = new Post(null, new AuthorDTO(karol), new Date(), "Aeeee", "Passei no vestibular!!!");
		
		CommentDTO c1 = new CommentDTO("Parabéns mano!", new Date(), new AuthorDTO(vinicius));
		CommentDTO c2 = new CommentDTO("Parabéns Primo!", new Date(), new AuthorDTO(ana));
		
		p1.getComments().addAll(Arrays.asList(c1, c2));
		
		prepo.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		victor.getPosts().addAll(Arrays.asList(p1, p2));	
		
		repo.save(victor);

	}

}
