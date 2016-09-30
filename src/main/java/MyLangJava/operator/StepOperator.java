package MyLangJava.operator;

import MyLangJava.Engine;

import java.util.List;

/**
 * Created by teradashoutarou on 2016/09/30.
 */
public class StepOperator implements OperatorInterface {
    @Override
    public Object call(Engine engine, List<?> args) {
        Object retVal = null;
        for (Object arg : args) {
            retVal = engine.eval(arg);
        }
        return retVal;
    }
}
