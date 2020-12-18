package cn.hu.afterwhat;

import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AfterwhatApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(StrUtil.contains("xlsx", "xls"));
    }

}
