package com.kaishengit.aop;

/**
 * Created by Administrator on 2016/6/30.
 */
public class MyAdvice {


    /**
     * 前置通知
     */
    public void beforeAdvice() {
        System.out.println("前置通知......");
    }

    /**
     * 后置通知
     */
    public void afterReturingAdvice(Object result) {
        System.out.println("后置通知..  "+result);
    }

    /**
     * 异常通知
     */
    public void exceptionAdvice(Exception e) {
        System.out.println("异常通知..... "+e.getMessage());
    }

    /**
     * 最终通知
     */
    public void finallyAdvie() {
        System.out.println("最终通知...");
    }
}
