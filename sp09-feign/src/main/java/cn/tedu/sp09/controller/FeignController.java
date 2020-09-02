package cn.tedu.sp09.controller;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.util.JsonResult;
import cn.tedu.sp09.feign.ItemFeignClient;
import cn.tedu.sp09.feign.OrderFeignClient;
import cn.tedu.sp09.feign.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@Slf4j
public class FeignController {
    @Autowired
    private ItemFeignClient itemFeignCliemt;
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private OrderFeignClient orderFeignClient;
    @GetMapping("/item-service/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId){
        log.info("调用远程商品服务,获得订单列表-sp09");
        return itemFeignCliemt.getItems(orderId);
    }

    @PostMapping("/item-service/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items){
        log.info("调用远程服务,减少商品库存-sp09");
        return itemFeignCliemt.decrease(items);
    }

    @GetMapping("/user-service/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId){
        log.info("调用远程商品服务,获取用户Id-sp09");
        return userFeignClient.getUser(userId);
    }
    @GetMapping("/user-service/{userId}/score")
    public JsonResult addScore(@PathVariable Integer userId,@RequestBody Integer score){
        log.info("调用远程服务,添加用户积分-sp09");
        return userFeignClient.addScore(userId, score);
    }
    @GetMapping("/order-service/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId) {
        log.info("调用远程服务,获取订单ID-sp09");
        return orderFeignClient.getOrder(orderId);
    }

    @GetMapping("/order-service")
    public JsonResult addOrder() {
        log.info("调用远程服务,添加订单-sp09");
        return orderFeignClient.addOrder();
    }
}
