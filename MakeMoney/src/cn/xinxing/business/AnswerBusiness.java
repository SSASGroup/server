package cn.xinxing.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.xinxing.model.Answers;

public class AnswerBusiness {
	public static List<Answers> getAllAnswers() {
		List<Answers> list = new ArrayList<Answers>();
		String sql = null;
		DBHelper db1 = null;
		sql = "select *from questionnaire_answer";
		db1 = new DBHelper(sql);//
		ResultSet ret = null;
		try {
			ret = db1.pst.executeQuery();
			System.out.println(ret); 
			while (ret.next()) {
				String publisher_id = ret.getString(1);
				String publisher_name = ret.getString(2);
				String answerer_id = ret.getString(3);
				String answerer_name = ret.getString(4);
				String title = ret.getString(5);
				int price = ret.getInt(6);
				String description = ret.getString(7);
				String answer_1 = ret.getString(8);
				String answer_2 = ret.getString(9);
				String answer_3 = ret.getString(10);
				String answer_4 = ret.getString(11);
				String answer_5 = ret.getString(12);
				Answers answer = new Answers();
				answer.setPublisherId(publisher_id);
				answer.setPublisherName(publisher_name);
				answer.setAnswererId(answerer_id);
				answer.setAnswererName(answerer_name);
				answer.setTitle(title);
				answer.setPrice(price);
				answer.setDescription(description);
				answer.setAnswer1(answer_1);
				answer.setAnswer2(answer_2);
				answer.setAnswer3(answer_3);
				answer.setAnswer4(answer_4);
				answer.setAnswer5(answer_5);
				list.add(answer);
			} //
			ret.close();
			db1.close();//
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //

		return list;
	}
	

	public static void addAnswer(String pid, String pname, String aid, String aname, String title, String price, String description, String a1, String a2, String a3,String a4, String a5) {
		String sql = null;
		DBHelper db1 = null;
		sql = "INSERT INTO `zhengxianqian`.`questionnaire_answer` (`publisher_id`, `publisher_name`, `answerer_id`, `answerer_name`, `title`, `price`, `description`, `answer_1`, `answer_2`, `answer_3`, `answer_4`, `answer_5`) VALUES ("+pid+", "+pname+", "+aid+", "+aname+", "+title+", "+price+", "+description+", "+a1+", "+a2+", "+a3+", "+a4+", "+a5+")";
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
	
	public static Answers getAnswerInfo(String pid, String aid, String title) {
		String sql = null;
		DBHelper db1 = null;
		sql = "select * from questionnaire_answer where publisher_id=" + pid+" and answerer_id="+aid +" and title="+title;// 
		db1 = new DBHelper(sql);// 
		System.out.println(sql);
		ResultSet ret = null;
		Answers answer = new Answers();
		try {
			ret = db1.pst.executeQuery();
			while (ret.next()) {
				String publisher_id = ret.getString(1);
				System.out.println(publisher_id);
				String publisher_name = ret.getString(2);
				String answerer_id = ret.getString(3);
				String answerer_name = ret.getString(4);
				String _title = ret.getString(5);
				int price = ret.getInt(6);
				String description = ret.getString(7);
				String answer_1 = ret.getString(8);
				String answer_2 = ret.getString(9);
				String answer_3 = ret.getString(10);
				String answer_4 = ret.getString(11);
				String answer_5 = ret.getString(12);
				answer.setPublisherId(publisher_id);
				answer.setPublisherName(publisher_name);
				answer.setAnswererId(answerer_id);
				answer.setAnswererName(answerer_name);
				answer.setTitle(_title);
				answer.setPrice(price);
				answer.setDescription(description);
				answer.setAnswer1(answer_1);
				answer.setAnswer2(answer_2);
				answer.setAnswer3(answer_3);
				answer.setAnswer4(answer_4);
				answer.setAnswer5(answer_5);
			} // 
			ret.close();
			db1.close();// 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 
		return answer;
	}

}




