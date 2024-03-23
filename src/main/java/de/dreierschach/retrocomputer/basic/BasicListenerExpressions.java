package de.dreierschach.retrocomputer.basic;

import de.dreierschach.retrocomputer.BasicBaseListener;
import de.dreierschach.retrocomputer.BasicParser;
import de.dreierschach.retrocomputer.basic.model.*;
import de.dreierschach.retrocomputer.ui.Renderer;
import org.springframework.stereotype.Component;

import static de.dreierschach.retrocomputer.basic.BasicError.Type.FUNCTION_ERROR;
import static de.dreierschach.retrocomputer.basic.model.Value.arrayValue;

@Component
public class BasicListenerExpressions extends BasicBaseListener implements BasicListenerHelper {
    private final Renderer renderer;
    private final RunningContext context;

    public BasicListenerExpressions(Renderer renderer, RunningContext context) {
        this.renderer = renderer;
        this.context = context;
    }

    @Override
    public RunningContext getContext() {
        return context;
    }

    @Override
    public Renderer getRenderer() {
        return renderer;
    }

    @Override
    public void enterAssignment(BasicParser.AssignmentContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new AssignmentExpression());
    }

    @Override
    public void exitAssignment(BasicParser.AssignmentContext ctx) {
        if (context.skip()) {
            return;
        }
        var expression = (AssignmentExpression) context.expressionStack().pop();
        var identifier = expression.identifier();
        var indexes = expression.indexes();
        var value = expression.evaluate();

        setValueByIdentifier(identifier, indexes, value);
    }

    @Override
    public void enterPowExpr(BasicParser.PowExprContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new OperatorExpression(OperatorExpression.Type.POW));
    }

    @Override
    public void enterMulDivModExpr(BasicParser.MulDivModExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var token = ctx.op.getText();
        var type = switch (token) {
            case "*" -> OperatorExpression.Type.MUL;
            case "/" -> OperatorExpression.Type.DIV;
            default -> OperatorExpression.Type.MOD;

        };
        context.expressionStack().push(new OperatorExpression(type));
    }

    @Override
    public void enterPlusMinusExpr(BasicParser.PlusMinusExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var token = ctx.op.getText();
        var type = "+".equals(token) ? OperatorExpression.Type.PLUS : OperatorExpression.Type.MINUS;
        context.expressionStack().push(new OperatorExpression(type));
    }

    @Override
    public void enterLogicalExpr(BasicParser.LogicalExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var token = ctx.op.getText();
        var type = switch (token) {
            case "AND" -> OperatorExpression.Type.AND;
            case "OR" -> OperatorExpression.Type.OR;
            default -> OperatorExpression.Type.XOR;

        };
        context.expressionStack().push(new OperatorExpression(type));
    }

    @Override
    public void enterCompExpr(BasicParser.CompExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var token = ctx.op.getText();
        var type = switch (token) {
            default -> OperatorExpression.Type.EQ;
            case "<>" -> OperatorExpression.Type.NEQ;
            case "<" -> OperatorExpression.Type.LT;
            case "<=" -> OperatorExpression.Type.LE;
            case ">" -> OperatorExpression.Type.GT;
            case ">=" -> OperatorExpression.Type.GE;
        };
        context.expressionStack().push(new OperatorExpression(type));
    }

    @Override
    public void enterArrayExpr(BasicParser.ArrayExprContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void enterFuncCallExpr(BasicParser.FuncCallExprContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new FuncCallExpression(ctx.functionCall().fn.getText(), renderer.modeConfig()));
    }

    @Override
    public void exitFuncCallExpr(BasicParser.FuncCallExprContext ctx) {
        if (context.skip()) {
            return;
        }
        exitExpression();
    }

    @Override
    public void exitPowExpr(BasicParser.PowExprContext ctx) {
        if (context.skip()) {
            return;
        }
        exitExpression();
    }

    @Override
    public void exitMulDivModExpr(BasicParser.MulDivModExprContext ctx) {
        if (context.skip()) {
            return;
        }
        exitExpression();
    }

    @Override
    public void exitPlusMinusExpr(BasicParser.PlusMinusExprContext ctx) {
        if (context.skip()) {
            return;
        }
        exitExpression();
    }

    @Override
    public void exitLogicalExpr(BasicParser.LogicalExprContext ctx) {
        if (context.skip()) {
            return;
        }
        exitExpression();
    }

    @Override
    public void exitCompExpr(BasicParser.CompExprContext ctx) {
        if (context.skip()) {
            return;
        }
        exitExpression();
    }

    @Override
    public void exitArrayExpr(BasicParser.ArrayExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var expression = context.expressionStack().pop();
        var result = arrayValue(expression.getValues());
        context.expressionStack().peek().addValue(result);
    }

    public void exitExpression() {
        if (context.skip()) {
            return;
        }
        var result = context.expressionStack().pop().evaluate();
        context.expressionStack().peek().addValue(result);
    }

    @Override
    public void enterIdExp(BasicParser.IdExpContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitIdExp(BasicParser.IdExpContext ctx) {
        if (context.skip()) {
            return;
        }
        var expression = context.expressionStack().pop();
        var identifier = expression.getValue(0).string();
        var indexes = expression.getValue(1).array().values().stream().map(Value::toNumber).toList();
        var value = getValueByIdentifier(identifier, indexes);
        context.expressionStack().peek().addValue(value);
    }

    @Override
    public void enterIdentifier(BasicParser.IdentifierContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new IdentifierExpression());
    }

    @Override
    public void exitIdentifier(BasicParser.IdentifierContext ctx) {
        if (context.skip()) {
            return;
        }
        var identifier = ctx.IDENTIFIER().getText();
        var indexes = arrayValue(context.expressionStack().pop().getValues());

        context.expressionStack().peek().addValue(new Value(identifier));
        context.expressionStack().peek().addValue(indexes);
    }

    @Override
    public void enterNotExpr(BasicParser.NotExprContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitNotExpr(BasicParser.NotExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var v = context.expressionStack().pop().evaluate();
        context.expressionStack().peek().addValue(not(v));
    }

    @Override
    public void enterNegativeExpression(BasicParser.NegativeExpressionContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitNegativeExpression(BasicParser.NegativeExpressionContext ctx) {
        if (context.skip()) {
            return;
        }
        var v = context.expressionStack().pop().evaluate();
        context.expressionStack().peek().addValue(neg(v));
    }

    // -------- literals

    @Override
    public void exitStringExpr(BasicParser.StringExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var text = ctx.STRING_LITERAL().getText();
        var value = new Value(text.substring(1, text.length() - 1));
        context.expressionStack().peek().addValue(value);
    }

    @Override
    public void exitNumExpr(BasicParser.NumExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var number = Integer.parseInt(ctx.NUMBER().getText());
        var value = new Value(number);
        context.expressionStack().peek().addValue(value);
    }

    @Override
    public void exitDoubleExpr(BasicParser.DoubleExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var doubleNumber = Double.parseDouble(ctx.DOUBLE_NUMBER().getText());
        var value = new Value(doubleNumber);
        context.expressionStack().peek().addValue(value);
    }

    @Override
    public void exitBoolExpr(BasicParser.BoolExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var text = ctx.BOOL_LITERAL().getText();
        var value = new Value(text).toType(Value.Type.BOOL);
        context.expressionStack().peek().addValue(value);
    }
}
