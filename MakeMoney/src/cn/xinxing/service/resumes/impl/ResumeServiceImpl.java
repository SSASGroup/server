package cn.xinxing.service.resumes.impl;
import java.util.List;

import cn.xinxing.business.ResumeBusiness;
import cn.xinxing.model.Resumes;
import cn.xinxing.service.resumes.ResumeService;



public class ResumeServiceImpl implements ResumeService{
	@Override

	public List<Resumes> getAllResumes() {
		// TODO Auto-generated method stub
		return ResumeBusiness.getAllResumes();
	}
	
	public void addResume(String id, String name, String title, String price, String description) {
		ResumeBusiness.addResume(id, name, title, price, description);
	}
	
	public Resumes getResumeInfo(String id, String title) {
		return ResumeBusiness.getResumeInfo(id, title);
	}
}
