package task12;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.regex.Pattern;

/**
 * Created by Birthright on 24.03.2016.
 */
@Aspect
public class NoSQLInjection {
    private static final Pattern VALID_SQL_QUERY_REGEX =
            Pattern.compile(".*(('(''|[^'])*')|(;)|(\\b(ALTER|CREATE|DELETE|DROP|EXEC(UTE)?|INSERT( +INTO)?|MERGE|SELECT|UPDATE|UNION( +ALL)?)\\b))*.*",
                    Pattern.CASE_INSENSITIVE);
    @Around("execution(* *..Statement.execute(String))")
    public Object noInjection(ProceedingJoinPoint joinPoint) {
        String sql = (String) joinPoint.getArgs()[0];
        if(!VALID_SQL_QUERY_REGEX.matcher(sql.toLowerCase()).matches()){
            try {
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }
}
