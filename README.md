#Sistemas Orientada a Objetos
##Ingeniería en Informática

##Sistema de agencia de autos

Dado el siguiente caso de estudio realice el diagrama de clases y la implementación en java

En una agencia de autos existen 2 tipos de planes para la compra en cuotas: plan regular y plan 70/30. Para el

cálculo de la cuota, en el plan regular, el precio del auto se divide por la cantidad de cuotas. En el plan 70/30,

el valor de la cuota surge de dividir el 70% del valor del auto por la cantidad de cuotas. El 30% restante se

debe pagar en el momento en que se retira el auto.

Para ambos planes el número de cuotas puede ser de 60 u 80.

De los vehículos se conoce su valor, de cada cuota se conoce el monto, la fecha de vencimiento, si se pagó o

no, y la fecha en que se pagó. Cada cliente puede suscribir un plan para un auto (solo uno). Cada vez que el

cliente paga una cuota, el pago de las mismas se va registrando en el sistema.

El sistema a modelar e implementar debe permitir:

● Crear y agregar al sistema un plan para un cliente que quiere comprar un auto. Diseñe una estructura

adecuada para crear los diferentes tipos de planes, esto incluye crear todas las cuotas del mismo con

la fecha de vencimiento que se se calcula automáticamente cada 30 días luego de creado el plan.

● Conocer para cada cliente el plan que tiene, las cuotas pagadas (considerando los datos enunciados

anteriormente), la cantidad de cuotas que restan por pagar, y el monto total que le queda por pagar

(en el caso del plan 70/30 debe incluir en ese monto el 30%).

● Registrar el pago de las cuotas

● Implementar también los siguientes métodos:

○ Plan:

 ■ cuotasImpagas: retorna una colección de cuotas que aún no han sido pagadas.

○ Agencia:

 ■ dineroPorCobrar: retorna la cantidad total que la agencia tiene por cobrar por todos

los planes.

 ■ clienteQueMenosDebe: retorna aquel cliente que tiene la menor deuda.


## Diagrama de Clases
![Alt text](docs/DiagramaDeClases.png?raw=true "Diagrama de Clases")

---

## Integrantes

* Ezquiel Montes   https://github.com/ezetarg
* Debora Sudañez   https://github.com/dsudaez
* Jorge Riera      https://github.com/jorgex9

