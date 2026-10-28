package com.student_sys.student_sys.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.csrf.CsrfException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice 
public class GlobalException {

        private static final Logger log = LoggerFactory.getLogger(GlobalException.class);

    
    @ExceptionHandler(CsrfException.class)
    public String csrfExceptionHandler(CsrfException exception,RedirectAttributes redirectAttributes){
        log.warn("CRSF validation", exception);
        redirectAttributes.addFlashAttribute("message","Session Expeired");
        return "redirect:/login";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String genericStringHandler(Exception exception){
        log.warn("Exception",exception);
        return "500";
    }
}
