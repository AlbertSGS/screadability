/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisannio.utility;

import com.unisannio.readability.ContractVisitor2;
import com.unisannio.readability.Total;
import hu.sed.parser.antlr4.grammar.solidity.SolidityLexer;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

/**
 *
 * @author Michele Fredella
 */
public class CalculatorMetrics {

    private static ArrayList<String> totalCode;
    private static int size = 0;

    static String readFile(String path, Charset encoding) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        totalCode = new ArrayList<String>();
        while (line != null) {
            size++;
            totalCode.add(line);
            line = reader.readLine();
        }
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static ArrayList<ArrayList<Object>> metric(File f) throws IOException {
        ArrayList<Object> recordFunzioni = null;
        ArrayList<ArrayList<Object>> tot = new ArrayList<ArrayList<Object>>();

        String contractCode = readFile(f.getPath(), Charset.forName("UTF-8"));
        CharStream charStream = CharStreams.fromString(contractCode);
        SolidityLexer lexer = new SolidityLexer(charStream);
        TokenStream tokens = new CommonTokenStream(lexer);
        SolidityParser parser = new SolidityParser(tokens);
        ContractVisitor2 contract = new ContractVisitor2(contractCode, totalCode);
        contract.visit(parser.sourceUnit());

        Map<String, Total> functionMetric = contract.getFunctionMetric();
        Map<String, Total> totalContract = contract.getTotalContract();
        size = totalContract.size() + size;

        for (String con : functionMetric.keySet()) {
            recordFunzioni = new ArrayList<Object>();
            Total d = functionMetric.get(con);
            int sloc = d.getSloc();
            recordFunzioni.add(f.getName());
            recordFunzioni.add(d.getNameContract());

            recordFunzioni.add(d.getNome());

            recordFunzioni.add(d.getSloc());

            recordFunzioni.add(Double.toString((double) d.getNumAss() / sloc).replace(".", ","));//1 SLOOC
            recordFunzioni.add(Double.toString((double) d.getBlank() / sloc).replace(".", ","));//2 SLOOC
            recordFunzioni.add(Double.toString((double) d.getNumVir() / sloc).replace(".", ","));//3 SLOOC
            recordFunzioni.add(Double.toString((double) d.getCloc() / sloc).replace(".", ","));//4 SLOOC
            recordFunzioni.add(Double.toString((double) d.getNumOpC() / sloc).replace(".", ","));//5 SLOOC
            recordFunzioni.add(Double.toString((double) d.getMediaLenIden()).replace(".", ","));//6
            recordFunzioni.add(Double.toString((double) d.getNumIf() / sloc).replace(".", ","));//7 SLOOC
            recordFunzioni.add(Double.toString(d.getMediaLineIndentation()).replace(".", ","));//8
            recordFunzioni.add(Double.toString((double) d.getNumKeyord() / sloc).replace(".", ","));//9 SLOOC
            recordFunzioni.add(Double.toString(d.getMediaLineLen()).replace(".", ","));//10
            recordFunzioni.add(Double.toString((double) d.getCicli() / sloc).replace(".", ","));//11 SLOOC
            recordFunzioni.add(Double.toString((double) d.getIdentifier() / sloc).replace(".", ","));//12 SLOOC
            recordFunzioni.add(Double.toString((double) d.getNumNumber() / sloc).replace(".", ","));//13 SLOOC

            recordFunzioni.add(Double.toString((double) d.getNumOpa() / sloc).replace(".", ","));//14 SLOOC
            recordFunzioni.add(Double.toString((double) d.getNumPar() / sloc).replace(".", ","));//15 SLOOC
            recordFunzioni.add(Double.toString((double) d.getNumPer() / sloc).replace(".", ","));//16 SLOOC
            recordFunzioni.add(Double.toString((double) d.getNumSpace() / sloc).replace(".", ","));//17 SLOOC
            recordFunzioni.add(d.getMaxLenIdentifier());
            recordFunzioni.add(d.getMaxLineIndentation());
            recordFunzioni.add(d.getNumKeyord());
            recordFunzioni.add(d.getMaxLenLenght());
            recordFunzioni.add(d.getIdentifier());
            recordFunzioni.add(d.getNumNumber());
            recordFunzioni.add(d.getMaxChar());
            recordFunzioni.add(d.getMax());
            tot.add(recordFunzioni);
        }

        return tot;
    }
}
