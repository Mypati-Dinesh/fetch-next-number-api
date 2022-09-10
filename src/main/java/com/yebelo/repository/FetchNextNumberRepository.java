package com.yebelo.repository;

public interface FetchNextNumberRepository {

    Integer fetchValueByCategoryCode(String categoryCode);

    Integer saveValueByCategoryCode(String categoryCode, Integer newValue);
}
