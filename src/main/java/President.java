import com.google.auto.value.AutoValue;
import com.google.auto.value.extension.memoized.Memoized;

import java.time.LocalDate;

@AutoValue
public abstract class President {
    public enum Party {
        DEMOCRATIC,
        REPUBLICAN,
        DEMOCRATIC_REPUBLICAN
    }
    public abstract int getPresidency();
    public abstract String getPresident();
    public abstract LocalDate getTookOffice();
    public abstract LocalDate getLeftOffice();
    public abstract Party getParty();

    public static President create(int presidency, String president, LocalDate start, LocalDate end, Party party) {
        return new AutoValue_President(presidency, president, start, end, party);
    }

    @Memoized
    @Override
    public abstract String toString();
}
