package cn.tedu.sp09.impl;

import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.util.JsonResult;
import cn.tedu.sp09.feign.OrderFeignClient;
import org.springframework.stereotype.Component;

@Component
public class OrderFeignClientImpl implements OrderFeignClient {
    @Override
    public JsonResult<Order> getOrder(String orderId) {
        return JsonResult.err().msg("获取订单ID失败-sp09");
    }

    @Override
    public JsonResult addOrder() {
        return JsonResult.err().msg("新增订单失败-sp09");
    }
}
