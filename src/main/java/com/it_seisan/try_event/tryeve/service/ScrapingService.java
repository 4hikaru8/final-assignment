package com.it_seisan.try_event.tryeve.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

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


        // KYOTOdesignサイトからのスクレイピング
        Document Kyotoevent = Jsoup.connect("https://kyoto-design.jp/event").get();
        Elements event = Kyotoevent.getElementsByClass("wrap clearfix");
       
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

        // おすすめ京都体験オスキョー（朝市のサイト）からのスクレイピング
        Document document = Jsoup.connect("http://taiken.onozomi.com/marche_list/").get();
        Elements allSc = document.getElementsContainingOwnText("【場所】");
        Elements asaichAllTitle = document.getElementsByClass("entry-stitle");
        
        String asaichContain = allSc.text();

        List<String> ptag = new ArrayList<String>(Arrays.asList(asaichContain.split("【",0)));

        // 中身初期化
        area = null;
        name = null;
        date = null;

        List<String> asaichTitleList = new ArrayList<String>();
        List<String> asaichDateList = new ArrayList<String>();
        List<String> asaichAreaList = new ArrayList<String>();

         // 朝市のタイトルをタイトルリストに入れる
        for (Element asaichtitle : asaichAllTitle){
           
            asaichTitleList.add(asaichtitle.text());            
        }

        // 朝市の情報をそれぞれのリストに入れる 
        for(int i = 0; i < ptag.size(); i++){
            if(ptag.get(i).startsWith("場所")){
                asaichAreaList.add(ptag.get(i));
            }else 
            if(ptag.get(i).startsWith("日程")){
                asaichDateList.add(ptag.get(i));
            }

        }

        // リストに格納した情報をeventsに入れる
        for(int i = 0; i < asaichDateList.size();i++){
            area = asaichAreaList.get(i);
            name = asaichTitleList.get(i);
            date = asaichDateList.get(i);

            events.add(new Event(area, name, date));
        }

        return events;


    }

}
