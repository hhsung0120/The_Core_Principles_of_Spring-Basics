package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    @Test
    void prototypeTest() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototypeBean1");
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean bean2 = ac.getBean(PrototypeBean.class);

        System.out.println("bean1 : " + bean1);
        System.out.println("bean2 : " + bean2);
        assertThat(bean1).isNotSameAs(bean2);

        //직접 클라이언트에서 소멸해줘야함
        bean1.destroy();
        bean2.destroy();

        //프로토타입은 소멸이 없음
        ac.close();

    }

    //프로토타입 스코프는 조회할때 빈생성 및 필요한 관계들이 주입된다. 소멸이 없음
    @Scope("prototype")
    static class PrototypeBean {

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("destroy");
        }
    }
}
