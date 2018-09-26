package br.edu.ftt.ec.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import br.edu.cefsa.ftt.ec.dao.FormularioDao;
import br.edu.cefsa.ftt.ec.model.Formulario;

/**
 * Servlet implementation class Formulario
 */
@WebServlet("/formulario")
public class FormularioApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Formulario> formularioData = new ArrayList<Formulario>(); //Pode remover...
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			             HttpServletResponse response) throws ServletException, 
	                                                          IOException {
		// TODO Auto-generated method stub
		response.getWriter()
                    .append(request.getParameter("id")).append(";")
		            .append(request.getParameter("nome")).append(";")
		            .append(request.getParameter("data")).append(";")
		            .append(request.getParameter("idade"));
		
		System.out.println(request);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Formulario f = new Formulario(
				request.getParameter("id"), //ID sera gerado no BD pela sequence
				request.getParameter("nome"),
        		request.getParameter("data"),
        		request.getParameter("idade");
		
		System.out.print(f);
		
		FormularioDao fd = new FormularioDao();
		
		String status = "OK";
		String message = "Formulario data saved!";
		String now = String.valueOf(new Date());
		
		try {
		   fd.addFormulario(p);
		} catch (Exception e) {
			status = "Error";
			message = e.getMessage();
			System.err.println(now +  " - Ops!! - " + message);
			System.err.println(now +  " - Ops!! - " + p);
			e.printStackTrace();
		}
		
		response.setContentType("application/json"); //MIME Type
		response.setCharacterEncoding("utf-8");
		
	    //create Json Object
		JsonObject json = new JsonObject();

		// put some value pairs into the JSON object .
		
		json.addProperty("Status", status);
		json.addProperty("Message", message);
		json.addProperty("Time", now);


		 response.getWriter().print(json.toString());
         response.flushBuffer();
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
