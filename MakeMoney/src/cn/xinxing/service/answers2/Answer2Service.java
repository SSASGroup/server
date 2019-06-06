package cn.xinxing.service.answers2;

import java.util.List;

import cn.xinxing.model.Answers2;

/**
 * 
 */
public interface Answer2Service {
	public List<Answers2> getAllAnswers2();
	public void addAnswer2(String pid, String pname, String aid, String aname, String title, String price, String description, String a1, String a2, String a3,String a4, String a5);
	public Answers2 getAnswer2Info(String aid, String pid, String title);
}
