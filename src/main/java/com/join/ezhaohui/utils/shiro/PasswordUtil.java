package com.join.ezhaohui.utils.shiro;

import com.join.ezhaohui.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Author:ljx
 * @Date:2020/4/27
 * @Description:
 */
public class PasswordUtil {
    private static RandomNumberGenerator randomNumberGenerator=new SecureRandomNumberGenerator();

//    @Value("${shiro.password.algorithm}")
    public static String ALGORITHM_NAME="sha";
//    @Value("${shiro.password.iterations}")
    public static int HASH_ITERATIONS=2;
    public static void encryptPassword(User user){
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword =new SimpleHash(ALGORITHM_NAME,user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()),HASH_ITERATIONS).toHex();
        user.setPassword(newPassword);
    }
}
