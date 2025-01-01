
# ImageViewer con MVC y MVP

---

### **Descripción**
Este proyecto es un visor de imágenes desarrollado en Java que utiliza el patrón de diseño **MVP (Model-View-Presenter)**. El visor permite al usuario navegar entre imágenes mediante el clic y arrastre del ratón, mostrando la imagen actual en tiempo real a medida que se mueve. 

La aplicación sigue principios de diseño limpio y **SOLID**, asegurando modularidad y extensibilidad.

---

### **Características**
- **Visualización de Imágenes**: Escala automáticamente las imágenes para ajustarse al tamaño del panel.
- **Navegación con el Ratón**: 
  - Arrastra la imagen hacia la izquierda para mostrar la siguiente.
  - Arrastra la imagen hacia la derecha para mostrar la anterior.
  - La imagen actual se mueve en tiempo real mientras se arrastra.
- **Diseño Modular**: Utiliza el patrón **MVP** para desacoplar lógica, interfaz y datos.

---

### **Estructura del Proyecto**
El proyecto sigue una arquitectura basada en **MVP**:

1. **Modelo (`Image`)**:
   - Administra la lista de imágenes y la lógica para obtener la imagen actual, anterior y siguiente.
   - Proporciona las rutas a los archivos de las imágenes.
   
2. **Vista (`ImageDisplay`)**:
   - Panel de visualización de imágenes que gestiona eventos del ratón (clic, arrastre).
   - Dibuja la imagen actual con lógica de escalado en tiempo real.

3. **Presentador (`Presenter`)**:
   - Actúa como intermediario entre el modelo y la vista.
   - Responde a los eventos de la vista (como el arrastre del ratón) y actualiza la imagen mostrada según sea necesario.

4. **Controlador (`ImageController`)**:
   - Actúa como intermediario entre el modelo y la vista.
   - Responde a los eventos de la vista, el click de los botones y actualiza la imagen mostrada según sea necesario, con la ayuda de comandos.

---

### **Requisitos del Sistema**
- **JDK**: Java 8 o superior.
- **Bibliotecas**: No se utilizan bibliotecas externas, solo clases estándar de Java.

---

### **Ejecución**
1. **Clonar el Repositorio**:
   ```bash
   git clone https://github.com/GabrielDT13/ImageViewer.git
   cd ImageViewer
   ```

2. **Usar Terminal o IntelliJ**:

---

### **Uso**
1. Al iniciar, se cargará la primera imagen del directorio configurado en el modelo.
2. **Navegar con el ratón**:
   - Arrastra la imagen hacia la derecha para retroceder.
   - Arrastra la imagen hacia la izquierda para avanzar.
3. Si no hay más imágenes en una dirección, la navegación no tendrá efecto.

---

### **Clases Principales**
| Clase                | Descripción                                                                 |
|----------------------|-----------------------------------------------------------------------------|
| `Main`              | Punto de entrada de la aplicación. Configura el modelo, la vista y el presentador. |
| `Image`        | Contiene la lista de imágenes y la lógica para navegar entre ellas.         |
| `ImageDisplay`  | Gestiona el dibujo de la imagen y los eventos del ratón.                   |
| `Presenter`         | Maneja la lógica de navegación y coordina la comunicación entre modelo y vista. |
| `ImageController`         | Maneja la lógica de navegación y coordina la comunicación entre modelo y vista. |

---

### **Extensiones Futuras**
- **Zoom**: Implementar zoom para ampliar o reducir las imágenes.
- **Soporte de Teclado**: Navegación usando teclas de flecha.
- **Animaciones**: Deslizamiento suave al cambiar de imagen y mostrar imagen anterior o posterior.

---

### **Autores**
- **Gabriel Dominguez Torres**: Usuario del Proyecto
- **Contacto**: gabrieldomingueztorres@gmail.com

---

### **Licencia**
Este proyecto está licenciado bajo la **MIT License**. Puedes usar, modificar y distribuir el código libremente. 

