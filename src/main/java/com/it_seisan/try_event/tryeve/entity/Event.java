package com.it_seisan.try_event.tryeve.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Event {

    // エリア
    private String event_area;
    // イベント名   
    private String event_name;
    // イベント日時
    private String event_date;
    
}
