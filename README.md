# SharedPreferences
Implementar diferentes opciones entre las cuales un usuario puede elegir

Descripción
En este desafío construiremos una aplicación que simulará el acceso de un usuario a una
aplicación. Después de ingresar a esta aplicación, el usuario tendrá dos caminos posibles:
1. Si el usuario ingresa por primera vez, se le muestra una pantalla de bienvenida, la que
se debe mostrar sólo una vez a cada usuario. El mismo usuario no puede ver la
misma pantalla más de una vez. A menos que la aplicación sea reinstalada.
2. Si el usuario ya ha ingresado a la aplicación (es decir está retornando a la
aplicación), ha visto la bienvenida y ahora ingresa directamente a la pantalla de
preferencias de la aplicación. En esta pantalla el usuario deberá seleccionar algunas
preferencias de idioma, escribir un nick name e ingresar su edad, considerando que
todos estos datos son opcionales y deben persistir entre sesiones de la aplicación, si
el usuario decide guardarlos, esto se puede presionando el botón guardar.
No se requiere validar los datos pero es importante que los datos ingresados
correspodan a los tipos de datos a almacenar.
Esta simple aplicación nos permite simular los accesos diarios de un usuario, normalmente
una aplicación tiene un login, una bienvenida para la primera vez y preferencias que
personalizan la experiencia. Eso es justamente lo que estamos simulando con este desafío.

HINT 
El proyecto base solo fue utilizado para diagramar los layout

Ud recibirá una aplicación base con todo lo necesario para mostrar las 3 pantallas y navegar
por ellas. Las pantallas que se encuentran en este proyecto base, tienen los siguientes
elementos:
● Pantalla 1, Login: Esta pantalla nos permite ingresar un nombre y contiene un botón
para avanzar a la siguiente pantalla. Puede ver en un ejemplo en la imagen 1.
● Pantalla 2, Bienvenida: Esta pantalla es la que el usuario verá la primera vez que
ingresa, sólo una vez. Debe tener un texto donde se despliega el nombre del usuario,
un mensaje de bienvenida y un botón para avanzar a la siguiente pantalla. La imagen
3 contiene un ejemplo.
● Pantalla 3, Pantalla de preferencias: Esta es la pantalla que contiene lo que ha
seleccionado el usuario, debe persistir entre diferentes instancias de la aplicación.
Esta pantalla contiene los siguientes componentes, como se ve en la imagen 4:
○ Un textview para mostrar el nickname
○ 4 checkboxs
○ 3 con idiomas
○ 1 con la opción otro, y un input de texto que es ese otro idioma
○ Un input de texto para ingresar el nickname
○ Un input de texto para ingresar la edad
○ Un botón para guardar.

Requerimientos
Para la realización de este desafío, debes descargar el .zip que se encuentra en plataforma,
llamado Apoyo Desafío - Preferencias de un usuario donde encontrarás, el material base
para poder desarrollar los siguientes puntos:
1. Debe completar la primera pantalla, Login, para que esta pueda almacenar en un
archivo de SharedPreferences el nombre de usuario, y saber si el usuario está
volviendo, o es un nuevo usuario en la aplicación. Lo que debe completar es lo
siguiente:
a. Crear el archivo de preferencias, y lo que sea necesario para manejar ese
archivo en las distintas funciones de la actividad.
b. Completar el método hasSeenWelcome, donde se decide si el usuario está
volviendo a la aplicación, o es un nuevo usuario.
2. Completar la pantalla de Bienvenida, segunda pantalla, esta pantalla debe almacenar
que usuario la ha visto. Si el usuario llegó a esta pantalla, se debe almacenar que ya
la vio, las claves para almacenar preferencias para un usuario, deben estar
asociadas a ese usuario de alguna forma:
a. Leer el archivo de preferencias y lo que sea necesario para usarlo en esta
actividad.
b. Completar el código en el método setUpViewsAndListener, para poder
almacenar que el usuario vio la pantalla.
3. Completar el código en la tercera pantalla, la de preferencias. En esta pantalla
tenemos varios métodos que debemos completar para poder persistir los datos
entre diferentes corridas de la aplicación. Debe completar lo siguiente:
a. Crear todo el código necesario para leer y utilizar el archivo de shared
preferences en esta Actividad.
b. Completar el método handleLanguages y el método loadProfile, para cargar
los datos iniciales desde el archivo de preferencias.
c. Completar los métodos saveLanguage y saveNickNameAndAge, para
almacenar los datos en el archivo, cuando el usuario presiona el botón
guardar.
d. Funcionamiento correcto de la aplicación.

Luego de completar todos estos requerimientos, la aplicación debe persistir los datos, y ser
capaz de navegar como fue descrito en la descripción del desafío.
