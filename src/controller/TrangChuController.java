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
 * Servlet implementation class TrangChuController
 */
@WebServlet("/TrangChuController")
public class TrangChuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrangChuController() {
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
		
		String key = request.getParameter("txttk");

		if(request.getParameter("key") != null) {
			key = request.getParameter("key");
		}
		String ml = request.getParameter("ml");
		
		loaibo lbo = new loaibo();
		mohinhbo mhbo = new mohinhbo();
		
		ArrayList<loaibean> dsloai = lbo.GetDsLoai();
		request.setAttribute("dsloai", dsloai);
		
		ArrayList<mohinhbean> dsmohinh = null;
//		request.setAttribute("dsmohinh", dsmohinh);
		
		int currentPage = 1;
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		int totalMohinh = mhbo.GetTotalMoHinh();
		int endPage = totalMohinh / 12;
		if (totalMohinh % 12 != 0) {
			endPage++;
		}
		
		if (ml != null && ml !="") {
			dsmohinh = mhbo.GetDsMoHinh_Loai(ml, currentPage);
			totalMohinh = mhbo.GetTotalMoHinh_Loai(ml);
//			System.out.println(dsmohinh);
//			System.out.println(totalMohinh);
			endPage = totalMohinh / 12;
			if (totalMohinh % 12 != 0) {
				endPage++;
			}
		}else if (key != null && key!="") {
			dsmohinh = mhbo.GetDsMoHinh_Td(key, currentPage);
			totalMohinh = mhbo.GetTotalMoHinh_Td(key);
//			System.out.println(dsmohinh);
//			System.out.println(totalMohinh);
			endPage = totalMohinh / 12;
			if (totalMohinh % 12 != 0) {
				endPage++;
			}
		} else {
			dsmohinh = mhbo.GetDsMoHinh(currentPage);
			
		}
		
		request.setAttribute("dsmohinh", dsmohinh);
		request.setAttribute("endP", endPage);
		request.setAttribute("currentP", currentPage);
		request.setAttribute("mloai", ml);
		request.setAttribute("keyTD", key);
		
		RequestDispatcher rd = request.getRequestDispatcher("TrangChu.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
