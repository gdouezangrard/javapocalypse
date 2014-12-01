package tec;

import tec.Transport;


public interface Usager {
  String nom();

  void monterDans(Transport b) throws TecInvalidException;
}
