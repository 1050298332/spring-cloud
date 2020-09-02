package cn.tedu.sp11.filter;

import cn.tedu.sp01.util.JsonResult;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AccessFilter extends ZuulFilter{
    /*
    * 过滤器类型：pre,post,routing,error
    * */

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    /*顺序号*/
    @Override
    public int filterOrder() {
        return 6;   //为什么指定第6个位置,在默认过滤器中 5执行了上下文对象中添加了service-id
        //所以在5后才能从上下文对象访问到service-id
    }
    /*对当前请求是否要进行过滤      true会执行run方法 是要进行过滤
        反之 返回false 会跳过过滤代码 继续执行后面的流程
        */
    @Override
    public boolean shouldFilter() {
        //判断用户请求的是否是商品服务,如果是商品服务进行过滤，其他服务不过滤
        RequestContext ctx = RequestContext.getCurrentContext();
        Object serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
        return "item-service".equals(serviceId);
    }
    /*过滤方法
    * 他的返回值:
    * 在当前zuul版本中没有启用,返回任何数据都无效*/
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)){
            //没有token阻止这次调用继续执行
            ctx.setSendZuulResponse(false);
            //在这里直接向客户端发送响应
            //JsonResult:{code:400,msg:没登录,data:null}
            ctx.setResponseStatusCode(JsonResult.NOT_LOGIN);
            ctx.setResponseBody(JsonResult.err().code(JsonResult.NOT_LOGIN).msg("NOT LOGIN").toString());

        }
        return null;//在当前zuul版本中没有启用,返回任何数据都无效
    }
}
