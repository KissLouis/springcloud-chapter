package com.louis.springcloud.zuul.server.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Louis
 * @title: AuthFilter
 * @projectName springcloud-chapter
 * @description: TODO
 * @date 2020/1/5 19:56
 */
public class AuthFilter extends ZuulFilter {
  @Override
  public String filterType() {
    // pre 路由前,route 路由时,post 路由完毕,error 发生错误时
    // 在请求被路由之前调用
    return "pre";
  }

  @Override
  public int filterOrder() {
    // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    // 是否执行该过滤器，此处为true，说明需要过滤
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    // 过滤器具体业务代码
    RequestContext currentContext = RequestContext.getCurrentContext();
    HttpServletRequest request = currentContext.getRequest();

    String token = request.getParameter("token"); // 获取请求的参数
    // 如果有token参数并且token值为miniooc，才进行路由
    if (StringUtils.isNotBlank(token) && token.equals("miniooc")) {
      currentContext.setSendZuulResponse(true); // 对请求进行路由
      currentContext.setResponseStatusCode(200);
      currentContext.set("code", 1);
    } else {
      currentContext.setSendZuulResponse(false); // 不对其进行路由
      currentContext.setResponseStatusCode(401);
      HttpServletResponse response = currentContext.getResponse();
      response.setHeader("content-type", "text/html;charset=utf8");
      currentContext.setResponseBody("网关认证失败，停止路由");
      currentContext.set("code", 0);
    }
    return null;
  }
}
