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
        List<Event> events = new ArrayList<>(); // リスト型のオブジェクトを用意

        // サンプルデータ
        events.add(new Event("城陽市", "五里五里まつり", "6月12日"));
        events.add(new Event("京都市下京区", "下賀茂まつり", "12月11日"));
        events.add(new Event("長岡京市", "ガラシャ祭り", "11月13日"));
        events.add(new Event("京都市北区", "とれたて朝市", "毎週土曜日6：00～"));

        scrapingService.ScrapingTarget();

        eventService.deleteData();  // 登録されているイベントデータを削除する
        eventService.save(events);  // 取得したデータをMySQLに保存する
    }
}
