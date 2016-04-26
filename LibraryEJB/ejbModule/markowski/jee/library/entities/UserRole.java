package markowski.jee.library.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import markowski.jee.library.ids.UserRoleId;

@Entity
@Table(name = "USER_ROLE")
@IdClass(UserRoleId.class)
public class UserRole {

	@Id
	@Column(name = "USER_LOGIN")
	private String userLogin;
	
	@Id
	@Column(name = "ROLE_ID")
	private Integer roleId;

	protected UserRole(){
	}
	
	public UserRole(String userLogin, Integer roleId) {
		this.userLogin = userLogin;
		this.roleId = roleId;
	}
	
	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
