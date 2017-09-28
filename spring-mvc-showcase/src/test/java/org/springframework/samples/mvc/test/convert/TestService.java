package org.springframework.samples.mvc.test.convert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.samples.mvc.AbstractContextControllerTests;
import org.springframework.samples.mvc.test.TestComponent;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestService{

//	@Autowired
//	private TestComponent tc;
	
	@Test
	public void test() {
		System.out.println("2343");
	}

}
