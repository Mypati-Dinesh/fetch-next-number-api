package com.yebelo.repository.impl;

import com.yebelo.repository.FetchNextNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FetchNextNumberRepositoryImpl implements FetchNextNumberRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer fetchValueByCategoryCode(String categoryCode) {
        String sql="SELECT CATEGORY_VALUE FROM CATEGORY WHERE CATEGORY_CODE=:categoryCode ;";
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("categoryCode", categoryCode);
        return namedParameterJdbcTemplate.query(sql, parameter, (rs, rowNum)-> rs.getInt("CATEGORY_VALUE")).get(0);
    }

    @Override
    public Integer saveValueByCategoryCode(String categoryCode, Integer newValue) {
        String sql = "UPDATE CATEGORY SET CATEGORY_VALUE = ? WHERE CATEGORY_CODE=? ;";
        Object[] updateCategory = {
                newValue,
                categoryCode
        };
        return jdbcTemplate.update(sql, updateCategory);
    }
}
