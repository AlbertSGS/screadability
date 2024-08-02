package com.unisannio.utility;

import com.unisannio.readability.LetterFrequency;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LOCCompute {

    private String separator;

    private ArrayList<Integer> lineLenght, indentation;
    private int numPar, numOpA, numOpC;
    private int lloc;
    private int cloc;
    private int start;
    private int end;
    private int numAss;
    private int numVir;
    private int numPer;
    private int numSpace;
    private int maxChar;

    public LOCCompute(String separator, int start, int end) {
        this.separator = separator;
        lloc = cloc = 0;
        this.start = start;
        this.end = end;

    }

    public Integer Blank(ArrayList<String> code) {
        int s = 0;
        ArrayList<String> app = new ArrayList<String>();

        for (int i = start; i <= end; i++) {
            app.add(code.get(i));
            StringTokenizer st = new StringTokenizer(code.get(i), "\n");

            while (st.hasMoreTokens()) {
                String x = st.nextToken();

                s++;
            }

        }
        int diff = app.size() - s;
        return diff;
    }

    public void calculateLOCMetrics(ArrayList<String> code) {
        lineLenght = new ArrayList<Integer>();
        for (int i = start; i <= end; i++) {
            String x = code.get(i);
            if (!x.trim().isEmpty()) {
                if (!x.trim().startsWith("/*") && !x.trim().startsWith("*") && !x.trim().startsWith("//") && !x.trim().endsWith("*/")) {
                    lloc++;
                    lineLenght.add(x.length());
                    if (x.trim().contains("//")) {
                        cloc++;
                    }
                } else {
                    cloc++;
                }
            }
        }

    }

    public void calculateMaxChar(ArrayList<String> code) {
        String app = "";
        for (int i = start; i <= end; i++) {
            StringTokenizer st = new StringTokenizer(code.get(i), " ");
            while (st.hasMoreTokens()) {
                String x = st.nextToken();

                if (!x.trim().isEmpty()) {
                    if (!x.trim().startsWith("/*") && !x.trim().startsWith("*") && !x.trim().startsWith("//") && !x.trim().endsWith("*/")) {
                        app = app + x;
                    }
                }
            }
        }
        maxChar = LetterFrequency.letterFrequency(app);
    }

    public void calculateIndentation(ArrayList<String> code) {
        indentation = new ArrayList<Integer>();
        for (int i = start; i <= end; i++) {
            String x = code.get(i);
            if (!x.trim().isEmpty()) {
                if (!x.trim().startsWith("/*") && !x.trim().startsWith("*") && !x.trim().startsWith("//") && !x.trim().endsWith("*/")) {

                    indentation.add(leadingBlanks(x));

                }
            }
        }

    }

    int leadingBlanks(String s) {
        int i = 0;
        int blanks = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                blanks++;
            } else if (s.charAt(i) == '\t') {
                blanks += 4;
            } else {
                break;
            }
            i++;
        }
        return blanks;
    }

    public void calculateNumPar(ArrayList<String> code) {
        for (int i = start; i <= end; i++) {
            StringTokenizer st = new StringTokenizer(code.get(i), "\n");
            while (st.hasMoreTokens()) {
                String x = st.nextToken();
                if (!x.trim().startsWith("/*") && !x.trim().startsWith("*") && !x.trim().startsWith("//") && !x.trim().endsWith("*/")) {
                    StringTokenizer st1 = new StringTokenizer(code.get(i));
                    while (st1.hasMoreTokens()) {
                        String x1 = st1.nextToken();
                        for (int y = 0; y <= x1.length() - 1; y++) {
                            if (x1.charAt(y) == '(') {
                                numPar++;
                            } else if (x1.charAt(y) == ')') {
                                numPar++;
                            } else if (x1.charAt(y) == '{') {
                                numPar++;
                            } else if (x1.charAt(y) == '}') {
                                numPar++;
                            }
                        }

                    }
                }

            }
        }
    }

    public void calculateNumVir(ArrayList<String> code) {
        for (int i = start; i <= end; i++) {
            StringTokenizer st = new StringTokenizer(code.get(i), "\n");
            while (st.hasMoreTokens()) {
                String x = st.nextToken();
                if (!x.trim().startsWith("/*") && !x.trim().startsWith("*") && !x.trim().startsWith("//") && !x.trim().endsWith("*/")) {
                    StringTokenizer st1 = new StringTokenizer(code.get(i));
                    while (st1.hasMoreTokens()) {
                        String x1 = st1.nextToken();
                        for (int y = 0; y <= x1.length() - 1; y++) {
                            if (x1.charAt(y) == ',') {
                                numVir++;
                            }
                        }

                    }
                }

            }
        }
    }

    public void calculateNumPeriod(ArrayList<String> code) {
        for (int i = start; i <= end; i++) {
            StringTokenizer st = new StringTokenizer(code.get(i), "\n");
            while (st.hasMoreTokens()) {
                String x = st.nextToken();
                if (!x.trim().startsWith("/*") && !x.trim().startsWith("*") && !x.trim().startsWith("//") && !x.trim().endsWith("*/")) {
                    StringTokenizer st1 = new StringTokenizer(code.get(i));
                    while (st1.hasMoreTokens()) {
                        String x1 = st1.nextToken();
                        for (int y = 0; y <= x1.length() - 1; y++) {
                            if (x1.charAt(y) == '.') {
                                numPer++;
                            }
                        }

                    }
                }

            }
        }
    }

    public void calculateNumSpace(ArrayList<String> code) {
        for (int i = start; i <= end; i++) {
            StringTokenizer st = new StringTokenizer(code.get(i), "\n");

            while (st.hasMoreTokens()) {
                String x = st.nextToken();

                if (!x.trim().startsWith("/*") && !x.trim().startsWith("*") && !x.trim().startsWith("//") && !x.trim().endsWith("*/")) {

                    for (int y = 0; y <= x.length() - 1; y++) {
                        if (x.charAt(y) == ' ') {
                            numSpace++;
                        }
                    }
                }

            }
        }
    }

    public void calculateNumOP(ArrayList<String> code) {
        for (int i = start; i <= end; i++) {
            StringTokenizer st = new StringTokenizer(code.get(i), "\n");
            while (st.hasMoreTokens()) {
                String x = st.nextToken();

                if (!x.trim().startsWith("/*") && !x.trim().startsWith("*") && !x.trim().startsWith("//") && !x.trim().endsWith("*/")) {
                    StringTokenizer st1 = new StringTokenizer(code.get(i));
                    while (st1.hasMoreTokens()) {
                        String x1 = st1.nextToken();
                        if (x1.contains("++")) {
                            numOpA = numOpA + 2;
                        } else if (x1.contains("--")) {
                            numOpA = numOpA + 2;
                        } else if (x1.contains("+") || x1.contains("*") || x1.contains("%") || x1.contains("-") || x1.contains("/")) {
                            numOpA++;
                        } else if (x1.contains("==") || x1.contains("<=") || x1.contains(">=")) {
                            numOpC = numOpC + 2;

                        } else if (x1.contains("<") || x1.contains(">")) {
                            numOpC++;

                        } else if (x1.contains("=")) {
                            numAss++;

                        }
                    }
                }

            }
        }
    }

    public int getMaxChar() {
        return maxChar;
    }

    public void setMaxChar(int maxChar) {
        this.maxChar = maxChar;
    }

    public int getNumOpA() {
        return numOpA;
    }

    public int getNumOpC() {
        return numOpC;
    }

    public int getNumAss() {
        return numAss;
    }

    public int getLLOC() {
        return lloc;
    }

    public int getCLOC() {
        return cloc;
    }

    public ArrayList<Integer> getLineLenght() {
        return lineLenght;
    }

    public int getNumPar() {
        return numPar;
    }

    public int getNumVir() {
        return numVir;
    }

    public int getNumPer() {
        return numPer;
    }

    public int getNumSpace() {
        return numSpace;
    }

    public ArrayList<Integer> getIndentation() {
        return indentation;
    }

    public void setIndentation(ArrayList<Integer> indentation) {
        this.indentation = indentation;
    }

}
