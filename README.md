# TITANFITV1-MASTER - Backend

## Descripción del Proyecto

El **Backend de TitanFitV1-Master** es el corazón de la aplicación, desarrollado en Java con el framework Spring Boot. Su función principal es gestionar toda la lógica de negocio, la seguridad de la aplicación (autenticación de usuarios y control de acceso), y la interacción con la base de datos para almacenar y recuperar información.

Este componente proporciona una API RESTful robusta y escalable que sirve de puente entre la base de datos MySQL y el frontend de la aplicación. Es responsable de manejar las solicitudes de los clientes (como registro, inicio de sesión, y futuras funcionalidades de gestión de rutinas y datos de usuario) y devolver las respuestas adecuadas.

## Características Clave del Backend

* **API RESTful:** Conjunto de endpoints para interactuar con el frontend, siguiendo los principios de REST.
* **Autenticación y Autorización:** Implementación de un sistema de seguridad para manejar el registro de usuarios, el inicio de sesión y proteger las rutas de la API.
* **Gestión de Usuarios:** Lógica para crear, leer, actualizar y eliminar datos de usuario.
* **Conexión a Base de Datos:** Persistencia de datos a través de MySQL utilizando Spring Data JPA y Hibernate.
* **Validación de Datos:** Asegura la integridad de los datos recibidos del frontend antes de su procesamiento y almacenamiento.

## Tecnologías Utilizadas

* **Java 17:** Lenguaje de programación principal.
* **Spring Boot 3.5.0:** Framework para el rápido desarrollo de aplicaciones Java.
* **Spring Data JPA:** Simplifica la interacción con la base de datos.
* **Hibernate:** Implementación de JPA para la capa de ORM (Object-Relational Mapping).
* **MySQL:** Sistema de gestión de base de datos relacional.
* **Maven:** Herramienta de automatización de construcción y gestión de dependencias.
* **Spring Security:** Para la seguridad de la aplicación (autenticación y autorización).

## Configuración y Ejecución

### Requisitos Previos

Asegúrate de tener instalado lo siguiente en tu sistema:

* **JDK 17** o superior
* **Apache Maven**
* **MySQL Server**
* **Git**

### Pasos de Configuración y Ejecución

1.  **Clonar el Repositorio:**
    Abre tu terminal y clona el repositorio del proyecto:
    ```bash
    git clone [https://github.com/brandonyezid/titanfi-master.git](https://github.com/brandonyezid/titanfi-master.git)
    ```
2.  **Navegar al Directorio del Backend:**
    Cambia al directorio donde se encuentra el código del backend (asumiendo que está en la raíz del repositorio o en una subcarpeta si es un monorepo):
    ```bash
    cd titanfi-master # O cd titanfi-master/backend si tu backend está en una subcarpeta 'backend'
    ```
3.  **Configurar la Base de Datos MySQL:**
    * Crea una base de datos en tu servidor MySQL (ej., `titanfit_db`).
    * Abre el archivo `src/main/resources/application.properties` (o `application.yml`) y actualiza las propiedades de conexión a tu base de datos:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/titanfit_db?createDatabaseIfNotExist=true
        spring.datasource.username=tu_usuario_mysql
        spring.datasource.password=tu_contraseña_mysql
        spring.jpa.hibernate.ddl-auto=update # Utiliza 'create' si es la primera vez para que Hibernate cree las tablas
        spring.jpa.show-sql=true
        ```
    * Asegúrate de que el usuario MySQL tiene permisos para crear y modificar tablas en esta base de datos.
4.  **Construir y Ejecutar el Proyecto:**
    Puedes construir y ejecutar la aplicación Spring Boot usando Maven:
    ```bash
    mvn clean install # Limpia y construye el proyecto, descarga dependencias
    mvn spring-boot:run # Ejecuta la aplicación Spring Boot
    ```
    Alternativamente, puedes importar el proyecto en tu IDE (IntelliJ IDEA recomendado) y ejecutar la clase principal `TitanFitApplication` directamente.

    La aplicación se iniciará por defecto en el puerto `8080`. Podrás acceder a sus endpoints REST en `http://localhost:8080/api/...`.

## Acceso al Repositorio

Puedes encontrar el código fuente completo del proyecto en el siguiente repositorio de GitHub:
[https://github.com/brandonyezid/titanfi-master.git](https://github.com/brandonyezid/titanfi-master.git)

## Colaboradores

* **Brandon Granada**
* **Daniel Bernal**
* **Jose Daniel Restrepo**
* **Dany Muñoz**
