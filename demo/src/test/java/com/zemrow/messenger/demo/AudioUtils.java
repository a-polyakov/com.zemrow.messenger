package com.zemrow.messenger.demo;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Синтез речи
 *
 * @author Alexandr Polyakov on 2019.01.14
 */
public class AudioUtils {
    //TODO
    private static final String KEY = "069b6659-984b-4c5f-880e-aaedcfd84102";

    public static void speak(String text) throws Exception {
        if (text != null && !text.isEmpty()) {
            String fileName = text + ".wav";
            fileName = fileName.replace('“', '_');
            fileName = fileName.replace('”', '_');
            fileName = fileName.replace('\\', '_');
            fileName = fileName.replace('/', '_');
            final File file = new File("drivers", fileName);
            if (!file.exists()) {
                String urlStr = "https://tts.voicetech.yandex.net/generate?" +
                        "key=" + KEY +
                        "&text=" + URLEncoder.encode(text, "UTF-8") +
                        "&format=wav" +
                        "&lang=ru-RU" +
                        "&speed=1.1" +
                        "&speaker=oksana";

                // Список голосов
                // -levitan
                // ermilov 1.3
                // -zahar
                // silaerkan 1.0
                // + oksana 1.1
                // -jane
                // -omazh
                // kolya
                // kostya
                // -nastya
                // sasha
                // nick
                // +erkanyavas
                // zhenya
                // tanya
                // ermil
                // anton_samokhvalov
                // tatyana_abramova
                // voicesearch
                // +alyss
                // ermil_with_tuning
                // robot
                // +dude
                // +zombie
                // smoky

                final HttpURLConnection connection = (HttpURLConnection) new URL(urlStr).openConnection();
                connection.connect();
                try (InputStream inputStream = connection.getInputStream()) {
                    byte buffer[] = new byte[1 << 12];
                    try (OutputStream outputStream = new FileOutputStream(file)) {
                        int read;
                        while ((read = inputStream.read(buffer)) > 0) {
                            outputStream.write(buffer, 0, read);
                        }
                    }
                }
            }

            final AudioInputStream ais = AudioSystem.getAudioInputStream(file);

            try (final Clip clip = AudioSystem.getClip()) {
                clip.open(ais);
                clip.start();
                while (!clip.isRunning())
                    Thread.sleep(10);
                while (clip.isRunning())
                    Thread.sleep(10);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        speak("Здравствуйте.");
    }
}
