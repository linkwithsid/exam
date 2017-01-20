<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Search Result</title>
</head>
<body>

	<h3>Submitted Student Information</h3>

	<h4>All Students Going Towards Your Center :</h4>
	
	<c:forEach var="searchResult"
		items="${searchResultList}">
		<table>
			<tr>
				<td>Name :</td>
				<td>${searchResult.name}</td>
			</tr>
			<tr>
				<td>Traveling From :</td>
				<td>${searchResult.from}</td>
			</tr>
			<tr>
				<td>To Your Exam Center</td>
				<td>${searchResult.to}</td>
			</tr>
			<tr>
				<td>On Exam Date</td>
				<td>${searchResult.date}</td>
			</tr>
			<tr>
				<td>Contact This Person</td>
				<td><input type="button" value="Contact" /></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
		</table>
	</c:forEach>
	<form:form method="GET" action="/exam/exam/addevent">
		<tr>
			<td>Not Relevant ? Don't worry add yourself, So that other can contact You.</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Add Your Journey" /></td>
		</tr>
	</form:form>
</body>
</html>