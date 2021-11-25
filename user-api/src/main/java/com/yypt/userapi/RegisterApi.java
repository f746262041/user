package com.yypt.userapi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: IceBear
 * @Date: 2021/11/19 22:56
 * @Description:
 */
//@RequestMapping("/User")
public interface RegisterApi {

    @RequestMapping("/User/alive")
    public String alive();

    @RequestMapping("/User/register")
    public String register(@RequestParam("msg") String msg);

    @PostMapping("/User/postPerson")
    public Person postPerson(@RequestBody Person person);

}
