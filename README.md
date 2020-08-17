# Planner
1. Para poder visualizar las imágenes de ejemplo entrar al readme del prepositorio;

El uso de la página web Planner permitirá al usuario programar cada evento, cita, recado y tarea, para tener un mejor almacenamiento de su tiempo, así mismo el usuario podrá almacenar el nombre/entre otros campos de aquellos libros/películas/series que el usuario quisiera recordar, nuestros principales objetivos son una mejora del manejo del tiempo del usuario, así mismo como incrementar su productividad al tener sus tareas organizadas y así el usuario pueda emplear su tiempo en otras actividades recreativas o de su gusto.

## Herramientas
### Backend
	1. IDE Eclipse
	2. MySQL
	3. Java
	
###Frontend
	1. Bootstrap
	2. HTML
	3. CSS
	4. JQuery(JavaScript)

### Prerequisitos

Para el funcionamiento de nuestro programa, primero tenemos que crea la siguiente base de datos:

	CREATE TABLE planner.favorites (
		id_fav int(11) NOT NULL AUTO_INCREMENT,
		category varchar(25) NOT NULL,
		name varchar(500) NOT NULL,
		reference varchar(500) NULL,
		comment varchar(2000) NULL,
		
		CONSTRAINT `Primary` PRIMARY KEY (id_fav)
	)
	ENGINE=InnoDB
	DEFAULT CHARSET=utf8mb4
	COLLATE=utf8mb4_general_ci
	COMMENT='';

	CREATE TABLE planner.importantdates (
		id_date int(11) auto_increment NOT NULL,
		title varchar(300) NOT NULL,
		due_date date NOT NULL,
		priority varchar(10) NOT NULL,
		CONSTRAINT `PRIMARY` PRIMARY KEY (id_date)
	)
	ENGINE=InnoDB
	DEFAULT CHARSET=utf8mb4
	COLLATE=utf8mb4_general_ci
	COMMENT='';

	CREATE TABLE planner.task (
		id_task int(11) auto_increment NOT NULL,
		title varchar(300) NOT NULL,
		description varchar(500) NULL,
		due_date date NOT NULL,
		priority varchar(10)NOT NULL,
		CONSTRAINT `PRIMARY` PRIMARY KEY (id_task)
	)
	ENGINE=InnoDB
	DEFAULT CHARSET=utf8mb4
	COLLATE=utf8mb4_general_ci
	COMMENT='';

	CREATE TABLE planner.user (
		id int(11) AUTO_INCREMENT NOT NULL,
		username varchar(30) NOT NULL,
		password varchar(30) NOT NULL,
		first_name varchar(30) NOT NULL,
		last_name varchar(50) NOT NULL,
		email varchar(50) NOT NULL,
		CONSTRAINT `PRIMARY` PRIMARY KEY (id)
	)
	ENGINE=InnoDB
	DEFAULT CHARSET=utf8mb4
	COLLATE=utf8mb4_general_ci
	COMMENT='';
	
	Luego modificar en el archivo web.xml el respectivo usuario, password y nombre de la base de datos con la que fue creada (Planner)
```
Poner foto del diagrama
```

### Patrón de Arquitectura MVC
1. Modelo:
	Accede a la capa de almacenamiento de datos
	
```
Captura de modelo 
```
2. Vista:
	Interfaz gráfica que recibe los datos del modelo y los muestra al usuario,	así mismo trabaja con el controlador para poder uso del action respectivo a realizar.
```
Captura de vista
```
3. Controlador:
	Los controladores se encargarán de gestionar las reglas de los eventos que se producen en la interfaz gráfica, para esto trabajamos con servlets los cuales tendrán diversos métodos con sus respectivos request y response llamando a las funciones de cada uno de nuestros DAO's (Data Access Object) en nuestro DAO's tenemos funcionalidades como listar/eliminar/actualizar entre otros.

```
Captura de switch y ejemplo método 
```

###Funcionalidades
1. Interfaz amigable de inicio de la página, la cual mostrará algunas de nuestras características
2. Inicio de sesión, cabe resaltar que se implementó la protección de rutas para que ningún intruso pueda entrar mediante rutas, así mismo tiene la verificación de que el usuario exista en el sistema.
3. Una vez que el usuario ingrese lo primero que visualizará es el home el cual cuenta con la tarea y fecha importante más próxima del usuario, así mismo realiza un conteo estadístico de las fechas de acuerdo a su importancia, así mismo de las tareas, este recuento estadístico solo toma en cuenta a las fechas que sean secuenciales de acuerdo a la fecha actual, también podemos ver un recuento de nuestros favoritos.
4. La siguiente vista es una guía de funcionalidad para el usuario.
5. También el usuario podrá visualizar un perfil con sus datos.
6. En el view de fechas importantes, estas están ordenadas por orden de fecha, así mismo se diferencia por cada color la prioridad de una fecha.
	También no trabajamos con formato backend en la visualización de fechas, sino que utilizamos un formato más amigable para el usuario.
7. En el view también se puede manejar el view de la tabla por la prioridad que eliga el usuario, así mismo como el mes.
8. Se pueden añadir nuevas fechas, editarlas y eliminarlas.
9. En la vista de tareas separamos en dos secciones, la del lado izquierdo muestra de manera más detallada la tarea que tenga que cumplir, con su prioridad respectiva; en la sección derecha se mostrará la fecha límite que tiene el usuario para realizar esta tarea.
10. También cuenta con ordenamiento de acuerdo a prioridad,se puede editar, ingresar y eliminar tareas.
11. La vista favoritos cuenta con un CRUD, así mismo con filtros de ordenamiento por categoría y el view será en cartas desplegables.  



## Integrantes del Proyecto
1. Shyndell Cutipa Ayala
2. Alvaro Ticona Motta
