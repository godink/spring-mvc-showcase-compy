package org.springframework.samples.mvc.test.convert;

import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.Formatter;

public class PhoneNumberFormatter implements Formatter<PhoneNumberModel>{
	
	Pattern pattern = Pattern.compile("^(\\d{3,4})-(\\d{7,8})$");
	
	@Override
	public String print(PhoneNumberModel object, Locale locale) {
		
		if(object == null){
			return "";
		}
		return new StringBuilder().append(object.getAreaCode()).append("-").
									append(object.getPhoneNumber()).toString();
	}

	@Override
	public PhoneNumberModel parse(String text, Locale locale) throws ParseException {
		if(StringUtils.isBlank(text)){
			return null;
		}
		Matcher matcher = pattern.matcher(text);
		if(matcher.matches()){
			PhoneNumberModel model = new PhoneNumberModel();
			model.setAreaCode(matcher.group(1));
			model.setPhoneNumber(matcher.group(2));
			return model;
		}else{
			throw new IllegalArgumentException(String.format("类型转换失败,需要 格式[010-12345678],但格式是[%s]", text));
		}
	}

	
}
