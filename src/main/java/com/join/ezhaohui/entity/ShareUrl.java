package com.join.ezhaohui.entity;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * t_share_url
 * @author 
 */
public class ShareUrl implements Serializable {

    private Integer id;

    private Integer state;

    private String url;

    private Date uploadTime;

    private static final long serialVersionUID = 1L;

    public ShareUrl(String url){
        this.url = url;
    }

    public ShareUrl(int id,String url){
        this.id = id;
        this.url = url;
    }

    public ShareUrl(int id,int state){
        this.id = id;
        this.state = state;
    }
    
    public ShareUrl(Integer id,String url,Date uploadTime){
        this.id=id;
        this.url=url;
        this.uploadTime=uploadTime;
    }

    public ShareUrl(Integer id,String url,Date uploadTime,int state){
        this.id = id;
        this.url = url;
        this.uploadTime = uploadTime;
        this.state = state;
    }

    public ShareUrl(Integer id, String url, Date uploadTime, Integer state ) {
        this.id = id;
        this.state = state;
        this.url = url;
        this.uploadTime = uploadTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShareUrl shareUrl = (ShareUrl) o;
        return Objects.equals(id, shareUrl.id) &&
                Objects.equals(state, shareUrl.state) &&
                Objects.equals(url, shareUrl.url) &&
                Objects.equals(uploadTime, shareUrl.uploadTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, url, uploadTime);
    }

    @Override
    public String toString() {
        return "ShareUrl{" +
                "id=" + id +
                ", state=" + state +
                ", url='" + url + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
