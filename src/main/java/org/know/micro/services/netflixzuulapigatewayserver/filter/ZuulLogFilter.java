package org.know.micro.services.netflixzuulapigatewayserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author KnowGroup
 */
@Component
public class ZuulLogFilter extends ZuulFilter{

    final Log LOG = LogFactory.getLog(this.getClass());
    
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
            LOG.info(request.getRequestURI());
        return this.getClass().getName();
    }

}
