package com.wjrong.action;
import java.io.File;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.If;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wjrong.model.Article;
import com.wjrong.model.PhotoFile;
import com.wjrong.service.ArticleService;
import com.wjrong.util.ActionUtil;

/**
 * 文章(后台)
 * @author wjrong
 * @data 2013-10-20
 *
 */
@SuppressWarnings("serial")
@Controller("articleAction")
@Scope("prototype")
public class ArticleAction extends ActionSupport implements ModelDriven<Article> {
	private Article article;
	private ArticleService articleService;
	private Integer[] delid;	//一组id
	private PhotoFile photoFile;	//上传类
	private String photoNoDelete;	//从服务器传来判断是否删除了图片
	private String uploadCategoryName;   //存放图片的路径目录
	


	
	/**
	 * 分页查询
	 */
	public String list(){
		ActionContext.getContext().put("pages", this.articleService.findArticle());
		return SUCCESS;
	}
	
	/**
	 * 分类分页查询
	 */
	public String listCid(){
		String cid=article.getCategoryid();
		ActionContext.getContext().put("pages", this.articleService.findArticle(cid));
		int i=Integer.valueOf(cid).intValue();
		if(i==1){
			return "Categoryid01";
		}else if(i==2){
			return "Categoryid02";
		}else if(i==3){
			return "Categoryid03";
		}else if(i==4){
			return "Categoryid04";
		}else if(i==5){
			return "Categoryid05";
		}else if(i==6){
			return "Categoryid06";
		}else if(i==7){
			return "Categoryid07";
		}else if(i==8){
			return "Categoryid08";
		}else if(i==9){
			return "Categoryid09";
		}else if(i==10){
			return "Categoryid10";
		}else if(i==11){
			return "Categoryid11";
		}else if(i==12){
			return "Categoryid12";
		}else{
			return SUCCESS;
		}
		
	}
	
	
	/**
	 * 分类1分页查询
	 */
	public String listCid1(){

		ActionContext.getContext().put("pages", this.articleService.findArticle("1"));
		
			return "Categoryid01";
		}
	
	
	/**
	 * 分类2分页查询
	 */
	public String listCid2(){

		ActionContext.getContext().put("pages", this.articleService.findArticle("2"));
		
			return "Categoryid02";
		}
	
	
	/**
	 * 分类3分页查询
	 */
	public String listCid3(){

		ActionContext.getContext().put("pages", this.articleService.findArticle("3"));
		
			return "Categoryid03";
		}
	
	/**
	 * 分类4分页查询
	 */
	public String listCid4(){

		ActionContext.getContext().put("pages", this.articleService.findArticle("4"));
		
			return "Categoryid04";
		}
	
	/**
	 * 分类5分页查询
	 */
	public String listCid5(){

		ActionContext.getContext().put("pages", this.articleService.findArticle("5"));
		
			return "Categoryid05";
		}
	
	/**
	 * 分类6分页查询
	 */
	public String listCid6(){

		ActionContext.getContext().put("pages", this.articleService.findArticle("6"));
		
			return "Categoryid06";
		}
	
	/**
	 * 分类7分页查询
	 */
	public String listCid7(){

		ActionContext.getContext().put("pages", this.articleService.findArticle("7"));
		
			return "Categoryid07";
		}
	
	/**
	 * 分类8分页查询
	 */
	public String listCid8(){

		ActionContext.getContext().put("pages", this.articleService.findArticle("8"));
		
			return "Categoryid08";
		}
	
	/**
	 * 分类9分页查询
	 */
	public String listCid9(){

		ActionContext.getContext().put("pages", this.articleService.findArticle("9"));
		
			return "Categoryid09";
		}
	
	/**
	 * 分类10分页查询
	 */
	public String listCid10(){

		ActionContext.getContext().put("pages", this.articleService.findArticle("10"));
		
			return "Categoryid10";
		}

	/**
	 * 分类11分页查询
	 */
	public String listCid11(){

		ActionContext.getContext().put("pages", this.articleService.findArticle("11"));
		
			return "Categoryid11";
		}
	
	/**
	 * 分类12分页查询
	 */
	public String listCid12(){

		ActionContext.getContext().put("pages", this.articleService.findArticle("12"));
		
			return "Categoryid12";
		}
	
	/**
	 * 分页查询全部有图文章
	 */
	public String showlist(){
		ActionContext.getContext().put("pages", this.articleService.findArticlePictureNoNull("All"));
		return SUCCESS;
	}
		
	/**
	 * 分类分页查询有图文章
	 */
	public String showlistCid(){
		String cid=article.getCategoryid();
		ActionContext.getContext().put("pages", this.articleService.findArticlePictureNoNull(cid));
		int i=Integer.valueOf(cid).intValue();
		if(i==1){
			return "showCategoryid01";
		}else if(i==2){
			return "showCategoryid02";
		}else if(i==3){
			return "showCategoryid03";
		}else if(i==4){
			return "showCategoryid04";
		}else if(i==5){
			return "showCategoryid05";
		}else if(i==6){
			return "showCategoryid06";
		}else if(i==7){
			return "showCategoryid07";
		}else if(i==8){
			return "showCategoryid08";
		}else if(i==9){
			return "showCategoryid09";
		}else if(i==10){
			return "showCategoryid10";
		}else if(i==11){
			return "showCategoryid11";
		}else if(i==12){
			return "showCategoryid12";
		}else if(i==13){
			return SUCCESS;
		}
		return SUCCESS;
	}
	
	/**
	 * 分类1分页查询有图文章
	 */
	public String showlistCid1(){
		ActionContext.getContext().put("pages", this.articleService.findArticlePictureNoNull("1"));
		return "showCategoryid01";
	}
	
	/**
	 * 分类2分页查询有图文章
	 */
	public String showlistCid2(){
		ActionContext.getContext().put("pages", this.articleService.findArticlePictureNoNull("2"));
		return "showCategoryid02";
	}
	
	/**
	 * 分类3分页查询有图文章
	 */
	public String showlistCid3(){
		ActionContext.getContext().put("pages", this.articleService.findArticlePictureNoNull("3"));
		return "showCategoryid03";
	}
	
	/**
	 * 分类4分页查询有图文章
	 */
	public String showlistCid4(){
		ActionContext.getContext().put("pages", this.articleService.findArticlePictureNoNull("4"));
		return "showCategoryid04";
	}
	
	/**
	 * 分类5分页查询有图文章
	 */
	public String showlistCid5(){
		ActionContext.getContext().put("pages", this.articleService.findArticlePictureNoNull("5"));
		return "showCategoryid05";
	}
	
	/**
	 * 分类6分页查询有图文章
	 */
	public String showlistCid6(){
		ActionContext.getContext().put("pages", this.articleService.findArticlePictureNoNull("6"));
		return "showCategoryid06";
	}
	
	/**
	 * 分类7分页查询有图文章
	 */
	public String showlistCid7(){
		ActionContext.getContext().put("pages", this.articleService.findArticlePictureNoNull("7"));
		return "showCategoryid0";
	}
	
	/**
	 * 分类8分页查询有图文章
	 */
	public String showlistCid8(){
		ActionContext.getContext().put("pages", this.articleService.findArticlePictureNoNull("8"));
		return "showCategoryid08";
	}
	
	/**
	 * 分类9分页查询有图文章
	 */
	public String showlistCid9(){
		ActionContext.getContext().put("pages", this.articleService.findArticlePictureNoNull("9"));
		return "showCategoryid09";
	}
	
	/**
	 * 分类10分页查询有图文章
	 */
	public String showlistCid10(){
		ActionContext.getContext().put("pages", this.articleService.findArticlePictureNoNull("10"));
		return "showCategoryid10";
	}
	
	/**
	 * 分类11分页查询有图文章
	 */
	public String showlistCid11(){
		ActionContext.getContext().put("pages", this.articleService.findArticlePictureNoNull("11"));
		return "showCategoryid11";
	}
	
	
	/**
	 * 分类12分页查询有图文章
	 */
	public String showlistCid12(){
		ActionContext.getContext().put("pages", this.articleService.findArticlePictureNoNull("12"));
		return "showCategoryid12";
	}
	
	/**
	 * 进入添加页面
	 */
	public String addInput(){
		return SUCCESS;
	}
	
	/**
	 *	添加文章
	 */
	public String add(){
		if(photoFile == null){
			this.articleService.add(article);
			ActionUtil.setURL("article_list.action");
			return ActionUtil.REDIRECT;
		}
		
		String cid=article.getCategoryid();
			int i=Integer.valueOf(cid).intValue();
			if(i==1){
				uploadCategoryName="Category1";
			}else if(i==2){
				uploadCategoryName="Category2";
			}else if(i==3){
				uploadCategoryName="Category3";
			}else if(i==4){
				uploadCategoryName="Category4";
			}else if(i==5){
				uploadCategoryName="Category5";
			}else if(i==6){
				uploadCategoryName="Category6";
			}else if(i==7){
				uploadCategoryName="Category7";
			}else if(i==8){
				uploadCategoryName="Category8";
			}else if(i==9){
				uploadCategoryName="Category9";
			}else if(i==10){
				uploadCategoryName="Category10";
			}else if(i==11){
				uploadCategoryName="Category11";
			}else if(i==12){
				uploadCategoryName="Category12";
			}else{
				uploadCategoryName="upload";
			}
		
		Calendar calendar = Calendar.getInstance();
		String timestamp = calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH)+1);
		
		String uploadUrl2="uploadFile/article/" +uploadCategoryName+ "/" + timestamp+"/";
		String uploadUrl = ServletActionContext.getServletContext().getRealPath("/") + uploadUrl2;
		
		File fl=new File(uploadUrl);
		if(!fl.exists()){
			//如果没有目录就建目录
			fl.mkdirs();
		}
		this.articleService.add(article, photoFile, uploadUrl,uploadUrl2);
		ActionUtil.setURL("article_list.action");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 * 删除文章
	 */
	public String delete(){
		this.articleService.delete(article.getId());
		ActionUtil.setURL("article_list.action");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 * 删除一直数据
	 */
	public String checkboxDelete(){
		this.articleService.deleteGroupArticle(delid);
		ActionUtil.setURL("article_list.action");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 * 进入修改页面
	 */
	public String updateInput(){
		Article n = this.articleService.load(article.getId());
		article.setId(n.getId());
		article.setTitle(n.getTitle());
		article.setAuthor(n.getAuthor());
		article.setContent(n.getContent());
		article.setTpicture(n.getTpicture());
		article.setIntro(n.getIntro());
		article.setCategoryid(n.getCategoryid());
		article.setTtop(n.getTtop());
		
		return SUCCESS;
	}
	
	/**
	 * 修改文章
	 */
	public String update(){
		Article n = new Article();
		n.setId(article.getId());
		n.setTitle(article.getTitle());
		n.setAuthor(article.getAuthor());
		n.setTtop(article.getTtop());
		n.setCategoryid(article.getCategoryid());
		n.setContent(article.getContent());
		n.setIntro(article.getIntro());
		n.setCreateDate(new Date());
		if(photoFile == null){
			if(photoNoDelete.length()  >1){
				n.setTpicture(photoNoDelete);
			}
			this.articleService.update(n);
			ActionUtil.setURL("article_list.action");
			return ActionUtil.REDIRECT;
		}
		
		
		String cid=article.getCategoryid();
		int i=Integer.valueOf(cid).intValue();
		if(i==1){
			uploadCategoryName="Category1";
		}else if(i==2){
			uploadCategoryName="Category2";
		}else if(i==3){
			uploadCategoryName="Category3";
		}else if(i==4){
			uploadCategoryName="Category4";
		}else if(i==5){
			uploadCategoryName="Category5";
		}else if(i==6){
			uploadCategoryName="Category6";
		}else if(i==7){
			uploadCategoryName="Category7";
		}else if(i==8){
			uploadCategoryName="Category8";
		}else if(i==9){
			uploadCategoryName="Category9";
		}else if(i==10){
			uploadCategoryName="Category10";
		}else if(i==11){
			uploadCategoryName="Category11";
		}else if(i==12){
			uploadCategoryName="Category12";
		}else{
			uploadCategoryName="upload";
		}
		
		/*
		if(i==1){
			uploadCategoryName="新闻联播";
		}else if(i==2){
			uploadCategoryName="图片联播";
		}else if(i==3){
			uploadCategoryName="校园服务";
		}else if(i==4){
			uploadCategoryName="奖学金";
		}else if(i==5){
			uploadCategoryName="就业服务";
		}else if(i==6){
			uploadCategoryName="媒体聚焦";
		}else if(i==7){
			uploadCategoryName="科研团队";
		}else if(i==8){
			uploadCategoryName="职位空缺";
		}else if(i==9){
			uploadCategoryName="校企合作";
		}else if(i==10){
			uploadCategoryName="科研成果";
		}else if(i==11){
			uploadCategoryName="集团快讯";
		}else if(i==12){
			uploadCategoryName="专业介绍";
		}else{
			uploadCategoryName="upload";
		}
		*/
		

		Calendar calendar = Calendar.getInstance();
		String timestamp = calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH)+1);
		
		String uploadUrl2="uploadFile/article/" + uploadCategoryName + "/" + timestamp+"/";
		String uploadUrl = ServletActionContext.getServletContext().getRealPath("/") + uploadUrl2;
		
		File fl=new File(uploadUrl);
		if(!fl.exists()){
			//如果没有目录就建目录
			fl.mkdirs();
		}
		this.articleService.update(n, photoFile, uploadUrl,uploadUrl2);
		ActionUtil.setURL("article_list.action");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 * 查看某个信息
	 */
	public String check(){
		Article n = this.articleService.load(article.getId());
		article.setId(n.getId());
		article.setTitle(n.getTitle());
		article.setContent(n.getContent());
		article.setCreateDate(n.getCreateDate());
		article.setTpicture(n.getTpicture());
		article.setAuthor(n.getAuthor());
		article.setCategoryid(n.getCategoryid());
		article.setTtop(n.getTtop());
		article.setIntro(n.getIntro());
		article.setClickRate(n.getClickRate());

		
		return SUCCESS;
	}
	
	
	
	
	
	@Override
	public Article getModel() {
		if(article == null) article = new Article();
		return article;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	@Resource
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
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
