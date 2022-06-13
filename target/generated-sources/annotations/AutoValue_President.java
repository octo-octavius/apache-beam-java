import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.extension.memoized.processor.MemoizeExtension")
final class AutoValue_President extends $AutoValue_President {
  @LazyInit
  @SuppressWarnings("Immutable")
  private transient volatile String toString;

  AutoValue_President(int presidency$, String president$, LocalDate tookOffice$,
      LocalDate leftOffice$, President.Party party$) {
    super(presidency$, president$, tookOffice$, leftOffice$, party$);
  }

  @Override
  public String toString() {
    if (toString == null) {
      synchronized (this) {
        if (toString == null) {
          toString = super.toString();
          if (toString == null) {
            throw new NullPointerException("toString() cannot return null");
          }
        }
      }
    }
    return toString;
  }
}
