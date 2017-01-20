<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Search Buddy</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
</head>
<body>

	<h2>Student Information</h2>
	<form:form method="POST" action="/exam/exam/searchresult">
		<table>
			<tr>
				<td><form:label path="name">Your Name</form:label></td>
				<td><form:input path="name" style="width: 500px;"/></td>
			</tr>
			<tr>
				<td><form:label path="from">Your Address</form:label></td>
				<td><form:input path="from" id="address" style="width: 500px;"/></td>
			</tr>
			<tr>
				<td><form:label path="to">Exam Center</form:label></td>
				<td><form:input path="to" id="toaddress" style="width: 500px;"/></td>
			</tr>
			<tr>
				<td><form:label path="date">Exam Date(DD-MM)</form:label></td>
				<td><form:input path="date" style="width: 500px;"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Search" /></td>
			</tr>
		</table>
	</form:form>
	<script type="text/javascript"
		src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCqEeDl_RFPExSr2ySPt6qggi6HC89wa88&sensor=false&libraries=places&language=en-AU"></script>
	<script>
		var autocomplete = new google.maps.places.Autocomplete(
				$("#address")[0], {});

		google.maps.event.addListener(autocomplete, 'place_changed',
				function() {
					var place = autocomplete.getPlace();
					console.log(place.address_components);
				});
	</script>
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