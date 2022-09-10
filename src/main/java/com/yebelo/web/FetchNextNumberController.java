package com.yebelo.web;

import com.yebelo.service.FetchNextNumberService;
import com.yebelo.web.model.FetchNextNumberInput;
import com.yebelo.web.model.FetchNextNumberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/FetchNextNumber")
public class FetchNextNumberController {

    @Autowired
    FetchNextNumberService fetchNextNumberServiceImpl;

    @PostMapping("")
    public ResponseEntity<Object> fetchNextNumber(@RequestBody FetchNextNumberInput fetchNextNumberInput) {
        List<Integer> valueList = fetchNextNumberServiceImpl.fetchNextNumber(fetchNextNumberInput.getCategoryCode());
        FetchNextNumberResponse fetchNextNumberResponse = FetchNextNumberResponse.builder()
                .oldValue(valueList.get(0))
                .newValue(valueList.get(1))
                .build();
        return ResponseEntity.ok().body(fetchNextNumberResponse);
    }
}
