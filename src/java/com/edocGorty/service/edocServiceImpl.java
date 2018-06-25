package com.edocGorty.service;

import com.edocGorty.dao.EdocMapper;
import com.edocGorty.pojo.Comment;
import com.edocGorty.pojo.User;
import com.edocGorty.pojo.edocentry;
import com.edocGorty.pojo.img;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by AcY on 2018/3/5.
 */
@Service
public class edocServiceImpl implements edocService {
    @Resource
    private EdocMapper edocMapper;
    public List<edocentry> getInfo(Integer categoryId, Integer currentPageNo,
                                   Integer pageSize) {
        return edocMapper.getInfo(categoryId,currentPageNo,pageSize);
    }
    public int Del(Integer id) {
        return edocMapper.Del(id);
    }
    public int count(int categoryId) {
        return edocMapper.count(categoryId);
    }
    public int upload(img img) {
        return edocMapper.upload(img);
    }
    public List<edocentry> getList(Map<String, Object> params) {
        return edocMapper.getList(params);
    }
}
