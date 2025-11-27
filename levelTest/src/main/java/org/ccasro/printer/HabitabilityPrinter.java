package org.ccasro.printer;

import org.ccasro.interfaces.Habitable;

public class HabitabilityPrinter {
    public void printReport(Habitable body) {
        System.out.println("Habitability Analysis:");
        System.out.println(body.getHabitabilityReport());
    }
}
