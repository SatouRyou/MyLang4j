package MyLangJava.operator;

import MyLangJava.Engine;

import java.util.List;

/**
 * Created by teradashoutarou on 2016/09/30.
 */
public class EqualOperator implements OperatorInterface {
    @Override
    public Object call(Engine engine, List<?> args) {
        return engine.eval(args.get(0)).equals(engine.eval(args.get(1)));
    }
}
