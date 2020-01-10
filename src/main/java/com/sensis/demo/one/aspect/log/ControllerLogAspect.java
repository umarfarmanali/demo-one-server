package com.sensis.demo.one.aspect.log;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class ControllerLogAspect {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Around("@annotation(org.springframework.web.bind.annotation.RequestMapping) && execution(public * *(..))")
	public Object log(final ProceedingJoinPoint proceedingJointPoint) throws Throwable{
		
		//Get the HTTP request
		HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		
		Object value;
		
		try {
			value = proceedingJointPoint.proceed();
		}finally {
			log.info("{} {} from {}", httpRequest.getMethod(), httpRequest.getRequestURI(), httpRequest.getRemoteAddr());
		}
		
		return value;
	}
}
