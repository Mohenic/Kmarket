package kr.co.kmarket.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public enum FileService {

	instance;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// File 관련
	
	public String getPath(HttpServletRequest req, String dir) {
		// 파일 업로드 경로 구하기 
		ServletContext ctx = req.getServletContext();
		String path = ctx.getRealPath(dir);
		return path;
	}
	
	public String getFilePath(HttpServletRequest req) {
		
		ServletContext ctx = req.getServletContext();
		String path = ctx.getRealPath("/thumb");
		return path;
	}
	
	public String renameToFile(HttpServletRequest req, String oName) {
		
		String path = getFilePath(req);
		
		int i = oName.lastIndexOf(".");
		String ext = oName.substring(i);
		
		String uuid = UUID.randomUUID().toString();
		String sName = uuid + ext;
		
		File f1 = new File(path+"/"+oName);
		File f2 = new File(path+"/"+sName);
		
		f1.renameTo(f2);
		
		return sName;
	}
	
	public MultipartRequest uploadFile(HttpServletRequest req) {
		
		String path = getFilePath(req);
		
		int maxSize = 1024 * 1024 * 10;
		
		MultipartRequest mr = null;
		
		try {
			
			mr = new MultipartRequest(req, path , maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
		} catch (Exception e) {
			logger.error("uploadFile : " + e.getMessage());
		}
		return mr;
	}
	
	public MultipartRequest uploadFile(HttpServletRequest req, String path) {
		// 최대 업로드 파일 크기
		int maxSize = 1024 * 1024 * 10;
		
		// 파일 업로드 및 Multipart 객체 생성
		MultipartRequest mr = null;
		
		try {
			mr = new MultipartRequest(req, 
									  path, 
									  maxSize, 
									  "UTF-8", 
									  new DefaultFileRenamePolicy());
		} catch (IOException e) {
			logger.error("uploadFile : " + e.getMessage());
		}
		
		return mr;
	}
}
