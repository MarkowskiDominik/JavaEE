package markowski.jee.library.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKS")
public class Book {

	@Id
	@Column(name = "ID")
	@javax.persistence.GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "TITLE")
	private String title;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}