<html>
<body>
	<h2>Knight is equipped!</h2>
	
<%-- 	<br /><a href="${pageContext.request.contextPath}/totalcost">Total cost</a> --%>
	
	<form method="GET" action="knight">
		<input type="submit" value="Knight">
	</form>
	
	<form method="GET" action="totalcost">
		<input type="submit" value="Get total cost of equipment">
	</form>
	
	<form method="GET" action="sortedequip">
		<input type="submit" value="Sorted equipment">
	</form>
	
	
	<p>Enter range of price to display</p>
	<form method="GET" action="withinrange">
		<table>
			<tr>
				<td>Lower bound</td>
				<td><input type="number" name="lowRange"></td>
			</tr>
			<tr>
				<td>Upper bound</td> 
				<td><input type="number" name="highRange"></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="Send data"></td>
			</tr>
			<tr>
				<<td>input type="submit" value="Equipment within price range"></td>
			</tr>
		</table>
		
	</form>
	
	
</body>
</html>
