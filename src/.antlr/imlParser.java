// Generated from /home/duarte/Documentos/UA/2ºAno/2ºSemestre/C/P/proj/comp2425-iml-a4/src/iml.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class imlParser extends Parser {
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
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, PERCENTAGE=68, NUMBER=69, STRING=70, ID=71, COMMENT=72, WS=73;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_variableDeclaration = 2, RULE_assignment = 3, 
		RULE_ifStatement = 4, RULE_forStatement = 5, RULE_untilStatement = 6, 
		RULE_outputStatement = 7, RULE_drawStatement = 8, RULE_storeStatement = 9, 
		RULE_appendStatement = 10, RULE_imageStatement = 11, RULE_placeStatement = 12, 
		RULE_shape = 13, RULE_expression = 14, RULE_primary = 15, RULE_list = 16, 
		RULE_type = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "variableDeclaration", "assignment", "ifStatement", 
			"forStatement", "untilStatement", "outputStatement", "drawStatement", 
			"storeStatement", "appendStatement", "imageStatement", "placeStatement", 
			"shape", "expression", "primary", "list", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'is'", "'if'", "'then'", "'else'", "'done'", "'for'", "'within'", 
			"'do'", "'until'", "'output'", "'draw'", "'store'", "'into'", "'append'", 
			"'image'", "'size'", "'by'", "'background'", "'place'", "'radius'", "'at'", 
			"'with'", "'intensity'", "'circle'", "'rect'", "'cross'", "'plus'", "'open'", 
			"'close'", "'dilate'", "'erode'", "'top'", "'hat'", "'black'", "'load'", 
			"'from'", "'run'", "'read'", "'count'", "'pixel'", "'in'", "'any'", "'>'", 
			"'.>'", "'columns'", "'of'", "'rows'", "'string'", "'('", "')'", "'number'", 
			"'*'", "'/'", "'+'", "'-'", "'.*'", "'.+'", "'.-'", "'-*'", "'|*'", "'!='", 
			"'=='", "'['", "','", "']'", "'percentage'", "'list'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "PERCENTAGE", "NUMBER", 
			"STRING", "ID", "COMMENT", "WS"
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
	public String getGrammarFileName() { return "iml.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public imlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(imlParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9220094495771029948L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 127L) != 0)) {
				{
				{
				setState(36);
				statement();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
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
	public static class StatementContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public UntilStatementContext untilStatement() {
			return getRuleContext(UntilStatementContext.class,0);
		}
		public OutputStatementContext outputStatement() {
			return getRuleContext(OutputStatementContext.class,0);
		}
		public DrawStatementContext drawStatement() {
			return getRuleContext(DrawStatementContext.class,0);
		}
		public StoreStatementContext storeStatement() {
			return getRuleContext(StoreStatementContext.class,0);
		}
		public AppendStatementContext appendStatement() {
			return getRuleContext(AppendStatementContext.class,0);
		}
		public ImageStatementContext imageStatement() {
			return getRuleContext(ImageStatementContext.class,0);
		}
		public PlaceStatementContext placeStatement() {
			return getRuleContext(PlaceStatementContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(imlParser.COMMENT, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				forStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(48);
				untilStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(49);
				outputStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(50);
				drawStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(51);
				storeStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(52);
				appendStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(53);
				imageStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(54);
				placeStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(55);
				match(COMMENT);
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
	public static class VariableDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(imlParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			type();
			setState(59);
			match(ID);
			setState(60);
			match(T__0);
			setState(61);
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
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(imlParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(ID);
			setState(64);
			match(T__0);
			setState(65);
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__1);
			setState(68);
			expression(0);
			setState(69);
			match(T__2);
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70);
				statement();
				}
				}
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -9220094495771029948L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 127L) != 0) );
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(75);
				match(T__3);
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(76);
					statement();
					}
					}
					setState(79); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -9220094495771029948L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 127L) != 0) );
				}
			}

			setState(83);
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
	public static class ForStatementContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(imlParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__5);
			setState(86);
			type();
			setState(87);
			match(ID);
			setState(88);
			match(T__6);
			setState(89);
			expression(0);
			setState(90);
			match(T__7);
			setState(92); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(91);
				statement();
				}
				}
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -9220094495771029948L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 127L) != 0) );
			setState(96);
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
	public static class UntilStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public UntilStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_untilStatement; }
	}

	public final UntilStatementContext untilStatement() throws RecognitionException {
		UntilStatementContext _localctx = new UntilStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_untilStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__8);
			setState(99);
			expression(0);
			setState(100);
			match(T__7);
			setState(102); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(101);
				statement();
				}
				}
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -9220094495771029948L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 127L) != 0) );
			setState(106);
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
	public static class OutputStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OutputStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputStatement; }
	}

	public final OutputStatementContext outputStatement() throws RecognitionException {
		OutputStatementContext _localctx = new OutputStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_outputStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__9);
			setState(109);
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
	public static class DrawStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DrawStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawStatement; }
	}

	public final DrawStatementContext drawStatement() throws RecognitionException {
		DrawStatementContext _localctx = new DrawStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_drawStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__10);
			setState(112);
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
	public static class StoreStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode STRING() { return getToken(imlParser.STRING, 0); }
		public StoreStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storeStatement; }
	}

	public final StoreStatementContext storeStatement() throws RecognitionException {
		StoreStatementContext _localctx = new StoreStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_storeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			expression(0);
			setState(115);
			match(T__11);
			setState(116);
			match(T__12);
			setState(117);
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
	public static class AppendStatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(imlParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AppendStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_appendStatement; }
	}

	public final AppendStatementContext appendStatement() throws RecognitionException {
		AppendStatementContext _localctx = new AppendStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_appendStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(ID);
			setState(120);
			match(T__13);
			setState(121);
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
	public static class ImageStatementContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ImageStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imageStatement; }
	}

	public final ImageStatementContext imageStatement() throws RecognitionException {
		ImageStatementContext _localctx = new ImageStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_imageStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__14);
			setState(124);
			match(T__15);
			setState(125);
			expression(0);
			setState(126);
			match(T__16);
			setState(127);
			expression(0);
			setState(128);
			match(T__17);
			setState(129);
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
	public static class PlaceStatementContext extends ParserRuleContext {
		public ShapeContext shape() {
			return getRuleContext(ShapeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PlaceStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_placeStatement; }
	}

	public final PlaceStatementContext placeStatement() throws RecognitionException {
		PlaceStatementContext _localctx = new PlaceStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_placeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(T__18);
			setState(132);
			shape();
			setState(133);
			match(T__19);
			setState(134);
			expression(0);
			setState(135);
			match(T__20);
			setState(136);
			expression(0);
			setState(137);
			expression(0);
			setState(138);
			match(T__21);
			setState(139);
			match(T__22);
			setState(140);
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
	public static class ShapeContext extends ParserRuleContext {
		public ShapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape; }
	}

	public final ShapeContext shape() throws RecognitionException {
		ShapeContext _localctx = new ShapeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_shape);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 251658240L) != 0)) ) {
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
	public static class LoadExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoadExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringConversionExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StringConversionExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadExprContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(imlParser.STRING, 0); }
		public ReadExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ComparisonExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CountPixelExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CountPixelExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AnyPixelExprContext extends ExpressionContext {
		public Token operator;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(imlParser.NUMBER, 0); }
		public AnyPixelExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RowsExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RowsExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ColumnsExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ColumnsExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImageArithmeticExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ImageArithmeticExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExprContext extends ExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ErodeExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ErodeExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OpenExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OpenExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CloseExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CloseExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TopHatExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TopHatExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArithmeticExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RunExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RunExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlackHatExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BlackHatExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberConversionExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NumberConversionExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DilateExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DilateExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__62:
			case PERCENTAGE:
			case NUMBER:
			case STRING:
			case ID:
				{
				_localctx = new PrimaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(145);
				primary();
				}
				break;
			case T__34:
				{
				_localctx = new LoadExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				match(T__34);
				setState(147);
				match(T__35);
				setState(148);
				expression(15);
				}
				break;
			case T__36:
				{
				_localctx = new RunExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				match(T__36);
				setState(150);
				match(T__35);
				setState(151);
				expression(14);
				}
				break;
			case T__37:
				{
				_localctx = new ReadExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152);
				match(T__37);
				setState(153);
				match(STRING);
				}
				break;
			case T__38:
				{
				_localctx = new CountPixelExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154);
				match(T__38);
				setState(155);
				match(T__39);
				setState(156);
				expression(0);
				setState(157);
				match(T__40);
				setState(158);
				expression(12);
				}
				break;
			case T__41:
				{
				_localctx = new AnyPixelExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160);
				match(T__41);
				setState(161);
				match(T__39);
				setState(162);
				expression(0);
				setState(163);
				((AnyPixelExprContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__42 || _la==T__43) ) {
					((AnyPixelExprContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(164);
				match(NUMBER);
				}
				break;
			case T__44:
				{
				_localctx = new ColumnsExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				match(T__44);
				setState(167);
				match(T__45);
				setState(168);
				expression(10);
				}
				break;
			case T__46:
				{
				_localctx = new RowsExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(T__46);
				setState(170);
				match(T__45);
				setState(171);
				expression(9);
				}
				break;
			case T__47:
				{
				_localctx = new StringConversionExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				match(T__47);
				setState(173);
				match(T__48);
				setState(174);
				expression(0);
				setState(175);
				match(T__49);
				}
				break;
			case T__50:
				{
				_localctx = new NumberConversionExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
				match(T__50);
				setState(178);
				match(T__48);
				setState(179);
				expression(0);
				setState(180);
				match(T__49);
				}
				break;
			case T__48:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				match(T__48);
				setState(183);
				expression(0);
				setState(184);
				match(T__49);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(229);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new OpenExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(188);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(189);
						match(T__27);
						setState(190);
						match(T__16);
						setState(191);
						expression(22);
						}
						break;
					case 2:
						{
						_localctx = new CloseExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(192);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(193);
						match(T__28);
						setState(194);
						match(T__16);
						setState(195);
						expression(21);
						}
						break;
					case 3:
						{
						_localctx = new DilateExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(196);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(197);
						match(T__29);
						setState(198);
						match(T__16);
						setState(199);
						expression(20);
						}
						break;
					case 4:
						{
						_localctx = new ErodeExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(200);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(201);
						match(T__30);
						setState(202);
						match(T__16);
						setState(203);
						expression(19);
						}
						break;
					case 5:
						{
						_localctx = new TopHatExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(204);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(205);
						match(T__31);
						setState(206);
						match(T__32);
						setState(207);
						match(T__16);
						setState(208);
						expression(18);
						}
						break;
					case 6:
						{
						_localctx = new BlackHatExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(209);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(210);
						match(T__33);
						setState(211);
						match(T__32);
						setState(212);
						match(T__16);
						setState(213);
						expression(17);
						}
						break;
					case 7:
						{
						_localctx = new ArithmeticExprContext(new ExpressionContext(_parentctx, _parentState));
						((ArithmeticExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(214);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(215);
						((ArithmeticExprContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__51 || _la==T__52) ) {
							((ArithmeticExprContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(216);
						((ArithmeticExprContext)_localctx).right = expression(6);
						}
						break;
					case 8:
						{
						_localctx = new ArithmeticExprContext(new ExpressionContext(_parentctx, _parentState));
						((ArithmeticExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(217);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(218);
						((ArithmeticExprContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__53 || _la==T__54) ) {
							((ArithmeticExprContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(219);
						((ArithmeticExprContext)_localctx).right = expression(5);
						}
						break;
					case 9:
						{
						_localctx = new ImageArithmeticExprContext(new ExpressionContext(_parentctx, _parentState));
						((ImageArithmeticExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(220);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(221);
						((ImageArithmeticExprContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__55 || _la==T__56) ) {
							((ImageArithmeticExprContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(222);
						((ImageArithmeticExprContext)_localctx).right = expression(4);
						}
						break;
					case 10:
						{
						_localctx = new ImageArithmeticExprContext(new ExpressionContext(_parentctx, _parentState));
						((ImageArithmeticExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(223);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(224);
						((ImageArithmeticExprContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2017612633061982208L) != 0)) ) {
							((ImageArithmeticExprContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(225);
						((ImageArithmeticExprContext)_localctx).right = expression(3);
						}
						break;
					case 11:
						{
						_localctx = new ComparisonExprContext(new ExpressionContext(_parentctx, _parentState));
						((ComparisonExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(226);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(227);
						((ComparisonExprContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__60 || _la==T__61) ) {
							((ComparisonExprContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(228);
						((ComparisonExprContext)_localctx).right = expression(2);
						}
						break;
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(imlParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(imlParser.NUMBER, 0); }
		public TerminalNode PERCENTAGE() { return getToken(imlParser.PERCENTAGE, 0); }
		public TerminalNode STRING() { return getToken(imlParser.STRING, 0); }
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_primary);
		try {
			setState(239);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				match(ID);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				match(NUMBER);
				}
				break;
			case PERCENTAGE:
				enterOuterAlt(_localctx, 3);
				{
				setState(236);
				match(PERCENTAGE);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(237);
				match(STRING);
				}
				break;
			case T__62:
				enterOuterAlt(_localctx, 5);
				{
				setState(238);
				list();
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
	public static class ListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(T__62);
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & 129117549725L) != 0)) {
				{
				setState(242);
				expression(0);
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__63) {
					{
					{
					setState(243);
					match(T__63);
					setState(244);
					expression(0);
					}
					}
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(252);
			match(T__64);
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
	public static class TypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_type);
		try {
			setState(261);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				match(T__14);
				}
				break;
			case T__50:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				match(T__50);
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				match(T__47);
				}
				break;
			case T__65:
				enterOuterAlt(_localctx, 4);
				{
				setState(257);
				match(T__65);
				}
				break;
			case T__66:
				enterOuterAlt(_localctx, 5);
				{
				setState(258);
				match(T__66);
				setState(259);
				match(T__45);
				setState(260);
				type();
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
		case 14:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 21);
		case 1:
			return precpred(_ctx, 20);
		case 2:
			return precpred(_ctx, 19);
		case 3:
			return precpred(_ctx, 18);
		case 4:
			return precpred(_ctx, 17);
		case 5:
			return precpred(_ctx, 16);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001I\u0108\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0005\u0000"+
		"&\b\u0000\n\u0000\f\u0000)\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"9\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0004\u0004H\b\u0004\u000b\u0004\f\u0004I\u0001"+
		"\u0004\u0001\u0004\u0004\u0004N\b\u0004\u000b\u0004\f\u0004O\u0003\u0004"+
		"R\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005]\b\u0005"+
		"\u000b\u0005\f\u0005^\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0004\u0006g\b\u0006\u000b\u0006\f\u0006h\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u00bb\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u00e6\b\u000e\n\u000e\f\u000e\u00e9\t\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00f0\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00f6\b\u0010"+
		"\n\u0010\f\u0010\u00f9\t\u0010\u0003\u0010\u00fb\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u0106\b\u0011\u0001\u0011\u0000\u0001\u001c"+
		"\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"\u0000\u0007\u0001\u0000\u0018\u001b\u0001\u0000"+
		"+,\u0001\u000045\u0001\u000067\u0001\u000089\u0001\u0000:<\u0001\u0000"+
		"=>\u0125\u0000\'\u0001\u0000\u0000\u0000\u00028\u0001\u0000\u0000\u0000"+
		"\u0004:\u0001\u0000\u0000\u0000\u0006?\u0001\u0000\u0000\u0000\bC\u0001"+
		"\u0000\u0000\u0000\nU\u0001\u0000\u0000\u0000\fb\u0001\u0000\u0000\u0000"+
		"\u000el\u0001\u0000\u0000\u0000\u0010o\u0001\u0000\u0000\u0000\u0012r"+
		"\u0001\u0000\u0000\u0000\u0014w\u0001\u0000\u0000\u0000\u0016{\u0001\u0000"+
		"\u0000\u0000\u0018\u0083\u0001\u0000\u0000\u0000\u001a\u008e\u0001\u0000"+
		"\u0000\u0000\u001c\u00ba\u0001\u0000\u0000\u0000\u001e\u00ef\u0001\u0000"+
		"\u0000\u0000 \u00f1\u0001\u0000\u0000\u0000\"\u0105\u0001\u0000\u0000"+
		"\u0000$&\u0003\u0002\u0001\u0000%$\u0001\u0000\u0000\u0000&)\u0001\u0000"+
		"\u0000\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(*\u0001"+
		"\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000*+\u0005\u0000\u0000\u0001"+
		"+\u0001\u0001\u0000\u0000\u0000,9\u0003\u0004\u0002\u0000-9\u0003\u0006"+
		"\u0003\u0000.9\u0003\b\u0004\u0000/9\u0003\n\u0005\u000009\u0003\f\u0006"+
		"\u000019\u0003\u000e\u0007\u000029\u0003\u0010\b\u000039\u0003\u0012\t"+
		"\u000049\u0003\u0014\n\u000059\u0003\u0016\u000b\u000069\u0003\u0018\f"+
		"\u000079\u0005H\u0000\u00008,\u0001\u0000\u0000\u00008-\u0001\u0000\u0000"+
		"\u00008.\u0001\u0000\u0000\u00008/\u0001\u0000\u0000\u000080\u0001\u0000"+
		"\u0000\u000081\u0001\u0000\u0000\u000082\u0001\u0000\u0000\u000083\u0001"+
		"\u0000\u0000\u000084\u0001\u0000\u0000\u000085\u0001\u0000\u0000\u0000"+
		"86\u0001\u0000\u0000\u000087\u0001\u0000\u0000\u00009\u0003\u0001\u0000"+
		"\u0000\u0000:;\u0003\"\u0011\u0000;<\u0005G\u0000\u0000<=\u0005\u0001"+
		"\u0000\u0000=>\u0003\u001c\u000e\u0000>\u0005\u0001\u0000\u0000\u0000"+
		"?@\u0005G\u0000\u0000@A\u0005\u0001\u0000\u0000AB\u0003\u001c\u000e\u0000"+
		"B\u0007\u0001\u0000\u0000\u0000CD\u0005\u0002\u0000\u0000DE\u0003\u001c"+
		"\u000e\u0000EG\u0005\u0003\u0000\u0000FH\u0003\u0002\u0001\u0000GF\u0001"+
		"\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000"+
		"IJ\u0001\u0000\u0000\u0000JQ\u0001\u0000\u0000\u0000KM\u0005\u0004\u0000"+
		"\u0000LN\u0003\u0002\u0001\u0000ML\u0001\u0000\u0000\u0000NO\u0001\u0000"+
		"\u0000\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PR\u0001"+
		"\u0000\u0000\u0000QK\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000"+
		"RS\u0001\u0000\u0000\u0000ST\u0005\u0005\u0000\u0000T\t\u0001\u0000\u0000"+
		"\u0000UV\u0005\u0006\u0000\u0000VW\u0003\"\u0011\u0000WX\u0005G\u0000"+
		"\u0000XY\u0005\u0007\u0000\u0000YZ\u0003\u001c\u000e\u0000Z\\\u0005\b"+
		"\u0000\u0000[]\u0003\u0002\u0001\u0000\\[\u0001\u0000\u0000\u0000]^\u0001"+
		"\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000"+
		"_`\u0001\u0000\u0000\u0000`a\u0005\u0005\u0000\u0000a\u000b\u0001\u0000"+
		"\u0000\u0000bc\u0005\t\u0000\u0000cd\u0003\u001c\u000e\u0000df\u0005\b"+
		"\u0000\u0000eg\u0003\u0002\u0001\u0000fe\u0001\u0000\u0000\u0000gh\u0001"+
		"\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000"+
		"ij\u0001\u0000\u0000\u0000jk\u0005\u0005\u0000\u0000k\r\u0001\u0000\u0000"+
		"\u0000lm\u0005\n\u0000\u0000mn\u0003\u001c\u000e\u0000n\u000f\u0001\u0000"+
		"\u0000\u0000op\u0005\u000b\u0000\u0000pq\u0003\u001c\u000e\u0000q\u0011"+
		"\u0001\u0000\u0000\u0000rs\u0003\u001c\u000e\u0000st\u0005\f\u0000\u0000"+
		"tu\u0005\r\u0000\u0000uv\u0005F\u0000\u0000v\u0013\u0001\u0000\u0000\u0000"+
		"wx\u0005G\u0000\u0000xy\u0005\u000e\u0000\u0000yz\u0003\u001c\u000e\u0000"+
		"z\u0015\u0001\u0000\u0000\u0000{|\u0005\u000f\u0000\u0000|}\u0005\u0010"+
		"\u0000\u0000}~\u0003\u001c\u000e\u0000~\u007f\u0005\u0011\u0000\u0000"+
		"\u007f\u0080\u0003\u001c\u000e\u0000\u0080\u0081\u0005\u0012\u0000\u0000"+
		"\u0081\u0082\u0003\u001c\u000e\u0000\u0082\u0017\u0001\u0000\u0000\u0000"+
		"\u0083\u0084\u0005\u0013\u0000\u0000\u0084\u0085\u0003\u001a\r\u0000\u0085"+
		"\u0086\u0005\u0014\u0000\u0000\u0086\u0087\u0003\u001c\u000e\u0000\u0087"+
		"\u0088\u0005\u0015\u0000\u0000\u0088\u0089\u0003\u001c\u000e\u0000\u0089"+
		"\u008a\u0003\u001c\u000e\u0000\u008a\u008b\u0005\u0016\u0000\u0000\u008b"+
		"\u008c\u0005\u0017\u0000\u0000\u008c\u008d\u0003\u001c\u000e\u0000\u008d"+
		"\u0019\u0001\u0000\u0000\u0000\u008e\u008f\u0007\u0000\u0000\u0000\u008f"+
		"\u001b\u0001\u0000\u0000\u0000\u0090\u0091\u0006\u000e\uffff\uffff\u0000"+
		"\u0091\u00bb\u0003\u001e\u000f\u0000\u0092\u0093\u0005#\u0000\u0000\u0093"+
		"\u0094\u0005$\u0000\u0000\u0094\u00bb\u0003\u001c\u000e\u000f\u0095\u0096"+
		"\u0005%\u0000\u0000\u0096\u0097\u0005$\u0000\u0000\u0097\u00bb\u0003\u001c"+
		"\u000e\u000e\u0098\u0099\u0005&\u0000\u0000\u0099\u00bb\u0005F\u0000\u0000"+
		"\u009a\u009b\u0005\'\u0000\u0000\u009b\u009c\u0005(\u0000\u0000\u009c"+
		"\u009d\u0003\u001c\u000e\u0000\u009d\u009e\u0005)\u0000\u0000\u009e\u009f"+
		"\u0003\u001c\u000e\f\u009f\u00bb\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005"+
		"*\u0000\u0000\u00a1\u00a2\u0005(\u0000\u0000\u00a2\u00a3\u0003\u001c\u000e"+
		"\u0000\u00a3\u00a4\u0007\u0001\u0000\u0000\u00a4\u00a5\u0005E\u0000\u0000"+
		"\u00a5\u00bb\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005-\u0000\u0000\u00a7"+
		"\u00a8\u0005.\u0000\u0000\u00a8\u00bb\u0003\u001c\u000e\n\u00a9\u00aa"+
		"\u0005/\u0000\u0000\u00aa\u00ab\u0005.\u0000\u0000\u00ab\u00bb\u0003\u001c"+
		"\u000e\t\u00ac\u00ad\u00050\u0000\u0000\u00ad\u00ae\u00051\u0000\u0000"+
		"\u00ae\u00af\u0003\u001c\u000e\u0000\u00af\u00b0\u00052\u0000\u0000\u00b0"+
		"\u00bb\u0001\u0000\u0000\u0000\u00b1\u00b2\u00053\u0000\u0000\u00b2\u00b3"+
		"\u00051\u0000\u0000\u00b3\u00b4\u0003\u001c\u000e\u0000\u00b4\u00b5\u0005"+
		"2\u0000\u0000\u00b5\u00bb\u0001\u0000\u0000\u0000\u00b6\u00b7\u00051\u0000"+
		"\u0000\u00b7\u00b8\u0003\u001c\u000e\u0000\u00b8\u00b9\u00052\u0000\u0000"+
		"\u00b9\u00bb\u0001\u0000\u0000\u0000\u00ba\u0090\u0001\u0000\u0000\u0000"+
		"\u00ba\u0092\u0001\u0000\u0000\u0000\u00ba\u0095\u0001\u0000\u0000\u0000"+
		"\u00ba\u0098\u0001\u0000\u0000\u0000\u00ba\u009a\u0001\u0000\u0000\u0000"+
		"\u00ba\u00a0\u0001\u0000\u0000\u0000\u00ba\u00a6\u0001\u0000\u0000\u0000"+
		"\u00ba\u00a9\u0001\u0000\u0000\u0000\u00ba\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ba\u00b1\u0001\u0000\u0000\u0000\u00ba\u00b6\u0001\u0000\u0000\u0000"+
		"\u00bb\u00e7\u0001\u0000\u0000\u0000\u00bc\u00bd\n\u0015\u0000\u0000\u00bd"+
		"\u00be\u0005\u001c\u0000\u0000\u00be\u00bf\u0005\u0011\u0000\u0000\u00bf"+
		"\u00e6\u0003\u001c\u000e\u0016\u00c0\u00c1\n\u0014\u0000\u0000\u00c1\u00c2"+
		"\u0005\u001d\u0000\u0000\u00c2\u00c3\u0005\u0011\u0000\u0000\u00c3\u00e6"+
		"\u0003\u001c\u000e\u0015\u00c4\u00c5\n\u0013\u0000\u0000\u00c5\u00c6\u0005"+
		"\u001e\u0000\u0000\u00c6\u00c7\u0005\u0011\u0000\u0000\u00c7\u00e6\u0003"+
		"\u001c\u000e\u0014\u00c8\u00c9\n\u0012\u0000\u0000\u00c9\u00ca\u0005\u001f"+
		"\u0000\u0000\u00ca\u00cb\u0005\u0011\u0000\u0000\u00cb\u00e6\u0003\u001c"+
		"\u000e\u0013\u00cc\u00cd\n\u0011\u0000\u0000\u00cd\u00ce\u0005 \u0000"+
		"\u0000\u00ce\u00cf\u0005!\u0000\u0000\u00cf\u00d0\u0005\u0011\u0000\u0000"+
		"\u00d0\u00e6\u0003\u001c\u000e\u0012\u00d1\u00d2\n\u0010\u0000\u0000\u00d2"+
		"\u00d3\u0005\"\u0000\u0000\u00d3\u00d4\u0005!\u0000\u0000\u00d4\u00d5"+
		"\u0005\u0011\u0000\u0000\u00d5\u00e6\u0003\u001c\u000e\u0011\u00d6\u00d7"+
		"\n\u0005\u0000\u0000\u00d7\u00d8\u0007\u0002\u0000\u0000\u00d8\u00e6\u0003"+
		"\u001c\u000e\u0006\u00d9\u00da\n\u0004\u0000\u0000\u00da\u00db\u0007\u0003"+
		"\u0000\u0000\u00db\u00e6\u0003\u001c\u000e\u0005\u00dc\u00dd\n\u0003\u0000"+
		"\u0000\u00dd\u00de\u0007\u0004\u0000\u0000\u00de\u00e6\u0003\u001c\u000e"+
		"\u0004\u00df\u00e0\n\u0002\u0000\u0000\u00e0\u00e1\u0007\u0005\u0000\u0000"+
		"\u00e1\u00e6\u0003\u001c\u000e\u0003\u00e2\u00e3\n\u0001\u0000\u0000\u00e3"+
		"\u00e4\u0007\u0006\u0000\u0000\u00e4\u00e6\u0003\u001c\u000e\u0002\u00e5"+
		"\u00bc\u0001\u0000\u0000\u0000\u00e5\u00c0\u0001\u0000\u0000\u0000\u00e5"+
		"\u00c4\u0001\u0000\u0000\u0000\u00e5\u00c8\u0001\u0000\u0000\u0000\u00e5"+
		"\u00cc\u0001\u0000\u0000\u0000\u00e5\u00d1\u0001\u0000\u0000\u0000\u00e5"+
		"\u00d6\u0001\u0000\u0000\u0000\u00e5\u00d9\u0001\u0000\u0000\u0000\u00e5"+
		"\u00dc\u0001\u0000\u0000\u0000\u00e5\u00df\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e6\u00e9\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e5\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8"+
		"\u001d\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00ea"+
		"\u00f0\u0005G\u0000\u0000\u00eb\u00f0\u0005E\u0000\u0000\u00ec\u00f0\u0005"+
		"D\u0000\u0000\u00ed\u00f0\u0005F\u0000\u0000\u00ee\u00f0\u0003 \u0010"+
		"\u0000\u00ef\u00ea\u0001\u0000\u0000\u0000\u00ef\u00eb\u0001\u0000\u0000"+
		"\u0000\u00ef\u00ec\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000"+
		"\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000\u00f0\u001f\u0001\u0000\u0000"+
		"\u0000\u00f1\u00fa\u0005?\u0000\u0000\u00f2\u00f7\u0003\u001c\u000e\u0000"+
		"\u00f3\u00f4\u0005@\u0000\u0000\u00f4\u00f6\u0003\u001c\u000e\u0000\u00f5"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f6\u00f9\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8"+
		"\u00fb\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00fa"+
		"\u00f2\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb"+
		"\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005A\u0000\u0000\u00fd!\u0001"+
		"\u0000\u0000\u0000\u00fe\u0106\u0005\u000f\u0000\u0000\u00ff\u0106\u0005"+
		"3\u0000\u0000\u0100\u0106\u00050\u0000\u0000\u0101\u0106\u0005B\u0000"+
		"\u0000\u0102\u0103\u0005C\u0000\u0000\u0103\u0104\u0005.\u0000\u0000\u0104"+
		"\u0106\u0003\"\u0011\u0000\u0105\u00fe\u0001\u0000\u0000\u0000\u0105\u00ff"+
		"\u0001\u0000\u0000\u0000\u0105\u0100\u0001\u0000\u0000\u0000\u0105\u0101"+
		"\u0001\u0000\u0000\u0000\u0105\u0102\u0001\u0000\u0000\u0000\u0106#\u0001"+
		"\u0000\u0000\u0000\u000e\'8IOQ^h\u00ba\u00e5\u00e7\u00ef\u00f7\u00fa\u0105";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}