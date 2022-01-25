package com.vbs.service;

import com.vbs.model.Court;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class CourtServiceTest {

    @Autowired
    private CourtService courtService;

    @Test
    void getCourtById() {
        long id = 1;
        Optional<Court> users = courtService.getUserById(id);
        String courtName = users.orElseThrow(NullPointerException::new).getName();
        assertEquals("諾亞方舟排球館", courtName);
    }

    @Test
    void saveCourt() {
        Court court = new Court("台中教育大學排球場", "台中市", "台中市西區民生路140號", 1);
        boolean bool = courtService.saveCourt(court);
        assertTrue(bool);
    }

    @Test
    void deleteCourtById() {
        long id = 1;
        boolean bool = courtService.deleteCourtById(id);
        assertTrue(bool);
    }

    @Test
    void updateCourt() {
        long id = 1;
        Court court = courtService.getUserById(id).orElseThrow(NullPointerException::new);
        court.setCountry("台中縣");
        courtService.updateCourt(court);

        //檢查是否有update進資料庫
        court = courtService.getUserById(id).orElseThrow(NullPointerException::new);
        String country = court.getCountry();
        assertEquals("台中縣", country);
    }

    @Test
    void listCourt() {
        List<Court> courts = courtService.listCourt();
    }
}