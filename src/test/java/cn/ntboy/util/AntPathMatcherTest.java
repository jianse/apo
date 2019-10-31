package cn.ntboy.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class AntPathMatcherTest {

    @Test
    public void matcherTest(){
        String[] patterns = {"/admin/images/*","/admin/js/*","/admin/login"};
        AntPathMatcher antPathMatcher = new AntPathMatcher();
//        System.out.println(antPathMatcher.isPattern(pattern));
        System.out.println(antPathMatcher.matchOne(patterns, "/admin/login"));
    }

}