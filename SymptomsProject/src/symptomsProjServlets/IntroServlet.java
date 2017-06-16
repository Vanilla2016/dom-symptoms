package symptomsProjServlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.DataConnector;
import com.mysql.jdbc.MySQLConnection;


/**
 * Servlet implementation class IntroServlet
 */
@WebServlet("/IntroServlet")
public class IntroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String welcomePageString;
	private String tableValues;
	private DataConnector inputDataConnector = new DataConnector();
	private MySQLConnection inputConnection;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		final String readNameTableString = "SELECT INGREDIENTID, INGREDIENTNAME FROM SYMPTOMSDB.INGREDIENTS";
		
		try {
			 inputConnection = inputDataConnector.getConnection();
			 tableValues = inputDataConnector.readTableVals(inputConnection, readNameTableString, true);
			
			request.setAttribute("message", tableValues);
	        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
