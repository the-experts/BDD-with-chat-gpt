Feature: Rekenmachine

  Scenario: Optellen van twee getallen
    Given de rekenmachine is ingeschakeld
    When ik twee getallen invoer: 5 en 3
    And ik de optelknop indruk
    Then zou de uitvoer gelijk moeten zijn aan 8

  Scenario: Optellen van meer dan twee getallen
    Given de rekenmachine is ingeschakeld
    When ik meerdere getallen invoer: 5, 3, 2 en 1
    And ik de optelknop indruk
    Then zou de uitvoer gelijk moeten zijn aan 11

  Scenario: Optellen van decimalen
    Given de rekenmachine is ingeschakeld
    When ik twee decimalen invoer: 3.14 en 2.5
    And ik de optelknop indruk
    Then zou de uitvoer gelijk moeten zijn aan 5.64

  Scenario: Optellen van negatieve getallen
    Given de rekenmachine is ingeschakeld
    When ik twee negatieve getallen invoer: -5 en -3
    And ik de optelknop indruk
    Then zou de uitvoer gelijk moeten zijn aan -8

  Scenario: Aftrekken van twee getallen
    Given de rekenmachine is ingeschakeld
    When ik twee getallen invoer: 7 en 3
    And ik de aftrekknop indruk
    Then zou de uitvoer gelijk moeten zijn aan 4

  Scenario: Aftrekken van decimalen
    Given de rekenmachine is ingeschakeld
    When ik twee decimalen invoer: 4.5 en 2.1
    And ik de aftrekknop indruk
    Then zou de uitvoer gelijk moeten zijn aan 2.4

  Scenario: Aftrekken van negatieve getallen
    Given de rekenmachine is ingeschakeld
    When ik twee getallen invoer: -7 en -3
    And ik de aftrekknop indruk
    Then zou de uitvoer gelijk moeten zijn aan -4

  Scenario: Vermenigvuldigen van twee getallen
    Given de rekenmachine is ingeschakeld
    When ik twee getallen invoer: 4 en 3
    And ik de vermenigvuldigknop indruk
    Then zou de uitvoer gelijk moeten zijn aan 12

  Scenario: Vermenigvuldigen van meer dan twee getallen
    Given de rekenmachine is ingeschakeld
    When ik meerdere getallen invoer: 4, 3, 2 en 1
    And ik de vermenigvuldigknop indruk
    Then zou de uitvoer gelijk moeten zijn aan 24

  Scenario: Vermenigvuldigen van decimalen
    Given de rekenmachine is ingeschakeld
    When ik twee decimalen invoer: 1.5 en 2.5
    And ik de vermenigvuldigknop indruk
    Then zou de uitvoer gelijk moeten zijn aan 3.75

  Scenario: Vermenigvuldigen van negatieve getallen
    Given de rekenmachine is ingeschakeld
    When ik twee getallen invoer: -4 en 3
    Then zou de uitvoer gelijk moeten zijn aan -12

  Scenario: Berekenen van goniometrische functies
    Given de rekenmachine is ingeschakeld
    When Ik voer 0 in
    And ik de sinusknop indruk
    Then zou de uitvoer gelijk moeten zijn aan 0

    Given de rekenmachine is ingeschakeld
    When Ik voer 45 in
    And ik de sinusknop indruk
    Then zou de uitvoer gelijk moeten zijn aan 0.8509035245341184

    Given de rekenmachine is ingeschakeld
    When Ik voer 1 in
    And ik de cosinuskop indruk
    Then zou de uitvoer gelijk moeten zijn aan 0.5403023058681398

    Given de rekenmachine is ingeschakeld
    When Ik voer 60 in
    And ik de cosinuskop indruk
    Then zou de uitvoer gelijk moeten zijn aan -0.9524129804151563

    Given de rekenmachine is ingeschakeld
    When Ik voer 1 in
    And ik de tangensknop indruk
    Then zou de uitvoer gelijk moeten zijn aan 1.557407724654902

    Given de rekenmachine is ingeschakeld
    When Ik voer 45 in
    And ik de tangensknop indruk
    Then zou de uitvoer gelijk moeten zijn aan 1.6197751905438615
