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
 * Servlet implementation class AdminThemLoaiController
 */
@WebServlet("/AdminThemLoaiController")
public class AdminThemLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminThemLoaiController() {
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
			String maloai = request.getParameter("maloai");
			String tenloai = request.getParameter("tenloai");
			String thembtn = request.getParameter("thembtn");
			String backbtn = request.getParameter("backbtn");
			loaibo lbo = new loaibo();
			if (request.getParameter("noterr") != "1") {
				if (thembtn != null) {
					int count = lbo.CountLoai_Loai(maloai);

					if (count == 0) {
						int kq = lbo.themloai(maloai, tenloai);
						response.sendRedirect("AdminQuanLyLoaiController");
					} else {
						request.setAttribute("ebox", "1");
						RequestDispatcher rd = request.getRequestDispatcher("AdminThemLoai.jsp");
						rd.forward(request, response);
					}

				} else if (backbtn != null) {
					response.sendRedirect("AdminQuanLyLoaiController");
				} else {
					response.sendRedirect("AdminThemLoai.jsp");
				}
			} else {
				response.sendRedirect("AdminThemLoai.jsp");
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
