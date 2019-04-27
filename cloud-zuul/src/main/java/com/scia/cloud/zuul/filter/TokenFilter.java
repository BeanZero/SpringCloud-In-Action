package com.scia.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.scia.base.entity.CodeStatus;
import com.scia.base.entity.Result;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author BeanZero
 * @date 2019-04-25
 */
@Component
public class TokenFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info("your request is {}, {}", request.getMethod(), request.getRequestURL().toString());
        String token = request.getParameter("token");
        if (StringUtils.isNotBlank(token)) {
            context.setSendZuulResponse(true);
            context.setResponseStatusCode(HttpStatus.OK.value());
            context.set("isSuccess", true);
        } else {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            context.getResponse().setContentType("text/html;charset=UTF-8");
            context.setResponseBody(new Result(CodeStatus.TOKENERROR.getValue(),
                    CodeStatus.TOKENERROR.getReasonPhrase()).toString());
            context.set("isSuccess", false);
        }
        return null;
    }

}
