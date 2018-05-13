package com.edocGorty.Utils;


import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.apache.log4j.Logger;

/**
 * Created by AcY on 2018/5/9.
 */
public class QiNiuClientUtil {
    //logger
    static Logger logger = Logger.getLogger(QiNiuClientUtil.class);
    //keys
    public static final String ACCESS_KEY = "xx";
    public static final String SECRET_KEY = "xx";
    //要上传的空间的名字
    public static final String bucket ="xx" ;

    /**
     * 七牛文件上传
     * @param path
     */
    public static void qiniuUpload(String path,String keys) {
        UploadManager uploadManager =new UploadManager(new Configuration());
        //获取到密钥
        Auth auth=Auth.create(ACCESS_KEY,SECRET_KEY);
        //设置上传空间
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(path,keys,upToken);
            logger.info(response.bodyString());
            logger.info("成功了七牛");
        } catch (QiniuException e) {
            Response r = e.response;
            //异常信息
            logger.info(r.toString());
        }
    }
}
