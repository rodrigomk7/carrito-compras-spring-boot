package com.rodrigo.spring.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.digitalers.spring.boot.dto.ProductoResponseDTO;
import com.digitalers.spring.boot.dto.ProductoResquestDTO;
import com.digitalers.spring.boot.utils.FileUploadUtil;
import com.rodrigo.spring.boot.entity.Producto;
import com.rodrigo.spring.boot.service.ProductoService;

@CrossOrigin(origins = { "http://127.0.0.1:5500/" })
@RestController
@RequestMapping("/productos")
public class ProductoController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private ProductoService productoService;

	@Autowired
	public ProductoController(ProductoService productoService) {
		// super();
		this.productoService = productoService;
	}

	@GetMapping()
	public ResponseEntity<?> obtenerTodos() {
		Map<String, Object> respuesta = new HashMap<>();

		try {
			log.info("Buscando todos los productos");
			List<Producto> productos = this.productoService.listarTodos();
			log.info("Productos encontrados" + productos.size());
			respuesta.put("productos", productos);
			respuesta.put("mensaje", "Los productos han sido encontrados correctamente");
			respuesta.put("status", HttpStatus.OK.value());

			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);

		} catch (Exception e) {
			log.error("Bocurrio un erroe en la app" + e.getMessage());
			respuesta.put("mensaje", "Bocurrio un erroe en la app" + e.getMessage());
			respuesta.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Uso el patron DTO para cargar desde del frond end
	// https://reactiveprogramming.io/blog/es/patrones-arquitectonicos/dto
	@PostMapping
	public ResponseEntity<?> crear(@Valid @ModelAttribute ProductoResquestDTO dto, BindingResult result,
			@RequestParam(value = "file", required = false) MultipartFile archivo) {

		Map<String, Object> respuesta = new HashMap<>();

		log.info("Insertando el producto" + dto);
		// control de los errores en los datos

		if (result.hasErrors()) {
			log.error("Hay un error con los datos qie vinieron de la solicitud");
			List<String> errorList = result.getFieldErrors().stream()
					.map(fieldError -> "Campo " + fieldError.getField() + "Invalido: " + fieldError.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errors", errorList);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}

		try {
			if (archivo != null && !archivo.isEmpty())
				dto.setNombreImagen(archivo.getOriginalFilename());

			ProductoResponseDTO e = this.productoService.insertar(dto);
			FileUploadUtil.guardarArchivo(archivo);
			respuesta.put("mensaje", "El producto se guardo correctamente");
			respuesta.put("elemento", e);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Bocurrio un erroe en la app" + e.getMessage());
			respuesta.put("mensaje", "Bocurrio un erroe en la app" + e.getMessage());
			respuesta.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// return null;
	}

}
