
spring可以通过很多种远程调用技术支持RPC

                RPC模型有            适用场景
              远程方法调用（RMI）    不考虑网络限制时（例如防火墙），访问/发布基于Java服务
              Hessian或Burlap      考虑网络限制时，通过HTTP访问/发布基于Java的服务。Hessian是二进制协议，而Burlap是基于XML的
              HTTP invoker         考虑网络限制，并希望适用基于XML或专有的序列化机制实现时，访问/发布基于spring的服务
              JAX-RPC和JAX-WS      访问/发布平台独立的，基于SOAP的Web服务