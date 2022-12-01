package me.pcy.javatest;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 부터는 접근제한자에 대한 제약이 없다.
 */
// 클래스에 적용하면 클래스와 모든 테스트 메서드에 이름표기 전략을 설정한다.
// 기본 구현체로 ReplaceUnderscores 클래스를 제공한다.
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    // 테스트 이름을 표기 설정
    @DisplayName("Study 인스턴스 만들기")
    void create_new_study() {
        System.out.println("Create!!");
        Study study = new Study(10);

        assertAll(
                () -> assertNotNull(study),
                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다."),
                // 람다 표현식을 사용하면 문자열 연산을 필요한 시점까지 하지 않는다.
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
                        () -> "스터디를 처음 만들면 " + StudyStatus.DRAFT + " 상태다.")
        );
    }

    @Test
    void createNewStudy_timeout() {
        assertTimeout(Duration.ofMillis(200), () -> {
            new Study(10);
            Thread.sleep(100L);
        });
        // ThreadLocal
    }

    @Test
    void createNewStudy_fail_limitLessThen0() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        
        String message = exception.getMessage();
        assertEquals("limit은 0보다 커야한다.", message);
    }
    
    @Test
    @Disabled  // 해당 테스트는 제외하고 진행
    void test() {
        System.out.println("Test!!");
    }

    // 모든 테스트가 실행되기 전 한 번만 실행
    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all");
    }

    // 모든 테스트가 실행된 이후 한 번만 실행
    @AfterAll
    static void afterAll() {
        System.out.println("After all");
    }

    // 각 테스트가 실행되기 이전에 실행
    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each");
    }

    // 각 테스트가 실행된 후에 실행
    @AfterEach
    void afterEach() {
        System.out.println("After Each");
    }
}