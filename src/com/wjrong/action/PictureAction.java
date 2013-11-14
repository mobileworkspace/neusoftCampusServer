package com.wjrong.action;
import java.io.File;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wjrong.model.Picture;
import com.wjrong.model.PhotoFile;
import com.wjrong.service.PictureService;
import com.wjrong.util.ActionUtil;

/**
 * 图片(后台)
 * @author wjrong
 * @data 2013-10-20
 *
 */
@SuppressWarnings("serial")
@Controller("pictureAction")
@Scope("prototype")
public class PictureAction extends ActionSupport implements ModelDriven<Picture> {
	private Picture picture;
	private PictureService pictureService;
	private Integer[] delid;	//一组id
	private PhotoFile photoFile;	//上传类
	private String photoNoDelete;	//从服务器传来判断是否删除了图片
	
	/**
	 * 分页查询
	 */
	public String list(){
		ActionContext.getContext().put("pages", this.pictureService.findPicture());
		return SUCCESS;
	}

	/**
	 * 分类分页查询
	 */
	public String listCid(){
		String cid=picture.getCategoryid();
		ActionContext.getContext().put("pages", this.pictureService.findPicture(cid));
		int i=Integer.valueOf(cid).intValue();
		if(i==1){
			return "Categoryid01";
		}else if(i==2){
			return "Categoryid02";
		}else{
			return SUCCESS;
		}
		
	}
	
	/**
	 * 进入添加页面
	 */
	public String addInput(){
		return SUCCESS;
	}
	
	/**
	 *	添加图片
	 */
	public String add(){
		if(photoFile == null){
			this.pictureService.add(picture);
			ActionUtil.setURL("picture_list.action");
			return ActionUtil.REDIRECT;
		}
		Calendar calendar = Calendar.getInstance();
		String timestamp = calendar.get(Calendar.YEAR) + "/" + calendar.get(Calendar.MONTH);
		
		String uploadUrl2="uploadFile/picture/" + "upload/" + timestamp+"/";
		String uploadUrl = ServletActionContext.getServletContext().getRealPath("/") + uploadUrl2;
		
		File fl=new File(uploadUrl);
		if(!fl.exists()){
			//如果没有目录就建目录
			fl.mkdirs();
		}
		this.pictureService.add(picture, photoFile, uploadUrl,uploadUrl2);
		ActionUtil.setURL("picture_list.action");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 *	添加内容图片
	 */
	public String addimg(){

		if(photoFile==null){
			System.out.print("没有图片内容！");
		}else {
			
		
		Calendar calendar = Calendar.getInstance();
		String timestamp = calendar.get(Calendar.YEAR) + "/" + calendar.get(Calendar.MONTH);
		
		String uploadUrl2="uploadFile/picture/" + "upload/" + timestamp+"/";
		String uploadUrl = ServletActionContext.getServletContext().getRealPath("/") + uploadUrl2;
		
		File fl=new File(uploadUrl);
			if(!fl.exists()){
				//如果没有目录就建目录
				fl.mkdirs();
			}
		this.pictureService.addimg(photoFile, uploadUrl);
		}
		ActionUtil.setURL(null);
		return ActionUtil.REDIRECT;
		
	}

	
	/**
	 * 删除图片
	 */
	public String delete(){
		this.pictureService.delete(picture.getId());
		ActionUtil.setURL("picture_list.action");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 * 删除一条数据
	 */
	public String checkboxDelete(){
		this.pictureService.deleteGroupPicture(delid);
		ActionUtil.setURL("picture_list.action");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 * 进入修改页面
	 */
	public String updateInput(){
		Picture n = this.pictureService.load(picture.getId());
		picture.setId(n.getId());
		picture.setTitle(n.getTitle());
		picture.setAuthor(n.getAuthor());
		picture.setTpicture(n.getTpicture());
		return SUCCESS;
	}
	
	/**
	 * 修改图片
	 */
	public String update(){
		Picture n = new Picture();
		n.setId(picture.getId());
		n.setTitle(picture.getTitle());
		n.setAuthor(picture.getAuthor());
		n.setTtop(picture.getTtop());
		n.setCategoryid(picture.getCategoryid());
		n.setCreateDate(new Date());
		if(photoFile == null){
			if(photoNoDelete.length()  >1){
				n.setTpicture(photoNoDelete);
			}
			this.pictureService.update(n);
			ActionUtil.setURL("picture_list.action");
			return ActionUtil.REDIRECT;
		}
		Calendar calendar = Calendar.getInstance();
		String timestamp = calendar.get(Calendar.YEAR) + "/" + calendar.get(Calendar.MONTH);
		
		String uploadUrl2="uploadFile/picture/" + "upload/" + timestamp+"/";
		String uploadUrl = ServletActionContext.getServletContext().getRealPath("/") + uploadUrl2;
		
		File fl=new File(uploadUrl);
		if(!fl.exists()){
			//如果没有目录就建目录
			fl.mkdirs();
		}
		this.pictureService.update(n, photoFile, uploadUrl,uploadUrl2);
		ActionUtil.setURL("picture_list.action");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 * 查看某个信息
	 */
	public String check(){
		Picture n = this.pictureService.load(picture.getId());
		picture.setId(n.getId());
		picture.setTitle(n.getTitle());
		picture.setCreateDate(n.getCreateDate());
		picture.setTpicture(n.getTpicture());
		picture.setAuthor(n.getAuthor());
		picture.setCategoryid(n.getCategoryid());
		picture.setTtop(n.getTtop());
		
		return SUCCESS;
	}
	
	
	
	
	
	@Override
	public Picture getModel() {
		if(picture == null) picture = new Picture();
		return picture;
	}
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	public PictureService getPictureService() {
		return pictureService;
	}
	@Resource
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}
	public Integer[] getDelid() {
		return delid;
	}
	public void setDelid(Integer[] delid) {
		this.delid = delid;
	}
	public PhotoFile getPhotoFile() {
		return photoFile;
	}
	public void setPhotoFile(PhotoFile photoFile) {
		this.photoFile = photoFile;
	}
	public String getPhotoNoDelete() {
		return photoNoDelete;
	}
	public void setPhotoNoDelete(String photoNoDelete) {
		this.photoNoDelete = photoNoDelete;
	}
}
