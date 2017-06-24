# felizcumple

## Requerimientos:

Se solicita una aplicacion que permita guardar los cumpleaños y telefonos de contactos. Se debe poder consultar los datos a través de un webservice.

## Funcionalidad:

1. Registrar un amigo con su fecha de nacimiento, nombre y telefono
2. Modificar fecha de nacimiento
3. Modificar telefono
4. Obtener la fecha de cumpleaños de un amigo y la edad
5. Obtener todos los cumpleaños de una fecha dada
6. Borrar un amigo

## Pegadas:

**Metodo Post a /api/cumple?nombre=[nombreAmigo]&fechaNacimiento=[dd-MMM-yyyy]&telefono[telefono]**
-ej: /api/cumple?nombre=Gigi&fechaNacimiento=31-Jul-1990&telefono=20741016

Respuesta:
- "Cumple guardado correctamente" 

Mensajes de error: 
- Si la fecha no esta en el formato correcto "Formato de fecha incorrecto"
- Si el numero de telefono contiene letras o caracteres invalidos "Numero de telefono inválido"

**Metodo Put a /api/cumple?nombre=[nombreAmigo]&fechaNacimiento=[dd-MMM-yyyy]**

- ej: /api/cumple?nombre=Gigi&fechaNacimiento=31-Jul-1990

Respuesta:

- "Cumple actualizado correctamente"

Mensajes de error: 

- Si la fecha no esta en el formato correcto "Formato de fecha incorrecto"
- Si no existe el contacto "Contacto no encontrado"

**Metodo Put a /api/cumple?nombre=[nombreAmigo]&telefono[telefono]**

- ej: /api/cumple?nombre=Gigi&telefono=20741016

Respuesta:

- "Telefono actualizado correctamente"

Mensajes de error: 

- Si el numero de telefono contiene letras o caracteres invalidos "Numero de telefono inválido"
- Si no existe el contacto "Contacto no encontrado"

**Metodo Get a /api/cumple?nombre=[nombreAmigo]**

- ej: /api/cumple?nombre=Gigi

Respuesta:

- Datos en formato json del registro

Mensajes de error: 

- Si no existe el contacto "Contacto no encontrado"

**Metodo Get a /api/cumples**

- ej: /api/cumples

Respuesta:

- Datos en formato json de todos los registros

Mensajes de error: 

- Si no hay registros "No existen cumpleaños registrados"

**Metodo Delete a /api/cumple?nombre=[nombreAmigo]**

- ej: /api/cumple?nombre=Gigi

Respuesta:

- "Cumple borrado correctamente"

Mensajes de error: 

- Si no existe el contacto "Contacto no encontrado"
 
