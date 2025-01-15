package hello.core;

import hello.core.member.*;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

/**
 * MemberApp 클래스는 프로그램의 시작점인 main 메서드를 포함하고 있습니다. 이 클래스는 다음과 같은 역할을 합니다:
 *
 * MemberService를 사용하여 멤버를 생성하고 저장:
 * MemberService 인터페이스를 구현한 MemberServiceImpl 객체를 생성하여 join 메서드를 통해 멤버를 저장합니다.
 * 멤버를 조회:
 * 저장된 멤버를 findMember 메서드를 사용하여 다시 조회합니다.
 */
public class MemberApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService= appConfig.memberService();

        //MemberService memberService = new MemberServiceImpl(); //객체를 직접 생성하고 있음. = 의존성 주입을 사용하지 않은 상태 .
        Member member=new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember= memberService.findMember( 1L);
        System.out.println("new member = "+ member.getName());
        System.out.println("findMember ="+ findMember.getName());


    }
}
