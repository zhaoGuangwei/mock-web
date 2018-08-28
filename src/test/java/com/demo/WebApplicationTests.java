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
		System.out.println("result1:"+cacheDemo.getInfo("hello"));
		//再次执行，命中缓存，不输出log;
		System.out.println("result2:"+cacheDemo.getInfo("hello"));
		System.out.println("result3:"+cacheDemo.getInfo("world"));
		//调用同类中的缓存方法;不会生效;
		System.out.println("result4:"+cacheDemo.invokeInfoInClass("hello"));
		System.out.println("result5:"+cacheDemo.invokeInfoInClass("hello"));
		//同类中的缓存方法，改用自建Map的方式;
		System.out.println("result6:"+cacheDemo.getInfoByMap("hello"));
		System.out.println("result7:"+cacheDemo.getInfoByMap("hello"));
	}

}
