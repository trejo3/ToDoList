package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TODOLIST database table.
 * 
 */
@Entity
@Table (name="TODOLIST", schema="TESTUSERDB")
@NamedQuery(name="Todolist.findAll", query="SELECT t FROM Todolist t")
public class Todolist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TASK_ID")
	private String taskId;

	@Temporal(TemporalType.DATE)
	private Date completed;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date due;

	private int priority;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="STATUS")
	private Status statusBean;

	//bi-directional many-to-one association to Users1
	@ManyToOne
	@JoinColumn(name="ASSIGNED_TO")
	private Users1 users1;

	public Todolist() {
	}

	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Date getCompleted() {
		return this.completed;
	}

	public void setCompleted(Date completed) {
		this.completed = completed;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDue() {
		return this.due;
	}

	public void setDue(Date due) {
		this.due = due;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Status getStatusBean() {
		return this.statusBean;
	}

	public void setStatusBean(Status statusBean) {
		this.statusBean = statusBean;
	}

	public Users1 getUsers1() {
		return this.users1;
	}

	public void setUsers1(Users1 users1) {
		this.users1 = users1;
	}

}