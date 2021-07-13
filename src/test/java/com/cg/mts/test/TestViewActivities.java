package com.cg.mts.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.mts.Exception.ActivityNotFoundException;
import com.cg.mts.Repository.IActivityRepository;
import com.cg.mts.Service.ActivityServiceImp;
import com.cg.mts.Service.IActivityService;
import com.cg.mts.entities.Activity;

@SpringBootTest
public class TestViewActivities {
	@Mock
	private IActivityRepository activityDao;

	@InjectMocks
	private IActivityService activityService = new ActivityServiceImp();

	@BeforeEach
	public void berforeEach() {
		when(activityDao.findById(3)).thenReturn(Optional.of(new Activity()));
		when(activityDao.findById(4)).thenReturn(Optional.empty());
	}

	@Test
	public void testViewActivityById1() throws ActivityNotFoundException {
		assertNotNull(activityService.viewActivityById(3));
	}

	@Test
	public void testViewActivityById2() throws ActivityNotFoundException {
		assertThrows(ActivityNotFoundException.class, () -> activityService.viewActivityById(4));
	}

	@Test
	public void testViewActivityById3() throws ActivityNotFoundException {
		assertThrows(ActivityNotFoundException.class, () -> activityService.viewActivities());
	}

}
