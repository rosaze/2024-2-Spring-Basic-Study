package hello.core.member;

//DIP 를 지키게 됨.
public class MemberServiceImpl implements MemberService{
    //가입을 하려면 memberrepository가 필요함
    private final MemberRepository memberRepository
    public MemberServiceImpl(MemoryMemberRepository memoryMemberRepository) {
        this.memberRepository= memberRepository;
    }
// 구현체에 뭐가 들어갈지를 생성자를 통해서 함
    @Override
    public void join(Member member)  {
        memberRepository.save(member); //오버라이드 한 게 호출됨
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
