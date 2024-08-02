package com.unisannio.readability;

import org.antlr.v4.runtime.misc.NotNull;

import hu.sed.parser.antlr4.grammar.solidity.SolidityBaseVisitor;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.DoWhileStatementContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.ForStatementContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.FunctionDefinitionContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.ModifierDefinitionContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.WhileStatementContext;

@SuppressWarnings("deprecation")
public class numCicliVisitor extends SolidityBaseVisitor<Integer> {

    private int numCicli;

    public numCicliVisitor() {
        numCicli = 0;
    }

    @Override
    public Integer visitFunctionDefinition(@NotNull FunctionDefinitionContext ctx) {
        super.visitFunctionDefinition(ctx);
        return numCicli;
    }

    @Override
    public Integer visitModifierDefinition(@NotNull ModifierDefinitionContext ctx) {
        super.visitModifierDefinition(ctx);
        return numCicli;
    }

    @Override
    public Integer visitWhileStatement(@NotNull WhileStatementContext ctx) {
        super.visitWhileStatement(ctx);
        numCicli++;
        return null;
    }

    @Override
    public Integer visitForStatement(@NotNull ForStatementContext ctx) {
        super.visitForStatement(ctx);
        numCicli++;
        return null;
    }

    @Override
    public Integer visitDoWhileStatement(@NotNull DoWhileStatementContext ctx) {
        super.visitDoWhileStatement(ctx);
        numCicli++;
        return null;
    }
}
