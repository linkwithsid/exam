<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Search Buddy</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
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

.error{
color :red
}
</style>
</head>
<body align="center">
	<h3>Search students</h3>
	<form:form method="POST" action="/exam/search">
		<div>
			<table align="center">
			<tr>
				<th colspan="3">Please fill below details, to search others going to your exam center</th>
			</tr>
				<tr>
					<td class="error">${error}</td>
				</tr>
				<tr>
					<td>Exam Center Name</td>
					<td colspan="2"><form:input path="centerAddress" id="toaddress" /></td>
				</tr>
				<tr>
					<td>Date of Exam</td>
					<td><form:input type="date" path="examDate" /></td>
					<td><input type="submit" value="Search" /></td>
				</tr>

			</table>
		</div>
	</form:form>
	<script type="text/javascript"
		src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCqEeDl_RFPExSr2ySPt6qggi6HC89wa88&sensor=false&libraries=places&language=en-AU"></script>
	<script>
		var autocomplete = new google.maps.places.Autocomplete(
				$("#toaddress")[0], {});

		google.maps.event.addListener(autocomplete, 'place_changed',
				function() {
					var place = autocomplete.getPlace();
					console.log(place.address_components);
				});
	</script>
</body>
</html>