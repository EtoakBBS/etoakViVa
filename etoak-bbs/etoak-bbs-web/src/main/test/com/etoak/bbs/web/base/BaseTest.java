package com.etoak.bbs.web.base;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.etoak.bbs.web.springboot.Application;

/**
 * 
 * @ClassName: BaseTest 
 * @Description: 单元测试公共类  （继承此类即可） 
 * @author 刘林
 * @date 2016年11月25日 下午2:40:43 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes = Application.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class BaseTest {

}
