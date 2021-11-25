package com.yypt.userconsumer;

import com.yypt.userapi.RegisterApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 方式一：不结合eureka，就是自定义一个client名字，就用url属性指定服务器列表：url="http://ip:port/"
 * <p>
 * 方式二：和Restemplate,需要跨语言才使用
 */
//@FeignClient(name = "xxoo", url = "http://localhost:7788")
//public interface UserApi {
//    @GetMapping("/alive")
//    public String alive();
//}

/**
 * 方式二：和Restemplate,需要跨语言才使用
 */
//@FeignClient(name = "user-provider")
//public interface UserApi {
//    @GetMapping("/alive")
//    public String alive();
//}

/**
 * 方式三 api 引入
 * 这里的接口就是为了让feignClient介入，拦截到请求
 */
@FeignClient(name = "user-provider", fallbackFactory = UserProviderBackFactory.class)
public interface UserApi extends RegisterApi {

    /**
     * 这里的@getMapping是给Feign看的
     * @RequestParam 也是给Feign看的
     * @param id
     * @return
     */
    @GetMapping("/getMap")
    Map<Integer, String> getMap(@RequestParam("id") Integer id);

    @GetMapping("/getMap2")
    Map<Integer, String> getMap2(@RequestParam("id") Integer id, @RequestParam("name") String name);

    @GetMapping("/getMap3")
    Map<Integer, String> getMap3(@RequestParam Map<String, Object> map);

    @PostMapping("/postMap")
    Map<Integer, String> postMap(Map<String, Object> map);

}
