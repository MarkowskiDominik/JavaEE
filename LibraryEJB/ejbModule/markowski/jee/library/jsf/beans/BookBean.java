package markowski.jee.library.jsf.beans;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import markowski.jee.library.entities.Book;
import markowski.jee.library.services.BookManagementService;

@SessionScoped
@ManagedBean(name = "bookBean")
@PermitAll
public class BookBean {

	@EJB
	BookManagementService bookService;

	public List<Book> getBooks() {
		return bookService.getBooks();
	}
	
	private Book book;

	public Book getBook() {
		if (book == null) {
			book = new Book();
		}
		return book;
	}

	public void addNewBook() {
		bookService.addNewBook(book);
	}
}
