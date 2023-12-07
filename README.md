Mise en contexte :

Vous avez comme projet de réimplémenter le dernier jeu à la mode : (Wordle)[https://fr.wikipedia.org/wiki/Wordle]. Votre première ébauche est faite en ligne de commande, mais dès que vos algorithmes seront au point, vous pensez en faire une (n-ième) version pour Android.

Vous avez définit les classes et fonctions minimales dont vous aurez besoin et vous avez bien sûr commencé par implémenter les tests qui les valident... et c'est là que vous êtes rendus. 

*La documentation des méthodes se trouve le répertoire doc/, lisez-la attentivement!*

# Mise en place :

1. Récupérez le projet

2. Créez votre divergence de l'ébauche de projet
   [Wordle](https://git.dti.crosemont.quebec/420-g55-ro/wordle).

3. *Rendez votre divergence privée* (Menu Paramètres/Général, section «Visibility, project features, permissions» dans «Project visibility», sélectionnez «Private» et «Enregistrer les modification» plus bas.)

4. Clonez votre divergence sur votre poste.
    
NB: *Ne faites pas de demande de fusion* (cela rendrait votre code visible à tous).
   
# À faire :

Il s'agit d'un projet Gradle que vous pouvez compiler en ligne de commande, dans IntelliJ, Android Studio ou tout autre IDE qui prend en charge Gradle.

Effectuez les tâches demandées dans les tickets #1, #2, #3 et #4. 

## Pour chaque ticket :

1. Créez une branche nommée «ticketX» où X est le numéro du ticket (`ticket1`, `ticket2`, etc.)

2. Effectuez la tâche demandée dans le ticket et commitez votre travail sur cette branche.

3. Poussez la branche ticketX. Le pipeline déclenché devrait réussir. Sinon, c'est qu'il y a un problème avec votre travail, continuez sur la même branche jusqu'à ce que le pipeline réussisse.

## Étape 0 : fusionnez la branche 1_constantes dans main

Réglez les éventuels conflits.

## Étape 1 : Assurez-vous d'avoir une classe compilable qui fait échouer tous les tests. Les méthodes devraient être déclarées sans être implémentées.

Résultat attendu du pipeline : L'étape `build` passe, l'étape `tests` échoue avec 15 tests échoués.

## Étape 2 : Implémentation :

### Ticket #1 : Implémentation du constructeur de Wordle

   [Ticket #1](https://git.dti.crosemont.quebec/420-g55-ro/wordle/-/issues/1)

Résultat attendu du pipeline : L'étape `tests` passe; tous les tests de `WordleConstructeurTest` réussissent :

### Ticket #2 : Implémenter les essais du joueur 

   [Ticket #2](https://git.dti.crosemont.quebec/420-g55-ro/wordle/-/issues/2)

Résultat attendu du pipeline : L'étape `tests` passe; tous les tests de `WordleEssayerTest` réussissent :

### Ticket #3 : Résumé des lettres essayées

   [Ticket #3](https://git.dti.crosemont.quebec/420-g55-ro/wordle/-/issues/3)

Résultat attendu du pipeline : L'étape `tests` passe; tous les tests de `WordleObtenirLettresTests` réussissent
  
### Ticket #4 : Tester la validation de la réussite d'une partie

   [Ticket #4](https://git.dti.crosemont.quebec/420-g55-ro/wordle/-/issues/4)

Résultat attendu du pipeline : L'étape `tests` passe; tous les tests de `WordleEstReussiTests` réussissent

## Étape finale

Fusionnez l'implémentation de tous les tickets dans `main`

Résultat attendu du pipeline : L'étape `tests` passe; *tous* les tests réussissent

# Notes:

Le résultat des tests vous assure que votre classe fonctionne comme prévu, cependant, vous devez aussi vous assurer de la qualité de votre code (suivre les normes de programmation, être lisible et optimisé)

Vos commits doivent être effectués correctement, c'est-à-dire que seules les modifications nécessaires doivent être commitées et les messages de commit doivent être brefs mais descriptifs de vos changements.
