package com.unisannio.readability;

import org.antlr.v4.runtime.misc.NotNull;

import hu.sed.parser.antlr4.grammar.solidity.SolidityBaseVisitor;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.FunctionDefinitionContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.IfStatementContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.ModifierDefinitionContext;

@SuppressWarnings("deprecation")
public class numIfVisitor extends SolidityBaseVisitor<Integer> {

    private int numIf;

    public numIfVisitor() {
        numIf = 0;
    }

    @Override
    public Integer visitFunctionDefinition(@NotNull FunctionDefinitionContext ctx) {
        super.visitFunctionDefinition(ctx);
        return numIf;
    }

    @Override
    public Integer visitModifierDefinition(@NotNull ModifierDefinitionContext ctx) {
        super.visitModifierDefinition(ctx);
        return numIf;
    }

    @Override
    public Integer visitIfStatement(@NotNull IfStatementContext ctx) {
        numIf++;
        super.visitIfStatement(ctx);
        return null;
    }

}
