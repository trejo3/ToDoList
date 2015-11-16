

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Todolist;

/**
 * Servlet implementation class TaskDetails
 */
@WebServlet("/TaskDetails")
public class TaskDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getSingleTask(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getSingleTask(request,response);
	}
	
	public void getSingleTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = customTools.DBUtil.getEmFactory().createEntityManager();

		
		String q="SELECT t FROM Todolist t where t.taskId = :tid";
		TypedQuery<Todolist> qT = em.createQuery(q, Todolist.class);
		qT.setParameter("tid", request.getParameter("tID"));
		
		Todolist desiredTask = null;
		
		String tableinfo = "";
		
		try
		{
			desiredTask = qT.getSingleResult();
			tableinfo = "<tr><td>"+desiredTask.getDescription()+"</td><td>"+desiredTask.getDue()+"</td><td>"+desiredTask.getPriority()+"</td><td>"+desiredTask.getStatusBean().getStatusId()+"</td></tr>";
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally{
			em.close();
			System.out.println("cerrado!");
		}
		
		
		request.setAttribute("tableinfo", tableinfo);
		request.setAttribute("taskID", request.getParameter("tID"));
		request.setAttribute("taskDesc", desiredTask.getDescription());
		request.setAttribute("taskDue", desiredTask.getDue());
		request.setAttribute("taskPriority", desiredTask.getPriority());
		request.setAttribute("taskStatus", desiredTask.getStatusBean().getStatusId());
			
		getServletContext()
		.getRequestDispatcher("/UpdateTask.jsp")
		.forward(request, response);
	}

}
