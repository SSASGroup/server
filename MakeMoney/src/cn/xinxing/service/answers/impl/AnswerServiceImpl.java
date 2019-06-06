package cn.xinxing.service.answers.impl;
import java.util.List;

import cn.xinxing.business.AnswerBusiness;
import cn.xinxing.model.Answers;
import cn.xinxing.service.answers.AnswerService;


public class AnswerServiceImpl implements AnswerService{
	@Override

	public List<Answers> getAllAnswers() {
		// TODO Auto-generated method stub
		return AnswerBusiness.getAllAnswers();
	}
	
	public void addAnswer(String pid, String pname, String aid, String aname, String title, String price, String description, String a1, String a2, String a3,String a4, String a5) {
		AnswerBusiness.addAnswer(pid, pname, aid, aname, title, price, description, a1, a2, a3, a4, a5);
	}
	
	public Answers getAnswerInfo(String aid, String pid, String title) {
		return AnswerBusiness.getAnswerInfo(aid, pid, title);
	}
}
