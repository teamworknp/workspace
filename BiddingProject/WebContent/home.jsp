<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.project.HotelInfo"%>
<%@page import="com.servlet.DisplayHotelServlet"%>
<%@include file="/header.jsp"%>
<div class="container-fluid">

	<div class="row">
		<div class="col-md-3">
			<form class="form-inline" action="display" method="get">
				<ul class="nav nav-pills nav-stacked">
					<li class="absolute"><span class="left"><h2>
								<font face="verdana"></font>Filter By
							</h2></span>
						<ul>
							<div class="checkbox">
								<label><input type="checkbox" name="score" value="score"><font
									face="verdana"></font> Sort By Score</label>
							</div>
							<br>
							<div class="checkbox">
								<label><input type="checkbox" name="name" class="small"
									value="name"><font face="verdana"></font> Sort By Name</label>
							</div>
							<br>
							<span class="bold"><H3>
									<font face="verdana"></font>Offered Services
								</H3></span>

							<div class="checkbox">
								<label><input type="checkbox" name="vegetarian"
									class="small" value="services"><font face="verdana"></font>
									Vegetarian</label>
							</div>
							<br>

							<div class="checkbox">
								<label><input type="checkbox" name="multicuisine"
									class="small" value="services"><font face="verdana"></font>
									MultiCusine</label>
							</div>
							<br>
							<div class="checkbox">
								<label><input type="checkbox" name="lodging"
									class="small" value="services"><font face="verdana"></font>
									Lodging</label>
							</div>
							<br>
							<div class="checkbox">
								<label><input type="checkbox" name="chinese"
									class="small" value="services"><font face="verdana"></font>
									Chinese</label>
							</div></li>
					<br>
				</ul>
				<br>
				<button type="submit" autofocus="autofocus" class="btn btn-default">Submit</button>
				<button type="reset" autofocus="autofocus" class="btn btn-default">Reset</button>
			</form>
		</div>
		<%@include file="/filterResults.jsp"%>
	</div>
	
    <%@include file="/carouselBar.jsp"%>
	<div class="clearfix visible-lg"></div>
</div>
</div>
<%@include file="/footer.jsp"%>