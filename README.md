# 📱 Practica02 - Diseño Responsivo App Banco Pichincha

**Autor:** Erwin Daniel Bueno Troya  
**Materia:** Desarrollo de Aplicaciones Móviles  
**Versión:** 1.0.0

---

## 📋 Descripción

Diseño responsivo del inicio de sesión de la aplicación móvil del **Banco Pichincha**, una de las entidades bancarias más importantes del Ecuador. El proyecto replica fielmente la interfaz de la app oficial, implementando un layout responsivo con `ConstraintLayout` y `ScrollView` para adaptarse a distintos tamaños de pantalla.

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java
- **IDE:** Android Studio
- **Min SDK:** API 24 (Android 7.0)
- **Target SDK:** API 34 (Android 14)
- **Librerías:**
  - `ConstraintLayout`
  - `Material Components for Android`

---

## 📁 Estructura del Proyecto

```
Practica02/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/practica02/
│           │   ├── MainActivity.java
│           │   ├── actlogopichincha.java
│           │   └── actregistro.java
│           └── res/
│               ├── drawable/
│               │   ├── logobancopichincha.png
│               │   ├── imgpincipal.png
│               │   ├── ic_usuario.png
│               │   ├── ic_fingerprint.png
│               │   ├── ic_pin.png
│               │   ├── ic_location.png
│               │   ├── ic_clave.png
│               │   └── ic_llamar.png
│               └── layout/
│                   ├── activity_main.xml
│                   ├── activity_actlogopichincha.xml
│                   └── activity_actregistro.xml
└── README.md
```

---

## 📐 Diseño Responsivo

El layout fue implementado con las siguientes técnicas de responsividad:

- ✅ `ConstraintLayout` como contenedor base
- ✅ `ScrollView` con `layout_width="0dp"` y `layout_height="0dp"` anclado a toda la pantalla
- ✅ Elementos con `layout_width="0dp"` + constraints para adaptarse al ancho disponible
- ✅ `weightSum` en `LinearLayout` para distribuir íconos equitativamente
- ✅ `adjustViewBounds="true"` en imágenes para mantener proporciones
- ✅ `layout_constraintWidth_percent` para el logo

---

## 🎨 Pantallas

### Login Banco Pichincha
Replica de la pantalla de inicio de sesión oficial con:
- Logo y versión de la app
- Imagen ilustrativa principal
- Opciones de ingreso: Usuario/Contraseña, Huella/Face ID, Pin de 6 dígitos
- Accesos rápidos: Ubicanos, Clave Digital, Llámanos
- Enlace para ingresar con otro usuario

---

## 📸 Capturas del Diseño

### Emulador Android
![Captura Emulador](capturas/Capemulador.png)

---

## 🎨 Paleta de Colores

| Color | Hex | Uso |
|-------|-----|-----|
| Amarillo Pichincha | `#FFD100` | Logo / detalles |
| Azul medio | `#1565C0` | Íconos secundarios / links |
| Gris oscuro | `#212121` | Texto principal |
| Gris suave | `#757575` | Texto versión |
| Blanco | `#FFFFFF` | Fondo |

---

## ▶️ Cómo ejecutar

1. Clona el repositorio:
```bash
git clone https://github.com/ErwinBueno/Practica02.git
```
2. Abre el proyecto en **Android Studio**
3. Conecta un emulador o dispositivo físico
4. Presiona **Run ▶️**

---

## 📄 Archivo Principal a Revisar

El layout principal de la actividad se encuentra en:

```
app/src/main/res/layout/activity_actlogopichincha.xml
```

---

## 📌 Notas

- La imagen principal (`imgpincipal.png`) fue obtenida de la app oficial del Banco Pichincha
- Los íconos fueron descargados de [Google Fonts Icons](https://fonts.google.com/icons)
- El diseño fue adaptado para mantener fidelidad visual con la app original
