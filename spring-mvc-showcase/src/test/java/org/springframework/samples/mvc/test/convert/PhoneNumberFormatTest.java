package org.springframework.samples.mvc.test.convert;

import org.junit.Test;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.format.support.DefaultFormattingConversionService;

import junit.framework.Assert;

public class PhoneNumberFormatTest {

	@Test
	public void test() throws NoSuchFieldException, SecurityException {
		//1.创建格式化服务
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		
		//2.添加自定义的注解格式化工厂
		conversionService.addFormatterForFieldAnnotation(new PhoneNumberFormatAnnotationFormatterFactory());
		
		FormatterModel model = new FormatterModel();
		
		TypeDescriptor phoneNumberType =  new TypeDescriptor(FormatterModel.class.getDeclaredField("phoneNumber"));
		
		TypeDescriptor stringType = TypeDescriptor.valueOf(String.class);
		
		PhoneNumberModel value = (PhoneNumberModel)conversionService.convert("020-12345658", stringType,phoneNumberType);
		
		model.setPhoneNumber(value);
		
		Assert.assertEquals("020-12345658", conversionService.convert(model.getPhoneNumber(), phoneNumberType, stringType));
		
	}

}
