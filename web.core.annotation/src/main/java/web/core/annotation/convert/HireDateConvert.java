package web.core.annotation.convert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class HireDateConvert implements Converter<String, Date> {

	@Override
	public Date convert(String date) {
		Date formatedDate = null;
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		try {
			formatedDate = (Date) formatDate.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return formatedDate;
	}

	
}
