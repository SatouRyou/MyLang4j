package MyLangJava;

import MyLangJava.operator.OperatorInterface;

import java.util.List;

/**
 * Created by teradashoutarou on 2016/10/11.
 */
public class Closure {
    private Engine engine;
    private OperatorInterface operator;

    public Closure(Engine engine, OperatorInterface operator){
        this.engine = engine;
        this.operator = operator;
    }

    public Object eval(List<?> args){
        return operator.call(engine, args);
    }
}
