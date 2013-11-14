package com.wjrong.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 品酒会
 * @author hugo
 *
 */
@Entity
@Table(name="t_tasting")
public class Tasting {
	private int id;
	private String picture;	//图片
	private String title;	//标题
	private String time;	//时间
	private String place;	//地点
	private String price;	//价格
	private String type;	//类型
	private String person;	//人数
	private String content;	//活动介绍
	private Date createDate;	//创建时间
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	@Column(name="content",columnDefinition="text")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name="create_date")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	//	以下是构造方法
	public Tasting() {
	}
	public Tasting(String title, String time, String place, String price, 
			String type, String person, String content) {
		this.title = title;
		this.time = time;
		this.place = place;
		this.price = price;
		this.type = type;
		this.person = person;
		this.content = content;
	}
}
