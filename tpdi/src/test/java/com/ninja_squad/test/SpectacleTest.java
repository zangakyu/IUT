package com.ninja_squad.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ninja_squad.controller.SpectacleService;
import com.ninja_squad.dao.SpectacleDAO;

public class SpectacleTest {
	
	public SpectacleDAO mockedSpectacleDAO;
	public SpectacleService spectacleController;
	
	@Before
	public void init() {
		mockedSpectacleDAO = mock(SpectacleDAO.class);
		spectacleController = new SpectacleService(mockedSpectacleDAO);
	}

	@Test
	public void testControllerFindSpectacle() throws IOException {
		List<String> list = new ArrayList<String>();
		list.add("test");
		when(mockedSpectacleDAO.getSpectacles()).thenReturn(list);

		assertEquals(list.get(0),spectacleController.findSpectacle("test").get(0));

	}
	
	@Test
	public void testControllerCreateSpectacleMethodCalled() throws IOException{
		SpectacleDAO mockedSpectacleDAO = mock(SpectacleDAO.class);
		SpectacleService spectacleController = new SpectacleService(mockedSpectacleDAO);
		
		spectacleController.createSpectale("créer spectacle");
		verify(mockedSpectacleDAO).writeSpectacle("spectacle");
	}

	@Test
	public void testControllerCreateSpectacleReturnsTrue() throws IOException{
		SpectacleDAO mockedSpectacleDAO = mock(SpectacleDAO.class);
		SpectacleService spectacleController = new SpectacleService(mockedSpectacleDAO);
		
		assertTrue(spectacleController.createSpectale("créer spectacle"));
	}
	
}
