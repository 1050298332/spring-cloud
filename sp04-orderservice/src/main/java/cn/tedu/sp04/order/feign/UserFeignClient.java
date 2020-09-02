package cn.tedu.sp04.order.feign;

import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.util.JsonResult;
import cn.tedu.sp04.order.feign.FB.UserFeignClientFB;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service",fallback = UserFeignClientFB.class)
public interface UserFeignClient {

    @GetMapping("/{userId}")
    JsonResult<User> getUser(@PathVariable Integer userId);

    // 拼接路径 /{userId}/score?score=新增积分
    @GetMapping("/{userId}/score")
    JsonResult addScore(@PathVariable Integer userId, @RequestParam Integer score);
}
