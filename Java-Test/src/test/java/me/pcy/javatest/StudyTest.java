package me.pcy.javatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * JUnit 5 부터는 접근제한자에 대한 제약이 없다.
 * JUnit이 제공하는 어노테이션은 메타 어노테이션으로 사용할 수 있다.
 *
 * Unit 테스트들은 각각 독립적으로 테스트가 진행되어야 한다.
 */
// 클래스에 적용하면 클래스와 모든 테스트 메서드에 이름표기 전략을 설정한다.
// 기본 구현체로 ReplaceUnderscores 클래스를 제공한다.
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
// 테스트 메서드를 독립적으로 싱행하여 예상치 못한 부작용을 방지하기 위해 테스트 마다 테스트 인스턴스를 새로 만든다.
// JUnit5에서는 이 전략을 변경할 수 있다.
// 테스트 클래스당 인스턴스를 하나만 만들어 사용한다.
// BeforeAll, AfterAll 메서드를 static 메서드로 만들지 않아도 된다.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
// 테스트 인스턴스를 새로 만드는 것과 같은 이유로 어떻게 순서를 정하는지는 의도적으로 분명히 하지 않는다.
// TestMethodOrder 어노테이션을 통해 원하는 순서에 따라 실행하도록 설정할 수 있다.
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudyTest {

    @Test
    // 테스트 이름을 표기 설정
    @DisplayName("Study 인스턴스 만들기")
    // 테스트 그룹 설정
    @Tag("slow")
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

    @SlowTest
    void createNewStudy_timeout() {
        assertTimeout(Duration.ofMillis(200), () -> {
            new Study(10);
            Thread.sleep(100L);
        });
        // ThreadLocal
    }

    // WINDOWS에서 테스트 활성화
    @EnabledOnOs(OS.WINDOWS)
    // MAC에서 테스트 비활성화
    @DisabledOnOs(OS.MAC)
    // 자바 11 버전에서 테스트 활성화
    @EnabledOnJre(JRE.JAVA_11)
    // 환경변수 TEST_ENV가 LOCAL에 매칭되면 테스트 활성화
//    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    @FastTest
    void createNewStudy_assume() {
        String test_env = System.getenv("TEST_ENV");

        // 조건에 따라 테스트하기
        assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
            Study study = new Study(100);
            assertThat(study.getLimit()).isGreaterThan(0);
        });
        assumingThat("DEV".equalsIgnoreCase(test_env), () -> {
            Study study = new Study(10);
            assertThat(study.getLimit()).isGreaterThan(10);
        });
    }

    @FastTest
    void createNewStudy_fail_limitLessThen0() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));

        String message = exception.getMessage();
        assertEquals("limit은 0보다 커야한다.", message);
    }

    @DisplayName("반복 테스트-단순 반복")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")  // value: 반복 횟수 / name: 이름 설정
    void repeatTest(RepetitionInfo repetitionInfo) {
        System.out.println("Repeat Test: " + repetitionInfo.getCurrentRepetition() + " / " + repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("반복 테스트-다른값")
    @ParameterizedTest(name = "{index} {displayName} : {0}")
//    @ValueSource(ints = {10, 20, 40, 80})
//    @NullAndEmptySource  // @NullSource + @EmptySource
    @CsvSource({"10, '자바 스터디'", "20, '스프링'", "30, 'JPA'"})
    void parameterizedTest(@AggregateWith(StudyAggregator.class) Study study) {
//        Study study = new Study(limit, name);
        System.out.println(study.getLimit());
    }

    // 인자 값 조합
    // 반드시 static inner 클래스 이거나, public 클래스여야 한다.
    static class StudyAggregator implements ArgumentsAggregator {
        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            return new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        }
    }

    // 명시적 인자 값 타입 변환
    // 하나의 아규먼트에만 적용되는 컨버터
    static class StudyConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class, targetType, "Can only convert to Study");
            return new Study(Integer.parseInt(source.toString()));
        }
    }

    int value = 1;

    @Test
    // 테스트 이름을 표기 설정
    @DisplayName("인스턴스 공유 fast")
    // 테스트 그룹 설정
    @Tag("fast")
    @Order(2)
    void testInstanceFast() {
        System.out.println("value: " + value++);
    }

    @Test
    // 테스트 이름을 표기 설정
    @DisplayName("인스턴스 공유 slow")
    // 테스트 그룹 설정
    @Tag("slow")
    @Order(1)
    void testInstanceSlow() {
        System.out.println("value: " + value++);
    }
    
    @Test
    @Disabled  // 해당 테스트는 제외하고 진행
    void disabledTest() {
        System.out.println("Test!!");
    }

    // 반드시 static 메서드여야 한다.
    // 모든 테스트가 실행되기 전 한 번만 실행
    @BeforeAll
    void beforeAll() {
        System.out.println("Before all");
    }

    // 모든 테스트가 실행된 이후 한 번만 실행
    @AfterAll
    void afterAll() {
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