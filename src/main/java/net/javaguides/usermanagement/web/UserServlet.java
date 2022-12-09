package net.javaguides.usermanagement.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermanagement.model.User;
import net.javaguides.usermanagemt.dao.UserDAO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        this.userDAO=new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getServletPath();
		switch(action)
		{
		case "/new":
			showNewForm(request,response);
			break;
		case "/insert":
			insertUser(request,response);
			break;
		case "/delete":
			try {
				deleteUser(request,response);
			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/edit":
			try {
				showEditForm(request,response);
			} catch (IOException | SQLException | ServletException e) {
				e.printStackTrace();
			}
			break;
		case "/update":
			try {
				updateUser(request,response);
			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			try {
				listUser(request,response);
			} catch (IOException | SQLException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)throws  IOException, SQLException,ServletException
	{
		List<User> listUser=userDAO.selectAllUser();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher=request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)throws  IOException, SQLException
	{
		int companyid=Integer.parseInt(request.getParameter("companyid"));
		String companyname=request.getParameter("companyname");
		int year=Integer.parseInt(request.getParameter("year"));
    	String position=request.getParameter("position");
    	int stipend=Integer.parseInt(request.getParameter("stipend"));
    	int students_selected=Integer.parseInt(request.getParameter("students_selected"));
    	int ppo=Integer.parseInt(request.getParameter("ppo"));
    	String branch=request.getParameter("branch");
    	String duration=request.getParameter("duration");
    	String location=request.getParameter("location");
    	String branches_eligible=request.getParameter("branches_eligible");
    	int ctc=Integer.parseInt(request.getParameter("ctc"));
    	int cgpa=Integer.parseInt(request.getParameter("cgpa"));
    	String link=request.getParameter("link");
    	
    	User user=new User(companyid,companyname,year,position,stipend,students_selected,ppo,branch,duration,location,branches_eligible,ctc,cgpa,link);
    	userDAO.updateUser(user);
    	response.sendRedirect("list");
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws  IOException, SQLException
	{	
		int companyid=Integer.parseInt(request.getParameter("companyid"));
		userDAO.deleteUser(companyid);
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws  IOException, SQLException,ServletException
	{
		int companyid=Integer.parseInt(request.getParameter("companyid"));
		User existingUser=userDAO.selectUser(companyid);
		RequestDispatcher dispatcher=request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
    private void insertUser (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	String companyname=request.getParameter("companyname");
    	int year=Integer.parseInt(request.getParameter("year"));
    	String position=request.getParameter("position");
    	int stipend=Integer.parseInt(request.getParameter("stipend"));
    	int students_selected=Integer.parseInt(request.getParameter("students_selected"));
    	int ppo=Integer.parseInt(request.getParameter("ppo"));
    	String branch=request.getParameter("branch");
    	String duration=request.getParameter("duration");
    	String location=request.getParameter("location");
    	String branches_eligible=request.getParameter("branches_eligible");
    	int ctc=Integer.parseInt(request.getParameter("ctc"));
    	int cgpa=Integer.parseInt(request.getParameter("cgpa"));
    	String link=request.getParameter("link");
    	
    	User newUser=new User(companyname,year,position,stipend,students_selected,ppo,branch,duration,location,branches_eligible,ctc,cgpa,link);
    	userDAO.insertUser(newUser);
    	response.sendRedirect("list");
    	
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
