package com.heibaiying.behavioral.iterator;

public class ZTest {
	public static void main(String[] args) {
		BookshelfImpl bookshelf = new BookshelfImpl();
		bookshelf.addBook(new Book("Java书籍"));
		bookshelf.addBook(new Book("Python书籍"));
		bookshelf.addBook(new Book("Go书籍"));
		BookIterator iterator = bookshelf.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
