package com.example.demo.resources;

import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.models.Arquivo;
import com.example.demo.repository.ArquivoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class UploadResource {
	
private ArquivoRepository arquivoRepository;
	
List<String> files = new ArrayList<String>();
private final Path rootLocation = Paths.get("C:\\Users\\fred\\Documents\\pdfjava");

	public UploadResource(ArquivoRepository arquivoRepository) {
		super();
		this.arquivoRepository = arquivoRepository;
	}

	@PostMapping("/savefile")
	public ResponseEntity<byte[]>save(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {
		String message;
		Arquivo arquivo = null;
		ByteArrayOutputStream baos = null;
		Blob blob = null;
		String nome = String.valueOf(Math.random() * 1000).substring(0, 3) + ".pdf";
		try {
	         try {
	            Files.copy(file.getInputStream(), this.rootLocation.resolve(nome));
	            arquivo = new Arquivo();
	            Long conversao = file.getSize();
	            String a = String.valueOf(conversao);
	            Integer  b = Integer.parseInt(a);
	            byte[] array = new byte[b];
	            file.getInputStream().read(array);
	            baos = new ByteArrayOutputStream();
	            baos.write(array);
	            blob = new SerialBlob(baos.toByteArray());
	            arquivo.setBytes(blob.getBytes(1, baos.toByteArray().length));
	            arquivo = this.arquivoRepository.save(arquivo);
	         } catch (Exception e) {
	            throw new RuntimeException("FAIL!");
	         }
	         files.add(file.getOriginalFilename());

	         message = "Successfully uploaded!";
	         return ResponseEntity.status(HttpStatus.OK).body(arquivo.getBytes());
	      } catch (Exception e) {
	         message = "Failed to upload!";
	         return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
	      }
	}
}
