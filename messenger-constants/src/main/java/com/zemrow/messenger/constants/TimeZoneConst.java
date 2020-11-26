package com.zemrow.messenger.constants;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;

/**
 * Константы существующих часовых поясов
 *
 * @author Alexandr Polyakov on 2020.10.30
 */
public class TimeZoneConst {

    /**
     * Europe/Moscow
     */
    public static final ZoneId MSK = ZoneId.of("Europe/Moscow");


    /**
     * Получить список доступных часовых поясов
     *
     * @param args
     */
    public static void main(String[] args) {
        boolean onlyOffset = true;
        if (onlyOffset) {
            final Map<Integer, List<String>> timeZoneShortNameMap = new TreeMap<>();
            for (String timeZoneName : ZoneId.getAvailableZoneIds()) {
                final TimeZone timeZone = TimeZone.getTimeZone(timeZoneName);
                final Integer offset = timeZone.getRawOffset();
                List<String> timeZoneNameList = timeZoneShortNameMap.get(offset);
                if (timeZoneNameList == null) {
                    timeZoneNameList = new ArrayList<>();
                    timeZoneShortNameMap.put(offset, timeZoneNameList);
                }
                timeZoneNameList.add(timeZoneName);
            }

            for (Map.Entry<Integer, List<String>> entry : timeZoneShortNameMap.entrySet()) {
                final Integer offset = entry.getKey();
                final ZoneOffset zoneOffset = ZoneOffset.ofTotalSeconds(offset / 1000);
                final String constName = "UTC" + zoneOffset.getId().replace('-', '_').replace("+", "").replace(":", "").replace("Z", "");
                System.out.println(getDoc(entry.getValue())
                        .append("    public static final TimeZone ").append(constName)
                        .append(" = TimeZone.getTimeZone(ZoneOffset.ofTotalSeconds(" + zoneOffset.getTotalSeconds() + "));\n").toString());
            }
        } else {
            final Map<String, List<String>> timeZoneShortNameMap = new TreeMap<>();
            for (String timeZoneName : TimeZone.getAvailableIDs()) {
                final TimeZone timeZone = TimeZone.getTimeZone(timeZoneName);
                final String timeZoneShortName = timeZone.getDisplayName(false, TimeZone.SHORT);
                List<String> timeZoneNameList = timeZoneShortNameMap.get(timeZoneShortName);
                if (timeZoneNameList == null) {
                    timeZoneNameList = new ArrayList<>();
                    timeZoneShortNameMap.put(timeZoneShortName, timeZoneNameList);
                }
                timeZoneNameList.add(timeZoneName);
            }

            for (Map.Entry<String, List<String>> entry : timeZoneShortNameMap.entrySet()) {
                final String constName = entry.getKey().replace('-', '_').replace("+", "").replace(":", "");
                System.out.println(getDoc(entry.getValue())
                        .append("    public static final TimeZone ").append(constName)
                        .append(" = TimeZone.getTimeZone(\"").append(entry.getValue().get(0)).append("\");\n").toString());
            }
        }
    }

    public static StringBuilder getDoc(final List<String> timeZoneNameList) {
        timeZoneNameList.sort(String::compareTo);
        final StringBuilder timeZoneNameListStr = new StringBuilder("    /**\n")
                .append("     * ");
        for (String timeZoneName : timeZoneNameList) {
            timeZoneNameListStr.append(timeZoneName).append(", ");
        }
        timeZoneNameListStr.setLength(timeZoneNameListStr.length() - 2);
        timeZoneNameListStr.append('\n')
                .append("     */\n");
        return timeZoneNameListStr;
    }
}
