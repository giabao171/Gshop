package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.hoadonbean;
import bo.hoadonbo;

/**
 * Servlet implementation class AdminLichSuGiaoDichController
 */
@WebServlet("/AdminLichSuGiaoDichController")
public class AdminLichSuGiaoDichController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLichSuGiaoDichController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		try {

			if (session.getAttribute("dnad") == null) {
				response.sendRedirect("AdminKTDangNhapController");
			} else {
				hoadonbo hdbo = new hoadonbo();
				ArrayList<hoadonbean> dshddm = hdbo.GetHDDaMua();

				request.setAttribute("dshddm", dshddm);
				RequestDispatcher rd = request.getRequestDispatcher("AdminLichSuGiaoDich.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
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
