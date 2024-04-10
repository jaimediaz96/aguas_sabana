package com.asb.aforo.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Data
public class PhotosDTO {
    private List<MultipartFile> photos;
}
