package markowski.jee.library.services;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import markowski.jee.library.entities.Book;

@Stateless
@LocalBean
@PermitAll
public class BookManagementService {

	@PersistenceContext(unitName = "LibraryPU")
	EntityManager em;

	@Resource
	SessionContext sessionContext;

	public List<Book> getBooks() {
		return em.createQuery("Select b From Book b", Book.class)
				.getResultList();
	}

	@RolesAllowed("OWNER")
	public void addNewBook(Book book) {
		em.persist(book);
	}

}
