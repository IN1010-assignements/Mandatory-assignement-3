class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {

  @Override
  public void leggTil(T x) {

    if (stoerrelse() == 0) {
      // Tom liste, setter inn nytt element
      super.leggTil(x);
      return;
    }
    for (int i = 0; i < stoerrelse(); i++) {

      if (hent(i).compareTo(x) > 0) {
        // Finner den korrekte plassen for det nye elementet

        super.leggTil(i, x);
        return;
        // Setter inn nytt element på rikitg plass
        }
      }
      super.leggTil(x);
      return;

  }

  @Override
  public T fjern() {
    if (stoerrelse() == 1) {
      return super.fjern();
    }

    else {
      return super.fjern(stoerrelse()-1);
    }
  }

  @Override
  public void sett(int pos, T x) throws UnsupportedOperationException {

    throw new UnsupportedOperationException();
  }

  @Override
  public void leggTil(int pos, T x) throws UnsupportedOperationException {

    throw new UnsupportedOperationException();
  }

}
