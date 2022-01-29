package com.example.core.order;

import com.example.core.discount.DiscountPolicy;
import com.example.core.discount.FixDiscountPolicy;
import com.example.core.member.Member;
import com.example.core.member.MemberRepository;
import com.example.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    // 윈도우의 경우 ctrl + f12 => 현재 메소드 다 보여줌
    // 수정자 주입을 포함한 나머지 주입 방식은 모두 생성자 이후에 호출되므로,
    // 필드에 'final' 키워드를 사욯알 수 없다. 오직 생성자 주입 방식만 'final' 키워드를 사용할 수 있다.
    // 항상 생성자 주입하기! 가끔 옵션이 필요한 겨우 수정자 주입 사옹. 필드는 X => 테스트 시에 값을 넣을 수 없음..
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy =  discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
