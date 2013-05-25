package main.java.br.com.zamlutti.comente.controllers;

import main.java.br.com.zamlutti.comente.utils.Urlizer;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class IndexController {

    private final Result result;
    private final Urlizer urlizer;

    public IndexController(Result result, Urlizer urlizer) {
        this.result = result;
        this.urlizer = urlizer;
    }

    @Path("/")
    public void index() {
    }

    @Post
    public void add(String title) {
        result.redirectTo(CommentsController.class).add(
                urlizer.urlize(title, '-'));
    }
}
