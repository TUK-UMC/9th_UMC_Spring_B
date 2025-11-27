package com.example.umc9th.global.config;

import com.example.umc9th.global.annotation.ValidPage;
import com.example.umc9th.global.exception.PageException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import com.example.umc9th.global.apiPayload.code.PageErrorCode;


@Component
public class ValidPageArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(ValidPage.class)
                && parameter.getParameterType().equals(Integer.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        String raw = request.getParameter("page");

        if (raw == null)
            throw new PageException(PageErrorCode.INVALID_PAGE);

        int page = Integer.parseInt(raw);

        if (page < 1)
            throw new PageException(PageErrorCode.INVALID_PAGE);

        return page;
    }
}
