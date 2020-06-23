package com.liaoxx.spring_hello.model;
import java.io.Serializable;

public class GoodsBrandModel implements Serializable {

    private long  id;

    private String name;

    private String summary;

    private String thumb;

    private String createTime;

    private String updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString(){
        return  "Brand:@id:"+this.getId()+";\r\n"
                +"@name: "+this.getName()+";\r\n"

                +"@summary: "+this.getSummary()+";\r\n"
                +"@thumb: "+this.getThumb()+";\r\n";

    }


}
