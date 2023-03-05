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
 * Servlet implementation class XoaSuaGHController
 */
@WebServlet("/XoaSuaGHController")
public class XoaSuaGHController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSuaGHController() {
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
		giohangbo gh = (giohangbo) session.getAttribute("gio");
		
		if (gh != null) {
			if (request.getParameter("xnmua") != null) {
//			RequestDispatcher rd = request.getRequestDispatcher("xacnhanmuaController");
//			rd.forward(request,response);
				response.sendRedirect("XacNhanMuaController");
			} else {
				if (request.getParameter("butsua") != null) {
					String mamh = request.getParameter("butsua");
					String tentb = "t" + mamh;
					long soluong = Long.parseLong(request.getParameter(tentb));
					if (soluong == 0)
						gh.XoaMH(mamh);
					else
						gh.SolLuong(mamh, soluong);

				} else if (request.getParameter("butxoa") != null) {
					String mamohinh = request.getParameter("butxoa");
					gh.XoaMH(mamohinh);

				} else if (request.getParameter("xoaall") != null) {
					String[] gtcheck = request.getParameterValues("check");
					if (gtcheck != null) {
						for (String ss : gtcheck)
							gh.XoaMH(ss);
					} else {
						gh.XoaAll();
					}
				}

				session.setAttribute("gio", gh);
				if (gh.ds.size() == 0)
					response.sendRedirect("TrangChuController");
				else
					response.sendRedirect("GioHangController");
			}
		} else
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
