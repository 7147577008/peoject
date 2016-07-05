package com.it.entity;

/**
 * Created by Administrator on 2016/6/16.
 */
public class Docoment {
    private String filename;
    private String savename;
    private String md5;
    private String extname;
    private String displaysize;

    private Long size;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSavename() {
        return savename;
    }

    public void setSavename(String savename) {
        this.savename = savename;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getExtname() {
        return extname;
    }

    public void setExtname(String extname) {
        this.extname = extname;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }


    public String getDisplaysize() {
        return displaysize;
    }

    public void setDisplaysize(String displaysize) {
        this.displaysize = displaysize;
    }

    public boolean isPreview() {
        if (getFilename() == null) {
            return false;
        }
        if (getFilename().endsWith(".jpg") || getFilename().endsWith(".png") || getFilename().endsWith(".gif") || getFilename().endsWith(".pdf") || getFilename().endsWith(".bmp")) {
            return true;
        }
        return false;
    }
}
