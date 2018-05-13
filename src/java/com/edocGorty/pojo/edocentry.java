package com.edocGorty.pojo;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Date;

/**
 * Created by AcY on 2018/3/5.
 */
public class edocentry {
    private Integer id;
    private Integer categoryId;
    private String title;
    private String summary;
    private  String uploaduser;
    private Date createdate;

    public edocentry() {
    }

    public edocentry(Integer id, Integer categoryId, String title, String summary, String uploaduser, Date createdate) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.summary = summary;
        this.uploaduser = uploaduser;
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "edocentry{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", uploaduser='" + uploaduser + '\'' +
                ", createdate=" + createdate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUploaduser() {
        return uploaduser;
    }

    public void setUploaduser(String uploaduser) {
        this.uploaduser = uploaduser;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
