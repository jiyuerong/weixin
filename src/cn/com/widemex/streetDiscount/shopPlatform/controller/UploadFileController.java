package cn.com.widemex.streetDiscount.shopPlatform.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.com.widemex.streetDiscount.shopPlatform.util.FileUtil;

@Controller
@RequestMapping(value = "/upload")
public class UploadFileController extends BaseController {

	@Autowired
	private FileUtil fileUtil;


	@RequestMapping(value = "file.do")
	@ResponseBody
	public String uploadPhoto(MultipartFile file, HttpServletRequest request,
			Model model) {
		
		String filePath = fileUtil.writeTempleFile(file, request.getSession()
				.getServletContext().getRealPath("/"));
		return request.getContextPath() + "/upload/" + filePath;

	}

}
