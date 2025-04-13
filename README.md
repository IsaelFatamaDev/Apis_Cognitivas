# Documentación de APIs

¡Hola! Este archivo es para ayudarte a entender cómo habilitar y usar dos APIs de RapidAPI utilizando Postman. Te voy a explicar los pasos de forma sencilla para que puedas hacerlo sin complicaciones.

Las dos APIs de las que vamos a hablar son:

1. **AI Web Scraper**: Esta API te permite extraer información de una página web (URL) y generar un resumen de esa página.
2. **AI Text to Image Generator Flux Free API**: Esta API te permite generar imágenes a partir de una descripción de texto, es decir, le dices qué quieres y ella crea una imagen para ti.

## Índice

1. [Introducción](#introducción)
2. [Habilitar las APIs](#habilitar-las-apis)
    - [AI Web Scraper](#ai-web-scraper)
    - [AI Text to Image Generator Flux Free API](#ai-text-to-image-generator-flux-free-api)
3. [Cómo consumir las APIs desde Postman](#cómo-consumir-las-apis-desde-postman)
    - [AI Web Scraper](#ai-web-scraper-en-postman)
    - [AI Text to Image Generator Flux Free API](#ai-text-to-image-generator-flux-free-api-en-postman)

---

## Introducción

Este documento te va a guiar sobre cómo empezar a usar las APIs de **AI Web Scraper** y **AI Text to Image Generator Flux Free API** a través de Postman. Ambas son bastante sencillas de usar, solo necesitas obtener tu clave de API desde RapidAPI (que es como un "pasaporte" para autenticarte) y luego hacer las solicitudes de forma correcta.

---

## Habilitar las APIs

### AI Web Scraper

1. Primero, necesitas ir al siguiente enlace: [AI Web Scraper en RapidAPI](https://rapidapi.com/cahik83144/api/ai-web-scraper1/playground/apiendpoint_449c144b-9630-4a88-91c6-7aef16f32242).
2. Si no tienes cuenta en RapidAPI, tienes que registrarte, pero si ya tienes cuenta solo inicias sesión.
3. Después de ingresar, seleccionas el plan que prefieras. Te recomiendo el plan gratuito para comenzar (te deja hacer algunas solicitudes al mes).
4. Ahora, RapidAPI te dará una clave especial que se llama **X-RapidAPI-Key**. Necesitarás esta clave para hacer las solicitudes.

### AI Text to Image Generator Flux Free API

1. Ahora vamos a la siguiente API: [AI Text to Image Generator Flux Free API en RapidAPI](https://rapidapi.com/poorav925/api/ai-text-to-image-generator-flux-free-api/playground/apiendpoint_b28cd8ef-63fe-4242-98e4-908a332770d3).
2. Al igual que antes, si no tienes cuenta en RapidAPI, regístrate. Si ya tienes cuenta, solo inicias sesión.
3. Al igual que con la API anterior, selecciona el plan que más te guste. El plan gratuito también te servirá para empezar, aunque tiene algunos límites.
4. Copia la **X-RapidAPI-Key** que te dan.

---

## Cómo consumir las APIs desde Postman

Ahora que ya tienes todo listo, vamos a hacer las solicitudes desde **Postman**.

### AI Web Scraper en Postman

Para usar esta API desde Postman, sigue estos pasos:

1. Abre **Postman** (si no tienes Postman, puedes descargarlo [aquí](https://www.postman.com/)).
2. Crea una nueva solicitud de tipo **POST**.
3. En la parte superior de la pantalla, coloca la **URL** de la solicitud: <https://ai-web-scraper1.p.rapidapi.com/>

4. Luego, agrega los **encabezados** (headers). Estos son unos detalles extra que le damos a la API para que sepa cómo procesar nuestra solicitud. Los encabezados deben ser:

- **X-RapidAPI-Key**: `tu_clave_de_API_aqui` (esta es la que copiaste antes de RapidAPI).
- **Content-Type**: `application/json`

5. Después, ve a la sección de **Body** en Postman y selecciona la opción **raw**. En el campo de texto que aparece, escribe lo siguiente (esto es el cuerpo de la solicitud en formato JSON):

```json
{
  "url": "https://es.wikipedia.org/wiki/Akira_Toriyama",
  "summary": true
}
```

6. Finalmente, haz clic en Enviar. Postman enviará la solicitud y te mostrará la respuesta de la API.

### AI Text to Image Generator Flux Free API en Postman

Ahora, vamos a usar la segunda API para generar imágenes a partir de texto. Los pasos son muy similares:

1. Abre Postman y crea una nueva solicitud POST.

2. Coloca la URL de la solicitud:

```pgsql
https://ai-text-to-image-generator-flux-free-api.p.rapidapi.com/aaaaaaaaaaaaaaaaaiimagegenerator/quick.php
```

3. Agrega los mismos encabezados que antes:

X-RapidAPI-Key: tu_clave_de_API_aqui (la que copiaste de RapidAPI).

Content-Type: application/json

4. En el cuerpo de la solicitud (Body), también selecciona la opción raw y agrega el siguiente JSON:

```json
{
  "prompt": "iron man and spider man",
  "style_id": 2,
  "size": "1-1"
}
```

5. Haz clic en Enviar y espera la respuesta. ¡Ahora deberías recibir una imagen basada en la descripción que diste en formato URL!
