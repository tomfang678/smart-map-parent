package com.ford.security.mapper;

import com.ford.security.domain.MapViewInfo;
import com.ford.security.entity.MapHistory;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MapHistoryMapper {

    int add(MapHistory mapViewInfo);

    List<MapHistory> getList();
}
