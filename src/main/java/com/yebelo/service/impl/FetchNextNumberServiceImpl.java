package com.yebelo.service.impl;

import com.yebelo.repository.FetchNextNumberRepository;
import com.yebelo.service.FetchNextNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FetchNextNumberServiceImpl implements FetchNextNumberService {

    @Autowired
    FetchNextNumberRepository fetchNextNumberRepositoryImpl;

    @Override
    public List<Integer> fetchNextNumber(String categoryCode) {
        Integer oldValue = fetchNextNumberRepositoryImpl.fetchValueByCategoryCode(categoryCode);
        String oldValueString = Integer.toString(oldValue);
        int newValue = 0;
        int sum =0;
        for(int i=0; i<=oldValueString.length()-1; i++){
            sum = sum + oldValueString.charAt(i);
        }
        if(sum == 1) {
            newValue = oldValue + 9;
        } else {
            
        }
        fetchNextNumberRepositoryImpl.saveValueByCategoryCode(categoryCode, newValue);
        List<Integer> valueList = new ArrayList<>();
        valueList.add(oldValue);
        valueList.add(newValue);
        return valueList;
    }
}
