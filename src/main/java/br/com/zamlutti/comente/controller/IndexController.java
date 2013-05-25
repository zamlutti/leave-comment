package main.java.br.com.zamlutti.comente.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class IndexController {

	private final Result result;

	public IndexController(Result result) {
		this.result = result;
	}

	@Path("/")
	public void index() {
	}

	@Post
	public void add(String title) {
		result.redirectTo(CommentsController.class).add(title);
	}
}
