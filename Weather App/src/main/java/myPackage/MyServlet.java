package myPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

import org.apache.catalina.valves.rewrite.InternalRewriteMap.LowerCase;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cityName = request.getParameter("userInput");
//		System.out.println(cityName);
		
//		API key and url
		String apiKey = "f8c721998f5652493c4cf4cac06689c1";
		String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey;
		
//		API integration
		URL url = new URL(apiUrl);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		
//		Now we need Data... on network it will be in stream... Reading the data from network
		InputStream inputStream = connection.getInputStream();
		InputStreamReader reader = new InputStreamReader(inputStream);
		
//		Now store the data in string whatever read in stream
		Scanner sc = new Scanner(reader);
		StringBuilder weatherData = new StringBuilder();
		while(sc.hasNext()) {
			weatherData.append(sc.nextLine());
		}
		
		sc.close();
		connection.disconnect();
//		System.out.println(weatherData);
//		weatherData is a string which has output in JSON format but it is in string... So we will convert this string to JSON 
//		so that we can easily get the required data from the JSON
		
//		Typecasting... String to JSON
		Gson gson = new Gson(); //It is a google libarary it allows JSON data in tree model
		JsonObject jsonObject = gson.fromJson(weatherData.toString(),JsonObject.class);
//		System.out.println(jsonObject);
		
//		Date and Time
		long dateTimestamp = jsonObject.get("dt").getAsLong()*1000;
		String date = new Date(dateTimestamp).toString();
		
//		Temparature
		double tempKelvin = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
		int temp = (int) (tempKelvin - 273.15);
//		Humidity
		int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
		
//		Wind Speed
		double windSpeed = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();
		
//		Weather Condition
		String weatherCondition = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
		
//		if end user entered the LowerCase, in that scenerio webpage will load in lowercase so directly taking name from api
		String city =  jsonObject.get("name").getAsString();
		
		request.setAttribute("date", date);
		request.setAttribute("city", city);
		request.setAttribute("temperature", temp);
		request.setAttribute("weatherCondition", weatherCondition);
		request.setAttribute("humidity", humidity);
		request.setAttribute("windSpeed", windSpeed);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
