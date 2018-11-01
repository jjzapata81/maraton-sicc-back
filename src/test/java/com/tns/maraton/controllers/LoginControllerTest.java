package com.tns.maraton.controllers;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tns.maraton.model.response.PingResponse;
import com.tns.maraton.model.response.RecognizeResponse;
import com.tns.maraton.services.LoginService;
import com.tns.maraton.util.FileUtil;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
	private static final String FILE_NAME = "julian3.jpeg";
	
	@InjectMocks
	private LoginController loginController;
	
	@Mock
	private LoginService loginService;
	
	@Mock
	private MultipartFile multipartFile;
	
	@Test
	public void getPingResponseTest() {
		PingResponse pingResponse = loginController.ping();
		assertEquals("Estás conectado!!", pingResponse.getMessage());
	}

}
