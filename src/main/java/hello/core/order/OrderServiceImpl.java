package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

  //  @Autowired
   // public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
  //      this.memberRepository = memberRepository;
  //      this.discountPolicy = discountPolicy;
  //  }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); /* 단일책임 정책 잘 준수 */
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
