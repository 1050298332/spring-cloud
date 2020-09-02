package cn.tedu.sp04.order.feign.FB;

import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.util.JsonResult;
import cn.tedu.sp04.order.feign.UserFeignClient;
import org.springframework.stereotype.Component;


@Component
public class UserFeignClientFB implements UserFeignClient {

    @Override
    public JsonResult<User> getUser(Integer userId) {
        if(Math.random()<0.4) {
            return JsonResult.ok(new User(userId, "缓存name"+userId, "缓存pwd"+userId));
        }
        return JsonResult.err("无法获取用户信息");
    }

    @Override
    public JsonResult addScore(Integer userId, Integer score) {
        return JsonResult.err("无法增加用户积分");
    }

}
