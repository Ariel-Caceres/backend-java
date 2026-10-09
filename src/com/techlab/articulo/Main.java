package com.techlab.articulo;

import java.util.ArrayList;
import java.util.Scanner;
import com.techlab.articulo.model.Category;

import com.techlab.articulo.model.Article;
import com.techlab.articulo.model.ElectronicArticle;

public class Main {
    public static void preloadCategories(ArrayList<Category> categories) {
        categories.add(new Category(1, "Electrónica", "Productos tecnológicos y electrónicos"));
        categories.add(new Category(2, "Periféricos", "Accesorios para computadora"));
        categories.add(new Category(3, "Alimentos", "Productos alimenticios"));
        categories.add(new Category(3, "Limpieza", "Artículos de limpieza del hogar"));

    }

    public static void articlesList(ArrayList<Article> articles) {
        if (articles.size() == 0) {
            System.out.println("No hay artículos cargados");
        } else {
            for (Article article : articles) {
                System.out.println(article);
            }
        }
    }

    public static void consultArticle(Scanner scanner, ArrayList<Article> articles) {
        System.out.println("Ingrese el código del articulo");
        int code = scanner.nextInt();
        for (Article article : articles) {
            if (article.getCode() == code) {
                System.out.println(article);
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Article> articles = new ArrayList<>();
        ArrayList<Category> categories = new ArrayList<>();
        preloadCategories(categories);
        int option = 0;
        do {
            System.out.println("====================");
            System.out.println("SISTEMA DE ARTÍCULOS");
            System.out.println("====================");
            System.out.println("1) Ingresar Articulo");
            System.out.println("2) Listar Articulo");
            System.out.println("3) Consultar Articulo");
            System.out.println("4) Modificar Articulo");
            System.out.println("5) Eliminar Articulo");
            System.out.println("6) Listar Categorías");
            System.out.println("0) Salir");
            System.out.println("====================");
            System.out.println("Seleccione una opción");

            switch (option) {
                case 1:
                    System.out.println("1) Ingresar Articulo electrónico");
                    System.out.println("2) Ingresar Articulo alimenticio");
                    System.out.println("Seleccione un tipo de articulo:");
                    int articleType = scanner.nextInt();
                    if (articleType == 1) {
                        System.out.println("====================");
                        System.out.println("Ingrese el código del articulo electrónico:");
                        System.out.println("====================");

                        int code = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("====================");
                        System.out.println("Ingrese el nombre del articulo electrónico:");
                        System.out.println("====================");

                        String name = scanner.nextLine();

                        System.out.println("====================");
                        System.out.println("Ingrese el precio del articulo electrónico:");
                        System.out.println("====================");
                        double price = scanner.nextDouble();

                        System.out.println("====================");
                        System.out.println("Ingrese la garantía en meses del articulo electrónico:");
                        System.out.println("====================");
                        int warrantyMonth = scanner.nextInt();

                        System.out.println("Categorías disponibles:");

                        for (Category category : categories) {
                            System.out.println(
                                    category.getCode() + ") " + category.getName());
                        }

                        System.out.println("Seleccione el código de la categoría:");
                        int categoryCode = scanner.nextInt();

                        Category selectedCategory = null;

                        for (Category category : categories) {
                            if (category.getCode() == categoryCode) {
                                selectedCategory = category;
                                break;
                            }
                        }

                        if (selectedCategory == null) {
                            System.out.println("Categoría no válida");
                        } else {
                            ElectronicArticle article = new ElectronicArticle(
                                    code, name, price, selectedCategory, warrantyMonth);

                            articles.add(article);

                            System.out.println("====================");
                            System.out.println("¡Articulo creado con éxito!");
                            System.out.println("====================");
                            System.out.println(article.toString());
                        }

                    }
                    if (articleType == 2) {
                        System.out.println("Ingrese el código del articulo alimenticio:");
                    }

                    break;
                case 2:
                    articlesList(articles);
                    System.out.println("");

                    break;
                case 3:
                    System.out.println("");

                    break;

                default:
                    break;
            }

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
            } else {
                System.out.println("Debe ingresar un número");
                scanner.next();
            }

        } while (option != 0);

    }
}