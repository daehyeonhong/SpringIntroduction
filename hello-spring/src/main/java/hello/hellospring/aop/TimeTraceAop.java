package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final Long start = System.currentTimeMillis();
        System.out.println(proceedingJoinPoint.toString());
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            final Long finish = System.currentTimeMillis();
            final Long timeMs = finish - start;
            System.out.println(proceedingJoinPoint + " " + timeMs);
        }
    }

}
