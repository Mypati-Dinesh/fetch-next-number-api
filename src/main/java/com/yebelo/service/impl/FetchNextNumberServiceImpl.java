package com.yebelo.service.impl;

import com.yebelo.repository.FetchNextNumberRepository;
import com.yebelo.service.FetchNextNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchNextNumberServiceImpl implements FetchNextNumberService {

    @Autowired
    FetchNextNumberRepository fetchNextNumberRepositoryImpl;

    @Override
    public List<Integer> fetchNextNumber(String categoryCode) {
        Integer oldValue = fetchNextNumberRepositoryImpl.fetchValueByCategoryCode(categoryCode);
        return null;
    }
}
