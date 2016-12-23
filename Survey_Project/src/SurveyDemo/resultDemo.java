package SurveyDemo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class resultDemo
 */
@WebServlet("/resultDemo")
public class resultDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String sql = null;
		insertResult ir = new insertResult();
		String sid = (String) request.getSession().getAttribute("SID");
		String uuid = (String) request.getSession().getAttribute("uuid");
		
		surveyQuestion[] demo = (surveyQuestion[])request.getSession().getAttribute("surveyQuestions");
		
		try {
			ir.isExist(uuid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < demo.length; i++) {
			if (demo[i].getType().equals("checkbox")) {
				String[] checkboxValues = (String[])request.getParameterValues(Integer.toString(i+1));
				//System.out.println(checkboxValues.length);
				if (checkboxValues == null) {
					ir.insertSql(uuid,sid,Integer.toString(i + 1)," ");
				}else {
					for (String values : checkboxValues) {
						//System.out.println(sql);
						ir.insertSql(uuid,sid,Integer.toString(i + 1),values);
					}
				}
			} else {
				//System.out.println(sql);
				String temp = request.getParameter(Integer.toString(i + 1));
				if (temp == null) {
					ir.insertSql(uuid,sid,Integer.toString(i + 1), " ");
				}else {
					ir.insertSql(uuid,sid,Integer.toString(i + 1), temp);
				}
				

			}
		}
		
		response.getWriter().append("Result: ").append("Survey Submit Successful");
		
	}
	
}
