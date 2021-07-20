package com.lmsia.server.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/** @Author: gin @Date: 2021/7/20 下午3:04 */
public class BookServiceFactory {
  public BookServiceFactory() {}

  private static BookServiceBean bean = new BookServiceBean();

  public static BookServiceBean getInstance() {
    return bean;
  }

  public static BookServiceBean getProxyInstance(MyCglibProxy proxy) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(BookServiceBean.class);
    enhancer.setCallback(proxy);
    return (BookServiceBean) enhancer.create();
  }

  public static BookServiceBean getAuthInstanceByFilter(MyCglibProxy myProxy) {
    Enhancer en = new Enhancer();
    en.setSuperclass(BookServiceBean.class);
    en.setCallbacks(new Callback[] {myProxy, NoOp.INSTANCE});
    en.setCallbackFilter(new MyProxyFilter());
    return (BookServiceBean) en.create();
  }
}
