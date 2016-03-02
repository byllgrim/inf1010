Testing og kjoering
===================
Se Makefile

Testing skal ikke gi noe output hvis alt gaar bra.
Hvis den henger har noe galt skjedd.

Hvor lang tid tok det?
======================
Veldig lang tid. Sikkert noen dager til sammen.

TODO
====
Masse strings er sammenlignet med compareTo() istedenfor equals(), fiks det.

Complaints
==========
Vi definerer grensesnitt med prefiksen 'Abstract'.
Det er misvisende ettersom de ikke er abstrakte klasser.
De kunne vaert navngitt bedre eller hatt prefiksen 'Grensesnitt'

SortertEnkelListe hoeres ut som en generell liste.
Navnet samsvarer ikke med faktum at den er svaert begrenset.

Disclaimer
==========
Datastrukturtegningen mangler flere members og metoder som ikke er relevante.

SortertEnkelListe har mange @SuppressWarnings("unchecked") fordi jeg aksesserer
medlemmer direkte. Ved aa bruke hent/sett metoder kunne jeg typesjekke.
Jeg velger aa ikke gjoere det fordi jeg ikke enda har forstaatt forskjellen
mellom objekter og datastrukturer.
