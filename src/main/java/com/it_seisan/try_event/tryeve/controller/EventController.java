package com.it_seisan.try_event.tryeve.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

// import com.it_seisan.try_event.tryeve.dto.EventSearchRequest;
import com.it_seisan.try_event.tryeve.entity.Event;
import com.it_seisan.try_event.tryeve.service.EventService;

@Controller
public class EventController {

    @Autowired
    EventService eventService;

    // @GetMapping(value = "/")
    // public String displaySearch(Model model) {
    //     model.addAttribute("eventSearchRequest", new EventSearchRequest());
    //     return "/";
    // }

    @GetMapping(value = "/")
    public String displayResult(Model model) {
        List<Event> events = new ArrayList<>();
        String searchArea = "伏見区";
        events = eventService.selectAll(searchArea);
        // events.add(new Event("伏見区", "まつり", "10月5日"));
        // events.add(new Event("左京区", "朝市", "1月5日"));
        // events.add(new Event("長岡京市", "ガラシャまつり", "12月23日"));
        model.addAttribute("events", events);
        return "index"; 
    }
}
