// Generated from ScriptPlugin.g4 by ANTLR 4.9.2

package com.github.meshotron2.scriptPlugin;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ScriptPluginParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, ID = 8, CHAR = 9,
            NUM = 10, WS = 11;
    public static final int
            RULE_main = 0, RULE_module = 1, RULE_expr = 2;

    private static String[] makeRuleNames() {
        return new String[]{
                "main", "module", "expr"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'module'", "'<'", "'>'", "'('", "')'", "'{'", "'}'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, "ID", "CHAR", "NUM",
                "WS"
        };
    }

    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "ScriptPlugin.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public ScriptPluginParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class MainContext extends ParserRuleContext {
        public TerminalNode EOF() {
            return getToken(ScriptPluginParser.EOF, 0);
        }

        public List<ModuleContext> module() {
            return getRuleContexts(ModuleContext.class);
        }

        public ModuleContext module(int i) {
            return getRuleContext(ModuleContext.class, i);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public MainContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_main;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ScriptPluginListener) ((ScriptPluginListener) listener).enterMain(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ScriptPluginListener) ((ScriptPluginListener) listener).exitMain(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ScriptPluginVisitor)
                return ((ScriptPluginVisitor<? extends T>) visitor).visitMain(this);
            else return visitor.visitChildren(this);
        }
    }

    public final MainContext main() throws RecognitionException {
        MainContext _localctx = new MainContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_main);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(9);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__0) {
                    {
                        {
                            setState(6);
                            module();
                        }
                    }
                    setState(11);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(15);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == ID) {
                    {
                        {
                            setState(12);
                            expr();
                        }
                    }
                    setState(17);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(18);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ModuleContext extends ParserRuleContext {
        public TerminalNode ID() {
            return getToken(ScriptPluginParser.ID, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode CHAR() {
            return getToken(ScriptPluginParser.CHAR, 0);
        }

        public List<TerminalNode> NUM() {
            return getTokens(ScriptPluginParser.NUM);
        }

        public TerminalNode NUM(int i) {
            return getToken(ScriptPluginParser.NUM, i);
        }

        public ModuleContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_module;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ScriptPluginListener) ((ScriptPluginListener) listener).enterModule(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ScriptPluginListener) ((ScriptPluginListener) listener).exitModule(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ScriptPluginVisitor)
                return ((ScriptPluginVisitor<? extends T>) visitor).visitModule(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ModuleContext module() throws RecognitionException {
        ModuleContext _localctx = new ModuleContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_module);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(20);
                match(T__0);
                setState(21);
                match(ID);
                setState(25);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__1) {
                    {
                        setState(22);
                        match(T__1);
                        setState(23);
                        match(CHAR);
                        setState(24);
                        match(T__2);
                    }
                }

                setState(34);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__3) {
                    {
                        setState(27);
                        match(T__3);
                        setState(29);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        do {
                            {
                                {
                                    setState(28);
                                    match(NUM);
                                }
                            }
                            setState(31);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        } while (_la == NUM);
                        setState(33);
                        match(T__4);
                    }
                }

                setState(36);
                match(T__5);
                setState(37);
                expr();
                setState(38);
                match(T__6);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprContext extends ParserRuleContext {
        public ExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expr;
        }

        public ExprContext() {
        }

        public void copyFrom(ExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class ConstructorContext extends ExprContext {
        public TerminalNode ID() {
            return getToken(ScriptPluginParser.ID, 0);
        }

        public List<TerminalNode> NUM() {
            return getTokens(ScriptPluginParser.NUM);
        }

        public TerminalNode NUM(int i) {
            return getToken(ScriptPluginParser.NUM, i);
        }

        public ConstructorContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ScriptPluginListener) ((ScriptPluginListener) listener).enterConstructor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ScriptPluginListener) ((ScriptPluginListener) listener).exitConstructor(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ScriptPluginVisitor)
                return ((ScriptPluginVisitor<? extends T>) visitor).visitConstructor(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprContext expr() throws RecognitionException {
        ExprContext _localctx = new ExprContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_expr);
        int _la;
        try {
            _localctx = new ConstructorContext(_localctx);
            enterOuterAlt(_localctx, 1);
            {
                setState(40);
                match(ID);
                setState(48);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__3) {
                    {
                        setState(41);
                        match(T__3);
                        setState(43);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        do {
                            {
                                {
                                    setState(42);
                                    match(NUM);
                                }
                            }
                            setState(45);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        } while (_la == NUM);
                        setState(47);
                        match(T__4);
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\r\65\4\2\t\2\4\3" +
                    "\t\3\4\4\t\4\3\2\7\2\n\n\2\f\2\16\2\r\13\2\3\2\7\2\20\n\2\f\2\16\2\23" +
                    "\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3\34\n\3\3\3\3\3\6\3 \n\3\r\3\16\3" +
                    "!\3\3\5\3%\n\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\6\4.\n\4\r\4\16\4/\3\4\5\4" +
                    "\63\n\4\3\4\2\2\5\2\4\6\2\2\28\2\13\3\2\2\2\4\26\3\2\2\2\6*\3\2\2\2\b" +
                    "\n\5\4\3\2\t\b\3\2\2\2\n\r\3\2\2\2\13\t\3\2\2\2\13\f\3\2\2\2\f\21\3\2" +
                    "\2\2\r\13\3\2\2\2\16\20\5\6\4\2\17\16\3\2\2\2\20\23\3\2\2\2\21\17\3\2" +
                    "\2\2\21\22\3\2\2\2\22\24\3\2\2\2\23\21\3\2\2\2\24\25\7\2\2\3\25\3\3\2" +
                    "\2\2\26\27\7\3\2\2\27\33\7\n\2\2\30\31\7\4\2\2\31\32\7\13\2\2\32\34\7" +
                    "\5\2\2\33\30\3\2\2\2\33\34\3\2\2\2\34$\3\2\2\2\35\37\7\6\2\2\36 \7\f\2" +
                    "\2\37\36\3\2\2\2 !\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"#\3\2\2\2#%\7\7\2\2" +
                    "$\35\3\2\2\2$%\3\2\2\2%&\3\2\2\2&\'\7\b\2\2\'(\5\6\4\2()\7\t\2\2)\5\3" +
                    "\2\2\2*\62\7\n\2\2+-\7\6\2\2,.\7\f\2\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/" +
                    "\60\3\2\2\2\60\61\3\2\2\2\61\63\7\7\2\2\62+\3\2\2\2\62\63\3\2\2\2\63\7" +
                    "\3\2\2\2\t\13\21\33!$/\62";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}