package markowski.jee.library.services;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import markowski.jee.library.entities.Author;

@Stateless
@LocalBean
@PermitAll
public class AuthorManagementService {

	@PersistenceContext(unitName = "LibraryPU")
	EntityManager em;

	@Resource
	SessionContext sessionContext;

	public List<Author> getAuthors() {
		return em.createQuery("Select author From AUTHORS author", Author.class)
			.getResultList();
	}

}
