// Generated from Jinja2withHTMLandCSSParser.g4 by ANTLR 4.13.2
package antlr.grammar.Jinja2withHTMLandCSS.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class Jinja2withHTMLandCSSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, JINJA_COMMENT=2, CSS_COMMENT=3, BLOCK_START=4, BLOCK_END=5, FOR=6, 
		END_FOR=7, IN=8, BOOL=9, LCURLY=10, RCURLY=11, ASSIGN=12, NOT=13, OPEN_TAG=14, 
		OPEN_TAG_SLASH=15, CLOSE_TAG=16, SELF_CLOSD=17, COLON=18, SEMICOLON=19, 
		COMMA=20, LPAREN=21, RPAREN=22, DOT=23, PLUS=24, MINUS=25, STAR=26, DIVISION=27, 
		STRING=28, NUMBER=29, CSS_UNIT=30, CSS_COLOR=31, HASH=32, IDENTIFIER=33;
	public static final int
		RULE_prog = 0, RULE_anyId = 1, RULE_jinja2Prog = 2, RULE_doctype = 3, 
		RULE_htmlelement = 4, RULE_endTag = 5, RULE_attribute = 6, RULE_attributeValue = 7, 
		RULE_elementContent = 8, RULE_statement = 9, RULE_expression = 10, RULE_exprContent = 11, 
		RULE_exprContentOnly = 12, RULE_argList = 13, RULE_argItem = 14, RULE_argValue = 15, 
		RULE_memberAccess = 16, RULE_block = 17, RULE_cssProg = 18, RULE_cssRule = 19, 
		RULE_cssSelectorList = 20, RULE_cssSelector = 21, RULE_simpleSelector = 22, 
		RULE_cssDeclaration = 23, RULE_cssValue = 24, RULE_cssValueAtom = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "anyId", "jinja2Prog", "doctype", "htmlelement", "endTag", "attribute", 
			"attributeValue", "elementContent", "statement", "expression", "exprContent", 
			"exprContentOnly", "argList", "argItem", "argValue", "memberAccess", 
			"block", "cssProg", "cssRule", "cssSelectorList", "cssSelector", "simpleSelector", 
			"cssDeclaration", "cssValue", "cssValueAtom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'{%'", "'%}'", "'for'", "'endfor'", "'in'", 
			null, "'{'", "'}'", "'='", "'!'", "'<'", "'</'", "'>'", "'/>'", "':'", 
			"';'", "','", "'('", "')'", "'.'", "'+'", "'-'", "'*'", "'/'", null, 
			null, null, null, "'#'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "JINJA_COMMENT", "CSS_COMMENT", "BLOCK_START", "BLOCK_END", 
			"FOR", "END_FOR", "IN", "BOOL", "LCURLY", "RCURLY", "ASSIGN", "NOT", 
			"OPEN_TAG", "OPEN_TAG_SLASH", "CLOSE_TAG", "SELF_CLOSD", "COLON", "SEMICOLON", 
			"COMMA", "LPAREN", "RPAREN", "DOT", "PLUS", "MINUS", "STAR", "DIVISION", 
			"STRING", "NUMBER", "CSS_UNIT", "CSS_COLOR", "HASH", "IDENTIFIER"
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
	public String getGrammarFileName() { return "Jinja2withHTMLandCSSParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private static final java.util.Set<String> VOID_ELEMENTS = new java.util.HashSet<>(java.util.Arrays.asList(
	        "area", "base", "br", "col", "embed", "hr", "img", "input",
	        "link", "meta", "param", "source", "track", "wbr"
	    ));
	    private boolean isVoidElementName(String name) {
	        return name != null && VOID_ELEMENTS.contains(name.toLowerCase());
	    }

	public Jinja2withHTMLandCSSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Jinja2Context extends ProgContext {
		public Jinja2ProgContext jinja2Prog() {
			return getRuleContext(Jinja2ProgContext.class,0);
		}
		public Jinja2Context(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterJinja2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitJinja2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinja2(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssContext extends ProgContext {
		public CssProgContext cssProg() {
			return getRuleContext(CssProgContext.class,0);
		}
		public CssContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCss(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCss(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCss(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new Jinja2Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				jinja2Prog();
				}
				break;
			case 2:
				_localctx = new CssContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				cssProg();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnyIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(Jinja2withHTMLandCSSParser.IDENTIFIER, 0); }
		public TerminalNode FOR() { return getToken(Jinja2withHTMLandCSSParser.FOR, 0); }
		public TerminalNode IN() { return getToken(Jinja2withHTMLandCSSParser.IN, 0); }
		public TerminalNode BOOL() { return getToken(Jinja2withHTMLandCSSParser.BOOL, 0); }
		public TerminalNode END_FOR() { return getToken(Jinja2withHTMLandCSSParser.END_FOR, 0); }
		public AnyIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterAnyId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitAnyId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitAnyId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnyIdContext anyId() throws RecognitionException {
		AnyIdContext _localctx = new AnyIdContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_anyId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8589935552L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Jinja2ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Jinja2withHTMLandCSSParser.EOF, 0); }
		public DoctypeContext doctype() {
			return getRuleContext(DoctypeContext.class,0);
		}
		public List<ElementContentContext> elementContent() {
			return getRuleContexts(ElementContentContext.class);
		}
		public ElementContentContext elementContent(int i) {
			return getRuleContext(ElementContentContext.class,i);
		}
		public Jinja2ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinja2Prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterJinja2Prog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitJinja2Prog(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinja2Prog(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jinja2ProgContext jinja2Prog() throws RecognitionException {
		Jinja2ProgContext _localctx = new Jinja2ProgContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_jinja2Prog);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(58);
				doctype();
				}
				break;
			}
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(61);
					elementContent();
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(67);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoctypeContext extends ParserRuleContext {
		public TerminalNode OPEN_TAG() { return getToken(Jinja2withHTMLandCSSParser.OPEN_TAG, 0); }
		public TerminalNode NOT() { return getToken(Jinja2withHTMLandCSSParser.NOT, 0); }
		public List<AnyIdContext> anyId() {
			return getRuleContexts(AnyIdContext.class);
		}
		public AnyIdContext anyId(int i) {
			return getRuleContext(AnyIdContext.class,i);
		}
		public TerminalNode CLOSE_TAG() { return getToken(Jinja2withHTMLandCSSParser.CLOSE_TAG, 0); }
		public DoctypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doctype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterDoctype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitDoctype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitDoctype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoctypeContext doctype() throws RecognitionException {
		DoctypeContext _localctx = new DoctypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_doctype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(OPEN_TAG);
			setState(70);
			match(NOT);
			setState(71);
			anyId();
			setState(72);
			anyId();
			setState(73);
			match(CLOSE_TAG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlelementContext extends ParserRuleContext {
		public HtmlelementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlelement; }
	 
		public HtmlelementContext() { }
		public void copyFrom(HtmlelementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelfClosingTagContext extends HtmlelementContext {
		public TerminalNode OPEN_TAG() { return getToken(Jinja2withHTMLandCSSParser.OPEN_TAG, 0); }
		public AnyIdContext anyId() {
			return getRuleContext(AnyIdContext.class,0);
		}
		public TerminalNode SELF_CLOSD() { return getToken(Jinja2withHTMLandCSSParser.SELF_CLOSD, 0); }
		public TerminalNode CLOSE_TAG() { return getToken(Jinja2withHTMLandCSSParser.CLOSE_TAG, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public SelfClosingTagContext(HtmlelementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterSelfClosingTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitSelfClosingTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitSelfClosingTag(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OpenCloseTagContext extends HtmlelementContext {
		public AnyIdContext anyId;
		public TerminalNode OPEN_TAG() { return getToken(Jinja2withHTMLandCSSParser.OPEN_TAG, 0); }
		public AnyIdContext anyId() {
			return getRuleContext(AnyIdContext.class,0);
		}
		public TerminalNode CLOSE_TAG() { return getToken(Jinja2withHTMLandCSSParser.CLOSE_TAG, 0); }
		public EndTagContext endTag() {
			return getRuleContext(EndTagContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<ElementContentContext> elementContent() {
			return getRuleContexts(ElementContentContext.class);
		}
		public ElementContentContext elementContent(int i) {
			return getRuleContext(ElementContentContext.class,i);
		}
		public OpenCloseTagContext(HtmlelementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterOpenCloseTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitOpenCloseTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitOpenCloseTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlelementContext htmlelement() throws RecognitionException {
		HtmlelementContext _localctx = new HtmlelementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_htmlelement);
		int _la;
		try {
			int _alt;
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new SelfClosingTagContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				if (!(isVoidElementName(_input.LT(2).getText()))) throw new FailedPredicateException(this, "isVoidElementName(_input.LT(2).getText())");
				setState(76);
				match(OPEN_TAG);
				setState(77);
				anyId();
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8589935552L) != 0)) {
					{
					{
					setState(78);
					attribute();
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(84);
				_la = _input.LA(1);
				if ( !(_la==CLOSE_TAG || _la==SELF_CLOSD) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				_localctx = new OpenCloseTagContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				if (!(!isVoidElementName(_input.LT(2).getText()))) throw new FailedPredicateException(this, "!isVoidElementName(_input.LT(2).getText())");
				setState(87);
				match(OPEN_TAG);
				setState(88);
				((OpenCloseTagContext)_localctx).anyId = anyId();
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8589935552L) != 0)) {
					{
					{
					setState(89);
					attribute();
					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(95);
				match(CLOSE_TAG);
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(96);
						elementContent();
						}
						} 
					}
					setState(101);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(102);
				endTag((((OpenCloseTagContext)_localctx).anyId!=null?_input.getText(((OpenCloseTagContext)_localctx).anyId.start,((OpenCloseTagContext)_localctx).anyId.stop):null));
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EndTagContext extends ParserRuleContext {
		public String expectedName;
		public AnyIdContext anyId;
		public TerminalNode OPEN_TAG_SLASH() { return getToken(Jinja2withHTMLandCSSParser.OPEN_TAG_SLASH, 0); }
		public AnyIdContext anyId() {
			return getRuleContext(AnyIdContext.class,0);
		}
		public TerminalNode CLOSE_TAG() { return getToken(Jinja2withHTMLandCSSParser.CLOSE_TAG, 0); }
		public EndTagContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EndTagContext(ParserRuleContext parent, int invokingState, String expectedName) {
			super(parent, invokingState);
			this.expectedName = expectedName;
		}
		@Override public int getRuleIndex() { return RULE_endTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterEndTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitEndTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitEndTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndTagContext endTag(String expectedName) throws RecognitionException {
		EndTagContext _localctx = new EndTagContext(_ctx, getState(), expectedName);
		enterRule(_localctx, 10, RULE_endTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(OPEN_TAG_SLASH);
			setState(107);
			((EndTagContext)_localctx).anyId = anyId();
			setState(108);
			if (!((((EndTagContext)_localctx).anyId!=null?_input.getText(((EndTagContext)_localctx).anyId.start,((EndTagContext)_localctx).anyId.stop):null).equals(_localctx.expectedName))) throw new FailedPredicateException(this, "$anyId.text.equals($expectedName)");
			setState(109);
			match(CLOSE_TAG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeContext extends ParserRuleContext {
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	 
		public AttributeContext() { }
		public void copyFrom(AttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanAttrContext extends AttributeContext {
		public AnyIdContext anyId() {
			return getRuleContext(AnyIdContext.class,0);
		}
		public BooleanAttrContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterBooleanAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitBooleanAttr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitBooleanAttr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FullAttrContext extends AttributeContext {
		public AnyIdContext anyId() {
			return getRuleContext(AnyIdContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Jinja2withHTMLandCSSParser.ASSIGN, 0); }
		public AttributeValueContext attributeValue() {
			return getRuleContext(AttributeValueContext.class,0);
		}
		public FullAttrContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterFullAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitFullAttr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitFullAttr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_attribute);
		try {
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new FullAttrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				anyId();
				setState(112);
				match(ASSIGN);
				setState(113);
				attributeValue();
				}
				break;
			case 2:
				_localctx = new BooleanAttrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				anyId();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(Jinja2withHTMLandCSSParser.STRING, 0); }
		public AttributeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterAttributeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitAttributeValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitAttributeValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeValueContext attributeValue() throws RecognitionException {
		AttributeValueContext _localctx = new AttributeValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_attributeValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementContentContext extends ParserRuleContext {
		public ElementContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementContent; }
	 
		public ElementContentContext() { }
		public void copyFrom(ElementContentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NestedElementContext extends ElementContentContext {
		public HtmlelementContext htmlelement() {
			return getRuleContext(HtmlelementContext.class,0);
		}
		public NestedElementContext(ElementContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterNestedElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitNestedElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitNestedElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextContentContext extends ElementContentContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TextContentContext(ElementContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterTextContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitTextContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitTextContent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExpressionContext extends ElementContentContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JinjaExpressionContext(ElementContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterJinjaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitJinjaExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinjaExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaBlockContext extends ElementContentContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public JinjaBlockContext(ElementContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterJinjaBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitJinjaBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinjaBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContentContext elementContent() throws RecognitionException {
		ElementContentContext _localctx = new ElementContentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_elementContent);
		try {
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new NestedElementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				htmlelement();
				}
				break;
			case 2:
				_localctx = new JinjaExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				expression();
				}
				break;
			case 3:
				_localctx = new JinjaBlockContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				block();
				}
				break;
			case 4:
				_localctx = new TextContentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public List<AnyIdContext> anyId() {
			return getRuleContexts(AnyIdContext.class);
		}
		public AnyIdContext anyId(int i) {
			return getRuleContext(AnyIdContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(Jinja2withHTMLandCSSParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(Jinja2withHTMLandCSSParser.COLON, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(Jinja2withHTMLandCSSParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(Jinja2withHTMLandCSSParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(Jinja2withHTMLandCSSParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(Jinja2withHTMLandCSSParser.RPAREN, i);
		}
		public List<TerminalNode> DOT() { return getTokens(Jinja2withHTMLandCSSParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Jinja2withHTMLandCSSParser.DOT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Jinja2withHTMLandCSSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Jinja2withHTMLandCSSParser.COMMA, i);
		}
		public List<TerminalNode> PLUS() { return getTokens(Jinja2withHTMLandCSSParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(Jinja2withHTMLandCSSParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(Jinja2withHTMLandCSSParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(Jinja2withHTMLandCSSParser.MINUS, i);
		}
		public List<TerminalNode> STAR() { return getTokens(Jinja2withHTMLandCSSParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(Jinja2withHTMLandCSSParser.STAR, i);
		}
		public List<TerminalNode> DIVISION() { return getTokens(Jinja2withHTMLandCSSParser.DIVISION); }
		public TerminalNode DIVISION(int i) {
			return getToken(Jinja2withHTMLandCSSParser.DIVISION, i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(136); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(136);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case FOR:
					case END_FOR:
					case IN:
					case BOOL:
					case IDENTIFIER:
						{
						setState(126);
						anyId();
						}
						break;
					case COLON:
						{
						setState(127);
						match(COLON);
						}
						break;
					case LPAREN:
						{
						setState(128);
						match(LPAREN);
						}
						break;
					case RPAREN:
						{
						setState(129);
						match(RPAREN);
						}
						break;
					case DOT:
						{
						setState(130);
						match(DOT);
						}
						break;
					case COMMA:
						{
						setState(131);
						match(COMMA);
						}
						break;
					case PLUS:
						{
						setState(132);
						match(PLUS);
						}
						break;
					case MINUS:
						{
						setState(133);
						match(MINUS);
						}
						break;
					case STAR:
						{
						setState(134);
						match(STAR);
						}
						break;
					case DIVISION:
						{
						setState(135);
						match(DIVISION);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(138); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public List<TerminalNode> LCURLY() { return getTokens(Jinja2withHTMLandCSSParser.LCURLY); }
		public TerminalNode LCURLY(int i) {
			return getToken(Jinja2withHTMLandCSSParser.LCURLY, i);
		}
		public ExprContentContext exprContent() {
			return getRuleContext(ExprContentContext.class,0);
		}
		public List<TerminalNode> RCURLY() { return getTokens(Jinja2withHTMLandCSSParser.RCURLY); }
		public TerminalNode RCURLY(int i) {
			return getToken(Jinja2withHTMLandCSSParser.RCURLY, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(LCURLY);
			setState(141);
			match(LCURLY);
			setState(142);
			exprContent();
			setState(143);
			match(RCURLY);
			setState(144);
			match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContentContext extends ParserRuleContext {
		public MemberAccessContext memberAccess() {
			return getRuleContext(MemberAccessContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(Jinja2withHTMLandCSSParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Jinja2withHTMLandCSSParser.RPAREN, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public ExprContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterExprContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitExprContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitExprContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContentContext exprContent() throws RecognitionException {
		ExprContentContext _localctx = new ExprContentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exprContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			memberAccess();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(147);
				match(LPAREN);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9395241920L) != 0)) {
					{
					setState(148);
					argList();
					}
				}

				setState(151);
				match(RPAREN);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContentOnlyContext extends ParserRuleContext {
		public ExprContentContext exprContent() {
			return getRuleContext(ExprContentContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Jinja2withHTMLandCSSParser.EOF, 0); }
		public ExprContentOnlyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprContentOnly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterExprContentOnly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitExprContentOnly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitExprContentOnly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContentOnlyContext exprContentOnly() throws RecognitionException {
		ExprContentOnlyContext _localctx = new ExprContentOnlyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exprContentOnly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			exprContent();
			setState(155);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgListContext extends ParserRuleContext {
		public List<ArgItemContext> argItem() {
			return getRuleContexts(ArgItemContext.class);
		}
		public ArgItemContext argItem(int i) {
			return getRuleContext(ArgItemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Jinja2withHTMLandCSSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Jinja2withHTMLandCSSParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			argItem();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(158);
				match(COMMA);
				setState(159);
				argItem();
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgItemContext extends ParserRuleContext {
		public ArgValueContext argValue() {
			return getRuleContext(ArgValueContext.class,0);
		}
		public AnyIdContext anyId() {
			return getRuleContext(AnyIdContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Jinja2withHTMLandCSSParser.ASSIGN, 0); }
		public ArgItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterArgItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitArgItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitArgItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgItemContext argItem() throws RecognitionException {
		ArgItemContext _localctx = new ArgItemContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_argItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(165);
				anyId();
				setState(166);
				match(ASSIGN);
				}
				break;
			}
			setState(170);
			argValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(Jinja2withHTMLandCSSParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(Jinja2withHTMLandCSSParser.NUMBER, 0); }
		public MemberAccessContext memberAccess() {
			return getRuleContext(MemberAccessContext.class,0);
		}
		public ArgValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterArgValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitArgValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitArgValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgValueContext argValue() throws RecognitionException {
		ArgValueContext _localctx = new ArgValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_argValue);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(STRING);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(NUMBER);
				}
				break;
			case FOR:
			case END_FOR:
			case IN:
			case BOOL:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				memberAccess();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MemberAccessContext extends ParserRuleContext {
		public List<AnyIdContext> anyId() {
			return getRuleContexts(AnyIdContext.class);
		}
		public AnyIdContext anyId(int i) {
			return getRuleContext(AnyIdContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(Jinja2withHTMLandCSSParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Jinja2withHTMLandCSSParser.DOT, i);
		}
		public MemberAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterMemberAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitMemberAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitMemberAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberAccessContext memberAccess() throws RecognitionException {
		MemberAccessContext _localctx = new MemberAccessContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_memberAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			anyId();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(178);
				match(DOT);
				setState(179);
				anyId();
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<TerminalNode> BLOCK_START() { return getTokens(Jinja2withHTMLandCSSParser.BLOCK_START); }
		public TerminalNode BLOCK_START(int i) {
			return getToken(Jinja2withHTMLandCSSParser.BLOCK_START, i);
		}
		public TerminalNode FOR() { return getToken(Jinja2withHTMLandCSSParser.FOR, 0); }
		public List<AnyIdContext> anyId() {
			return getRuleContexts(AnyIdContext.class);
		}
		public AnyIdContext anyId(int i) {
			return getRuleContext(AnyIdContext.class,i);
		}
		public TerminalNode IN() { return getToken(Jinja2withHTMLandCSSParser.IN, 0); }
		public List<TerminalNode> BLOCK_END() { return getTokens(Jinja2withHTMLandCSSParser.BLOCK_END); }
		public TerminalNode BLOCK_END(int i) {
			return getToken(Jinja2withHTMLandCSSParser.BLOCK_END, i);
		}
		public TerminalNode END_FOR() { return getToken(Jinja2withHTMLandCSSParser.END_FOR, 0); }
		public List<ElementContentContext> elementContent() {
			return getRuleContexts(ElementContentContext.class);
		}
		public ElementContentContext elementContent(int i) {
			return getRuleContext(ElementContentContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(BLOCK_START);
			setState(186);
			match(FOR);
			setState(187);
			anyId();
			setState(188);
			match(IN);
			setState(189);
			anyId();
			setState(190);
			match(BLOCK_END);
			setState(194);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(191);
					elementContent();
					}
					} 
				}
				setState(196);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(197);
			match(BLOCK_START);
			setState(198);
			match(END_FOR);
			setState(199);
			match(BLOCK_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Jinja2withHTMLandCSSParser.EOF, 0); }
		public List<CssRuleContext> cssRule() {
			return getRuleContexts(CssRuleContext.class);
		}
		public CssRuleContext cssRule(int i) {
			return getRuleContext(CssRuleContext.class,i);
		}
		public CssProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssProg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssProgContext cssProg() throws RecognitionException {
		CssProgContext _localctx = new CssProgContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_cssProg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(201);
				cssRule();
				}
				}
				setState(204); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 12893291456L) != 0) );
			setState(206);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssRuleContext extends ParserRuleContext {
		public CssSelectorListContext cssSelectorList() {
			return getRuleContext(CssSelectorListContext.class,0);
		}
		public TerminalNode LCURLY() { return getToken(Jinja2withHTMLandCSSParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(Jinja2withHTMLandCSSParser.RCURLY, 0); }
		public List<CssDeclarationContext> cssDeclaration() {
			return getRuleContexts(CssDeclarationContext.class);
		}
		public CssDeclarationContext cssDeclaration(int i) {
			return getRuleContext(CssDeclarationContext.class,i);
		}
		public CssRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssRuleContext cssRule() throws RecognitionException {
		CssRuleContext _localctx = new CssRuleContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_cssRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			cssSelectorList();
			setState(209);
			match(LCURLY);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8589935552L) != 0)) {
				{
				{
				setState(210);
				cssDeclaration();
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(216);
			match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssSelectorListContext extends ParserRuleContext {
		public List<CssSelectorContext> cssSelector() {
			return getRuleContexts(CssSelectorContext.class);
		}
		public CssSelectorContext cssSelector(int i) {
			return getRuleContext(CssSelectorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Jinja2withHTMLandCSSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Jinja2withHTMLandCSSParser.COMMA, i);
		}
		public CssSelectorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssSelectorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssSelectorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssSelectorList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssSelectorList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssSelectorListContext cssSelectorList() throws RecognitionException {
		CssSelectorListContext _localctx = new CssSelectorListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_cssSelectorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			cssSelector();
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(219);
				match(COMMA);
				setState(220);
				cssSelector();
				}
				}
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssSelectorContext extends ParserRuleContext {
		public List<SimpleSelectorContext> simpleSelector() {
			return getRuleContexts(SimpleSelectorContext.class);
		}
		public SimpleSelectorContext simpleSelector(int i) {
			return getRuleContext(SimpleSelectorContext.class,i);
		}
		public TerminalNode COLON() { return getToken(Jinja2withHTMLandCSSParser.COLON, 0); }
		public AnyIdContext anyId() {
			return getRuleContext(AnyIdContext.class,0);
		}
		public CssSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssSelector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssSelectorContext cssSelector() throws RecognitionException {
		CssSelectorContext _localctx = new CssSelectorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_cssSelector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			simpleSelector();
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12893291456L) != 0)) {
				{
				{
				setState(227);
				simpleSelector();
				}
				}
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(233);
				match(COLON);
				setState(234);
				anyId();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleSelectorContext extends ParserRuleContext {
		public SimpleSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleSelector; }
	 
		public SimpleSelectorContext() { }
		public void copyFrom(SimpleSelectorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdSelectorContext extends SimpleSelectorContext {
		public TerminalNode HASH() { return getToken(Jinja2withHTMLandCSSParser.HASH, 0); }
		public AnyIdContext anyId() {
			return getRuleContext(AnyIdContext.class,0);
		}
		public IdSelectorContext(SimpleSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterIdSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitIdSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitIdSelector(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassSelectorContext extends SimpleSelectorContext {
		public TerminalNode DOT() { return getToken(Jinja2withHTMLandCSSParser.DOT, 0); }
		public AnyIdContext anyId() {
			return getRuleContext(AnyIdContext.class,0);
		}
		public ClassSelectorContext(SimpleSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterClassSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitClassSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitClassSelector(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElementSelectorContext extends SimpleSelectorContext {
		public AnyIdContext anyId() {
			return getRuleContext(AnyIdContext.class,0);
		}
		public ElementSelectorContext(SimpleSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterElementSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitElementSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitElementSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleSelectorContext simpleSelector() throws RecognitionException {
		SimpleSelectorContext _localctx = new SimpleSelectorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_simpleSelector);
		try {
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
			case END_FOR:
			case IN:
			case BOOL:
			case IDENTIFIER:
				_localctx = new ElementSelectorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				anyId();
				}
				break;
			case DOT:
				_localctx = new ClassSelectorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				match(DOT);
				setState(239);
				anyId();
				}
				break;
			case HASH:
				_localctx = new IdSelectorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				match(HASH);
				setState(241);
				anyId();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssDeclarationContext extends ParserRuleContext {
		public AnyIdContext anyId() {
			return getRuleContext(AnyIdContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Jinja2withHTMLandCSSParser.COLON, 0); }
		public CssValueContext cssValue() {
			return getRuleContext(CssValueContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(Jinja2withHTMLandCSSParser.SEMICOLON, 0); }
		public CssDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssDeclarationContext cssDeclaration() throws RecognitionException {
		CssDeclarationContext _localctx = new CssDeclarationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_cssDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			anyId();
			setState(245);
			match(COLON);
			setState(246);
			cssValue();
			setState(247);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssValueContext extends ParserRuleContext {
		public List<CssValueAtomContext> cssValueAtom() {
			return getRuleContexts(CssValueAtomContext.class);
		}
		public CssValueAtomContext cssValueAtom(int i) {
			return getRuleContext(CssValueAtomContext.class,i);
		}
		public CssValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueContext cssValue() throws RecognitionException {
		CssValueContext _localctx = new CssValueContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_cssValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(249);
				cssValueAtom();
				}
				}
				setState(252); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 12657361856L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssValueAtomContext extends ParserRuleContext {
		public CssValueAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValueAtom; }
	 
		public CssValueAtomContext() { }
		public void copyFrom(CssValueAtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssCommaContext extends CssValueAtomContext {
		public TerminalNode COMMA() { return getToken(Jinja2withHTMLandCSSParser.COMMA, 0); }
		public CssCommaContext(CssValueAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssComma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssComma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssComma(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssStringContext extends CssValueAtomContext {
		public TerminalNode STRING() { return getToken(Jinja2withHTMLandCSSParser.STRING, 0); }
		public CssStringContext(CssValueAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssMinusContext extends CssValueAtomContext {
		public TerminalNode MINUS() { return getToken(Jinja2withHTMLandCSSParser.MINUS, 0); }
		public CssMinusContext(CssValueAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssLParenContext extends CssValueAtomContext {
		public TerminalNode LPAREN() { return getToken(Jinja2withHTMLandCSSParser.LPAREN, 0); }
		public CssLParenContext(CssValueAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssLParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssLParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssLParen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssColorContext extends CssValueAtomContext {
		public TerminalNode CSS_COLOR() { return getToken(Jinja2withHTMLandCSSParser.CSS_COLOR, 0); }
		public CssColorContext(CssValueAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssColor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssIdentifierContext extends CssValueAtomContext {
		public AnyIdContext anyId() {
			return getRuleContext(AnyIdContext.class,0);
		}
		public CssIdentifierContext(CssValueAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssNumberContext extends CssValueAtomContext {
		public TerminalNode NUMBER() { return getToken(Jinja2withHTMLandCSSParser.NUMBER, 0); }
		public CssNumberContext(CssValueAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssUnitContext extends CssValueAtomContext {
		public TerminalNode CSS_UNIT() { return getToken(Jinja2withHTMLandCSSParser.CSS_UNIT, 0); }
		public CssUnitContext(CssValueAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssUnit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssRParenContext extends CssValueAtomContext {
		public TerminalNode RPAREN() { return getToken(Jinja2withHTMLandCSSParser.RPAREN, 0); }
		public CssRParenContext(CssValueAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssRParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssRParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssRParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueAtomContext cssValueAtom() throws RecognitionException {
		CssValueAtomContext _localctx = new CssValueAtomContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_cssValueAtom);
		try {
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new CssNumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				match(NUMBER);
				}
				break;
			case CSS_UNIT:
				_localctx = new CssUnitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				match(CSS_UNIT);
				}
				break;
			case CSS_COLOR:
				_localctx = new CssColorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				match(CSS_COLOR);
				}
				break;
			case FOR:
			case END_FOR:
			case IN:
			case BOOL:
			case IDENTIFIER:
				_localctx = new CssIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(257);
				anyId();
				}
				break;
			case COMMA:
				_localctx = new CssCommaContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(258);
				match(COMMA);
				}
				break;
			case MINUS:
				_localctx = new CssMinusContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(259);
				match(MINUS);
				}
				break;
			case STRING:
				_localctx = new CssStringContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(260);
				match(STRING);
				}
				break;
			case LPAREN:
				_localctx = new CssLParenContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(261);
				match(LPAREN);
				}
				break;
			case RPAREN:
				_localctx = new CssRParenContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(262);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return htmlelement_sempred((HtmlelementContext)_localctx, predIndex);
		case 5:
			return endTag_sempred((EndTagContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean htmlelement_sempred(HtmlelementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return isVoidElementName(_input.LT(2).getText());
		case 1:
			return !isVoidElementName(_input.LT(2).getText());
		}
		return true;
	}
	private boolean endTag_sempred(EndTagContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return (((EndTagContext)_localctx).anyId!=null?_input.getText(((EndTagContext)_localctx).anyId.start,((EndTagContext)_localctx).anyId.stop):null).equals(_localctx.expectedName);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001!\u010a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000\u0003\u00007\b\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0003\u0002<\b\u0002\u0001\u0002"+
		"\u0005\u0002?\b\u0002\n\u0002\f\u0002B\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004P\b\u0004"+
		"\n\u0004\f\u0004S\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004[\b\u0004\n\u0004\f\u0004^\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004b\b\u0004\n\u0004\f\u0004e\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004i\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006u\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b}\b\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u0089"+
		"\b\t\u000b\t\f\t\u008a\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0096\b\u000b\u0001\u000b"+
		"\u0003\u000b\u0099\b\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u00a1\b\r\n\r\f\r\u00a4\t\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00a9\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00b0\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u00b5\b\u0010\n\u0010\f\u0010\u00b8\t\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005"+
		"\u0011\u00c1\b\u0011\n\u0011\f\u0011\u00c4\t\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0004\u0012\u00cb\b\u0012\u000b\u0012"+
		"\f\u0012\u00cc\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0005\u0013\u00d4\b\u0013\n\u0013\f\u0013\u00d7\t\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u00de\b\u0014\n"+
		"\u0014\f\u0014\u00e1\t\u0014\u0001\u0015\u0001\u0015\u0005\u0015\u00e5"+
		"\b\u0015\n\u0015\f\u0015\u00e8\t\u0015\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u00ec\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0003\u0016\u00f3\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0004\u0018\u00fb\b\u0018\u000b\u0018\f\u0018"+
		"\u00fc\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0108\b\u0019\u0001"+
		"\u0019\u0000\u0000\u001a\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02\u0000\u0002\u0002\u0000"+
		"\u0006\t!!\u0001\u0000\u0010\u0011\u011c\u00006\u0001\u0000\u0000\u0000"+
		"\u00028\u0001\u0000\u0000\u0000\u0004;\u0001\u0000\u0000\u0000\u0006E"+
		"\u0001\u0000\u0000\u0000\bh\u0001\u0000\u0000\u0000\nj\u0001\u0000\u0000"+
		"\u0000\ft\u0001\u0000\u0000\u0000\u000ev\u0001\u0000\u0000\u0000\u0010"+
		"|\u0001\u0000\u0000\u0000\u0012\u0088\u0001\u0000\u0000\u0000\u0014\u008c"+
		"\u0001\u0000\u0000\u0000\u0016\u0092\u0001\u0000\u0000\u0000\u0018\u009a"+
		"\u0001\u0000\u0000\u0000\u001a\u009d\u0001\u0000\u0000\u0000\u001c\u00a8"+
		"\u0001\u0000\u0000\u0000\u001e\u00af\u0001\u0000\u0000\u0000 \u00b1\u0001"+
		"\u0000\u0000\u0000\"\u00b9\u0001\u0000\u0000\u0000$\u00ca\u0001\u0000"+
		"\u0000\u0000&\u00d0\u0001\u0000\u0000\u0000(\u00da\u0001\u0000\u0000\u0000"+
		"*\u00e2\u0001\u0000\u0000\u0000,\u00f2\u0001\u0000\u0000\u0000.\u00f4"+
		"\u0001\u0000\u0000\u00000\u00fa\u0001\u0000\u0000\u00002\u0107\u0001\u0000"+
		"\u0000\u000047\u0003\u0004\u0002\u000057\u0003$\u0012\u000064\u0001\u0000"+
		"\u0000\u000065\u0001\u0000\u0000\u00007\u0001\u0001\u0000\u0000\u0000"+
		"89\u0007\u0000\u0000\u00009\u0003\u0001\u0000\u0000\u0000:<\u0003\u0006"+
		"\u0003\u0000;:\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<@\u0001"+
		"\u0000\u0000\u0000=?\u0003\u0010\b\u0000>=\u0001\u0000\u0000\u0000?B\u0001"+
		"\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000"+
		"AC\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000CD\u0005\u0000\u0000"+
		"\u0001D\u0005\u0001\u0000\u0000\u0000EF\u0005\u000e\u0000\u0000FG\u0005"+
		"\r\u0000\u0000GH\u0003\u0002\u0001\u0000HI\u0003\u0002\u0001\u0000IJ\u0005"+
		"\u0010\u0000\u0000J\u0007\u0001\u0000\u0000\u0000KL\u0004\u0004\u0000"+
		"\u0000LM\u0005\u000e\u0000\u0000MQ\u0003\u0002\u0001\u0000NP\u0003\f\u0006"+
		"\u0000ON\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000"+
		"\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SQ\u0001"+
		"\u0000\u0000\u0000TU\u0007\u0001\u0000\u0000Ui\u0001\u0000\u0000\u0000"+
		"VW\u0004\u0004\u0001\u0000WX\u0005\u000e\u0000\u0000X\\\u0003\u0002\u0001"+
		"\u0000Y[\u0003\f\u0006\u0000ZY\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000"+
		"\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]_\u0001\u0000"+
		"\u0000\u0000^\\\u0001\u0000\u0000\u0000_c\u0005\u0010\u0000\u0000`b\u0003"+
		"\u0010\b\u0000a`\u0001\u0000\u0000\u0000be\u0001\u0000\u0000\u0000ca\u0001"+
		"\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000df\u0001\u0000\u0000\u0000"+
		"ec\u0001\u0000\u0000\u0000fg\u0003\n\u0005\u0000gi\u0001\u0000\u0000\u0000"+
		"hK\u0001\u0000\u0000\u0000hV\u0001\u0000\u0000\u0000i\t\u0001\u0000\u0000"+
		"\u0000jk\u0005\u000f\u0000\u0000kl\u0003\u0002\u0001\u0000lm\u0004\u0005"+
		"\u0002\u0001mn\u0005\u0010\u0000\u0000n\u000b\u0001\u0000\u0000\u0000"+
		"op\u0003\u0002\u0001\u0000pq\u0005\f\u0000\u0000qr\u0003\u000e\u0007\u0000"+
		"ru\u0001\u0000\u0000\u0000su\u0003\u0002\u0001\u0000to\u0001\u0000\u0000"+
		"\u0000ts\u0001\u0000\u0000\u0000u\r\u0001\u0000\u0000\u0000vw\u0005\u001c"+
		"\u0000\u0000w\u000f\u0001\u0000\u0000\u0000x}\u0003\b\u0004\u0000y}\u0003"+
		"\u0014\n\u0000z}\u0003\"\u0011\u0000{}\u0003\u0012\t\u0000|x\u0001\u0000"+
		"\u0000\u0000|y\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|{\u0001"+
		"\u0000\u0000\u0000}\u0011\u0001\u0000\u0000\u0000~\u0089\u0003\u0002\u0001"+
		"\u0000\u007f\u0089\u0005\u0012\u0000\u0000\u0080\u0089\u0005\u0015\u0000"+
		"\u0000\u0081\u0089\u0005\u0016\u0000\u0000\u0082\u0089\u0005\u0017\u0000"+
		"\u0000\u0083\u0089\u0005\u0014\u0000\u0000\u0084\u0089\u0005\u0018\u0000"+
		"\u0000\u0085\u0089\u0005\u0019\u0000\u0000\u0086\u0089\u0005\u001a\u0000"+
		"\u0000\u0087\u0089\u0005\u001b\u0000\u0000\u0088~\u0001\u0000\u0000\u0000"+
		"\u0088\u007f\u0001\u0000\u0000\u0000\u0088\u0080\u0001\u0000\u0000\u0000"+
		"\u0088\u0081\u0001\u0000\u0000\u0000\u0088\u0082\u0001\u0000\u0000\u0000"+
		"\u0088\u0083\u0001\u0000\u0000\u0000\u0088\u0084\u0001\u0000\u0000\u0000"+
		"\u0088\u0085\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000"+
		"\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000"+
		"\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000"+
		"\u008b\u0013\u0001\u0000\u0000\u0000\u008c\u008d\u0005\n\u0000\u0000\u008d"+
		"\u008e\u0005\n\u0000\u0000\u008e\u008f\u0003\u0016\u000b\u0000\u008f\u0090"+
		"\u0005\u000b\u0000\u0000\u0090\u0091\u0005\u000b\u0000\u0000\u0091\u0015"+
		"\u0001\u0000\u0000\u0000\u0092\u0098\u0003 \u0010\u0000\u0093\u0095\u0005"+
		"\u0015\u0000\u0000\u0094\u0096\u0003\u001a\r\u0000\u0095\u0094\u0001\u0000"+
		"\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000"+
		"\u0000\u0000\u0097\u0099\u0005\u0016\u0000\u0000\u0098\u0093\u0001\u0000"+
		"\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u0017\u0001\u0000"+
		"\u0000\u0000\u009a\u009b\u0003\u0016\u000b\u0000\u009b\u009c\u0005\u0000"+
		"\u0000\u0001\u009c\u0019\u0001\u0000\u0000\u0000\u009d\u00a2\u0003\u001c"+
		"\u000e\u0000\u009e\u009f\u0005\u0014\u0000\u0000\u009f\u00a1\u0003\u001c"+
		"\u000e\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a3\u001b\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a6\u0003\u0002\u0001\u0000\u00a6\u00a7\u0005\f\u0000"+
		"\u0000\u00a7\u00a9\u0001\u0000\u0000\u0000\u00a8\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0003\u001e\u000f\u0000\u00ab\u001d\u0001\u0000\u0000"+
		"\u0000\u00ac\u00b0\u0005\u001c\u0000\u0000\u00ad\u00b0\u0005\u001d\u0000"+
		"\u0000\u00ae\u00b0\u0003 \u0010\u0000\u00af\u00ac\u0001\u0000\u0000\u0000"+
		"\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00ae\u0001\u0000\u0000\u0000"+
		"\u00b0\u001f\u0001\u0000\u0000\u0000\u00b1\u00b6\u0003\u0002\u0001\u0000"+
		"\u00b2\u00b3\u0005\u0017\u0000\u0000\u00b3\u00b5\u0003\u0002\u0001\u0000"+
		"\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b7!\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9"+
		"\u00ba\u0005\u0004\u0000\u0000\u00ba\u00bb\u0005\u0006\u0000\u0000\u00bb"+
		"\u00bc\u0003\u0002\u0001\u0000\u00bc\u00bd\u0005\b\u0000\u0000\u00bd\u00be"+
		"\u0003\u0002\u0001\u0000\u00be\u00c2\u0005\u0005\u0000\u0000\u00bf\u00c1"+
		"\u0003\u0010\b\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c4\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c6\u0005\u0004\u0000\u0000\u00c6\u00c7\u0005"+
		"\u0007\u0000\u0000\u00c7\u00c8\u0005\u0005\u0000\u0000\u00c8#\u0001\u0000"+
		"\u0000\u0000\u00c9\u00cb\u0003&\u0013\u0000\u00ca\u00c9\u0001\u0000\u0000"+
		"\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0005\u0000\u0000\u0001\u00cf%\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0003(\u0014\u0000\u00d1\u00d5\u0005\n\u0000\u0000\u00d2"+
		"\u00d4\u0003.\u0017\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d8\u0001\u0000\u0000\u0000\u00d7\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\u000b\u0000\u0000\u00d9\'\u0001"+
		"\u0000\u0000\u0000\u00da\u00df\u0003*\u0015\u0000\u00db\u00dc\u0005\u0014"+
		"\u0000\u0000\u00dc\u00de\u0003*\u0015\u0000\u00dd\u00db\u0001\u0000\u0000"+
		"\u0000\u00de\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0)\u0001\u0000\u0000\u0000"+
		"\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u00e6\u0003,\u0016\u0000\u00e3"+
		"\u00e5\u0003,\u0016\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e8"+
		"\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e7"+
		"\u0001\u0000\u0000\u0000\u00e7\u00eb\u0001\u0000\u0000\u0000\u00e8\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005\u0012\u0000\u0000\u00ea\u00ec"+
		"\u0003\u0002\u0001\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ec"+
		"\u0001\u0000\u0000\u0000\u00ec+\u0001\u0000\u0000\u0000\u00ed\u00f3\u0003"+
		"\u0002\u0001\u0000\u00ee\u00ef\u0005\u0017\u0000\u0000\u00ef\u00f3\u0003"+
		"\u0002\u0001\u0000\u00f0\u00f1\u0005 \u0000\u0000\u00f1\u00f3\u0003\u0002"+
		"\u0001\u0000\u00f2\u00ed\u0001\u0000\u0000\u0000\u00f2\u00ee\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3-\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f5\u0003\u0002\u0001\u0000\u00f5\u00f6\u0005\u0012\u0000"+
		"\u0000\u00f6\u00f7\u00030\u0018\u0000\u00f7\u00f8\u0005\u0013\u0000\u0000"+
		"\u00f8/\u0001\u0000\u0000\u0000\u00f9\u00fb\u00032\u0019\u0000\u00fa\u00f9"+
		"\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fa"+
		"\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd1\u0001"+
		"\u0000\u0000\u0000\u00fe\u0108\u0005\u001d\u0000\u0000\u00ff\u0108\u0005"+
		"\u001e\u0000\u0000\u0100\u0108\u0005\u001f\u0000\u0000\u0101\u0108\u0003"+
		"\u0002\u0001\u0000\u0102\u0108\u0005\u0014\u0000\u0000\u0103\u0108\u0005"+
		"\u0019\u0000\u0000\u0104\u0108\u0005\u001c\u0000\u0000\u0105\u0108\u0005"+
		"\u0015\u0000\u0000\u0106\u0108\u0005\u0016\u0000\u0000\u0107\u00fe\u0001"+
		"\u0000\u0000\u0000\u0107\u00ff\u0001\u0000\u0000\u0000\u0107\u0100\u0001"+
		"\u0000\u0000\u0000\u0107\u0101\u0001\u0000\u0000\u0000\u0107\u0102\u0001"+
		"\u0000\u0000\u0000\u0107\u0103\u0001\u0000\u0000\u0000\u0107\u0104\u0001"+
		"\u0000\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0107\u0106\u0001"+
		"\u0000\u0000\u0000\u01083\u0001\u0000\u0000\u0000\u001a6;@Q\\cht|\u0088"+
		"\u008a\u0095\u0098\u00a2\u00a8\u00af\u00b6\u00c2\u00cc\u00d5\u00df\u00e6"+
		"\u00eb\u00f2\u00fc\u0107";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}