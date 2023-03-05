package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.mohinhbo;

/**
 * Servlet implementation class AdminXoaSanPhamController
 */
@WebServlet("/AdminXoaSanPhamController")
public class AdminXoaSanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminXoaSanPhamController() {
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
			String mamh = request.getParameter("mmh");
			mohinhbo mhbo = new mohinhbo();

			if (mamh != null) {
				int dem = mhbo.KTDemMoHinh_CTHD(mamh);
				if (dem == 0) {
					int kq = mhbo.XoaMoHinh(mamh);
					response.sendRedirect("AdminQuanLySanPhamController");
				} else {
					request.setAttribute("errbox", "1");
					RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLySanPhamController");
					rd.forward(request, response);
				
				}
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
