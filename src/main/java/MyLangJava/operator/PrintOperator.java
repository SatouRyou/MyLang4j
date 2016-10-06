package MyLangJava.operator;

import MyLangJava.Engine;

import java.util.List;

/**
 * Created by teradashoutarou on 2016/10/06.
 */
public class PrintOperator implements OperatorInterface {
    @Override
    public Object call(Engine engine, List<?> args) {
        Object value = engine.eval(args.get(0)).toString();
        System.out.println(value);
        return value;
    }
}
