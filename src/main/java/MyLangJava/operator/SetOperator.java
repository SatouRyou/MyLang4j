package MyLangJava.operator;

import MyLangJava.Engine;

import java.util.List;

/**
 * Created by teradashoutarou on 2016/09/30.
 */
public class SetOperator implements OperatorInterface {
    @Override
    public Object call(Engine engine, List<?> args) {
        return engine.setVariable( (String)args.get(0), engine.eval(args.get(1) ));
    }
}
