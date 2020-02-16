package com.ford.security.service;

import com.ford.security.entity.MapHistory;
import com.ford.security.mapper.MapHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapHistoryService {
    @Autowired
    private MapHistoryMapper mapHistoryMapper;

    public void add(List<MapHistory> mapHistoryList) {
        for (MapHistory history : mapHistoryList) {
            mapHistoryMapper.add(history);
        }
    }

    public List<MapHistory> query() {
        return mapHistoryMapper.getList();
    }
}
