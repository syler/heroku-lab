package com._1few.lab

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
class TrailingSlashConfig : WebMvcConfigurerAdapter() {
    override fun addResourceHandlers(registry: ResourceHandlerRegistry?) {
        registry!!.addResourceHandler("/images/").addResourceLocations("classpath:/static/images")
    }
    override fun configurePathMatch(configurer: PathMatchConfigurer?) {
        configurer!!.isUseTrailingSlashMatch = true
    }
}