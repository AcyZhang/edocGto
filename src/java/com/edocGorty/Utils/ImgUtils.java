package com.edocGorty.Utils;

import com.alibaba.druid.sql.visitor.functions.Now;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;

/**
 * Created by AcY on 2018/5/31.
 */
public class ImgUtils {
   private String  path;
   private String defaultPath="E:\\photo\\";
    private String fileName;
    private String defaultName="GuiCamera";
    static int serialNum=0;
    private String imageFormat;//图像文件的格式
    private String defaultImageFormat="jpg";
    Dimension d=Toolkit.getDefaultToolkit().getScreenSize();

    public  ImgUtils(){
        fileName=defaultName;
        imageFormat=defaultImageFormat;
        path=defaultPath;
    }

    public ImgUtils(String s,String format,String p) {
        fileName=s;
        imageFormat=format;
        path=p;
    }
    /**
     * 对屏幕进行拍照
     *
     * **/
    public void snapshot(){
        try {
            //拷贝屏幕到一个BufferedImage对象screenshot
            BufferedImage screenshot=(new Robot()).createScreenCapture(
                    new Rectangle(0,0,(int)d.getWidth(),(int)d.getHeight()));
//           serialNum=(int)(Math.random()*100);

            serialNum ++;
//            if (serialNum<)
            //根据文件前缀变量和文件格式变量，自动生成文件名
            path +=fileName+String.valueOf(serialNum)+"."+imageFormat;
            System.out.println(path);
            File f=new File(path);
            System.out.println("Save File-"+path);
            //将screenshot对象写入图像文件
            ImageIO.write(screenshot, imageFormat, f);
            System.out.println("..Finished");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        ImgUtils cam=new ImgUtils();
        cam.snapshot();
        System.out.println("嘿嘿哈嘿吼");
    }
}
