package wabinogi.hive.udf;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import org.apache.hadoop.hive.ql.exec.UDF;
import com.maxmind.db.CHMCache;
import com.maxmind.geoip2.*;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.Subdivision;


public class Ip2City extends UDF {

	public static void main(String[] args) throws IOException, GeoIp2Exception {
		// TODO Auto-generated method stub
		
		
	}

	
	
	public String evaluate(String ip) throws IOException, GeoIp2Exception
	{
		File database = new File("resource/GeoLite2-City.mmdb");
		DatabaseReader reader = new DatabaseReader.Builder(database).withCache(new CHMCache()).build();
		InetAddress ipAddress = InetAddress.getByName(ip);
		CityResponse response = reader.city(ipAddress);
		

		Subdivision subdivision = response.getMostSpecificSubdivision();
		String sname =  subdivision.getName();
		if(sname == null)
		{
			sname = "x";
		}
		return sname;

		/*
		City city = response.getCity();
		System.out.println("城市c : " +  city.getName()); // 'Minneapolis'

        
		Location location = response.getLocation();
		System.out.println(location.getLatitude());  // 
		System.out.println(location.getLongitude()); // 
		*/
	}
	
}
