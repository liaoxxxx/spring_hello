package com.liaoxx.spring_hello.util;

import com.alibaba.fastjson.JSON;
import com.liaoxx.spring_hello.component.Audience;
import com.liaoxx.spring_hello.entity.Admin;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.*;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：pyy
 * Date：2019/7/17 17:24
 * Version: v1.0
 * ========================
 */
@Component
public class JwtTokenUtil {
    private static Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);
    public static final String AUTH_HEADER_KEY = "Authorization";

    @Autowired
    Base64Util base64Util;

    /**
     * 解析jwt
     * @param jsonWebToken
     * @param base64Security
     * @return
     */
    public static Claims parseJWT(String jsonWebToken, String base64Security) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (ExpiredJwtException  eje) {
            log.error("===== Token过期 =====", eje);

        } catch (Exception e){
            log.error("===== token解析异常 =====", e);
        }
        return null;
    }
    /**
     * 构建jwt
     * @param userId
     * @param username
     * @param role
     * @param audience
     * @return
     */
    public static String createJWT(Admin admin, List role, Audience audience) {
        try {
            // 使用HS256加密算法
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
            long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);
            //生成签名密钥
            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(audience.getBase64Secret());
            Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

            //添加构成JWT的参数
            JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                    // 可以将基本不重要的对象信息放到claims
                    .claim("roles", role)
                    .claim("userId", admin.getId())
                    .claim("name", admin.getNickname())
                    .claim("avatar", admin.getAvatars())
                    .claim("introduction",admin.getAvatars())
                    .setSubject(admin.getUsername())           // 代表这个JWT的主体，即它的所有人
                    .setIssuer(audience.getClientId())              // 代表这个JWT的签发主体；
                    .setIssuedAt(new Date())        // 是一个时间戳，代表这个JWT的签发时间；
                    .setAudience(audience.getName())          // 代表这个JWT的接收对象；
                    .signWith(signatureAlgorithm, signingKey);
            //添加Token过期时间
            int TTLMillis = audience.getExpiresSecond();
            if (TTLMillis >= 0) {
                long expMillis = nowMillis + TTLMillis;
                Date exp = new Date(expMillis);
                builder.setExpiration(exp)  // 是一个时间戳，代表这个JWT的过期时间；
                        .setNotBefore(now); // 是一个时间戳，代表这个JWT生效的开始时间，意味着在这个时间之前验证JWT是会失败的
            }
            //log.info(builder.toString());
            //生成JWT
            return builder.compact();
        } catch (Exception e) {
            log.error("签名失败", e);
           return  "签名失败";
        }
    }
    /**
     * 从token中获取用户名
     * @param token
     * @param base64Security
     * @return
     */
    public static String getUsername(String token, String base64Security){
        return Objects.requireNonNull(parseJWT(token, base64Security)).getSubject();
    }
    /**
     * 从token中获取用户ID
     * @param token
     * @param base64Security
     * @return
     */
    public static String getUserId(String token, String base64Security){
        return Objects.requireNonNull(parseJWT(token, base64Security)).get("userId", String.class);
    }

    /**
     * 从token中获取用户ID
     * @param token
     * @param base64Security
     * @return
     */
    public static String getRoles(String token, String base64Security){
        return Objects.requireNonNull(parseJWT(token, base64Security)).get("roles", String.class);
    }
    /**
     * 是否已过期
     * @param token
     * @param base64Security
     * @return
     */
    public static boolean isExpiration(String token, String base64Security) {
        return Objects.requireNonNull(parseJWT(token, base64Security)).getExpiration().before(new Date());
    }

    public static boolean checkToken(String token, String base64Secret){
        System.out.println();
        Claims claims=parseJWT(token,base64Secret);
        String iss =claims.getIssuer();
        String sub =claims.getSubject();
        String clientAudience =claims.getAudience();


        String jti =claims.getId();

        if (claims.getExpiration().getTime()>  System.currentTimeMillis()

        )
        {
            return true;
        }
        return  false;
    }


    public static  Map<String,Object> getPayload(String token) throws UnsupportedEncodingException {
        //eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6W3sicm9sZU5hbWUiOiJhZG1pbiJ9LHsicm9sZU5hbWUiOiJmaW5hbmNlIn0seyJyb2xlTmFtZSI6ImVkaXRvciJ9XSwidXNlcklkIjoxLCJzdWIiOiJhZG1pbiIsImlzcyI6IjA5OGY2YmNkNDYyMWQzNzNjYWRlNGU4MzI2MjdiNGY2IiwiaWF0IjoxNTgyNDY0MTA5LCJhdWQiOiJsb2NhbGhvc3QiLCJleHAiOjE1ODI0NjQyODIsIm5iZiI6MTU4MjQ2NDEwOX0.Xj-HaFassQLpoN2lzxUFuI55aS9tTMmANz-zJOZOZ10
        String payloadAnsSign= token.substring(token.indexOf('.')+1); //第一次裁剪掉 jwt 的hearder 部分 余下 ：payload.sign
        String payloadBase64=payloadAnsSign.substring(0,payloadAnsSign.indexOf('.')); ///第一次裁剪掉 jwt 的sign 部分 余下 ：payload
        String payloadJson=new String(Base64.getDecoder().decode(payloadBase64), "utf-8");; //base64 解码获得 payload 的json字符串

        return   JSON.parseObject(payloadJson); //转换成  jwtPayloadEntity
    }
}
