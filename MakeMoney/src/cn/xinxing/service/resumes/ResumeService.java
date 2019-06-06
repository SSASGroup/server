package cn.xinxing.service.resumes;

import java.util.List;

import cn.xinxing.model.Resumes;


/**
 * 
 */
public interface ResumeService {
	public List<Resumes> getAllResumes();
	public void addResume(String id, String name, String title, String price, String description);
	public Resumes getResumeInfo(String id, String title);
}
