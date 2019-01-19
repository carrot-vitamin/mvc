package com.project.controller.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yin
 * @desc FileController
 * @date 2018/10/20 20:50
 */
@Controller
@RequestMapping(value = "/file")
public class FileController {

    @GetMapping(value = "/index")
    public String fileManage() {
        return "file/file";
    }
}
