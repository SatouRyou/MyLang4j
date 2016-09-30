package MyLangJava.Expression;

import MyLangJava.Engine;
import MyLangJava.operator.OperatorInterface;

import java.util.List;

/**
 * Created by teradashoutarou on 2016/09/29.
 */
public class CallOperator implements ExpressionInterface {

    private OperatorInterface operator;
    private List<?> args;

    public CallOperator(OperatorInterface operator, List<?> args){
        this.operator = operator;
        this.args = args;
    }

    @Override
    public Object eval( Engine engine ) {
        return operator.call( engine, args );
    }
}
