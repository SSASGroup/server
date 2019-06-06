package cn.xinxing.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.xinxing.model.Questionnaires;

public class QuestionnaireBusiness {
	public static List<Questionnaires> getAllQuestionnaires() {
		List<Questionnaires> list = new ArrayList<Questionnaires>();
		String sql = null;
		DBHelper db1 = null;
		sql = "select *from questionnaire_question";// SQL
		db1 = new DBHelper(sql);//
		ResultSet ret = null;
		try {
			ret = db1.pst.executeQuery();
			while (ret.next()) {
				String publisher_id = ret.getString(1);
				String publisher_name = ret.getString(2);
				String title = ret.getString(3);
				int price = ret.getInt(4);
				String description = ret.getString(5);
				String question_1 = ret.getString(6);
				String question_2 = ret.getString(7);
				String question_3 = ret.getString(8);
				String question_4 = ret.getString(9);
				String question_5 = ret.getString(10);
				Questionnaires questionnaire = new Questionnaires();
				questionnaire.setId(publisher_id);
				questionnaire.setName(publisher_name);
				questionnaire.setTitle(title);
				questionnaire.setPrice(price);
				questionnaire.setDescription(description);
				questionnaire.setQuestion1(question_1);
				questionnaire.setQuestion2(question_2);
				questionnaire.setQuestion3(question_3);
				questionnaire.setQuestion4(question_4);
				questionnaire.setQuestion5(question_5);
				list.add(questionnaire);
			} //
			ret.close();
			db1.close();//
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //

		return list;
	}
	

	public static void addQuestionnaire(String id, String name, String title, String price, String description, String q1, String q2, String q3,String q4, String q5) {
		String sql = null;
		DBHelper db1 = null;  
		sql = "INSERT INTO `zhengxianqian`.`questionnaire_question` (`publisher_id`, `publisher_name`, `title`, `price`, `description`, `question_1`, `question_2`, `question_3`, `question_4`, `question_5`) VALUES ("+id+", "+name+", "+title+", "+price+", "+description+", "+q1+", "+q2+", "+q3+", "+q4+", "+q5+")";
		//System.out.println(sql); 
		db1 = new DBHelper(sql);
		try {
			int row = db1.pst.executeUpdate();
			db1.close();// 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 
		return;
	}
	
	public static Questionnaires getQuestionnaireInfo(String id, String title) {
		String sql = null;
		DBHelper db1 = null;
		sql = "select * from questionnaire_question where publisher_id=" + id + " and title="+title;// 
		db1 = new DBHelper(sql);// 
		ResultSet ret = null;
		Questionnaires questionnaire = new Questionnaires();
		try {
			ret = db1.pst.executeQuery();
			while (ret.next()) {
				String publisher_id = ret.getString(1);
				String publisher_name = ret.getString(2);
				String _title = ret.getString(3);
				int price = ret.getInt(4);
				String description = ret.getString(5);
				String question_1 = ret.getString(6);
				String question_2 = ret.getString(7);
				String question_3 = ret.getString(8);
				String question_4 = ret.getString(9);
				String question_5 = ret.getString(10);
				questionnaire.setId(publisher_id);
				questionnaire.setName(publisher_name);
				questionnaire.setTitle(_title);
				questionnaire.setPrice(price);
				questionnaire.setDescription(description);
				questionnaire.setQuestion1(question_1);
				questionnaire.setQuestion2(question_2);
				questionnaire.setQuestion3(question_3);
				questionnaire.setQuestion4(question_4);
				questionnaire.setQuestion5(question_5);
			} // 
			ret.close();
			db1.close();// 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 
		return questionnaire;
	}

}




