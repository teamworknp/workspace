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

@Path("/hotelComment")
public class CommentResource {

	/**
	 * add the comment count by one 
	 * @param hotelId
	 * @return
	 */
	@POST
	@Path("/add/{hotelId}")
	public void addComment(@PathParam("hotelId") String hotelId) {
		
		String query = "select * from HOTEL_COMMENT where HOTEL_ID = "+hotelId;
		Connection connection = null;
		Statement statement = null;
		Statement statement2 = null;
		try {
			connection = DbUtility.getConnection();
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
			int comment_count = resultSet.getInt("COMMENT_COUNT");
			comment_count++;

			query = "UPDATE HOTEL_COMMENT " +
					"SET COMMENT_COUNT = "+ comment_count+
					" WHERE HOTEL_ID = '"+hotelId+"'";
			
			statement2 = connection.createStatement();
			statement2.execute(query);
			System.out.println("Record is updated to HOTEL_COMMENT table!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnection(statement, connection);
		}
	}
	
	@GET
	@Path("/get/{hotelId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getComment(@PathParam("hotelId") String hotelId) {
		
		int comment_count = 0;
		String query = "select * from HOTEL_COMMENT where HOTEL_ID = "+hotelId;
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DbUtility.getConnection();
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
			comment_count = resultSet.getInt("COMMENT_COUNT");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnection(statement, connection);
		}
		
		return String.valueOf(comment_count);
	}
}