package cn.tedu.sp09.impl;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.util.JsonResult;
import cn.tedu.sp09.feign.ItemFeignClient;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ItemFeignClientImpl implements ItemFeignClient {
    @Override
    public JsonResult<List<Item>> getItems(String orderId) {
        return JsonResult.err().msg("获取订单列表失败-sp09");
    }

    @Override
    public JsonResult decrease(List<Item> items) {
        return JsonResult.err().msg("添加用户积分失败-sp09");
    }
}
