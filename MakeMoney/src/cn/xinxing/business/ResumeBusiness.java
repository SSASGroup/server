package cn.xinxing.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.xinxing.model.Questionnaires;
import cn.xinxing.model.Resumes;

public class ResumeBusiness {
	public static List<Resumes> getAllResumes() {
		List<Resumes> list = new ArrayList<Resumes>();
		String sql = null;
		DBHelper db1 = null;
		sql = "select *from resume_question";// SQL
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
				Resumes resume = new Resumes();
				resume.setId(publisher_id);
				resume.setName(publisher_name);
				resume.setTitle(title);
				resume.setPrice(price);
				resume.setDescription(description);
				list.add(resume);
			} //
			ret.close();
			db1.close();//
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //

		return list;
	}
	

	public static void addResume(String id, String name, String title, String price, String description) {
		String sql = null;
		DBHelper db1 = null;  
		sql = "INSERT INTO `zhengxianqian`.`resume_question` (`publisher_id`, `publisher_name`, `title`, `price`, `description`) VALUES ("+id+", "+name+", "+title+", "+price+", "+description+")";
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
	
	public static Resumes getResumeInfo(String id, String title) {
		String sql = null;
		DBHelper db1 = null;
		sql = "select * from resume_question where publisher_id=" + id + " and title="+title;// 
		db1 = new DBHelper(sql);// 
		ResultSet ret = null;
		Resumes resume = new Resumes();
		try {
			ret = db1.pst.executeQuery();
			while (ret.next()) {
				String publisher_id = ret.getString(1);
				String publisher_name = ret.getString(2);
				String _title = ret.getString(3);
				int price = ret.getInt(4);
				String description = ret.getString(5);
				resume.setId(publisher_id);
				resume.setName(publisher_name);
				resume.setTitle(_title);
				resume.setPrice(price);
				resume.setDescription(description);
			} // 
			ret.close();
			db1.close();// 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 
		return resume;
	}

}




