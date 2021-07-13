package com.cg.mts.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.Exception.ActivityNotFoundException;
import com.cg.mts.Service.ActivityServiceImp;
import com.cg.mts.dto.ActivityDto;
import com.cg.mts.dto.SuccessMessageDto;
import com.cg.mts.entities.Activity;
import com.cg.mts.util.ActivityConstants;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ActivityController {

	@Autowired
	ActivityServiceImp activityService;

	/*
	 * Method Name : insertCab Parameter : activityDto Return Type : Activity Author
	 * Name: Gayathri S Created Date : 23-05-2021
	 */
	@PostMapping("/insertactivity")
	public SuccessMessageDto insertActivity(@RequestBody ActivityDto activityDto) throws ActivityNotFoundException {
		Activity activity = activityService.insertActivity(activityDto);
		return new SuccessMessageDto(ActivityConstants.ACTIVITY_ADDED + activity.getActivityId());
	}

	/*
	 * Method Name : viewActivity Parameter : No Parameter Return Type : List Author
	 * Name: Gayathri S Created Date : 24-05-2021
	 */
	@GetMapping("/getactivity")
	public List<Activity> viewActivity() throws ActivityNotFoundException {
		return activityService.viewActivities();

	}

	/*
	 * Method Name : viewActivityById Parameter : id Return Type : Activity Author
	 * Name: Gayathri S Created Date : 25-05-2021
	 */
	@GetMapping("/getactivitybyid/{id}")
	public Activity viewActivityById(@PathVariable("id") Integer id) throws ActivityNotFoundException {

		return activityService.viewActivityById(id);
	}

	/*
	 * Method Name : updateCab Parameter : add Return Type : SuccessMessageDto
	 * Author Name: Gayathri S Created Date : 26-05-2021
	 */
	@PutMapping("/updateactivity")
	public SuccessMessageDto updateActivity(@RequestBody ActivityDto add) throws ActivityNotFoundException {
		Activity activity = activityService.updateActivity(add);
		return new SuccessMessageDto(ActivityConstants.ADDRESS_UPDATED + activity.getActivityId());
	}

}