package com.unisannio.readability;

import com.unisannio.utility.LOCCompute;
import hu.sed.parser.antlr4.grammar.solidity.SolidityBaseVisitor;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.antlr.v4.runtime.misc.NotNull;

/**
 *
 * @author Michele Fredella
 */
@SuppressWarnings("deprecation")
public class ContractVisitor2 extends SolidityBaseVisitor<Void> {

    private String sourceText;
    private ArrayList<String> totalCode;
    private SolidityParser.ContractDefinitionContext currentContract;
    private HashMap<String, Total> functionMetric = new HashMap<>();
    private HashMap<String, Total> totalContract = new HashMap<>();

    public ContractVisitor2(String sourceText, ArrayList<String> totalCode) {
        this.sourceText = sourceText;
        this.totalCode = totalCode;
    }
    private int slocTot, llocTot, clocTot, blankTot, cicliTot, numIfTot, numKeyordTot, numParTot, numOpaTot, numOpCTot, numAssTot, numVirTot, numPerTot, numSpaceTot, identifierTot, numNumberTot, maxLineIndentation, maxLenIdentifier, maxLenLenght, maxChar;
    private double mediaLenIdenTot, mediaLineLen, mediaLineIndentation;
    private String contractNameT, typeT, maxOccT;
    private ArrayList<String> occT;

    @Override
    public Void visitContractDefinition(@NotNull SolidityParser.ContractDefinitionContext ctx) {
        slocTot = 0;
        llocTot = 0;
        clocTot = 0;
        cicliTot = 0;
        numIfTot = 0;
        numKeyordTot = 0;
        numParTot = 0;
        numOpaTot = 0;
        numOpCTot = 0;
        numAssTot = 0;
        numVirTot = 0;
        numPerTot = 0;
        numSpaceTot = 0;
        identifierTot = 0;
        mediaLenIdenTot = 0;
        numNumberTot = 0;
        mediaLineIndentation = 0;
        mediaLineLen = 0;
        maxLineIndentation = 0;
        maxLenIdentifier = 0;
        maxLenLenght = 0;
        maxChar = 0;

        String contractName, type;
        currentContract = ctx;
        slocTot = (ctx.getStop().getLine() - ctx.getStart().getLine()) + 1;
        LOCCompute locCalc = new LOCCompute("\n", ctx.getStart().getLine() - 1, ctx.getStop().getLine() - 1);
        locCalc.calculateLOCMetrics(totalCode);
        llocTot = locCalc.getLLOC();
        clocTot = locCalc.getCLOC();
        blankTot = locCalc.Blank(totalCode);
        type = ctx.getChild(0).getText();

        contractName = ctx.getChild(1).getText();
        contractNameT = contractName;
        typeT = type;
        super.visitContractDefinition(ctx);
        return null;
    }

    @Override
    public Void visitModifierDefinition(@NotNull SolidityParser.ModifierDefinitionContext ctx) {
        int sloc, lloc, cloc, blank;
        String name, type, contract;
        sloc = (ctx.getStop().getLine() - ctx.getStart().getLine()) + 1;
        LOCCompute locCalc = new LOCCompute("\n", ctx.getStart().getLine() - 1, ctx.getStop().getLine() - 1);
        locCalc.calculateLOCMetrics(totalCode);
        lloc = locCalc.getLLOC();
        cloc = locCalc.getCLOC();
        blank = locCalc.Blank(totalCode);
        contract = currentContract.children.get(1).getText();
        type = ctx.getChild(0).getText();
        name = ctx.getChild(1).getText();
        locCalc.calculateLOCMetrics(totalCode);
        locCalc.calculateNumPar(totalCode);
        locCalc.calculateNumOP(totalCode);
        locCalc.calculateNumVir(totalCode);
        locCalc.calculateNumPeriod(totalCode);
        locCalc.calculateNumSpace(totalCode);
        locCalc.calculateMaxChar(totalCode);
        locCalc.calculateIndentation(totalCode);
        int cicli = new numCicliVisitor().visitModifierDefinition(ctx);
        cicliTot = cicliTot + cicli;
        int numif = new numIfVisitor().visitModifierDefinition(ctx);
        numIfTot = numIfTot + numif;
        int numKeyord = new keywordVisitor().visitModifierDefinition(ctx);
        numKeyordTot = numKeyordTot + numKeyord;
        int numPar = locCalc.getNumPar();
        numParTot = numParTot + numPar;
        int numOpA = locCalc.getNumOpA();
        numOpaTot = numOpaTot + numOpA;
        int numOpC = locCalc.getNumOpC();
        numOpCTot = numOpCTot + numOpC;
        int numAss = locCalc.getNumAss();
        numAssTot = numAssTot + numAss;
        int numVir = locCalc.getNumVir();
        numVirTot = numVirTot + numVir;
        int numPer = locCalc.getNumPer();
        numPerTot = numPerTot + numPer;
        int numSpace = locCalc.getNumSpace();
        numSpaceTot = numSpaceTot + numSpace;
        identifierVisitor ide = new identifierVisitor();
        int identifier = ide.visitModifierDefinition(ctx);
        identifierTot = identifierTot + identifier;
        ArrayList<Integer> identifierList = ide.getLenghtIdentifier();
        if (identifierList.size() > 0) {
            double sommaLenIden = 0;
            for (Integer a : identifierList) {
                sommaLenIden = sommaLenIden + a;
            }
            double mediaLenIden = sommaLenIden / identifierList.size();
            mediaLenIdenTot = mediaLenIden;
            Collections.sort(identifierList);
            Collections.reverse(identifierList);
            maxLenIdentifier = identifierList.get(0);
        } else {
            mediaLenIdenTot = 0;
            maxLenIdentifier = 0;
        }
        ArrayList<String> textIdent = ide.getIdentifierText();
        if (textIdent.size() > 0) {
            ArrayList<String> a = countFrequencies(textIdent);
            maxOccT = a.get(a.size() - 1).split(":")[1];
            occT = a;
        } else {
            maxOccT = "0";
            occT = new ArrayList<String>();
        }
        ArrayList<Integer> lineLen = locCalc.getLineLenght();
        double mediaLine;
        if (lineLen.size() > 0) {
            double sommaLineLen = 0;
            for (Integer a : lineLen) {
                sommaLineLen = sommaLineLen + a;
            }
            mediaLine = sommaLineLen / lineLen.size();
            mediaLineLen = mediaLine;
            Collections.sort(lineLen);
            Collections.reverse(lineLen);
            maxLenLenght = lineLen.get(0);
        } else {
            mediaLineLen = 0;
            maxLenLenght = 0;
        }
        ArrayList<Integer> indentation = locCalc.getIndentation();
        double mediaIndentationLine;
        if (indentation.size() > 0) {
            double sommaLineLen = 0;
            for (Integer a : indentation) {
                sommaLineLen = sommaLineLen + a;
            }
            mediaIndentationLine = sommaLineLen / indentation.size();
            mediaLineIndentation = mediaIndentationLine;
            Collections.sort(indentation);
            Collections.reverse(indentation);
            maxLineIndentation = indentation.get(0);
        } else {
            mediaLineIndentation = 0;
            maxLineIndentation = 0;
        }
        maxChar = locCalc.getMaxChar();
        int numNumber = new numberVisitor().visitModifierDefinition(ctx);
        numNumberTot = numNumberTot + numNumber;
        Total t = new Total(contract, type, name, sloc, lloc, cloc, blank, cicli, numif, numKeyord, numPar, numOpA, numOpC, numAss, numVir, numPer, numSpace, identifier, mediaLenIdenTot, mediaLineLen, maxOccT, occT, numNumber, mediaLineIndentation, maxLineIndentation, maxLenIdentifier, maxLenLenght, maxChar);
        functionMetric.put(name, t);
        Total t1 = new Total(contractNameT, typeT, name, slocTot, llocTot, clocTot, blankTot, cicliTot, numIfTot, numKeyordTot, numParTot, numOpaTot, numOpCTot, numAssTot, numVirTot, numPerTot, numSpaceTot, identifierTot, mediaLenIdenTot, mediaLineLen, null, null, numNumberTot, mediaLineIndentation, maxLineIndentation, maxLenIdentifier, maxLenLenght, maxChar);
        totalContract.put(contractNameT, t1);
        super.visitModifierDefinition(ctx);
        return null;
    }

    @Override
    public Void visitFunctionDefinition(@NotNull SolidityParser.FunctionDefinitionContext ctx) {
        int sloc, lloc, cloc, blank;
        String name, type, contract;
        sloc = (ctx.getStop().getLine() - ctx.getStart().getLine()) + 1;
        LOCCompute locCalc = new LOCCompute("\n", ctx.getStart().getLine() - 1, ctx.getStop().getLine() - 1);
        locCalc.calculateLOCMetrics(totalCode);
        lloc = locCalc.getLLOC();
        cloc = locCalc.getCLOC();
        blank = locCalc.Blank(totalCode);

        contract = currentContract.children.get(1).getText();
        type = ctx.getChild(0).getText();
        name = ctx.getChild(1).getText();
        locCalc.calculateLOCMetrics(totalCode);
        locCalc.calculateNumPar(totalCode);
        locCalc.calculateNumOP(totalCode);
        locCalc.calculateNumVir(totalCode);
        locCalc.calculateNumPeriod(totalCode);
        locCalc.calculateNumSpace(totalCode);
        locCalc.calculateMaxChar(totalCode);
        locCalc.calculateIndentation(totalCode);
        int cicli = new numCicliVisitor().visitFunctionDefinition(ctx);
        cicliTot = cicliTot + cicli;
        int numif = new numIfVisitor().visitFunctionDefinition(ctx);
        numIfTot = numIfTot + numif;
        int numKeyord = new keywordVisitor().visitFunctionDefinition(ctx);
        numKeyordTot = numKeyordTot + numKeyord;
        int numPar = locCalc.getNumPar();
        numParTot = numParTot + numPar;
        int numOpA = locCalc.getNumOpA();
        numOpaTot = numOpaTot + numOpA;
        int numOpC = locCalc.getNumOpC();
        numOpCTot = numOpCTot + numOpC;
        int numAss = locCalc.getNumAss();
        numAssTot = numAssTot + numAss;
        int numVir = locCalc.getNumVir();
        numVirTot = numVirTot + numVir;
        int numPer = locCalc.getNumPer();
        numPerTot = numPerTot + numPer;
        int numSpace = locCalc.getNumSpace();
        numSpaceTot = numSpaceTot + numSpace;
        identifierVisitor ide = new identifierVisitor();
        int identifier = ide.visitFunctionDefinition(ctx);
        identifierTot = identifierTot + identifier;
        ArrayList<Integer> identifierList = ide.getLenghtIdentifier();
        if (identifierList.size() > 0) {
            double sommaLenIden = 0;
            for (Integer a : identifierList) {
                sommaLenIden = sommaLenIden + a;
            }
            double mediaLenIden = sommaLenIden / identifierList.size();
            mediaLenIdenTot = mediaLenIden;
            Collections.sort(identifierList);
            Collections.reverse(identifierList);
            maxLenIdentifier = identifierList.get(0);
        } else {
            mediaLenIdenTot = 0;
            maxLenIdentifier = 0;
        }
        ArrayList<String> textIdent = ide.getIdentifierText();
        if (textIdent.size() > 0) {

            ArrayList<String> a = countFrequencies(textIdent);
            maxOccT = a.get(a.size() - 1).split(":")[1];
            occT = a;
        } else {
            maxOccT = "0";
            occT = new ArrayList<String>();
        }
        ArrayList<Integer> lineLen = locCalc.getLineLenght();
        double mediaLine;
        if (lineLen.size() > 0) {
            double sommaLineLen = 0;
            for (Integer a : lineLen) {
                sommaLineLen = sommaLineLen + a;
            }
            mediaLine = sommaLineLen / lineLen.size();
            mediaLineLen = mediaLine;
            Collections.sort(lineLen);
            Collections.reverse(lineLen);
            maxLenLenght = lineLen.get(0);
        } else {
            mediaLineLen = 0;
            maxLenLenght = 0;
        }
        maxChar = locCalc.getMaxChar();
        ArrayList<Integer> indentation = locCalc.getIndentation();
        double mediaIndentationLine;
        if (indentation.size() > 0) {
            double sommaLineLen = 0;
            for (Integer a : indentation) {
                sommaLineLen = sommaLineLen + a;
            }
            mediaIndentationLine = sommaLineLen / indentation.size();
            mediaLineIndentation = mediaIndentationLine;
            Collections.sort(indentation);
            Collections.reverse(indentation);
            maxLineIndentation = indentation.get(0);
        } else {
            mediaLineIndentation = 0;
            maxLineIndentation = 0;
        }
        int numNumber = new numberVisitor().visitFunctionDefinition(ctx);
        numNumberTot = numNumberTot + numNumber;
        Total t = new Total(contract, type, name, sloc, lloc, cloc, blank, cicli, numif, numKeyord, numPar, numOpA, numOpC, numAss, numVir, numPer, numSpace, identifier, mediaLenIdenTot, mediaLineLen, maxOccT, occT, numNumber, mediaLineIndentation, maxLineIndentation, maxLenIdentifier, maxLenLenght, maxChar);
        functionMetric.put(name, t);
        Total t1 = new Total(contractNameT, typeT, name, slocTot, llocTot, clocTot, blankTot, cicliTot, numIfTot, numKeyordTot, numParTot, numOpaTot, numOpCTot, numAssTot, numVirTot, numPerTot, numSpaceTot, identifierTot, mediaLenIdenTot, mediaLineLen, null, null, numNumberTot, mediaLineIndentation, maxLineIndentation, maxLenIdentifier, maxLenLenght, maxChar);
        totalContract.put(contractNameT, t1);
        super.visitFunctionDefinition(ctx);

        return null;
    }

    public HashMap<String, Total> getTotalContract() {
        return totalContract;
    }

    public HashMap<String, Total> getFunctionMetric() {
        return functionMetric;
    }

    public ArrayList<String> countFrequencies(ArrayList<String> list) {

        TreeMap<String, Integer> tmap = new TreeMap<String, Integer>();
        for (String t : list) {
            Integer c = tmap.get(t);
            tmap.put(t, (c == null) ? 1 : c + 1);
        }

        ArrayList<String> a = sortByValue(tmap);
        return a;

    }

    public <K, V extends Comparable<? super V>> ArrayList<String> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        ArrayList<String> app = new ArrayList<String>();
        for (Map.Entry<K, V> entry : list) {
            app.add(entry.getKey() + ":" + entry.getValue());
        }

        return app;
    }
}
