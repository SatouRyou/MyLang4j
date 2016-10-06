package MyLangJava.operator;

import MyLangJava.Engine;

import java.util.List;

/**
 * Created by teradashoutarou on 2016/09/30.
 */
public class GetOperator implements  OperatorInterface {
    @Override
    public Object call(Engine engine, List<?> args) {

        return engine.variables.get(args.get(0));
    }
}
