package com.graph.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.graph.schema.Post;
import com.graph.schema.User;
import com.graph.service.GraphService;

@Service
public class GraphServiceImpl implements GraphService{

	private final String URL ="https://jsonplaceholder.typicode.com/";
	
	@Override
	public User[] getUser(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User[]> response = restTemplate.getForEntity(URL+"posts?userId="+id, User[].class);
		return response.getBody();
	}

	@Override
	public User getPost(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User> response = restTemplate.getForEntity(URL+"posts/"+id, User.class);
		return response.getBody();
	}

	@Override
	public Post[] getComment(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Post[]> response = restTemplate.getForEntity(URL+"comments?postId="+id, Post[].class);
		return response.getBody();
	}

	@Override
	public Post[] getCommentFromPost(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Post[]> response = restTemplate.getForEntity(URL+"posts/"+id+"/comments", Post[].class);
		return response.getBody();
	}

	@Override
	public void updatePost(User post) {
		User p = getPost(post.getId());
		p.setBody(post.getBody());
		p.setTitle(post.getTitle());
		p.setUserId(post.getUserId());
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(URL+"posts/"+post.getId(),p);
	}

	@Override
	public void deletePost(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(URL+"posts/"+id);
	}

	
	
}
