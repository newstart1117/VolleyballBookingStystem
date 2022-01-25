package com.vbs.service;

import com.vbs.model.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class ActivityServiceTest {

    @Autowired
    private ActivityService activityService;

    @Test
    void getActivityById() {
        long id = 1;
        Optional<Activity> activity = activityService.getActivityById(id);
        String activityName = activity.orElseThrow(NullPointerException::new).getName();
        assertEquals("歡樂老杯盃", activityName);
    }

    @Test
    void saveActivity() {
        Date start = new GregorianCalendar(2022, 01, 31, 14, 0).getTime();
        Date end = new GregorianCalendar(2022, 01, 31, 17, 0).getTime();
        Activity example = activityService.getActivityById(1).orElseThrow(NullPointerException::new);
        Activity activity = new Activity("測試開團", "測試開團的描述", "男網", "純男", start, end, example.getUser(), example.getCourt());
        boolean bool = activityService.saveActivity(activity);
        assertTrue(bool);
    }

    @Test
    void deleteActivityById() {
        long id = 1;
        boolean bool = activityService.deleteActivityById(id);
        assertTrue(bool);
    }

    @Test
    void updateActivity() {
        long id = 1;
        Activity activity = activityService.getActivityById(id).orElseThrow(NullPointerException::new);
        activity.setDescription("測試修改描述");
        activityService.updateActivity(activity);

        //檢查是否有update進資料庫
        activity = activityService.getActivityById(id).orElseThrow(NullPointerException::new);
        String description = activity.getDescription();
        assertEquals("測試修改描述", description);
    }

    @Test
    void listActivity() {
        List<Activity> courts = activityService.listActivity();
    }
}