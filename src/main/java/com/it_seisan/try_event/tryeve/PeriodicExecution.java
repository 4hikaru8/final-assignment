package com.it_seisan.try_event.tryeve;

import java.io.IOException;
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
import com.it_seisan.try_event.tryeve.service.ScrapingService;
@Component
public class PeriodicExecution {

    @Autowired
    EventService eventService;
    @Autowired
    ScrapingService scrapingService;

    @Scheduled(cron = "0 * * * * *", zone = "Asia/Tokyo")
    public void output1() throws IOException {
        List<Event> events = scrapingService.ScrapingTarget();
        // リスト型のオブジェクトを用意


        eventService.deleteData();  // 登録されているイベントデータを削除する
        eventService.save(events);  // 取得したデータをMySQLに保存する
    }
}
