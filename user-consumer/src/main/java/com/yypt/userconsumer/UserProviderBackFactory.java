package com.yypt.userconsumer;

import com.yypt.userapi.Person;
import feign.hystrix.FallbackFactory;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Auther: IceBear
 * @Date: 2021/11/24 22:51
 * @Description:
 */
@Component
public class UserProviderBackFactory implements FallbackFactory<UserApi> {
    @Override
    public UserApi create(Throwable cause) {
        return new UserApi() {
            @Override
            public Map<Integer, String> getMap(Integer id) {
                return null;
            }

            @Override
            public Map<Integer, String> getMap2(Integer id, String name) {
                return null;
            }

            @Override
            public Map<Integer, String> getMap3(Map<String, Object> map) {
                return null;
            }

            @Override
            public Map<Integer, String> postMap(Map<String, Object> map) {
                return null;
            }

            @Override
            public String alive() {
                System.out.println(cause);
                System.out.println(ToStringBuilder.reflectionToString(cause));
                cause.printStackTrace();
                return "hahahahah";
            }

            @Override
            public String register(String msg) {
                return null;
            }

            @Override
            public Person postPerson(Person person) {
                return null;
            }
        };
    }
}
