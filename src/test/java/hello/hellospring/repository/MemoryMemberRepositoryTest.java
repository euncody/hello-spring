package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore(); // 각 테스트 후 저장소를 비워줌
    }

    @Test
    public void save() {
        // Given
        Member member = new Member();
        member.setName("spring");

        // When
        repository.save(member);

        // Then
        Member result = repository.findById(member.getId()).get();
       assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName() {
        // Given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // When
        Member result = repository.findByName("spring1").get();

        // Then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        // Given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // When
        List<Member> result = repository.findAll();

        // Then
        assertThat(result.size()).isEqualTo(2);
    }
}
