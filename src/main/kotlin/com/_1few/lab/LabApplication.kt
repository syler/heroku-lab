package com._1few.lab

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class LabApplication

fun main(args: Array<String>) {
    SpringApplication.run(LabApplication::class.java, *args)
}
