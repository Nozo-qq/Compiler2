// Generated from D:/Nozo/Projects/Compiler2/src/antlr/grammar/Jinja2withHTMLandCSS/Jinja2withHTMLandCSSParser.g4 by ANTLR 4.13.2
package antlr.grammar.Jinja2withHTMLandCSS;
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
		RULE_htmlelement = 4, RULE_startTag = 5, RULE_endTag = 6, RULE_attribute = 7, 
		RULE_attributeValue = 8, RULE_elementContent = 9, RULE_statement = 10, 
		RULE_expression = 11, RULE_memberAccess = 12, RULE_block = 13, RULE_cssProg = 14, 
		RULE_cssRule = 15, RULE_cssSelectorList = 16, RULE_cssSelector = 17, RULE_simpleSelector = 18, 
		RULE_cssDeclaration = 19, RULE_cssValue = 20, RULE_cssValueAtom = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "anyId", "jinja2Prog", "doctype", "htmlelement", "startTag", 
			"endTag", "attribute", "attributeValue", "elementContent", "statement", 
			"expression", "memberAccess", "block", "cssProg", "cssRule", "cssSelectorList", 
			"cssSelector", "simpleSelector", "cssDeclaration", "cssValue", "cssValueAtom"
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
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new Jinja2Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				jinja2Prog();
				}
				break;
			case 2:
				_localctx = new CssContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
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
			setState(48);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(50);
				doctype();
				}
				break;
			}
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8857602000L) != 0)) {
				{
				{
				setState(53);
				elementContent();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
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
			setState(61);
			match(OPEN_TAG);
			setState(62);
			match(NOT);
			setState(63);
			anyId();
			setState(64);
			anyId();
			setState(65);
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
		public StartTagContext startTag() {
			return getRuleContext(StartTagContext.class,0);
		}
		public EndTagContext endTag() {
			return getRuleContext(EndTagContext.class,0);
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
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new OpenCloseTagContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				startTag();
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8857602000L) != 0)) {
					{
					{
					setState(68);
					elementContent();
					}
					}
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(74);
				endTag();
				}
				break;
			case 2:
				_localctx = new SelfClosingTagContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
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
	public static class StartTagContext extends ParserRuleContext {
		public TerminalNode OPEN_TAG() { return getToken(Jinja2withHTMLandCSSParser.OPEN_TAG, 0); }
		public AnyIdContext anyId() {
			return getRuleContext(AnyIdContext.class,0);
		}
		public TerminalNode CLOSE_TAG() { return getToken(Jinja2withHTMLandCSSParser.CLOSE_TAG, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public StartTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStartTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStartTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStartTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartTagContext startTag() throws RecognitionException {
		StartTagContext _localctx = new StartTagContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_startTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(OPEN_TAG);
			setState(89);
			anyId();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8589935552L) != 0)) {
				{
				{
				setState(90);
				attribute();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
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
	public static class EndTagContext extends ParserRuleContext {
		public TerminalNode OPEN_TAG_SLASH() { return getToken(Jinja2withHTMLandCSSParser.OPEN_TAG_SLASH, 0); }
		public AnyIdContext anyId() {
			return getRuleContext(AnyIdContext.class,0);
		}
		public TerminalNode CLOSE_TAG() { return getToken(Jinja2withHTMLandCSSParser.CLOSE_TAG, 0); }
		public EndTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
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

	public final EndTagContext endTag() throws RecognitionException {
		EndTagContext _localctx = new EndTagContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_endTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(OPEN_TAG_SLASH);
			setState(99);
			anyId();
			setState(100);
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
		enterRule(_localctx, 14, RULE_attribute);
		try {
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new FullAttrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				anyId();
				setState(103);
				match(ASSIGN);
				setState(104);
				attributeValue();
				}
				break;
			case 2:
				_localctx = new BooleanAttrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
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
		enterRule(_localctx, 16, RULE_attributeValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
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
		enterRule(_localctx, 18, RULE_elementContent);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_TAG:
				_localctx = new NestedElementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				htmlelement();
				}
				break;
			case LCURLY:
				_localctx = new JinjaExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				expression();
				}
				break;
			case BLOCK_START:
				_localctx = new JinjaBlockContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				block();
				}
				break;
			case FOR:
			case END_FOR:
			case IN:
			case BOOL:
			case COLON:
			case COMMA:
			case LPAREN:
			case RPAREN:
			case DOT:
			case PLUS:
			case MINUS:
			case STAR:
			case DIVISION:
			case IDENTIFIER:
				_localctx = new TextContentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				statement();
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
		enterRule(_localctx, 20, RULE_statement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(127); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(127);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case FOR:
					case END_FOR:
					case IN:
					case BOOL:
					case IDENTIFIER:
						{
						setState(117);
						anyId();
						}
						break;
					case COLON:
						{
						setState(118);
						match(COLON);
						}
						break;
					case LPAREN:
						{
						setState(119);
						match(LPAREN);
						}
						break;
					case RPAREN:
						{
						setState(120);
						match(RPAREN);
						}
						break;
					case DOT:
						{
						setState(121);
						match(DOT);
						}
						break;
					case COMMA:
						{
						setState(122);
						match(COMMA);
						}
						break;
					case PLUS:
						{
						setState(123);
						match(PLUS);
						}
						break;
					case MINUS:
						{
						setState(124);
						match(MINUS);
						}
						break;
					case STAR:
						{
						setState(125);
						match(STAR);
						}
						break;
					case DIVISION:
						{
						setState(126);
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
				setState(129); 
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
		public MemberAccessContext memberAccess() {
			return getRuleContext(MemberAccessContext.class,0);
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
		enterRule(_localctx, 22, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(LCURLY);
			setState(132);
			match(LCURLY);
			setState(133);
			memberAccess();
			setState(134);
			match(RCURLY);
			setState(135);
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
		enterRule(_localctx, 24, RULE_memberAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			anyId();
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(138);
				match(DOT);
				setState(139);
				anyId();
				}
				}
				setState(144);
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
		enterRule(_localctx, 26, RULE_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(BLOCK_START);
			setState(146);
			match(FOR);
			setState(147);
			anyId();
			setState(148);
			match(IN);
			setState(149);
			anyId();
			setState(150);
			match(BLOCK_END);
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(151);
					elementContent();
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(157);
			match(BLOCK_START);
			setState(158);
			match(END_FOR);
			setState(159);
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
		enterRule(_localctx, 28, RULE_cssProg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(161);
				cssRule();
				}
				}
				setState(164); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 12893291456L) != 0) );
			setState(166);
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
		enterRule(_localctx, 30, RULE_cssRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			cssSelectorList();
			setState(169);
			match(LCURLY);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8589935552L) != 0)) {
				{
				{
				setState(170);
				cssDeclaration();
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(176);
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
		enterRule(_localctx, 32, RULE_cssSelectorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			cssSelector();
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(179);
				match(COMMA);
				setState(180);
				cssSelector();
				}
				}
				setState(185);
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
		enterRule(_localctx, 34, RULE_cssSelector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			simpleSelector();
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12893291456L) != 0)) {
				{
				{
				setState(187);
				simpleSelector();
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(193);
				match(COLON);
				setState(194);
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
		enterRule(_localctx, 36, RULE_simpleSelector);
		try {
			setState(202);
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
				setState(197);
				anyId();
				}
				break;
			case DOT:
				_localctx = new ClassSelectorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				match(DOT);
				setState(199);
				anyId();
				}
				break;
			case HASH:
				_localctx = new IdSelectorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(200);
				match(HASH);
				setState(201);
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
		enterRule(_localctx, 38, RULE_cssDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			anyId();
			setState(205);
			match(COLON);
			setState(206);
			cssValue();
			setState(207);
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
		enterRule(_localctx, 40, RULE_cssValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(209);
				cssValueAtom();
				}
				}
				setState(212); 
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
		enterRule(_localctx, 42, RULE_cssValueAtom);
		try {
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new CssNumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				match(NUMBER);
				}
				break;
			case CSS_UNIT:
				_localctx = new CssUnitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				match(CSS_UNIT);
				}
				break;
			case CSS_COLOR:
				_localctx = new CssColorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(216);
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
				setState(217);
				anyId();
				}
				break;
			case COMMA:
				_localctx = new CssCommaContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(218);
				match(COMMA);
				}
				break;
			case MINUS:
				_localctx = new CssMinusContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(219);
				match(MINUS);
				}
				break;
			case STRING:
				_localctx = new CssStringContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(220);
				match(STRING);
				}
				break;
			case LPAREN:
				_localctx = new CssLParenContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(221);
				match(LPAREN);
				}
				break;
			case RPAREN:
				_localctx = new CssRParenContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(222);
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

	public static final String _serializedATN =
		"\u0004\u0001!\u00e2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0001\u0000\u0003\u0000/\b\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0003\u00024\b\u0002\u0001\u0002\u0005\u00027\b\u0002\n\u0002"+
		"\f\u0002:\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0005"+
		"\u0004F\b\u0004\n\u0004\f\u0004I\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004P\b\u0004\n\u0004\f\u0004S\t"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004W\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005\\\b\u0005\n\u0005\f\u0005_\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007l\b"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\tt\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0004\n\u0080\b\n\u000b\n\f\n\u0081\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u008d"+
		"\b\f\n\f\f\f\u0090\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0005\r\u0099\b\r\n\r\f\r\u009c\t\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0004\u000e\u00a3\b\u000e\u000b\u000e\f\u000e\u00a4\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00ac"+
		"\b\u000f\n\u000f\f\u000f\u00af\t\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u00b6\b\u0010\n\u0010\f\u0010\u00b9"+
		"\t\u0010\u0001\u0011\u0001\u0011\u0005\u0011\u00bd\b\u0011\n\u0011\f\u0011"+
		"\u00c0\t\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00c4\b\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00cb"+
		"\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0004\u0014\u00d3\b\u0014\u000b\u0014\f\u0014\u00d4\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0003\u0015\u00e0\b\u0015\u0001\u0015\u0000\u0000"+
		"\u0016\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*\u0000\u0002\u0002\u0000\u0006\t!!\u0001\u0000"+
		"\u0010\u0011\u00f2\u0000.\u0001\u0000\u0000\u0000\u00020\u0001\u0000\u0000"+
		"\u0000\u00043\u0001\u0000\u0000\u0000\u0006=\u0001\u0000\u0000\u0000\b"+
		"V\u0001\u0000\u0000\u0000\nX\u0001\u0000\u0000\u0000\fb\u0001\u0000\u0000"+
		"\u0000\u000ek\u0001\u0000\u0000\u0000\u0010m\u0001\u0000\u0000\u0000\u0012"+
		"s\u0001\u0000\u0000\u0000\u0014\u007f\u0001\u0000\u0000\u0000\u0016\u0083"+
		"\u0001\u0000\u0000\u0000\u0018\u0089\u0001\u0000\u0000\u0000\u001a\u0091"+
		"\u0001\u0000\u0000\u0000\u001c\u00a2\u0001\u0000\u0000\u0000\u001e\u00a8"+
		"\u0001\u0000\u0000\u0000 \u00b2\u0001\u0000\u0000\u0000\"\u00ba\u0001"+
		"\u0000\u0000\u0000$\u00ca\u0001\u0000\u0000\u0000&\u00cc\u0001\u0000\u0000"+
		"\u0000(\u00d2\u0001\u0000\u0000\u0000*\u00df\u0001\u0000\u0000\u0000,"+
		"/\u0003\u0004\u0002\u0000-/\u0003\u001c\u000e\u0000.,\u0001\u0000\u0000"+
		"\u0000.-\u0001\u0000\u0000\u0000/\u0001\u0001\u0000\u0000\u000001\u0007"+
		"\u0000\u0000\u00001\u0003\u0001\u0000\u0000\u000024\u0003\u0006\u0003"+
		"\u000032\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000048\u0001\u0000"+
		"\u0000\u000057\u0003\u0012\t\u000065\u0001\u0000\u0000\u00007:\u0001\u0000"+
		"\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009;\u0001"+
		"\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000;<\u0005\u0000\u0000\u0001"+
		"<\u0005\u0001\u0000\u0000\u0000=>\u0005\u000e\u0000\u0000>?\u0005\r\u0000"+
		"\u0000?@\u0003\u0002\u0001\u0000@A\u0003\u0002\u0001\u0000AB\u0005\u0010"+
		"\u0000\u0000B\u0007\u0001\u0000\u0000\u0000CG\u0003\n\u0005\u0000DF\u0003"+
		"\u0012\t\u0000ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000GE\u0001"+
		"\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HJ\u0001\u0000\u0000\u0000"+
		"IG\u0001\u0000\u0000\u0000JK\u0003\f\u0006\u0000KW\u0001\u0000\u0000\u0000"+
		"LM\u0005\u000e\u0000\u0000MQ\u0003\u0002\u0001\u0000NP\u0003\u000e\u0007"+
		"\u0000ON\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000"+
		"\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SQ\u0001"+
		"\u0000\u0000\u0000TU\u0007\u0001\u0000\u0000UW\u0001\u0000\u0000\u0000"+
		"VC\u0001\u0000\u0000\u0000VL\u0001\u0000\u0000\u0000W\t\u0001\u0000\u0000"+
		"\u0000XY\u0005\u000e\u0000\u0000Y]\u0003\u0002\u0001\u0000Z\\\u0003\u000e"+
		"\u0007\u0000[Z\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000][\u0001"+
		"\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^`\u0001\u0000\u0000\u0000"+
		"_]\u0001\u0000\u0000\u0000`a\u0005\u0010\u0000\u0000a\u000b\u0001\u0000"+
		"\u0000\u0000bc\u0005\u000f\u0000\u0000cd\u0003\u0002\u0001\u0000de\u0005"+
		"\u0010\u0000\u0000e\r\u0001\u0000\u0000\u0000fg\u0003\u0002\u0001\u0000"+
		"gh\u0005\f\u0000\u0000hi\u0003\u0010\b\u0000il\u0001\u0000\u0000\u0000"+
		"jl\u0003\u0002\u0001\u0000kf\u0001\u0000\u0000\u0000kj\u0001\u0000\u0000"+
		"\u0000l\u000f\u0001\u0000\u0000\u0000mn\u0005\u001c\u0000\u0000n\u0011"+
		"\u0001\u0000\u0000\u0000ot\u0003\b\u0004\u0000pt\u0003\u0016\u000b\u0000"+
		"qt\u0003\u001a\r\u0000rt\u0003\u0014\n\u0000so\u0001\u0000\u0000\u0000"+
		"sp\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000sr\u0001\u0000\u0000"+
		"\u0000t\u0013\u0001\u0000\u0000\u0000u\u0080\u0003\u0002\u0001\u0000v"+
		"\u0080\u0005\u0012\u0000\u0000w\u0080\u0005\u0015\u0000\u0000x\u0080\u0005"+
		"\u0016\u0000\u0000y\u0080\u0005\u0017\u0000\u0000z\u0080\u0005\u0014\u0000"+
		"\u0000{\u0080\u0005\u0018\u0000\u0000|\u0080\u0005\u0019\u0000\u0000}"+
		"\u0080\u0005\u001a\u0000\u0000~\u0080\u0005\u001b\u0000\u0000\u007fu\u0001"+
		"\u0000\u0000\u0000\u007fv\u0001\u0000\u0000\u0000\u007fw\u0001\u0000\u0000"+
		"\u0000\u007fx\u0001\u0000\u0000\u0000\u007fy\u0001\u0000\u0000\u0000\u007f"+
		"z\u0001\u0000\u0000\u0000\u007f{\u0001\u0000\u0000\u0000\u007f|\u0001"+
		"\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f~\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000"+
		"\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0015\u0001\u0000\u0000"+
		"\u0000\u0083\u0084\u0005\n\u0000\u0000\u0084\u0085\u0005\n\u0000\u0000"+
		"\u0085\u0086\u0003\u0018\f\u0000\u0086\u0087\u0005\u000b\u0000\u0000\u0087"+
		"\u0088\u0005\u000b\u0000\u0000\u0088\u0017\u0001\u0000\u0000\u0000\u0089"+
		"\u008e\u0003\u0002\u0001\u0000\u008a\u008b\u0005\u0017\u0000\u0000\u008b"+
		"\u008d\u0003\u0002\u0001\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008d"+
		"\u0090\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e"+
		"\u008f\u0001\u0000\u0000\u0000\u008f\u0019\u0001\u0000\u0000\u0000\u0090"+
		"\u008e\u0001\u0000\u0000\u0000\u0091\u0092\u0005\u0004\u0000\u0000\u0092"+
		"\u0093\u0005\u0006\u0000\u0000\u0093\u0094\u0003\u0002\u0001\u0000\u0094"+
		"\u0095\u0005\b\u0000\u0000\u0095\u0096\u0003\u0002\u0001\u0000\u0096\u009a"+
		"\u0005\u0005\u0000\u0000\u0097\u0099\u0003\u0012\t\u0000\u0098\u0097\u0001"+
		"\u0000\u0000\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009d\u0001"+
		"\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u009e\u0005"+
		"\u0004\u0000\u0000\u009e\u009f\u0005\u0007\u0000\u0000\u009f\u00a0\u0005"+
		"\u0005\u0000\u0000\u00a0\u001b\u0001\u0000\u0000\u0000\u00a1\u00a3\u0003"+
		"\u001e\u000f\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005"+
		"\u0000\u0000\u0001\u00a7\u001d\u0001\u0000\u0000\u0000\u00a8\u00a9\u0003"+
		" \u0010\u0000\u00a9\u00ad\u0005\n\u0000\u0000\u00aa\u00ac\u0003&\u0013"+
		"\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ac\u00af\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000"+
		"\u0000\u00ae\u00b0\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0005\u000b\u0000\u0000\u00b1\u001f\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b7\u0003\"\u0011\u0000\u00b3\u00b4\u0005\u0014\u0000\u0000"+
		"\u00b4\u00b6\u0003\"\u0011\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b8\u0001\u0000\u0000\u0000\u00b8!\u0001\u0000\u0000\u0000\u00b9\u00b7"+
		"\u0001\u0000\u0000\u0000\u00ba\u00be\u0003$\u0012\u0000\u00bb\u00bd\u0003"+
		"$\u0012\u0000\u00bc\u00bb\u0001\u0000\u0000\u0000\u00bd\u00c0\u0001\u0000"+
		"\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c3\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0005\u0012\u0000\u0000\u00c2\u00c4\u0003\u0002"+
		"\u0001\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c4#\u0001\u0000\u0000\u0000\u00c5\u00cb\u0003\u0002\u0001"+
		"\u0000\u00c6\u00c7\u0005\u0017\u0000\u0000\u00c7\u00cb\u0003\u0002\u0001"+
		"\u0000\u00c8\u00c9\u0005 \u0000\u0000\u00c9\u00cb\u0003\u0002\u0001\u0000"+
		"\u00ca\u00c5\u0001\u0000\u0000\u0000\u00ca\u00c6\u0001\u0000\u0000\u0000"+
		"\u00ca\u00c8\u0001\u0000\u0000\u0000\u00cb%\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cd\u0003\u0002\u0001\u0000\u00cd\u00ce\u0005\u0012\u0000\u0000\u00ce"+
		"\u00cf\u0003(\u0014\u0000\u00cf\u00d0\u0005\u0013\u0000\u0000\u00d0\'"+
		"\u0001\u0000\u0000\u0000\u00d1\u00d3\u0003*\u0015\u0000\u00d2\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5)\u0001\u0000"+
		"\u0000\u0000\u00d6\u00e0\u0005\u001d\u0000\u0000\u00d7\u00e0\u0005\u001e"+
		"\u0000\u0000\u00d8\u00e0\u0005\u001f\u0000\u0000\u00d9\u00e0\u0003\u0002"+
		"\u0001\u0000\u00da\u00e0\u0005\u0014\u0000\u0000\u00db\u00e0\u0005\u0019"+
		"\u0000\u0000\u00dc\u00e0\u0005\u001c\u0000\u0000\u00dd\u00e0\u0005\u0015"+
		"\u0000\u0000\u00de\u00e0\u0005\u0016\u0000\u0000\u00df\u00d6\u0001\u0000"+
		"\u0000\u0000\u00df\u00d7\u0001\u0000\u0000\u0000\u00df\u00d8\u0001\u0000"+
		"\u0000\u0000\u00df\u00d9\u0001\u0000\u0000\u0000\u00df\u00da\u0001\u0000"+
		"\u0000\u0000\u00df\u00db\u0001\u0000\u0000\u0000\u00df\u00dc\u0001\u0000"+
		"\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df\u00de\u0001\u0000"+
		"\u0000\u0000\u00e0+\u0001\u0000\u0000\u0000\u0015.38GQV]ks\u007f\u0081"+
		"\u008e\u009a\u00a4\u00ad\u00b7\u00be\u00c3\u00ca\u00d4\u00df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}