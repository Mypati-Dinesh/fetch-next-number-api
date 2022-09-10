package com.yebelo.web;

import com.yebelo.service.FetchNextNumberService;
import com.yebelo.web.model.FetchNextNumberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path ="/FetchNextNumber")
public class FetchNextNumberController {

    @Autowired
    FetchNextNumberService fetchNextNumberServiceImpl;

    @GetMapping("")
    public ResponseEntity<Object> fetchNextNumber(String categoryCode) {
        List<Integer> valueList = fetchNextNumberServiceImpl.fetchNextNumber(categoryCode);
        FetchNextNumberResponse fetchNextNumberResponse = FetchNextNumberResponse.builder()
                .oldValue(valueList.get(0))
                .newValue(valueList.get(1))
                .build();
        return ResponseEntity.ok().body(fetchNextNumberResponse);
    }
}
