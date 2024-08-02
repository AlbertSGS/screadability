package com.unisannio.readability;

import org.antlr.v4.runtime.misc.NotNull;

import hu.sed.parser.antlr4.grammar.solidity.SolidityBaseVisitor;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.AssemblyItemContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.AssemblyLiteralContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.FunctionDefinitionContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.ModifierDefinitionContext;

import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.NumberLiteralContext;

import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.PrimaryExpressionContext;

import java.util.ArrayList;

@SuppressWarnings("deprecation")
public class numberVisitor extends SolidityBaseVisitor<Integer> {

    private int num;
    private ArrayList<Integer> lenghtIdentifier;

    public numberVisitor() {
        num = 0;
        lenghtIdentifier = new ArrayList<Integer>();
    }

    @Override
    public Integer visitFunctionDefinition(@NotNull FunctionDefinitionContext ctx) {
        super.visitFunctionDefinition(ctx);
        return num;
    }

    @Override
    public Integer visitModifierDefinition(@NotNull ModifierDefinitionContext ctx) {
        super.visitModifierDefinition(ctx);
        return num;
    }

    @Override
    public Integer visitPrimaryExpression(@NotNull PrimaryExpressionContext ctx) {
        if (ctx.numberLiteral() != null) {
            num++;
        }

        super.visitPrimaryExpression(ctx);
        return null;
    }

    @Override
    public Integer visitAssemblyItem(@NotNull AssemblyItemContext ctx) {
        if (ctx.numberLiteral() != null) {
            num++;
        }

        super.visitAssemblyItem(ctx);
        return null;
    }

    @Override
    public Integer visitAssemblyLiteral(@NotNull AssemblyLiteralContext ctx) {
        if (ctx.DecimalNumber() != null) {
            num++;
        }

        super.visitAssemblyLiteral(ctx);
        return null;
    }

    @Override
    public Integer visitNumberLiteral(@NotNull NumberLiteralContext ctx) {
        num++;

        super.visitNumberLiteral(ctx);
        return null;
    }

}
