package cn.mauth.issue.boss.common;

import cn.mauth.issue.util.base.BaseController;
import cn.mauth.issue.util.exception.BaseException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理增强器
 */
@RestControllerAdvice
public class BossExceptionHandler extends BaseController {

	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.OK)
	public String processException(Exception e) {
		logger.error(e.getMessage(), e);
		return error("系统异常");
	}

	@ExceptionHandler({ BaseException.class })
	@ResponseStatus(HttpStatus.OK)
	public String processException(BaseException e) {
		logger.error(e.getMessage(), e);
		return error(e.getMessage());
	}

	@ExceptionHandler({ UnauthorizedException.class })
	@ResponseStatus(HttpStatus.OK)
	public String processException(UnauthorizedException e) {
		logger.error(e.getMessage(), e);
		return error("没此权限，请联系管理员");
	}

}
