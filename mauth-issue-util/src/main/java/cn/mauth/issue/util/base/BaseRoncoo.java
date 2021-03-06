package cn.mauth.issue.util.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础类
 * 
 * @author mauth
 */
public class BaseRoncoo {

	protected static final ExecutorService exchangeExecutor = Executors.newFixedThreadPool(50);
	protected static final ExecutorService rechargeExecutor = Executors.newFixedThreadPool(50);
	protected static final ExecutorService notifyExecutor = Executors.newFixedThreadPool(50);

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	protected void logToString(Object obj) {
		logger.info(ReflectionToStringBuilder.toString(obj, ToStringStyle.MULTI_LINE_STYLE));
	}
}
