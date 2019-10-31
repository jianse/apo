package cn.ntboy.other;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LogTest {
    @Test
    public void logColorTest(){
        log.warn("this is a warn");
        log.error("this is a error");
        log.debug("this is a debug message");
        log.info("this is a info");

    }
}
