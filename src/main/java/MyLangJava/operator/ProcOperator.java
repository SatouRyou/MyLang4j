package MyLangJava.operator;

import MyLangJava.Engine;

import java.util.List;

/**
 * Created by teradashoutarou on 2016/10/07.
 */
public class ProcOperator implements OperatorInterface {

    private List<?> argNames;
    private Object procedure;

    public ProcOperator(List<?> argNames, Object procedure){
        this.argNames = argNames;
        this.procedure = procedure;
    }

    @Override
    public Object call(Engine engine, List<?> args) {
        Engine _engine = new Engine(engine);
        return _engine.eval(procedure);
    }
}
