// Generated from /home/me/Documents/uni/31/PECI/código/script/src/main/resources/ScriptPlugin.g4 by ANTLR 4.9.2
package com.github.meshotron2.scriptPlugin;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link ScriptPluginVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class ScriptPluginBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements ScriptPluginVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitMain(ScriptPluginParser.MainContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitModule(ScriptPluginParser.ModuleContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitConstructor(ScriptPluginParser.ConstructorContext ctx) { return visitChildren(ctx); }
}