function formcheck(){
	flag=true;
	var name=$("#name").val();
	var s_name=$("#s_name");
	var profession=$("#profession").val();
	var s_profession=$("#s_profession");
	var phone=$("#phone").val();
	var s_phone=$("#s_phone");
	var email=$("#email").val();
	var s_email=$("#s_email");
	var QQ=$("#QQ").val();
	var s_QQ=$("#s_QQ");
	var content=$("#content").val();
	var s_content=$("#s_content");
	var Cphone =/^((1[3-8][0-9]{1})|159|153)+\d{8}$/;
	var iscemail =/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	
	//名字
	if(name==""){
		s_name.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">必填！</font>");
		return false;
	}else{
		s_name.html("<img src=\"./admin/images/right.png \" />");
	} 
	//职业
	if(profession==""){
		s_profession.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">必填！</font>");
		return false;
	}else{
		s_profession.html("<img src=\"./admin/images/right.png \" />");
	}
	//手机
	if(phone==""){
		s_phone.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">必填！</font>");
		return false;
	}else if(!Cphone.test(phone)){
		s_phone.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">请填写正确的手机号码！</font>");
		return false;
	}else{
		s_phone.html("<img src=\"./admin/images/right.png \" />");
	}
	//邮箱
	if(email==""){
		s_email.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">必填！</font>");
		return false;
	}else if(!iscemail.test(email)){
		s_email.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">请填写正确的邮箱号！</font>");
		return false;
	}else{
		s_email.html("<img src=\"./admin/images/right.png \" />");
	}
	//QQ
	if(QQ==""){
		s_QQ.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">必填！</font>");
		return false;
	}else if(isNaN(QQ)){
		s_QQ.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">请填写数字！</font>");
		return false;
	}else{
		s_QQ.html("<img src=\"./admin/images/right.png \" />");
	}
	//留言
	if(content==""){
		s_content.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">必填！</font>");
		return false;
	}else{
		s_content.html("<img src=\"./admin/images/right.png \" />");
	}
	
	return flag;
}
