package com.edocGorty.dao;


import com.edocGorty.pojo.Comment;
import com.edocGorty.pojo.User;
import com.edocGorty.pojo.edocentry;
import com.edocGorty.pojo.img;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
     int upload(img img);
    List<edocentry> getList(Map<String,Object> params);
}
