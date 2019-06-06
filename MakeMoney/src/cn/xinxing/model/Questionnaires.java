package cn.xinxing.model;

public class Questionnaires {
	private String publisher_id	;
	private String publisher_name;
	private String title;
	private int price;
	private String description;
	private String question_1;
	private String question_2;
	private String question_3;
	private String question_4;
	private String question_5;
	
	public String getId() {
		return publisher_id;
	}
	public void setId(String _id) {
		this.publisher_id = _id;
	}
	
	public String getName() {
		return publisher_name;
	}
	public void setName(String _name) {
		this.publisher_name = _name;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String _title) {
		this.title = _title;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int _price) {
		this.price = _price;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String _description) {
		this.description = _description;
	}
	
	public String getQuestion1() {
		return question_1;
	}
	public void setQuestion1(String _question) {
		this.question_1 = _question;
	}
	
	public String getQuestion2() {
		return question_2;
	}
	public void setQuestion2(String _question) {
		this.question_2 = _question;
	}
	
	public String getQuestion3() {
		return question_3;
	}
	public void setQuestion3(String _question) {
		this.question_3 = _question;
	}
	
	public String getQuestion4() {
		return question_4;
	}
	public void setQuestion4(String _question) {
		this.question_4 = _question;
	}
	
	public String getQuestion5() {
		return question_5;
	}
	public void setQuestion5(String _question) {
		this.question_5 = _question;
	}
}
