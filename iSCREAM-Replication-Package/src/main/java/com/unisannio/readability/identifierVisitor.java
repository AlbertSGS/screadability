package com.unisannio.readability;

import org.antlr.v4.runtime.misc.NotNull;

import hu.sed.parser.antlr4.grammar.solidity.SolidityBaseVisitor;

import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.AssemblyCallContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.AssemblyFunctionDefinitionContext;

import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.AssemblyIdentifierOrListContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.AssemblyItemContext;

import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.AssemblyStackAssignmentContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.ContractDefinitionContext;

import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.EnumDefinitionContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.EnumValueContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.EventDefinitionContext;

import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.FunctionDefinitionContext;

import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.LabelDefinitionContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.ModifierDefinitionContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.ModifierInvocationContext;

import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.NameValueContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.PragmaNameContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.PrimaryExpressionContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.StateVariableDeclarationContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.StructDefinitionContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.SubAssemblyContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.UsingForDeclarationContext;
import java.util.ArrayList;

@SuppressWarnings("deprecation")
public class identifierVisitor extends SolidityBaseVisitor<Integer> {

    private int numIdentifier;
    private ArrayList<Integer> lenghtIdentifier;
    private ArrayList<String> identifierText;

    public identifierVisitor() {
        numIdentifier = 0;
        lenghtIdentifier = new ArrayList<Integer>();
        identifierText = new ArrayList<String>();
    }

    @Override
    public Integer visitFunctionDefinition(@NotNull FunctionDefinitionContext ctx) {
        super.visitFunctionDefinition(ctx);
        return numIdentifier;
    }

    @Override
    public Integer visitModifierDefinition(@NotNull ModifierDefinitionContext ctx) {
        super.visitModifierDefinition(ctx);
        return numIdentifier;
    }

    @Override
    public Integer visitPrimaryExpression(@NotNull PrimaryExpressionContext ctx) {
        if (ctx.identifier() != null) {

            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            lenghtIdentifier.add(diff);

            identifierText.add(ctx.identifier().getText());
            numIdentifier++;
        }

        super.visitPrimaryExpression(ctx);
        return null;
    }

    @Override
    public Integer visitNameValue(@NotNull NameValueContext ctx) {
        if (ctx.identifier() != null) {
            numIdentifier++;
            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            identifierText.add(ctx.identifier().getText());
            lenghtIdentifier.add(diff);
        }

        super.visitNameValue(ctx);
        return null;
    }

    @Override
    public Integer visitAssemblyItem(@NotNull AssemblyItemContext ctx) {
        if (ctx.identifier() != null) {
            numIdentifier++;
            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            identifierText.add(ctx.identifier().getText());
            lenghtIdentifier.add(diff);
        }

        super.visitAssemblyItem(ctx);
        return null;
    }

    @Override
    public Integer visitPragmaName(@NotNull PragmaNameContext ctx) {
        if (ctx.identifier() != null) {
            numIdentifier++;
            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            identifierText.add(ctx.identifier().getText());
            lenghtIdentifier.add(diff);
        }

        super.visitPragmaName(ctx);
        return null;
    }

    @Override
    public Integer visitContractDefinition(@NotNull ContractDefinitionContext ctx) {
        if (ctx.identifier() != null) {
            numIdentifier++;
            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            identifierText.add(ctx.identifier().getText());
            lenghtIdentifier.add(diff);
        }

        super.visitContractDefinition(ctx);
        return null;
    }

    @Override
    public Integer visitStateVariableDeclaration(@NotNull StateVariableDeclarationContext ctx) {
        if (ctx.identifier() != null) {
            numIdentifier++;
            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            identifierText.add(ctx.identifier().getText());
            lenghtIdentifier.add(diff);
        }

        super.visitStateVariableDeclaration(ctx);
        return null;
    }

    @Override
    public Integer visitUsingForDeclaration(@NotNull UsingForDeclarationContext ctx) {
        if (ctx.identifier() != null) {
            numIdentifier++;
            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            lenghtIdentifier.add(diff);
            identifierText.add(ctx.identifier().getText());
        }

        super.visitUsingForDeclaration(ctx);
        return null;
    }

    @Override
    public Integer visitStructDefinition(@NotNull StructDefinitionContext ctx) {
        if (ctx.identifier() != null) {
            numIdentifier++;
            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            lenghtIdentifier.add(diff);
            identifierText.add(ctx.identifier().getText());
        }

        super.visitStructDefinition(ctx);
        return null;
    }

    @Override
    public Integer visitModifierInvocation(@NotNull ModifierInvocationContext ctx) {
        if (ctx.identifier() != null) {
            numIdentifier++;
            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            lenghtIdentifier.add(diff);
            identifierText.add(ctx.identifier().getText());
        }

        super.visitModifierInvocation(ctx);
        return null;
    }

    @Override
    public Integer visitEventDefinition(@NotNull EventDefinitionContext ctx) {
        if (ctx.identifier() != null) {
            numIdentifier++;
            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            lenghtIdentifier.add(diff);
            identifierText.add(ctx.identifier().getText());
        }

        super.visitEventDefinition(ctx);
        return null;
    }

    @Override
    public Integer visitEnumValue(@NotNull EnumValueContext ctx) {
        if (ctx.identifier() != null) {
            numIdentifier++;
            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            lenghtIdentifier.add(diff);
            identifierText.add(ctx.identifier().getText());

        }

        super.visitEnumValue(ctx);
        return null;
    }

    @Override
    public Integer visitEnumDefinition(@NotNull EnumDefinitionContext ctx) {
        if (ctx.identifier() != null) {
            numIdentifier++;
            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            lenghtIdentifier.add(diff);
            identifierText.add(ctx.identifier().getText());
        }

        super.visitEnumDefinition(ctx);
        return null;
    }

    @Override
    public Integer visitAssemblyCall(@NotNull AssemblyCallContext ctx) {
        if (ctx.identifier() != null) {
            numIdentifier++;
            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            lenghtIdentifier.add(diff);
            identifierText.add(ctx.identifier().getText());
        }

        super.visitAssemblyCall(ctx);
        return null;
    }

    @Override
    public Integer visitAssemblyIdentifierOrList(@NotNull AssemblyIdentifierOrListContext ctx) {
        if (ctx.identifier() != null) {
            numIdentifier++;
            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            lenghtIdentifier.add(diff);
            identifierText.add(ctx.identifier().getText());
        }

        super.visitAssemblyIdentifierOrList(ctx);
        return null;
    }

    @Override
    public Integer visitAssemblyStackAssignment(@NotNull AssemblyStackAssignmentContext ctx) {
        if (ctx.identifier() != null) {
            numIdentifier++;
            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            lenghtIdentifier.add(diff);
            identifierText.add(ctx.identifier().getText());
        }

        super.visitAssemblyStackAssignment(ctx);
        return null;
    }

    @Override
    public Integer visitLabelDefinition(@NotNull LabelDefinitionContext ctx) {
        if (ctx.identifier() != null) {
            numIdentifier++;
            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            lenghtIdentifier.add(diff);
            identifierText.add(ctx.identifier().getText());
        }

        super.visitLabelDefinition(ctx);
        return null;
    }

    @Override
    public Integer visitAssemblyFunctionDefinition(@NotNull AssemblyFunctionDefinitionContext ctx) {
        if (ctx.identifier() != null) {
            numIdentifier++;
            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            lenghtIdentifier.add(diff);
            identifierText.add(ctx.identifier().getText());
        }

        super.visitAssemblyFunctionDefinition(ctx);
        return null;
    }

    @Override
    public Integer visitSubAssembly(@NotNull SubAssemblyContext ctx) {
        if (ctx.identifier() != null) {
            numIdentifier++;
            int start = ctx.identifier().getStart().getStartIndex();
            int stop = ctx.identifier().getStop().getStopIndex();
            int diff = (stop - start) + 1;
            lenghtIdentifier.add(diff);
            identifierText.add(ctx.identifier().getText());
        }

        super.visitSubAssembly(ctx);
        return null;
    }

    public ArrayList<Integer> getLenghtIdentifier() {
        return lenghtIdentifier;
    }

    public ArrayList<String> getIdentifierText() {
        return identifierText;
    }

}
