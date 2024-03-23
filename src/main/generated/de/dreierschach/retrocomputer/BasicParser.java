// Generated from de/dreierschach/retrocomputer/Basic.g4 by ANTLR 4.13.1
package de.dreierschach.retrocomputer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BasicParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, NOT=59, NUMBER=60, 
		DOUBLE_NUMBER=61, STRING_LITERAL=62, BOOL_LITERAL=63, ASTERISK=64, SLASH=65, 
		PERCENT=66, PLUS=67, MINUS=68, POW=69, EQUAL=70, NOT_EQUAL=71, LESS=72, 
		LESS_OR_EQUAL=73, GREATER=74, GREATER_OR_EQUAL=75, AND=76, OR=77, XOR=78, 
		FN_SIN=79, FN_COS=80, FN_TAN=81, FN_ASIN=82, FN_ACOS=83, FN_ATAN=84, FN_SQR=85, 
		FN_LOG=86, FN_ABS=87, FN_SGN=88, FN_CHR=89, FN_VAL=90, FN_INT=91, FN_FLOAT=92, 
		FN_STR=93, FN_RND=94, FN_SPC=95, FN_SUBSTR=96, FN_HEX=97, FN_AHEX=98, 
		FN_WIDTH=99, FN_HEIGHT=100, FN_LEN=101, NL=102, SPACE=103, COMMENT=104, 
		IDENTIFIER=105;
	public static final int
		RULE_program = 0, RULE_line = 1, RULE_statement = 2, RULE_forStatement = 3, 
		RULE_nextStatement = 4, RULE_assignment = 5, RULE_ifStatement = 6, RULE_thenStatement = 7, 
		RULE_elseStatement = 8, RULE_print = 9, RULE_println = 10, RULE_printNewline = 11, 
		RULE_goto = 12, RULE_gosub = 13, RULE_return = 14, RULE_end = 15, RULE_list = 16, 
		RULE_listAll = 17, RULE_listOne = 18, RULE_listFrom = 19, RULE_listTo = 20, 
		RULE_listFromTo = 21, RULE_clear = 22, RULE_cls = 23, RULE_new = 24, RULE_input = 25, 
		RULE_leftScroll = 26, RULE_rightScroll = 27, RULE_delay = 28, RULE_load = 29, 
		RULE_save = 30, RULE_dir = 31, RULE_del = 32, RULE_setMode = 33, RULE_color = 34, 
		RULE_bgcolor = 35, RULE_set = 36, RULE_drawLine = 37, RULE_drawEllipse = 38, 
		RULE_drawFEllipse = 39, RULE_drawRect = 40, RULE_drawFRect = 41, RULE_drawFace = 42, 
		RULE_drawFFace = 43, RULE_drawText = 44, RULE_drawFText = 45, RULE_drawCText = 46, 
		RULE_drawFCText = 47, RULE_arcade = 48, RULE_flip = 49, RULE_data = 50, 
		RULE_restore = 51, RULE_read = 52, RULE_vsync = 53, RULE_help = 54, RULE_identifier = 55, 
		RULE_expression = 56, RULE_keyboard = 57, RULE_functionCall = 58;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "line", "statement", "forStatement", "nextStatement", "assignment", 
			"ifStatement", "thenStatement", "elseStatement", "print", "println", 
			"printNewline", "goto", "gosub", "return", "end", "list", "listAll", 
			"listOne", "listFrom", "listTo", "listFromTo", "clear", "cls", "new", 
			"input", "leftScroll", "rightScroll", "delay", "load", "save", "dir", 
			"del", "setMode", "color", "bgcolor", "set", "drawLine", "drawEllipse", 
			"drawFEllipse", "drawRect", "drawFRect", "drawFace", "drawFFace", "drawText", 
			"drawFText", "drawCText", "drawFCText", "arcade", "flip", "data", "restore", 
			"read", "vsync", "help", "identifier", "expression", "keyboard", "functionCall"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'FOR'", "'TO'", "'STEP'", "'NEXT'", "'IF'", "'THEN'", "'ELSE'", 
			"'PRINT'", "'?'", "'@'", "','", "';'", "'GOTO'", "'GOSUB'", "'RETURN'", 
			"'END'", "'LIST'", "'CLEAR'", "'CLS'", "'NEW'", "'INPUT'", "'SCROLL'", 
			"'LEFT'", "'RIGHT'", "'DELAY'", "'LOAD'", "'SAVE'", "'DIR'", "'DEL'", 
			"'MODE'", "'COLOR'", "'SET'", "'LINE'", "'ELLIPSE'", "'FELLIPSE'", "'RECT'", 
			"'FRECT'", "'FACE'", "'FFACE'", "'TEXT'", "'AT'", "'FTEXT'", "'CTEXT'", 
			"'FCTEXT'", "'ARCADE'", "'FLIP'", "'DATA'", "'RESTORE'", "'READ'", "'VSYNC'", 
			"'HELP'", "'['", "']'", "'('", "')'", "'POINT'", "'KEY'", "'NOT'", null, 
			null, null, null, "'*'", "'/'", "'%'", "'+'", "'-'", "'^'", "'='", "'<>'", 
			"'<'", "'<='", "'>'", "'>='", "'AND'", "'OR'", "'XOR'", "'SIN'", "'COS'", 
			"'TAN'", "'ASIN'", "'ACOS'", "'ATAN'", "'SQR'", "'LOG'", "'ABS'", "'SGN'", 
			"'CHR'", "'VAL'", "'INT'", "'FLOAT'", "'STR'", "'RND'", "'SPC'", "'SUBSTR'", 
			"'HEX'", "'AHEX'", "'WIDTH'", "'HEIGHT'", "'LEN'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "NOT", 
			"NUMBER", "DOUBLE_NUMBER", "STRING_LITERAL", "BOOL_LITERAL", "ASTERISK", 
			"SLASH", "PERCENT", "PLUS", "MINUS", "POW", "EQUAL", "NOT_EQUAL", "LESS", 
			"LESS_OR_EQUAL", "GREATER", "GREATER_OR_EQUAL", "AND", "OR", "XOR", "FN_SIN", 
			"FN_COS", "FN_TAN", "FN_ASIN", "FN_ACOS", "FN_ATAN", "FN_SQR", "FN_LOG", 
			"FN_ABS", "FN_SGN", "FN_CHR", "FN_VAL", "FN_INT", "FN_FLOAT", "FN_STR", 
			"FN_RND", "FN_SPC", "FN_SUBSTR", "FN_HEX", "FN_AHEX", "FN_WIDTH", "FN_HEIGHT", 
			"FN_LEN", "NL", "SPACE", "COMMENT", "IDENTIFIER"
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
	public String getGrammarFileName() { return "Basic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BasicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public TerminalNode EOF() { return getToken(BasicParser.EOF, 0); }
		public List<TerminalNode> NL() { return getTokens(BasicParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(BasicParser.NL, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			line();
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(120); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(119);
						match(NL);
						}
						}
						setState(122); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NL );
					setState(124);
					line();
					}
					} 
				}
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(130);
				match(NL);
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136);
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
	public static class LineContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(BasicParser.NUMBER, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(NUMBER);
			setState(139);
			statement();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(140);
				match(T__0);
				setState(141);
				statement();
				}
				}
				setState(146);
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
	public static class StatementContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(BasicParser.COMMENT, 0); }
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public NextStatementContext nextStatement() {
			return getRuleContext(NextStatementContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public PrintlnContext println() {
			return getRuleContext(PrintlnContext.class,0);
		}
		public PrintNewlineContext printNewline() {
			return getRuleContext(PrintNewlineContext.class,0);
		}
		public GotoContext goto_() {
			return getRuleContext(GotoContext.class,0);
		}
		public GosubContext gosub() {
			return getRuleContext(GosubContext.class,0);
		}
		public ReturnContext return_() {
			return getRuleContext(ReturnContext.class,0);
		}
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ClearContext clear() {
			return getRuleContext(ClearContext.class,0);
		}
		public ClsContext cls() {
			return getRuleContext(ClsContext.class,0);
		}
		public NewContext new_() {
			return getRuleContext(NewContext.class,0);
		}
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public LeftScrollContext leftScroll() {
			return getRuleContext(LeftScrollContext.class,0);
		}
		public RightScrollContext rightScroll() {
			return getRuleContext(RightScrollContext.class,0);
		}
		public DelayContext delay() {
			return getRuleContext(DelayContext.class,0);
		}
		public LoadContext load() {
			return getRuleContext(LoadContext.class,0);
		}
		public SaveContext save() {
			return getRuleContext(SaveContext.class,0);
		}
		public DirContext dir() {
			return getRuleContext(DirContext.class,0);
		}
		public DelContext del() {
			return getRuleContext(DelContext.class,0);
		}
		public SetModeContext setMode() {
			return getRuleContext(SetModeContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public ColorContext color() {
			return getRuleContext(ColorContext.class,0);
		}
		public BgcolorContext bgcolor() {
			return getRuleContext(BgcolorContext.class,0);
		}
		public DrawLineContext drawLine() {
			return getRuleContext(DrawLineContext.class,0);
		}
		public DrawEllipseContext drawEllipse() {
			return getRuleContext(DrawEllipseContext.class,0);
		}
		public DrawFEllipseContext drawFEllipse() {
			return getRuleContext(DrawFEllipseContext.class,0);
		}
		public DrawRectContext drawRect() {
			return getRuleContext(DrawRectContext.class,0);
		}
		public DrawFRectContext drawFRect() {
			return getRuleContext(DrawFRectContext.class,0);
		}
		public DrawFaceContext drawFace() {
			return getRuleContext(DrawFaceContext.class,0);
		}
		public DrawFFaceContext drawFFace() {
			return getRuleContext(DrawFFaceContext.class,0);
		}
		public DrawTextContext drawText() {
			return getRuleContext(DrawTextContext.class,0);
		}
		public DrawFTextContext drawFText() {
			return getRuleContext(DrawFTextContext.class,0);
		}
		public DrawCTextContext drawCText() {
			return getRuleContext(DrawCTextContext.class,0);
		}
		public DrawFCTextContext drawFCText() {
			return getRuleContext(DrawFCTextContext.class,0);
		}
		public ArcadeContext arcade() {
			return getRuleContext(ArcadeContext.class,0);
		}
		public FlipContext flip() {
			return getRuleContext(FlipContext.class,0);
		}
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public ReadContext read() {
			return getRuleContext(ReadContext.class,0);
		}
		public RestoreContext restore() {
			return getRuleContext(RestoreContext.class,0);
		}
		public VsyncContext vsync() {
			return getRuleContext(VsyncContext.class,0);
		}
		public HelpContext help() {
			return getRuleContext(HelpContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(COMMENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				forStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				nextStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(150);
				assignment();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(151);
				ifStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(152);
				print();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(153);
				println();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(154);
				printNewline();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(155);
				goto_();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(156);
				gosub();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(157);
				return_();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(158);
				end();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(159);
				list();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(160);
				clear();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(161);
				cls();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(162);
				new_();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(163);
				input();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(164);
				leftScroll();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(165);
				rightScroll();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(166);
				delay();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(167);
				load();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(168);
				save();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(169);
				dir();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(170);
				del();
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(171);
				setMode();
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(172);
				set();
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(173);
				color();
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(174);
				bgcolor();
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(175);
				drawLine();
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(176);
				drawEllipse();
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(177);
				drawFEllipse();
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(178);
				drawRect();
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(179);
				drawFRect();
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(180);
				drawFace();
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(181);
				drawFFace();
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(182);
				drawText();
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(183);
				drawFText();
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(184);
				drawCText();
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 39);
				{
				setState(185);
				drawFCText();
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 40);
				{
				setState(186);
				arcade();
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 41);
				{
				setState(187);
				flip();
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 42);
				{
				setState(188);
				data();
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 43);
				{
				setState(189);
				read();
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 44);
				{
				setState(190);
				restore();
				}
				break;
			case 45:
				enterOuterAlt(_localctx, 45);
				{
				setState(191);
				vsync();
				}
				break;
			case 46:
				enterOuterAlt(_localctx, 46);
				{
				setState(192);
				help();
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
	public static class ForStatementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(BasicParser.EQUAL, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(T__1);
			setState(196);
			identifier();
			setState(197);
			match(EQUAL);
			setState(198);
			expression(0);
			setState(199);
			match(T__2);
			setState(200);
			expression(0);
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(201);
				match(T__3);
				setState(202);
				expression(0);
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
	public static class NextStatementContext extends ParserRuleContext {
		public NextStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nextStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterNextStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitNextStatement(this);
		}
	}

	public final NextStatementContext nextStatement() throws RecognitionException {
		NextStatementContext _localctx = new NextStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_nextStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__4);
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
	public static class AssignmentContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(BasicParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			identifier();
			setState(208);
			match(EQUAL);
			setState(209);
			expression(0);
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
	public static class IfStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ThenStatementContext thenStatement() {
			return getRuleContext(ThenStatementContext.class,0);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(T__5);
			setState(212);
			expression(0);
			setState(213);
			match(T__6);
			setState(214);
			thenStatement();
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(215);
				match(T__7);
				setState(216);
				elseStatement();
				}
				break;
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
	public static class ThenStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(BasicParser.NUMBER, 0); }
		public ThenStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thenStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterThenStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitThenStatement(this);
		}
	}

	public final ThenStatementContext thenStatement() throws RecognitionException {
		ThenStatementContext _localctx = new ThenStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_thenStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__4:
			case T__5:
			case T__8:
			case T__9:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
			case T__51:
			case COMMENT:
			case IDENTIFIER:
				{
				setState(219);
				statement();
				}
				break;
			case NUMBER:
				{
				setState(220);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class ElseStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(BasicParser.NUMBER, 0); }
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitElseStatement(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__4:
			case T__5:
			case T__8:
			case T__9:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
			case T__51:
			case COMMENT:
			case IDENTIFIER:
				{
				setState(223);
				statement();
				}
				break;
			case NUMBER:
				{
				setState(224);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class PrintContext extends ParserRuleContext {
		public ExpressionContext at;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitPrint(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_print);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==T__9) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(228);
				match(T__10);
				setState(229);
				((PrintContext)_localctx).at = expression(0);
				setState(230);
				match(T__11);
				}
			}

			setState(234);
			expression(0);
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(235);
					match(T__12);
					setState(236);
					expression(0);
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(242);
			match(T__12);
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
	public static class PrintlnContext extends ParserRuleContext {
		public ExpressionContext at;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PrintlnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_println; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterPrintln(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitPrintln(this);
		}
	}

	public final PrintlnContext println() throws RecognitionException {
		PrintlnContext _localctx = new PrintlnContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_println);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==T__9) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(245);
				match(T__10);
				setState(246);
				((PrintlnContext)_localctx).at = expression(0);
				setState(247);
				match(T__11);
				}
			}

			setState(251);
			expression(0);
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(252);
				match(T__12);
				setState(253);
				expression(0);
				}
				}
				setState(258);
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
	public static class PrintNewlineContext extends ParserRuleContext {
		public PrintNewlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printNewline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterPrintNewline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitPrintNewline(this);
		}
	}

	public final PrintNewlineContext printNewline() throws RecognitionException {
		PrintNewlineContext _localctx = new PrintNewlineContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_printNewline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(T__8);
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
	public static class GotoContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public GotoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterGoto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitGoto(this);
		}
	}

	public final GotoContext goto_() throws RecognitionException {
		GotoContext _localctx = new GotoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_goto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(T__13);
			setState(262);
			expression(0);
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
	public static class GosubContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public GosubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gosub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterGosub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitGosub(this);
		}
	}

	public final GosubContext gosub() throws RecognitionException {
		GosubContext _localctx = new GosubContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_gosub);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(T__14);
			setState(265);
			expression(0);
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
	public static class ReturnContext extends ParserRuleContext {
		public ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitReturn(this);
		}
	}

	public final ReturnContext return_() throws RecognitionException {
		ReturnContext _localctx = new ReturnContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(T__15);
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
	public static class EndContext extends ParserRuleContext {
		public EndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitEnd(this);
		}
	}

	public final EndContext end() throws RecognitionException {
		EndContext _localctx = new EndContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(T__16);
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
	public static class ListContext extends ParserRuleContext {
		public ListAllContext listAll() {
			return getRuleContext(ListAllContext.class,0);
		}
		public ListOneContext listOne() {
			return getRuleContext(ListOneContext.class,0);
		}
		public ListFromContext listFrom() {
			return getRuleContext(ListFromContext.class,0);
		}
		public ListToContext listTo() {
			return getRuleContext(ListToContext.class,0);
		}
		public ListFromToContext listFromTo() {
			return getRuleContext(ListFromToContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitList(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_list);
		try {
			setState(276);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				listAll();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				listOne();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(273);
				listFrom();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(274);
				listTo();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(275);
				listFromTo();
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
	public static class ListAllContext extends ParserRuleContext {
		public ListAllContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listAll; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterListAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitListAll(this);
		}
	}

	public final ListAllContext listAll() throws RecognitionException {
		ListAllContext _localctx = new ListAllContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_listAll);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(T__17);
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
	public static class ListOneContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(BasicParser.NUMBER, 0); }
		public ListOneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listOne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterListOne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitListOne(this);
		}
	}

	public final ListOneContext listOne() throws RecognitionException {
		ListOneContext _localctx = new ListOneContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_listOne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(T__17);
			setState(281);
			match(NUMBER);
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
	public static class ListFromContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(BasicParser.NUMBER, 0); }
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public ListFromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listFrom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterListFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitListFrom(this);
		}
	}

	public final ListFromContext listFrom() throws RecognitionException {
		ListFromContext _localctx = new ListFromContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_listFrom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(T__17);
			setState(284);
			match(NUMBER);
			setState(285);
			match(MINUS);
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
	public static class ListToContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public TerminalNode NUMBER() { return getToken(BasicParser.NUMBER, 0); }
		public ListToContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listTo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterListTo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitListTo(this);
		}
	}

	public final ListToContext listTo() throws RecognitionException {
		ListToContext _localctx = new ListToContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_listTo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(T__17);
			setState(288);
			match(MINUS);
			setState(289);
			match(NUMBER);
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
	public static class ListFromToContext extends ParserRuleContext {
		public Token from;
		public Token to;
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(BasicParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(BasicParser.NUMBER, i);
		}
		public ListFromToContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listFromTo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterListFromTo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitListFromTo(this);
		}
	}

	public final ListFromToContext listFromTo() throws RecognitionException {
		ListFromToContext _localctx = new ListFromToContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_listFromTo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(T__17);
			setState(292);
			((ListFromToContext)_localctx).from = match(NUMBER);
			setState(293);
			match(MINUS);
			setState(294);
			((ListFromToContext)_localctx).to = match(NUMBER);
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
	public static class ClearContext extends ParserRuleContext {
		public ClearContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clear; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterClear(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitClear(this);
		}
	}

	public final ClearContext clear() throws RecognitionException {
		ClearContext _localctx = new ClearContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_clear);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(T__18);
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
	public static class ClsContext extends ParserRuleContext {
		public ClsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterCls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitCls(this);
		}
	}

	public final ClsContext cls() throws RecognitionException {
		ClsContext _localctx = new ClsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_cls);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(T__19);
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
	public static class NewContext extends ParserRuleContext {
		public NewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitNew(this);
		}
	}

	public final NewContext new_() throws RecognitionException {
		NewContext _localctx = new NewContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_new);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(T__20);
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
	public static class InputContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitInput(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(T__21);
			setState(303);
			identifier();
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
	public static class LeftScrollContext extends ParserRuleContext {
		public LeftScrollContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftScroll; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterLeftScroll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitLeftScroll(this);
		}
	}

	public final LeftScrollContext leftScroll() throws RecognitionException {
		LeftScrollContext _localctx = new LeftScrollContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_leftScroll);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(T__22);
			setState(306);
			match(T__23);
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
	public static class RightScrollContext extends ParserRuleContext {
		public RightScrollContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightScroll; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterRightScroll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitRightScroll(this);
		}
	}

	public final RightScrollContext rightScroll() throws RecognitionException {
		RightScrollContext _localctx = new RightScrollContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_rightScroll);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(T__22);
			setState(309);
			match(T__24);
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
	public static class DelayContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DelayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delay; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterDelay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitDelay(this);
		}
	}

	public final DelayContext delay() throws RecognitionException {
		DelayContext _localctx = new DelayContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_delay);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			match(T__25);
			setState(312);
			expression(0);
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
	public static class LoadContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_load; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterLoad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitLoad(this);
		}
	}

	public final LoadContext load() throws RecognitionException {
		LoadContext _localctx = new LoadContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_load);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(T__26);
			setState(315);
			expression(0);
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
	public static class SaveContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SaveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_save; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterSave(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitSave(this);
		}
	}

	public final SaveContext save() throws RecognitionException {
		SaveContext _localctx = new SaveContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_save);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			match(T__27);
			setState(318);
			expression(0);
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
	public static class DirContext extends ParserRuleContext {
		public DirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dir; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterDir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitDir(this);
		}
	}

	public final DirContext dir() throws RecognitionException {
		DirContext _localctx = new DirContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_dir);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(T__28);
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
	public static class DelContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_del; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterDel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitDel(this);
		}
	}

	public final DelContext del() throws RecognitionException {
		DelContext _localctx = new DelContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_del);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(T__29);
			setState(323);
			expression(0);
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
	public static class SetModeContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SetModeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setMode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterSetMode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitSetMode(this);
		}
	}

	public final SetModeContext setMode() throws RecognitionException {
		SetModeContext _localctx = new SetModeContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_setMode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(T__30);
			setState(326);
			expression(0);
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
	public static class ColorContext extends ParserRuleContext {
		public Token bg;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_color; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitColor(this);
		}
	}

	public final ColorContext color() throws RecognitionException {
		ColorContext _localctx = new ColorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_color);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(T__31);
			setState(329);
			expression(0);
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(330);
				((ColorContext)_localctx).bg = match(T__11);
				setState(331);
				expression(0);
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
	public static class BgcolorContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BgcolorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bgcolor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterBgcolor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitBgcolor(this);
		}
	}

	public final BgcolorContext bgcolor() throws RecognitionException {
		BgcolorContext _localctx = new BgcolorContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_bgcolor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(T__31);
			setState(335);
			match(T__11);
			setState(336);
			expression(0);
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
	public static class SetContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitSet(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(T__32);
			setState(339);
			expression(0);
			setState(340);
			match(T__11);
			setState(341);
			expression(0);
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
	public static class DrawLineContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DrawLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterDrawLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitDrawLine(this);
		}
	}

	public final DrawLineContext drawLine() throws RecognitionException {
		DrawLineContext _localctx = new DrawLineContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_drawLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(T__33);
			setState(344);
			expression(0);
			setState(345);
			match(T__11);
			setState(346);
			expression(0);
			setState(347);
			match(T__2);
			setState(348);
			expression(0);
			setState(349);
			match(T__11);
			setState(350);
			expression(0);
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
	public static class DrawEllipseContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DrawEllipseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawEllipse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterDrawEllipse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitDrawEllipse(this);
		}
	}

	public final DrawEllipseContext drawEllipse() throws RecognitionException {
		DrawEllipseContext _localctx = new DrawEllipseContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_drawEllipse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(T__34);
			setState(353);
			expression(0);
			setState(354);
			match(T__11);
			setState(355);
			expression(0);
			setState(356);
			match(T__2);
			setState(357);
			expression(0);
			setState(358);
			match(T__11);
			setState(359);
			expression(0);
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
	public static class DrawFEllipseContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DrawFEllipseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawFEllipse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterDrawFEllipse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitDrawFEllipse(this);
		}
	}

	public final DrawFEllipseContext drawFEllipse() throws RecognitionException {
		DrawFEllipseContext _localctx = new DrawFEllipseContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_drawFEllipse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			match(T__35);
			setState(362);
			expression(0);
			setState(363);
			match(T__11);
			setState(364);
			expression(0);
			setState(365);
			match(T__2);
			setState(366);
			expression(0);
			setState(367);
			match(T__11);
			setState(368);
			expression(0);
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
	public static class DrawRectContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DrawRectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawRect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterDrawRect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitDrawRect(this);
		}
	}

	public final DrawRectContext drawRect() throws RecognitionException {
		DrawRectContext _localctx = new DrawRectContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_drawRect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(T__36);
			setState(371);
			expression(0);
			setState(372);
			match(T__11);
			setState(373);
			expression(0);
			setState(374);
			match(T__2);
			setState(375);
			expression(0);
			setState(376);
			match(T__11);
			setState(377);
			expression(0);
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
	public static class DrawFRectContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DrawFRectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawFRect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterDrawFRect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitDrawFRect(this);
		}
	}

	public final DrawFRectContext drawFRect() throws RecognitionException {
		DrawFRectContext _localctx = new DrawFRectContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_drawFRect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			match(T__37);
			setState(380);
			expression(0);
			setState(381);
			match(T__11);
			setState(382);
			expression(0);
			setState(383);
			match(T__2);
			setState(384);
			expression(0);
			setState(385);
			match(T__11);
			setState(386);
			expression(0);
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
	public static class DrawFaceContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DrawFaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawFace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterDrawFace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitDrawFace(this);
		}
	}

	public final DrawFaceContext drawFace() throws RecognitionException {
		DrawFaceContext _localctx = new DrawFaceContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_drawFace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			match(T__38);
			setState(389);
			expression(0);
			setState(390);
			match(T__11);
			setState(391);
			expression(0);
			setState(392);
			match(T__2);
			setState(393);
			expression(0);
			setState(394);
			match(T__11);
			setState(395);
			expression(0);
			setState(396);
			match(T__2);
			setState(397);
			expression(0);
			setState(398);
			match(T__11);
			setState(399);
			expression(0);
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
	public static class DrawFFaceContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DrawFFaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawFFace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterDrawFFace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitDrawFFace(this);
		}
	}

	public final DrawFFaceContext drawFFace() throws RecognitionException {
		DrawFFaceContext _localctx = new DrawFFaceContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_drawFFace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			match(T__39);
			setState(402);
			expression(0);
			setState(403);
			match(T__11);
			setState(404);
			expression(0);
			setState(405);
			match(T__2);
			setState(406);
			expression(0);
			setState(407);
			match(T__11);
			setState(408);
			expression(0);
			setState(409);
			match(T__2);
			setState(410);
			expression(0);
			setState(411);
			match(T__11);
			setState(412);
			expression(0);
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
	public static class DrawTextContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DrawTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterDrawText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitDrawText(this);
		}
	}

	public final DrawTextContext drawText() throws RecognitionException {
		DrawTextContext _localctx = new DrawTextContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_drawText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			match(T__40);
			setState(415);
			expression(0);
			setState(416);
			match(T__41);
			setState(417);
			expression(0);
			setState(418);
			match(T__11);
			setState(419);
			expression(0);
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
	public static class DrawFTextContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DrawFTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawFText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterDrawFText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitDrawFText(this);
		}
	}

	public final DrawFTextContext drawFText() throws RecognitionException {
		DrawFTextContext _localctx = new DrawFTextContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_drawFText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(T__42);
			setState(422);
			expression(0);
			setState(423);
			match(T__41);
			setState(424);
			expression(0);
			setState(425);
			match(T__11);
			setState(426);
			expression(0);
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
	public static class DrawCTextContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DrawCTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawCText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterDrawCText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitDrawCText(this);
		}
	}

	public final DrawCTextContext drawCText() throws RecognitionException {
		DrawCTextContext _localctx = new DrawCTextContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_drawCText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			match(T__43);
			setState(429);
			expression(0);
			setState(430);
			match(T__41);
			setState(431);
			expression(0);
			setState(432);
			match(T__11);
			setState(433);
			expression(0);
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
	public static class DrawFCTextContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DrawFCTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawFCText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterDrawFCText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitDrawFCText(this);
		}
	}

	public final DrawFCTextContext drawFCText() throws RecognitionException {
		DrawFCTextContext _localctx = new DrawFCTextContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_drawFCText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			match(T__44);
			setState(436);
			expression(0);
			setState(437);
			match(T__41);
			setState(438);
			expression(0);
			setState(439);
			match(T__11);
			setState(440);
			expression(0);
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
	public static class ArcadeContext extends ParserRuleContext {
		public ArcadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arcade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterArcade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitArcade(this);
		}
	}

	public final ArcadeContext arcade() throws RecognitionException {
		ArcadeContext _localctx = new ArcadeContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_arcade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			match(T__45);
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
	public static class FlipContext extends ParserRuleContext {
		public FlipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterFlip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitFlip(this);
		}
	}

	public final FlipContext flip() throws RecognitionException {
		FlipContext _localctx = new FlipContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_flip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			match(T__46);
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
	public static class DataContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitData(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			match(T__47);
			setState(447);
			expression(0);
			setState(452);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(448);
				match(T__11);
				setState(449);
				expression(0);
				}
				}
				setState(454);
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
	public static class RestoreContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(BasicParser.NUMBER, 0); }
		public RestoreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_restore; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterRestore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitRestore(this);
		}
	}

	public final RestoreContext restore() throws RecognitionException {
		RestoreContext _localctx = new RestoreContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_restore);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			match(T__48);
			setState(457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(456);
				match(NUMBER);
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
	public static class ReadContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitRead(this);
		}
	}

	public final ReadContext read() throws RecognitionException {
		ReadContext _localctx = new ReadContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_read);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			match(T__49);
			setState(460);
			identifier();
			setState(465);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(461);
				match(T__11);
				setState(462);
				identifier();
				}
				}
				setState(467);
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
	public static class VsyncContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VsyncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vsync; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterVsync(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitVsync(this);
		}
	}

	public final VsyncContext vsync() throws RecognitionException {
		VsyncContext _localctx = new VsyncContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_vsync);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			match(T__50);
			setState(470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 53)) & ~0x3f) == 0 && ((1L << (_la - 53)) & 5066549513717749L) != 0)) {
				{
				setState(469);
				expression(0);
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
	public static class HelpContext extends ParserRuleContext {
		public Token topic;
		public TerminalNode STRING_LITERAL() { return getToken(BasicParser.STRING_LITERAL, 0); }
		public HelpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_help; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterHelp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitHelp(this);
		}
	}

	public final HelpContext help() throws RecognitionException {
		HelpContext _localctx = new HelpContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_help);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			match(T__51);
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING_LITERAL) {
				{
				setState(473);
				((HelpContext)_localctx).topic = match(STRING_LITERAL);
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
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BasicParser.IDENTIFIER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			match(IDENTIFIER);
			setState(488);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(477);
				match(T__52);
				setState(478);
				expression(0);
				setState(483);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(479);
					match(T__11);
					setState(480);
					expression(0);
					}
					}
					setState(485);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(486);
				match(T__53);
				}
				break;
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
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParanthesisExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParanthesisExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterParanthesisExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitParanthesisExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleExprContext extends ExpressionContext {
		public TerminalNode DOUBLE_NUMBER() { return getToken(BasicParser.DOUBLE_NUMBER, 0); }
		public DoubleExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterDoubleExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitDoubleExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegativeExpressionContext extends ExpressionContext {
		public ExpressionContext right;
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NegativeExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterNegativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitNegativeExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitArrayExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(BasicParser.AND, 0); }
		public TerminalNode OR() { return getToken(BasicParser.OR, 0); }
		public TerminalNode XOR() { return getToken(BasicParser.XOR, 0); }
		public LogicalExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterLogicalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitLogicalExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlusMinusExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(BasicParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public PlusMinusExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterPlusMinusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitPlusMinusExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivModExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASTERISK() { return getToken(BasicParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(BasicParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(BasicParser.PERCENT, 0); }
		public MulDivModExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterMulDivModExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitMulDivModExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallExprContext extends ExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FuncCallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterFuncCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitFuncCallExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumExprContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(BasicParser.NUMBER, 0); }
		public NumExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterNumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitNumExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringExprContext extends ExpressionContext {
		public TerminalNode STRING_LITERAL() { return getToken(BasicParser.STRING_LITERAL, 0); }
		public StringExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterStringExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitStringExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class KeyboardExprContext extends ExpressionContext {
		public KeyboardContext keyboard() {
			return getRuleContext(KeyboardContext.class,0);
		}
		public KeyboardExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterKeyboardExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitKeyboardExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends ExpressionContext {
		public ExpressionContext right;
		public TerminalNode NOT() { return getToken(BasicParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitNotExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdExpContext extends ExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public IdExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterIdExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitIdExp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LESS() { return getToken(BasicParser.LESS, 0); }
		public TerminalNode LESS_OR_EQUAL() { return getToken(BasicParser.LESS_OR_EQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(BasicParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(BasicParser.NOT_EQUAL, 0); }
		public TerminalNode GREATER() { return getToken(BasicParser.GREATER, 0); }
		public TerminalNode GREATER_OR_EQUAL() { return getToken(BasicParser.GREATER_OR_EQUAL, 0); }
		public CompExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitCompExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolExprContext extends ExpressionContext {
		public TerminalNode BOOL_LITERAL() { return getToken(BasicParser.BOOL_LITERAL, 0); }
		public BoolExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitBoolExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PowExprContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode POW() { return getToken(BasicParser.POW, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PowExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterPowExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitPowExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PointExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PointExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterPointExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitPointExpr(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 112;
		enterRecursionRule(_localctx, 112, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__54:
				{
				_localctx = new ParanthesisExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(491);
				match(T__54);
				setState(492);
				expression(0);
				setState(493);
				match(T__55);
				}
				break;
			case NOT:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(495);
				match(NOT);
				setState(496);
				((NotExprContext)_localctx).right = expression(11);
				}
				break;
			case MINUS:
				{
				_localctx = new NegativeExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(497);
				match(MINUS);
				setState(498);
				((NegativeExpressionContext)_localctx).right = expression(10);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(499);
				match(NUMBER);
				}
				break;
			case DOUBLE_NUMBER:
				{
				_localctx = new DoubleExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(500);
				match(DOUBLE_NUMBER);
				}
				break;
			case STRING_LITERAL:
				{
				_localctx = new StringExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(501);
				match(STRING_LITERAL);
				}
				break;
			case BOOL_LITERAL:
				{
				_localctx = new BoolExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(502);
				match(BOOL_LITERAL);
				}
				break;
			case T__52:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(503);
				match(T__52);
				setState(504);
				expression(0);
				setState(509);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(505);
					match(T__11);
					setState(506);
					expression(0);
					}
					}
					setState(511);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(512);
				match(T__53);
				}
				break;
			case T__56:
				{
				_localctx = new PointExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(514);
				match(T__56);
				setState(515);
				match(T__54);
				setState(516);
				expression(0);
				setState(517);
				match(T__11);
				setState(518);
				expression(0);
				setState(519);
				match(T__55);
				}
				break;
			case FN_SIN:
			case FN_COS:
			case FN_TAN:
			case FN_ASIN:
			case FN_ACOS:
			case FN_ATAN:
			case FN_SQR:
			case FN_LOG:
			case FN_ABS:
			case FN_SGN:
			case FN_CHR:
			case FN_VAL:
			case FN_INT:
			case FN_FLOAT:
			case FN_STR:
			case FN_RND:
			case FN_SPC:
			case FN_SUBSTR:
			case FN_HEX:
			case FN_AHEX:
			case FN_WIDTH:
			case FN_HEIGHT:
			case FN_LEN:
				{
				_localctx = new FuncCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(521);
				functionCall();
				}
				break;
			case T__57:
				{
				_localctx = new KeyboardExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(522);
				keyboard();
				}
				break;
			case IDENTIFIER:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(523);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(543);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(541);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExpressionContext(_parentctx, _parentState));
						((PowExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(526);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(527);
						match(POW);
						setState(528);
						((PowExprContext)_localctx).right = expression(17);
						}
						break;
					case 2:
						{
						_localctx = new MulDivModExprContext(new ExpressionContext(_parentctx, _parentState));
						((MulDivModExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(529);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(530);
						((MulDivModExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 7L) != 0)) ) {
							((MulDivModExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(531);
						((MulDivModExprContext)_localctx).right = expression(16);
						}
						break;
					case 3:
						{
						_localctx = new PlusMinusExprContext(new ExpressionContext(_parentctx, _parentState));
						((PlusMinusExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(532);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(533);
						((PlusMinusExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((PlusMinusExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(534);
						((PlusMinusExprContext)_localctx).right = expression(15);
						}
						break;
					case 4:
						{
						_localctx = new CompExprContext(new ExpressionContext(_parentctx, _parentState));
						((CompExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(535);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(536);
						((CompExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 63L) != 0)) ) {
							((CompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(537);
						((CompExprContext)_localctx).right = expression(14);
						}
						break;
					case 5:
						{
						_localctx = new LogicalExprContext(new ExpressionContext(_parentctx, _parentState));
						((LogicalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(538);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(539);
						((LogicalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & 7L) != 0)) ) {
							((LogicalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(540);
						((LogicalExprContext)_localctx).right = expression(13);
						}
						break;
					}
					} 
				}
				setState(545);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeyboardContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public KeyboardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyboard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterKeyboard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitKeyboard(this);
		}
	}

	public final KeyboardContext keyboard() throws RecognitionException {
		KeyboardContext _localctx = new KeyboardContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_keyboard);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			match(T__57);
			setState(547);
			match(T__54);
			setState(549);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 53)) & ~0x3f) == 0 && ((1L << (_la - 53)) & 5066549513717749L) != 0)) {
				{
				setState(548);
				expression(0);
				}
			}

			setState(551);
			match(T__55);
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
	public static class FunctionCallContext extends ParserRuleContext {
		public Token fn;
		public TerminalNode FN_SIN() { return getToken(BasicParser.FN_SIN, 0); }
		public TerminalNode FN_COS() { return getToken(BasicParser.FN_COS, 0); }
		public TerminalNode FN_TAN() { return getToken(BasicParser.FN_TAN, 0); }
		public TerminalNode FN_ASIN() { return getToken(BasicParser.FN_ASIN, 0); }
		public TerminalNode FN_ACOS() { return getToken(BasicParser.FN_ACOS, 0); }
		public TerminalNode FN_ATAN() { return getToken(BasicParser.FN_ATAN, 0); }
		public TerminalNode FN_SQR() { return getToken(BasicParser.FN_SQR, 0); }
		public TerminalNode FN_LOG() { return getToken(BasicParser.FN_LOG, 0); }
		public TerminalNode FN_ABS() { return getToken(BasicParser.FN_ABS, 0); }
		public TerminalNode FN_SGN() { return getToken(BasicParser.FN_SGN, 0); }
		public TerminalNode FN_CHR() { return getToken(BasicParser.FN_CHR, 0); }
		public TerminalNode FN_VAL() { return getToken(BasicParser.FN_VAL, 0); }
		public TerminalNode FN_INT() { return getToken(BasicParser.FN_INT, 0); }
		public TerminalNode FN_FLOAT() { return getToken(BasicParser.FN_FLOAT, 0); }
		public TerminalNode FN_STR() { return getToken(BasicParser.FN_STR, 0); }
		public TerminalNode FN_RND() { return getToken(BasicParser.FN_RND, 0); }
		public TerminalNode FN_SPC() { return getToken(BasicParser.FN_SPC, 0); }
		public TerminalNode FN_SUBSTR() { return getToken(BasicParser.FN_SUBSTR, 0); }
		public TerminalNode FN_HEX() { return getToken(BasicParser.FN_HEX, 0); }
		public TerminalNode FN_AHEX() { return getToken(BasicParser.FN_AHEX, 0); }
		public TerminalNode FN_WIDTH() { return getToken(BasicParser.FN_WIDTH, 0); }
		public TerminalNode FN_HEIGHT() { return getToken(BasicParser.FN_HEIGHT, 0); }
		public TerminalNode FN_LEN() { return getToken(BasicParser.FN_LEN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicListener ) ((BasicListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			((FunctionCallContext)_localctx).fn = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & 8388607L) != 0)) ) {
				((FunctionCallContext)_localctx).fn = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(554);
			match(T__54);
			setState(563);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 53)) & ~0x3f) == 0 && ((1L << (_la - 53)) & 5066549513717749L) != 0)) {
				{
				setState(555);
				expression(0);
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(556);
					match(T__11);
					setState(557);
					expression(0);
					}
					}
					setState(562);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(565);
			match(T__55);
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
		case 56:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001i\u0238\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0001\u0000\u0001\u0000"+
		"\u0004\u0000y\b\u0000\u000b\u0000\f\u0000z\u0001\u0000\u0005\u0000~\b"+
		"\u0000\n\u0000\f\u0000\u0081\t\u0000\u0001\u0000\u0005\u0000\u0084\b\u0000"+
		"\n\u0000\f\u0000\u0087\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u008f\b\u0001\n\u0001\f\u0001"+
		"\u0092\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"\u00c2\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00cc\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u00da\b\u0006\u0001\u0007\u0001\u0007\u0003\u0007\u00de\b\u0007\u0001"+
		"\b\u0001\b\u0003\b\u00e2\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u00e9\b\t\u0001\t\u0001\t\u0001\t\u0005\t\u00ee\b\t\n\t\f\t\u00f1\t"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00fa"+
		"\b\n\u0001\n\u0001\n\u0001\n\u0005\n\u00ff\b\n\n\n\f\n\u0102\t\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0115\b\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0003\"\u014d\b\"\u0001#\u0001#\u0001#\u0001#\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001"+
		"(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001"+
		",\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		".\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u00010\u00010\u00011\u00011\u00012\u00012\u0001"+
		"2\u00012\u00052\u01c3\b2\n2\f2\u01c6\t2\u00013\u00013\u00033\u01ca\b3"+
		"\u00014\u00014\u00014\u00014\u00054\u01d0\b4\n4\f4\u01d3\t4\u00015\u0001"+
		"5\u00035\u01d7\b5\u00016\u00016\u00036\u01db\b6\u00017\u00017\u00017\u0001"+
		"7\u00017\u00057\u01e2\b7\n7\f7\u01e5\t7\u00017\u00017\u00037\u01e9\b7"+
		"\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00058\u01fc\b8\n8"+
		"\f8\u01ff\t8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00038\u020d\b8\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00058\u021e\b8\n8\f8\u0221\t8\u00019\u00019\u00019\u00039\u0226\b9"+
		"\u00019\u00019\u0001:\u0001:\u0001:\u0001:\u0001:\u0005:\u022f\b:\n:\f"+
		":\u0232\t:\u0003:\u0234\b:\u0001:\u0001:\u0001:\u0000\u0001p;\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprt\u0000\u0006\u0001\u0000"+
		"\t\n\u0001\u0000@B\u0001\u0000CD\u0001\u0000FK\u0001\u0000LN\u0001\u0000"+
		"Oe\u0255\u0000v\u0001\u0000\u0000\u0000\u0002\u008a\u0001\u0000\u0000"+
		"\u0000\u0004\u00c1\u0001\u0000\u0000\u0000\u0006\u00c3\u0001\u0000\u0000"+
		"\u0000\b\u00cd\u0001\u0000\u0000\u0000\n\u00cf\u0001\u0000\u0000\u0000"+
		"\f\u00d3\u0001\u0000\u0000\u0000\u000e\u00dd\u0001\u0000\u0000\u0000\u0010"+
		"\u00e1\u0001\u0000\u0000\u0000\u0012\u00e3\u0001\u0000\u0000\u0000\u0014"+
		"\u00f4\u0001\u0000\u0000\u0000\u0016\u0103\u0001\u0000\u0000\u0000\u0018"+
		"\u0105\u0001\u0000\u0000\u0000\u001a\u0108\u0001\u0000\u0000\u0000\u001c"+
		"\u010b\u0001\u0000\u0000\u0000\u001e\u010d\u0001\u0000\u0000\u0000 \u0114"+
		"\u0001\u0000\u0000\u0000\"\u0116\u0001\u0000\u0000\u0000$\u0118\u0001"+
		"\u0000\u0000\u0000&\u011b\u0001\u0000\u0000\u0000(\u011f\u0001\u0000\u0000"+
		"\u0000*\u0123\u0001\u0000\u0000\u0000,\u0128\u0001\u0000\u0000\u0000."+
		"\u012a\u0001\u0000\u0000\u00000\u012c\u0001\u0000\u0000\u00002\u012e\u0001"+
		"\u0000\u0000\u00004\u0131\u0001\u0000\u0000\u00006\u0134\u0001\u0000\u0000"+
		"\u00008\u0137\u0001\u0000\u0000\u0000:\u013a\u0001\u0000\u0000\u0000<"+
		"\u013d\u0001\u0000\u0000\u0000>\u0140\u0001\u0000\u0000\u0000@\u0142\u0001"+
		"\u0000\u0000\u0000B\u0145\u0001\u0000\u0000\u0000D\u0148\u0001\u0000\u0000"+
		"\u0000F\u014e\u0001\u0000\u0000\u0000H\u0152\u0001\u0000\u0000\u0000J"+
		"\u0157\u0001\u0000\u0000\u0000L\u0160\u0001\u0000\u0000\u0000N\u0169\u0001"+
		"\u0000\u0000\u0000P\u0172\u0001\u0000\u0000\u0000R\u017b\u0001\u0000\u0000"+
		"\u0000T\u0184\u0001\u0000\u0000\u0000V\u0191\u0001\u0000\u0000\u0000X"+
		"\u019e\u0001\u0000\u0000\u0000Z\u01a5\u0001\u0000\u0000\u0000\\\u01ac"+
		"\u0001\u0000\u0000\u0000^\u01b3\u0001\u0000\u0000\u0000`\u01ba\u0001\u0000"+
		"\u0000\u0000b\u01bc\u0001\u0000\u0000\u0000d\u01be\u0001\u0000\u0000\u0000"+
		"f\u01c7\u0001\u0000\u0000\u0000h\u01cb\u0001\u0000\u0000\u0000j\u01d4"+
		"\u0001\u0000\u0000\u0000l\u01d8\u0001\u0000\u0000\u0000n\u01dc\u0001\u0000"+
		"\u0000\u0000p\u020c\u0001\u0000\u0000\u0000r\u0222\u0001\u0000\u0000\u0000"+
		"t\u0229\u0001\u0000\u0000\u0000v\u007f\u0003\u0002\u0001\u0000wy\u0005"+
		"f\u0000\u0000xw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000zx\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000"+
		"|~\u0003\u0002\u0001\u0000}x\u0001\u0000\u0000\u0000~\u0081\u0001\u0000"+
		"\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000"+
		"\u0000\u0080\u0085\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000"+
		"\u0000\u0082\u0084\u0005f\u0000\u0000\u0083\u0082\u0001\u0000\u0000\u0000"+
		"\u0084\u0087\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0088\u0001\u0000\u0000\u0000"+
		"\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u0000\u0000\u0001"+
		"\u0089\u0001\u0001\u0000\u0000\u0000\u008a\u008b\u0005<\u0000\u0000\u008b"+
		"\u0090\u0003\u0004\u0002\u0000\u008c\u008d\u0005\u0001\u0000\u0000\u008d"+
		"\u008f\u0003\u0004\u0002\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008f"+
		"\u0092\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0001\u0000\u0000\u0000\u0091\u0003\u0001\u0000\u0000\u0000\u0092"+
		"\u0090\u0001\u0000\u0000\u0000\u0093\u00c2\u0005h\u0000\u0000\u0094\u00c2"+
		"\u0003\u0006\u0003\u0000\u0095\u00c2\u0003\b\u0004\u0000\u0096\u00c2\u0003"+
		"\n\u0005\u0000\u0097\u00c2\u0003\f\u0006\u0000\u0098\u00c2\u0003\u0012"+
		"\t\u0000\u0099\u00c2\u0003\u0014\n\u0000\u009a\u00c2\u0003\u0016\u000b"+
		"\u0000\u009b\u00c2\u0003\u0018\f\u0000\u009c\u00c2\u0003\u001a\r\u0000"+
		"\u009d\u00c2\u0003\u001c\u000e\u0000\u009e\u00c2\u0003\u001e\u000f\u0000"+
		"\u009f\u00c2\u0003 \u0010\u0000\u00a0\u00c2\u0003,\u0016\u0000\u00a1\u00c2"+
		"\u0003.\u0017\u0000\u00a2\u00c2\u00030\u0018\u0000\u00a3\u00c2\u00032"+
		"\u0019\u0000\u00a4\u00c2\u00034\u001a\u0000\u00a5\u00c2\u00036\u001b\u0000"+
		"\u00a6\u00c2\u00038\u001c\u0000\u00a7\u00c2\u0003:\u001d\u0000\u00a8\u00c2"+
		"\u0003<\u001e\u0000\u00a9\u00c2\u0003>\u001f\u0000\u00aa\u00c2\u0003@"+
		" \u0000\u00ab\u00c2\u0003B!\u0000\u00ac\u00c2\u0003H$\u0000\u00ad\u00c2"+
		"\u0003D\"\u0000\u00ae\u00c2\u0003F#\u0000\u00af\u00c2\u0003J%\u0000\u00b0"+
		"\u00c2\u0003L&\u0000\u00b1\u00c2\u0003N\'\u0000\u00b2\u00c2\u0003P(\u0000"+
		"\u00b3\u00c2\u0003R)\u0000\u00b4\u00c2\u0003T*\u0000\u00b5\u00c2\u0003"+
		"V+\u0000\u00b6\u00c2\u0003X,\u0000\u00b7\u00c2\u0003Z-\u0000\u00b8\u00c2"+
		"\u0003\\.\u0000\u00b9\u00c2\u0003^/\u0000\u00ba\u00c2\u0003`0\u0000\u00bb"+
		"\u00c2\u0003b1\u0000\u00bc\u00c2\u0003d2\u0000\u00bd\u00c2\u0003h4\u0000"+
		"\u00be\u00c2\u0003f3\u0000\u00bf\u00c2\u0003j5\u0000\u00c0\u00c2\u0003"+
		"l6\u0000\u00c1\u0093\u0001\u0000\u0000\u0000\u00c1\u0094\u0001\u0000\u0000"+
		"\u0000\u00c1\u0095\u0001\u0000\u0000\u0000\u00c1\u0096\u0001\u0000\u0000"+
		"\u0000\u00c1\u0097\u0001\u0000\u0000\u0000\u00c1\u0098\u0001\u0000\u0000"+
		"\u0000\u00c1\u0099\u0001\u0000\u0000\u0000\u00c1\u009a\u0001\u0000\u0000"+
		"\u0000\u00c1\u009b\u0001\u0000\u0000\u0000\u00c1\u009c\u0001\u0000\u0000"+
		"\u0000\u00c1\u009d\u0001\u0000\u0000\u0000\u00c1\u009e\u0001\u0000\u0000"+
		"\u0000\u00c1\u009f\u0001\u0000\u0000\u0000\u00c1\u00a0\u0001\u0000\u0000"+
		"\u0000\u00c1\u00a1\u0001\u0000\u0000\u0000\u00c1\u00a2\u0001\u0000\u0000"+
		"\u0000\u00c1\u00a3\u0001\u0000\u0000\u0000\u00c1\u00a4\u0001\u0000\u0000"+
		"\u0000\u00c1\u00a5\u0001\u0000\u0000\u0000\u00c1\u00a6\u0001\u0000\u0000"+
		"\u0000\u00c1\u00a7\u0001\u0000\u0000\u0000\u00c1\u00a8\u0001\u0000\u0000"+
		"\u0000\u00c1\u00a9\u0001\u0000\u0000\u0000\u00c1\u00aa\u0001\u0000\u0000"+
		"\u0000\u00c1\u00ab\u0001\u0000\u0000\u0000\u00c1\u00ac\u0001\u0000\u0000"+
		"\u0000\u00c1\u00ad\u0001\u0000\u0000\u0000\u00c1\u00ae\u0001\u0000\u0000"+
		"\u0000\u00c1\u00af\u0001\u0000\u0000\u0000\u00c1\u00b0\u0001\u0000\u0000"+
		"\u0000\u00c1\u00b1\u0001\u0000\u0000\u0000\u00c1\u00b2\u0001\u0000\u0000"+
		"\u0000\u00c1\u00b3\u0001\u0000\u0000\u0000\u00c1\u00b4\u0001\u0000\u0000"+
		"\u0000\u00c1\u00b5\u0001\u0000\u0000\u0000\u00c1\u00b6\u0001\u0000\u0000"+
		"\u0000\u00c1\u00b7\u0001\u0000\u0000\u0000\u00c1\u00b8\u0001\u0000\u0000"+
		"\u0000\u00c1\u00b9\u0001\u0000\u0000\u0000\u00c1\u00ba\u0001\u0000\u0000"+
		"\u0000\u00c1\u00bb\u0001\u0000\u0000\u0000\u00c1\u00bc\u0001\u0000\u0000"+
		"\u0000\u00c1\u00bd\u0001\u0000\u0000\u0000\u00c1\u00be\u0001\u0000\u0000"+
		"\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c2\u0005\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005\u0002\u0000"+
		"\u0000\u00c4\u00c5\u0003n7\u0000\u00c5\u00c6\u0005F\u0000\u0000\u00c6"+
		"\u00c7\u0003p8\u0000\u00c7\u00c8\u0005\u0003\u0000\u0000\u00c8\u00cb\u0003"+
		"p8\u0000\u00c9\u00ca\u0005\u0004\u0000\u0000\u00ca\u00cc\u0003p8\u0000"+
		"\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000"+
		"\u00cc\u0007\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005\u0005\u0000\u0000"+
		"\u00ce\t\u0001\u0000\u0000\u0000\u00cf\u00d0\u0003n7\u0000\u00d0\u00d1"+
		"\u0005F\u0000\u0000\u00d1\u00d2\u0003p8\u0000\u00d2\u000b\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d4\u0005\u0006\u0000\u0000\u00d4\u00d5\u0003p8\u0000"+
		"\u00d5\u00d6\u0005\u0007\u0000\u0000\u00d6\u00d9\u0003\u000e\u0007\u0000"+
		"\u00d7\u00d8\u0005\b\u0000\u0000\u00d8\u00da\u0003\u0010\b\u0000\u00d9"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da"+
		"\r\u0001\u0000\u0000\u0000\u00db\u00de\u0003\u0004\u0002\u0000\u00dc\u00de"+
		"\u0005<\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00dc\u0001"+
		"\u0000\u0000\u0000\u00de\u000f\u0001\u0000\u0000\u0000\u00df\u00e2\u0003"+
		"\u0004\u0002\u0000\u00e0\u00e2\u0005<\u0000\u0000\u00e1\u00df\u0001\u0000"+
		"\u0000\u0000\u00e1\u00e0\u0001\u0000\u0000\u0000\u00e2\u0011\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e8\u0007\u0000\u0000\u0000\u00e4\u00e5\u0005\u000b"+
		"\u0000\u0000\u00e5\u00e6\u0003p8\u0000\u00e6\u00e7\u0005\f\u0000\u0000"+
		"\u00e7\u00e9\u0001\u0000\u0000\u0000\u00e8\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000"+
		"\u00ea\u00ef\u0003p8\u0000\u00eb\u00ec\u0005\r\u0000\u0000\u00ec\u00ee"+
		"\u0003p8\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u00f1\u0001\u0000"+
		"\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f0\u00f2\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0005\r\u0000\u0000\u00f3\u0013\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f9\u0007\u0000\u0000\u0000\u00f5\u00f6\u0005\u000b\u0000"+
		"\u0000\u00f6\u00f7\u0003p8\u0000\u00f7\u00f8\u0005\f\u0000\u0000\u00f8"+
		"\u00fa\u0001\u0000\u0000\u0000\u00f9\u00f5\u0001\u0000\u0000\u0000\u00f9"+
		"\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb"+
		"\u0100\u0003p8\u0000\u00fc\u00fd\u0005\r\u0000\u0000\u00fd\u00ff\u0003"+
		"p8\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00ff\u0102\u0001\u0000\u0000"+
		"\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000"+
		"\u0000\u0101\u0015\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000"+
		"\u0000\u0103\u0104\u0005\t\u0000\u0000\u0104\u0017\u0001\u0000\u0000\u0000"+
		"\u0105\u0106\u0005\u000e\u0000\u0000\u0106\u0107\u0003p8\u0000\u0107\u0019"+
		"\u0001\u0000\u0000\u0000\u0108\u0109\u0005\u000f\u0000\u0000\u0109\u010a"+
		"\u0003p8\u0000\u010a\u001b\u0001\u0000\u0000\u0000\u010b\u010c\u0005\u0010"+
		"\u0000\u0000\u010c\u001d\u0001\u0000\u0000\u0000\u010d\u010e\u0005\u0011"+
		"\u0000\u0000\u010e\u001f\u0001\u0000\u0000\u0000\u010f\u0115\u0003\"\u0011"+
		"\u0000\u0110\u0115\u0003$\u0012\u0000\u0111\u0115\u0003&\u0013\u0000\u0112"+
		"\u0115\u0003(\u0014\u0000\u0113\u0115\u0003*\u0015\u0000\u0114\u010f\u0001"+
		"\u0000\u0000\u0000\u0114\u0110\u0001\u0000\u0000\u0000\u0114\u0111\u0001"+
		"\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0114\u0113\u0001"+
		"\u0000\u0000\u0000\u0115!\u0001\u0000\u0000\u0000\u0116\u0117\u0005\u0012"+
		"\u0000\u0000\u0117#\u0001\u0000\u0000\u0000\u0118\u0119\u0005\u0012\u0000"+
		"\u0000\u0119\u011a\u0005<\u0000\u0000\u011a%\u0001\u0000\u0000\u0000\u011b"+
		"\u011c\u0005\u0012\u0000\u0000\u011c\u011d\u0005<\u0000\u0000\u011d\u011e"+
		"\u0005D\u0000\u0000\u011e\'\u0001\u0000\u0000\u0000\u011f\u0120\u0005"+
		"\u0012\u0000\u0000\u0120\u0121\u0005D\u0000\u0000\u0121\u0122\u0005<\u0000"+
		"\u0000\u0122)\u0001\u0000\u0000\u0000\u0123\u0124\u0005\u0012\u0000\u0000"+
		"\u0124\u0125\u0005<\u0000\u0000\u0125\u0126\u0005D\u0000\u0000\u0126\u0127"+
		"\u0005<\u0000\u0000\u0127+\u0001\u0000\u0000\u0000\u0128\u0129\u0005\u0013"+
		"\u0000\u0000\u0129-\u0001\u0000\u0000\u0000\u012a\u012b\u0005\u0014\u0000"+
		"\u0000\u012b/\u0001\u0000\u0000\u0000\u012c\u012d\u0005\u0015\u0000\u0000"+
		"\u012d1\u0001\u0000\u0000\u0000\u012e\u012f\u0005\u0016\u0000\u0000\u012f"+
		"\u0130\u0003n7\u0000\u01303\u0001\u0000\u0000\u0000\u0131\u0132\u0005"+
		"\u0017\u0000\u0000\u0132\u0133\u0005\u0018\u0000\u0000\u01335\u0001\u0000"+
		"\u0000\u0000\u0134\u0135\u0005\u0017\u0000\u0000\u0135\u0136\u0005\u0019"+
		"\u0000\u0000\u01367\u0001\u0000\u0000\u0000\u0137\u0138\u0005\u001a\u0000"+
		"\u0000\u0138\u0139\u0003p8\u0000\u01399\u0001\u0000\u0000\u0000\u013a"+
		"\u013b\u0005\u001b\u0000\u0000\u013b\u013c\u0003p8\u0000\u013c;\u0001"+
		"\u0000\u0000\u0000\u013d\u013e\u0005\u001c\u0000\u0000\u013e\u013f\u0003"+
		"p8\u0000\u013f=\u0001\u0000\u0000\u0000\u0140\u0141\u0005\u001d\u0000"+
		"\u0000\u0141?\u0001\u0000\u0000\u0000\u0142\u0143\u0005\u001e\u0000\u0000"+
		"\u0143\u0144\u0003p8\u0000\u0144A\u0001\u0000\u0000\u0000\u0145\u0146"+
		"\u0005\u001f\u0000\u0000\u0146\u0147\u0003p8\u0000\u0147C\u0001\u0000"+
		"\u0000\u0000\u0148\u0149\u0005 \u0000\u0000\u0149\u014c\u0003p8\u0000"+
		"\u014a\u014b\u0005\f\u0000\u0000\u014b\u014d\u0003p8\u0000\u014c\u014a"+
		"\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000\u0000\u014dE\u0001"+
		"\u0000\u0000\u0000\u014e\u014f\u0005 \u0000\u0000\u014f\u0150\u0005\f"+
		"\u0000\u0000\u0150\u0151\u0003p8\u0000\u0151G\u0001\u0000\u0000\u0000"+
		"\u0152\u0153\u0005!\u0000\u0000\u0153\u0154\u0003p8\u0000\u0154\u0155"+
		"\u0005\f\u0000\u0000\u0155\u0156\u0003p8\u0000\u0156I\u0001\u0000\u0000"+
		"\u0000\u0157\u0158\u0005\"\u0000\u0000\u0158\u0159\u0003p8\u0000\u0159"+
		"\u015a\u0005\f\u0000\u0000\u015a\u015b\u0003p8\u0000\u015b\u015c\u0005"+
		"\u0003\u0000\u0000\u015c\u015d\u0003p8\u0000\u015d\u015e\u0005\f\u0000"+
		"\u0000\u015e\u015f\u0003p8\u0000\u015fK\u0001\u0000\u0000\u0000\u0160"+
		"\u0161\u0005#\u0000\u0000\u0161\u0162\u0003p8\u0000\u0162\u0163\u0005"+
		"\f\u0000\u0000\u0163\u0164\u0003p8\u0000\u0164\u0165\u0005\u0003\u0000"+
		"\u0000\u0165\u0166\u0003p8\u0000\u0166\u0167\u0005\f\u0000\u0000\u0167"+
		"\u0168\u0003p8\u0000\u0168M\u0001\u0000\u0000\u0000\u0169\u016a\u0005"+
		"$\u0000\u0000\u016a\u016b\u0003p8\u0000\u016b\u016c\u0005\f\u0000\u0000"+
		"\u016c\u016d\u0003p8\u0000\u016d\u016e\u0005\u0003\u0000\u0000\u016e\u016f"+
		"\u0003p8\u0000\u016f\u0170\u0005\f\u0000\u0000\u0170\u0171\u0003p8\u0000"+
		"\u0171O\u0001\u0000\u0000\u0000\u0172\u0173\u0005%\u0000\u0000\u0173\u0174"+
		"\u0003p8\u0000\u0174\u0175\u0005\f\u0000\u0000\u0175\u0176\u0003p8\u0000"+
		"\u0176\u0177\u0005\u0003\u0000\u0000\u0177\u0178\u0003p8\u0000\u0178\u0179"+
		"\u0005\f\u0000\u0000\u0179\u017a\u0003p8\u0000\u017aQ\u0001\u0000\u0000"+
		"\u0000\u017b\u017c\u0005&\u0000\u0000\u017c\u017d\u0003p8\u0000\u017d"+
		"\u017e\u0005\f\u0000\u0000\u017e\u017f\u0003p8\u0000\u017f\u0180\u0005"+
		"\u0003\u0000\u0000\u0180\u0181\u0003p8\u0000\u0181\u0182\u0005\f\u0000"+
		"\u0000\u0182\u0183\u0003p8\u0000\u0183S\u0001\u0000\u0000\u0000\u0184"+
		"\u0185\u0005\'\u0000\u0000\u0185\u0186\u0003p8\u0000\u0186\u0187\u0005"+
		"\f\u0000\u0000\u0187\u0188\u0003p8\u0000\u0188\u0189\u0005\u0003\u0000"+
		"\u0000\u0189\u018a\u0003p8\u0000\u018a\u018b\u0005\f\u0000\u0000\u018b"+
		"\u018c\u0003p8\u0000\u018c\u018d\u0005\u0003\u0000\u0000\u018d\u018e\u0003"+
		"p8\u0000\u018e\u018f\u0005\f\u0000\u0000\u018f\u0190\u0003p8\u0000\u0190"+
		"U\u0001\u0000\u0000\u0000\u0191\u0192\u0005(\u0000\u0000\u0192\u0193\u0003"+
		"p8\u0000\u0193\u0194\u0005\f\u0000\u0000\u0194\u0195\u0003p8\u0000\u0195"+
		"\u0196\u0005\u0003\u0000\u0000\u0196\u0197\u0003p8\u0000\u0197\u0198\u0005"+
		"\f\u0000\u0000\u0198\u0199\u0003p8\u0000\u0199\u019a\u0005\u0003\u0000"+
		"\u0000\u019a\u019b\u0003p8\u0000\u019b\u019c\u0005\f\u0000\u0000\u019c"+
		"\u019d\u0003p8\u0000\u019dW\u0001\u0000\u0000\u0000\u019e\u019f\u0005"+
		")\u0000\u0000\u019f\u01a0\u0003p8\u0000\u01a0\u01a1\u0005*\u0000\u0000"+
		"\u01a1\u01a2\u0003p8\u0000\u01a2\u01a3\u0005\f\u0000\u0000\u01a3\u01a4"+
		"\u0003p8\u0000\u01a4Y\u0001\u0000\u0000\u0000\u01a5\u01a6\u0005+\u0000"+
		"\u0000\u01a6\u01a7\u0003p8\u0000\u01a7\u01a8\u0005*\u0000\u0000\u01a8"+
		"\u01a9\u0003p8\u0000\u01a9\u01aa\u0005\f\u0000\u0000\u01aa\u01ab\u0003"+
		"p8\u0000\u01ab[\u0001\u0000\u0000\u0000\u01ac\u01ad\u0005,\u0000\u0000"+
		"\u01ad\u01ae\u0003p8\u0000\u01ae\u01af\u0005*\u0000\u0000\u01af\u01b0"+
		"\u0003p8\u0000\u01b0\u01b1\u0005\f\u0000\u0000\u01b1\u01b2\u0003p8\u0000"+
		"\u01b2]\u0001\u0000\u0000\u0000\u01b3\u01b4\u0005-\u0000\u0000\u01b4\u01b5"+
		"\u0003p8\u0000\u01b5\u01b6\u0005*\u0000\u0000\u01b6\u01b7\u0003p8\u0000"+
		"\u01b7\u01b8\u0005\f\u0000\u0000\u01b8\u01b9\u0003p8\u0000\u01b9_\u0001"+
		"\u0000\u0000\u0000\u01ba\u01bb\u0005.\u0000\u0000\u01bba\u0001\u0000\u0000"+
		"\u0000\u01bc\u01bd\u0005/\u0000\u0000\u01bdc\u0001\u0000\u0000\u0000\u01be"+
		"\u01bf\u00050\u0000\u0000\u01bf\u01c4\u0003p8\u0000\u01c0\u01c1\u0005"+
		"\f\u0000\u0000\u01c1\u01c3\u0003p8\u0000\u01c2\u01c0\u0001\u0000\u0000"+
		"\u0000\u01c3\u01c6\u0001\u0000\u0000\u0000\u01c4\u01c2\u0001\u0000\u0000"+
		"\u0000\u01c4\u01c5\u0001\u0000\u0000\u0000\u01c5e\u0001\u0000\u0000\u0000"+
		"\u01c6\u01c4\u0001\u0000\u0000\u0000\u01c7\u01c9\u00051\u0000\u0000\u01c8"+
		"\u01ca\u0005<\u0000\u0000\u01c9\u01c8\u0001\u0000\u0000\u0000\u01c9\u01ca"+
		"\u0001\u0000\u0000\u0000\u01cag\u0001\u0000\u0000\u0000\u01cb\u01cc\u0005"+
		"2\u0000\u0000\u01cc\u01d1\u0003n7\u0000\u01cd\u01ce\u0005\f\u0000\u0000"+
		"\u01ce\u01d0\u0003n7\u0000\u01cf\u01cd\u0001\u0000\u0000\u0000\u01d0\u01d3"+
		"\u0001\u0000\u0000\u0000\u01d1\u01cf\u0001\u0000\u0000\u0000\u01d1\u01d2"+
		"\u0001\u0000\u0000\u0000\u01d2i\u0001\u0000\u0000\u0000\u01d3\u01d1\u0001"+
		"\u0000\u0000\u0000\u01d4\u01d6\u00053\u0000\u0000\u01d5\u01d7\u0003p8"+
		"\u0000\u01d6\u01d5\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000\u0000"+
		"\u0000\u01d7k\u0001\u0000\u0000\u0000\u01d8\u01da\u00054\u0000\u0000\u01d9"+
		"\u01db\u0005>\u0000\u0000\u01da\u01d9\u0001\u0000\u0000\u0000\u01da\u01db"+
		"\u0001\u0000\u0000\u0000\u01dbm\u0001\u0000\u0000\u0000\u01dc\u01e8\u0005"+
		"i\u0000\u0000\u01dd\u01de\u00055\u0000\u0000\u01de\u01e3\u0003p8\u0000"+
		"\u01df\u01e0\u0005\f\u0000\u0000\u01e0\u01e2\u0003p8\u0000\u01e1\u01df"+
		"\u0001\u0000\u0000\u0000\u01e2\u01e5\u0001\u0000\u0000\u0000\u01e3\u01e1"+
		"\u0001\u0000\u0000\u0000\u01e3\u01e4\u0001\u0000\u0000\u0000\u01e4\u01e6"+
		"\u0001\u0000\u0000\u0000\u01e5\u01e3\u0001\u0000\u0000\u0000\u01e6\u01e7"+
		"\u00056\u0000\u0000\u01e7\u01e9\u0001\u0000\u0000\u0000\u01e8\u01dd\u0001"+
		"\u0000\u0000\u0000\u01e8\u01e9\u0001\u0000\u0000\u0000\u01e9o\u0001\u0000"+
		"\u0000\u0000\u01ea\u01eb\u00068\uffff\uffff\u0000\u01eb\u01ec\u00057\u0000"+
		"\u0000\u01ec\u01ed\u0003p8\u0000\u01ed\u01ee\u00058\u0000\u0000\u01ee"+
		"\u020d\u0001\u0000\u0000\u0000\u01ef\u01f0\u0005;\u0000\u0000\u01f0\u020d"+
		"\u0003p8\u000b\u01f1\u01f2\u0005D\u0000\u0000\u01f2\u020d\u0003p8\n\u01f3"+
		"\u020d\u0005<\u0000\u0000\u01f4\u020d\u0005=\u0000\u0000\u01f5\u020d\u0005"+
		">\u0000\u0000\u01f6\u020d\u0005?\u0000\u0000\u01f7\u01f8\u00055\u0000"+
		"\u0000\u01f8\u01fd\u0003p8\u0000\u01f9\u01fa\u0005\f\u0000\u0000\u01fa"+
		"\u01fc\u0003p8\u0000\u01fb\u01f9\u0001\u0000\u0000\u0000\u01fc\u01ff\u0001"+
		"\u0000\u0000\u0000\u01fd\u01fb\u0001\u0000\u0000\u0000\u01fd\u01fe\u0001"+
		"\u0000\u0000\u0000\u01fe\u0200\u0001\u0000\u0000\u0000\u01ff\u01fd\u0001"+
		"\u0000\u0000\u0000\u0200\u0201\u00056\u0000\u0000\u0201\u020d\u0001\u0000"+
		"\u0000\u0000\u0202\u0203\u00059\u0000\u0000\u0203\u0204\u00057\u0000\u0000"+
		"\u0204\u0205\u0003p8\u0000\u0205\u0206\u0005\f\u0000\u0000\u0206\u0207"+
		"\u0003p8\u0000\u0207\u0208\u00058\u0000\u0000\u0208\u020d\u0001\u0000"+
		"\u0000\u0000\u0209\u020d\u0003t:\u0000\u020a\u020d\u0003r9\u0000\u020b"+
		"\u020d\u0003n7\u0000\u020c\u01ea\u0001\u0000\u0000\u0000\u020c\u01ef\u0001"+
		"\u0000\u0000\u0000\u020c\u01f1\u0001\u0000\u0000\u0000\u020c\u01f3\u0001"+
		"\u0000\u0000\u0000\u020c\u01f4\u0001\u0000\u0000\u0000\u020c\u01f5\u0001"+
		"\u0000\u0000\u0000\u020c\u01f6\u0001\u0000\u0000\u0000\u020c\u01f7\u0001"+
		"\u0000\u0000\u0000\u020c\u0202\u0001\u0000\u0000\u0000\u020c\u0209\u0001"+
		"\u0000\u0000\u0000\u020c\u020a\u0001\u0000\u0000\u0000\u020c\u020b\u0001"+
		"\u0000\u0000\u0000\u020d\u021f\u0001\u0000\u0000\u0000\u020e\u020f\n\u0010"+
		"\u0000\u0000\u020f\u0210\u0005E\u0000\u0000\u0210\u021e\u0003p8\u0011"+
		"\u0211\u0212\n\u000f\u0000\u0000\u0212\u0213\u0007\u0001\u0000\u0000\u0213"+
		"\u021e\u0003p8\u0010\u0214\u0215\n\u000e\u0000\u0000\u0215\u0216\u0007"+
		"\u0002\u0000\u0000\u0216\u021e\u0003p8\u000f\u0217\u0218\n\r\u0000\u0000"+
		"\u0218\u0219\u0007\u0003\u0000\u0000\u0219\u021e\u0003p8\u000e\u021a\u021b"+
		"\n\f\u0000\u0000\u021b\u021c\u0007\u0004\u0000\u0000\u021c\u021e\u0003"+
		"p8\r\u021d\u020e\u0001\u0000\u0000\u0000\u021d\u0211\u0001\u0000\u0000"+
		"\u0000\u021d\u0214\u0001\u0000\u0000\u0000\u021d\u0217\u0001\u0000\u0000"+
		"\u0000\u021d\u021a\u0001\u0000\u0000\u0000\u021e\u0221\u0001\u0000\u0000"+
		"\u0000\u021f\u021d\u0001\u0000\u0000\u0000\u021f\u0220\u0001\u0000\u0000"+
		"\u0000\u0220q\u0001\u0000\u0000\u0000\u0221\u021f\u0001\u0000\u0000\u0000"+
		"\u0222\u0223\u0005:\u0000\u0000\u0223\u0225\u00057\u0000\u0000\u0224\u0226"+
		"\u0003p8\u0000\u0225\u0224\u0001\u0000\u0000\u0000\u0225\u0226\u0001\u0000"+
		"\u0000\u0000\u0226\u0227\u0001\u0000\u0000\u0000\u0227\u0228\u00058\u0000"+
		"\u0000\u0228s\u0001\u0000\u0000\u0000\u0229\u022a\u0007\u0005\u0000\u0000"+
		"\u022a\u0233\u00057\u0000\u0000\u022b\u0230\u0003p8\u0000\u022c\u022d"+
		"\u0005\f\u0000\u0000\u022d\u022f\u0003p8\u0000\u022e\u022c\u0001\u0000"+
		"\u0000\u0000\u022f\u0232\u0001\u0000\u0000\u0000\u0230\u022e\u0001\u0000"+
		"\u0000\u0000\u0230\u0231\u0001\u0000\u0000\u0000\u0231\u0234\u0001\u0000"+
		"\u0000\u0000\u0232\u0230\u0001\u0000\u0000\u0000\u0233\u022b\u0001\u0000"+
		"\u0000\u0000\u0233\u0234\u0001\u0000\u0000\u0000\u0234\u0235\u0001\u0000"+
		"\u0000\u0000\u0235\u0236\u00058\u0000\u0000\u0236u\u0001\u0000\u0000\u0000"+
		"\u001dz\u007f\u0085\u0090\u00c1\u00cb\u00d9\u00dd\u00e1\u00e8\u00ef\u00f9"+
		"\u0100\u0114\u014c\u01c4\u01c9\u01d1\u01d6\u01da\u01e3\u01e8\u01fd\u020c"+
		"\u021d\u021f\u0225\u0230\u0233";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}