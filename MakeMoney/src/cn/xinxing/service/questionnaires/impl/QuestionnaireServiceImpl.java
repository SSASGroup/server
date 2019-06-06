package cn.xinxing.service.questionnaires.impl;
import java.util.List;

import cn.xinxing.business.QuestionnaireBusiness;
import cn.xinxing.model.Questionnaires;
import cn.xinxing.service.questionnaires.QuestionnaireService;


public class QuestionnaireServiceImpl implements QuestionnaireService{
	@Override

	public List<Questionnaires> getAllQuestionnaires() {
		// TODO Auto-generated method stub
		return QuestionnaireBusiness.getAllQuestionnaires();
	}
	
	public void addQuestionnaire(String id, String name, String title, String price, String description, String q1, String q2, String q3,String q4, String q5) {
		QuestionnaireBusiness.addQuestionnaire(id, name, title, price, description, q1, q2, q3, q4, q5);
	}
	
	public Questionnaires getQuestionnaireInfo(String id, String title) {
		return QuestionnaireBusiness.getQuestionnaireInfo(id, title);
	}
}
