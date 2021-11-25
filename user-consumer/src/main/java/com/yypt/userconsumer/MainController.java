package com.yypt.userconsumer;

import com.yypt.userapi.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: IceBear
 * @Date: 2021/11/19 21:09
 * @Description:
 */
@RestController
public class MainController {

    @Autowired
    UserApi api;

    @GetMapping("/alive")
    public String alive() {
        return api.alive();
    }

    @GetMapping("/register")
    public String register() {
        return api.register("icebear");
    }

//    @Autowired
//    MashibingApi mapi;


//    @GetMapping("/vip")
//    public String vip() {
//
//        return mapi.getVip();
//    }

    @GetMapping("/map")
    public Map<Integer, String> map(Integer id) {
        System.out.println(id);
        return api.getMap(id);
    }

    @GetMapping("/map2")
    public Map<Integer, String> map2(Integer id, String name) {
        System.out.println(id);
        return api.getMap2(id, name);
    }


    @GetMapping("/map3")
    public Map<Integer, String> map3(@RequestParam Map<String, Object> map) {
        map.put("id", 111);
        map.put("name", "猪八戒");
        System.out.println("map3_" + map);
        return api.getMap3(map);
    }


    @GetMapping("/map4")
    public Map<Integer, String> map4(@RequestParam Map<String, Object> map) {
        System.out.println("map4");
        map.put("id", 777);
        map.put("name", "小九九");
        System.out.println(map);
        return api.postMap(map);
    }

    @GetMapping("/postperson")
    public Person postperson(@RequestParam Map<String, Object> map) {
        Person person = new Person();
        person.setId(Integer.parseInt(map.get("id").toString()));
        person.setName("sssss");
        return api.postPerson(person);
    }
}
