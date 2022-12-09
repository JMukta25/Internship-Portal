package net.javaguides.usermanagemt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.User;

//This DAO class provides CRUD database operatons for the table company_info in the database
public class UserDAO {
	private String jdbcURL="jdbc:mysql://localhost:3306/companydb?useSSL=false";
	private String jdbcUsername="root";
	private String jdbcPassword="freedom!";
	
	private static final String INSERT_USERS_SQL = "Insert into companyinfo "+"(companyname,year,position,stipend,students_selected,ppo,"
			+ "branch,duration,location,branches_eligible,ctc,cgpa,link) values"+
	"(?,?,?,?,?,?,?,?,?,?,?,?,?);";
	
	private static final String SELECT_USERS_BY_ID = "select companyid,companyname,year,position,stipend,students_selected,ppo,branch,duration,location,branches_eligible,ctc,cgpa,link from companyinfo where companyid=?;";
	private static final String SELECT_ALL_USERS = "select * from companyinfo";
	private static final String DELETE_USERS_SQL = "delete from companyinfo where companyid=?;";
	private static final String UPDATE_USERS_SQL = "update companyinfo set companyname=? ,year=?, position=?,stipend=?,students_selected=?,ppo=?,branch=?,duration=?,location=?,branches_eligible=?,ctc=?,cgpa=?,link=? where companyid=?;";
	
	protected Connection getConnection()
	{
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	
	//Adding company info
	public void insertUser(User user)
	{
		try(Connection connection=getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USERS_SQL))
		{
			preparedStatement.setString(1, user.getCompanyname());
			preparedStatement.setInt(2, user.getYear());
			preparedStatement.setString(3, user.getPosition());
			preparedStatement.setInt(4, user.getStipend());
			preparedStatement.setInt(5, user.getStudents_selected());
			preparedStatement.setInt(6, user.getPpo());
			preparedStatement.setString(7, user.getBranch());
			preparedStatement.setString(8, user.getDuration());
			preparedStatement.setString(9, user.getLocation());
			preparedStatement.setString(10, user.getBranches_eligible());
			preparedStatement.setInt(11, user.getCtc());
			preparedStatement.setInt(12, user.getCgpa());
			preparedStatement.setString(13, user.getLink());
			preparedStatement.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//update company info
	
	public boolean updateUser(User user) throws SQLException
	{
		boolean rowUpdated;
		try(Connection connection=getConnection();
				PreparedStatement statement=connection.prepareStatement(UPDATE_USERS_SQL);)
		{
			statement.setString(1, user.getCompanyname());
			statement.setInt(2, user.getYear());
			statement.setString(3, user.getPosition());
			statement.setInt(4, user.getStipend());
			statement.setInt(5, user.getStudents_selected());
			statement.setInt(6, user.getPpo());
			statement.setString(7, user.getBranch());
			statement.setString(8, user.getDuration());
			statement.setString(9, user.getLocation());
			statement.setString(10, user.getBranches_eligible());
			statement.setInt(11, user.getCtc());
			statement.setInt(12, user.getCgpa());
			statement.setString(13, user.getLink());
			statement.setInt(14, user.getCompanyid());
			statement.executeUpdate();
			
			rowUpdated = statement.executeUpdate()>0;
			
		}
		return rowUpdated;
	}
	
	//select company by id 
	public User selectUser(int companyid)
	{
		User user=null;
		try(Connection connection=getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(SELECT_USERS_BY_ID);)
		{
			preparedStatement.setInt(1, companyid);
			System.out.println(preparedStatement);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				String companyname=rs.getString("companyname");
				int year=rs.getInt("year");
				String position=rs.getString("position");
				int stipend=rs.getInt("stipend");
				int students_selected=rs.getInt("students_selected");
				int ppo=rs.getInt("ppo");
				String branch=rs.getString("branch");
				String duration=rs.getString("duration");
				String location=rs.getString("location");
				String branches_eligible=rs.getString("branches_eligible");
				int ctc=rs.getInt("ctc");
				int cgpa=rs.getInt("cgpa");
				String link=rs.getString("link");
				user=new User(companyname,year,position,stipend,students_selected,ppo,branch,duration,location,branches_eligible,ctc,cgpa,link);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
	//select all companies 
	
	public List<User> selectAllUser()
	{
		List<User> users=new ArrayList<>();
		try(Connection connection=getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_USERS);)
		{
			System.out.println(preparedStatement);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				int companyid=rs.getInt("companyid");
				String companyname=rs.getString("companyname");
				int year=rs.getInt("year");
				String position=rs.getString("position");
				int stipend=rs.getInt("stipend");
				int students_selected=rs.getInt("students_selected");
				int ppo=rs.getInt("ppo");
				String branch=rs.getString("branch");
				String duration=rs.getString("duration");
				String location=rs.getString("location");
				String branches_eligible=rs.getString("branches_eligible");
				int ctc=rs.getInt("ctc");
				int cgpa=rs.getInt("cgpa");
				String link=rs.getString("link");
				users.add(new User(companyid,companyname,year,position,stipend,students_selected,ppo,branch,duration,location,branches_eligible,ctc,cgpa,link));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return users;
	}
	
	//delete a company
	public boolean deleteUser(int companyid) throws SQLException
	{
		boolean rowDeleted;
		try(Connection connection=getConnection();
				PreparedStatement statement=connection.prepareStatement(DELETE_USERS_SQL);)
		{
			statement.setInt(1, companyid);
			rowDeleted=statement.executeUpdate()>0;
		}
		return rowDeleted;
	}

}
