package com.demo;

import com.demo.model.CacheDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {
	@Autowired
	private CacheDemo cacheDemo;

	@Test
	public void testEhCache() {
		//首次不命中缓存，会执行一次;
		System.out.println("result:"+cacheDemo.getInfo("hello"));
		//再次执行，命中缓存，不输出log;
		System.out.println("result:"+cacheDemo.getInfo("hello"));
		System.out.println("result:"+cacheDemo.getInfo("world"));
	}

}
