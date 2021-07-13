package com.cg.mts.Service;

import java.util.List;

import com.cg.mts.Exception.ActivityNotFoundException;
import com.cg.mts.dto.ActivityDto;
import com.cg.mts.entities.Activity;

public interface IActivityService {

	public Activity insertActivity(ActivityDto activityDto) throws ActivityNotFoundException;

	public Activity updateActivity(ActivityDto activityDto) throws ActivityNotFoundException;

	public List<Activity> viewActivities() throws ActivityNotFoundException;

	public Activity viewActivityById(Integer activityId) throws ActivityNotFoundException;
}
