package com.renintech.railway;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CallConnect {
	public static String getConnection(String urlstring)throws IOException
	{
		try
		{
			System.out.println(urlstring);
			URL url=new URL(urlstring);
			HttpURLConnection connection=(HttpURLConnection) url.openConnection();
			InputStream is=connection.getInputStream();
			int i = 0;
			StringBuilder data = new StringBuilder("");
			while((i=is.read())!=-1){
				//System.out.println("hai");
				//System.out.println((char)i);
				data.append((char)i);
			}
			String response = data.toString().trim();			
			System.out.println("::::: "+response);
			return response;

		}
		catch(MalformedURLException e)
		{
		e.printStackTrace();
		throw e;
		}
		catch(IOException i)
		{
			i.printStackTrace();
			throw i;
		}
	
	}

}


