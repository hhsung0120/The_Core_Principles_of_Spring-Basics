package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@Component 를 찾아서 스프링 빈으로 자동 등록
@ComponentScan(
        //AppConfig.java는 수동으로 빈을 등록했지 때문에 제외를 해주지 않으면 빈 충돌
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}

//설정 정보가 아무 것도 없어도 됨.
