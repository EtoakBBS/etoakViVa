package com.etoak.bbs.web.aspect;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * aop
 * 
 * @ClassName: WebLogAspect 
 * @Description: TODO 
 * @author 刘林
 * @date 2016年12月7日 下午1:26:48 
 *
 */
@Aspect
@Component
public class WebLogAspect {

	public static Log logger = LogFactory.getLog(WebLogAspect.class);

	ThreadLocal<Long> startTime = new ThreadLocal<>();

	/**
	 * 定义一个切入点.
     * ~ 第一个 * 代表任意修饰符及任意返回值.
     * ~ 第二个 * 任意包名
     * ~ 第三个 * 代表任意方法.
     * ~ 第四个 * 定义在web包或者子包
     * ~ 第五个 * 任意方法
     * ~ .. 匹配任意数量的参数.
     * 
	 * @Title: webLog 
	 * @return void 
	 * @throws
	 */
	@Pointcut("execution(public * com.etoak.bbs.web.controller..*.*(..))")
	public void webLog() {
	}

	/**
	 * 
	 * @Title: doBefore
	 * @param joinPoint
	 * @throws Throwable 
	 * @return void
	 */
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		logger.info("URL : " + request.getRequestURL().toString());
		logger.info("HTTP_METHOD : " + request.getMethod());
		logger.info("IP : " + request.getRemoteAddr());
		logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

	}
	
	@AfterThrowing(pointcut="webLog()",throwing="ex")
	public void doAfter(JoinPoint joinPoint,Exception ex) throws IOException{
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletResponse response = attributes.getResponse();
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter p = response.getWriter();
		
		String a = "<script>alert(\" "+ex + " \")</script>";
		p.println(a);
		p.flush();
		
		logger.info(ex);
	}
	
	/*
     * 打印错误信息
     */
	void printStackTraceAsCause(StringBuffer s,
			Throwable iex) {
		s.append(iex.toString());
        StackTraceElement[] trace = iex.getStackTrace();
        for (int i=0; i < trace.length; i++) {
            s.append("\tat ").append(trace[i]);
        }
		Throwable ourCause = iex.getCause();
		if (ourCause != null) {
			this.printStackTraceAsCause(s, ourCause);
		}
	}

//	@AfterReturning(returning = "ret", pointcut = "webLog()")
//	public void doAfterReturning(Object ret) throws Throwable {
//		
//	}
}
