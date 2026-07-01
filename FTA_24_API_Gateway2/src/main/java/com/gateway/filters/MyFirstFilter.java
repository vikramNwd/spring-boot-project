package com.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MyFirstFilter implements GlobalFilter{

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		//pre-filter : logging, authentication 
		
		//task==>Runnable, Callable
		
		Runnable r1 = () -> System.out.println("======post-filter executed=========");
		
		System.out.println("=======pre-filter executed=========");		
		return chain.filter(exchange)
				.then(Mono.fromRunnable(r1));	 //continue to next filters(route-specific filter)
	}

}