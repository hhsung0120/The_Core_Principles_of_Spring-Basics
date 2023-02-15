package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class singletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void 싱긑톤_테스트() {
        AppConfig appConfig = new AppConfig();

        //1. 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        //참조 값이 다른것을 확인
        System.out.println(memberService1);
        System.out.println(memberService2);

        //서로 다른 객체라는 것 증명
        assertThat(memberService1).isNotEqualTo(memberService2);

        //객체가 계속 생성되면 메모리 낭비가 심하다!
        //방안 : 하나의 객체만 생성해서 공유해서 쓰도록 싱글톤 처리
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용)")
    void singletonServiceTest() {
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        System.out.println(instance1);
        System.out.println(instance2);

        //same -> 객체 비교
        //equals -> 값 비교
        assertThat(instance1).isSameAs(instance2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }

    //싱글톤 방식의 주의점
    // 1. stateful 하게 설계하면 안된다.
    // 2. 특정 클라이언트에 의존적인 필드가 있으면 안된다
    // 3. 특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다.
    // 4. 가급적 읽기만 가능해야 한다.
    // 5. 필드 대신에 자바에서 공유되지 않는, 지역변수, 파라미터, ThreadLocal 등을 사용해야 한다.
}
