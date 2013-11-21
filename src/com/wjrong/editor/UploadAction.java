package com.wjrong.editor;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 * @author wjrong
 * 后台处理上传图片
 *
 */
@SuppressWarnings("serial")
public class UploadAction extends BaseAction{
	private File imgFile;
	

	
	public void uploadImg(){
		try {
			Calendar calendar = Calendar.getInstance();
			String timestamp = calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH)+1);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmss");
			Random r=new Random();
			String path=ServletActionContext.getServletContext().getRealPath("/");
			String uploadUrl=path+"uploadFile/article/ContentPhoto/" + timestamp+"/";
			String imgName="CU"+sdf.format(new Date())+r.nextInt(100)+".jpg";
		
			File fl=new File(uploadUrl);
			if(!fl.exists()){
				//如果没有目录就建目录
				fl.mkdirs();
			}
			
			FileUtils.copyFile(imgFile,new File(uploadUrl+imgName));
			
			//向kindeditor返回json格式图片路径
			String outPath=ServletActionContext.getRequest().getScheme()+"://"+ServletActionContext.getRequest().getServerName()+":"+ServletActionContext.getRequest().getServerPort()+ServletActionContext.getRequest().getContextPath()+"/";
			//String outPath=path;
			System.out.println(outPath);
			String outImageName=outPath+"uploadFile/article/ContentPhoto/" + timestamp+"/"+imgName;
			String returnUrl="{\"error\":0,\"url\":\""+outImageName+"\"}";
			System.out.println(returnUrl);
			ServletActionContext.getResponse().getWriter().print(returnUrl);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public File getImgFile() {
		return imgFile;
	}
	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}
	
}
