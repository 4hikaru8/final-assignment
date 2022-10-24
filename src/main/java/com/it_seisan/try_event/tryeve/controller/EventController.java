package com.it_seisan.try_event.tryeve.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// import com.it_seisan.try_event.tryeve.dto.EventSearchRequest;
import com.it_seisan.try_event.tryeve.entity.Event;
import com.it_seisan.try_event.tryeve.service.EventService;

@Controller
@RequestMapping(value = "/")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping(value = "/")
    public String displayResult(Model model) {
        List<Event> events = new ArrayList<>();
        // String searchArea = "下京区";   // 検索したいエリアを代入する
        // events = eventService.selectEvent(searchArea);   // 検索表示
        events = eventService.selectAll(); // 全件表示
        model.addAttribute("events", events);
        return "index"; 
    }
}
