package com.edocGorty.dao;


import com.edocGorty.pojo.edocentry;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AcY on 2018/3/5.
 */
@Repository
public interface EdocMapper {
    List<edocentry>  getInfo(@Param("categoryId") Integer categoryId,
    @Param(value="from")Integer currentPageNo,
                             @Param(value="pageSize")Integer pageSize);
    int Del(@Param("id") Integer id);
     Integer count(@Param("categoryId") int categoryId);
}
