package de.dreierschach.retrocomputer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class DelegateProxy<T> implements InvocationHandler {
    public static final Logger log = LoggerFactory.getLogger(DelegateProxy.class);
    private final List<T> delegates;

    public DelegateProxy(List<T> delegates) {
        this.delegates = delegates;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        // call delegate methods

        delegates.forEach(delegate -> {
                    try {
                        method.invoke(delegate, args);
                    } catch (Exception e) {
                        log.error("unable to invoke method {} for delegate {}", method.getName(), delegate, e);
                    }
                }
        );
        return null;
    }

    public static <T> T instance(Class<T> clazz, List<T> delegates) {
        return (T) Proxy.newProxyInstance(
                DelegateProxy.class.getClassLoader(),
                new Class[]{clazz},
                new DelegateProxy(delegates));
    }
}
