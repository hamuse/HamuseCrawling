package com.hamuse.web.proxy;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("pxy") @Lazy
public class Proxy {
	public String string(Object param) {
		Function<Object, String> f = String :: valueOf;
		return f.apply(param);
	}
	
	public int integer(String param) {
		Function<String, Integer> f = Integer :: parseInt;
		return f.apply(param);
	}
	public Boolean equel(String s1, String s2 ) {
		BiPredicate<String, String> f = String :: equals;
		return f.test(s1, s2);
	}
	public void print(String t) {
		Consumer<String> f = System.out :: println;
		f.accept(t);
	}
}
