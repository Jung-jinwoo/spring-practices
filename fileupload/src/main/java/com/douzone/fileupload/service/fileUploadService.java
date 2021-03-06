package com.douzone.fileupload.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class fileUploadService {

	private static String SAVE_PATH = "/upload-images";
	private static String URL_BASE = "/images";
	
	public String restore(MultipartFile multipartFile) throws Exception {
		String url = null;
		
		try {
			
			if (multipartFile.isEmpty()) {
				return url;
			}
			
			String originFilename = multipartFile.getOriginalFilename();
			String extName = originFilename.substring(originFilename.lastIndexOf('.') + 1);
			String saveFilename = generateSaveFilename(extName);
			long fileSize = multipartFile.getSize();

			System.out.println("##############" + originFilename);
			System.out.println("##############" + fileSize);
			System.out.println("##############" + saveFilename);

			byte[] data = multipartFile.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
			os.write(data);
			os.close();
			
			url = URL_BASE + "/" + saveFilename;
			System.out.println(url);
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException("file upload error:" + e);
		}

		return url;
	}

	private String generateSaveFilename(String extName) {
		String filename = "";

		Calendar calendar = Calendar.getInstance();
		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += "." + extName;

		return filename;
	}
}
