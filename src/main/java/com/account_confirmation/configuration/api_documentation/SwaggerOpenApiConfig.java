package com.account_confirmation.configuration.api_documentation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Account confirmation service", version = "1.0.0"),
        tags = { @Tag(name = "accounts-confirmation", description = "provides interaction with account-confirmation by http-requests") }
)
public class SwaggerOpenApiConfig {
}
