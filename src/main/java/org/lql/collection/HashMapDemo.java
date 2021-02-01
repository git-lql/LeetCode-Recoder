package org.lql.collection;

import org.apache.log4j.Logger;

import java.util.*;

/**
 * @author: lql
 * @date: 2020/12/24 14:24
 * @description: HashMap Demo
 */
public class HashMapDemo {

    private static Logger logger = Logger.getLogger("HashMapDemo");

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(10);
        map.put("1", "11");
        map.put("2", "22");
        map.put("3", "33");
        map.put("4", "44");
        map.put("5", "55");
        keySetTraverseHashMap(map);
        valueTraverseHashMap(map);
        entrySetTraverseHashMap(map);

        hashMapTest(map);
    }

    /**
     * entrySet遍历
     *
     * @param map HashMap
     */
    private static void entrySetTraverseHashMap(HashMap<String, String> map) {
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            logger.debug(key + " : " + value);
        }
    }

    /**
     * value遍历
     *
     * @param map HashMap
     */
    private static void valueTraverseHashMap(HashMap<String, String> map) {
        Collection<String> values = map.values();
        for (String value : values) {
            logger.debug(value);
        }
    }

    /**
     * keySet遍历
     *
     * @param map HashMap
     */
    private static void keySetTraverseHashMap(HashMap<String, String> map) {
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            logger.debug(key);
        }
    }

    private static void hashMapTest(HashMap<String, String> map) {
        Set<String> keySet = map.keySet();
        logger.debug("keySet: " + keySet);

        Collection<String> values = map.values();
        logger.debug("values: " + values);

        Set<Map.Entry<String, String>> entries = map.entrySet();
        logger.debug("entries: " + entries);
    }
}
