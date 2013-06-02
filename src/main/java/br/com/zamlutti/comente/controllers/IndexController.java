package br.com.zamlutti.comente.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.zamlutti.comente.entities.Entry;
import br.com.zamlutti.comente.repositories.EntryRepository;
import br.com.zamlutti.comente.utils.Urlizer;

@Resource
public class IndexController {

	private final Result result;
	private final Urlizer urlizer;
	private final EntryRepository entryRepository;
	private final Validator validator;

	public IndexController(Result result, Validator validator, Urlizer urlizer,
			EntryRepository entryRepository) {
		this.result = result;
		this.validator = validator;
		this.urlizer = urlizer;
		this.entryRepository = entryRepository;
	}

	@Get("/")
	public void index() {
	}

	@Post("/")
	public void add(Entry entry) {
		this.validator.validate(entry);
		this.validator.onErrorRedirectTo(IndexController.class).index();

		String title = entry.getTitle();
		String url = this.urlizer.urlize(title, '-');
		Entry entryFound = this.entryRepository.find(url);
		if (entryFound == null) {
			entry.setUrl(url);
			this.entryRepository.save(entry);
		}

		this.result.redirectTo(CommentsController.class).add(url);
	}
}
