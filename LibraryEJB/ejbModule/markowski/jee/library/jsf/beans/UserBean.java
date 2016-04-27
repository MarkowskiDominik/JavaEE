package markowski.jee.library.jsf.beans;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.jboss.security.auth.spi.Util;

import markowski.jee.library.entities.User;
import markowski.jee.library.services.UserManagementService;

@SessionScoped
@ManagedBean(name = "userBean")
@PermitAll
public class UserBean {

	@EJB
	UserManagementService userService;

	private User user;
	private String repeatPassword;

	public List<User> getUsers() {
		return userService.getUsers();
	}

	public User getUser() {
		if (user == null) {
			user = new User();
		}
		return user;
	}

	public void registerNewUser() {
		user.setPassword(generatePasswordHash(user.getPassword()));
		userService.registerNewUser(user);
	}

	public Boolean correctPasswords() {
		return repeatPassword != null && user.getPassword() != null
				&& repeatPassword.equals(user.getPassword());
	}

	private String generatePasswordHash(String password) {
		return Util.createPasswordHash("SHA-256", "BASE64", null, null,
				password);
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
}
