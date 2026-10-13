package com.techlab.articulo;

import java.util.ArrayList;
import java.util.Scanner;
import com.techlab.articulo.model.Category;

import com.techlab.articulo.model.Article;
import com.techlab.articulo.model.ElectronicArticle;
import com.techlab.articulo.model.FoodArticle;

public class Main {
    public static void preloadCategories(ArrayList<Category> categories) {
        categories.add(new Category(1, "Electrónica", "Productos tecnológicos y electrónicos"));
        categories.add(new Category(2, "Periféricos", "Accesorios para computadora"));
        categories.add(new Category(3, "Alimentos", "Productos alimenticios"));
        categories.add(new Category(3, "Limpieza", "Artículos de limpieza del hogar"));

    }

    public static void preloadArticles(ArrayList<Article> articles, ArrayList<Category> categories) {
        Category electronics = categories.get(0);
        Category periferics = categories.get(1);
        Category food = categories.get(2);

        articles.add(new ElectronicArticle(1, "mouse", 110, electronics, 10));
        articles.add(new ElectronicArticle(2, "teclado", 120, electronics, 11));
        articles.add(new ElectronicArticle(3, "auriculares", 130, electronics, 12));
        articles.add(new ElectronicArticle(4, "parlantes", 140, electronics, 13));
        articles.add(new FoodArticle(5, "pan", 50, food, 20));

    }

    public static void createArticle(Scanner scanner, ArrayList<Article> articles, ArrayList<Category> categories) {
        int code;
        String name;
        double price;
        int warrantyMonths;
        int expDays;
        int articleType = 10;
        Category selectedCategory;
        boolean existCode = false;
        boolean validName = false;
        boolean validPrice = false;
        boolean validWarrantyMonths = false;
        boolean validExpDays = false;
        boolean validCategory = false;
        boolean validOptionTpe = false;

        do {
            validOptionTpe = false;
            System.out.println("1) Ingresar Articulo electrónico");
            System.out.println("2) Ingresar Articulo alimenticio");
            System.out.println("Seleccione un tipo de articulo:");

            if (!scanner.hasNextInt()) {
                System.out.println("Seleccione un numero valido:");
                scanner.nextLine();
                continue;
            }

            int isANumber = scanner.nextInt();

            if (isANumber < 0 || isANumber > 2) {
                System.out.println("Seleccione una opción valida:");
                scanner.nextLine();
                continue;
            }
            validOptionTpe = true;

            articleType = isANumber;
            scanner.nextLine();

        } while (!validOptionTpe);

        do {

            System.out.println("====================");
            System.out.println("Ingrese el código del articulo :");
            System.out.println("====================");

            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese un código válido:");
                scanner.nextLine();
            }
            code = scanner.nextInt();
            scanner.nextLine();
            existCode = false;

            for (Article article : articles) {
                if (article.getCode() == code) {
                    System.out.println("El código ingresado ya existe");
                    existCode = true;
                    break;
                }
            }

        } while (existCode);

        do {
            validName = false;
            System.out.println("====================");
            System.out.println("Ingrese el nombre del articulo :");
            System.out.println("====================");
            name = scanner.nextLine();
            validName = name.length() > 0;
            if (validName == false) {
                System.out.println("Ingrese un nombre valido");
                continue;
            }
        } while (!validName);

        do {
            validPrice = false;
            System.out.println("====================");
            System.out.println("Ingrese el precio del articulo :");
            System.out.println("====================");

            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese un numero válido:");
                scanner.nextLine();
            }

            price = scanner.nextDouble();
            scanner.nextLine();
            validPrice = price > 0;

            if (validPrice == false) {
                System.out.println("Ingrese un precio valido");
                break;
            }
        } while (!validPrice);

        if (articleType == 1) {
            do {
                validWarrantyMonths = false;
                System.out.println("====================");
                System.out.println("Ingrese la garantía en meses del articulo :");
                System.out.println("====================");

                while (!scanner.hasNextInt()) {
                    System.out.println("Ingrese un numero válido:");
                    scanner.nextLine();
                }

                warrantyMonths = scanner.nextInt();
                scanner.nextLine();
                validWarrantyMonths = warrantyMonths > 0;
                if (validWarrantyMonths == false) {
                    System.out.println("Ingrese una cantidad de meses valida");
                    break;
                }
            } while (!validWarrantyMonths);

            do {
                validCategory = false;
                System.out.println("Categorías disponibles:");
                for (Category category : categories) {
                    System.out.println(
                            category.getCode() + ") " + category.getName());
                }
                System.out.println("Seleccione el código de la categoría:");
                int categoryCode = scanner.nextInt();
                scanner.nextLine();
                selectedCategory = null;
                for (Category category : categories) {
                    if (category.getCode() == categoryCode) {
                        selectedCategory = category;
                        validCategory = category.getCode() == categoryCode;
                    }
                }
                if (validCategory == false) {
                    System.out.println("Categoría seleccionada invalida");
                    break;
                }

            } while (!validCategory);

            ElectronicArticle article = new ElectronicArticle(
                    code, name, price, selectedCategory, warrantyMonths);
            articles.add(article);
            System.out.println("====================");
            System.out.println("¡Articulo creado con éxito!");
            System.out.println("====================");
            System.out.println("Resumen del articulo creado: ");
            System.out.println(article.toString());
        }

        if (articleType == 2) {
            do {
                validExpDays = false;
                System.out.println("====================");
                System.out.println("Ingrese los dia para el vencimiento del articulo :");
                System.out.println("====================");
                expDays = scanner.nextInt();
                scanner.nextLine();
                validExpDays = expDays > 0;
                if (validExpDays == false) {
                    System.out.println("Ingrese una cantidad de días valida");
                    continue;
                }
            } while (!validExpDays);

            do {
                validCategory = false;
                System.out.println("Categorías disponibles:");
                for (Category category : categories) {
                    System.out.println(
                            category.getCode() + ") " + category.getName());
                }
                System.out.println("Seleccione el código de la categoría:");
                int categoryCode = scanner.nextInt();
                scanner.nextLine();
                selectedCategory = null;
                for (Category category : categories) {
                    if (category.getCode() == categoryCode) {
                        selectedCategory = category;
                        validCategory = category.getCode() == categoryCode;
                    }
                }
                if (validCategory == false) {
                    System.out.println("Categoría seleccionada invalida");
                    continue;
                }

            } while (!validCategory);

            FoodArticle article = new FoodArticle(code, name, price, selectedCategory, expDays);
            articles.add(article);
            System.out.println("====================");
            System.out.println("¡Articulo creado con éxito!");
            System.out.println("====================");
            System.out.println("Resumen del articulo creado: ");
            System.out.println(article.toString());
        }

    }

    public static void articlesList(ArrayList<Article> articles) {
        if (articles.size() == 0) {
            System.out.println("No hay artículos cargados");
        } else {
            System.out.println("====================");
            System.out.println("Lista de artículos");
            System.out.println("====================");

            for (Article article : articles) {
                System.out.println(article);
            }
        }
    }

    public static void consultArticle(Scanner scanner, ArrayList<Article> articles) {
        if (articles.isEmpty()) {
            System.out.println("No existen artículos en la lista");
            return;
        }
        System.out.println("Ingrese el código del articulo");
        int code = scanner.nextInt();

        for (Article article : articles) {
            if (article.getCode() == code) {
                System.out.println(article);
                return;
            }
        }
        System.out.println("No se encontró ningún artículo con ese código");
    }

    public static void updateArticle(Scanner scanner, ArrayList<Article> articles, ArrayList<Category> categories) {
        if (articles.isEmpty()) {
            System.out.println("La lista de artículos esta vacía");
            return;
        }
        System.out.println("Ingrese código del articulo a modificar");
        int codeArt = scanner.nextInt();
        scanner.nextLine();
        for (Article article : articles) {
            if (article.getCode() == codeArt) {
                System.out.println("Ingrese el nuevo nombre para el artículo");
                String newName = scanner.nextLine();
                System.out.println("Ingrese el nuevo precio para el artículo");
                int newPrice = scanner.nextInt();
                scanner.nextLine();

                // System.out.println("Ingrese la nueva categoría");
                // String newCategory = scanner.nextLine();

                if (article instanceof FoodArticle) {
                    System.out.println("Ingrese los días para el vencimiento");
                    int expDays = scanner.nextInt();
                    scanner.nextLine();
                    ((FoodArticle) article).setDaysForExpiration(expDays);

                } else {
                    System.out.println("Ingrese los meses de garantía");
                    int warrantyMonths = scanner.nextInt();
                    scanner.nextLine();
                    ((ElectronicArticle) article).setWarrantyMonths(warrantyMonths);

                }

                article.setName(newName);
                article.setPrice(newPrice);
                // ?????? creo nueva categoría o modifico la categoría existente ?????? go next
                // category.setName(null);(newCategory);
                System.out.println("Artículo modificado con éxito");
                return;
            }

        }
        System.out.println("No se encontró artículo con el código" + codeArt);

    }

    public static void deleteArticle(Scanner scanner, ArrayList<Article> articles) {
        if (articles.isEmpty()) {
            System.out.println("No existen artículos ");
            return;
        }
        System.out.println("Ingrese el código del producto a eliminar");
        int code = scanner.nextInt();
        scanner.nextLine();
        boolean deleted = articles.removeIf(art -> art.getCode() == code);
        if (deleted) {
            System.out.println("Articulo eliminado con éxito");
        } else {
            System.out.println("No existe el articulo con el código " + code);
        }
        return;

    }

    public static void categoryList(Scanner scanner, ArrayList<Category> categories) {
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    public static void menu(Scanner scanner, int option) {
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
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Article> articles = new ArrayList<>();
        ArrayList<Category> categories = new ArrayList<>();
        preloadCategories(categories);
        preloadArticles(articles, categories);
        int option = -1;
        do {
            menu(scanner, option);

            if (!scanner.hasNextInt()) {
                System.out.println("La opción elegida no es valida");
                scanner.next();
                continue;
            }
            option = scanner.nextInt();
            scanner.nextLine();

            if (option < 0 || option > 6) {
                System.out.println("La opción elegida no es válida");
                continue;
            }

            switch (option) {
                case 1:
                    createArticle(scanner, articles, categories);
                    break;
                case 2:
                    articlesList(articles);
                    System.out.println("");

                    break;
                case 3:
                    System.out.println("");
                    consultArticle(scanner, articles);
                    break;

                case 4:
                    System.out.println("");
                    updateArticle(scanner, articles, categories);
                    break;

                case 5:
                    System.out.println("");
                    deleteArticle(scanner, articles);
                    break;
                case 6:
                    System.out.println("");
                    categoryList(scanner, categories);
                    break;
                default:
                    break;
            }

        } while (option != 0);

    }
}