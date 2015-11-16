

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Users1;

/**
 * Servlet implementation class UserAuthentication
 */
@WebServlet("/UserAuthentication")
public class UserAuthentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAuthentication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		authenticate(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		authenticate(request,response);
	}
	
	public void authenticate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManager em = customTools.DBUtil.getEmFactory().createEntityManager();
		String page = "/UserNotFound.jsp";
		String userID = (String)request.getParameter("userID");
		
		String q="SELECT u FROM Users1 u where u.userId = :uId";
		TypedQuery<Users1> qT = em.createQuery(q, Users1.class);
		qT.setParameter("uId", userID);
		try
		{
		Users1 myUser = qT.getSingleResult();
		page = "/TaskList";
		HttpSession session = request.getSession();
		session.setAttribute("userID", userID);
		getServletContext()
		.getRequestDispatcher(page)
		.forward(request, response);
		}
		catch(NoResultException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			getServletContext()
			.getRequestDispatcher(page)
			.forward(request, response);
		}
//		List<Users1> tempList = qT.getResultList();
//		System.out.println("tempList size: " + tempList.size());
//		if(tempList != null){
//			
//			HttpSession session = request.getSession();
//			
//			session.setAttribute("userID", userID);
//			
//			page = "/TaskList";
//		}
//		else{
//			page = "UserNotFound.jsp";
//			
//		}
//		}
//		catch (Exception e)
//		{
//			System.out.println(e);
//		}
//		finally{
//			em.close();
//			System.out.println("cerrado!");
//			getServletContext()
//			.getRequestDispatcher(page)
//			.forward(request, response);
//		}
		}//closes method

}
