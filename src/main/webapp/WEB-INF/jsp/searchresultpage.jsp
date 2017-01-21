<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Search Result</title>
<style>
input, select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #148feb;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #1081ea;
}

div {
	border-radius: 5px;
	background-color: #f9f9f9;
	padding: 20px;
}

table {
	border-collapse: collapse;
}

th, td {
	text-align: left;
	padding: 8px;
}

.borderme, th {
	border-collapse: collapse;
	border: 1px solid black;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #128feb;
	color: white;
}
</style>
</head>
<body align="center">

	<h3>Submitted Student Information</h3>

	<c:choose>
		<c:when test="${numOfResult > 1}">
			<h4>Currently, ${numOfResult} students are going to your center
				:</h4>
		</c:when>
		<c:otherwise>
			<h4>Currently, ${numOfResult} student is going to your center :</h4>
		</c:otherwise>
	</c:choose>


	<h4>${command.centerAddress}on:${command.examDate}</h4>
	<c:if test="${numOfResult > 0}">
		<div>
			<table class="borderme" align="center">
				<tr class="borderme">
					<th>Students Name</th>
					<th>Traveling From</th>
					<th>Contact Number</th>
				</tr>
				<c:forEach var="searchResult" items="${searchResultList}">
					<tr class="borderme">
						<td class="borderme">${searchResult.name}</td>
						<td class="borderme">${searchResult.startPoint}</td>
						<td class="borderme">${searchResult.contactNumber}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>

	<form:form method="POST" action="/exam/addevent">
		<table align="center">
			<tr>
				<td>Search result is not relevant to you? Don't worry add
					yourself, So that other can contact You.</td>
			</tr>
			<form:input path="centerAddress" type="hidden" />
			<form:input path="examDate" type="hidden" />
			<tr>
				<td colspan="2"><input type="submit" value="Add Your Journey" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>