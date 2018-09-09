package com.sunxu.domain;

import org.springframework.core.convert.converter.Converter;

/**
 * @author 孙许
 * @date 2018/09/09
 */
public class StringToUserConverter implements Converter<String, User> {

    /**
     * Spring希望这个类型转换体系替换java标准的PropertyEditor
     * 对于同一个类型对象来说，如果既在ConversionService中装配了自定义转换器，又通过
     * WebBindingInitializer装配了自定义编辑器，同时还在控制器中通过@InitBinder装配了
     * 自定义编辑器，那么SpringMVC将按照优先顺序查找对应类型的编辑器
     * 1.查询通过@InitBinder装配的自定义编辑器
     * 2.查询通过ConversionService装配的自定义转换器
     * 3.查询通过WebBindingInitializer装配的自定义编辑器
     * @param source
     * @return
     */
    @Override
    public User convert(String source) {
        User user = new User();
        if (source != null) {
            String[] items = source.split(":");
            user.setUserName(items[0]);
            user.setPassword(items[1]);
            user.setRealName(items[2]);
        }
        return user;
    }
}
