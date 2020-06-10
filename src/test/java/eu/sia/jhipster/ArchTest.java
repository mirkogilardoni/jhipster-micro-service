package eu.sia.jhipster;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("eu.sia.jhipster");

        noClasses()
            .that()
            .resideInAnyPackage("eu.sia.jhipster.service..")
            .or()
            .resideInAnyPackage("eu.sia.jhipster.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..eu.sia.jhipster.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
