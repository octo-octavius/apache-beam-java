import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
abstract class $AutoValue_President extends President {

  private final int presidency;

  private final String president;

  private final LocalDate tookOffice;

  private final LocalDate leftOffice;

  private final President.Party party;

  $AutoValue_President(
      int presidency,
      String president,
      LocalDate tookOffice,
      LocalDate leftOffice,
      President.Party party) {
    this.presidency = presidency;
    if (president == null) {
      throw new NullPointerException("Null president");
    }
    this.president = president;
    if (tookOffice == null) {
      throw new NullPointerException("Null tookOffice");
    }
    this.tookOffice = tookOffice;
    if (leftOffice == null) {
      throw new NullPointerException("Null leftOffice");
    }
    this.leftOffice = leftOffice;
    if (party == null) {
      throw new NullPointerException("Null party");
    }
    this.party = party;
  }

  @Override
  public int getPresidency() {
    return presidency;
  }

  @Override
  public String getPresident() {
    return president;
  }

  @Override
  public LocalDate getTookOffice() {
    return tookOffice;
  }

  @Override
  public LocalDate getLeftOffice() {
    return leftOffice;
  }

  @Override
  public President.Party getParty() {
    return party;
  }

  @Override
  public String toString() {
    return "President{"
        + "presidency=" + presidency + ", "
        + "president=" + president + ", "
        + "tookOffice=" + tookOffice + ", "
        + "leftOffice=" + leftOffice + ", "
        + "party=" + party
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof President) {
      President that = (President) o;
      return this.presidency == that.getPresidency()
          && this.president.equals(that.getPresident())
          && this.tookOffice.equals(that.getTookOffice())
          && this.leftOffice.equals(that.getLeftOffice())
          && this.party.equals(that.getParty());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= presidency;
    h$ *= 1000003;
    h$ ^= president.hashCode();
    h$ *= 1000003;
    h$ ^= tookOffice.hashCode();
    h$ *= 1000003;
    h$ ^= leftOffice.hashCode();
    h$ *= 1000003;
    h$ ^= party.hashCode();
    return h$;
  }

}
