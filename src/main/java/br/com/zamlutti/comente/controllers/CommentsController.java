package main.java.br.com.zamlutti.comente.controllers;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class CommentsController {
	private final Result result;

	public CommentsController(Result result) {
		this.result = result;
	}

	@Path("/{title}")
	public void add(String title) {
		result.include("title", title);
	}

	@Post
	public void save(String email, String comment) {
		result.redirectTo(IndexController.class).index();
	}
}
