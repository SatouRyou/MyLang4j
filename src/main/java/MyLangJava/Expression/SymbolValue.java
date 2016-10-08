package MyLangJava.Expression;

import MyLangJava.Engine;

/**
 * Created by teradashoutarou on 2016/10/06.
 */
public class SymbolValue implements ExpressionInterface {

    private String symbol;

    public SymbolValue(String symbol){
        this.symbol = symbol;
    }

    @Override
    public Object eval(Engine engine) {
        return engine.getVariable( this.symbol );
    }
}
