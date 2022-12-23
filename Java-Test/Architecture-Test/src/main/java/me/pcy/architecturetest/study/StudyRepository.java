package me.pcy.architecturetest.study;

import me.pcy.architecturetest.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {
}
