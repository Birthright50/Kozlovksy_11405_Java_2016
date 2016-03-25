package task13;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.regex.Pattern;

/**
 * Created by Birthright on 24.03.2016.
 */
@Aspect
public class EmailValid {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Around("execution(* *..*.setEmail(String))")
    public Object validEmail(ProceedingJoinPoint joinPoint) {
        String email = (String) joinPoint.getArgs()[0];
        if (VALID_EMAIL_ADDRESS_REGEX.matcher(email).matches()) {
            try {
                joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }
}
