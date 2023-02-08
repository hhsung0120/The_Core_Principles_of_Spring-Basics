package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Assertions.assertThat(memberService1).isNotEqualTo(memberService2);

        //객체가 계속 생성되면 메모리 낭비가 심하다!
        //방안 : 하나의 객체만 생성해서 공유해서 쓰도록 싱글톤 처리
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용)")
    void singletonServiceTest(){
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        System.out.println(instance1);
        System.out.println(instance2);

        //same -> 객체 비교
        //equals -> 값 비교
        Assertions.assertThat(instance1).isSameAs(instance2);
    }
}
