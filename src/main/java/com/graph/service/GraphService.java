package com.graph.service;

import com.graph.schema.Post;
import com.graph.schema.User;

public interface GraphService {

	User[]  getUser(Long id);

	User getPost(Long id);

	Post[] getComment(Long id);

	Post[] getCommentFromPost(Long id);

	void updatePost(User post);

	void deletePost(Long id);
}
