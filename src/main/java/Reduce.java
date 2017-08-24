import org.apache.calcite.rel.core.Calc;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple4;




public class Reduce implements ReduceFunction<Tuple3<Integer, Integer, Double>> {

    @Override
    public Tuple3<Integer, Integer, Double> reduce(Tuple3<Integer, Integer, Double> in, Tuple3<Integer, Integer, Double> out) throws Exception {
        Double sum;

        // sum up all in one book
        sum = in.f2 + in.f2;
        out = new Tuple3<Integer, Integer, Double>(in.f0, in.f1, sum);
        return out;
    }
}