
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.api.java.operators.ProjectOperator;
import org.apache.flink.api.java.operators.ReduceOperator;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple4;
import org.apache.flink.api.java.tuple.builder.Tuple12Builder;
import org.apache.flink.table.runtime.aggregate.DistinctReduce;


@SuppressWarnings("serial")
public class FirstFlink {

    // *************************************************************************
    //     PROGRAM
    // *************************************************************************

     static public void main(String[] args) throws Exception {

        // Creation de l'environement
        ExecutionEnvironment Env = ExecutionEnvironment.getExecutionEnvironment();

        // recupreation des donnee dans un CSV
        //DataSet<Tuple2<Double, Double>> database = Env.readCsvFile("C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Data\\Flinkl.csv")
          //      .types(Double.class, Double.class);

         DataSet<Tuple4<Integer, Integer, Double, Double>> database = Env.readCsvFile("C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Data\\Flinke.csv")
                 .types(Integer.class, Integer.class, Double.class, Double.class);
        //ProjectOperator<?, Tuple> total = database.project(1);

        //ProjectOperator<?, Tuple> count = database.project(0);

        //total.print();
       // count.print();
        database.print();

        //Multipication des prix pas les quantites
        DataSet<Tuple3<Integer, Integer, Double>> Rest = database.map(new Calculator());


        // ReduceOperator<Double> sum = Rest.reduce((a, b)->a+b); //lambda pour add les result

       //Reduce et print

         //put reduce here
         ReduceOperator<Tuple3<Integer, Integer, Double>> output = Rest
                 .groupBy(0)
                 .reduce(new Reduce());
         Rest.print();
         output.print();
    }
}