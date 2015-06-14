package com.resources;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.utility.DbUtility;

@Path("/hotelPage")
public class PageResource {

	static int pageId = 100;
	/**
	 * get list of hotel based on particular page name
	 * @param pageName
	 * @return
	 */
	@POST
	@Path("/get/{pageName}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getHotel(@PathParam("pageName") String pageName) {
		
		String hotelList = "";
		String query = "SELECT * from page INNER JOIN pagehotel " +
				"on PAGE_TABLE.PAGE_ID = PAGE_HOTEL.PAGE_ID" +
				"where PAGE_TABLE.PAHE_NAME = '"+pageName+"'";
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DbUtility.getConnection();
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				hotelList = hotelList + resultSet.getInt("HOTEL_ID") +",";
				System.out.println("Hotel id : " + resultSet.getInt("HOTEL_ID"));
			}
			hotelList = hotelList.substring(0, hotelList.length()-1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnection(statement, connection);
		}
		return hotelList;
	}
	
	/**
	 * get list of available pages in the table
	 * @return
	 */
	@GET
	@Path("/get")
	public String getPages() {
		
		String nameOfPages= "";
		String query = "select * from PAGE_TABLE";
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DbUtility.getConnection();
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				nameOfPages = nameOfPages + resultSet.getString("PAGE_NAME") +",";
				System.out.println("page name : " + resultSet.getString("PAGE_NAME"));
			}
			nameOfPages = nameOfPages.substring(0, nameOfPages.length()-1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnection(statement, connection);
		}
		return nameOfPages;
	}
	
	/**
	 * create a page based on given page name example /createPage/hotels in bangalore
	 * @param pageName
	 * @return
	 */
	@POST
	@Path("/create/{pageName}")
	public void createPage(@PathParam("pageName") String pageName) {

		Connection dbConnection = null;
		Statement statement = null;
 
		String insertTableSQL = "INSERT INTO PAGE_TABLE (PAGE_ID, PAGE_NAME) VALUES ("+pageId+",'"+pageName+"'))";
		try {
			dbConnection = DbUtility.getConnection();
			statement = dbConnection.createStatement();
 
			// execute insert SQL statement
			statement.executeUpdate(insertTableSQL);
			System.out.println("Record is inserted into page table !");
			pageId++;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DbUtility.closeConnection(statement, dbConnection);
		}
	}
	
	@POST
	@Path("/addHotel/{pageName}/{hotelId}")
	public void addHotel(@PathParam("pageName") String pageName,
						   @PathParam("hotelId") String hotelId) {
		
		Connection dbConnection = null;
		Statement statement = null;
 
		String insertTableSQL = "INSERT INTO PAGE_HOTELS (HOTEL_ID) " +
								" SELECT " +
								" (SELECT PAGE_ID from PAGE_TABLE where PAGE_NAME = '"+pageName+"')," +
								"  HOTEL_ID from (values ('"+hotelId+"')) PAGE_HOTELS_DATA (HOTEL_ID)";
		try {
			dbConnection = DbUtility.getConnection();
			statement = dbConnection.createStatement();
 
			// execute insert SQL statement
			statement.executeUpdate(insertTableSQL);
			System.out.println("Record is inserted into page hotel table !");
			pageId++;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DbUtility.closeConnection(statement, dbConnection);
		}
	}
}