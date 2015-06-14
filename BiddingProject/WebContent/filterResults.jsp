<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.project.HotelInfo"%>
<%@ page isErrorPage="true" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<body>
	<div class="container">
		<% 
			List<HotelInfo> list = (ArrayList<HotelInfo>) request.getAttribute("data"); 	%>
			<%-- <%
			if(list == null){
			%>
				<jsp:include page="/display" />
			<% }%> --%>
		
		<% if(list != null) {%>
			<h2>List of Hotels</h2>
		
			<table class="table-condensed" border="4">
			<thead>
				<tr>
					<th>Hotels Name</th>
					<th>Hotels Url</th>
					<th>Hotels Score</th>
					<th>Hotels Service</th>
				</tr>
			</thead>
			<%for(HotelInfo info : list) {%>
			<tbody >
				<tr>
					<td><%= info.getName()%></td>
					<td><%= info.getUrl()%></td>
					<td><%= info.getScore()%></td>
					<td><%= info.getServices()%></td>
				</tr>
			</tbody>
			<%} %>
		</table>
			
			
		<%} else {%>
				<%@include file="/sorry.jsp"%>
		<%} %> 

	</div>
</body>
