package me.pcy.mockitotest.study;

import me.pcy.mockitotest.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {
}
