package neilyich.codes.codescorrector

import neilyich.correction.codes.serialization.CodesModule
import neilyich.field.serialization.FieldsModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SerializationConfig {
    @Bean
    fun fieldsModule() = FieldsModule()

    @Bean
    fun codesModule() = CodesModule()
}