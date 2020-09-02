package cn.tedu.sp01.service;

import cn.tedu.sp01.pojo.User;

/*
手敲这些代码
不要CV复制
 */
public interface UserService {
    //获取用户
    User getUser(Integer userId);

    //增加用户积分
    void addScore(Integer userId, Integer score);
}
