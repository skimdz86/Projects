package it.crevu.landing.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class LandingServlet
 */
public class LandingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AppCore appCore;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LandingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("IN SERVLET");
		
		appCore = new AppCore();//qui, se no nella init tiene aperta la connessione a vita al db
		
		String nickname = "", email ="", message ="";
		
		String errorDesc ="";
		
		nickname = request.getParameter("name");
		email = request.getParameter("email");
		message = request.getParameter("message");
		
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
			String s=headers.nextElement();
			System.out.println("HEADER: "+s);
			System.out.println("VALUE: "+request.getHeader(s));
		}
		
		response.setContentType("application/json; charset=utf-8");
//		response.setContentType("text/plain");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		
		PrintWriter out = response.getWriter();
	    boolean outcome = false;
	    try{
			appCore.saveUser(nickname, email, message);
			outcome=true;
			
		}catch(MySQLIntegrityConstraintViolationException ex){
			outcome=false;
			System.err.println("Error: duplicate value");
			ex.printStackTrace();
			errorDesc = "DUPLICATED_EMAIL";
		}catch(Exception e){
			outcome=false;
			System.err.println("Generic error in saving user");
			e.printStackTrace();
			errorDesc = "GENERIC_ERROR";
		}
	    finally{
	    	appCore.closeConnection();
	    }
	    
	    JSONObject jsonObj = new JSONObject();
	    
	    if(outcome) jsonObj.put("esito", "OK");
	    else jsonObj.put("esito", "KO");
	    jsonObj.put("error_desc", errorDesc);
	    
//	    String json = "{esito : ";
//	    if(outcome) json+="\"OK\"";
//	    else json+="\"KO\"";
//	    json+=", error_desc: \""+errorDesc+"\"}";
	    
	    out.print(jsonObj);
	    
	    
//	    if(outcome) out.println("OK");
//	    else out.println("KO");
		
	    
	    out.flush();
//	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/esito.html"); 
//		rd.forward(request, response);
		
	}

}
