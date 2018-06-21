package com.edocGorty.Utils;

import com.aliyun.oss.OSSClient;
import org.apache.log4j.Logger;

import javax.imageio.stream.FileImageInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

/**
 * Created by AcY on 2018/5/9.
 */
public class OssClientUtil {
    static Logger logger = Logger.getLogger(OssClientUtil.class);
    //
    private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    //密钥
    private static String acessKeyId = "xx";
    private static String accessKeySecret = "xx";
    //要上传的文件地址
    private static String bucket = "fe-video";
    private static OssClientUtil ossClientUtil;
    String path="";

    public OssClientUtil() {
        super();
    }

    public static OssClientUtil newInstance() {
        if (ossClientUtil == null) {
            ossClientUtil = new OssClientUtil();
//如果存储空间为空 就创建一个新的
        }
        return ossClientUtil;
    }

    public static   String uploadPic(byte[] content, String keys) {
        //连接到OSS
        OSSClient ossClient = new OSSClient(endpoint, acessKeyId, accessKeySecret);
        ossClient.putObject(bucket, keys, new ByteArrayInputStream(content));
        String url = String.valueOf(getUrl(keys));
        ossClient.shutdown();
        //获得它上传后的url地址
        logger.info(url);
        logger.info("成功了ali");
        return url;
    }
    //
    public static URL getUrl(String key){
    OSSClient server=new OSSClient(endpoint,acessKeyId,accessKeySecret);
        Date expirations=new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);//为路径获取一个过期时间
        logger.info(expirations);
        URL url = server.generatePresignedUrl(bucket,key, expirations);
        server.getEndpoint();
        server.shutdown();
        return url;
    }
    /**
     *
     * @param path
     * @return
     */
    public static byte[] imsge2byte(String path) {
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[61858764];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
