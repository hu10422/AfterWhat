package cn.hu.afterwhat;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.KeyUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author howitt
 * @version 1.0.0
 * @ClassName SymmetricEncryptionTests.java
 * @Description TODO 对称加密测试，基于huTool工具包
 * @createTime 2020年12月9日11:29:28
 */
@SpringBootTest
public class SymmetricEncryptionTests {

    /**
     * 基于hutool 工具包的  AES加密测试
     */
    @Test
    public void encryptOfAes() {
        String key = "bEu&5%oRmy#5aH3S";
        String iv = "WH#ioEjEPG9!%oS1";
        String algorithm = "AES/CBC/PKCS7Padding";

        // 构建加密工具实例
        SymmetricCrypto aesUtil = new SymmetricCrypto(algorithm, KeyUtil.generateKey("AES", key.getBytes()));
//        SymmetricCrypto aesUtil = new SymmetricCrypto(SymmetricAlgorithm.AES, KeyUtil.generateKey("AES", key.getBytes()));
        aesUtil.setIv(iv.getBytes());//加盐

        String content = "{\"name\":\"json在线编辑器\",\"v1.0\":\"2014-07-02 22:05 工具上线\"}";//需要加密内容
        String encryptStr = aesUtil.encryptBase64(content); //加密
        String decryptStr = aesUtil.decryptStr(encryptStr);//解密

        System.out.println(StrUtil.format("算法:{}", algorithm));
        System.out.println(StrUtil.format("密钥:{}", key));
        System.out.println(StrUtil.format("加盐:{}", iv));
        System.out.println(StrUtil.format("需要加密文本:{}", content));
        System.out.println(StrUtil.format("加密之后文本:{}", encryptStr));
        System.out.println(StrUtil.format("解密之后文本:{}", decryptStr));
    }

}
