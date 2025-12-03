package net.laedanrex.santa.day02;

import net.laedanrex.santa.ResourcesUtils;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;

class IDValidatorTest {

    @Test
    void validateID() throws Exception {
        IDValidator validator = new IDValidator();
        Files.lines(ResourcesUtils.getResourcePath("day02/input_01_test"))
                .forEach(validator::addRanges);
        System.out.println(validator.getAllInvalidIDS());
        System.out.println("SUM=" + validator.sumOfAllInvalid());
    }

}