<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Add Buddy</title>
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

.error {
	color: red
}

div {
	border-radius: 5px;
	background-color: #f9f9f9;
	padding: 20px;
}
</style>
</head>
<body align="center">

	<h3>Add your exam info</h3>
	<form:form method="POST" action="/exam/addevent">
		<div>
			<table align="center">
				<tr>
					<th></th>
					<th colspan="2">Please fill below details, for others to
						contact you</th>
				</tr>
				<tr>
					<td class="error">${error}</td>
				</tr>
				<tr>
					<td><form:label path="centerAddress">Exam Center Name</form:label></td>
					<td colspan="2"><form:input path="centerAddress"
							id="toaddress" placeholder="Your exam center" autocomplete="on" /></td>
				</tr>
				<tr>
					<td>Date of Exam</td>
					<td colspan="2"><form:input type="date" path="examDate" /></td>
				</tr>
				<tr>
					<td><form:label path="name">Your Name</form:label></td>
					<td colspan="2"><form:input path="name"
							placeholder="Your name" maxlength="32" /></td>
				</tr>
				<tr>
					<td><form:label path="startPoint">Your Address</form:label></td>
					<td colspan="2"><form:input path="startPoint" id="fromaddress"
							placeholder="Your address" autocomplete="on" /></td>
				</tr>
				<tr>
					<td><form:label path="contactNumber">Mobile Number </form:label></td>
					<td colspan="2"><form:input path="contactNumber"
							placeholder="Your 10 digit number" maxlength="10" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Select a Password</form:label></td>
					<td colspan="2"><form:input type="password" path="password"
							placeholder="Select password" maxlength="15" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Add my info" /></td>
				</tr>
			</table>
		</div>
	</form:form>
	<script type="text/javascript"
		src="http://maps.google.com/maps/api/js?key=AIzaSyCqEeDl_RFPExSr2ySPt6qggi6HC89wa88&sensor=false&libraries=places&language=en-AU"></script>
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
	<script type="text/javascript">
		function initialize() {
			var options = {
				componentRestrictions : {
					country : "IN"
				}
			};
			var input = document.getElementById('fromaddress');
			var autocomplete = new google.maps.places.Autocomplete(input,
					options);
		}
		google.maps.event.addDomListener(window, 'load', initialize);
	</script>
</body>
</html>