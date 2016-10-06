package MyLangJava.operator;

import MyLangJava.Engine;

import java.util.List;

/**
 * Created by teradashoutarou on 2016/10/07.
 */
public class LambdaOperator implements OperatorInterface {
    @Override
    public Object call(Engine engine, List<?> args) {
        return new ProcOperator((List<?>)args.get(0), args.get(1));
    }
}
