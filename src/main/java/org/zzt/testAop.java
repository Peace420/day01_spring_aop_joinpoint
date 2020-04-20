package org.zzt;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zzt.demo.Target;

/**
 * Description: testAop
 * date: 2020/4/18 11:21
 * author: 朱忠涛
 * version: 1.0
 */
public class testAop {

    private ClassPathXmlApplicationContext ac;
    @Before
    public void before(){
        ac = new ClassPathXmlApplicationContext("*/applicationContext.xml");
    }

    @Test
    public void testDemo(){
        // 测试
        Target target =(Target) ac.getBean("target");
        String result = target.play("ls");
        System.out.println("result:"+result);
    }
}
