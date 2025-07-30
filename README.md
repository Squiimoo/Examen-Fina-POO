# Sistema de Gestión de Hotel  

Este sistema permite la gestión de reservas de habitaciones, control de check-in/check-out, registro de clientes y disponibilidad de habitaciones. Está construido con Java y Swing bajo arquitectura MVC.

---

## Integrantes  
- William Loyola (Rol: Vista/Controlador)  
- Oscar Patiño (Rol: Modelo/Persistencia)  

---

## Requisitos  
- Java 11 o superior  
- IDE recomendado: Visual Studio Code o IntelliJ IDEA  
- Librerías utilizadas:  
  - **Ninguna adicional** (sólo clases estándar de Java como `javax.swing`, `java.io`, `java.time`, etc.)

---

## Instrucciones  
1. Clonar o descargar este repositorio  
2. Asegurarse de que la estructura sea:
   Reservas de Hotel/
  ├── .vscode/
  ├── bin/
  ├── data/
  │ ├── clientes.csv
  │ ├── habitaciones.csv
  │ └── reservas.csv
  ├── src/
  │ ├── controlador/
  │ ├── main/
  │ ├── modelo/
  │ │ └── interfaces/
  │ └── vista/
  └── README.md
3. Compilar desde terminal:
  `javac -d bin src/main/Main.java`
4. Ejecutar:
  `java -cp bin main.Main`

---

## Funcionalidades Clave
- Registro y listado de clientes y habitaciones
- Gestión de reservas con validación de fechas
- Check-in y check-out
- Cancelación de reservas
- Filtro de reservas por fecha y apellido
- Validaciones de campos obligatorios
- Almacenamiento persistente en archivos .csv
- Diseño MVC limpio y extensible
  
---

## Capturas
  
---

## Diagrama UML  

---


