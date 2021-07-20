package com.lmsia.server.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/** @Author: gin @Date: 2021/7/20 下午3:07 */
public class MyCglibProxy implements MethodInterceptor {
  public Enhancer enhancer = new Enhancer();

  private String name;

  public MyCglibProxy(String name) {
    this.name = name;
  }

  public Object getDaoBean(Class clazz) {
    enhancer.setSuperclass(clazz);
    enhancer.setCallback(this);
    return enhancer.create();
  }

  @Override
  public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
      throws Throwable {
    System.out.println("调用方式：" + method.getName());
    if (!"boss".equals(name)) {
      System.out.println("没有权限");
      return null;
    }
    Object o = proxy.invokeSuper(obj, args);
    return o;
  }
}
