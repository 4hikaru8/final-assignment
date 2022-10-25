package com.it_seisan.try_event.tryeve.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class ScrapingService {

    public void ScrapingTarget() throws IOException {
        
        // // 検索する場所のワードを配列として用意
        // String wordArea[] = {"京都市左京区", "京都市右京区", "京都市上京区", "京都市中京区", "京都市下京区", "京都市南区",
        //                         "京都市伏見区", "京都市西京区", "京都市東山区", "京都市山科区", "京都市南区", "宇治市", "長岡京市", "八幡市"};
        // // 検索する種類のワードを配列として用意
        // String wordEvent[] = {"まつり", "祭", "イベント", "朝市"};

        Document document = Jsoup.connect("https://kyoto-design.jp/event").get();
        Elements event = document.getElementsByClass("wrap clearfix");
       
        List<String> titleList = new ArrayList<String>();
        List<String> dateList = new ArrayList<String>();
        List<String> collabo = new ArrayList<String>();
        int a = 0;


        for (Element course : event) {
            titleList.add(course.getElementsByClass("title").text());
            dateList.add(course.getElementsByClass("date nowrap").text());

            collabo.add(titleList.get(a) +"　開催期間："+ dateList.get(a));
            a++;
        }
        System.out.println(areaConversion("御香宮"));
    }

    public String areaConversion(String place) throws IOException {

        // google検索で場所を検索して住所を返す
        String area;
        Document document = Jsoup.connect("https://www.google.com/search?q=" + place + "%20住所").get();
        String eventAddress = document.getElementsByClass("sXLaOe").text();
        String[] addressSplits = eventAddress.split("\s|(?<=府)|(?<=市)|(?<=区)");

        if(addressSplits[2].equals("京都市")) {
            area = addressSplits[2] + addressSplits[3];
        }else{
            area = addressSplits[2];
        }

        return area;
    }
}
