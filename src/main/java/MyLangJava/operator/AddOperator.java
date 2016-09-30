package MyLangJava.operator;

import MyLangJava.Engine;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by teradashoutarou on 2016/09/30.
 */
public class AddOperator implements OperatorInterface {

    public Object call(Engine engine, List<?> args ) {
        BigDecimal retValue = BigDecimal.ZERO;
        for(Object arg: args){
            Object v = engine.eval(arg);
            retValue = retValue.add((BigDecimal)v);
        }
        return retValue;
    }
}
