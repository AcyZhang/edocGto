package com.edocgorty;
import static com.edocGorty.Utils.QiALiClientUtil.upload;

/**
 * Created by AcY on 2018/5/9.
 */
public class QiALiTest {

    public static void main(String[] args) {
        //上传文件地址
        String path = "E:\\Photo\\GS.jpg";
        String keys = "pic0031.jpg";
        String srcPath = "E:\\photo\\moten.jpg";
        String destPath = "F:\\Test\\ss.jpg";
        String chose = "1";
        upload(chose, path, keys, srcPath, destPath);
    }

}




