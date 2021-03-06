package tec;

/**
 * Cette classe represente l'etat d'un passager dans un transport en commun.
 * Un passager a trois etats possibles : DEHORS, ASSIS et DEBOUT.
 *
 * Il y a un etat à l'exterieur du transport (DEHORS) et deux etats à 
 * l'intérieur (ASSIS, DEBOUT).
 *  
 * Les instances de cette classe sont des objets constants.
 *
 * @author Georgy
 * @since 2007-2014
 **/
class EtatPassager {

  private static final EtatPassager DEHORS = new EtatPassager();
  private static final EtatPassager ASSIS  = new EtatPassager();
  private static final EtatPassager DEBOUT = new EtatPassager();

  /**
   * Le passager est-il a l'exterieur du transport ?
   *
   * @return vrai si instanciation avec DEHORS;
   */
  public boolean estExterieur() {
    return this == DEHORS;
  }

  /**
   * Le passager est-il assis a l'interieur du transport ?
   *
   * @return vrai si instanciation avec ASSIS;
   */
  public boolean estAssis() {
    return this == ASSIS;
  }

  /**
   * Le passager est-il debout a l'interieur du transport ?
   *
   * @return vrai si instanciation avec DEBOUT;
   */
  public boolean estDebout() {
    return this == DEBOUT;
  }

  /**
   * Le passager est-il a l'interieur du transport ?
   *
   * @return vrai si instanciation avec ASSIS ou DEBOUT.
   */
  public boolean estInterieur() {
    return this == ASSIS || this == DEBOUT;
  }


  /**
   * Fournit une nouvelle instance d'EtatPassager.
   *
   * @return instance dans l'etat ASSIS.
   */
  public static EtatPassager assis() {
    return ASSIS; 
  }

  /**
   * Fournit une nouvelle instance d'EtatPassager.
   *
   * @return instance dans l'etat DEBOUT.
   */
  public static EtatPassager debout() {
    return DEBOUT;
  }

  /**
   * Fournit une nouvelle instance d'EtatPassager.
   *
   * @return instance dans l'etat DEHORS.
   */
  public static EtatPassager dehors() {
    return DEHORS;
  }

  /*
   * Cette methode est heritee de la classe {@link java.lang.Object}.
   * Tres utile pour le debogage, elle permet de fournir une 
   * chaine de caracteres correspondant a l'etat d'un objet.
   * <p> Un code par defaut est definit dans 
   * {@link java.lang.Object#toString() la classe Object} 
   * Il faut adapter (redefinir) le code de cette methode à chaque classe.
   */
  @Override
  public String toString() {
      String nom = null;
      if (this == DEHORS) {
          nom = "dehors";
      }
      else if (this == ASSIS) {
          nom = "assis";
      }
      else {
          nom = "debout";
      }
      return "<" + nom + ">";
  }
}
