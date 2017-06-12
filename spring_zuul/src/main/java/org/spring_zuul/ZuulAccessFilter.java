package org.spring_zuul;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulAccessFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory
			.getLogger(ZuulAccessFilter.class);

	@Override
	public boolean shouldFilter() {

		return true;
	}

	@Override
	public Object run() {

		RequestContext rctx = RequestContext.getCurrentContext();
		HttpServletRequest request = rctx.getRequest();
		logger.info("send method: {} request to url: {}", request.getMethod(),
				request.getRequestURI());

		String accessToken = request.getParameter("accessToken");

		if (accessToken == null || !accessToken.equals("rss123")) {

			logger.info("accessToken: {} verify failed!", accessToken);
			rctx.setSendZuulResponse(false);
			rctx.setResponseStatusCode(401);
			rctx.setResponseBody("accessToken: " + accessToken
					+ " verify failed!");
			return null;
		}

		logger.info("accessToken: {} verify is ok.", accessToken);

		return null;
	}

	@Override
	public String filterType() {

		return "pre";
	}

	@Override
	public int filterOrder() {

		return 0;
	}

}
