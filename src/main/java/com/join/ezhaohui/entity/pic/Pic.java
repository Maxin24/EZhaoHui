package com.join.ezhaohui.entity.pic;

public class Pic {
    private int id;
    private String descr;
    private String url;
    private String pic_url;
    private int rank;

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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String desc) {
        this.descr = desc;
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
                ", descr='" + descr + '\'' +
                ", url='" + url + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
