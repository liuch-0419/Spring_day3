package com.baizhi.test;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDK {
    @Test
    public void testJDK(){
        final UserService userService=new UserServiceImpl();
        //获取到原始类实现的接口
        Class<?>[] interfaces=userService.getClass().getInterfaces();
        //创建额外功能
        InvocationHandler invocationHandler=new InvocationHandler() {
            @Override
            public Object invoke(Object target, Method method, Object[] args) throws Throwable {
                System.out.println("原始方法执行之前执行");
                Object ret = method.invoke(userService, args);
                System.out.println("原始方法执行之后执行");
                return ret;
            }
        };
        UserService proxy= (UserService) Proxy.newProxyInstance(TestJDK.class.getClassLoader(),interfaces,invocationHandler);
        proxy.register();
    }
}
