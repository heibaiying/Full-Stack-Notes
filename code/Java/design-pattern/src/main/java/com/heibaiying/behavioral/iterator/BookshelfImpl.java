package com.heibaiying.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 书柜
 */
public class BookshelfImpl implements Bookshelf {

	private List<Book> bookList = new ArrayList<>();

	@Override
	public void addBook(Book book) {
		bookList.add(book);
	}

	@Override
	public void removeBook(Book book) {
		bookList.remove(book);
	}

	@Override
	public BookIterator iterator() {
		return new BookIterator(bookList);
	}
}
