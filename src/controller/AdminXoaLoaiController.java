package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bo.loaibo;

/**
 * Servlet implementation class AdminXoaLoaiController
 */
@WebServlet("/AdminXoaLoaiController")
public class AdminXoaLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminXoaLoaiController() {
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
		try {
			String maloai = request.getParameter("ml");
			loaibo lbo = new loaibo();

			if (maloai != null) {
				int dem = lbo.CountLoai_MoHinh(maloai);
				if (dem == 0) {
					int kq = lbo.xoaloai(maloai);
					response.sendRedirect("AdminQuanLyLoaiController");
				} else {
					request.setAttribute("errbox", "1");
					RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLyLoaiController");
					rd.forward(request, response);
				
				}
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
