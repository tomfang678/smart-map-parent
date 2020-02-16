package com.ford.security;

import com.alibaba.fastjson.JSON;
import com.ford.security.entity.MapHistory;
import com.ford.security.mapper.MapHistoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("dev")
public class MapHistoryServiceTest {
    @Resource
    private MapHistoryMapper mapHistoryMapper;

    @Test
    public void addTest() {
        MapHistory mapHistory = new MapHistory();
        String jsonStr = "{\"title\":\"中国石化加油站(北凯旋路店)\",\"point\":\"125.319787，43.968519\",\"url\":\"http://map.baidu.com/?s=inf%26uid%3D6a57e3155763ec2e4c3a59b4%26c%3D53&i=0&sr=1\",\"detailUrl\":\"http://api.map.baidu.com/place/detail?uid=6a57e3155763ec2e4c3a59b4&output=html&source=jsapi\",\"address\":\"近郊北凯旋路10号\",\"city\":\"长春市\",\"province\":\"吉林省\",\"type\":0,\"isAccurate\":false,\"distance\":\"1931.55\",\"keyword\":\"中石化加油站\",\"tag\":1}";
        mapHistory = JSON.parseObject(jsonStr, MapHistory.class);
        Integer reuslt = mapHistoryMapper.add(mapHistory);
        if (reuslt > 0) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(true);
        }
    }

    @Test
    public void queryTest() {
        List<MapHistory> mapHistoryList = mapHistoryMapper.getList();
        Assert.assertNotNull(mapHistoryList);
    }
}
