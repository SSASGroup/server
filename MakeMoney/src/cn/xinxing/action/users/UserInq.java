package cn.xinxing.action.users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xinxing.business.UserBusiness;
import cn.xinxing.json.core.ListObject;
import cn.xinxing.json.responseUtils.ResponseUtils;
import cn.xinxing.json.status.StatusHouse;
import cn.xinxing.json.utils.JackJsonUtils;
import cn.xinxing.model.Users;

/**
 * Servlet implementation class NewInq
 */
@WebServlet("/UserInq")
public class UserInq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		List<Users> list = UserBusiness.getAllUsers();
		ListObject listObject=new ListObject();
		listObject.setItems(list);
		listObject.setStatusObject(StatusHouse.COMMON_STATUS_OK);
		String responseText = JackJsonUtils.toJson(listObject);
		ResponseUtils.renderJson(response, responseText);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		ListObject listObject=new ListObject();

		if(type.equals("add")) { 
			String id = request.getParameter("user_id");
			String name = request.getParameter("user_name");
			String password = request.getParameter("user_password");
			String money = request.getParameter("user_money");
			UserBusiness.addUser(id, name, password, money);

			listObject.setStatusObject(StatusHouse.COMMON_STATUS_OK);
			
		} else if(type.equals("query")) {
			String id = request.getParameter("user_id");
			List<Users> list = new ArrayList<Users>();
			list.add(UserBusiness.getUserInfoById(id));
			listObject.setItems(list);
			listObject.setStatusObject(StatusHouse.COMMON_STATUS_OK);
		} else if(type.equals("update")) {
			String id = request.getParameter("user_id");
			String money = request.getParameter("user_money");
			UserBusiness.updateById(id, money);

			listObject.setStatusObject(StatusHouse.COMMON_STATUS_OK);
		} else {
			System.out.println("Wrong" ); 
			listObject.setStatusObject(StatusHouse.COMMON_STATUS_ERROR);
		}
		
		String responseText = JackJsonUtils.toJson(listObject);
		ResponseUtils.renderJson(response, responseText);
	}

}
