package com.vbs.service;

import com.vbs.model.ActivityRegistration;
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
class RegistrationServiceTest {

    @Autowired
    private RegistrationService registrationService;

    @Test
    void getRegistrationById() {
        long id = 1;
        Optional<ActivityRegistration> registration = registrationService.getRegistrationById(id);
        int status = registration.orElseThrow(NullPointerException::new).getStatus();
        assertEquals(2, status);
    }

    @Test
    void saveRegistration() {
        Date start = new GregorianCalendar(2022, 01, 31, 14, 0).getTime();
        Date end = new GregorianCalendar(2022, 01, 31, 17, 0).getTime();
        ActivityRegistration example = registrationService.getRegistrationById(1).orElseThrow(NullPointerException::new);
        ActivityRegistration registration = new ActivityRegistration(2, example.getUser(), example.getActivity());
        boolean bool = registrationService.saveRegistration(registration);
        assertTrue(bool);
    }

    @Test
    void deleteRegistrationById() {
        long id = 1;
        boolean bool = registrationService.deleteRegistrationById(id);
        assertTrue(bool);
    }

    @Test
    void updateRegistration() {
        long id = 1;
        ActivityRegistration registration = registrationService.getRegistrationById(id).orElseThrow(NullPointerException::new);
        registration.setStatus(1);
        registrationService.updateRegistration(registration);

        //檢查是否有update進資料庫
        registration = registrationService.getRegistrationById(id).orElseThrow(NullPointerException::new);
        int status = registration.getStatus();
        assertEquals(1, status);
    }

    @Test
    void listRegistration() {
        List<ActivityRegistration> courts = registrationService.listRegistration();
    }
}