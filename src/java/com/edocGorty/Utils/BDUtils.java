package com.edocGorty.Utils;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by AcY on 2018/5/10.
 */
public class BDUtils {
    //logger
    static Logger logger = Logger.getLogger(BDUtils.class);
    public static void Filess(String srcPath, String destPath) throws IOException {
        // 打开输入流
        FileInputStream fis = new FileInputStream(srcPath);
        // 打开输出流
        FileOutputStream fos = new FileOutputStream(destPath);
        // 读取和写入信息
        int len = 0;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }
        // 关闭流
        logger.info("上传到本地");
        fos.close();
        fis.close();
    }
}
