package com.example;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;


public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        final boolean contains = StrUtil.contains("hello", 'o');
        System.out.println(contains);
        final ObjectMapper objectMapper = new ObjectMapper();
        final String ak = objectMapper.writeValueAsString(new User("ak", 18));
        System.out.println(ak);
        final InputStream resourceAsStream = Main.class.getResourceAsStream("/config/app.properties");
        final Properties properties = new Properties();
        properties.load(resourceAsStream);
        System.out.println(properties.get("hello"));
    }

    @Data
    @AllArgsConstructor
    private static class User {
        private String name;
        private Integer age;
    }
}
