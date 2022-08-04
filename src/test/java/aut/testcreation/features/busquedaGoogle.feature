Feature: Busquedas Google
  Se realizaran una serie de busquedas desde la pagina principal de google

  @aut
  Scenario: Buscar Tsoft
    Given que estoy en el Home de Google
    When busco la palabra "Tsoft" en el navegador
    And presiono el boton buscar
    Then me lleva a la pagina de resultados