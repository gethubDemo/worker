package com.cuit.worker.util.Interceptor;

import com.cuit.worker.model.Message;
import com.cuit.worker.util.JwtHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.alibaba.fastjson.JSONObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Component
public class RequestInterceptor implements HandlerInterceptor {
    private static Logger log=LoggerFactory.getLogger(RequestInterceptor.class);
    //存储不需要拦截的url
    private static final String[] IGNORE_URI = {"/user/login"};
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private Message message;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        String servletPath=request.getServletPath();
        log.info("请求路径："+servletPath);
        //遍历数组确定该路径是否需要拦截
        for(String str:IGNORE_URI){
            if(servletPath.contains(str)){
                flag=true;
                log.info("该请求不需要拦截！");
            }
        }
        if (!flag) {
            try {
                String token = request.getHeader("Authorization");
                token.isEmpty();//if语句无法判断，他要抛出异常，暂时用try
                try {
                    Date tokenTime = jwtHelper.getClaimByToken(token).getExpiration();
                    if (jwtHelper.isTokenExpired(tokenTime)) {
                        log.info("Token 过期");
                        message.setCode(1);
                        message.setMsg("Token过期");
                        JSONObject object = (JSONObject) JSONObject.toJSON(message);
                        returnJson(response,object);
                    } else {
                        log.info("Token 验证成功");
                        flag = true;
                    }
                } catch (Exception e) {
                    log.info("Token获取失败");
                    message.setCode(1);
                    message.setMsg("Token不存在");
                    JSONObject object = (JSONObject) JSONObject.toJSON(message);
                    returnJson(response,object);
                }
            }catch (Exception e){
                message.setMsg("无Token");
                message.setCode(2);
                JSONObject object = (JSONObject) JSONObject.toJSON(message);
                returnJson(response,object);
            }
        }
        return flag;
    }
    private void returnJson(HttpServletResponse response,JSONObject mes) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = null;
        try {
             writer = response.getWriter();
             writer.print(mes);
        }catch (Exception e){
            log.error("输出错误");
        }finally {
            if (writer != null){
                writer.close();
            }
        }

    }
}
