package com.heibaiying.behavioral.memento;

public class ZTest {
	public static void main(String[] args) {
		GitRepository repository = new GitRepository();
		Article article = new Article("Java手册", "版本一");
		repository.save(article);
		article.setContent("版本二");
		repository.save(article);
		article.setContent("版本三");
		repository.save(article);
		System.out.println(repository.back());
		System.out.println(repository.get(0));
	}
}
