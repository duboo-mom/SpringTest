<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Test01</title>
</head>
<body>
	<h2>1. JSTL core 변수</h2>
	<c:set var="number1" value="36"/>
	<c:set var="number2" value="3"/>
		
	<b>첫번째 숫자 : ${number1 }</b> <br>
	<b>두번째 숫자 : ${number2 }</b>
	
	<h2>2. JSTL core 연산</h2>
	<c:set var="division" value="${number1 / number2 }"/>
	
	<b>더하기 : ${number1 + number2 }</b> <br>
	<b>빼기 : ${number1 - number2 }</b> <br>
	<b>곱하기 : ${number1 * number2 }</b> <br>
	<b>나누기 : ${division }</b>
	
	<h2>3. core out</h2>
	<c:out value="<title>core out</title>"/>

	<h2>4. JSTL core if</h2>
	<c:if test="${division >= 10 }">
		<h1>${division }</h1>
	</c:if>	
	<c:if test="${division < 10 }">
		<h4>${division }</h4>
	</c:if>

	<h2>5. core if</h2>
	<c:if test="${(number1 * number2) > 100 }">
		<c:out value="<script>alert('너무 큰 수 입니다')</script>" escapeXml="false"/>
	</c:if>
	

</body>
</html>