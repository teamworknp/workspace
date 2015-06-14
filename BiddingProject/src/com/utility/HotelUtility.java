package com.utility;

import javax.swing.plaf.ListUI;

import com.google.gson.Gson;
import com.project.HotelInfo;
import com.sun.xml.internal.ws.util.StringUtils;

public class HotelUtility {

	/**
	 * method used to give particular hotel information based on the given URL 
	 * @param url
	 * @return
	 */
	public static HotelInfo	getHotelInfo(String url) {
		
		//lets suppose we get this string as the output from given url
		String hotelInfo1 = "{\"name\": \"Testhotel 1\",\"id\": 1,\"url\": \"/hotels/1\","+
				"\"desc\": \"\",\"img\": \"\",\"score\": 10,\"services\": [ {"+
				"\"name\": \"Vegetarian\"},{\"name\": \"Chinese\"}]}";
		
		String hotelInfo2 = "{\"name\": \"Testhotel 2\",\"id\": 2,\"url\": \"/hotels/2\","+
				"\"desc\": \"\",\"img\": \"\",\"score\": 8,\"services\": [ {"+
				"\"name\": \"Vegetarian\"},{\"name\": \"lodging\"}]}";
		
		String hotelInfo3 = "{\"name\": \"Testhotel 3\",\"id\": 3,\"url\": \"/hotels/3\","+
				"\"desc\": \"\",\"img\": \"\",\"score\": 9,\"services\": [ {"+
				"\"name\": \"lodging\"},{\"name\": \"Chinese\"}]}";
		
		String hotelInfo4 = "{\"name\": \"Testhotel 4\",\"id\": 4,\"url\": \"/hotels/4\","+
				"\"desc\": \"\",\"img\": \"\",\"score\": 10,\"services\": [ {"+
				"\"name\": \"Vegetarian\"},{\"name\": \"multicuisine\"}]}";
		
		String hotelInfo5 = "{\"name\": \"Testhotel 5\",\"id\": 5,\"url\": \"/hotels/5\","+
				"\"desc\": \"\",\"img\": \"\",\"score\": 6,\"services\": [ {"+
				"\"name\": \"lodging\"},{\"name\": \"Chinese\"}]}";
		
		String hotelInfo6 = "{\"name\": \"Testhotel 6\",\"id\": 6,\"url\": \"/hotels/6\","+
				"\"desc\": \"\",\"img\": \"\",\"score\": 7,\"services\": [ {"+
				"\"name\": \"multicuisine\"},{\"name\": \"lodging\"}]}";
		
		String hotelInfo7 = "{\"name\": \"Testhotel 7\",\"id\": 7,\"url\": \"/hotels/7\","+
				"\"desc\": \"\",\"img\": \"\",\"score\": 2,\"services\": [ {"+
				"\"name\": \"multicuisine\"},{\"name\": \"Chinese\"}]}";
		
		if (url.contains("1")) {
			return convertJson(hotelInfo1);
		}
		
		if (url.contains("2")) {
			return convertJson(hotelInfo2);
		}
		
		if (url.contains("3")) {
			return convertJson(hotelInfo3);
		}
		
		if (url.contains("4")) {
			return convertJson(hotelInfo4);
		}
		
		if (url.contains("5")) {
			return convertJson(hotelInfo5);
		}
		
		if (url.contains("6")) {
			return convertJson(hotelInfo6);
		}
		
		return convertJson(hotelInfo7);
		//now we convert this string into HotelInfo object
		
	}
	
	/**
	 * method used to convert json string into user define object
	 * @param string
	 * @return
	 */
	private static HotelInfo convertJson(String string) {
		HotelInfo info = new HotelInfo();
		
		Gson gson = new Gson();
		info = gson.fromJson(string, HotelInfo.class);
		return info;
	}
	
	/**
	 * method used to give list of hotels based on the given URL
	 * @param url
	 * @return
	 */
	public static String[] getHotels(String url) {
		//lets suppose we get this string as the output from given url
		String listOfHotels = "[1,2,3,4,5,6,7]";
		if(listOfHotels.equals("[]")){
			return new String[0];
		}
		return convertListOfHotels(listOfHotels);
	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	private static String[] convertListOfHotels(String listOfHotels) {
		//convert string into List of Integer
		listOfHotels = listOfHotels.substring(1, listOfHotels.length()-1);
		
//		System.out.println("string without brases :"+listOfHotels);
//		System.out.println("final string : "+listOfHotels);
		String[] list = listOfHotels.split(",");
		return list;
	}
}