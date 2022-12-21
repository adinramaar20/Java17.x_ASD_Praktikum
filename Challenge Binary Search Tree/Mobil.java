public class Mobil {
  public int tahun;
  public String tipe;

  public Mobil(int tahun, String tipe) {
    this.tahun = tahun;
    this.tipe = tipe;
  }

  @Override
  public String toString() {
    return String.format("%s (%d)", this.tipe, this.tahun);
  }
}