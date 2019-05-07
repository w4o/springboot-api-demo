package lok.tar.app.config;

import lok.tar.app.domain.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author frank
 * @date 2019-04-25 09:45
 */
@ControllerAdvice
public class FormatResponseBodyAdvice implements ResponseBodyAdvice {

    @Value("${app.version}")
    private String version;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof CommonResult) {
            CommonResult commonResult = (CommonResult) body;
            commonResult.setVersion(version);
            return commonResult;
        }
        return body;
    }
}
