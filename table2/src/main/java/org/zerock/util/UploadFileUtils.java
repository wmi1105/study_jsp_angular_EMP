package org.zerock.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);
	
	public static String uploadFile(String uploadPath, 
            String originalName, 
            byte[] fileData)throws Exception{

		UUID uid = UUID.randomUUID();
		
		String savedName = uid.toString() +"_"+originalName;
		
		String savedPath = calcPath(uploadPath); //저장될 경로 계산
		
		File target = new File(uploadPath +savedPath,savedName);
		
		FileCopyUtils.copy(fileData, target); //원본 파일을 저장하는 부분
		
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		
		String uploadedFileName = null;
		
		if(MediaUtils.getMediaType(formatName) != null){
		uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
		}else{
		uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		
		return uploadedFileName;
		
	}

	private static  String makeIcon(String uploadPath, 
		String path, 
		String fileName)throws Exception{
		
		String iconName = 
		uploadPath + path + File.separator+ fileName;
		
		return iconName.substring(
		uploadPath.length()).replace(File.separatorChar, '/');
	}
	
	
	//폴더의 생성 부분
	 private static String calcPath(String uploadPath){
		    
		    Calendar cal = Calendar.getInstance();
		    
		    String yearPath = File.separator+cal.get(Calendar.YEAR);
		    
		    String monthPath = yearPath + 
		        File.separator + 
		        new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);

		    String datePath = monthPath + 
		        File.separator + 
		        new DecimalFormat("00").format(cal.get(Calendar.DATE));
		    
		    makeDir(uploadPath, yearPath,monthPath,datePath);
		    
		    logger.info(datePath);
		    
		    return datePath;
		  }
	 private static void makeDir(String uploadPath, String... paths){
		    
		    if(new File(paths[paths.length-1]).exists()){
		      return;
		    }
		    
		    for (String path : paths) {
		      
		      File dirPath = new File(uploadPath + path);
		      
		      if(! dirPath.exists() ){
		        dirPath.mkdir();
		      } 
		    }
	 }
	 
	 //썸네일 이미지 생성
	 private static  String makeThumbnail(
             String uploadPath, 
             String path, 
             String fileName)throws Exception{
        
		 //메모리상의 이미지 객체
   BufferedImage sourceImg = 
       ImageIO.read(new File(uploadPath + path, fileName));
   
   BufferedImage destImg = 
       Scalr.resize(sourceImg, 
           Scalr.Method.AUTOMATIC, 
           Scalr.Mode.FIT_TO_HEIGHT,100);
   
   String thumbnailName = 
       uploadPath + path + File.separator +"s_"+ fileName; //원본 이미지와 구별하기 위해 s_
   
   File newFile = new File(thumbnailName);
   String formatName = 
       fileName.substring(fileName.lastIndexOf(".")+1);
   
   
   ImageIO.write(destImg, formatName.toUpperCase(), newFile);
   return thumbnailName.substring(
       uploadPath.length()).replace(File.separatorChar, '/');
 } 
		  
}
