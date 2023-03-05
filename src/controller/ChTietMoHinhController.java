package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.loaibean;
import bean.mohinhbean;
import bo.loaibo;
import bo.mohinhbo;

/**
 * Servlet implementation class ChTietMoHinhController
 */
@WebServlet("/ChTietMoHinhController")
public class ChTietMoHinhController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChTietMoHinhController() {
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
			String mamohinh = request.getParameter("mmh");
			mohinhbo mhbo = new mohinhbo();
			loaibo lbo = new loaibo();
			ArrayList<loaibean> dsloai = lbo.GetDsLoai();
			ArrayList<mohinhbean> dsrandom = mhbo.GetDsRandomMoHinh();
			mohinhbean ctmh = new mohinhbean();
			
			if (mamohinh != null || mamohinh!="") {
				ctmh = mhbo.GetCTMoHinh(mamohinh);
				System.out.print(ctmh);
				request.setAttribute("ctmh", ctmh);
				request.setAttribute("dsloai", dsloai);
				request.setAttribute("dsrandom", dsrandom);
				RequestDispatcher rd = request.getRequestDispatcher("ChiTietMoHinh.jsp");
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
