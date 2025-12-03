package net.laedanrex.santa;

import net.laedanrex.santa.day01.Counter;

import java.nio.file.Files;
import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws Exception {
        day01();
    }

    static void day01() throws Exception {

        Counter counter = new Counter();
        counter.printHeader();
        Files.lines(ResourcesUtils.getResourcePath("day01/input_2"))
                .forEach(line -> {
                    counter.readLine(line);
                    counter.print();
                });
        counter.printHeader();
        System.out.println(LocalDateTime.now());
        //input 1 :  R36     |      93 |    6558 |    1135
        //input 2 :  R36     |      93 |    6558 |    1135
    }

}
