package com.it_seisan.try_event.tryeve.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.it_seisan.try_event.tryeve.entity.Event;

@Service
public class ScrapingService {

    public List<Event> ScrapingTarget() throws IOException {
        
        // // 検索する場所のワードを配列として用意
        // String wordArea[] = {"京都市左京区", "京都市右京区", "京都市上京区", "京都市中京区", "京都市下京区", "京都市南区",
        //                         "京都市伏見区", "京都市西京区", "京都市東山区", "京都市山科区", "京都市南区", "宇治市", "長岡京市", "八幡市"};
        // // 検索する種類のワードを配列として用意
        // String wordEvent[] = {"まつり", "祭", "イベント", "朝市"};

        Document document = Jsoup.connect("https://kyoto-design.jp/event").get();
        Elements event = document.getElementsByClass("wrap clearfix");
       
        List<Event> events = new ArrayList<Event>();
        String area;
        String name;
        String date;




        for (Element course : event) {

            area = course.getElementsByClass("place").text();
            name = course.getElementsByClass("title").text();
            date = course.getElementsByClass("date nowrap").text();

            events.add(new Event(area,name,date));
            
        }
        return events;
    }

}
