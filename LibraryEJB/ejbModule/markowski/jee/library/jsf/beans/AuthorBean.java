package markowski.jee.library.jsf.beans;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import markowski.jee.library.entities.Author;
import markowski.jee.library.services.AuthorManagementService;

@SessionScoped
@ManagedBean(name = "authorBean")
@PermitAll
public class AuthorBean {

	@EJB
	AuthorManagementService authorService;
	
	public List<Author> getAuthors() {
		return authorService.getAuthors();
	}
}
