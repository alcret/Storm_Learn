package trident.state;

import storm.trident.state.map.NonTransactionalMap;

public class OutbreakTrendState extends NonTransactionalMap<Long> {
    public OutbreakTrendState(OutbreakTrendBackingMap outbreakBackingMap) {
        super(outbreakBackingMap);
    }
}
