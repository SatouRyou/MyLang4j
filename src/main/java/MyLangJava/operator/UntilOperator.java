package MyLangJava.operator;

import MyLangJava.Engine;

import java.util.List;

/**
 * Created by teradashoutarou on 2016/09/30.
 */
public class UntilOperator implements OperatorInterface {
    @Override
    public Object call(Engine engine, List<?> args) {
        Object retVal = null;
        while(!(Boolean)engine.eval(args.get(0))){
            retVal = engine.eval(args.get(1));
        }
        return retVal;
    }
}
