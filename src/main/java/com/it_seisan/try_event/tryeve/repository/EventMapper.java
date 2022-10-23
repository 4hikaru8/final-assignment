package com.it_seisan.try_event.tryeve.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.it_seisan.try_event.tryeve.entity.Event;

@Mapper
public interface EventMapper {

    public List<Event> selectAll();
}
