package fr.nogachi.controllers;

import fr.nogachi.services.FileService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * @author Messiaen elvis
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/file")
public class FileController {

    private final FileService service;

    public FileController(FileService fileService) {
        this.service = fileService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> createPhoto(@RequestParam MultipartFile file) {
        return Map.of("url", service.uploadFile(file));
    }
/*
    .* => regex qui defini que l'on peux avoir exemple .jpg .png .jpeg etc
 */

    @GetMapping("/{filename:.*}")
    public ResponseEntity<Resource> download(@PathVariable String filename, HttpServletRequest request) throws FileNotFoundException {
        Resource resource = service.downloadFile(filename);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            System.out.println("MineType impossible à determiner");
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).header(HttpHeaders.CONTENT_DISPOSITION, "Attachement : filename=\"" + resource.getFilename() + "\"").body(resource);
    }

}
