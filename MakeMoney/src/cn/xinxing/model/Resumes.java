package cn.xinxing.model;

public class Resumes {
	private String publisherId;
	private String publisherName;
	private String title;
	private int price;
	private String description;
	
	public String getId() {
		return publisherId;
	}
	public void setId(String _id) {
		this.publisherId = _id;
	}
	
	public String getName() {
		return publisherName;
	}
	public void setName(String _name) {
		this.publisherName = _name;
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
}
