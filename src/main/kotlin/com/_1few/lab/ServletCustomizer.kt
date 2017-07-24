package com._1few.lab

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer
import org.springframework.boot.context.embedded.MimeMappings
import org.springframework.stereotype.Component

@Component
open class ServletCustomizer : EmbeddedServletContainerCustomizer {
    /**
     * customize MIME type if you need it.
     */
    override fun customize(container: ConfigurableEmbeddedServletContainer?) {
        val mappings: MimeMappings = MimeMappings(MimeMappings.DEFAULT)
        container!!.setMimeMappings(mappings)
    }
}