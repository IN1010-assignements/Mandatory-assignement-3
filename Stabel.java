class Stabel<T> extends Lenkeliste<T> {

  public void leggPaa(T x) {

    this.leggTil(x);
  }

  public T taAv() {

    return this.fjern(this.stoerrelse()-1);
  }
}
