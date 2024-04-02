<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body{
display: flex;
height: 100vh;
width: 100%;
justify-content: center;
align-items: center;
}
fieldset{
height: 200px;
width: 200px;

}
</style>
<body>
<fieldset>
<table>
<legend>
<h1>Login</h1>
<form action="login" method="post">

 <tr>
	<td>EMAIL:</td>
	<td><input type="email" name="email" ></td>
 </tr>
 <tr>
	<td>PASSWORD:</td>
	<td><input type="password" name="password" ></td>
 </tr>
 <tr><td colspan="2"><input type="submit"></td></tr>


</form>
</legend>
</table>
</fieldset>
</body>
</html>