package com.springboot.tutorial.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.tutorial.rest.model.Product;
import com.springboot.tutorial.rest.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value="Products Rest Service",description="Products rest services")
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@ApiOperation(value="Get product service",notes="Get product by product id.")
	@ApiResponses(value= {
			@ApiResponse(code=400,message="Request is not proper, check details."),
			@ApiResponse(code=500,message="Server is unable process request.")
	})
	@RequestMapping(method=RequestMethod.GET,value="/{productId}")
	public Product getProduct(
			@ApiParam(required=true,example="1")
			@PathVariable("productId") Integer productId) {
		return productService.getProduct(productId);
	}
	
	@ApiOperation(value="Get all products service",notes="Get all products.")
	@ApiResponses(value= {
			@ApiResponse(code=500,message="Server is unable process request.")
	})
	@RequestMapping(method=RequestMethod.GET,value="/")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	
	@ApiOperation(value="Add product service",notes="Add product by providing product detail.")
	@ApiResponses(value= {
			@ApiResponse(code=500,message="Server is unable process request.")
	})
	@RequestMapping(method=RequestMethod.POST,value="/")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@ApiOperation(value="Delete product service",notes="Delete product by product id.")
	@ApiResponses(value= {
			@ApiResponse(code=500,message="Server is unable process request.")
	})
	@RequestMapping(method=RequestMethod.DELETE,value="/{productId}")
	public Boolean deleteProduct(@ApiParam(required=true,example="1")
	@PathVariable("productId") Integer productId) {
		return productService.deleteProduct(productId);
	}
	
	
}

