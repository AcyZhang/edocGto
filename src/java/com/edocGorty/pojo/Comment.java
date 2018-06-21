package com.edocGorty.pojo;

import java.io.Serializable;

/**
 * Created by AcY on 2018/5/20.
 */
public class Comment implements Serializable {
    private int id;//id
    private String comm_name;//商品名称
    private String comm_price;//价格
    private String comm_pl;//评价

    private int provider_type;//类型
private String provider_name;
    private String file;//图片
    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public Comment(int id, String comm_name, String comm_price, String comm_pl, int provider_type, String provider_name, String file) {
        this.id = id;
        this.comm_name = comm_name;
        this.comm_price = comm_price;
        this.comm_pl = comm_pl;
        this.provider_type = provider_type;
        this.provider_name = provider_name;
        this.file=file;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comm_name='" + comm_name + '\'' +
                ", comm_price='" + comm_price + '\'' +
                ", comm_pl='" + comm_pl + '\'' +
                ", provider_type=" + provider_type +
                ", provider_name='" + provider_name + '\'' +
                ", file='" + file + '\'' +
                '}';
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComm_name() {
        return comm_name;
    }

    public void setComm_name(String comm_name) {
        this.comm_name = comm_name;
    }

    public String getComm_price() {
        return comm_price;
    }

    public void setComm_price(String comm_price) {
        this.comm_price = comm_price;
    }

    public String getComm_pl() {
        return comm_pl;
    }

    public void setComm_pl(String comm_pl) {
        this.comm_pl = comm_pl;
    }

    public int getProvider_type() {
        return provider_type;
    }

    public void setProvider_type(int provider_type) {
        this.provider_type = provider_type;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
