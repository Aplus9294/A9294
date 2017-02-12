<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册表单</title>
<link media="all" href="reset.css" type="text/css" rel="stylesheet">
<style type="text/css">BODY {
	FONT-SIZE: 12px; BACKGROUND: #fff; COLOR: #000; LINE-HEIGHT: 1.25; FONT-FAMILY: "Times New Roman", Times, serif; TEXT-ALIGN: center
}
H1 {
	FONT-WEIGHT: bold; FONT-SIZE: 14px; LINE-HEIGHT: 2em
}
FORM {
	PADDING-RIGHT: 4px; PADDING-LEFT: 4px; BACKGROUND: #9cbc2c; PADDING-BOTTOM: 4px; MARGIN: 0px auto; WIDTH: 500px; PADDING-TOP: 4px; border-radius: 5px; moz-border-radius: 5px; webkit-border-radius: 5px; khtml-border-radius: 5px; moz-box-shadow: 0 0 4px rgba(0,0,0,0.4); webkit-box-shadow: 0 0 4px rgba(0,0,0,0.4); box-shadow: 0 0 4px rgba(0,0,0,0.4)
}
FIELDSET {
	PADDING-RIGHT: 40px; PADDING-LEFT: 0px; PADDING-BOTTOM: 5px; BORDER-TOP-STYLE: none; PADDING-TOP: 10px; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: none
}
#regForm OL LI {
	CLEAR: both; BORDER-RIGHT: #f7f7f7 1px solid; PADDING-RIGHT: 10px; BORDER-TOP: #f7f7f7 1px solid; PADDING-LEFT: 10px; BACKGROUND: white; MARGIN-BOTTOM: 12px; PADDING-BOTTOM: 5px; BORDER-LEFT: #f7f7f7 1px solid; LINE-HEIGHT: 30px; PADDING-TOP: 5px; BORDER-BOTTOM: #f7f7f7 1px solid; POSITION: relative; border-radius: 5px; moz-border-radius: 5px; webkit-border-radius: 5px; khtml-border-radius: 5px
}
UNKNOWN {
	BORDER-RIGHT: #999 1px solid; PADDING-RIGHT: 5px; BORDER-TOP: #999 1px solid; PADDING-LEFT: 5px; PADDING-BOTTOM: 5px; BORDER-LEFT: #999 1px solid; WIDTH: 200px; PADDING-TOP: 5px; BORDER-BOTTOM: #999 1px solid; border-radius: 3px; moz-border-radius: 3px
	background:#fff; webkit-border-radius: 3px; khtml-border-radius: 3px; outline: medium none
}
#regForm OL LI:hover {
	BORDER-LEFT-COLOR: #9cbc2c; BACKGROUND: #f7f7f7; BORDER-BOTTOM-COLOR: #9cbc2c; BORDER-TOP-COLOR: #9cbc2c; BORDER-RIGHT-COLOR: #9cbc2c
}
#regForm LABEL {
	FLOAT: left; FONT: 13px/30px Georgia,"Times New Roman",Times,serif; WIDTH: 120px
}
#regForm BUTTON {
	PADDING-RIGHT: 15px; PADDING-LEFT: 15px; BACKGROUND: #384313; PADDING-BOTTOM: 4px; MARGIN: auto; FONT: 14px Georgia, "Times New Roman", Times, serif; COLOR: #ffffff; BORDER-TOP-STYLE: none; PADDING-TOP: 4px; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; LETTER-SPACING: 1px; BORDER-BOTTOM-STYLE: none; border-radius: 14px; moz-border-radius: 14px; webkit-border-radius: 14px; khtml-border-radius: 14px; text-shadow: 0 1px 1px #000000
}
#agev {
	LEFT: 430px; POSITION: absolute
}
</style>
</head>
<body>
<h1>注册帐号</h1>
<form id="regForm" action="RegisterServlet" onsubmit="return register(this);" method="post">
<fieldset>
<ol>
  <li/><label for="username">用户昵称：</label><input id="username" name="username"
  autofocus required> 
  <li/><label for="sex">你的性别：</label> 
  	<td><input type="radio" name="sex" value="男" checked="checked">男
	    <input type="radio" name="sex" value="女">女
  	</td>
  <li/><label for="password">你的密码：</label><input id="password" name="password"
  autofocus required> 
  <li/><label for="conPassword">确认密码：</label><input id="conPassword" name="conPassword"
  autofocus required>
  <li/><label for="secQuestion">密保问题：</label><input id="secQuestion" name="secQuestion"
  autofocus required>
  <li/><label for="secQuestionAns">密保答案：</label><input id="secQuestionAns" name="secQuestionAns" autofocus required>
  <li/><label for="email">Email：</label><input id="email" type="email" name="email" 
  required placeholder="example@domain.com"> 
  <li/><label for="birthday">出生日期：</label><input id="birthday" name="birthday" autofocus required> 
</ol>
</fieldset>
<div><button type="submit">注册</button> </div></form>
</body>
</html>