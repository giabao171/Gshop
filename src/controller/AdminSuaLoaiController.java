package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.loaibean;
import bo.loaibo;

/**
 * Servlet implementation class AdminSuaLoaiController
 */
@WebServlet("/AdminSuaLoaiController")
public class AdminSuaLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSuaLoaiController() {
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
			String maloai = request.getParameter("ml");
			
			String txtmaloai = request.getParameter("maloai");
			String tenloai = request.getParameter("tenloai");
			String suabtn = request.getParameter("suabtn");
			String backbtn = request.getParameter("backbtn");
			
			loaibo lbo = new loaibo();
			loaibean lbean = new loaibean();
			
			if(suabtn != null) {
				int kq = lbo.sualoai(txtmaloai, tenloai, txtmaloai);
				response.sendRedirect("AdminQuanLyLoaiController");
			}
			else if(backbtn != null) {
				response.sendRedirect("AdminQuanLyLoaiController");
			}
			else {
				lbean = lbo.GetLoaiItem(maloai);
				
				request.setAttribute("loaiitem", lbean);
				RequestDispatcher rd = request.getRequestDispatcher("AdminSuaLoai.jsp");
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
