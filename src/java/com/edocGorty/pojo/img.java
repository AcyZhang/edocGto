package com.edocGorty.pojo;

/**
 * Created by AcY on 2018/6/2.
 */
public class img {
    private int id;
    private String imgPicPath;
    private String name;
    private String imgs;

    @Override
    public String toString() {
        return "img{" +
                "id=" + id +
                ", imgPicPath='" + imgPicPath + '\'' +
                ", name='" + name + '\'' +
                ", imgs='" + imgs + '\'' +
                '}';
    }

    public img(int id, String imgPicPath, String name, String imgs) {
        this.id = id;
        this.imgPicPath = imgPicPath;
        this.name = name;
        this.imgs = imgs;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public img() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgPicPath() {
        return imgPicPath;
    }

    public void setImgPicPath(String imgPicPath) {
        this.imgPicPath = imgPicPath;
    }


}
