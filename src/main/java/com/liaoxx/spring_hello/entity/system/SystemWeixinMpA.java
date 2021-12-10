package com.liaoxx.spring_hello.entity.system;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class SystemWeixinMpA implements Serializable {

  @Getter
  @Setter
  @JSONField(name = "appid")
  @JsonProperty("appid")
  public String  appId   ;

  @Getter
  @Setter
  @JSONField(name = "secret")
  @JsonProperty("secret")
  public String  secret  ;

  @Getter
  @Setter
  @JSONField(name = "appkey")
  @JsonProperty("appkey")
  public String  appKey  ;


  @Getter
  @Setter
  @JSONField(name = "mch_id")
  @JsonProperty("mch_id")
  public String  mchId  ;

  @Getter
  @Setter
  @JSONField(name = "examine")
  @JsonProperty("examine")
  public String  examine;

  @Getter
  @Setter
  @JSONField(name = "uid")
  @JsonProperty("uid")
  public String  uid   ;

  @Override
  public String toString(){
    return  "---------SystemWeixinMpA toString------:"+ JSON.toJSONString(this);
  }
}
