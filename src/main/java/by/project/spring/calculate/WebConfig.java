package by.project.spring.calculate;

import by.project.spring.calculate.interceptor.NullUserSessionInterceptor;
import by.project.spring.calculate.interceptor.UserSessionInterceptor;
import by.project.spring.calculate.model.entity.Operation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("by.project.spring.calculate")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/pages/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(false);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserSessionInterceptor()).addPathPatterns("/calc");
        registry.addInterceptor(new UserSessionInterceptor()).addPathPatterns("/history");
        registry.addInterceptor(new UserSessionInterceptor()).addPathPatterns("/logout");
        registry.addInterceptor(new NullUserSessionInterceptor()).addPathPatterns("/reg");
        registry.addInterceptor(new NullUserSessionInterceptor()).addPathPatterns("/auth");
    }

    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    @Bean
    public Map<String, Operation> getOperation(Sum sum, Mult mult, Diff diff, Div div){
        Map<String,Operation> operationMap = new HashMap<>();
        operationMap.put("SUM",sum);
        operationMap.put("DIV",div);
        operationMap.put("MULT",mult);
        operationMap.put("DIFF",diff);
        return operationMap;
    }



}
