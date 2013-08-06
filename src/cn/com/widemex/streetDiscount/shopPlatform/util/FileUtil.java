package cn.com.widemex.streetDiscount.shopPlatform.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import cn.com.widemex.framework.logging.WideLogger;

@Component
public class FileUtil {

	private static final WideLogger logger = WideLogger.getLogger(FileUtil.class);
	
	
	public String  writeTempleFile(MultipartFile file, String appRootPath){
					
		logger.info(appRootPath);
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		
		String fileName = file.getOriginalFilename();
		
		String fileExt = "";
		
		if (fileName.indexOf(".") != -1){
			fileExt = fileName.substring(fileName.indexOf("."));
		}	
		
		String relativePath = this.generatePicDic() + uuid + fileExt.toLowerCase();
		
		if(!appRootPath.endsWith(File.separator)){
			appRootPath += File.separator;
		}
		
		String targetPath = this.generateFullPath(appRootPath, relativePath); 
		logger.info(targetPath);
		
		File tempFile = new File(targetPath);
		if (!tempFile.exists()) {
			tempFile.getParentFile().mkdirs();
		}
		try {
			file.transferTo(tempFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			logger.error("", e);
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("", e);
			return null;
		}
		
		return relativePath.replaceAll("\\\\", "/");
		
		
	}
	
	
	public String generateFullPath(String appRootPath, String relativePath){
		if("\\".equals(File.separator)){
			relativePath = relativePath.replaceAll("/", "\\\\");
		}
		return appRootPath + "upload" + File.separator + relativePath; 
	}
	
	
	private String generatePicDic(){
		
		String current = String.valueOf(System.currentTimeMillis());
		String url = "";
		while(current.length() > 3){
			if(current.length() <= 4){
				break;
			}
			url += current.substring(0, 3);
			url += File.separator;
			current = current.substring(3);
		}
		return url;	
	}
	
	
}
