package com.heibaiying.behavioral.iterator;

/**
 * 书柜
 */
public interface Bookshelf {

	void addBook(Book book);

	void removeBook(Book book);

	BookIterator iterator();
}
