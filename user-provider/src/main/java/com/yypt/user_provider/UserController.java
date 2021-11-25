package com.yypt.user_provider;

import com.yypt.userapi.Person;
import com.yypt.userapi.RegisterApi;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: IceBear
 * @Date: 2021/11/19 20:49
 * @Description:
 */
@RestController
public class UserController implements RegisterApi {
    private AtomicInteger count = new AtomicInteger();
    @Value("${server.port}")
    String port;

    @Override
    public String alive() {
        try {
            System.out.println("准备睡觉。。。。。。");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = count.getAndIncrement();
        System.out.println(port + "=====第" + i + "次调用");

        return "port:" + port;
    }

    @Override
    public String register(String msg) {
        return msg + "_register-----";
    }


    @GetMapping("/getMap")
    public Map<Integer, String> getMap(@RequestParam("id") Integer id) {
        System.out.println(id);
        return Collections.singletonMap(id, "mmeme");
    }

    @GetMapping("/getMap2")
    public Map<Integer, String> getMap2(Integer id, String name) {
        System.out.println(id);
        return Collections.singletonMap(id, name);
    }

    @GetMapping("/getMap3")
    public Map<Integer, String> getMap3(@RequestParam Map<String, Object> map) {
        System.out.println(map);
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
    }


    @PostMapping("/postMap")
    public Map<Integer, String> postMap(@RequestBody Map<String, Object> map) {
        System.out.println(map);
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
    }


    @Override
    public Person postPerson(Person person) {
        System.out.println(ToStringBuilder.reflectionToString(person));
        return person;
    }


}
