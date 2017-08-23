import org.apache.calcite.rel.core.Calc;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple4;

/*
public class Calculator implements MapFunction<Tuple2<Double, Double>, Double> {

    public Double map(Tuple2<Double, Double> in) {
        return in.f0 * in.f1;
    }
}*/

public class Calculator implements MapFunction<Tuple4<Integer, Integer, Double, Double>, Tuple3<Integer, Integer, Double>> {

    public Tuple3<Integer, Integer, Double> map(Tuple4<Integer, Integer, Double, Double> in) {

        Tuple3<Integer, Integer, Double> Calc = new Tuple3<Integer,Integer,Double>();
        Calc.f0 = in.f0;
        Calc.f1 = in.f1;
        Calc.f2 = in.f2 * in.f3;
        return Calc;
    }
}