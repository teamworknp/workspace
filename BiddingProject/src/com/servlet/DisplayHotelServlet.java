package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.HotelInfo;
import com.utility.HotelUtility;

/**
 * Servlet implementation class DisplayHotelServlet
 */
//@WebServlet("/display")
public class DisplayHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL = "GET/hotels";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayHotelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
//		System.out.println("servlet strats from init method");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//				System.out.println("service starts");
				String[] services = request.getParameterValues("services");
				String isNameSorted = request.getParameter("name");
				String isScoreSorted = request.getParameter("score");

//				System.out.println("isNameSorted :"+isNameSorted);
//				System.out.println("isScoreSorted :"+isScoreSorted);
				
				List<HotelInfo> list = getHotelInfos(services, isNameSorted, isScoreSorted);
				
//				System.out.println("Size of data list :" +list.size());
				
				request.setAttribute("data", list);
				request.getRequestDispatcher("/home.jsp").forward(request, response);
			}
			
			private List<HotelInfo> getHotelInfos(String[] services, String isNameSorted, String isScoreSorted) {
				
				String url = URL;
				if(services != null && services.length != 0){
					url=url+"?";
					for (String	service : services) {
						url = url +"services="+service+"&";
					}
					url=url.substring(0, url.length()-1);
				}
				
//				System.out.println("URL :"+url);
				
				String[] hotelList = HotelUtility.getHotels(url);
				List<HotelInfo> list = new ArrayList<HotelInfo>();
				
				if(hotelList != null && hotelList.length >0){
					
					for (String hotelId : hotelList) {
						String url1 = URL+"/"+hotelId;
						System.out.println(url1);
						list.add(HotelUtility.getHotelInfo(url1));
					}
				}
				
				//just for printing purpose
//				for (HotelInfo hotelInfo : list) {
//					System.out.println("Hotel name :"+hotelInfo.getName()+" hotel score :"+hotelInfo.getScore());
//				}
				if (isNameSorted != null) {
					Collections.sort(list, HotelInfo.nameComparator);
					
					System.out.println(" After sorted based on name");
					//just for printing purpose
//					for (HotelInfo hotelInfo : list) {
//						System.out.println("Hotel name :"+hotelInfo.getName()+" hotel score :"+hotelInfo.getScore());
//					}
				}
				
				if (isScoreSorted != null) {
					Collections.sort(list, HotelInfo.ScoreComparator);
					
					System.out.println(" After sorted based on score");
					//just for printing purpose
//					for (HotelInfo hotelInfo : list) {
//						System.out.println("Hotel name :"+hotelInfo.getName()+" hotel score :"+hotelInfo.getScore());
//					}
				}
				return list;
			}

}