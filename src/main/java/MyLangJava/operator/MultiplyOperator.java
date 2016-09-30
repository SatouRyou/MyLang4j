package MyLangJava.operator;

import MyLangJava.Engine;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by teradashoutarou on 2016/09/30.
 */
public class MultiplyOperator implements OperatorInterface {
    @Override
    public Object call(Engine engine, List<?> args) {
        BigDecimal retValue = BigDecimal.ONE;
        for(Object arg: args){
            Object v = engine.eval(arg);
            retValue = retValue.multiply((BigDecimal)v);
        }
        return retValue;
    }
}
