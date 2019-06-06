package cn.xinxing.action.questionnaires;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xinxing.business.QuestionnaireBusiness;
import cn.xinxing.json.core.ListObject;
import cn.xinxing.json.responseUtils.ResponseUtils;
import cn.xinxing.json.status.StatusHouse;
import cn.xinxing.json.utils.JackJsonUtils;
import cn.xinxing.model.Questionnaires;

/**
 * Servlet implementation class NewInq
 */
@WebServlet("/QuestionnaireInq")
public class QuestionnaireInq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionnaireInq() {
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
		List<Questionnaires> list = QuestionnaireBusiness.getAllQuestionnaires();
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
			String title = request.getParameter("title");
			String price = request.getParameter("price");
			String description = request.getParameter("description");
			String question_1 = request.getParameter("question_1");
			String question_2 = request.getParameter("question_2");
			String question_3 = request.getParameter("question_3");
			String question_4 = request.getParameter("question_4");
			String question_5 = request.getParameter("question_5");

			QuestionnaireBusiness.addQuestionnaire(publisher_id, publisher_name, title, price, description, question_1, question_2, question_3, question_4, question_5);

			listObject.setStatusObject(StatusHouse.COMMON_STATUS_OK);
			
		} else if(type.equals("query")) {
			String publisher_id = request.getParameter("publisher_id");
			String title = request.getParameter("title");
			List<Questionnaires> list = new ArrayList<Questionnaires>();
			list.add(QuestionnaireBusiness.getQuestionnaireInfo(publisher_id, title));
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
