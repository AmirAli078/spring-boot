package com.demo.services.impli;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.services.FileService;
@Service
public class FileServiceImpli implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		//File name 
		String name=file.getOriginalFilename();
		
		
		//random name generate file 
		String randomID=UUID.randomUUID().toString();
		String fileName1=randomID.concat(name.substring(name.lastIndexOf(".")));
		
		// full path
		String filePath=path+File.separator+fileName1;
		
		//create folder if not exist 
		
		File f=new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		//file copy 
		Files.copy(file.getInputStream(), Paths.get(filePath));
		return fileName1;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath=path+File.separator+fileName;
		InputStream is=new FileInputStream(fullPath);
		return is;
	}

}
