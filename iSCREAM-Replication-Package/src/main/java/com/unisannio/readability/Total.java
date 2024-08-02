/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisannio.readability;

import java.util.ArrayList;

/**
 *
 * @author Michele Fredella
 */
public class Total {

    String nameContract, type, nome;
    int sloc, lloc, cloc, blank, cicli, numIf, numKeyord, numPar, numOpa, numOpC, numAss, numVir, numPer, numSpace, identifier, numNumber, maxLineIndentation, maxLenIdentifier, maxLenLenght, maxChar;
    double mediaLenIden, mediaLineLen, mediaLineIndentation;

    String max;
    ArrayList<String> oct;

    public Total(String nameContract, String type, String nome, int sloc, int lloc, int cloc, int blank, int cicli, int numIf, int numKeyord, int numPar, int numOpa, int numOpC, int numAss, int numVir, int numPer, int numSpace, int identifier, double mediaLenIden, double mediaLineLen, String max, ArrayList<String> oct, int numNumber, double mediaLineIndentation, int maxLineIndentation, int maxLenIdentifier, int maxLenLenght, int maxChar) {
        this.nameContract = nameContract;
        this.type = type;
        this.nome = nome;
        this.sloc = sloc;
        this.lloc = lloc;
        this.cloc = cloc;
        this.blank = blank;
        this.cicli = cicli;
        this.numIf = numIf;
        this.numKeyord = numKeyord;
        this.numPar = numPar;
        this.numOpa = numOpa;
        this.numOpC = numOpC;
        this.numAss = numAss;
        this.numVir = numVir;
        this.numPer = numPer;
        this.numSpace = numSpace;
        this.identifier = identifier;
        this.mediaLenIden = mediaLenIden;
        this.mediaLineLen = mediaLineLen;
        this.max = max;
        this.oct = oct;
        this.numNumber = numNumber;
        this.mediaLineIndentation = mediaLineIndentation;
        this.maxLineIndentation = maxLineIndentation;
        this.maxLenIdentifier = maxLenIdentifier;
        this.maxLenLenght = maxLenLenght;
        this.maxChar = maxChar;
    }

    public int getMaxChar() {
        return maxChar;
    }

    public void setMaxChar(int maxChar) {
        this.maxChar = maxChar;
    }

    public int getMaxLenLenght() {
        return maxLenLenght;
    }

    public void setMaxLenLenght(int maxLenLenght) {
        this.maxLenLenght = maxLenLenght;
    }

    public int getMaxLenIdentifier() {
        return maxLenIdentifier;
    }

    public void setMaxLenIdentifier(int maxLenIdentifier) {
        this.maxLenIdentifier = maxLenIdentifier;
    }

    public int getMaxLineIndentation() {
        return maxLineIndentation;
    }

    public void setMaxLineIndentation(int maxLineIndentation) {
        this.maxLineIndentation = maxLineIndentation;
    }

    public double getMediaLineLen() {
        return mediaLineLen;
    }

    public void setMediaLineLen(double mediaLineLen) {
        this.mediaLineLen = mediaLineLen;
    }

    public double getMediaLenIden() {
        return mediaLenIden;
    }

    public void setMediaLenIden(double mediaLenIden) {
        this.mediaLenIden = mediaLenIden;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public ArrayList<String> getOct() {
        return oct;
    }

    public void setOct(ArrayList<String> oct) {
        this.oct = oct;
    }

    public String getNameContract() {
        return nameContract;
    }

    public void setNameContract(String nameContract) {
        this.nameContract = nameContract;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSloc() {
        return sloc;
    }

    public void setSloc(int sloc) {
        this.sloc = sloc;
    }

    public int getLloc() {
        return lloc;
    }

    public void setLloc(int lloc) {
        this.lloc = lloc;
    }

    public int getCloc() {
        return cloc;
    }

    public void setCloc(int cloc) {
        this.cloc = cloc;
    }

    public int getBlank() {
        return blank;
    }

    public void setBlank(int blank) {
        this.blank = blank;
    }

    public int getCicli() {
        return cicli;
    }

    public void setCicli(int cicli) {
        this.cicli = cicli;
    }

    public int getNumIf() {
        return numIf;
    }

    public void setNumIf(int numIf) {
        this.numIf = numIf;
    }

    public int getNumKeyord() {
        return numKeyord;
    }

    public void setNumKeyord(int numKeyord) {
        this.numKeyord = numKeyord;
    }

    public int getNumPar() {
        return numPar;
    }

    public void setNumPar(int numPar) {
        this.numPar = numPar;
    }

    public int getNumOpa() {
        return numOpa;
    }

    public void setNumOpa(int numOpa) {
        this.numOpa = numOpa;
    }

    public int getNumOpC() {
        return numOpC;
    }

    public void setNumOpC(int numOpC) {
        this.numOpC = numOpC;
    }

    public int getNumAss() {
        return numAss;
    }

    public void setNumAss(int numAss) {
        this.numAss = numAss;
    }

    public int getNumVir() {
        return numVir;
    }

    public void setNumVir(int numVir) {
        this.numVir = numVir;
    }

    public int getNumPer() {
        return numPer;
    }

    public void setNumPer(int numPer) {
        this.numPer = numPer;
    }

    public int getNumSpace() {
        return numSpace;
    }

    public void setNumSpace(int numSpace) {
        this.numSpace = numSpace;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public void setMediaLenIden(int mediaLenIden) {
        this.mediaLenIden = mediaLenIden;
    }

    public int getNumNumber() {
        return numNumber;
    }

    public void setNumNumber(int numNumber) {
        this.numNumber = numNumber;
    }

    public double getMediaLineIndentation() {
        return mediaLineIndentation;
    }

    public void setMediaLineIndentation(double mediaLineIndentation) {
        this.mediaLineIndentation = mediaLineIndentation;
    }

    @Override
    public String toString() {
        return "Metric{" + "nameContract=" + nameContract + ", type=" + type + ", nome=" + nome + ", sloc=" + sloc + ", lloc=" + lloc + ", cloc=" + cloc + ", blank=" + blank + ", cicli=" + cicli + ", numIf=" + numIf + ", numKeyord=" + numKeyord + ", numPar=" + numPar + ", numOpa=" + numOpa + ", numOpC=" + numOpC + ", numAss=" + numAss + ", numVir=" + numVir + ", numPer=" + numPer + ", numSpace=" + numSpace + ", identifier=" + identifier + ", mediaLenIden=" + mediaLenIden + ", numNumber=" + numNumber + '}';
    }

}
