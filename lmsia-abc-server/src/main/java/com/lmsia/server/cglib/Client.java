package com.lmsia.server.cglib;

/** @Author: gin @Date: 2021/7/20 下午3:05 */
public class Client {
  public static void main(String[] args) {
    //
//    BookServiceBean instance = BookServiceFactory.getInstance();
//    doMethod(instance);
//
//    BookServiceBean service = BookServiceFactory.getProxyInstance(new MyCglibProxy("boss"));
//    service.create();
//    BookServiceBean service2 = BookServiceFactory.getProxyInstance(new MyCglibProxy("aa"));
//    service2.create();

    BookServiceBean service3 = BookServiceFactory.getAuthInstanceByFilter(new MyCglibProxy("boss"));
    service3.create();
    BookServiceBean service4 = BookServiceFactory.getAuthInstanceByFilter(new MyCglibProxy("jhon"));
    service4.query();

  }

  public static void doMethod(BookServiceBean bean) {
    bean.create();
    bean.query();
    bean.update();
    bean.delete();
  }
}
