// Generated from de/dreierschach/retrocomputer/Basic.g4 by ANTLR 4.13.1
package de.dreierschach.retrocomputer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BasicParser}.
 */
public interface BasicListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BasicParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(BasicParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(BasicParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(BasicParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(BasicParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(BasicParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(BasicParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(BasicParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(BasicParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#nextStatement}.
	 * @param ctx the parse tree
	 */
	void enterNextStatement(BasicParser.NextStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#nextStatement}.
	 * @param ctx the parse tree
	 */
	void exitNextStatement(BasicParser.NextStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(BasicParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(BasicParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(BasicParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(BasicParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#thenStatement}.
	 * @param ctx the parse tree
	 */
	void enterThenStatement(BasicParser.ThenStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#thenStatement}.
	 * @param ctx the parse tree
	 */
	void exitThenStatement(BasicParser.ThenStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(BasicParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(BasicParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(BasicParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(BasicParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#println}.
	 * @param ctx the parse tree
	 */
	void enterPrintln(BasicParser.PrintlnContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#println}.
	 * @param ctx the parse tree
	 */
	void exitPrintln(BasicParser.PrintlnContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#printNewline}.
	 * @param ctx the parse tree
	 */
	void enterPrintNewline(BasicParser.PrintNewlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#printNewline}.
	 * @param ctx the parse tree
	 */
	void exitPrintNewline(BasicParser.PrintNewlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#goto}.
	 * @param ctx the parse tree
	 */
	void enterGoto(BasicParser.GotoContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#goto}.
	 * @param ctx the parse tree
	 */
	void exitGoto(BasicParser.GotoContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#gosub}.
	 * @param ctx the parse tree
	 */
	void enterGosub(BasicParser.GosubContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#gosub}.
	 * @param ctx the parse tree
	 */
	void exitGosub(BasicParser.GosubContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(BasicParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(BasicParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEnd(BasicParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEnd(BasicParser.EndContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(BasicParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(BasicParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#listAll}.
	 * @param ctx the parse tree
	 */
	void enterListAll(BasicParser.ListAllContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#listAll}.
	 * @param ctx the parse tree
	 */
	void exitListAll(BasicParser.ListAllContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#listOne}.
	 * @param ctx the parse tree
	 */
	void enterListOne(BasicParser.ListOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#listOne}.
	 * @param ctx the parse tree
	 */
	void exitListOne(BasicParser.ListOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#listFrom}.
	 * @param ctx the parse tree
	 */
	void enterListFrom(BasicParser.ListFromContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#listFrom}.
	 * @param ctx the parse tree
	 */
	void exitListFrom(BasicParser.ListFromContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#listTo}.
	 * @param ctx the parse tree
	 */
	void enterListTo(BasicParser.ListToContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#listTo}.
	 * @param ctx the parse tree
	 */
	void exitListTo(BasicParser.ListToContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#listFromTo}.
	 * @param ctx the parse tree
	 */
	void enterListFromTo(BasicParser.ListFromToContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#listFromTo}.
	 * @param ctx the parse tree
	 */
	void exitListFromTo(BasicParser.ListFromToContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#clear}.
	 * @param ctx the parse tree
	 */
	void enterClear(BasicParser.ClearContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#clear}.
	 * @param ctx the parse tree
	 */
	void exitClear(BasicParser.ClearContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#cls}.
	 * @param ctx the parse tree
	 */
	void enterCls(BasicParser.ClsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#cls}.
	 * @param ctx the parse tree
	 */
	void exitCls(BasicParser.ClsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#new}.
	 * @param ctx the parse tree
	 */
	void enterNew(BasicParser.NewContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#new}.
	 * @param ctx the parse tree
	 */
	void exitNew(BasicParser.NewContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(BasicParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(BasicParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#leftScroll}.
	 * @param ctx the parse tree
	 */
	void enterLeftScroll(BasicParser.LeftScrollContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#leftScroll}.
	 * @param ctx the parse tree
	 */
	void exitLeftScroll(BasicParser.LeftScrollContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#rightScroll}.
	 * @param ctx the parse tree
	 */
	void enterRightScroll(BasicParser.RightScrollContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#rightScroll}.
	 * @param ctx the parse tree
	 */
	void exitRightScroll(BasicParser.RightScrollContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#delay}.
	 * @param ctx the parse tree
	 */
	void enterDelay(BasicParser.DelayContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#delay}.
	 * @param ctx the parse tree
	 */
	void exitDelay(BasicParser.DelayContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#load}.
	 * @param ctx the parse tree
	 */
	void enterLoad(BasicParser.LoadContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#load}.
	 * @param ctx the parse tree
	 */
	void exitLoad(BasicParser.LoadContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#save}.
	 * @param ctx the parse tree
	 */
	void enterSave(BasicParser.SaveContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#save}.
	 * @param ctx the parse tree
	 */
	void exitSave(BasicParser.SaveContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#dir}.
	 * @param ctx the parse tree
	 */
	void enterDir(BasicParser.DirContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#dir}.
	 * @param ctx the parse tree
	 */
	void exitDir(BasicParser.DirContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#del}.
	 * @param ctx the parse tree
	 */
	void enterDel(BasicParser.DelContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#del}.
	 * @param ctx the parse tree
	 */
	void exitDel(BasicParser.DelContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#setMode}.
	 * @param ctx the parse tree
	 */
	void enterSetMode(BasicParser.SetModeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#setMode}.
	 * @param ctx the parse tree
	 */
	void exitSetMode(BasicParser.SetModeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColor(BasicParser.ColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColor(BasicParser.ColorContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSet(BasicParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSet(BasicParser.SetContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#drawLine}.
	 * @param ctx the parse tree
	 */
	void enterDrawLine(BasicParser.DrawLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#drawLine}.
	 * @param ctx the parse tree
	 */
	void exitDrawLine(BasicParser.DrawLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#drawEllipse}.
	 * @param ctx the parse tree
	 */
	void enterDrawEllipse(BasicParser.DrawEllipseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#drawEllipse}.
	 * @param ctx the parse tree
	 */
	void exitDrawEllipse(BasicParser.DrawEllipseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#drawFEllipse}.
	 * @param ctx the parse tree
	 */
	void enterDrawFEllipse(BasicParser.DrawFEllipseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#drawFEllipse}.
	 * @param ctx the parse tree
	 */
	void exitDrawFEllipse(BasicParser.DrawFEllipseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#drawRect}.
	 * @param ctx the parse tree
	 */
	void enterDrawRect(BasicParser.DrawRectContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#drawRect}.
	 * @param ctx the parse tree
	 */
	void exitDrawRect(BasicParser.DrawRectContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#drawFRect}.
	 * @param ctx the parse tree
	 */
	void enterDrawFRect(BasicParser.DrawFRectContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#drawFRect}.
	 * @param ctx the parse tree
	 */
	void exitDrawFRect(BasicParser.DrawFRectContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#drawText}.
	 * @param ctx the parse tree
	 */
	void enterDrawText(BasicParser.DrawTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#drawText}.
	 * @param ctx the parse tree
	 */
	void exitDrawText(BasicParser.DrawTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#drawCText}.
	 * @param ctx the parse tree
	 */
	void enterDrawCText(BasicParser.DrawCTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#drawCText}.
	 * @param ctx the parse tree
	 */
	void exitDrawCText(BasicParser.DrawCTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#arcade}.
	 * @param ctx the parse tree
	 */
	void enterArcade(BasicParser.ArcadeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#arcade}.
	 * @param ctx the parse tree
	 */
	void exitArcade(BasicParser.ArcadeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#flip}.
	 * @param ctx the parse tree
	 */
	void enterFlip(BasicParser.FlipContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#flip}.
	 * @param ctx the parse tree
	 */
	void exitFlip(BasicParser.FlipContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#help}.
	 * @param ctx the parse tree
	 */
	void enterHelp(BasicParser.HelpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#help}.
	 * @param ctx the parse tree
	 */
	void exitHelp(BasicParser.HelpContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(BasicParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(BasicParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paranthesisExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParanthesisExpr(BasicParser.ParanthesisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paranthesisExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParanthesisExpr(BasicParser.ParanthesisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDoubleExpr(BasicParser.DoubleExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDoubleExpr(BasicParser.DoubleExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negativeExpression}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegativeExpression(BasicParser.NegativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negativeExpression}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegativeExpression(BasicParser.NegativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(BasicParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(BasicParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpr(BasicParser.LogicalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpr(BasicParser.LogicalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusMinusExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPlusMinusExpr(BasicParser.PlusMinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusMinusExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPlusMinusExpr(BasicParser.PlusMinusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivModExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDivModExpr(BasicParser.MulDivModExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivModExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDivModExpr(BasicParser.MulDivModExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpr(BasicParser.FuncCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpr(BasicParser.FuncCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumExpr(BasicParser.NumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumExpr(BasicParser.NumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(BasicParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(BasicParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code keyboardExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterKeyboardExpr(BasicParser.KeyboardExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code keyboardExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitKeyboardExpr(BasicParser.KeyboardExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(BasicParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(BasicParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExp}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdExp(BasicParser.IdExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExp}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdExp(BasicParser.IdExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(BasicParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(BasicParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(BasicParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(BasicParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(BasicParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link BasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(BasicParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#keyboard}.
	 * @param ctx the parse tree
	 */
	void enterKeyboard(BasicParser.KeyboardContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#keyboard}.
	 * @param ctx the parse tree
	 */
	void exitKeyboard(BasicParser.KeyboardContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(BasicParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(BasicParser.FunctionCallContext ctx);
}