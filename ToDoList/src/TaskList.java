

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Todolist;

/**
 * Servlet implementation class TaskList
 */
@WebServlet("/TaskList")
public class TaskList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		getTasks(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		getTasks(request,response);
	}

	public void getTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = customTools.DBUtil.getEmFactory().createEntityManager();
		HttpSession session = request.getSession();

		String userID = (String) session.getAttribute("userID");

		String q = "SELECT t FROM Todolist t where t.statusBean.statusId != 3 and t.users1.userId = :userID";

		TypedQuery<Todolist> qT = em.createQuery(q, Todolist.class);

		qT.setParameter("userID", userID);

		List<Todolist> Tasks = null;

		String tableinfo = "";

		Tasks = qT.getResultList();
		for(int i=0;i<Tasks.size();i++)
		{
			String tID = Tasks.get(i).getTaskId();
			tableinfo += "<tr><td>" + Tasks.get(i).getDescription()+"</td><td>" + Tasks.get(i).getDue()+"</td><td>" + Tasks.get(i).getPriority()+"</td><td>" + Tasks.get(i).getStatusBean().getStatusId()+"</td><td><a href=\"TaskDetails?tID="+tID+"\">" + "Update"+"</td></tr>";
		}
		request.setAttribute("tableinfo", tableinfo);

		getServletContext()
		.getRequestDispatcher("/TaskList.jsp")
		.forward(request, response);
	}

}
