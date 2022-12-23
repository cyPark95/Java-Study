import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import me.pcy.architecturetest.App;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

// 클래스를 읽어 확인할 패키지 설정
@AnalyzeClasses(packagesOf = App.class)
public class ArchJUnitTests {

    // TODO ..domain.. 패키지에 있는 클래스는 ..study.., ..member.., ..domain에서 참조할 수 있다.
    @ArchTest  // 확인할 규칙 정의
    ArchRule domainPackageRule = classes().that().resideInAPackage("..domain..")
            .should().onlyBeAccessed().byClassesThat()
            .resideInAnyPackage("..study..", "..member..", "..domain..");

    // TODO ..member.. 패키지에 있는 클래스는 ..study..와 ..member..에서만 참조할 수 있다.(반대로) ..domain.. 패키지는 ..member.. 패키지를 참조하지 못한다.
    @ArchTest
    ArchRule memberPackageRule = noClasses().that().resideInAPackage("..domain..")
            .should().accessClassesThat().resideInAPackage("..member..");

    // TODO ..study.. 패키지에 있는 클래스는 ..study.. 에서만 참조할 수 있다.
    @ArchTest
    ArchRule studyPackageRule = noClasses().that().resideOutsideOfPackage("..study..")
            .should().accessClassesThat().resideInAnyPackage("..study..");

    // TODO 순환 참조 없어야 한다.
    @ArchTest
    ArchRule freeOfCycles = slices().matching("..architecturetest.(*)..")
            .should().beFreeOfCycles();
}
