package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bo.khachhangbo;

/**
 * Servlet implementation class DangKyControllerG
 */
@WebServlet("/DangKyControllerG")
public class DangKyControllerG extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKyControllerG() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		try {
			String hoten = request.getParameter("ht");
			String diachi = request.getParameter("dc");
			String sodt = request.getParameter("sdt");
			String email = request.getParameter("email");
			String tendn = request.getParameter("tdn");
			String matkhau = request.getParameter("mk");
			String but = request.getParameter("but1");
			khachhangbo khbo = new khachhangbo();
			
			int kq = 0;
			if (hoten != null && hoten != "" && diachi != null && diachi != "" && sodt != null && sodt != ""
					&& email != null && email != "" && tendn != null && tendn != "" && matkhau != null && matkhau != ""
					&& but != null) {

//			kq = khbo.DangKyKh(hoten, diachi, sodt, email, tendn, khachhangbo.ConvertPassMd5(matkhau));
				kq = khbo.DangKy(hoten, diachi, sodt, email, tendn, khachhangbo.ConvertPassMD5(matkhau));
			}

			if (kq == 1) {

//			RequestDispatcher rd = request.getRequestDispatcher("dangNhap.jsp"); 
//			rd.forward(request,response);
//			session.setAttribute("dn", khbean);
				khachhangbean khbean = new khachhangbean();
//			khbean = khbo.DangNhapKh(tendn, khachhangbo.ConvertPassMd5(matkhau));
				khbean = khbo.KTDangNhap(tendn, khachhangbo.ConvertPassMD5(matkhau));
				session.setAttribute("dn", khbean);
//			System.out.println(khbean);

//			RequestDispatcher rd = request.getRequestDispatcher("sachserverlet"); 
//			rd.forward(request,response);
				response.sendRedirect("TrangChuController");
			} else {

				request.setAttribute("ta", 1);
				RequestDispatcher rd = request.getRequestDispatcher("DangKyG.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
