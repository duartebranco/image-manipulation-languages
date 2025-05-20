// Generated from iml.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class imlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

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
		T__52=53, T__53=54, T__54=55, T__55=56, PERCENTAGE=57, NUMBER=58, STRING=59, 
		ID=60, COMMENT=61, WS=62;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_variableDeclaration = 2, RULE_assignment = 3, 
		RULE_ifStatement = 4, RULE_forStatement = 5, RULE_untilStatement = 6, 
		RULE_outputStatement = 7, RULE_drawStatement = 8, RULE_storeStatement = 9, 
		RULE_appendStatement = 10, RULE_expression = 11, RULE_primary = 12, RULE_list = 13, 
		RULE_type = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "variableDeclaration", "assignment", "ifStatement", 
			"forStatement", "untilStatement", "outputStatement", "drawStatement", 
			"storeStatement", "appendStatement", "expression", "primary", "list", 
			"type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'is'", "'if'", "'then'", "'else'", "'done'", "'for'", "'within'", 
			"'do'", "'until'", "'output'", "'draw'", "'store'", "'into'", "'append'", 
			"'open'", "'by'", "'close'", "'dilate'", "'erode'", "'top'", "'hat'", 
			"'black'", "'load'", "'from'", "'run'", "'read'", "'count'", "'pixel'", 
			"'in'", "'any'", "'>'", "'.>'", "'columns'", "'of'", "'rows'", "'string'", 
			"'('", "')'", "'-'", "'/'", "'+'", "'|*'", "'-*'", "'+*'", "'.*'", "'.+'", 
			"'.-'", "'!='", "'=='", "'['", "','", "']'", "'image'", "'number'", "'percentage'", 
			"'list'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "PERCENTAGE", "NUMBER", 
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4603804969504607812L) != 0)) {
				{
				{
				setState(30);
				statement();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
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
		public TerminalNode COMMENT() { return getToken(imlParser.COMMENT, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				forStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(42);
				untilStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(43);
				outputStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(44);
				drawStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(45);
				storeStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(46);
				appendStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(47);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			type();
			setState(51);
			match(ID);
			setState(52);
			match(T__0);
			setState(53);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(ID);
			setState(56);
			match(T__0);
			setState(57);
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
		public StatementContext statement;
		public List<StatementContext> thenStmts = new ArrayList<StatementContext>();
		public List<StatementContext> elseStmts = new ArrayList<StatementContext>();
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__1);
			setState(60);
			expression(0);
			setState(61);
			match(T__2);
			setState(63); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(62);
				((IfStatementContext)_localctx).statement = statement();
				((IfStatementContext)_localctx).thenStmts.add(((IfStatementContext)_localctx).statement);
				}
				}
				setState(65); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4603804969504607812L) != 0) );
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(67);
				match(T__3);
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(68);
					((IfStatementContext)_localctx).statement = statement();
					((IfStatementContext)_localctx).elseStmts.add(((IfStatementContext)_localctx).statement);
					}
					}
					setState(71); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4603804969504607812L) != 0) );
				}
			}

			setState(75);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__5);
			setState(78);
			type();
			setState(79);
			match(ID);
			setState(80);
			match(T__6);
			setState(81);
			expression(0);
			setState(82);
			match(T__7);
			setState(84); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(83);
				statement();
				}
				}
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4603804969504607812L) != 0) );
			setState(88);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterUntilStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitUntilStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitUntilStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UntilStatementContext untilStatement() throws RecognitionException {
		UntilStatementContext _localctx = new UntilStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_untilStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__8);
			setState(91);
			expression(0);
			setState(92);
			match(T__7);
			setState(94); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(93);
				statement();
				}
				}
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4603804969504607812L) != 0) );
			setState(98);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterOutputStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitOutputStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitOutputStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputStatementContext outputStatement() throws RecognitionException {
		OutputStatementContext _localctx = new OutputStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_outputStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__9);
			setState(101);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterDrawStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitDrawStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitDrawStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DrawStatementContext drawStatement() throws RecognitionException {
		DrawStatementContext _localctx = new DrawStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_drawStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__10);
			setState(104);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterStoreStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitStoreStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitStoreStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StoreStatementContext storeStatement() throws RecognitionException {
		StoreStatementContext _localctx = new StoreStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_storeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			expression(0);
			setState(107);
			match(T__11);
			setState(108);
			match(T__12);
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
	public static class AppendStatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(imlParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AppendStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_appendStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterAppendStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitAppendStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitAppendStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AppendStatementContext appendStatement() throws RecognitionException {
		AppendStatementContext _localctx = new AppendStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_appendStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(ID);
			setState(112);
			match(T__13);
			setState(113);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterLoadExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitLoadExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitLoadExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringConversionExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StringConversionExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterStringConversionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitStringConversionExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitStringConversionExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PixelOperationExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PixelOperationExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterPixelOperationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitPixelOperationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitPixelOperationExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadExprContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(imlParser.STRING, 0); }
		public ReadExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterReadExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitReadExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitReadExpr(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterComparisonExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitComparisonExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitComparisonExpr(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterCountPixelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitCountPixelExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitCountPixelExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AnyPixelExprContext extends ExpressionContext {
		public Token operator;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(imlParser.NUMBER, 0); }
		public AnyPixelExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterAnyPixelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitAnyPixelExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitAnyPixelExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RowsExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RowsExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterRowsExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitRowsExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitRowsExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ColumnsExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ColumnsExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterColumnsExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitColumnsExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitColumnsExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlipExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FlipExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterFlipExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitFlipExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitFlipExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExprContext extends ExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterPrimaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitPrimaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitPrimaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ScaleExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ScaleExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterScaleExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitScaleExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitScaleExpr(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterErodeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitErodeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitErodeExpr(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterOpenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitOpenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitOpenExpr(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterCloseExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitCloseExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitCloseExpr(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterTopHatExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitTopHatExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitTopHatExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RunExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RunExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterRunExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitRunExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitRunExpr(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterBlackHatExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitBlackHatExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitBlackHatExpr(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterDilateExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitDilateExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitDilateExpr(this);
			else return visitor.visitChildren(this);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__49:
			case PERCENTAGE:
			case NUMBER:
			case STRING:
			case ID:
				{
				_localctx = new PrimaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(116);
				primary();
				}
				break;
			case T__22:
				{
				_localctx = new LoadExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				match(T__22);
				setState(118);
				match(T__23);
				setState(119);
				expression(13);
				}
				break;
			case T__24:
				{
				_localctx = new RunExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				match(T__24);
				setState(121);
				match(T__23);
				setState(122);
				expression(12);
				}
				break;
			case T__25:
				{
				_localctx = new ReadExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				match(T__25);
				setState(124);
				match(STRING);
				}
				break;
			case T__26:
				{
				_localctx = new CountPixelExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125);
				match(T__26);
				setState(126);
				match(T__27);
				setState(127);
				expression(0);
				setState(128);
				match(T__28);
				setState(129);
				expression(10);
				}
				break;
			case T__29:
				{
				_localctx = new AnyPixelExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				match(T__29);
				setState(132);
				match(T__27);
				setState(133);
				expression(0);
				setState(134);
				((AnyPixelExprContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__30 || _la==T__31) ) {
					((AnyPixelExprContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(135);
				match(NUMBER);
				}
				break;
			case T__32:
				{
				_localctx = new ColumnsExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				match(T__32);
				setState(138);
				match(T__33);
				setState(139);
				expression(8);
				}
				break;
			case T__34:
				{
				_localctx = new RowsExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(T__34);
				setState(141);
				match(T__33);
				setState(142);
				expression(7);
				}
				break;
			case T__35:
				{
				_localctx = new StringConversionExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				match(T__35);
				setState(144);
				match(T__36);
				setState(145);
				expression(0);
				setState(146);
				match(T__37);
				}
				break;
			case T__36:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				match(T__36);
				setState(149);
				expression(0);
				setState(150);
				match(T__37);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(194);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(192);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new OpenExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(154);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(155);
						match(T__14);
						setState(156);
						match(T__15);
						setState(157);
						expression(20);
						}
						break;
					case 2:
						{
						_localctx = new CloseExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(158);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(159);
						match(T__16);
						setState(160);
						match(T__15);
						setState(161);
						expression(19);
						}
						break;
					case 3:
						{
						_localctx = new DilateExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(162);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(163);
						match(T__17);
						setState(164);
						match(T__15);
						setState(165);
						expression(18);
						}
						break;
					case 4:
						{
						_localctx = new ErodeExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(166);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(167);
						match(T__18);
						setState(168);
						match(T__15);
						setState(169);
						expression(17);
						}
						break;
					case 5:
						{
						_localctx = new TopHatExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(170);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(171);
						match(T__19);
						setState(172);
						match(T__20);
						setState(173);
						match(T__15);
						setState(174);
						expression(16);
						}
						break;
					case 6:
						{
						_localctx = new BlackHatExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(175);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(176);
						match(T__21);
						setState(177);
						match(T__20);
						setState(178);
						match(T__15);
						setState(179);
						expression(15);
						}
						break;
					case 7:
						{
						_localctx = new FlipExprContext(new ExpressionContext(_parentctx, _parentState));
						((FlipExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(180);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(181);
						((FlipExprContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3848290697216L) != 0)) ) {
							((FlipExprContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(182);
						((FlipExprContext)_localctx).right = expression(5);
						}
						break;
					case 8:
						{
						_localctx = new ScaleExprContext(new ExpressionContext(_parentctx, _parentState));
						((ScaleExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(183);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(184);
						((ScaleExprContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30786325577728L) != 0)) ) {
							((ScaleExprContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(185);
						((ScaleExprContext)_localctx).right = expression(4);
						}
						break;
					case 9:
						{
						_localctx = new PixelOperationExprContext(new ExpressionContext(_parentctx, _parentState));
						((PixelOperationExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(186);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(187);
						((PixelOperationExprContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 246290604621824L) != 0)) ) {
							((PixelOperationExprContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(188);
						((PixelOperationExprContext)_localctx).right = expression(3);
						}
						break;
					case 10:
						{
						_localctx = new ComparisonExprContext(new ExpressionContext(_parentctx, _parentState));
						((ComparisonExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(189);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(190);
						((ComparisonExprContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__47 || _la==T__48) ) {
							((ComparisonExprContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(191);
						((ComparisonExprContext)_localctx).right = expression(2);
						}
						break;
					}
					} 
				}
				setState(196);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_primary);
		try {
			setState(202);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				match(ID);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				match(NUMBER);
				}
				break;
			case PERCENTAGE:
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
				match(PERCENTAGE);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(200);
				match(STRING);
				}
				break;
			case T__49:
				enterOuterAlt(_localctx, 5);
				{
				setState(201);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(T__49);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2162853971469795328L) != 0)) {
				{
				setState(205);
				expression(0);
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__50) {
					{
					{
					setState(206);
					match(T__50);
					setState(207);
					expression(0);
					}
					}
					setState(212);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(215);
			match(T__51);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imlListener ) ((imlListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof imlVisitor ) return ((imlVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_type);
		try {
			setState(224);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__52:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				match(T__52);
				}
				break;
			case T__53:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				match(T__53);
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(219);
				match(T__35);
				}
				break;
			case T__54:
				enterOuterAlt(_localctx, 4);
				{
				setState(220);
				match(T__54);
				}
				break;
			case T__55:
				enterOuterAlt(_localctx, 5);
				{
				setState(221);
				match(T__55);
				setState(222);
				match(T__33);
				setState(223);
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
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 18);
		case 2:
			return precpred(_ctx, 17);
		case 3:
			return precpred(_ctx, 16);
		case 4:
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001>\u00e3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0005\u0000"+
		" \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00011\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0004\u0004@\b\u0004\u000b\u0004\f\u0004A\u0001\u0004\u0001\u0004\u0004"+
		"\u0004F\b\u0004\u000b\u0004\f\u0004G\u0003\u0004J\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0004\u0005U\b\u0005\u000b\u0005\f\u0005V\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004"+
		"\u0006_\b\u0006\u000b\u0006\f\u0006`\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u0099\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00c1\b\u000b\n\u000b"+
		"\f\u000b\u00c4\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f"+
		"\u00cb\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00d1\b\r\n\r\f\r\u00d4"+
		"\t\r\u0003\r\u00d6\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00e1\b\u000e"+
		"\u0001\u000e\u0000\u0001\u0016\u000f\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0005\u0001\u0000\u001f"+
		" \u0001\u0000\')\u0001\u0000*,\u0001\u0000-/\u0001\u000001\u00ff\u0000"+
		"!\u0001\u0000\u0000\u0000\u00020\u0001\u0000\u0000\u0000\u00042\u0001"+
		"\u0000\u0000\u0000\u00067\u0001\u0000\u0000\u0000\b;\u0001\u0000\u0000"+
		"\u0000\nM\u0001\u0000\u0000\u0000\fZ\u0001\u0000\u0000\u0000\u000ed\u0001"+
		"\u0000\u0000\u0000\u0010g\u0001\u0000\u0000\u0000\u0012j\u0001\u0000\u0000"+
		"\u0000\u0014o\u0001\u0000\u0000\u0000\u0016\u0098\u0001\u0000\u0000\u0000"+
		"\u0018\u00ca\u0001\u0000\u0000\u0000\u001a\u00cc\u0001\u0000\u0000\u0000"+
		"\u001c\u00e0\u0001\u0000\u0000\u0000\u001e \u0003\u0002\u0001\u0000\u001f"+
		"\u001e\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000!\u001f\u0001"+
		"\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"$\u0001\u0000\u0000\u0000"+
		"#!\u0001\u0000\u0000\u0000$%\u0005\u0000\u0000\u0001%\u0001\u0001\u0000"+
		"\u0000\u0000&1\u0003\u0004\u0002\u0000\'1\u0003\u0006\u0003\u0000(1\u0003"+
		"\b\u0004\u0000)1\u0003\n\u0005\u0000*1\u0003\f\u0006\u0000+1\u0003\u000e"+
		"\u0007\u0000,1\u0003\u0010\b\u0000-1\u0003\u0012\t\u0000.1\u0003\u0014"+
		"\n\u0000/1\u0005=\u0000\u00000&\u0001\u0000\u0000\u00000\'\u0001\u0000"+
		"\u0000\u00000(\u0001\u0000\u0000\u00000)\u0001\u0000\u0000\u00000*\u0001"+
		"\u0000\u0000\u00000+\u0001\u0000\u0000\u00000,\u0001\u0000\u0000\u0000"+
		"0-\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u00000/\u0001\u0000\u0000"+
		"\u00001\u0003\u0001\u0000\u0000\u000023\u0003\u001c\u000e\u000034\u0005"+
		"<\u0000\u000045\u0005\u0001\u0000\u000056\u0003\u0016\u000b\u00006\u0005"+
		"\u0001\u0000\u0000\u000078\u0005<\u0000\u000089\u0005\u0001\u0000\u0000"+
		"9:\u0003\u0016\u000b\u0000:\u0007\u0001\u0000\u0000\u0000;<\u0005\u0002"+
		"\u0000\u0000<=\u0003\u0016\u000b\u0000=?\u0005\u0003\u0000\u0000>@\u0003"+
		"\u0002\u0001\u0000?>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000"+
		"A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BI\u0001\u0000\u0000"+
		"\u0000CE\u0005\u0004\u0000\u0000DF\u0003\u0002\u0001\u0000ED\u0001\u0000"+
		"\u0000\u0000FG\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001"+
		"\u0000\u0000\u0000HJ\u0001\u0000\u0000\u0000IC\u0001\u0000\u0000\u0000"+
		"IJ\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KL\u0005\u0005\u0000"+
		"\u0000L\t\u0001\u0000\u0000\u0000MN\u0005\u0006\u0000\u0000NO\u0003\u001c"+
		"\u000e\u0000OP\u0005<\u0000\u0000PQ\u0005\u0007\u0000\u0000QR\u0003\u0016"+
		"\u000b\u0000RT\u0005\b\u0000\u0000SU\u0003\u0002\u0001\u0000TS\u0001\u0000"+
		"\u0000\u0000UV\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001"+
		"\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0005\u0005\u0000\u0000"+
		"Y\u000b\u0001\u0000\u0000\u0000Z[\u0005\t\u0000\u0000[\\\u0003\u0016\u000b"+
		"\u0000\\^\u0005\b\u0000\u0000]_\u0003\u0002\u0001\u0000^]\u0001\u0000"+
		"\u0000\u0000_`\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001"+
		"\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0005\u0005\u0000\u0000"+
		"c\r\u0001\u0000\u0000\u0000de\u0005\n\u0000\u0000ef\u0003\u0016\u000b"+
		"\u0000f\u000f\u0001\u0000\u0000\u0000gh\u0005\u000b\u0000\u0000hi\u0003"+
		"\u0016\u000b\u0000i\u0011\u0001\u0000\u0000\u0000jk\u0003\u0016\u000b"+
		"\u0000kl\u0005\f\u0000\u0000lm\u0005\r\u0000\u0000mn\u0005;\u0000\u0000"+
		"n\u0013\u0001\u0000\u0000\u0000op\u0005<\u0000\u0000pq\u0005\u000e\u0000"+
		"\u0000qr\u0003\u0016\u000b\u0000r\u0015\u0001\u0000\u0000\u0000st\u0006"+
		"\u000b\uffff\uffff\u0000t\u0099\u0003\u0018\f\u0000uv\u0005\u0017\u0000"+
		"\u0000vw\u0005\u0018\u0000\u0000w\u0099\u0003\u0016\u000b\rxy\u0005\u0019"+
		"\u0000\u0000yz\u0005\u0018\u0000\u0000z\u0099\u0003\u0016\u000b\f{|\u0005"+
		"\u001a\u0000\u0000|\u0099\u0005;\u0000\u0000}~\u0005\u001b\u0000\u0000"+
		"~\u007f\u0005\u001c\u0000\u0000\u007f\u0080\u0003\u0016\u000b\u0000\u0080"+
		"\u0081\u0005\u001d\u0000\u0000\u0081\u0082\u0003\u0016\u000b\n\u0082\u0099"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u001e\u0000\u0000\u0084\u0085"+
		"\u0005\u001c\u0000\u0000\u0085\u0086\u0003\u0016\u000b\u0000\u0086\u0087"+
		"\u0007\u0000\u0000\u0000\u0087\u0088\u0005:\u0000\u0000\u0088\u0099\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0005!\u0000\u0000\u008a\u008b\u0005\""+
		"\u0000\u0000\u008b\u0099\u0003\u0016\u000b\b\u008c\u008d\u0005#\u0000"+
		"\u0000\u008d\u008e\u0005\"\u0000\u0000\u008e\u0099\u0003\u0016\u000b\u0007"+
		"\u008f\u0090\u0005$\u0000\u0000\u0090\u0091\u0005%\u0000\u0000\u0091\u0092"+
		"\u0003\u0016\u000b\u0000\u0092\u0093\u0005&\u0000\u0000\u0093\u0099\u0001"+
		"\u0000\u0000\u0000\u0094\u0095\u0005%\u0000\u0000\u0095\u0096\u0003\u0016"+
		"\u000b\u0000\u0096\u0097\u0005&\u0000\u0000\u0097\u0099\u0001\u0000\u0000"+
		"\u0000\u0098s\u0001\u0000\u0000\u0000\u0098u\u0001\u0000\u0000\u0000\u0098"+
		"x\u0001\u0000\u0000\u0000\u0098{\u0001\u0000\u0000\u0000\u0098}\u0001"+
		"\u0000\u0000\u0000\u0098\u0083\u0001\u0000\u0000\u0000\u0098\u0089\u0001"+
		"\u0000\u0000\u0000\u0098\u008c\u0001\u0000\u0000\u0000\u0098\u008f\u0001"+
		"\u0000\u0000\u0000\u0098\u0094\u0001\u0000\u0000\u0000\u0099\u00c2\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\n\u0013\u0000\u0000\u009b\u009c\u0005\u000f"+
		"\u0000\u0000\u009c\u009d\u0005\u0010\u0000\u0000\u009d\u00c1\u0003\u0016"+
		"\u000b\u0014\u009e\u009f\n\u0012\u0000\u0000\u009f\u00a0\u0005\u0011\u0000"+
		"\u0000\u00a0\u00a1\u0005\u0010\u0000\u0000\u00a1\u00c1\u0003\u0016\u000b"+
		"\u0013\u00a2\u00a3\n\u0011\u0000\u0000\u00a3\u00a4\u0005\u0012\u0000\u0000"+
		"\u00a4\u00a5\u0005\u0010\u0000\u0000\u00a5\u00c1\u0003\u0016\u000b\u0012"+
		"\u00a6\u00a7\n\u0010\u0000\u0000\u00a7\u00a8\u0005\u0013\u0000\u0000\u00a8"+
		"\u00a9\u0005\u0010\u0000\u0000\u00a9\u00c1\u0003\u0016\u000b\u0011\u00aa"+
		"\u00ab\n\u000f\u0000\u0000\u00ab\u00ac\u0005\u0014\u0000\u0000\u00ac\u00ad"+
		"\u0005\u0015\u0000\u0000\u00ad\u00ae\u0005\u0010\u0000\u0000\u00ae\u00c1"+
		"\u0003\u0016\u000b\u0010\u00af\u00b0\n\u000e\u0000\u0000\u00b0\u00b1\u0005"+
		"\u0016\u0000\u0000\u00b1\u00b2\u0005\u0015\u0000\u0000\u00b2\u00b3\u0005"+
		"\u0010\u0000\u0000\u00b3\u00c1\u0003\u0016\u000b\u000f\u00b4\u00b5\n\u0004"+
		"\u0000\u0000\u00b5\u00b6\u0007\u0001\u0000\u0000\u00b6\u00c1\u0003\u0016"+
		"\u000b\u0005\u00b7\u00b8\n\u0003\u0000\u0000\u00b8\u00b9\u0007\u0002\u0000"+
		"\u0000\u00b9\u00c1\u0003\u0016\u000b\u0004\u00ba\u00bb\n\u0002\u0000\u0000"+
		"\u00bb\u00bc\u0007\u0003\u0000\u0000\u00bc\u00c1\u0003\u0016\u000b\u0003"+
		"\u00bd\u00be\n\u0001\u0000\u0000\u00be\u00bf\u0007\u0004\u0000\u0000\u00bf"+
		"\u00c1\u0003\u0016\u000b\u0002\u00c0\u009a\u0001\u0000\u0000\u0000\u00c0"+
		"\u009e\u0001\u0000\u0000\u0000\u00c0\u00a2\u0001\u0000\u0000\u0000\u00c0"+
		"\u00a6\u0001\u0000\u0000\u0000\u00c0\u00aa\u0001\u0000\u0000\u0000\u00c0"+
		"\u00af\u0001\u0000\u0000\u0000\u00c0\u00b4\u0001\u0000\u0000\u0000\u00c0"+
		"\u00b7\u0001\u0000\u0000\u0000\u00c0\u00ba\u0001\u0000\u0000\u0000\u00c0"+
		"\u00bd\u0001\u0000\u0000\u0000\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3"+
		"\u0017\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5"+
		"\u00cb\u0005<\u0000\u0000\u00c6\u00cb\u0005:\u0000\u0000\u00c7\u00cb\u0005"+
		"9\u0000\u0000\u00c8\u00cb\u0005;\u0000\u0000\u00c9\u00cb\u0003\u001a\r"+
		"\u0000\u00ca\u00c5\u0001\u0000\u0000\u0000\u00ca\u00c6\u0001\u0000\u0000"+
		"\u0000\u00ca\u00c7\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000"+
		"\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00cb\u0019\u0001\u0000\u0000"+
		"\u0000\u00cc\u00d5\u00052\u0000\u0000\u00cd\u00d2\u0003\u0016\u000b\u0000"+
		"\u00ce\u00cf\u00053\u0000\u0000\u00cf\u00d1\u0003\u0016\u000b\u0000\u00d0"+
		"\u00ce\u0001\u0000\u0000\u0000\u00d1\u00d4\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d5"+
		"\u00cd\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d8\u00054\u0000\u0000\u00d8\u001b"+
		"\u0001\u0000\u0000\u0000\u00d9\u00e1\u00055\u0000\u0000\u00da\u00e1\u0005"+
		"6\u0000\u0000\u00db\u00e1\u0005$\u0000\u0000\u00dc\u00e1\u00057\u0000"+
		"\u0000\u00dd\u00de\u00058\u0000\u0000\u00de\u00df\u0005\"\u0000\u0000"+
		"\u00df\u00e1\u0003\u001c\u000e\u0000\u00e0\u00d9\u0001\u0000\u0000\u0000"+
		"\u00e0\u00da\u0001\u0000\u0000\u0000\u00e0\u00db\u0001\u0000\u0000\u0000"+
		"\u00e0\u00dc\u0001\u0000\u0000\u0000\u00e0\u00dd\u0001\u0000\u0000\u0000"+
		"\u00e1\u001d\u0001\u0000\u0000\u0000\u000e!0AGIV`\u0098\u00c0\u00c2\u00ca"+
		"\u00d2\u00d5\u00e0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}