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
    //获取全部信息
    List<edocentry>  getInfo(@Param("categoryId") Integer categoryId,
    @Param(value="from")Integer currentPageNo,
                             @Param(value="pageSize")Integer pageSize);
    //根据id来删除信息
    int Del(@Param("id") Integer id);
    //查询有多少条数据
     Integer count(@Param("categoryId") int categoryId);
     //上传图片
     int upload(img img);
     //导出excel 未实现
    List<edocentry> getList(Map<String,Object> params);
}
