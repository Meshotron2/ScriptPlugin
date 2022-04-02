// Generated from ScriptPlugin.g4 by ANTLR 4.9.2

package com.github.meshotron2.scriptPlugin;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ScriptPluginParser}.
 */
public interface ScriptPluginListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ScriptPluginParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(ScriptPluginParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptPluginParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(ScriptPluginParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptPluginParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(ScriptPluginParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptPluginParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(ScriptPluginParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CreateShape}
	 * labeled alternative in {@link ScriptPluginParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCreateShape(ScriptPluginParser.CreateShapeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CreateShape}
	 * labeled alternative in {@link ScriptPluginParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCreateShape(ScriptPluginParser.CreateShapeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptPluginParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void enterInstantiation(ScriptPluginParser.InstantiationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptPluginParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void exitInstantiation(ScriptPluginParser.InstantiationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptPluginParser#coefficient}.
	 * @param ctx the parse tree
	 */
	void enterCoefficient(ScriptPluginParser.CoefficientContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptPluginParser#coefficient}.
	 * @param ctx the parse tree
	 */
	void exitCoefficient(ScriptPluginParser.CoefficientContext ctx);
}