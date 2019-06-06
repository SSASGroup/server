package cn.xinxing.service.questionnaires;

import java.util.List;

import cn.xinxing.model.Questionnaires;

/**
 * 
 */
public interface QuestionnaireService {
	public List<Questionnaires> getAllQuestionnaires();
	public void addQuestionnaire(String id, String name, String title, String price, String description, String q1, String q2, String q3,String q4, String q5);
	public Questionnaires getQuestionnaireInfo(String id, String title);
}
