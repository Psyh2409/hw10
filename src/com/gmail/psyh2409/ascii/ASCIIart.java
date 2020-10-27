package com.gmail.psyh2409.ascii;

import java.util.*;

public class ASCIIart {
    private String text;
    private Map<Character, List<String>> map;

    public ASCIIart() {
        super();
        this.text = "";
        map = new HashMap<>();
        alphabetToMap();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<Character, List<String>> getMap() {
        return map;
    }

    public void setMap(Map<Character, List<String>> map) {
        this.map = map;
    }

    public void alphabetToMap(){
        map.put('A', Arrays.asList(
                "      *      ",
                "     * *     ",
                "    *   *    ",
                "   * * * *   ",
                "  *       *  ",
                " *         * "));
        map.put('B', Arrays.asList(
                " * * * * *   ",
                " *        *  ",
                " * * * * *   ",
                " *         * ",
                " *         * ",
                " * * * * *   "));
        map.put('C', Arrays.asList(
                "   * * * *   ",
                " *         * ",
                " *           ",
                " *           ",
                " *         * ",
                "   * * * *   "));
        map.put('D', Arrays.asList(
                " * * * * *   ",
                " *         * ",
                " *         * ",
                " *         * ",
                " *         * ",
                " * * * * *   "));
        map.put('E', Arrays.asList(
                " * * * * * * ",
                " *           ",
                " * * * *     ",
                " *           ",
                " *           ",
                " * * * * * * "));
        map.put('F', Arrays.asList(
                " * * * * * * ",
                " *           ",
                " * * * *     ",
                " *           ",
                " *           ",
                " *           "));
        map.put('G', Arrays.asList(
                "   * * * *   ",
                " *         * ",
                " *           ",
                " *       * * ",
                " *         * ",
                "   * * * *   "));
        map.put('H', Arrays.asList(
                " *         * ",
                " *         * ",
                " * * * * * * ",
                " *         * ",
                " *         * ",
                " *         * "));
        map.put('I', Arrays.asList(
                "    * * *    ",
                "      *      ",
                "      *      ",
                "      *      ",
                "      *      ",
                "    * * *    "));
        map.put('J', Arrays.asList(
                "   * * * * * ",
                "           * ",
                "           * ",
                "           * ",
                " *         * ",
                "   * * * *   "));
        map.put('K', Arrays.asList(
                " *         * ",
                " *      *    ",
                " * * *       ",
                " *     *     ",
                " *       *   ",
                " *         * "));
        map.put('L', Arrays.asList(
                " *           ",
                " *           ",
                " *           ",
                " *           ",
                " *           ",
                " * * * * * * "));
        map.put('M', Arrays.asList(
                " *         * ",
                " **       ** ",
                " * *     * * ",
                " *  *   *  * ",
                " *   * *   * ",
                " *    *    * "));
        map.put('N', Arrays.asList(
                " *         * ",
                " * *       * ",
                " *   *     * ",
                " *     *   * ",
                " *       * * ",
                " *         * "));
        map.put('O', Arrays.asList(
                "   * * * *   ",
                " *         * ",
                " *         * ",
                " *         * ",
                " *         * ",
                "   * * * *   "));
        map.put('P', Arrays.asList(
                " * * * * *   ",
                " *         * ",
                " *         * ",
                " * * * * *   ",
                " *           ",
                " *           "));
        map.put('Q', Arrays.asList(
                "   * * * *   ",
                " *         * ",
                " *         * ",
                " *         * ",
                " *       * * ",
                "   * * * * * "));
        map.put('R', Arrays.asList(
                " * * * * *   ",
                " *         * ",
                " *         * ",
                " * * * * *   ",
                " *       *   ",
                " *         * "));
        map.put('S', Arrays.asList(
                "   * * * *  ",
                " *        * ",
                "   * * *    ",
                "         *  ",
                " *        * ",
                "   * * * *  "));
        map.put('T', Arrays.asList(
                "  * * * * *  ",
                "      *      ",
                "      *      ",
                "      *      ",
                "      *      ",
                "      *      "));
        map.put('U', Arrays.asList(
                " *         * ",
                " *         * ",
                " *         * ",
                " *         * ",
                " *         * ",
                "   * * * *   "));
        map.put('V', Arrays.asList(
                " *         * ",
                "  *       *  ",
                "   *     *   ",
                "    *   *    ",
                "     * *     ",
                "      *      "));
        map.put('W', Arrays.asList(
                " *         * ",
                " *         * ",
                " *    *    * ",
                " *   * *   * ",
                " * *     * * ",
                " *         * "));
        map.put('X', Arrays.asList(
                "  *       *  ",
                "    *   *    ",
                "      *      ",
                "     * *     ",
                "   *     *   ",
                " *         * "));
        map.put('Y', Arrays.asList(
                " *         * ",
                "   *     *   ",
                "     * *     ",
                "      *      ",
                "      *      ",
                "      *      "));
        map.put('Z', Arrays.asList(
                " * * * * * * ",
                "         *   ",
                "       *     ",
                "     *       ",
                "   *         ",
                " * * * * * * "));
        map.put(' ', Arrays.asList(
                "             ",
                "             ",
                "             ",
                "             ",
                "             ",
                "             "));
    }

    public void printASCII(String text){
        List<StringBuilder> lsb = new ArrayList<>();
        if (text == null) {return;}
        this.text = text;
        for (int i = 0; i < 6; i++) {
            Character character = text.toUpperCase().charAt(0);
            List<String> ls = map.get(character);
            String str = ls.get(i).replace('*', character);
            StringBuilder sb = new StringBuilder();
            boolean add = lsb.add(sb.append(str));
        }
        for (int i = 1; i < text.length(); i++) {
            char c = text.toUpperCase().charAt(i);
            for (int j = 0; j < 6; j++) {
                lsb.get(j).append(map.get(c).get(j).replace('*', c));
            }
        }
        for (StringBuilder sb: lsb) {
            System.out.println(sb);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ASCIIart asciIart = (ASCIIart) o;
        return Objects.equals(text, asciIart.text) &&
                Objects.equals(map, asciIart.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, map);
    }

    @Override
    public String toString() {
        return "ASCIIart{" +
                "text='" + text + '\'' +
                ", map=" + map +
                '}';
    }
}
