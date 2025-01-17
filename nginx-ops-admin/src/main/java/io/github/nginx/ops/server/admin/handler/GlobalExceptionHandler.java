package io.github.nginx.ops.server.admin.handler;

import io.github.nginx.ops.server.comm.domain.vo.R;
import io.github.nginx.ops.server.comm.exception.BusinessException;
import io.github.nginx.ops.server.system.service.SysReturnService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author lihao3
 */
@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

  private final SysReturnService sysReturnService;

  /** 业务异常 */
  @ExceptionHandler(BusinessException.class)
  public R handleBusinessException(BusinessException e, HttpServletRequest request) {
    log.warn("业务异常, 异常信息为:{}", e.getMessage(), e);
    return R.error(sysReturnService.getMessage(e.getCode()));
  }

  /** 拦截未知的运行时异常 */
  @ExceptionHandler(RuntimeException.class)
  public R handleRuntimeException(RuntimeException e, HttpServletRequest request) {
    String requestURI = request.getRequestURI();
    log.error("请求地址:{},发生未知异常.", requestURI, e);
    return R.error(e.getMessage());
  }

  /** 系统异常 */
  @ExceptionHandler(Exception.class)
  public R handleException(Exception e, HttpServletRequest request) {
    String requestURI = request.getRequestURI();
    log.error("请求地址:{},发生系统异常.", requestURI, e);
    return R.error(e.getMessage());
  }

  /** 自定义验证异常 */
  @ExceptionHandler(BindException.class)
  public R handleBindException(BindException e) {
    log.error(e.getMessage(), e);
    String message = e.getAllErrors().get(0).getDefaultMessage();
    return R.error(message, message);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public R handleBindException(MethodArgumentNotValidException e) {
    log.warn("参数校验失败, 异常简介为:{}", e.getMessage(), e);
    return R.error(
        sysReturnService.getMessage(e.getBindingResult().getFieldError().getDefaultMessage()));
  }

  /** 请求方式不支持 */
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public R handleHttpRequestMethodNotSupported(
      HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
    String requestURI = request.getRequestURI();
    log.error("请求地址:{},不支持{}请求", requestURI, e.getMethod());
    return R.error(e.getMessage());
  }
}
