package com.heibaiying.behavioral.memento;

import java.util.Date;

public class Memorandum {

	private String title;
	private String content;
	private Date createTime;

	public Memorandum(Article article) {
		this.title = article.getTitle();
		this.content = article.getContent();
		this.createTime = new Date();
	}

	public Article toArticle() {
		return new Article(this.title, this.content);
	}

}
