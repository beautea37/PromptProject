package com.me.kije.promptproject.repository;
import com.me.kije.promptproject.Entity.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromptRepository extends JpaRepository<Prompt, Long> {
    // 필요한 메소드를 추가로 정의할 수 있습니다.
}
