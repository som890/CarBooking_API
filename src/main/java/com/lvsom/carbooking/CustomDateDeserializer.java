package com.lvsom.carbooking;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeserializer extends JsonDeserializer<Date>  {
	
	 private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	 
	@Override
	   public Date deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
		 String dateString = jsonParser.getText();
	        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	        try {
	            return dateFormat.parse(dateString);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	}

}
