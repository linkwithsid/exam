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

.error {
	color: red
}
</style>
</head>
<body align="center">
	<h3>Search students</h3>
	<form:form method="POST" action="/exam/search">
		<div>
			<table align="center">
				<tr>
					<th colspan="3">Please fill below details, to search others
						going to your exam center</th>
				</tr>
				<tr>
					<td class="error">${error}</td>
				</tr>
				<tr>
					<td>Exam Center Name</td>
					<td colspan="2"><form:input path="centerAddress"
							id="toaddress" placeholder="Your exam center" autocomplete="on"/></td>
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
	<script type="text/javascript">
		function initialize() {
			var options = {
				componentRestrictions : {
					country : "IN"
				}
			};
			var input = document.getElementById('toaddress');
			var autocomplete = new google.maps.places.Autocomplete(input,
					options);
		}
		google.maps.event.addDomListener(window, 'load', initialize);
	</script>
</body>
</html>