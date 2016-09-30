package MyLangJava.Expression;

import MyLangJava.Engine;

/**
 * Created by teradashoutarou on 2016/09/29.
 */
public class ImmediateValue implements ExpressionInterface {

    private Object value;

    public ImmediateValue(Object value){

        this.value = value;
    }
    @Override
    public Object eval( Engine engine ) {

        return value;
    }
}
