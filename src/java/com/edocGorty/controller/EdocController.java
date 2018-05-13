package com.edocGorty.controller;



import com.edocGorty.pojo.edocentry;
import com.edocGorty.service.edocService;
import com.edocGorty.common.Constants;
import com.edocGorty.common.PageSupport;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by AcY on 2018/3/5.
 */
@Controller
@RequestMapping("/edoc")
public class EdocController {
    @Resource
    private edocService edocService;

    @RequestMapping(value = "/inde",method = RequestMethod.GET)
    public String getInfos(@RequestParam(value = "categoryId",defaultValue = "0") Integer categoryId, HttpSession session,
                           @RequestParam(value="pageIndex",required=false) String pageIndex,
                            Model model){
        List<edocentry> edoc=null;
        int pageSize = Constants.pageSize;

        //当前页码
        Integer currentPageNo = 1;
        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch (NumberFormatException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        //总数量（表）
        int totalCount = 0;
        try {
            totalCount = edocService.count(categoryId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PageSupport pages = new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();
        //控制首页和尾页
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }
        try {
            edoc=edocService.getInfo(categoryId,(pages.getCurrentPageNo() - 1) * pageSize,pageSize);


            session.setAttribute("list",edoc);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute("pages", pages);
        System.out.println(edoc);
         return "sss";
    }
    @RequestMapping(value = "/inDel",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> DelInfo(@RequestParam(value = "id",defaultValue = "0") Integer id){
        int mun=edocService.Del(id);
        Map<String,String> map=new HashMap<String, String>();
        System.out.println("-------------"+id);//4
if (mun>=1){
    map.put("messag","1");
    return map;
}else {
    map.put("messag","0");
}
        return map;
    }
}
