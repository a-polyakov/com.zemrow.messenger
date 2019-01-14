package com.zemrow.messenger;

import java.io.IOException;
import java.util.Scanner;

/**
 * Запуск сервера
 *
 * @author Alexandr Polyakov on 2018.06.17
 */
public class RunApplication {
    public static void main(String[] args) throws IOException {
        final AppConfiguration appConfiguration = new AppConfiguration(args);
        try (final AppContext appContext = new AppContext(appConfiguration)) {
            try (final Scanner scanner = new Scanner(System.in)) {
                while (!"exit".equals(scanner.nextLine())) ;
            }
        }
    }
}
