package com.edocGorty.controller;


import com.edocGorty.Utils.osaUtils;
import com.edocGorty.common.Constants;
import com.edocGorty.common.ExcelImportUtil;
import com.edocGorty.common.PageSupport;
import com.edocGorty.pojo.User;
import com.edocGorty.pojo.edocentry;
import com.edocGorty.pojo.img;
import com.edocGorty.service.edocService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;




/**
 * Created by AcY on 2018/3/5.
 */
@Controller
@RequestMapping("/edoc")
public class EdocController {
    @Resource
    private edocService edocService;

    @RequestMapping(value = "/inde", method = RequestMethod.GET)
    public String getInfos(@RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId, HttpSession session,
                           @RequestParam(value = "pageIndex", required = false) String pageIndex,
                           Model model) {
        List<edocentry> edoc = null;
        int pageSize = Constants.pageSize;

        //当前页码
        Integer currentPageNo = 1;
        if (pageIndex != null) {
            try {
                currentPageNo = Integer.valueOf(pageIndex);
                System.out.println(currentPageNo+"========="+pageIndex);
            } catch (NumberFormatException e) {
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
        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }
        try {
            edoc = edocService.getInfo(categoryId, (pages.getCurrentPageNo() - 1) * pageSize, pageSize);


            session.setAttribute("list", edoc);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute("pages", pages);
        System.out.println(edoc);
        return "sss";
    }

    @RequestMapping(value = "/inDel", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> DelInfo(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        int mun = edocService.Del(id);
        Map<String, String> map = new HashMap<String, String>();
        System.out.println("-------------" + id);//4
        if (mun >= 1) {
            map.put("messag", "1");
            return map;
        } else {
            map.put("messag", "0");
        }
        return map;
    }
   @RequestMapping("/upload")
   @ResponseBody
    public Object up(img img, @RequestParam(value = "file", required = false)
           MultipartFile file) {
       osaUtils osaUtils = new osaUtils();
       String name = null;
       try {
           name = osaUtils.uploadImg2Oss(file);
           String imgUrl = osaUtils.getImgUrl(name);
           System.out.println("asdsfdgfhghjg" + imgUrl);
            img.setImgPicPath(imgUrl);
           if (edocService.upload(img) > 0) {
               // http://fe-video.oss-cn-beijing.aliyuncs.com/pic0005.jpg?Expires=1842952341&OSSAccessKeyId=LTAIHnUCvJa806Cv&Signature=b0uG%2FBE4%2B%2Frv70xq97NQXZnzbK0%3D
              // http://fe-video.oss-cn-beijing.aliyuncs.com/fe-video/1527931569595.jpg?Expires=1843291562&OSSAccessKeyId=LTAIHnUCvJa806Cv&Signature=%2BJ78Qy4Vtx%2FuHVuVUb%2FPXTniSAY%3D
               return "sss";
           } else {
               return "upload";
           }
       } catch (Exception e) {
           e.printStackTrace();
       }

      return "upload";
   }






    @RequestMapping(value="/excel", method=RequestMethod.POST)
    @ResponseBody
    public void exportSysUsers(HttpServletRequest req,HttpServletResponse res,
                               String title, String summary, String uploaduser) throws IOException{
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("title", "".equals(title) || null == title ? null : title);
        params.put("summary", "".equals(summary) || null == summary ? null : summary);
        params.put("uploaduser", "".equals(uploaduser) || null == uploaduser ? null : uploaduser);

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String formatTime = sdf.format(d);
        String fileName="系统用户表-"+formatTime;
        //填充projects数据
        List<edocentry> userList = edocService.getList(params);
        List<Map<String,Object>> list=createExcelRecord(userList);
        String columnNames[]={"姓名", "邮箱", "电话"};//列名
        String keys[] = {"name", "username", "email"};//map中的key
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ExcelImportUtil.createWorkBook(list,keys,columnNames).write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        res.reset();
        res.setContentType("application/vnd.ms-excel;charset=utf-8");
        res.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = res.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
    }

    /**
     * 生成Excel数据
     * @param userList
     * @return
     */
    private List<Map<String, Object>> createExcelRecord(List<edocentry> userList) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        edocentry user = null;
        for (int j = 0; j < userList.size(); j++) {
            user = userList.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            mapValue.put("title", user.getTitle());

            mapValue.put("summary", user.getSummary());
            mapValue.put("uploaduser", user.getUploaduser());
            listmap.add(mapValue);
        }
        return listmap;
    }
}
