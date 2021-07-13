package com.cg.mts.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.Exception.ActivityNotFoundException;
import com.cg.mts.Repository.IActivityRepository;
import com.cg.mts.dto.ActivityDto;
import com.cg.mts.entities.Activity;
import com.cg.mts.util.ActivityConstants;

@Service
public class ActivityServiceImp implements IActivityService {
	@Autowired
	IActivityRepository activityDao;

	/*
	 * Method Name : insertCab Parameter : activityDto Return Type : Activity Author
	 * Name: Gayathri S Created Date : 23-05-2021
	 */
	@Override
	public Activity insertActivity(ActivityDto activityDto) throws ActivityNotFoundException {
		validateActivity(activityDto);
		Activity activity = new Activity();
		Optional<Activity> optActivity = activityDao.findById(activityDto.getActivityId());
		if (optActivity.isPresent())
			throw new ActivityNotFoundException(ActivityConstants.ACTIVITY_ALREADY_FOUND);

		activity.setActivityId(activityDto.getActivityId());
		activity.setDescription(activityDto.getDescription());
		activity.setCharges(activityDto.getCharges());
		return activityDao.save(activity);
	}

	/*
	 * Method Name : validateActivity Parameter : activityDto Return Type : boolean
	 * Author Name: Gayathri S Created Date : 28-05-2021
	 */
	public boolean validateActivity(ActivityDto activityDto) throws ActivityNotFoundException {
		if (activityDto.getCharges() <= 0)
			throw new ActivityNotFoundException(ActivityConstants.ACTIVITY_CHARGE_GREATER);

		return true;
	}

	/*
	 * Method Name : updateCab Parameter : activityDto Return Type : Activity Author
	 * Name: Gayathri S Created Date : 26-05-2021
	 */
	@Override
	public Activity updateActivity(ActivityDto activityDto) throws ActivityNotFoundException {
		validateActivity(activityDto);
		Optional<Activity> optActivity = activityDao.findById(activityDto.getActivityId());
		if (!optActivity.isPresent())
			throw new ActivityNotFoundException(ActivityConstants.ACTIVITY_NOT_FOUND);

		Activity activity = optActivity.get();
		activity.setActivityId(activityDto.getActivityId());
		activity.setDescription(activityDto.getDescription());
		activity.setCharges(activityDto.getCharges());
		return activityDao.save(activity);

	}

	/*
	 * Method Name : viewActivities Parameter : No Parameter Return Type : List
	 * Author Name: Gayathri S Created Date : 24-05-2021
	 */
	@Override
	public List<Activity> viewActivities() throws ActivityNotFoundException {
		List<Activity> activitylist = activityDao.findAll();
		if (activitylist.isEmpty())
			throw new ActivityNotFoundException(ActivityConstants.ACTIVITY_NOT_FOUND);
		activitylist.sort((a1, a2) -> a1.getActivityId().compareTo(a2.getActivityId()));
		return activitylist;
	}

	/*
	 * Method Name : viewActivityById Parameter : activityId Return Type : Activity
	 * Author Name: Gayathri S Created Date : 25-05-2021
	 */
	@Override
	public Activity viewActivityById(Integer activityId) throws ActivityNotFoundException {
		Optional<Activity> optactivity = activityDao.findById(activityId);
		if (!optactivity.isPresent()) {
			throw new ActivityNotFoundException(ActivityConstants.ACTIVITY_NOT_FOUND);

		}
		return optactivity.get();
	}

}
