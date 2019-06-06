package cn.xinxing.action.answers2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xinxing.business.Answer2Business;
import cn.xinxing.json.core.ListObject;
import cn.xinxing.json.responseUtils.ResponseUtils;
import cn.xinxing.json.status.StatusHouse;
import cn.xinxing.json.utils.JackJsonUtils;
import cn.xinxing.model.Answers2;

/**
 * Servlet implementation class NewInq
 */
@WebServlet("/Answer2Inq")
public class Answer2Inq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Answer2Inq() {
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
		List<Answers2> list = Answer2Business.getAllAnswers2();
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
			String publisher_id = request.getParameter("publisher_id");
			String publisher_name = request.getParameter("publisher_name");
			String answerer_id = request.getParameter("answerer_id");
			String answerer_name = request.getParameter("answerer_name");
			String title = request.getParameter("title");
			String price = request.getParameter("price");
			String description = request.getParameter("description");
			String answer_1 = request.getParameter("answer_1");
			String answer_2 = request.getParameter("answer_2");
			String answer_3 = request.getParameter("answer_3");
			String answer_4 = request.getParameter("answer_4");
			String answer_5 = request.getParameter("answer_5");

			Answer2Business.addAnswer2(publisher_id, publisher_name, answerer_id, answerer_name, title, price, description, answer_1, answer_2, answer_3, answer_4, answer_5);

			listObject.setStatusObject(StatusHouse.COMMON_STATUS_OK);
			
		} else if(type.equals("query")) {
			String publisher_id = request.getParameter("publisher_id");
			String answerer_id = request.getParameter("answerer_id");
			String title = request.getParameter("title");
			List<Answers2> list = new ArrayList<Answers2>();
			list.add(Answer2Business.getAnswer2Info(publisher_id, answerer_id, title));
			listObject.setItems(list);
			listObject.setStatusObject(StatusHouse.COMMON_STATUS_OK);
		} else {
			System.out.println("Wrong" ); 
			listObject.setStatusObject(StatusHouse.COMMON_STATUS_ERROR);
		}
		
		String responseText = JackJsonUtils.toJson(listObject);
		ResponseUtils.renderJson(response, responseText);
	}

}
