import work.interfacefonctionnel.Calculateur;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
       // System.out.printf("Hello and welcome!");

        //Interface fonctionnel
        System.out.println("*************************************** Interface fonctionnel *****************************************");
        Calculateur addition = (a, b) -> a + b;
        System.out.println("Addition : "+addition.operation(5, 3));


        //Interfaces Fonctionnelles Prédéfinies en Java 8
        //Predicate<T> → Filtrage
        System.out.println("*************************************** Predicate<T> → Filtrage *****************************************");
        Predicate<Integer> estPair = n -> n % 2 == 0;
        System.out.println(estPair.test(10)); // Résultat : true
        System.out.println(estPair.test(11)); // Résultat : false

        //Function<T, R> → Transformation : Transforme un objet d'un type T en un autre type R.
        System.out.println("************************************* Function<T, R> → Transformation *********************************************");
        Function<String, Integer> longueur = s -> s.length();
        System.out.println(longueur.apply("Java 8")); // Résultat : 6

        //Consumer<T> → Exécuter une action : Exécute une opération sur un objet de type T, mais ne retourne rien.
        System.out.println("*************************************** Consumer<T> → Exécuter une action *****************************************");
        Consumer<String> afficher = s -> System.out.println("Bonjour " + s);
        afficher.accept("Alice"); // Résultat : Bonjour Alice

        //Supplier<T> → Fournir une valeur : Fournit une valeur sans paramètre d’entrée.
        System.out.println("*************************************** Supplier<T> → Fournir une valeur *****************************************");
        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get()); // Résultat : un nombre aléatoire

        //UnaryOperator<T> → Transformation sans changement de type : Applique une transformation sur un élément du même type.
        System.out.println("*************************************** UnaryOperator<T> → Transformation *****************************************");
        UnaryOperator<Integer> carre = n -> n * n;
        System.out.println(carre.apply(4)); // Résultat : 16

        ///Références de Méthodes avec Interfaces Fonctionnelles
        System.out.println("*************************************** Références de Méthodes avec Interfaces Fonctionnelles *****************************************");
        Consumer<String> print = System.out::println;
        print.accept("Hello World"); // Résultat : Hello World

        //Exemple Complet avec Plusieurs Interfaces Fonctionnelles
        System.out.println("*************************************** Exemple Complet avec Plusieurs Interfaces Fonctionnelles *****************************************");
        // Predicate : Vérifie si un nombre est positif
        Predicate<Integer> estPositif = n -> n > 0;
        System.out.println(estPositif.test(5));  // true
        System.out.println(estPositif.test(-3)); // false

        // Function : Convertir Celsius en Fahrenheit
        Function<Double, Double> celsiusToFahrenheit = c -> (c * 9/5) + 32;
        System.out.println(celsiusToFahrenheit.apply(0.0));  // 32.0

        // Consumer : Afficher un message
        Consumer<String> afficherMessage = message -> System.out.println("Message : " + message);
        afficherMessage.accept("Hello Java 8");

        // Supplier : Retourner un mot de passe aléatoire
        Supplier<String> genererMotDePasse = () -> "Java8-" + (int) (Math.random() * 1000);
        System.out.println(genererMotDePasse.get());

        // UnaryOperator : Doubler une valeur
        UnaryOperator<Integer> doubler = x -> x * 2;
        System.out.println(doubler.apply(10));  // 20

        //Expliquez ce qu'est un Stream et ses méthodes clés.
        System.out.println(" Quelle est la différence entre map() et flatMap() ?");
        List<List<Integer>> nested = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
        List<Integer> flatList = nested.stream().flatMap(List::stream).collect(Collectors.toList());
        // Résultat : [1, 2, 3, 4]

        //Comment fonctionnent les méthodes default dans les interfaces ?



        //Qu'est-ce que Optional en Java 8 ?


        //Qu'est-ce qu'une référence de méthode en Java 8 ? : •	C'est une abréviation des expressions lambda
        System.out.println("Qu'est-ce qu'une référence de méthode en Java 8 ?");
        List<String> noms = Arrays.asList("Alice", "Bob");
        noms.forEach(System.out::println); // Référence à println

        //Qu'est-ce que parallelStream() en Java 8 ? :•	parallelStream() permet d'exécuter un Stream en parallèle pour améliorer les performances.
        System.out.println("Qu'est-ce que parallelStream() en Java 8 ? ?");
        List<Integer> nombres = Arrays.asList(1, 2, 3);
        nombres.parallelStream().map(n -> n * 2).forEach(System.out::println);

        //Peut-on utiliser plusieurs filtres dans un seul Stream ?
        System.out.println("Peut-on utiliser plusieurs filtres dans un seul Stream ?");
        List<Integer> nombrs = Arrays.asList(1, 2, 3, 4, 5);
        nombrs.stream()
                .filter(n -> n > 2)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println); // Résultat : 4

        //Expliquez la méthode reduce() dans les Streams avec un exemple. : •	reduce() est utilisée pour agréger les éléments d'un Stream.
        System.out.println("Expliquez la méthode reduce() dans les Streams avec un exemple.");
        List<Integer> nombs = Arrays.asList(1, 2, 3, 4);
        int somme = nombs.stream().reduce(0, Integer::sum);
        System.out.println(somme); // Résultat : 10

        //Comment Java 8 gère-t-il les méthodes par défaut en cas d'héritage multiple ?
        System.out.println("Afficher une liste en utilisant les expressions lambda");
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(name -> System.out.println(name));

        //
        System.out.println("Filtrer les nombres pairs d'une liste en utilisant les Streams");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evens); // [2, 4, 6]
//
        System.out.println("Trouver la valeur maximale dans une liste en utilisant les Streams");
        List<Integer> nmbers = Arrays.asList(10, 20, 30, 40);
        int max = nmbers.stream()
                .max(Integer::compare)
                .orElse(0);
        System.out.println(max); // 40

        //
        System.out.println("Convertir une liste de chaînes en majuscules");
        List<String> nom = Arrays.asList("alice", "bob");
        List<String> upperNames = nom.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperNames); // [ALICE, BOB]

        //
        System.out.println("Regrouper des chaînes par leur longueur en utilisant groupingBy()");
        List<String> names1 = Arrays.asList("Alice", "Bob", "Charlie");
        Map<Integer, List<String>> grouped = names1.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(grouped); // {3=[Bob], 5=[Alice], 7=[Charlie]}

        //
        System.out.println("7. Compter le nombre d'occurrences de chaque mot dans une liste");

        List<String> words = Arrays.asList("apple", "banana", "apple");
        Map<String, Long> wordCount = words.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println(wordCount); // {apple=2, banana=1}

        //
        System.out.println("8. Concaténer des chaînes en utilisant joining()");
        List<String> words2 = Arrays.asList("Java", "est", "puissant");
        String sentence = words2.stream()
                .collect(Collectors.joining(" "));
        System.out.println(sentence); // Java est puissant

        //
        System.out.println("9. Trier des employés par salaire");
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 5000),
                new Employee("Bob", 3000),
                new Employee("Charlie", 4000)
        );

        List<Employee> sorted = employees.stream()
                .sorted(Comparator.comparingInt(e -> e.salary))
                .collect(Collectors.toList());

        System.out.println(sorted);
        // [Bob: 3000, Charlie: 4000, Alice: 5000]

        //
        System.out.println("Trouver le premier caractère non répété dans une chaîne");
        String input = "swiss";
        Character result = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(result); // w

        //
        //
        System.out.println("11. Supprimer les doublons d'une liste en utilisant Stream.distinct()");
        List<Integer> numbers1 = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinctNumbers = numbers1.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(distinctNumbers); // [1, 2, 3, 4, 5]

        //
        //
        System.out.println("12. Trouver tous les éléments commençant par \"A\" dans une liste");
        List<String> names2 = Arrays.asList("Alice", "Bob", "Annie", "Alex");
        List<String> filteredNames = names2.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println(filteredNames); // [Alice, Annie, Alex]

        //
        System.out.println("14. Aplatir une liste de listes en utilisant flatMap()");
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        List<Integer> flatList2 = nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(flatList2); // [1, 2, 3, 4, 5, 6, 7, 8]
        //
        System.out.println("15. Séparer les nombres pairs et impairs en utilisant partitioningBy()");
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> partitioned = numbers3.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println(partitioned); // {false=[1, 3, 5], true=[2, 4, 6]}

        //
        System.out.println("17.\tTrouver le deuxième plus grand nombre dans une liste");
        List<Integer> numbers4 = Arrays.asList(10, 20, 30, 40, 50);
        int secondHighest = numbers4.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1) // Ignorer le plus grand élément
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucun deuxième plus grand nombre trouvé"));

        System.out.println(secondHighest); // 40

        //
        System.out.println("18.\tCompter la fréquence des caractères dans une chaîne en utilisant les Streams");
        String input1 = "java";
        Map<Character, Long> frequency = input1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(frequency); // {a=2, j=1, v=1}

        //
        System.out.println("19.\tGénérer un flux infini de nombres pairs et le limiter à 10 éléments");
        List<Integer> numbers5 = Arrays.asList(10, 20, 30, 40);
        boolean allGreater = numbers5.stream().allMatch(n -> n > 5);

        System.out.println(allGreater); // true

        //
        System.out.println("20.\tCalculer la moyenne d'une liste de nombres");
        List<Integer> numbers6 = Arrays.asList(10, 20, 30, 40);
        double average = numbers6.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println(average); // 25.0

        //
        System.out.println("21.\tRegrouper les employés par département en utilisant Collectors.groupingBy()");
        List<Employee2> employees2 = Arrays.asList(
                new Employee2("Alice", "RH"),
                new Employee2("Bob", "IT"),
                new Employee2("Charlie", "RH"),
                new Employee2("David", "IT")
        );

        Map<String, List<Employee2>> groupedByDepartment = employees2.stream()
                .collect(Collectors.groupingBy(emp -> emp.department));

        groupedByDepartment.forEach((dept, emps) -> {
            System.out.println(dept + ": " + emps.stream().map(e -> e.name).collect(Collectors.toList()));
        });

        // Sortie :
        // RH: [Alice, Charlie]
        // IT: [Bob, David]

        //
        System.out.println("22.\tCompter les occurrences de chaque mot dans une phrase");
        String sentence2 = "Java est puissant et Java est populaire";
        Map<String, Long> wordCount2 = Arrays.stream(sentence2.split(" "))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        System.out.println(wordCount2);
        // Sortie : {Java=2, est=2, puissant=1, et=1, populaire=1}

        //
        System.out.println("23.\tTrouver le mot le plus long dans une liste");
        List<String> words3 = Arrays.asList("pomme", "banane", "cerise", "datte");
        String longestWord = words3.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);

        System.out.println(longestWord); // banane

        //
        System.out.println("24.\tFusionner deux listes en une seule en utilisant flatMap()");
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);

        List<Integer> mergedList = Stream.of(list1, list2)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(mergedList); // [1, 2, 3, 4, 5, 6]

        //
        System.out.println("25.\tTrouver le premier élément d'un Stream supérieur à 10");
        List<Integer> numbers7 = Arrays.asList(5, 8, 12, 3, 20);
        int first = numbers7.stream()
                .filter(n -> n > 10)
                .findFirst()
                .orElse(-1);

        System.out.println(first); // 12

        //
        System.out.println("26.\tTrouver la valeur minimale dans une liste en utilisant Streams");
        List<Integer> numbers8 = Arrays.asList(10, 20, 5, 15);
        int min = numbers8.stream()
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("Aucun minimum trouvé"));

        System.out.println(min); // 5

        //
        System.out.println("28.\tUtiliser Stream.generate() pour créer une liste de nombres aléatoires");
        List<Double> randomNumbers = Stream.generate(Math::random)
                .limit(5)
                .collect(Collectors.toList());

        System.out.println(randomNumbers);

        System.out.println("29.\tTrouver les éléments dupliqués dans une liste en utilisant les Streams");
        List<Integer> numbers9 = Arrays.asList(1, 2, 3, 4, 5, 2, 3);
        Set<Integer> duplicates = numbers9.stream()
                .filter(n -> Collections.frequency(numbers9, n) > 1)
                .collect(Collectors.toSet());

        System.out.println(duplicates); // [2, 3]


    }
}
//Comment Java 8 gère-t-il les méthodes par défaut en cas d'héritage multiple ?
interface A {
    default void afficher() {
        System.out.println("A");
    }
}
interface B {
    default void afficher() {
        System.out.println("B");
    }
}
class C implements A, B {
    public void afficher() {
        A.super.afficher();
    } // Résout le conflit
}


///
class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return name + ": " + salary;
    }

}
class Employee2 {
    String name;
    String department;

    Employee2(String name, String department) {
        this.name = name;
        this.department = department;
    }
}
