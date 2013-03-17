import java.io.Console;
import java.io.IOException;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.util.jndi.JndiContext;
import org.marut.camel.TwitterRoute;
import org.marut.camel.TwitterStore;


public class TestCamel {

	public static void main (String[] args){
		TwitterRoute twitterRoute = new TwitterRoute();
		try {			
			CamelContext myCamelContext = new DefaultCamelContext();		
			myCamelContext.addRoutes(twitterRoute);
			myCamelContext.start();		
			System.in.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
