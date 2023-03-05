package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class HTGioHangController
 */
@WebServlet("/HTGioHangController")
public class HTGioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HTGioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		
		String mamh = request.getParameter("mmh");
		String tenmh = request.getParameter("tmh");
		long giamh = Long.parseLong(request.getParameter("gia"));
		String anhmh = request.getParameter("anh");
		
		if (mamh != null) {

			giohangbo gh = null;
			// neu mua hang lan dau
			if (session.getAttribute("gio") == null) {

				gh = new giohangbo();// cap vung nho
				session.setAttribute("gio", gh);

			}
			// b1: Luu session ra bien
			gh = (giohangbo) session.getAttribute("gio");
			// b2: Thao tac tren bien
			gh.Them(mamh, tenmh, giamh, (long) 1, anhmh);
			// b3: Luu bien vao session
			session.setAttribute("gio", gh);
			session.setAttribute("gioh", gh.ds);

		}
		
		response.sendRedirect("GioHangController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
