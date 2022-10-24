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
        List<Event> events = new ArrayList<>(); // リスト型のオブジェクトを用意

        // サンプルデータ
        events.add(new Event("城陽市", "五里五里まつり", "6月12日"));
        events.add(new Event("下京区", "下賀茂まつり", "12月11日"));


        eventService.deleteData();  // 登録されているイベントデータを削除する
        eventService.save(events);  // 取得したデータをMySQLに保存する
    }
}
