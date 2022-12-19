package me.pcy.dockertest.study;

import lombok.RequiredArgsConstructor;
import me.pcy.dockertest.domain.Study;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/study")
@RequiredArgsConstructor
public class StudyController {

    final StudyRepository repository;

    @GetMapping("/{id}")
    public Study getStudy(@PathVariable("id") final Long id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("Study not found for '" + id + "'");
        });
    }

    @PostMapping
    public Study createStudy(@RequestBody final Study study) {
        return repository.save(study);
    }
}
