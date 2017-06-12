package com.bestcxx.stu.springmvc.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 时间格式转化器
 * @theme 
 * @author wujie
 * @Datetime 2017年6月12日
 * 
 * 该类起作用需要 先配置（比如bean id=conversionService） org.springframework.format.support.FormattingConversionServiceFactoryBean
 * 然后将改bean 配置到 <mvc:annotation-driven conversion-service="conversionService"/>
 */
public class SpringGlobalStrToDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String arg0) {
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(arg0);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
