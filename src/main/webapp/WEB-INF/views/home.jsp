<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link href="resources/style.css" rel="stylesheet" />
</head>
<body>
	<h1>Today's Weather ${ city.getCurrentobservation().getName()}</h1>

<table border="1">
<tr>

	<c:choose>
		<c:when test="${city eq null}">
	How are you?

</c:when>
		<c:otherwise>
				
								
				<c:forEach begin="0" end="8" step="2" varStatus="loop">
					<c:choose>
						<c:when test="${city.getTime().getTempLabel().get(0) eq 'Low'}">

							
								<c:choose>
								<c:when test="${loop.index == 0}">
									<td>
									
									<c:out value = "${city.getTime().getStartPeriodName().get(0)} <br>Low: "/> 
									<c:out value = "${city.getData().getTemperature().get(0)} <br> "/>
									</td>
									
								</c:when>
								</c:choose>
								<td>
								<c:out value = "${city.getTime().getStartPeriodName().get(loop.index + 1)} <br> "/>
								<c:out value = "High: ${city.getData().getTemperature().get(loop.index + 1)}"/>
								<c:out value = "Low: ${city.getData().getTemperature().get(loop.index + 2)} <br>"/>
								<!--  Description: ${city.getData().getText().get(loop.index)} <br>-->
								</td>

						</c:when>

						<c:otherwise>
								
								<td>	
								${city.getTime().getStartPeriodName().get(loop.index)} <br> 
								High:
								${city.getData().getTemperature().get(loop.index)} 
								<br>
								Low:
								${city.getData().getTemperature().get(loop.index + 1)} <br>
								<!--  Description: ${city.getData().getText().get(loop.index)} <br>-->
								</td>
								
						</c:otherwise>
					</c:choose>
				</c:forEach>			
		</c:otherwise>
	</c:choose>
</tr>
</table>
	<a href="resources/pickCity.html">Choose a city</a>
</body>
</html>
