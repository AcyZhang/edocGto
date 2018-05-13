package com.edocGorty.Utils;

import com.edocgorty.QiALiTest;
import org.apache.log4j.Logger;

import static com.edocGorty.Utils.BDUtils.Filess;

/**
 * Created by AcY on 2018/5/11.
 */
public class QiALiClientUtil {
    static Logger logger = Logger.getLogger(QiALiTest.class);
    private enum sel {
        ali, qiniu, ben
    };
    /**
     * 文件上传
     *
     * @param path
     * @param keys
     * @param srcPath
     * @param destPath
     */
    public static void upload(String chose, String path, String keys, String srcPath, String destPath) {
        sel m = null;
        if (chose == "1") {
            m = sel.ali;
        } else if (chose == "2") {
            m =sel.qiniu;
        } else {
            m =sel.ben;
        }
        switch (m) {
            case ali:
                //上传图片的地址
                OssClientUtil.uploadPic(OssClientUtil.imsge2byte(path), keys);
                break;
            case qiniu:
                QiNiuClientUtil.qiniuUpload(path, keys);
                break;
            case ben:
                try {
                    Filess(srcPath, destPath);
                } catch (Exception e) {
                    //throw Exception(e);
                }
                break;
        }
    }
}
