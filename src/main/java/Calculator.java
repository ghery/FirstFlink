import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple4;

/*
public class Calculator implements MapFunction<Tuple2<Double, Double>, Double> {

    public Double map(Tuple2<Double, Double> in) {
        return in.f0 * in.f1;
    }
}*/

public class Calculator implements MapFunction<Tuple4<Integer, Integer, Double, Double>, Double> {

    public Double map(Tuple4<Integer, Integer, Double, Double> in) {
        return in.f2 * in.f3;
    }
}