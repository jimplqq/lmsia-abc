package com.lmsia.server.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/** @Author: gin @Date: 2021/7/20 下午3:13 */
public class MyProxyFilter implements CallbackFilter {
  @Override
  public int accept(Method method) {
    if (!"query".equalsIgnoreCase(method.getName())) {
      return 0;
    }
    return 1;
  }
}
