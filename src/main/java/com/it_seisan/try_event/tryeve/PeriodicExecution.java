package com.it_seisan.try_event.tryeve;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.it_seisan.try_event.tryeve.entity.Event;
import com.it_seisan.try_event.tryeve.service.EventService;
/* 
    定期実行を行うクラス
 */
@Component
public class PeriodicExecution {

    @Autowired
    EventService eventService;

    @Scheduled(cron = "0 * * * * *", zone = "Asia/Tokyo")
    public void output1() {
        List<Event> events = new ArrayList<>();
        events.add(new Event("亀岡市", "くりまつり", "9月1日"));
        events.add(new Event("中京区", "古本市", "11月30日"));
        eventService.save(events);
        // System.out.println("hello");
    }
}
