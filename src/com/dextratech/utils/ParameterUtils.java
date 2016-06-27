package com.dextratech.utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParameterUtils {

	private static final String intArray = "int[]";
	private static final String intValue = "int";
	private static final String doubleArray = "double[]";
	private static final String doubleValue = "double";
	private static final String floatArray = "float[]";
	private static final String floatValue = "float";
	private static final String stringValue = "String";
	
	public static String getParameterFromText(String text) {
		StringBuilder  builder = new StringBuilder();
		if(tryMatching("Integer", text) || tryMatching("integer", text)
				|| tryMatching("Integers", text) || tryMatching("integers", text)) {
			builder.append("int");
		}else if(tryMatching("Double", text) || tryMatching("double", text)
				|| tryMatching("Doubles", text) || tryMatching("doubles", text)) {
			builder.append("double");
		}else if(tryMatching("Float", text) || tryMatching("float", text)
				|| tryMatching("Floats", text) || tryMatching("floats", text)) {
			builder.append("float");
		}else {
			builder.append("String");
		}
		if(tryMatching("Array", text) || tryMatching("array", text)) {
			builder.append("[]");
		}
		builder.append(" ");
		builder.append("args");
		return builder.toString();
	}
	
	private static boolean tryMatching(String type, String text) {
		Pattern pattern = Pattern.compile(".*\\b" + type+"\\b.*");
		Matcher matcher = pattern.matcher(text);
		return matcher.find();
	}
	
	public static String getValueTypeKey(String text) {
		String type = "";
		switch (getParameterFromText(text)) {
		case intArray:
			
			break;
		case intValue:
			
			break;
		case doubleArray:
			
			break;
		case doubleValue:
			
			break;
		case floatArray:
			
			break;
		case floatValue:
			
			break;
		case stringValue:
			
			break;
		default:
			
			break;
		}
		return type;
	}

}
