package main.java.br.com.zamlutti.comente.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class CommentsController {	
	private final Result result;
	
	public CommentsController(Result result) {
		this.result = result;
	}
	
	@Path("/{title}")
	public void add(String title){
		result.include("title", title);
	}
}
