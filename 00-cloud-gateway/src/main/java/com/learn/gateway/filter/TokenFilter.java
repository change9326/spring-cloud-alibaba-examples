package com.learn.gateway.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author yujiaqi
 * @date 2020-03-10 09:27
 * @description
 */
@Component
public class TokenFilter implements GlobalFilter {

    @Value("${server.port}")
    private String serverPort;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取参数
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (token == null || token.isEmpty()) {
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.BAD_REQUEST);
            String msg = "token not is null ";
            DataBuffer buffer = response.bufferFactory().wrap(msg.getBytes());
            return response.writeWith(Mono.just(buffer));
        }
        // 在请求头中存放serverPort serverPort(获取方式，request.getHeader("serverPort"))
        ServerHttpRequest request = exchange.getRequest().mutate().header("serverPort", serverPort).build();
        // 直接转发到真实服务
        return chain.filter(exchange.mutate().request(request).build());
    }
}

