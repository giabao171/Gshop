package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.adminbean;
import bo.adminbo;



/**
 * Servlet implementation class AdminDangKyController
 */
@WebServlet("/AdminDangKyController")
public class AdminDangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDangKyController() {
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
			
			String tendn = request.getParameter("tdn");
			String matkhau = request.getParameter("mk");
			String but = request.getParameter("but1");
			
			adminbo adbo = new adminbo();
			
			int kq = 0;
			if (tendn != null && tendn != "" && matkhau != null && matkhau != ""
					&& but != null) {

				kq = adbo.DangKy(tendn, adminbo.ConvertPassMD5(matkhau), true);
			}

			if (kq == 1) {
				adminbean adbean = new adminbean();

				adbean = adbo.KTDangNhap(tendn, adminbo.ConvertPassMD5(matkhau));
				session.setAttribute("dnad", adbean);
				response.sendRedirect("AdminTrangChuController");
			} else {

				request.setAttribute("ta", 1);
				RequestDispatcher rd = request.getRequestDispatcher("AdminDangKy.jsp");
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
