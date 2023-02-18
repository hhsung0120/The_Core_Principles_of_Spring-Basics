package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AutoAppConfigTest {

    //이 TC 가 성공하려면 MemberServiceImpl, MemoryMemberRepository @Component 선언해주고, 생성자에 @Autowired 선언해줘야 스프링 빈에 등록되어 TC 성공
    @Test
    void basicScan() {
//        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
//        MemberService memberService = ac.getBean(MemberService.class);
//        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
