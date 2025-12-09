package cleancode;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "cleancode")
public class ArchitectureTest {

        @ArchTest
        public static final ArchRule classes_should_not_access_standard_streams = noClasses().should()
                        .accessClassesThat()
                        .belongToAnyOf(java.lang.System.class)
                        .because("System.out usage should be replaced by a Logger for better control and testing");

        // Another rule that should pass to show mixed results if the above fails
        @ArchTest
        public static final ArchRule classes_should_be_in_correct_package = noClasses().that()
                        .resideInAPackage("cleancode")
                        .should().dependOnClassesThat().resideInAPackage("java.sql");
}
