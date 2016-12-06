package com.qihoo.study.thrift.protocol;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TProtocol;

import java.lang.reflect.Method;

public abstract class TClientProxyFactory {

	public static <T extends TServiceClient> T getProxy(T client) {
		//代理TServiceClient 实现添加traceId
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(client.getClass());
		enhancer.setCallback(new TClientProxy(client));//设置回调
		return (T)enhancer.create(new Class[]{TProtocol.class, TProtocol.class},
				new Object[]{client.getInputProtocol(), client.getOutputProtocol()});//创建代理对象
	}

	public static class TClientProxy implements MethodInterceptor {
		private TServiceClient target;

		public TClientProxy(TServiceClient target) {
			this.target = target;
		}

		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			//写入traceId
			target.getOutputProtocol().writeString("abc");
			return method.invoke(target, args);
		}
	}


}
