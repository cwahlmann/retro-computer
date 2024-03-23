package de.dreierschach.retrocomputer.basic;

import de.dreierschach.retrocomputer.BasicBaseListener;
import de.dreierschach.retrocomputer.BasicParser;
import de.dreierschach.retrocomputer.FileService;
import de.dreierschach.retrocomputer.VsyncTimer;
import de.dreierschach.retrocomputer.basic.model.PrintExpression;
import de.dreierschach.retrocomputer.basic.model.Value;
import de.dreierschach.retrocomputer.basic.model.ValueExpression;
import de.dreierschach.retrocomputer.config.HelpConfig;
import de.dreierschach.retrocomputer.ui.Renderer;
import org.springframework.stereotype.Component;

import static de.dreierschach.retrocomputer.basic.BasicError.Type.FUNCTION_ERROR;
import static de.dreierschach.retrocomputer.ui.VideoMode.videoMode;

@Component
public class BasicListenerUi extends BasicBaseListener implements BasicListenerHelper {
    private final Renderer renderer;
    private final RunningContext context;
    private final VsyncTimer vsyncTimer;

    public BasicListenerUi(Renderer renderer, RunningContext context, VsyncTimer vsyncTimer) {
        this.renderer = renderer;
        this.context = context;
        this.vsyncTimer = vsyncTimer;
    }

    public RunningContext getContext() {
        return context;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    @Override
    public void enterPrint(BasicParser.PrintContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new PrintExpression());
    }

    @Override
    public void exitPrint(BasicParser.PrintContext ctx) {
        if (context.skip()) {
            return;
        }
        var expression = (PrintExpression) (context.expressionStack().pop());
        assertTextMode();
        if (ctx.at != null) {
            var pos = expression.getValue(0).toNumber();
            if (pos < 0 || pos >= renderer.getSize()) {
                throw new BasicError(BasicError.Type.FUNCTION_ERROR, context.getPp());
            }
            renderer.setCursor(pos);
            renderer.print(expression.evaluate(1).toString(), context.getColor(), context.getBgColor());
            return;
        }
        renderer.print(expression.evaluate().toString(), context.getColor(), context.getBgColor());
    }

    @Override
    public void enterPrintln(BasicParser.PrintlnContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new PrintExpression());
    }

    @Override
    public void exitPrintln(BasicParser.PrintlnContext ctx) {
        if (context.skip()) {
            return;
        }
        assertTextMode();
        var expression = (PrintExpression) (context.expressionStack().pop());
        if (ctx.at != null) {
            var pos = expression.getValue(0).toNumber();
            if (pos < 0 || pos >= renderer.getSize()) {
                throw new BasicError(BasicError.Type.FUNCTION_ERROR, context.getPp());
            }
            renderer.setCursor(pos);
            renderer.println(expression.evaluate(1).toString(), context.getColor(), context.getBgColor());
            return;
        }
        renderer.println(expression.evaluate().toString(), context.getColor(), context.getBgColor());
    }

    @Override
    public void exitPrintNewline(BasicParser.PrintNewlineContext ctx) {
        if (context.skip()) {
            return;
        }
        assertTextMode();
        renderer.println(context.getColor(), context.getBgColor());
    }

    @Override
    public void enterInput(BasicParser.InputContext ctx) {
        if (context.skip()) {
            return;
        }
        assertTextMode();
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitInput(BasicParser.InputContext ctx) {
        if (context.skip()) {
            return;
        }
        assertTextMode();
        var expression = context.expressionStack().pop();
        var identifier = expression.getValue(0).string();
        var indexes = expression.getValue(1).array().values().stream().map(Value::toNumber).toList();
        context.activateInputLine();
        renderer.setCursorType(Renderer.CursorType.INSERT);
        var input = context.awaitInputLine();
        renderer.setCursorType(Renderer.CursorType.INVISIBLE);
        setValueByIdentifier(identifier, indexes, new Value(input));
    }

    @Override
    public void exitLeftScroll(BasicParser.LeftScrollContext ctx) {
        if (context.skip()) {
            return;
        }
        assertTextMode();
        renderer.scrollLeft();
    }

    @Override
    public void exitRightScroll(BasicParser.RightScrollContext ctx) {
        if (context.skip()) {
            return;
        }
        assertTextMode();
        renderer.scrollRight();
    }

    @Override
    public void exitCls(BasicParser.ClsContext ctx) {
        renderer.clear(context.getColor(), context.getBgColor());
    }

    @Override
    public void enterSetMode(BasicParser.SetModeContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitSetMode(BasicParser.SetModeContext ctx) {
        if (context.skip()) {
            return;
        }
        var expression = context.expressionStack().pop();
        renderer.setVideoMode(videoMode(expression.evaluate().toNumber()));
        context.setColor(1);
        context.setBgColor(0);
        renderer.clear(1, 0);
    }

    @Override
    public void enterColor(BasicParser.ColorContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitColor(BasicParser.ColorContext ctx) {
        if (context.skip()) {
            return;
        }
        var expression = context.expressionStack().pop();
        context.setColor(expression.evaluate().toNumber());
        if (ctx.bg != null) {
            context.setBgColor(expression.getValue(1).toNumber());
        }
    }

    @Override
    public void enterBgcolor(BasicParser.BgcolorContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitBgcolor(BasicParser.BgcolorContext ctx) {
        if (context.skip()) {
            return;
        }
        var expression = context.expressionStack().pop();
        context.setBgColor(expression.evaluate().toNumber());
    }

    @Override
    public void enterSet(BasicParser.SetContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitSet(BasicParser.SetContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var x = expression.getValue(0).toNumber();
        var y = expression.getValue(1).toNumber();
        var color = context.getColor();
        renderer.setPoint(x, y, color);
    }

    @Override
    public void enterPointExpr(BasicParser.PointExprContext ctx) {
        if (context.skip()) {
            return;
        }
        if (renderer.isTextMode()) {
            throw new BasicError(FUNCTION_ERROR, context.getPp());
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitPointExpr(BasicParser.PointExprContext ctx) {
        if (context.skip()) {
            return;
        }
        if (renderer.isTextMode()) {
            throw new BasicError(FUNCTION_ERROR, context.getPp());
        }
        var expression = context.expressionStack().pop();
        var x = expression.getValue(0).toNumber();
        var y = expression.getValue(1).toNumber();
        var c = renderer.getColorIndex(x, y);
        context.expressionStack().peek().addValue(new Value(c));
    }

    @Override
    public void enterDrawLine(BasicParser.DrawLineContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawLine(BasicParser.DrawLineContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var x0 = expression.getValue(0).toNumber();
        var y0 = expression.getValue(1).toNumber();
        var x1 = expression.getValue(2).toNumber();
        var y1 = expression.getValue(3).toNumber();
        var color = context.getColor();
        renderer.drawLine(x0, y0, x1, y1, color);
    }

    @Override
    public void enterDrawEllipse(BasicParser.DrawEllipseContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawEllipse(BasicParser.DrawEllipseContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var x0 = expression.getValue(0).toNumber();
        var y0 = expression.getValue(1).toNumber();
        var x1 = expression.getValue(2).toNumber();
        var y1 = expression.getValue(3).toNumber();
        var color = context.getColor();
        renderer.drawEllipse(x0, y0, x1, y1, color);
    }

    @Override
    public void enterDrawFEllipse(BasicParser.DrawFEllipseContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }


    @Override
    public void exitDrawFEllipse(BasicParser.DrawFEllipseContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var x0 = expression.getValue(0).toNumber();
        var y0 = expression.getValue(1).toNumber();
        var x1 = expression.getValue(2).toNumber();
        var y1 = expression.getValue(3).toNumber();
        var color = context.getColor();
        renderer.drawFilledEllipse(x0, y0, x1, y1, color);
    }

    @Override
    public void enterDrawRect(BasicParser.DrawRectContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawRect(BasicParser.DrawRectContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var x0 = expression.getValue(0).toNumber();
        var y0 = expression.getValue(1).toNumber();
        var x1 = expression.getValue(2).toNumber();
        var y1 = expression.getValue(3).toNumber();
        var color = context.getColor();
        renderer.drawRect(x0, y0, x1, y1, color);
    }

    @Override
    public void enterDrawFRect(BasicParser.DrawFRectContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawFRect(BasicParser.DrawFRectContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var x0 = expression.getValue(0).toNumber();
        var y0 = expression.getValue(1).toNumber();
        var x1 = expression.getValue(2).toNumber();
        var y1 = expression.getValue(3).toNumber();
        var color = context.getColor();
        renderer.drawFilledRect(x0, y0, x1, y1, color);
    }

    @Override
    public void enterDrawFace(BasicParser.DrawFaceContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawFace(BasicParser.DrawFaceContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var x0 = expression.getValue(0).toNumber();
        var y0 = expression.getValue(1).toNumber();
        var x1 = expression.getValue(2).toNumber();
        var y1 = expression.getValue(3).toNumber();
        var x2 = expression.getValue(4).toNumber();
        var y2 = expression.getValue(5).toNumber();
        var color = context.getColor();
        renderer.drawFace(x0, y0, x1, y1, x2, y2, color);
    }

    @Override
    public void enterDrawFFace(BasicParser.DrawFFaceContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawFFace(BasicParser.DrawFFaceContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var x0 = expression.getValue(0).toNumber();
        var y0 = expression.getValue(1).toNumber();
        var x1 = expression.getValue(2).toNumber();
        var y1 = expression.getValue(3).toNumber();
        var x2 = expression.getValue(4).toNumber();
        var y2 = expression.getValue(5).toNumber();
        var color = context.getColor();
        renderer.drawFilledFace(x0, y0, x1, y1, x2, y2, color);
    }

    @Override
    public void enterDrawText(BasicParser.DrawTextContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawText(BasicParser.DrawTextContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var text = expression.getValue(0).toString();
        var x = expression.getValue(1).toNumber();
        var y = expression.getValue(2).toNumber();
        var color = context.getColor();
        renderer.drawText(text, x, y, color, -1);
    }

    @Override
    public void enterDrawCText(BasicParser.DrawCTextContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawCText(BasicParser.DrawCTextContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var text = expression.getValue(0).toString();
        var x = expression.getValue(1).toNumber();
        var y = expression.getValue(2).toNumber();
        var color = context.getColor();
        renderer.centerText(text, x, y, color, -1);
    }

    @Override
    public void enterDrawFText(BasicParser.DrawFTextContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawFText(BasicParser.DrawFTextContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var text = expression.getValue(0).toString();
        var x = expression.getValue(1).toNumber();
        var y = expression.getValue(2).toNumber();
        renderer.drawText(text, x, y, context.getColor(), context.getBgColor());
    }

    @Override
    public void enterDrawFCText(BasicParser.DrawFCTextContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawFCText(BasicParser.DrawFCTextContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var text = expression.getValue(0).toString();
        var x = expression.getValue(1).toNumber();
        var y = expression.getValue(2).toNumber();
        renderer.centerText(text, x, y, context.getColor(), context.getBgColor());
    }

    @Override
    public void exitArcade(BasicParser.ArcadeContext ctx) {
        renderer.setArcadeMode(true);
    }

    @Override
    public void exitFlip(BasicParser.FlipContext ctx) {
        renderer.flip();
    }

    @Override
    public void enterVsync(BasicParser.VsyncContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());

    }

    @Override
    public void exitVsync(BasicParser.VsyncContext ctx) {
        if (context.skip()) {
            return;
        }
        var expression = context.expressionStack().pop();
        if (ctx.expression() != null) {
            var ticks = expression.evaluate().toNumber();
            if (ticks <= 0 || ticks > 50) {
                throw new BasicError(FUNCTION_ERROR, context.getPp());
            }
            vsyncTimer.setTicks(ticks);
            return;
        }
        vsyncTimer.await();
    }

    @Override
    public void enterKeyboardExpr(BasicParser.KeyboardExprContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitKeyboardExpr(BasicParser.KeyboardExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var v = context.expressionStack().pop().evaluate();
        Value result;
        if (v == Value.UNDEF) {
            result = new Value(String.valueOf(context.getTypedKey()));
        } else {
            var expected = switch (v.type()) {
                case STRING -> v.toString().charAt(0);
                case BOOL -> 0;
                case NUMBER -> v.number();
                case DOUBLE_NUMBER -> v.toNumber();
                case ARRAY -> v.toNumber();
            };
            result = new Value(context.isPressedKey((char) expected));
        }
        context.expressionStack().peek().addValue(result);
    }
}
