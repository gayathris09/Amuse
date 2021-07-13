package com.cg.mts.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.mts.Exception.ActivityNotFoundException;
import com.cg.mts.Repository.IActivityRepository;
import com.cg.mts.Service.ActivityServiceImp;
import com.cg.mts.Service.IActivityService;
import com.cg.mts.dto.ActivityDto;
import com.cg.mts.entities.Activity;

@SpringBootTest
public class TestUpdateActivity {
	@Mock
	private IActivityRepository activityDao;

	@InjectMocks
	private IActivityService activityService = new ActivityServiceImp();

	@BeforeEach
	public void berforeEach() {
		when(activityDao.findById(1)).thenReturn(Optional.of(new Activity()));
		when(activityDao.findById(2)).thenReturn(Optional.empty());
		when(activityDao.save(any(Activity.class))).thenReturn(new Activity());

	}

	@Test
	public void testEditActivity1() throws ActivityNotFoundException {
		ActivityDto dto = new ActivityDto(1, 12.0F, "cabservices");

		assertNotNull(activityService.updateActivity(dto));

	}

	@Test
	public void testEditAddress3() throws ActivityNotFoundException {
		ActivityDto dto = new ActivityDto(1, 0.0F, "cabservices");
		assertThrows(ActivityNotFoundException.class, () -> activityService.updateActivity(dto));

	}

	@Test
	public void testEditAddress5() throws ActivityNotFoundException {
		ActivityDto dto = new ActivityDto(2, 12.0F, "cabservices");
		assertThrows(ActivityNotFoundException.class, () -> activityService.updateActivity(dto));

	}

}
