import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.values.PCollection;

import java.net.URL;

public class BeamIO {
    public static void main(String[] args) {
        Pipeline pipeline = Pipeline.create();
        PCollection<String> output = pipeline.apply(TextIO.read().from(getInputURL().getPath()));
        output.apply("write", TextIO.write().to("president_copy").withoutSharding().withSuffix(".csv"));

        pipeline.run();
    }

    public static URL getInputURL() {
        return BeamIO.class.getResource("presidents.csv");
    }
}
