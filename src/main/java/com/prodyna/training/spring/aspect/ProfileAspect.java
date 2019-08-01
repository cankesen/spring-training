package com.prodyna.training.spring.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
//activate if you dont define in configuration as bean
@Component
@Slf4j
public class ProfileAspect {

    //instead of Sl4j
    //private static final Logger logger = LoggerFactory.getLogger(ProfileAspect.class);

    @Pointcut(value="execution(public * *(..))")
    public void anyPublicMethod() { }


    //Advice and joint point
    @Around("anyPublicMethod() && @annotation(Profile)")
    public Object profileExecuteMethod(ProceedingJoinPoint jointPoint) throws Throwable {
        Signature signature = jointPoint.getSignature();
        String methodName = signature.toShortString();

        StopWatch stopWatch = new StopWatch(ProfileAspect.class.getName());
        stopWatch.start(methodName);
        jointPoint.proceed();
        stopWatch.stop();

        log.info(stopWatch.prettyPrint());

        return jointPoint.proceed();
    }
}
