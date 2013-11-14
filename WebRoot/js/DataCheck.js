//check名字
function c_name(){
	var name=$("#name").val();
	var s_name=$("#s_name");
	if(name==""){
		s_name.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">必填！</font>");
	
	}else{
		s_name.html("<img src=\"./admin/images/right.png \" />");
		
	}
}
//check职业
function c_profession(){
	var profession=$("#profession").val();
	var s_profession=$("#s_profession");
	if(profession==""){
		s_profession.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">必填！</font>");
	
	}else{
		s_profession.html("<img src=\"./admin/images/right.png \" />");
		
	}
}
//check手机
function c_phone(){
	var phone=$("#phone").val();
	var s_phone=$("#s_phone");
	var Cphone =/^((1[3-8][0-9]{1})|159|153)+\d{8}$/;
	if(phone==""){
		s_phone.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">必填！</font>");
	
	}else if(!Cphone.test(phone)){
		s_phone.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">请填写正确的手机号码！</font>");
		
	}else{
		s_phone.html("<img src=\"./admin/images/right.png \" />");
		
	}
}
//check邮箱
function c_email(){
	var email=$("#email").val();
	var s_email=$("#s_email");
	var iscemail =/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	if(email==""){
		s_email.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">必填！</font>");
	
	}else if(!iscemail.test(email)){
		s_email.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">请填写正确的邮箱号！</font>");
		
	}else{
		s_email.html("<img src=\"./admin/images/right.png \" />");
		
	}
}
//checkQQ
function c_QQ(){
	var QQ=$("#QQ").val();
	var s_QQ=$("#s_QQ");
	if(QQ==""){
		s_QQ.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">必填！</font>");
	
	}else if(isNaN(QQ)){
		s_QQ.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">请填写数字！</font>");
		
	}else{
		s_QQ.html("<img src=\"./admin/images/right.png \" />");
		
	}
}
//check留言
function c_content(){
	var content=$("#content").val();
	var s_content=$("#s_content");
	if(content==""){
		s_content.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">必填！</font>");
	
	}else{
		s_content.html("<img src=\"./admin/images/right.png \" />");
		
	}
}
