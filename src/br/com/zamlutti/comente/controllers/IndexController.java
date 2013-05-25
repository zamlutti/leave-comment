package br.com.zamlutti.comente.controllers;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zamlutti.comente.utils.Urlizer;

@Resource
public class IndexController {

    private Result result;
    private Urlizer urlizer;

    public IndexController(Result result, Urlizer urlizer) {
        this.result = result;
        this.urlizer = urlizer;
    }

    @Path("/")
    public void index() {
    }

    @Post
    public void add(String title) {
        String urlizedTitle = this.urlizer.urlize(title, '-');
        this.result.redirectTo(CommentsController.class).add(urlizedTitle);
    }
}
