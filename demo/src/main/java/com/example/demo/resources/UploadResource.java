package com.example.demo.resources;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.Arquivo;
import com.example.demo.repository.ArquivoRepository;
import com.example.demo.repository.TelefoneRepository;

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
		Arquivo arquivo = null;
		String message;
		ByteArrayOutputStream baos = null;
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
	            arquivo.setBytes(array);
	            arquivo = this.arquivoRepository.save(arquivo);
	            //reescrevendo o pdf apos ser salvo no banco
	            nome = "SAIDA_" + String.valueOf(Math.random() * 1000).substring(0, 3) + ".pdf";
	            baos = new ByteArrayOutputStream();
	            baos.write(arquivo.getBytes());
	            InputStream isFromFirstData = new ByteArrayInputStream(baos.toByteArray()); 
	            Files.copy(isFromFirstData, this.rootLocation.resolve(nome));
	            
	            byte[] contents = arquivo.getBytes();
	            Blob blob = new SerialBlob(baos.toByteArray());
	            InputStream isFromFirstData2 = new ByteArrayInputStream(blob.getBytes(1, baos.toByteArray().length)); 
	            nome = "SAIDA_" + String.valueOf(Math.random() * 1000).substring(0, 3) + ".pdf";
	            Files.copy(isFromFirstData2, this.rootLocation.resolve(nome));
	            arquivo.setBlob(blob);
	         } catch (Exception e) {
	            throw new RuntimeException("FAIL!");
	         }
	         files.add(file.getOriginalFilename());

	         message = "Successfully uploaded!";
	         return ResponseEntity.status(HttpStatus.OK).body(arquivo.getBlob().getBytes(1, baos.toByteArray().length));
	      } catch (Exception e) {
	         message = "Failed to upload!";
	         return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
	      }
	}
}
