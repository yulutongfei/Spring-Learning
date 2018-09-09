package com.sunxu.controller;

import com.sunxu.domain.User;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.junit.Assert.*;

/**
 * @author 孙许
 * @date 2018/09/09
 * @description
 */
public class UserControllerTest {

    @Test
    public void handle51() {
        RestTemplate restTemplate = buildRestTemplate();
        User user = new User();
        user.setUserName("tom");
        user.setPassword("1234");
        user.setRealName("汤姆");

        HttpHeaders entityHeaders = new HttpHeaders();
        entityHeaders.setContentType(MediaType.valueOf("application/xml;UTF-8"));
        entityHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

        HttpEntity<User> requestEntity = new HttpEntity<>(user, entityHeaders);
        ResponseEntity<User> responseEntity = restTemplate.exchange("http://localhost:8080/user/handle51",
                HttpMethod.POST, requestEntity, User.class);

        User responseUser = responseEntity.getBody();
        Assert.assertNotNull(responseUser);
        Assert.assertEquals("汤姆", responseUser.getRealName());
    }

    private RestTemplate buildRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
        xStreamMarshaller.setStreamDriver(new StaxDriver());
        xStreamMarshaller.setAnnotatedClasses(new Class[]{User.class});

        MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();
        xmlConverter.setMarshaller(xStreamMarshaller);
        xmlConverter.setUnmarshaller(xStreamMarshaller);
        restTemplate.getMessageConverters().add(xmlConverter);

        return restTemplate;
    }
}