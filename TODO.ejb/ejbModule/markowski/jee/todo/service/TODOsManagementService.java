package markowski.jee.todo.service;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.security.authorization.AuthorizationException;

import markowski.jee.todo.entities.TODO;

@Stateless
@LocalBean
@PermitAll
public class TODOsManagementService {

	@PersistenceContext(unitName = "TodoPU")
	EntityManager em;

	@Resource
	SessionContext sessionContext;

	public List<TODO> findTODOs() {
		return em.createQuery("Select td From TODO td", TODO.class)
				.getResultList();
	}

	@RolesAllowed("ADMIN")
	public void addTODO(TODO todo) {
		todo.setUser(sessionContext.getCallerPrincipal().getName());
		todo.setDone(false);

		em.persist(todo);
	}

	public void markTODOAsDone(TODO todo) throws AuthorizationException {
		TODO todoDb = em.find(TODO.class, todo.getId());

		if (sessionContext.isCallerInRole("ADMIN")
				|| sessionContext.getCallerPrincipal().getName()
						.equals(todoDb.getUser())) {
			todoDb.setDone(true);
		} else {
			throw new AuthorizationException("Not allowed!");
		}
	}

}
