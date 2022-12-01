package me.pcy.javatest;

import org.junit.jupiter.api.*;

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
        Study study = new Study();
        assertNotNull(study);
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