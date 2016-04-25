package markowski.jee.todo.jsf.beans;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.jboss.security.authorization.AuthorizationException;

import markowski.jee.todo.entities.TODO;
import markowski.jee.todo.service.TODOsManagementService;

@SessionScoped
@ManagedBean(name = "todoBean")
@PermitAll
public class TODOBean {

	@EJB
	TODOsManagementService todosService;

	public List<TODO> getTodos() {
		return todosService.findTODOs();
	}

	public void setTodoAsDone(TODO todo) throws AuthorizationException {
		todosService.markTODOAsDone(todo);
	}
	
	private TODO todo;

	public TODO getTodo() {
		if (todo == null) {
			todo = new TODO();
		}
		return todo;
	}

	public String addNewTodo() {
		todosService.addTODO(todo);
		todo = null;

		return "list";
	}

}
