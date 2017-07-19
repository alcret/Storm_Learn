package trident.operator;

import com.esotericsoftware.minlog.Log;
import storm.trident.operation.BaseFunction;
import storm.trident.operation.TridentCollector;
import storm.trident.tuple.TridentTuple;

public class DispatchAlert extends BaseFunction {
    private static final long serialVersionUID = 1L;

    public void execute(TridentTuple tuple, TridentCollector collector) {
        String alert = (String) tuple.getValue(0);
        Log.error("ALERT RECEIVED [" + alert + "]");
        Log.error("Dispatch the national guard!!!");
        System.out.println("运行结束===================");
        System.exit(0);
    }
}
