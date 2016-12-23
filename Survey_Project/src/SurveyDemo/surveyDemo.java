package SurveyDemo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class surveyDemo
 */
@WebServlet("/surveyDemo")
public class surveyDemo extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public surveyDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uuid = "";
		translateData tdata = new translateData();

		try {
			uuid = request.getParameter("uuid");
			if (uuid.isEmpty() || !tdata.existSurvey(uuid)) {
				request.setAttribute("alertMsg", "No such survey Or you did not enter the UUID");
				getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
				return;
			}
			
			tdata.getData(uuid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<String> txtBoxString = new ArrayList<>();
		
		surveyQuestion[] demo = new surveyQuestion[tdata.getQuestion().size()];

		for (int i = 0; i < (tdata.getQuestion()).size(); i++) {
			demo[i] = new surveyQuestion();
			demo[i].setQuestion((tdata.getQuestion()).get(i));
			demo[i].setName(Integer.toString((i+1)));
			demo[i].setType((tdata.getQuestionType()).get(i));
		}
		
		//set choices	
		int offset = 0;
		for (int i = 0; i < (tdata.getQuestion()).size(); i++) {
			txtBoxString.clear();
			if (demo[i].getType().equals("text")) {
				demo[i].setMaxLength("maxlength=\"20\"");
				txtBoxString.add("");
				demo[i].setChoice(txtBoxString.toArray(new String[txtBoxString.size()]));
				++offset;
				//System.out.println("textbox size -------->"+demo[i].getChoice().length);
			} else {
				if (offset > 0) {
					demo[i].setChoice((tdata.getChoices()).get(i - offset));
				} else {
					demo[i].setChoice((tdata.getChoices()).get(i));
				}
			}

		}
		
		HttpSession session = request.getSession();
		request.getSession().setAttribute("surveyQuestions", demo);
		session.setAttribute("quest", demo);
		request.getSession().setAttribute("SID", tdata.getSID());
		request.getSession().setAttribute("uuid", uuid);
		
		
		getServletContext().getRequestDispatcher("/initSurvey.jsp").forward(request, response);
	}

}
