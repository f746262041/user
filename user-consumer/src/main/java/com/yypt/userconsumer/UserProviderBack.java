package com.yypt.userconsumer;

import com.yypt.userapi.Person;
import com.yypt.userapi.RegisterApi;
import org.springframework.stereotype.Component;

/**
 * @Auther: IceBear
 * @Date: 2021/11/23 23:26
 * @Description:
 */
@Component
public class UserProviderBack implements RegisterApi {
    @Override
    public String alive() {
        System.out.println("降级啦。。。。。。。");
        return "降级啦！！！";
    }

    @Override
    public String register(String msg) {
        return null;
    }

    @Override
    public Person postPerson(Person person) {
        return null;
    }
}
