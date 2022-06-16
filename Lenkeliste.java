class Lenkeliste<T> implements Liste<T> {

  class Node {
    Node neste = null;
    Node forrige = null;
    T data;
    Node (T x) {
      data = x;  }
    Node() {
      data = null;
    }
  }
  private Node start = null;
  private Node slutt = null;
  private int counter = 0;
  // Node tomNode = new Node();

  @Override
  public void leggTil(T x) {

    Node ny = new Node(x);

    if (start == null) {
      // Ved første node vil både start- og sluttnode være den samme
      start = ny;
      slutt = ny;
    }
    else {

      ny.forrige = slutt;
      slutt.neste = ny;
      slutt = ny;
    }
    counter ++;
    // Legger til 1 på telleren når det legges til en node
  }

  @Override
  public T fjern() {
    if (counter == 0) {
      throw new UgyldigListeIndeks(-1);
    }

    T returnVerdi = start.data; // lager en returnverdi variabel
    start = start.neste; // setter start til å være nåværende start sin neste
    // start.forrige = null; // Setter forrige til null, siden start ikke har noen forrige
    counter --; // Trekker i fra 1 på telleren når det fjernes en node
    return returnVerdi;
  }


  @Override
  public T fjern(int pos) throws UgyldigListeIndeks {
    if (counter == 0) {
      throw new UgyldigListeIndeks(-1);
    }

    if (pos<0 || pos>=counter) {
      throw new UgyldigListeIndeks(pos);
      // Exception som kaster unntak dersom indeksen er for stor eller liten
    }
    if (pos == 0) {
      return this.fjern();
    }

    else if (pos == counter-1) {

      Node peker = start;
      for (int i = 0; i < pos; i++) {
        peker = peker.neste;
        // for-loop som går igjennom nodene til den er på riktig posisjon
      }
      peker.forrige.neste = null;
      counter --;
      // Trekker fra en på telleren ved fjerning av node
      return peker.data;
    }

    else {
      Node peker = start;
      for (int i = 0; i < pos; i++) {
        peker = peker.neste;
        // for-loop som går igjennom nodene til den er på riktig posisjon
      }
      peker.forrige.neste = peker.neste;
      peker.neste.forrige = peker.forrige;
      counter --;
      // Trekker fra en på telleren ved fjerning av node
      return peker.data;
    }
  }

  @Override
  public void sett(int pos, T x) throws UgyldigListeIndeks {
    if (pos<0 || pos>=counter) {
      throw new UgyldigListeIndeks(pos);
      // Exception som kaster unntak dersom indeksen er for stor eller liten
    }

    Node peker = start;
    for (int i = 0; i < pos; i++) {
      peker = peker.neste;
    }
    peker.data = x;
    // Gir peker sin data den nye verdien x som kommer inn som parameter.
  }

  @Override
  public void leggTil(int pos, T x) throws UgyldigListeIndeks {
    if (pos<0 || pos>counter) {
      throw new UgyldigListeIndeks(pos);
      // Exception som kaster unntak dersom indeksen er for stor eller liten
    }
    else if (pos == 0 && counter == 0 || pos == counter) {
      this.leggTil(x);
    }

    else if (pos == 0) {

      Node nyNode = new Node(x);
      nyNode.neste = start;
      start.forrige = nyNode;
      start = nyNode;
      counter ++;

    }
    else {

    Node nyNode = new Node(x);

    Node peker = start;
    for (int i = 0; i < pos; i++) {
      peker = peker.neste;
    }
    peker.forrige.neste = nyNode;
    nyNode.neste = peker;
    nyNode.forrige = peker.forrige;
    peker.forrige = nyNode;

    // Gir den nye noden riktige forrige og neste verdier, og peker riktig
    // forrige og neste verdier.
    counter ++;
    // Legger til 1 på telleren når det legges til en node
    }

  }

  @Override
  public int stoerrelse() {

    return counter;
  }

  @Override
  public T hent(int pos) throws UgyldigListeIndeks {
    if (pos<0 || pos>=counter) {
      throw new UgyldigListeIndeks(pos);
      // Exception som kaster unntak dersom indeksen er for stor eller liten
    }
    if (pos == 0) {
      return start.data;
    }
    else if (pos == counter-1) {
      return slutt.data;
    }

    else {

    Node peker = start;
    for (int i = 0; i < pos; i++) {
      peker = peker.neste;
    }
    return peker.data;
    }
  }

  @Override
  public String toString() {

    String alleData = "";

    Node peker = start;
    for (int i = 0; i < counter; i++) {
      peker = peker.neste;
      alleData = alleData+" "+peker.data;
    }
    return alleData;
  }


}
