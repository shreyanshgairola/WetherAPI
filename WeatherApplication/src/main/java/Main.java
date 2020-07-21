import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import Reader.JSONReader;

public class Main extends APIhit{
	public static void main(String[] args) throws IOException {
		String city;
		BufferedReader in = null;
		String inputline;
		
		System.out.println("Enter City Name");
		Scanner sc=new Scanner(System.in);  
		city = sc.nextLine();
		
		
		InputStream responsestream = hitapi("http://api.openweathermap.org/data/2.5/weather?q={param1}&appid={param2}",city,"7fe67bf08c80ded756e598d6f8fedaea");

		in = new BufferedReader(new InputStreamReader(responsestream));

		
		StringBuffer response = new StringBuffer();
		while((inputline = in.readLine()) != null)
		{
			response.append(inputline);
		}
		
		in.close();
		
		
		
		System.out.println("Temperature :- "+ JSONReader.getValue(response.toString(),"main.temp"));
		System.out.println("Min Temperature :- "+ JSONReader.getValue(response.toString(),"main.temp_min"));
		System.out.println("Max Temperature :- "+ JSONReader.getValue(response.toString(),"main.temp_max"));
		System.out.println("Humidity :- "+ JSONReader.getValue(response.toString(),"main.humidity"));
		System.out.println("Feels Like :- "+ JSONReader.getValue(response.toString(),"main.feels_like"));
		
		
		System.out.println("Visibility :- "+ JSONReader.getValue(response.toString(),"visibility"));
		
		System.out.println("Wind Speed :- "+ JSONReader.getValue(response.toString(),"wind.speed"));
		System.out.println("Wind Degree :- "+ JSONReader.getValue(response.toString(), "wind.deg"));
	}
}
