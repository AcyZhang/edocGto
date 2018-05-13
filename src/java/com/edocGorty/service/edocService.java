package com.edocGorty.service;

import com.edocGorty.pojo.edoccategory;
import com.edocGorty.pojo.edocentry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by AcY on 2018/3/5.
 */
public interface edocService {
    List<edocentry> getInfo(Integer categoryId, Integer currentPageNo,
                            Integer pageSize);
    int Del(Integer id);
    int count(int categoryId);
}
