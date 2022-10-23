package com.it_seisan.try_event.tryeve.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it_seisan.try_event.tryeve.entity.Event;
import com.it_seisan.try_event.tryeve.repository.EventMapper;

@Service
public class EventService {

    @Autowired
    private EventMapper eventMapper;

    public List<Event> selectAll(String searchArea) {
        return eventMapper.selectAll(searchArea);
    }
}
