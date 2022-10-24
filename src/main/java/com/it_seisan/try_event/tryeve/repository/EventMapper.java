package com.it_seisan.try_event.tryeve.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.it_seisan.try_event.tryeve.entity.Event;

@Mapper
public interface EventMapper {

    public List<Event> selectAll();

    public List<Event> selectEvent(String seachArea);

    public void save(@Param("eventList")List<Event> events);

    public void deleteData();
}
