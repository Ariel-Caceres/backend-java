# Sistema de Gestión de Artículos en Java

Proyecto de consola desarrollado en Java para practicar los fundamentos del lenguaje, la programación orientada a objetos (POO) y la implementación de operaciones CRUD sobre artículos y categorías.

## Descripción

El sistema permite gestionar artículos de diferentes tipos, como productos electrónicos y alimentos. Cada artículo tiene información general y propiedades específicas según su tipo.

Los datos se almacenan temporalmente en listas (`ArrayList`) durante la ejecución del programa.

## Funcionalidades

- **Ingresar artículos:** registrar nuevos artículos con sus datos y categoría.
- **Listar artículos:** mostrar todos los artículos registrados.
- **Consultar artículos:** buscar un artículo mediante su código.
- **Modificar artículos:** actualizar información de un artículo existente.
- **Eliminar artículos:** eliminar un artículo mediante su código.
- **Listar categorías:** mostrar las categorías disponibles.
- **Validar entradas:** comprobar que los datos ingresados tengan el formato esperado.
- **Pre cargar datos:** iniciar el sistema con artículos y categorías de ejemplo.

## Tecnologías utilizadas

- Java
- Visual Studio Code
- Git y GitHub

## Conceptos de Java practicados

### 1. Programación orientada a objetos (POO)

Se utilizan clases y objetos para representar los elementos del sistema.

- **Clases:** `Article`, `ElectronicArticle`, `FoodArticle` y `Category`.
- **Objetos:** instancias que representan artículos y categorías concretas.
- **Encapsulamiento:** atributos privados y métodos para acceder o modificar sus valores.
- **Constructores:** inicialización de objetos con sus respectivos datos.
- **Métodos:** organización de las operaciones del sistema en funciones reutilizables.

### 2. Herencia y polimorfismo

La clase `Article` representa la estructura general de un artículo, mientras que `ElectronicArticle` y `FoodArticle` heredan de ella.

Cada subtipo incorpora atributos específicos:

- `ElectronicArticle`: meses de garantía.
- `FoodArticle`: días hasta el vencimiento.

El polimorfismo permite almacenar distintos tipos de artículos en una misma colección:

```java
ArrayList<Article> articles = new ArrayList<>();
```

Además, se utilizan métodos sobrescritos (`@Override`) para mostrar información específica de cada subtipo.

### 3. Clases abstractas

`Article` es una clase abstracta que define una estructura común para todos los artículos.

Contiene métodos abstractos que deben implementar sus clases hijas, como `getArticleType()` y `getSpecificDetail()`.

Esto permite establecer un contrato común sin necesidad de crear objetos directamente de la clase `Article`.

### 4. Colecciones con ArrayList

Se utilizan listas dinámicas para almacenar los artículos y las categorías.

```java
ArrayList<Article> articles = new ArrayList<>();
ArrayList<Category> categories = new ArrayList<>();
```

Entre las operaciones practicadas se encuentran:

- `add()`: agregar elementos.
- `get()`: obtener elementos por índice.
- `isEmpty()`: comprobar si una lista está vacía.
- `removeIf()`: eliminar elementos que cumplan una condición.
- Recorrer colecciones mediante `for-each`.

### 5. Control de flujo

El programa utiliza diferentes estructuras de control:

- `if` y `else`: tomar decisiones según una condición.
- `switch` y `case`: ejecutar la operación correspondiente a la opción seleccionada.
- `do-while`: mantener el menú activo hasta que el usuario elija salir.
- `for-each`: recorrer artículos y categorías.
- `break`: detener un bucle cuando se encuentra el elemento buscado.
- `continue`: saltar a la siguiente iteración de un bucle.

### 6. Entrada de datos con Scanner

Se utiliza `Scanner` para leer las entradas del usuario desde la consola.

```java
Scanner scanner = new Scanner(System.in);
```

Se practican métodos como:

- `nextInt()`: leer números enteros.
- `nextDouble()`: leer números decimales.
- `nextLine()`: leer una línea de texto.
- `hasNextInt()`: comprobar si la siguiente entrada puede interpretarse como un entero.

También se trabaja con el manejo del salto de línea pendiente al combinar `nextInt()` y `nextLine()`.

### 7. Validación de datos

Se implementan comprobaciones para evitar entradas incorrectas y mejorar el funcionamiento del sistema.

Algunos ejemplos son:

- Comprobar que el usuario ingrese números donde corresponda.
- Evitar códigos de artículo duplicados.
- Verificar si un artículo existe antes de consultarlo, modificarlo o eliminarlo.
- Controlar las opciones disponibles en el menú.

También se practica la reutilización de lógica de validación mediante métodos auxiliares.

### 8. Métodos y organización del código

El programa divide las responsabilidades en métodos independientes, como:

- `createArticle()`
- `articlesList()`
- `consultArticle()`
- `updateArticle()`
- `deleteArticle()`
- `categoryList()`
- `preloadArticles()`
- `preloadCategories()`

Esta organización facilita la lectura, el mantenimiento y la reutilización del código.

## Estructura del proyecto

```text
src/
└── com/
    └── techlab/
        └── articulo/
            ├── Main.java
            └── model/
                ├── Article.java
                ├── Category.java
                ├── ElectronicArticle.java
                └── FoodArticle.java
```

_La estructura puede variar según la organización definitiva de los paquetes del proyecto._

## Ejecución

1. Clonar el repositorio.
2. Abrir el proyecto en Visual Studio Code con el soporte para Java instalado.
3. Ejecutar la clase `Main.java`.
4. Utilizar el menú de la consola para seleccionar las operaciones disponibles.
