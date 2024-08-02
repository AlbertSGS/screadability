package com.unisannio.readability;

import org.antlr.v4.runtime.misc.NotNull;

import hu.sed.parser.antlr4.grammar.solidity.SolidityBaseVisitor;

import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.AssemblyItemContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.FunctionDefinitionContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.FunctionTypeNameContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.ModifierDefinitionContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.ModifierListContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.StateMutabilityContext;
import hu.sed.parser.antlr4.grammar.solidity.SolidityParser.StateVariableDeclarationContext;

@SuppressWarnings("deprecation")
public class keywordVisitor extends SolidityBaseVisitor<Integer> {

    private int numKey;

    public keywordVisitor() {
        numKey = 0;
    }

    @Override
    public Integer visitFunctionDefinition(@NotNull FunctionDefinitionContext ctx) {

        super.visitFunctionDefinition(ctx);
        return numKey;
    }

    @Override
    public Integer visitModifierDefinition(@NotNull ModifierDefinitionContext ctx) {

        super.visitModifierDefinition(ctx);
        return numKey;
    }

    @Override
    public Integer visitStateVariableDeclaration(@NotNull StateVariableDeclarationContext ctx) {

        numKey++;

        super.visitStateVariableDeclaration(ctx);
        return null;
    }

    @Override
    public Integer visitStateMutability(@NotNull StateMutabilityContext ctx) {

        numKey++;

        super.visitStateMutability(ctx);
        return null;
    }

    @Override
    public Integer visitAssemblyItem(@NotNull AssemblyItemContext ctx) {

        if (ctx.BreakKeyword() != null || ctx.ContinueKeyword() != null) {
            numKey++;
        }

        super.visitAssemblyItem(ctx);
        return null;
    }

    @Override
    public Integer visitFunctionTypeName(@NotNull FunctionTypeNameContext ctx) {

        numKey++;

        super.visitFunctionTypeName(ctx);
        return null;
    }

    @Override
    public Integer visitModifierList(@NotNull ModifierListContext ctx) {

        numKey++;

        super.visitModifierList(ctx);
        return null;
    }
}
