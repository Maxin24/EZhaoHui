package com.join.ezhaohui.entity;

public class Pic {
    private int id;
    private String url;
    private String pic_url;
    private int rank;
    private String cdesc;

    public String getDesc() {
        return cdesc;
    }

    public void setDesc(String desc) {
        this.cdesc = desc;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Pic{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
