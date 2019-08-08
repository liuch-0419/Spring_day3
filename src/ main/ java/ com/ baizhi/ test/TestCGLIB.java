package com.baizhi.test;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class TestCGLIB {
    @Test
    public void testCglib(){
        //原始类对象
        final UserService userService=new UserServiceImpl();
        //额外功能
        InvocationHandler invocationHandler=new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                System.out.println("原始方法执行前执行的");
                Object ret = method.invoke(userService, args);
                System.out.println("原始方法执行后执行的");
                return ret;
            }
        };
        //创建enhancer对象
        Enhancer enhancer=new Enhancer();
        //设置类加载器
        enhancer.setClassLoader(TestCGLIB.class.getClassLoader());
        //把原始父类作为父类  保证原始类与代理类拥有想的方法
        enhancer.setSuperclass(userService.getClass());
        //设置额外功能
        enhancer.setCallback(invocationHandler);
        //创建代理对象
        UserServiceImpl userService1= (UserServiceImpl) enhancer.create();
        userService1.register();
        S.mt.t(n)i-----------anjr;intpuoeys
    }
}
