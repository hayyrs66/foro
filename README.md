# ForoHub

ForoHub es una aplicación de foros diseñada para permitir a los usuarios discutir y compartir información sobre diferentes temas.

## Características

- **Crear Temas**: Permite a los usuarios crear nuevos temas de discusión.
- **Editar Temas**: Funcionalidad para editar los temas existentes.
- **Eliminar Temas**: Los usuarios pueden eliminar los temas que han creado.
- **Listar Temas**: Visualización de todos los temas disponibles en el foro.

## Tecnologías Utilizadas

- Java
- Spring Framework
- Hibernate
- PostgreSQL (o la base de datos que estés utilizando)

## Instalación y Uso

1. **Requisitos Previos**
   - Java JDK 8 o superior instalado
   - Maven
   - PostgreSQL (o la base de datos de tu elección) instalado y configurado

2. **Configuración de la Base de Datos**
   - Crea una base de datos en PostgreSQL para ForoHub.
   - Actualiza las credenciales de la base de datos en `application.properties`.

3. **Compilación y Ejecución**
   ```bash
   mvn clean install
   java -jar target/forohub-1.0.jar
```
4. **Uso**
   - Accede a la aplicación a través de `http://localhost:8080` en tu navegador web.
