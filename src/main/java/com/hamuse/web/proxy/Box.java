package com.hamuse.web.proxy;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Box<T> {
	private HashMap<String, T> box;

	public Box() {
		box = new HashMap<String, T>();
	}

	public void clear() {
		box.clear();
	}

	public void put(List<String> x, Inventory<T> y) {
		box = new HashMap<>();
		for (int i = 0; i < x.size(); i++) {
			box.put(x.get(i), y.get(i));
		}
		box.forEach((k, v) -> System.out.println(String.format("%s : %s", k, v)));
	//forEach가 선언하는거라 생각하면되고 / -> invok 구현부라 생각하면된다. 
	}
	public T get(String k) {
		Function<String, T> f = p -> box.get(p);
		return f.apply(k);
	}

	public HashMap<String, T> get() {
		return box;
	}

	public int size() {
		return box.size();
	}

}
