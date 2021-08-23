package com.example.demo.resources;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.Arquivo;
import com.example.demo.repository.ArquivoRepository;
import com.example.demo.repository.TelefoneRepository;

@RestController
@RequestMapping(value="/upload")
public class UploadResource {
	
private ArquivoRepository arquivoRepository;
	
	public UploadResource(ArquivoRepository arquivoRepository) {
		super();
		this.arquivoRepository = arquivoRepository;
	}

	@PostMapping("/")
	public ResponseEntity<Arquivo>save(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {
		Arquivo arquivo = new Arquivo();
		try {
			arquivo.setBytes(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		arquivoRepository.save(arquivo);
		return new ResponseEntity<Arquivo>(arquivo, HttpStatus.OK);
		
	}
}
