package com.kaishengit.web.entity;

/**
 * Created by Administrator on 2016/6/17.
 */
public class Movie {

    private String title;
    private String rate;
    private String releaseyear;
    private String sendtime;
    private String daoyan;
    private String jianjie;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(String releaseyear) {
        this.releaseyear = releaseyear;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public String getDaoyan() {
        return daoyan;
    }

    public void setDaoyan(String daoyan) {
        this.daoyan = daoyan;
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", rate='" + rate + '\'' +
                ", releaseyear='" + releaseyear + '\'' +
                ", sendtime='" + sendtime + '\'' +
                ", daoyan='" + daoyan + '\'' +
                ", jianjie='" + jianjie + '\'' +
                '}';
    }
}
