# api-gateway
API Gateway

API gateway is nothing more than a layer between your clients and services.
It offers serious advantages from an API management perspective.

In a Microservices architecture, request routing is one of the many use cases of API Gateway.
Another common use of API Gateway is load balancing between backend services.

One more important use case of API Gateway is Gateway Offloading. It is a common pattern to move shared
and common functionalities from the backend services to the API Gateway. An example is the validation of
authentication token, such as JWT token. Instead of validating a JWT token in each of your services,
you offload it to the API Gateway.

* Authentication - An API gateway might be used to authenticate API calls. This way, even if the client needs 
to access data from multiple services, they only need to authenticate once at the gateway. 
This rensures authentication processes are consistent across the application.

* Input Validation - API gateways can also be used to perform simple logic. In the case of input validation,
this means ensuring that the client’s request contains all the necessary information to complete 
the request — in the correct format — before it reaches the service which will ultimately retrieve the requested data.

* Metrics Collection - Since all requests are funneled through the API gateway, it’s the ideal place to collect analytics.
An API gateway can, for example, measure how many requests a user is making or how many requests are being relayed to a 
particular microservices. This also allows API gateways to be used for rate limiting: if a user is sending too many requests,
the gateway can reject them instead of passing them on to one of the services.

* Response Transformation - Often, different devices and users need access to different information. 
For example, mobile devices might need less data than desktop devices, while internal clients might 
need more information than external clients. An API gateway can be used to account for this,
effectively presenting a unique API to each client type. This is something Netflix does with its API gateway.
