package com.simpleSpringBootECommerce.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ApplicationConfig implements WebMvcConfigurer {

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);
		return messageSource;
	}

//	@Bean
//	public FormattingConversionService mvcConversionService() {
//		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
//		DateFormatterRegistrar formatterRegistrar = new DateFormatterRegistrar();
//		formatterRegistrar.setFormatter(new DateFormatter("MM/dd/yyyy"));
//		formatterRegistrar.registerFormatters(conversionService);
//		return conversionService;
//	}

//	@Bean
//	public InternalResourceViewResolver internalResourceViewResolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setExposedContextBeanNames("cart");
//		resolver.setExposeContextBeansAsAttributes(true);
//		return resolver;
//	}

//	@Bean
//	public CacheManager cacheManager() {
//		CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(5,
//				TimeUnit.MINUTES);
//		GuavaCacheManager manager = new GuavaCacheManager();
//		manager.setCacheBuilder(builder);
//		return manager;
//	}

}
