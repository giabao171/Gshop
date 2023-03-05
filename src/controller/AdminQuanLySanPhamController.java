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

import bean.loaibean;
import bean.mohinhbean;
import bo.loaibo;
import bo.mohinhbo;

/**
 * Servlet implementation class AdminQuanLySanPhamController
 */
@WebServlet("/AdminQuanLySanPhamController")
public class AdminQuanLySanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminQuanLySanPhamController() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("dnad") == null) {
				response.sendRedirect("AdminKTDangNhapController");
			} else {
				mohinhbo mhbo = new mohinhbo();

				ArrayList<mohinhbean> dsmohinh = null;

				int currentPage = 1;
				if (request.getParameter("page") != null) {
					currentPage = Integer.parseInt(request.getParameter("page"));
				}

				int totalMohinh = mhbo.GetTotalMoHinh();
				int endPage = totalMohinh / 12;
				if (totalMohinh % 12 != 0) {
					endPage++;

					dsmohinh = mhbo.GetDsMoHinh(currentPage);
					if(request.getAttribute("errbox") == "1") {
						request.setAttribute("ebox", "1");
					}
					if(request.getParameter("noterr") == "1") {
						request.setAttribute("ebox", "0");
					}

					request.setAttribute("dsmohinh", dsmohinh);
					request.setAttribute("endP", endPage);
					request.setAttribute("currentP", currentPage);

					RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLySanPham.jsp");
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
