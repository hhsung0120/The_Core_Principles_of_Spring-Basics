package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    //할인 정책을 수정하려면 OrderServiceImpl 을 수정해야한다 OCP 위반
    private final MemberRepository memberRepository;
    /*
    전
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


     DiscountPolicy 추상화에 의존하지 않고 RateDiscountPolicy, FixDiscountPolicy 구현체에도 의존하기 때문에 DIP 위반
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();*/

    //후
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

