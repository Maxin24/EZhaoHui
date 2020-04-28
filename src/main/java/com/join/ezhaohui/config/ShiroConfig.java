package com.join.ezhaohui.config;

import com.join.ezhaohui.realm.UserRealm;
import com.join.ezhaohui.utils.shiro.PasswordUtil;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:ljx
 * @Date:2020/4/27
 * @Description:
 */
@Configuration
public class ShiroConfig {
    /**
     * 配置shiro的拦截器
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> filterChainDefinitionMap=new HashMap<>();


        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");

        filterChainDefinitionMap.put("/admin/*","authc");
//        filterChainDefinitionMap.put("/info/*","roles[admin]");
        filterChainDefinitionMap.put("/**","anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 配置凭证匹配器
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();

        //设置哈希算法
        hashedCredentialsMatcher.setHashAlgorithmName(PasswordUtil.ALGORITHM_NAME);
        //设置轮询次数
        hashedCredentialsMatcher.setHashIterations(PasswordUtil.HASH_ITERATIONS);

        return hashedCredentialsMatcher;
    }

    /**
     * 配置Realm
     * @return
     */
    @Bean
    public UserRealm userRealm(){
        UserRealm userRealm =new UserRealm();
        //给Realm配置凭证匹配器
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    @Bean
    public PasswordUtil passwordUtil(){
        return new PasswordUtil();
    }
}
