package org.springframework.samples.mvc.test.convert;

import java.util.HashSet;
import java.util.Set;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

public class PhoneNumberFormatAnnotationFormatterFactory implements AnnotationFormatterFactory<PhoneNumber>{

	private final Set<Class<?>> fieldTypes;
	
	private final PhoneNumberFormatter formatter;
	
	public PhoneNumberFormatAnnotationFormatterFactory() {
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(PhoneNumberModel.class);
		this.fieldTypes = set;
		this.formatter = new PhoneNumberFormatter();
	}
	
	@Override
	public Set<Class<?>> getFieldTypes() {
		return fieldTypes;
	}

	@Override
	public Printer<?> getPrinter(PhoneNumber annotation, Class<?> fieldType) {
		return formatter;
	}

	@Override
	public Parser<?> getParser(PhoneNumber annotation, Class<?> fieldType) {
		return formatter;
	}

}
