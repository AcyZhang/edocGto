package com.edocgorty;


import com.edocGorty.Utils.OssClientUtil;
import com.edocGorty.Utils.QiNiuClientUtil;
import org.junit.Test;

import java.io.IOException;

import static com.edocGorty.Utils.BDUtils.Filess;
import static com.edocGorty.Utils.OssClientUtil.imsge2byte;

/**
 * Created by AcY on 2018/5/10.
 */
public class UpLoadTset {
    /**
     * 文件上传到本地
     */
    @Test
    public void win() {
        String str1 = "E:\\photo\\moten.jpg";
        String str2 = "F:\\Test\\ssa.jpg";
        try {
            Filess(str1, str2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传文件阿里云测试
     */
    @Test
    public void ali() {
        OssClientUtil.uploadPic(imsge2byte("E:\\Photo\\moten.jpg"), "pic0001.jpg");

    }
    /**
     * 文件上传到七牛
     */
    @Test
    public void qiniu() {
        String path = "E:\\Photo\\GS.jpg";
        //
        String keys = "qiniu1.png";
        QiNiuClientUtil.qiniuUpload(path, keys);
    }
}



