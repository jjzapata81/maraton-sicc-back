package com.tns.maraton.services;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import com.tns.maraton.client.MaratonClient;
import com.tns.maraton.exceptions.BusinessException;
import com.tns.maraton.services.LoginService;
import com.tns.maraton.validators.Validator;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {
	private static final String FILE_NAME = "julian3.jpeg";
	private static final String FILE_NAME_INCORRECT = "info.txt";
	@InjectMocks
	private LoginService loginService;
	
	@Mock
	private MaratonClient client;
	
	@Mock
	private Validator validate;
	
	
	@Before
	  public void setUp() { // Note: It is not required to call this setUp()
	    // ...
	  }
	
	@Test(expected = BusinessException.class)
	public void registerMustCallValidate() {
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
		loginService.register(file, "Jackson");
		verify(validate).isNotNull(file);
	}
	
	@Test
	public void mustRegisterValidateIsNotNull() {
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
		when(validate.isNotNull(file)).thenReturn(true);
		when(validate.isLessThan15Characters("Jackson")).thenReturn(true);
		when(validate.fileFormatAllowed(file)).thenReturn(true);
		loginService.register(file, "Jackson");
		verify(client).register(file, "Jackson");
	}
	
	@Test(expected = BusinessException.class)
	public void mustRegisterValidateIsNull() {
		File file = null;
		when(validate.isLessThan15Characters("Jackson")).thenReturn(true);
		loginService.register(file, "Jackson");
		verify(client, times(0)).register(file, "Jackson");
	}
	
	@Test(expected = BusinessException.class)
	public void mustRegisterThrowAnExceptionWhereFileIsNull() {
		File file = null;
		when(validate.isNotNull(file)).thenReturn(false);
		when(validate.isLessThan15Characters("Jackson")).thenReturn(true);
		when(validate.fileFormatAllowed(file)).thenReturn(true);
		loginService.register(file, "Jackson");
	}
	
	@Test(expected = BusinessException.class)
	public void compareMustCallValidate() {
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
		loginService.compare(file, "Jackson");
		verify(validate).isNotNull(file);
	}
	
	@Test
	public void mustCompareValidateIsNotNull() {
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
		when(validate.isNotNull(file)).thenReturn(true);
		loginService.compare(file, "Jackson");
		verify(client).compare(file, "Jackson");
	}
	
	@Test(expected = BusinessException.class)
	public void mustCompareValidateIsNull() {
		File file = null;
		loginService.compare(file, "Jackson");
		verify(client, times(0)).compare(file, "Jackson");
	}
	
	@Test(expected = BusinessException.class)
	public void mustCompareThrowAnExceptionWhereFileIsNull() {
		File file = null;
		loginService.compare(file, "Jackson");
	}
	
	@Test
	public void mustValidateNotEmptyName() {
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
		when(validate.isNotNull(file)).thenReturn(true);
		when(validate.isLessThan15Characters("Jackson")).thenReturn(true);
		when(validate.fileFormatAllowed(file)).thenReturn(true);
		loginService.register(file, "Jackson");
		verify(validate).isEmpty("Jackson");
	}
	
	@Test(expected = BusinessException.class)
	public void mustValidateEmptyName() {
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
		when(validate.isLessThan15Characters("")).thenReturn(true);
		when(validate.isEmpty("")).thenReturn(true);
		loginService.register(file, "");
		verify(validate).isEmpty("");
	}
	
	@Test
	public void mustValidateNameIsLessThan15Characters() {
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
		when(validate.isNotNull(file)).thenReturn(true);
		when(validate.fileFormatAllowed(file)).thenReturn(true);
		when(validate.isLessThan15Characters("Jackson")).thenReturn(true);
		loginService.register(file, "Jackson");
		verify(validate).isLessThan15Characters("Jackson");
	}
	
	@Test(expected = BusinessException.class)
	public void mustValidateNameIsGreatherThan15Characters() {
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
		when(validate.isLessThan15Characters("camilorestreporamirez")).thenReturn(false);
		loginService.register(file, "camilorestreporamirez");
		verify(validate).isLessThan15Characters("camilorestreporamirez");
	}
	
	@Test
	public void mustValidateNoSpaceBetween2Words() {
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
		when(validate.isNotNull(file)).thenReturn(true);
		when(validate.isLessThan15Characters("Jackson")).thenReturn(true);
		when(validate.fileFormatAllowed(file)).thenReturn(true);
		loginService.register(file, "Jackson");
		verify(validate).spaceBetween2Words("Jackson");
	}
	
	@Test(expected = BusinessException.class)
	public void mustValidateSpaceBetween2Words() {
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
		when(validate.isLessThan15Characters("Jackson Martinez")).thenReturn(true);
		when(validate.spaceBetween2Words("Jackson Martinez")).thenReturn(true);
		loginService.register(file, "Jackson Martinez");
		verify(validate).isLessThan15Characters("Jackson Martinez");
	}
	
	@Test
	public void mustValidateNotBeginWithANumber() {
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
		when(validate.isNotNull(file)).thenReturn(true);
		when(validate.fileFormatAllowed(file)).thenReturn(true);
		when(validate.isLessThan15Characters("Jackson")).thenReturn(true);
		loginService.register(file, "Jackson");
		verify(validate).beginWithANumber("Jackson");
	}
	
	@Test(expected = BusinessException.class)
	public void mustValidateBeginWithANumber() {
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
		when(validate.isLessThan15Characters("9a")).thenReturn(true);
		when(validate.spaceBetween2Words("9a")).thenReturn(false);
		when(validate.beginWithANumber("9a")).thenReturn(true);
		loginService.register(file, "9a");
	}
	
	@Test
	public void mustValidateFormatAllowed() {
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
		when(validate.isNotNull(file)).thenReturn(true);
		when(validate.fileFormatAllowed(file)).thenReturn(true);
		when(validate.isLessThan15Characters("Jackson")).thenReturn(true);
		loginService.register(file, "Jackson");
		verify(validate).fileFormatAllowed(file);
	}
	
	@Test(expected = BusinessException.class)
	public void mustValidateFormatNotAllowed() {
		File file = new File(getClass().getClassLoader().getResource(FILE_NAME_INCORRECT).getFile());
		when(validate.isLessThan15Characters("a")).thenReturn(true);
		when(validate.spaceBetween2Words("a")).thenReturn(false);
		when(validate.beginWithANumber("a")).thenReturn(false);
		loginService.register(file, "a");
		verify(validate).fileFormatAllowed(file);
	}
}
