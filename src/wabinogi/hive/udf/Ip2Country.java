package wabinogi.hive.udf;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import org.apache.hadoop.hive.ql.exec.UDF;
import com.maxmind.db.CHMCache;
import com.maxmind.geoip2.*;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.Country;
 

public class Ip2Country {

	public static void main(String[] args) throws IOException, GeoIp2Exception {
		// TODO Auto-generated method stub
		Ip2Country ic = new Ip2Country();
		System.out.println(ic.evaluate("8.8.8.8"));
	}

	
	public String evaluate(String ip) throws IOException, GeoIp2Exception
	{
		File database = new File("C:\\Users\\Administrator\\Workspaces\\MyEclipse 2017 CI\\HIVE\\resource\\GeoLite2-City.mmdb");
		System.out.println(database.getAbsolutePath());
		DatabaseReader reader = new DatabaseReader.Builder(database).withCache(new CHMCache()).build();
		InetAddress ipAddress = InetAddress.getByName(ip);
		CityResponse response = reader.city(ipAddress);
		
		Country country = response.getCountry();
		String cname =  country.getName();
		if(cname == null)
		{
			cname = "x";
		}
		

		return cname;

	}
	
}
