package de.cluster.microservices.zuul;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@EnableZuulProxy
@Slf4j
@SpringBootApplication(scanBasePackages = {"de.cluster.microservices.zuul"} )
@EnableDiscoveryClient
public class ZuulApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		try{
			ctx = SpringApplication.run(ZuulApplication.class, args);
		}catch (Exception e) {
			log.error(e.getStackTrace().toString());
		}
		finally {
			((AbstractApplicationContext)ctx).registerShutdownHook();
		}
	}
}
