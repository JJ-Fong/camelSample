package org.marut.camel;

import org.apache.camel.builder.RouteBuilder;

//Create a route in Camel Context. A route is a new thread. A Java DSL defines route
//Our objective is to create a route which reads tweets from your twitter account every 1 minute interval and 
//sends them to console
public class TwitterRoute extends RouteBuilder {

	static final String consumerKey  = "<Your Key>";
	static final String consumerSecret = "<Your secret>";
	static final String accessToken ="<Your access token>";
	static final String accessSecret ="<Your access secret>";
	
	@Override
	public void configure() throws Exception {
		
		//Camel's Java DSL to define a global Exception handler..
		onException(Exception.class).logStackTrace(true).handled(true);
		
		//Time interval of polling
		int delay = 60; //in seconds
		String twitterUrl = String.format("twitter://timeline/home?type=polling" +
				"&delay=60&consumerKey=%s&consumerSecret=%s&accessToken=%s&accessTokenSecret=%s", 
				consumerKey, consumerSecret, accessToken, accessSecret);
		
		//You can redirect tweets to file or to a bean 
		from(twitterUrl)//.to("file://home/mytweets.txt");
		//Bean instantition done by Type, Specify method name which gets called when 
		  .bean(TwitterStore.class, "storeTweet");
	}
}
