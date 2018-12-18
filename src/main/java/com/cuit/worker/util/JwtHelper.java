package com.cuit.worker.util;


import com.cuit.worker.model.Audience;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

@Component
public class JwtHelper {
    private static Logger log=LoggerFactory.getLogger(JwtHelper.class);
    @Autowired
    private Audience audience;

    public String CreateJWT(int userId){
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + audience.getExpireTime()*1000);
        return Jwts.builder().setHeaderParam("typ","JWT")
                .claim("userId",userId)
                .setIssuedAt(nowDate)
                .signWith(SignatureAlgorithm.HS256,audience.getBase64Secret())
                .setExpiration(expireDate)
                .compact();
    }
    public Claims getClaimByToken(String Token){
        if (StringUtils.isEmpty(Token)){
            return null;
        }
        try {
           return Jwts.parser().setSigningKey(audience.getBase64Secret()).parseClaimsJws(Token).getBody();
        }catch (Exception e){
            log.debug("Token 验证失败");
        }
        return null;
    }
    public  boolean isTokenExpired(Date expiration){
        return expiration.before(new Date());
    }

}
