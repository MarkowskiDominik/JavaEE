package markowski.jee.library.services;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import markowski.jee.library.entities.User;
import markowski.jee.library.entities.UserRole;

@Stateless
@LocalBean
@PermitAll
public class UserManagementService {

	private static final int OWNER_ROLE_ID = 1;
	private static final int USER_ROLE_ID = 2;

	@PersistenceContext(unitName = "LibraryPU")
	EntityManager em;

	@Resource
	SessionContext sessionContext;

	public List<User> getUsers() {
		return em.createQuery("Select u From User u", User.class)
				.getResultList();
	}

	public void registerNewUser(User user) {
		em.persist(user);
		UserRole userRole = new UserRole(user.getLogin(), USER_ROLE_ID);
		em.persist(userRole);
	}

	public void registerNewOwner(User owner) {
		em.persist(owner);
		UserRole userRole = new UserRole(owner.getLogin(), OWNER_ROLE_ID);
		em.persist(userRole);
	}
}
