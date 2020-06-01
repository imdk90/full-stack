package com.movit.apigateway;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLogginFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("inside run method of zuul api gateway");

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		System.out.println(request.getRequestURI());

		logger.info("Request " + request.getRequestURI() + " service id" + ctx.get("serviceId"));
		/*
		 * RequestContext ctx = RequestContext.getCurrentContext(); HttpServletRequest
		 * request = ctx.getRequest(); System.out.println(request.getRequestURI());
		 * Map<String, List<String>> qps = new HashMap<String, List<String>>(); // copy
		 * request param map Map<String, String[]> qpmap = request.getParameterMap(); //
		 * for (Map.Entry<String, String[]> entry : qpmap.entrySet()) { String key1 =
		 * "id"; String[] values1 = {"1"}; String key2 = "password"; String[] val =
		 * {"123"}; qps.put(key1, Arrays.asList(values1)); qps.put(key2,
		 * Arrays.asList(val)); //s } ctx.setRequestQueryParams(qps);
		 * 
		 * //ctx.setRequestQueryParams(qp);
		 * 
		 * // ctx.setRequestQueryParams(qp); // requestQueryParams.put(key, value)
		 * Map<String, List<String>> requestQueryParams = ctx.getRequestQueryParams();
		 * for (Map.Entry<String, List<String>> entry : requestQueryParams.entrySet()) {
		 * String key = entry.getKey(); List<String> val1= entry.getValue();
		 * System.out.println(key +" & "+ val1); }
		 * 
		 * route(r -> r.query("refer", "email") .uri("lb://FIRST-SERVICE/") //downstream
		 * endpoint lb - load balanced .id("first-service")) .build();
		 * 
		 * // ctx.put("serviceId", "movit-login-service");
		 */ return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	/*
	 * @Override public boolean shouldFilter() { return true; }
	 * 
	 * @Override public Object run() throws ZuulException { // HttpServletRequest
	 * request = RequestContext.getCurrentContext().getRequest();
	 * System.out.println("Inside logging filer");
	 * 
	 * 
	 * logger.info("Request is -> {} and request uri -> {}",
	 * request.getHeaderNames().toString(), request.getRequestURI());
	 * 
	 * RequestContext ctx = RequestContext.getCurrentContext(); HttpServletRequest
	 * request = ctx.getRequest();
	 * 
	 * 
	 * URL previousrouteHost = ctx.getRouteHost(); Object serviceId =
	 * ctx.get("movit-login-service"); ctx.put("serviceId", "movit-login-service");
	 * 
	 * 
	 * String previousUri = request.getRequestURI();
	 * 
	 * String contextUri = (String) ctx.get("requestURI");
	 * 
	 * if (previousUri != null && isFilterRequiredForIam(previousUri)) { try {
	 * previousUri = previousUri.replace("/mps", "");
	 * 
	 * ctx.setRouteHost(new
	 * URL("http://localhost:8765/movit-login-service/user/login-feign/1/123"));
	 * 
	 * //ctx.put("requestURI", "movit-login-service/user/login-feign/1/123");
	 * ctx.put("serviceId", "movit-login-service"); previousUri = ""; } catch
	 * (Exception e) { System.out.println("exception "); } } else {
	 * ctx.set("serviceId", "movit-login-service"); }
	 * 
	 * System.out.println("url------------------------" +
	 * ctx.getRequest().getRequestURL().toString());
	 * 
	 * return null; }
	 * 
	 * @Override public String filterType() { return "pre"; }
	 * 
	 * @Override public int filterOrder() { return 1; }
	 * 
	 * private boolean isFilterRequiredForIam(String uri) { if
	 * (uri.contains("/mps")) return true; else return false; }
	 * 
	 * private boolean isFilterRequiredFor(String uri) { if
	 * (uri.contains("/movit-login-service/")) return true; else return false; }
	 * 
	 */}
