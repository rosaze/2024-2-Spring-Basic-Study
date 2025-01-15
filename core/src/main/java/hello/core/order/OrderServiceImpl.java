package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    //회원찾고 할인정책이 필요함
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member= memberRepository.findById(memberId);
        int discountPrice= discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
/**
 * orderservice: 주문 생성 서비스의 중심 역할을 함.
 * 설계가 잘 된 이유: orderservice 가 할인에 대해서 알 필요 없음 : 단일책임원칙 잘 지킨것임
 * orderservice 에서 할인 변경에 대한 요청이 들어와도 고치지 않아도 됨. 할인 정책을 변경하고 싶다면 DiscountPolicy
 * 인터페이스를 구현한 새로운 클래스를 만들어서 교체하기만 하면 됨. 기존 코드 수정할 필요 없음
 *
 * 주문생성이 요청오면 회원정보를 조회하고 할인정책에 회원을 넘김. 멤버를 통으로 넘김. 여기에서 뭘 넘길지는 고민해야 함 .
 */
    }
}
