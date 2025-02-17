# Java 8 - Concepts Clés et Fonctionnalités

## 1. Quelles sont les principales fonctionnalités introduites dans Java 8 ?
Java 8 a introduit plusieurs fonctionnalités majeures, notamment :
- Expressions lambda
- Interfaces fonctionnelles
- API Stream
- Optional
- Nouvelle API Date et Heure (java.time)
- Méthodes par défaut dans les interfaces
- Références de méthode
- Collectors
- parallelStream

## 2. Qu'est-ce qu'une interface fonctionnelle ?
Une interface fonctionnelle est une interface qui ne contient qu'une seule méthode abstraite. Elle peut contenir des méthodes par défaut et statiques. Elle est souvent utilisée avec les expressions lambda. Exemple :
```java
@FunctionalInterface
interface MyFunctionalInterface {
    void execute();
}
```

## 3. Expliquez ce qu'est un Stream et ses méthodes clés.
Un Stream est une séquence d'éléments qui supporte des opérations fonctionnelles comme `map`, `filter`, `reduce`. Il peut être parallèle ou séquentiel.
Méthodes clés :
- `filter(Predicate<T>)`
- `map(Function<T, R>)`
- `flatMap(Function<T, Stream<R>>)`
- `collect(Collector<T, A, R>)`
- `reduce(BinaryOperator<T>)`

## 4. Quelle est la différence entre map() et flatMap() ?
- `map()` transforme chaque élément en un autre élément.
- `flatMap()` transforme chaque élément en un Stream et aplatit les résultats.

Exemple :
```java
List<String> list = Arrays.asList("Hello", "World");
list.stream().map(String::toUpperCase).forEach(System.out::println);
```

## 5. Qu'est-ce que Optional en Java 8 ?
`Optional<T>` est une classe conteneur pour éviter les `NullPointerException`.

Exemple :
```java
Optional<String> opt = Optional.ofNullable("Hello");
opt.ifPresent(System.out::println);
```

## 6. Comment fonctionnent les méthodes default dans les interfaces ?
Les méthodes par défaut (`default`) permettent d’ajouter des fonctionnalités sans casser les implémentations existantes.
```java
interface MyInterface {
    default void show() {
        System.out.println("Default method");
    }
}
```

## 7. Quel est le rôle des Collectors ?
Les `Collectors` permettent d’agréger des résultats des Streams.
Exemple :
```java
List<String> list = Arrays.asList("a", "b", "c");
String result = list.stream().collect(Collectors.joining(","));
```

## 8. En quoi l'API Date et Heure de Java 8 diffère-t-elle de java.util.Date ?
L’API `java.time` introduit `LocalDate`, `LocalTime`, `LocalDateTime`, `Instant` qui sont immuables et thread-safe.

## 9. Qu'est-ce qu'une référence de méthode en Java 8 ?
Une référence de méthode (`::`) est une syntaxe alternative aux expressions lambda.
```java
list.forEach(System.out::println);
```

## 10. Qu'est-ce que parallelStream() en Java 8 ?
`parallelStream()` exécute les opérations en parallèle pour améliorer les performances.

## 11. Quelle est la différence entre Stream.findFirst() et Stream.findAny() ?
- `findFirst()` retourne le premier élément.
- `findAny()` retourne un élément arbitraire, optimisé pour les flux parallèles.

## 12. Quels sont les différents types de Stream en Java 8 ?
- `IntStream`, `LongStream`, `DoubleStream` (Streams primitifs)
- `Stream<T>` (générique)

## 13. Peut-on utiliser plusieurs filtres dans un seul Stream ?
Oui, plusieurs filtres peuvent être chaînés.
```java
stream.filter(x -> x > 10).filter(x -> x < 50);
```

## 14. Expliquez la méthode reduce() dans les Streams avec un exemple.
`reduce()` permet d’agréger des valeurs.
```java
int sum = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
```

## 15. Comment Java 8 gère-t-il les méthodes par défaut en cas d'héritage multiple ?
Si deux interfaces fournissent la même méthode par défaut, la classe doit la redéfinir explicitement.

## 16. Quelles sont les bonnes pratiques pour utiliser les Streams en Java 8 ?
- Privilégier les Streams parallèles pour les grandes collections.
- Éviter d’abuser de `map` et `flatMap` pour améliorer la lisibilité.
- Utiliser `Collectors` pour l’agrégation.
- Préférer `Optional` aux valeurs nulles.

