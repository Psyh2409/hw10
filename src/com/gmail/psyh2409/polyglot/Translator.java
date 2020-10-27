package com.gmail.psyh2409.polyglot;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public class Translator implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, String> map;
    private File fileThis;
    private File fileEngIn;
    private File fileUaOut;

    public Translator() {
        super();
    }

    public Translator(String fileThisName, String fileEngInName, String fileUaOutName) {
        super();
        map = new HashMap<>();
        fileThis = new File(fileThisName);
        fileEngIn = new File(fileEngInName);
        fileUaOut = new File(fileUaOutName);
    }

    //
    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public File getFile() {
        return fileThis;
    }

    public void setFile(File file) {
        this.fileThis = file;
    }

    public boolean saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileThis))) {
            oos.writeObject(this);
            return true;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return false;
    }

    public Translator readFromFile() {
        Translator translator = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileThis))) {
            translator = (Translator) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return translator;
    }

    public String textReader() {
        StringBuilder sb = new StringBuilder("");
        if (fileEngIn.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileEngIn))) {
                String s = "";
                while (br.ready()) {
                    s = br.readLine();
                    sb.append(s);
                }
                return sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public boolean textWriter(String ua) {
        if (ua == null) {
            return false;
        }
        if (fileUaOut.exists()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileUaOut))) {
                oos.writeObject(ua);
                return true;
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return false;
    }

    public String stringTranslate(String eng, BufferedReader br) throws IOException {
        boolean isUpperCase = false;
        String ua = "";
        if (eng != null) {
            isUpperCase = !eng.equals(eng.toLowerCase());
            if (map.containsKey(eng.toLowerCase())) {
                ua = map.get(eng.toLowerCase());
            } else {
                ua = putNewWord(eng, br);
            }
        }
        String a = ua.substring(0, 1).toUpperCase() + ua.substring(1);
        return isUpperCase ? a : ua;
    }

    public String translateText(String eng) {
        String[] other;
        String[] words;
        StringBuilder builder = new StringBuilder("");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            if (eng != null) {
                other = eng.split("\\w+");
                words = eng.split("\\W+");
                for (int i = 0; i < other.length; i++) {
                    if (i < other.length - 1) {
                        builder.append(other[i]);
                        if (Pattern.compile("-?\\d+(\\.\\d+)?").matcher(words[i]).matches()) {
                            builder.append(words[i]);
                        } else {
                            builder.append(stringTranslate(words[i], br));
                        }
                    } else {
                        builder.append(other[i]);
                    }
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return builder.toString();
    }

    private String putNewWord(String eng, BufferedReader br) throws IOException {
        String ua = "";
        if (eng != null) {
            System.out.println("Please, enter ukrainian word, that is analog of \"" + eng.toLowerCase() + "\"");
            ua = br.readLine();
            map.put(eng.toLowerCase(), ua.toLowerCase());
        }
        return ua;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Translator that = (Translator) o;
        return Objects.equals(map, that.map) &&
                Objects.equals(fileThis, that.fileThis) &&
                Objects.equals(fileEngIn, that.fileEngIn) &&
                Objects.equals(fileUaOut, that.fileUaOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map, fileThis, fileEngIn, fileUaOut);
    }

    @Override
    public String toString() {
        return "Translator{" +
                "map=" + map +
                ", fileThis=" + fileThis +
                ", fileEngIn=" + fileEngIn +
                ", fileUaOut=" + fileUaOut +
                '}';
    }
}
