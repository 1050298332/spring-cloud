package cn.tedu.sp09.impl;

import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.util.JsonResult;
import cn.tedu.sp09.feign.UserFeignClient;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientImpl implements UserFeignClient {
    @Override
    public JsonResult<User> getUser(Integer userId) {
        return JsonResult.err().msg("获取用户信息-sp09");
    }

    @Override
    public JsonResult addScore(Integer userId, Integer score) {
        return JsonResult.err().msg("获取商品订单失败-sp09");
    }
}
