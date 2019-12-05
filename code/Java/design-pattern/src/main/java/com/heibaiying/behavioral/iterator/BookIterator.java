package com.heibaiying.behavioral.iterator;

import java.util.List;

public class BookIterator implements Iterator<Book> {

	private List<Book> bookList;
	private int position = 0;

	public BookIterator(List<Book> bookList) {
		this.bookList = bookList;
	}

	@Override
	public Book next() {
		return bookList.get(position++);
	}

	@Override
	public boolean hasNext() {
		return position < bookList.size();
	}
}
