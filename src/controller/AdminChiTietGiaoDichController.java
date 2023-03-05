package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.xacthucchitietbean;
import bo.xacthucchitietbo;


/**
 * Servlet implementation class AdminChiTietGiaoDichController
 */
@WebServlet("/AdminChiTietGiaoDichController")
public class AdminChiTietGiaoDichController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChiTietGiaoDichController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			String mhd = request.getParameter("mhd");
			
			ArrayList<xacthucchitietbean> dscthd = new ArrayList<xacthucchitietbean>();
			xacthucchitietbo xtcthdbo = new xacthucchitietbo();
			
			if(mhd !=null) {
				dscthd = xtcthdbo.GetCTHoaDon(Long.parseLong(mhd));
			}
			
			request.setAttribute("dscthd", dscthd);
			RequestDispatcher rd = request.getRequestDispatcher("AdminChiTietGiaoDich.jsp");
			rd.forward(request, response);
		}
		catch (Exception e) {
			// TODO: handle exception
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
