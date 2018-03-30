package com.acucaradus.app.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitservices.app.dao.NewsDAO;
import com.bitservices.app.models.News;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/")
public class RestAPIController {
	@Autowired 
	private NewsDAO newsDAO;

	@PostMapping(value = "/news")
	public ResponseEntity addNews(@RequestBody News news) {
		System.out.println(news);
		if (this.newsDAO.create(news)) {
			return new ResponseEntity(news, HttpStatus.CREATED);
		} else {
			return new ResponseEntity(news, HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value = "/news/highestid")
	public ResponseEntity getHighestId() {
		return new ResponseEntity(this.newsDAO.getHighestNewsId(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/registerVote")
	public ResponseEntity registerVote(@RequestBody News news) {
		System.out.println("nid: "+news.getNid()+" votesUp: "+news.getVotesUp()+" votesDown: "+news.getVotesDown());
		news = this.newsDAO.registerVote(news);
		return new ResponseEntity(news, HttpStatus.OK);
		
	}
	
}
