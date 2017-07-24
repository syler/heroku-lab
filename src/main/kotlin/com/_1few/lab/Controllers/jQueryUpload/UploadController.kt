package com._1few.lab.Controllers.jQueryUpload

import org.apache.tomcat.util.http.fileupload.FileUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.multipart.MultipartFile
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Paths

@Controller
@RequestMapping("/jquery-upload")
class UploadController {
    @Autowired
    private lateinit var env: Environment

    @RequestMapping("")
    fun index(model: Model): String {
        return "jquery-upload/index"
    }

    @ResponseBody
    @PostMapping("upload")
    fun upload(@RequestPart("upload-file") uploadfile: Array<MultipartFile>): UploadResult {
        if (uploadfile.count() == 0) return UploadResult(false, "the uploading file is not detected.", arrayOf())

        var dir = env.getProperty("com._1b2m.defaultuploaddir")
        dir = Paths.get("src/main/resources/static", dir).toString()
        val f: File = File(dir)
        if (f.exists()) {
            FileUtils.deleteDirectory(f)
        }

        f.mkdirs()

        for (file in uploadfile) {
            val fileName = file.originalFilename;

            val filepath: String = Paths.get(dir, fileName).toString()
            val stream: BufferedOutputStream = BufferedOutputStream(FileOutputStream(File(filepath)))
            stream.write(file.bytes)
            stream.close()
        }

        return UploadResult(true, "successfully uploaded your file(s). ", uploadfile.map { it.originalFilename }.toTypedArray())
    }
}

class UploadResult(val success: Boolean, val message: String, val files: Array<String>)
