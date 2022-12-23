import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

public class ArchTests {

    @Test
    void packageDependencyTests() {
        JavaClasses classes = new ClassFileImporter().importPackages("me.pcy.architecturetest");

        // TODO ..domain.. 패키지에 있는 클래스는 ..study.., ..member.., ..domain에서 참조할 수 있다.
        ArchRule domainPackageRule = classes().that().resideInAPackage("..domain..")
                .should().onlyBeAccessed().byClassesThat()
                .resideInAnyPackage("..study..", "..member..", "..domain..");

        domainPackageRule.check(classes);
        
        // TODO ..member.. 패키지에 있는 클래스는 ..study..와 ..member..에서만 참조할 수 있다. (반대로) ..domain.. 패키지는 ..member.. 패키지를 참조하지 못한다.
        ArchRule memberPackageRule = noClasses().that().resideInAPackage("..domain..")
                .should().accessClassesThat().resideInAPackage("..member..");

        memberPackageRule.check(classes);

        // TODO ..study.. 패키지에 있는 클래스는 ..study.. 에서만 참조할 수 있다.
        ArchRule studyPackageRule = noClasses().that().resideOutsideOfPackage("..study..")
                .should().accessClassesThat().resideInAPackage("..study..");

        studyPackageRule.check(classes);

        // TODO 순환 참조 없어야 한다.
        ArchRule freeOfCycles = slices().matching("..architecturetest.(*)..")
                .should().beFreeOfCycles();
    }
}
