package com.birthright.aspects;

import com.birthright.entity.Users;
import com.birthright.service.CustomUserDetails;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by birthright on 07.05.16.
 */
@Component
public aspect UserControl {
    @Pointcut("@annotation(com.birthright.aspects.annotation.UserControl)")
    public void user() {
    }

    @Around("admin()")
    public Object check(ProceedingJoinPoint jp) throws Throwable {
        Users user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo();
        if (user.getUserRole().equals("ROLE_USER")) {
            return jp.proceed();
        }
        return "redirect:/";
    }
}
