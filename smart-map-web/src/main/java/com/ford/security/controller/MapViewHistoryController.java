package com.ford.security.controller;

import com.ford.security.dao.MapHistoryService;
import com.ford.security.domain.MapViewInfo;
import com.ford.security.entity.MapHistory;
import com.ford.security.response.Response;
import com.ford.security.response.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/map")
@Slf4j
public class MapViewHistoryController {

    @Autowired
    private MapHistoryService mapHistoryService;

    /**
     * 记录最近的4s店和中石化加油站信息
     **/
    @PostMapping("/record")
    public Response<List<MapHistory>> RecordViewHistory(@RequestBody List<MapHistory> mapHistoryList) {
        mapHistoryService.add(mapHistoryList);
        return ResponseUtil.success(mapHistoryList);
    }

    /**
     * 统计查询最频繁的数据
     **/
    @GetMapping("query")
    public Response<List<MapHistory>> Query() {
        List<MapHistory> mapViewInfoList = mapHistoryService.query();
        return ResponseUtil.success(mapViewInfoList);
    }
}
