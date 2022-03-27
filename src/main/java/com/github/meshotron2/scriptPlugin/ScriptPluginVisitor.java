// Generated from ScriptPlugin.g4 by ANTLR 4.9.2

package com.github.meshotron2.scriptPlugin;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ScriptPluginParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface ScriptPluginVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link ScriptPluginParser#main}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMain(ScriptPluginParser.MainContext ctx);

    /**
     * Visit a parse tree produced by {@link ScriptPluginParser#module}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitModule(ScriptPluginParser.ModuleContext ctx);

    /**
     * Visit a parse tree produced by the {@code Constructor}
     * labeled alternative in {@link ScriptPluginParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConstructor(ScriptPluginParser.ConstructorContext ctx);
}