package com.cg.mts.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.mts.Exception.ActivityNotFoundException;
import com.cg.mts.Repository.IActivityRepository;
import com.cg.mts.Service.ActivityServiceImp;
import com.cg.mts.Service.IActivityService;
import com.cg.mts.dto.ActivityDto;
import com.cg.mts.entities.Activity;

@SpringBootTest
public class TestInsertActivity {

	@Mock
	IActivityRepository activityRepo;

	@InjectMocks
	IActivityService activityService = new ActivityServiceImp();

	@BeforeEach
	public void beforeEach() {
		when(activityRepo.findById(1)).thenReturn(Optional.of(new Activity()));
		when(activityRepo.findById(2)).thenReturn(Optional.empty());

	}

	@Test
	public void testActivtiy1() throws ActivityNotFoundException {
		ActivityDto activityDto = new ActivityDto(1, 12.0F, "chargesdescription");
		assertThrows(ActivityNotFoundException.class, () -> activityService.insertActivity(activityDto));
	}

	@Test
	public void testActivtiy2() throws ActivityNotFoundException {
		ActivityDto activityDto = new ActivityDto(2, 13.0F, "cabRequirementdescription");
		assertNull(activityService.insertActivity(activityDto));
	}

	@Test
	public void testActivtiy3() throws ActivityNotFoundException {
		ActivityDto activityDto = new ActivityDto(2, 00.0F, "cabRequirementdescription");
		assertThrows(ActivityNotFoundException.class, () -> activityService.insertActivity(activityDto));
	}
}
