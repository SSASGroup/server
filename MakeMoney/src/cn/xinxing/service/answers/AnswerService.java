package cn.xinxing.service.answers;

import java.util.List;

import cn.xinxing.model.Answers;

/**
 * 
 */
public interface AnswerService {
	public List<Answers> getAllAnswers();
	public void addAnswer(String pid, String pname, String aid, String aname, String title, String price, String description, String a1, String a2, String a3,String a4, String a5);
	public Answers getAnswerInfo(String aid, String pid, String title);
}
