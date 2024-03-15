package de.dreierschach.retrocomputer.basic.model;

import de.dreierschach.retrocomputer.config.GfxModeConfig;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class FuncCallExpression extends Expression {

    private final BasicFunction function;
    private final GfxModeConfig config;

    public FuncCallExpression(String token, GfxModeConfig config) {
        this.function = BasicFunction.of(token);
        this.config = config;
    }

    @Override
    public Value evaluate() {
        return function.function.apply(config, getValues());
    }

    enum BasicFunction {
        FN_NOPE("", (c, v) -> v.get(0)),
        FN_SIN("SIN", (c, v) -> new Value(Math.sin(v.get(0).toDoubleNumber()))),
        FN_COS("COS", (c, v) -> new Value(Math.cos(v.get(0).toDoubleNumber()))),
        FN_TAN("TAN", (c, v) -> new Value(Math.tan(v.get(0).toDoubleNumber()))),
        FN_ASIN("ASIN", (c, v) -> new Value(Math.asin(v.get(0).toDoubleNumber()))),
        FN_ACOS("ACOS", (c, v) -> new Value(Math.acos(v.get(0).toDoubleNumber()))),
        FN_ATAN("ATAN", (c, v) -> new Value(Math.atan(v.get(0).toDoubleNumber()))),
        FN_SQR("SQR", (c, v) -> new Value(Math.sqrt(v.get(0).toDoubleNumber()))),
        FN_LOG("LOG", (c, v) -> new Value(Math.log10(v.get(0).toDoubleNumber()))),
        FN_ABS("ABS", BasicFunction::abs),
        FN_SGN("SGN", BasicFunction::sgn),
        FN_CHR("CHR", (c, v) -> new Value(String.valueOf((char) v.get(0).toNumber()))),
        FN_VAL("VAL", (c, v) -> new Value(v.get(0).toString().charAt(0))),
        FN_INT("INT", (c, v) -> new Value(v.get(0).toNumber())),
        FN_FLOAT("FLOAT", (c, v) -> new Value(v.get(0).toDoubleNumber())),
        FN_STR("STR", (c, v) -> new Value(v.get(0).toString())),
        FN_RND("RND", BasicFunction::rnd),
        FN_SPC("SPC", (c, v) -> new Value(StringUtils.repeat(' ', v.get(0).toNumber()))),
        FN_SUBSTR("SUBSTR", BasicFunction::substr),
        FN_HEX("HEX", (c, v) -> new Value("%X".formatted(v.get(0).toNumber()))),
        FN_AHEX("AHEX", (c, v) -> new Value(Integer.parseInt(v.get(0).toString(), 16))),
        FN_WIDTH("WIDTH", (c, v) -> new Value(c.getWidth())),
        FN_HEIGHT("HEIGHT", (c, v) -> new Value(c.getHeight())),
        ;

        BasicFunction(String token, BiFunction<GfxModeConfig, List<Value>, Value> function) {
            this.token = token;
            this.function = function;
        }

        public static BasicFunction of(String token) {
            return Arrays.stream(values()).filter(f -> f.token.equals(token)).findAny().orElse(FN_NOPE);
        }

        private static Value abs(GfxModeConfig c, List<Value> v) {
            return switch (v.get(0).type()) {
                case STRING -> new Value(Math.abs(v.get(0).toDoubleNumber()));
                case BOOL -> new Value(v.get(0).bool() ? 1 : 0);
                case NUMBER -> new Value(Math.abs(v.get(0).number()));
                case DOUBLE_NUMBER -> new Value(Math.abs(v.get(0).doubleNumber()));
                case ARRAY -> Value.UNDEF;
            };
        }

        private static Value sgn(GfxModeConfig c, List<Value> v) {
            return switch (v.get(0).type()) {
                case STRING -> new Value(Math.signum(v.get(0).toDoubleNumber()));
                case BOOL -> new Value(v.get(0).bool() ? 1 : 0);
                case NUMBER -> new Value(Math.signum(v.get(0).number()));
                case DOUBLE_NUMBER -> new Value(Math.signum(v.get(0).doubleNumber()));
                case ARRAY -> Value.UNDEF;
            };
        }

        private static Value rnd(GfxModeConfig c, List<Value> v) {
            return switch (v.get(0).type()) {
                case STRING ->
                        StringUtils.isEmpty(v.get(0).string()) ? v.get(0) : new Value(String.valueOf(v.get(0).string().charAt((int) (Math.random() * v.get(0).string().length()))));
                case BOOL -> new Value(Math.random() >= 0.5);
                case NUMBER -> new Value((int) (Math.random() * v.get(0).number()));
                case DOUBLE_NUMBER -> new Value(Math.random() * v.get(0).doubleNumber());
                case ARRAY -> Value.UNDEF;
            };
        }

        private static Value substr(GfxModeConfig c, List<Value> v) {
            if (v.size() < 2) {
                return v.get(0);
            }
            var s = v.get(0).string();
            var from = v.get(1).number();
            if (v.size() < 3) {
                if (from >= s.length()) {
                    return new Value("");
                }
                return new Value(s.substring(from));
            }
            var to = v.get(2).number();
            if (to <= from) {
                return new Value("");
            }
            if (to >= s.length()) {
                return new Value(s.substring(from));
            }
            return new Value(s.substring(from, to));
        }

        private final String token;
        private final BiFunction<GfxModeConfig, List<Value>, Value> function;
    }
}
