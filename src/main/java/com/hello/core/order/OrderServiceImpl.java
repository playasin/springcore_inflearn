package com.hello.core.order;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.Member;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired        //lombok의 @RequiredArgsConstructor로 대체
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) { //같은 타입으로 여러개의 bean이 있을때때        this.memberRepository = memberRepository;
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //4Test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
