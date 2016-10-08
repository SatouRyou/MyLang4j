package MyLangJava.operator;

import MyLangJava.Engine;

import java.util.List;

/**
 * Created by teradashoutarou on 2016/10/07.
 */
public class DefineOperator implements OperatorInterface {
    @Override
    public Object call(Engine engine, List<?> args) {
        return engine.defineVariable(
                (String)args.get(0),
                engine.eval(args.get(1)));
    }
}
