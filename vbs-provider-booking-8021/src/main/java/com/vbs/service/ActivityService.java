package com.vbs.service;

import com.vbs.model.Activity;
import com.vbs.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Optional<Activity> getActivityById(long id){
        return activityRepository.findById(id);
    }

    public boolean saveActivity(Activity activity){
        activityRepository.save(activity);
        return  true;
    }

    public boolean deleteActivityById(Long id){
        Activity activity = activityRepository.getById(id);
        if(activity == null){
            return false;
        }
        activityRepository.delete(activity);
        return true;
    }

    public boolean updateActivity(Activity activity){
        if(activityRepository.findById(activity.getId()) == null){
            return false;
        }
        activityRepository.save(activity);
        return  true;
    }

    public List<Activity> listActivity(){
        return activityRepository.findAll();
    }


}
