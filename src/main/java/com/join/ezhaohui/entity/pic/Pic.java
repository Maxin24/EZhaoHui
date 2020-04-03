package com.join.ezhaohui.entity.pic;

public class Pic {
    private int id;
    private String desc;
    private String url;
    private String pic_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    @Override
    public String toString() {
        return "pic{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", url='" + url + '\'' +
                ", pic_url='" + pic_url + '\'' +
                '}';
    }
}
