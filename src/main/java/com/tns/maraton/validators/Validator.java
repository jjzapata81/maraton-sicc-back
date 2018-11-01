package com.tns.maraton.validators;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class Validator {

	private static final int MAX_KN_ALLOWED = 100;
	private static final int MAX_KB_ALLOWED = MAX_KN_ALLOWED;
	private static final int CONVERT_TO_KB_VARIABLE = 1024;
	private static final String PNG = "PNG";
	private static final String SEPARATOR_POINT = ".";
	private static final int FORMAT_VALUE_POSITION = 1;
	private static final String JPG = "jpg";
	private static final String JPEG = "jpeg";
	private static final int PRIMERA_POSICION = 0;
	private static final String VALIDADOR_ESPACIO_EN_BLANCO = "\\s";

	public boolean isNotNull(File file) {
		return null != file;
	}

	public boolean isLessThan15Characters(String textToCompare) {
		return textToCompare.length()<15;
	}

	public boolean isEmpty(String textToCompare) {
		return textToCompare.isEmpty();
	}

	public boolean spaceBetween2Words(String textToCompare) {
		Pattern pattern = Pattern.compile(VALIDADOR_ESPACIO_EN_BLANCO);
		Matcher matcher = pattern.matcher(textToCompare);
		return matcher.find();
	}

	public boolean beginWithANumber(String textToCompare) {
		return Character.isDigit(textToCompare.charAt(PRIMERA_POSICION));
	}

	public boolean fileFormatAllowed(File file) {
		String filename = file.getName();
		String[] fileSparatedByPointOfTypeOfFile = filename.split(Pattern.quote(SEPARATOR_POINT));
		return (fileSparatedByPointOfTypeOfFile[FORMAT_VALUE_POSITION].equals(JPG)
				|| fileSparatedByPointOfTypeOfFile[FORMAT_VALUE_POSITION].equals(JPEG)
				|| fileSparatedByPointOfTypeOfFile[FORMAT_VALUE_POSITION].equals(PNG));
	}

	public boolean fileIsGreather100KB(File file) {
		return (file.length()/CONVERT_TO_KB_VARIABLE)>MAX_KB_ALLOWED;
	}

}
