package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USERS1 database table.
 * 
 */
@Entity
@Table (name="USERS1", schema="TESTUSERDB")
@NamedQuery(name="Users1.findAll", query="SELECT u FROM Users1 u")
public class Users1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private String userId;

	@Column(name="FULL_NAME")
	private String fullName;

	//bi-directional many-to-one association to Todolist
	@OneToMany(mappedBy="users1")
	private List<Todolist> todolists;

	public Users1() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Todolist> getTodolists() {
		return this.todolists;
	}

	public void setTodolists(List<Todolist> todolists) {
		this.todolists = todolists;
	}

	public Todolist addTodolist(Todolist todolist) {
		getTodolists().add(todolist);
		todolist.setUsers1(this);

		return todolist;
	}

	public Todolist removeTodolist(Todolist todolist) {
		getTodolists().remove(todolist);
		todolist.setUsers1(null);

		return todolist;
	}

}