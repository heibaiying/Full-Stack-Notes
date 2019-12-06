package com.heibaiying.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class GitRepository {

	private List<Memorandum> repository = new ArrayList<>();

	public void save(Article article) {
		Memorandum memorandum = new Memorandum(article);
		repository.add(memorandum);
	}

	public Article get(int version) {
		Memorandum memorandum = repository.get(version);
		return memorandum.toArticle();
	}

	public Article back() {
		return repository.get(repository.size() - 1).toArticle();
	}
}
