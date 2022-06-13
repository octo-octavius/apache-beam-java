import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.schemas.Schema;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.Row;
import org.apache.beam.sdk.values.TypeDescriptors;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryPC {
    private static final Schema PRESIDENT_SCHEMA = Schema.of(
            Schema.Field.of("Presidency", Schema.FieldType.INT32),
            Schema.Field.of("President", Schema.FieldType.STRING),
            Schema.Field.of("Start", Schema.FieldType.STRING),
            Schema.Field.of("End", Schema.FieldType.STRING),
            Schema.Field.of("Party", Schema.FieldType.STRING)
    );
    public static void main(String[] args) {

        //System.out.println(getPresidents().get(1).toString());
        Pipeline p = Pipeline.create();

        PCollection<Row> inputPC = p.apply(Create.of(getPresidents()).withRowSchema(PRESIDENT_SCHEMA));
        PCollection<String> inputStrPC = inputPC.apply(MapElements.into(TypeDescriptors.strings()).via(Row::toString));
        inputStrPC.apply(TextIO.write().to("presidents_inmemory").withoutSharding().withSuffix(".csv"));
        p.run();
    }

    private static List<Row> getPresidents() {
        List<President> presidents = List.of(
                President.create(43, "George W. Bush", LocalDate.of(2001, 01, 20), LocalDate.of(2009, 01, 20), President.Party.REPUBLICAN),
                President.create(43, "Bill Clinton", LocalDate.of(1993, 01, 20), LocalDate.of(2001, 01, 20), President.Party.DEMOCRATIC)
        );

        return presidents.stream().map((president ->
                Row.withSchema(PRESIDENT_SCHEMA)
                        .addValue(president.getPresidency())
                        .addValue(president.getPresident())
                        .addValue(president.getTookOffice().toString())
                        .addValue(president.getLeftOffice().toString())
                        .addValue(president.getParty().toString()).build()
        )).collect(Collectors.toList());

    }
}
