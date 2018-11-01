package com.tns.maraton.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class ValidatorTest {
	private static final String FILE_NAME_JPEG = "julian3.jpeg";
	private static final String FILE_NAME_JPG = "Jackson.jpg";
	private static final String FILE_NAME_PNG = "Captura.PNG";
	
	@Test
	public void mustValidateFileIsNotNull() {
		Validator validate = new Validator();
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME_JPEG).getFile());
		boolean isNotNull = validate.isNotNull(file);
		assertTrue(isNotNull);
	}
	
	@Test
	public void mustValidateFileIsNull() {
		Validator validate = new Validator();
		File file = null;
		boolean isNotNull = validate.isNotNull(file);
		assertFalse(isNotNull);
	}
	
	@Test
	public void lessThan15CharactersTest() {
		Validator validator = new Validator();
		String textToCompare = "s";
		boolean isLessThan15Characters = validator.isLessThan15Characters(textToCompare);
		assertTrue(isLessThan15Characters);
	}
	
	@Test
	public void moreThan15CharactersTest() {
		Validator validator = new Validator();
		String textToCompare = "camilorestreporamirez";
		boolean isLessThan15Characters = validator.isLessThan15Characters(textToCompare);
		assertFalse(isLessThan15Characters);
	}
	
	@Test
	public void emptyNameTest() {
		Validator validator = new Validator();
		String textToCompare = "";
		boolean isEmpty = validator.isEmpty(textToCompare);
		assertTrue(isEmpty);
	}
	
	@Test
	public void noEmptyNameTest() {
		Validator validator = new Validator();
		String textToCompare = "s";
		boolean isEmpty = validator.isEmpty(textToCompare);
		assertFalse(isEmpty);
	}
	
	@Test
	public void noSpaceBetween2WordsInTheNameTest() {
		Validator validator = new Validator();
		String textToCompare = "s";
		boolean spaceBetween2Words = validator.spaceBetween2Words(textToCompare);
		assertFalse(spaceBetween2Words);
	}
	
	@Test
	public void spaceBetween2WordsInTheNameTest() {
		Validator validator = new Validator();
		String textToCompare = "s a";
		boolean spaceBetween2Words = validator.spaceBetween2Words(textToCompare);
		assertTrue(spaceBetween2Words);
	}
	
	@Test
	public void beginWithANumberTest() {
		Validator validator = new Validator();
		String textToCompare = "9camilo";
		boolean beginWithANumber = validator.beginWithANumber(textToCompare);
		assertTrue(beginWithANumber);
	}
	
	@Test
	public void notBeginWithANumberTest() {
		Validator validator = new Validator();
		String textToCompare = "camilo";
		boolean beginWithANumber = validator.beginWithANumber(textToCompare);
		assertFalse(beginWithANumber);
	}
	
	@Test
	public void fileIsJpegTest() {
		Validator validator = new Validator();
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME_JPEG).getFile());
		boolean fileIsJpeg = validator.fileFormatAllowed(file);
		assertTrue(fileIsJpeg);
	}
	
	@Test
	public void fileIsJpgTest() {
		Validator validator = new Validator();
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME_JPG).getFile());
		boolean fileIsJpeg = validator.fileFormatAllowed(file);
		assertTrue(fileIsJpeg);
	}
	
	@Test
	public void fileIsPngTest() {
		Validator validator = new Validator();
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME_PNG).getFile());
		boolean fileIsPng = validator.fileFormatAllowed(file);
		assertTrue(fileIsPng);
	}
	
	@Test
	public void fileIsGreather100KBTest() {
		Validator validator = new Validator();
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME_PNG).getFile());
		boolean fileIsGreather100KB = validator.fileIsGreather100KB(file);
		assertTrue(fileIsGreather100KB);
	}
	
	@Test
	public void fileIsNotGreather100KBTest() {
		Validator validator = new Validator();
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME_JPG).getFile());
		boolean fileIsGreather100KB = validator.fileIsGreather100KB(file);
		assertFalse(fileIsGreather100KB);
	}

}
