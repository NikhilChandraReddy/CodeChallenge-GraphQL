package com.graph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.graph.schema.Post;
import com.graph.schema.User;
import com.graph.service.GraphService;

@RestController
public class GraphController {
	@Autowired
	private GraphService graphService;
	
	@GetMapping("/getUser/{id}")
	public User[] getUser(@PathVariable Long id) {
		return graphService.getUser(id);
	}
	
	@GetMapping("/getPost/{id}")
	public User getPost(@PathVariable Long id) {
		return graphService.getPost(id);
	}
	
	@GetMapping("/getComment/{id}")
	public Post[] getComment(@PathVariable Long id) {
		return graphService.getComment(id);
	}
	
	@GetMapping("/getCommentFromPost/{id}")
	public Post[] getCommentFromPost(@PathVariable Long id) {
		return graphService.getCommentFromPost(id);
	}
	
	@PutMapping("/updatePost")
	public void updatePost(@RequestBody User post) {
		graphService.updatePost(post);
	}
	
	@GetMapping("/deletePost/{id}")
	public void deletePost(@PathVariable Long id) {
		graphService.deletePost(id);
	}
}
