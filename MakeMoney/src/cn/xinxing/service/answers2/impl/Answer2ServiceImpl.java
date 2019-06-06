package cn.xinxing.service.answers2.impl;
import java.util.List;

import cn.xinxing.business.Answer2Business;
import cn.xinxing.model.Answers2;
import cn.xinxing.service.answers2.Answer2Service;


public class Answer2ServiceImpl implements Answer2Service{
	@Override

	public List<Answers2> getAllAnswers2() {
		// TODO Auto-generated method stub
		return Answer2Business.getAllAnswers2();
	}
	
	public void addAnswer2(String pid, String pname, String aid, String aname, String title, String price, String description, String a1, String a2, String a3,String a4, String a5) {
		Answer2Business.addAnswer2(pid, pname, aid, aname, title, price, description, a1, a2, a3, a4, a5);
	}
	
	public Answers2 getAnswer2Info(String aid, String pid, String title) {
		return Answer2Business.getAnswer2Info(aid, pid, title);
	}
}
