package com.ford.security.controller;

import com.ford.security.domain.MapViewInfo;
import com.ford.security.response.Response;
import com.ford.security.response.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/map")
@Slf4j
public class MapViewHistoryController {

    @PostMapping("/record")
    public Response<List<MapViewInfo>> RecordViewHistory(@RequestBody List<MapViewInfo> mapViewInfoList) {
        String str = "xx";
        return ResponseUtil.success(mapViewInfoList);
    }

    @GetMapping("query")
    public Response<List<MapViewInfo>> Query() {
        List<MapViewInfo> mapViewInfoList = new ArrayList<>();
        return ResponseUtil.success(mapViewInfoList);
    }
}
