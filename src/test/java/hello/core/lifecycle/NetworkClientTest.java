package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class NetworkClientTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

        //이렇게 하게 되면 스프링에 의존하지 않는 장점, 코드를 고칠수 있음
        //@Bean(initMethod = "init", destroyMethod = "close") //외부 라이브러리를 초기화 또는 종료가 필요하면 이렇게 선언해서 사용하자!
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://www.naver.com");
            return networkClient;
        }
    }

}