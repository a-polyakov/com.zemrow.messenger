package com.zemrow.messenger.server;

import java.util.Scanner;

/**
 * Запуск сервера
 *
 * @author Alexandr Polyakov on 2018.06.17
 */
public class RunServer {
    public static void main(String[] args) throws Exception {
        final ServerConfiguration serverConfiguration = new ServerConfiguration(args);
        try (final ServerContext serverContext = new ServerContext(serverConfiguration)) {
            try (final Scanner scanner = new Scanner(System.in)) {
                while (!"exit".equals(scanner.nextLine())) ;
            }
        }
    }
}
