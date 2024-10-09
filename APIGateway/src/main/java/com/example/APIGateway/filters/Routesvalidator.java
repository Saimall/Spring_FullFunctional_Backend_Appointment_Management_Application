package com.example.APIGateway.filters;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;



@Component
public class Routesvalidator {
	
	public static final List<String> openAPIendpoints=List.of("/authenticate/register","/authenticate/validate/user","/authenticate/validate/token");
	
	public Predicate<ServerHttpRequest> isSecured = request->openAPIendpoints.stream().noneMatch(uri->request.getURI().getPath().contains(uri));

}
